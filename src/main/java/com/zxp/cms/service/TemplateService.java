package com.zxp.cms.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.zxp.cms.constant.ConfigConstant;
import com.zxp.cms.constant.SystemConstant;
import com.zxp.cms.entity.Folder;
import com.zxp.cms.exception.TemplateNotFoundException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.zxp.cms.entity.vo.FolderVo;
import com.zxp.cms.exception.FolderNotFoundException;

@Service
public class TemplateService {

	private static String FOLDER_TEMPLATE_PREFIX = "folder";
	private static String FILE_TEMPLATE_PREFIX = "article";

	protected final Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private ConfigService configService;

	@Autowired
	private FolderService folderService;

	/**
	 * @return
	 */
	public String get404() {
		return this.getTemplatePath("404");
	}

	/**
	 * @return
	 */
	public String get500() {
		return this.getTemplatePath("500");
	}

	/**
	 * 得到首页（默认页）模板
	 * 
	 * @return
	 * @throws TemplateNotFoundException
	 */
	public String getDefaultTemplate() throws TemplateNotFoundException {
		List<String> themeOrderList = new ArrayList<String>();
		themeOrderList.add("index");
		themeOrderList.add(FOLDER_TEMPLATE_PREFIX);
		themeOrderList.add(FILE_TEMPLATE_PREFIX);
		for (String theme : themeOrderList) {
			if (this.isExist(theme)) {
				return this.getTemplatePath(theme);
			}
		}
		throw new TemplateNotFoundException("模板文件：index 不存在！！");
	}

	/**
	 * 得到文件夹模板
	 * 
	 * @param folderId
	 * @return
	 * @throws TemplateNotFoundException
	 * @throws FolderNotFoundException
	 */
	public String getFolderTemplate(long folderId)
			throws TemplateNotFoundException, FolderNotFoundException {
		List<FolderVo> folderPathList = folderService
				.getFolderPathListByFolderId(folderId);
		List<String> themeOrderList = new ArrayList<String>();
		themeOrderList.add(FOLDER_TEMPLATE_PREFIX);
		String themeString = FOLDER_TEMPLATE_PREFIX;
		for (Folder folder : folderPathList) {
			themeString = themeString + "-" + folder.getEname();
			themeOrderList.add(themeString);
		}
		// 模板顺序反转
		Collections.reverse(themeOrderList);
		for (String theme : themeOrderList) {
			if (this.isExist(theme)) {
				return this.getTemplatePath(theme);
			}
		}
		throw new TemplateNotFoundException("模板文件："
				+ this.getTemplatePath(FOLDER_TEMPLATE_PREFIX) + ".ftl"
				+ " 不存在！！");
	}

	/**
	 * 得到文件模板
	 * 
	 * @param folderPathList
	 * @param articleId
	 * @return
	 * @throws TemplateNotFoundException
	 * @throws FolderNotFoundException
	 */
	public String getArticleTemplate(long folderId, long articleId)
			throws TemplateNotFoundException, FolderNotFoundException {
		List<FolderVo> folderPathList = folderService
				.getFolderPathListByFolderId(folderId);
		List<String> themeOrderList = new ArrayList<String>();
		themeOrderList.add(FILE_TEMPLATE_PREFIX);
		String themeString = FILE_TEMPLATE_PREFIX;
		for (Folder folder : folderPathList) {
			themeString = themeString + "-" + folder.getEname();
			themeOrderList.add(themeString);
		}
		themeOrderList.add(themeString + "-" + articleId);
		// 模板顺序反转
		Collections.reverse(themeOrderList);
		for (String theme : themeOrderList) {
			if (this.isExist(theme)) {
				return this.getTemplatePath(theme);
			}
		}
		throw new TemplateNotFoundException("模板文件："
				+ this.getTemplatePath(FILE_TEMPLATE_PREFIX) + " 不存在！！");
	}

	/**
	 * 得到当前请求需要渲染的模板相对路径
	 * 
	 * @param theme
	 * @return
	 */
	private String getTemplatePath(String template) {
		return "/template/"
				+ configService.getStringByKey(ConfigConstant.DEFAULT_TEMPLATE)
				+ "/" + template;
	}

	/**
	 * 模板物理地址是否存在
	 * 
	 * @param theme
	 * @return
	 */
	@Cacheable("default")
	public Boolean isExist(String theme) {
		String themePath = "/WEB-INF/static/template/"
				+ configService.getStringByKey(ConfigConstant.DEFAULT_TEMPLATE)
				+ "/" + theme + ".ftl";
		File file = new File(SystemConstant.CMS_ROOT + themePath);
		if (file.exists()) {
			logger.info("尝试使用模板：" + themePath+"【存在】");
			return true;
		} else {
			logger.info("尝试使用模板：" + themePath+"【不存在】");
			return false;
		}
	}

	// ///////////////////////////////
	// ///// 查詢 ////////
	// ///////////////////////////////
}
