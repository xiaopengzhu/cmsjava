package com.zxp.cms.tag;

import static freemarker.template.ObjectWrapper.BEANS_WRAPPER;

import java.io.IOException;
import java.util.Map;

import com.zxp.cms.entity.vo.PageVo;
import com.zxp.cms.plugin.TagPlugin;
import com.zxp.cms.service.ArticleService;
import com.zxp.cms.service.FolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zxp.cms.entity.vo.ArticleVo;
import com.zxp.cms.exception.FolderNotFoundException;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

@Service
public class ArticlePageTag extends TagPlugin {

	@Autowired
	private ArticleService articleService;

	@Autowired
	private FolderService folderService;

	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		// 获取页面的参数
		Integer folderId = Integer.parseInt(params.get("folderId").toString());
		Integer p = Integer.parseInt(params.get("p").toString());
		Integer rows = Integer.parseInt(params.get("rows").toString());
		// 获取文件的分页
		try {
			PageVo<ArticleVo> pageVo = articleService.getArticlePageByFolderId(
					folderId, p, rows);
			env.setVariable("tag_article_page", BEANS_WRAPPER.wrap(pageVo));
		} catch (FolderNotFoundException e) {
			env.setVariable("tag_article_page", BEANS_WRAPPER.wrap(null));
		}

		body.render(env.getOut());
	}

}
