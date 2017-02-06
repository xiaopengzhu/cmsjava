/*
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	长沙市师说网络科技有限公司 版权所有
 *	http://www.shishuo.com
 */

package com.zxp.cms.action.manage;

import javax.servlet.http.HttpServletRequest;

import com.zxp.cms.constant.SystemConstant;
import com.zxp.cms.entity.vo.AdminVo;
import com.zxp.cms.entity.vo.JsonVo;
import com.zxp.cms.exception.ValidateException;
import com.zxp.cms.service.AdminFolderService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.zxp.cms.service.AdminService;
import com.zxp.cms.service.ArticleService;
import com.zxp.cms.service.ConfigService;
import com.zxp.cms.service.FolderService;
import com.zxp.cms.service.HeadlineService;
import com.zxp.cms.service.MediaService;

/**
 * @author 所有action的父类
 * 
 */
@Controller
public class ManageBaseAction {

	protected final Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	protected ConfigService configService;

	@Autowired
	protected FolderService folderService;

	@Autowired
	protected ArticleService articleService;

	@Autowired
	protected MediaService attachmentService;

	@Autowired
	protected AdminService adminService;

	@Autowired
	protected HeadlineService headlineService;

	@Autowired
	protected AdminFolderService adminFolderService;

	/**
	 * 参数校验
	 * 
	 * @param json
	 *            json数据Bean
	 * @throws ValidateException
	 */
	protected <T> void validate(JsonVo<T> json) throws ValidateException {
		if (json.getErrors().size() > 0) {
			json.setResult(false);
			throw new ValidateException("有错误发生");
		} else {
			json.setResult(true);
		}
	}

	/**
	 * 从session中获得管理员的信息
	 * 
	 * @param request
	 * @return
	 */
	protected AdminVo getAdmin(HttpServletRequest request) {
		AdminVo admin = (AdminVo) request.getSession().getAttribute(
				SystemConstant.SESSION_ADMIN);
		return admin;
	}
}
