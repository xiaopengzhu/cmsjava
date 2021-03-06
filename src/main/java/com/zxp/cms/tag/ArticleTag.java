
package com.zxp.cms.tag;

import static freemarker.template.ObjectWrapper.BEANS_WRAPPER;

import java.io.IOException;
import java.util.Map;

import com.zxp.cms.entity.Article;
import com.zxp.cms.exception.ArticleNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zxp.cms.plugin.TagPlugin;
import com.zxp.cms.service.ArticleService;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

@Service
public class ArticleTag extends TagPlugin {

	@Autowired
	private ArticleService articleService;

	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		// 获取页面的参数
		Integer articleId = Integer
				.parseInt(params.get("articleId").toString());
		// 获取指定的文件
		try {
			Article article = articleService.getArticleById(articleId);
			env.setVariable("tag_article", BEANS_WRAPPER.wrap(article));
		} catch (ArticleNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		body.render(env.getOut());
	}
}
