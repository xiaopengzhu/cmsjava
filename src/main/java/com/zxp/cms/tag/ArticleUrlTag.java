
package com.zxp.cms.tag;

import java.io.IOException;
import java.util.Map;

import com.zxp.cms.util.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zxp.cms.plugin.TagPlugin;
import com.zxp.cms.service.FolderService;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

@Service
public class ArticleUrlTag extends TagPlugin {
	@Autowired
	private FolderService folderService;

	public void execute(Environment env, Map params,
			TemplateModel[] loopVars, TemplateDirectiveBody body)
			throws TemplateException, IOException {
		String artcleId = params.get("articleId").toString();
		String basePath = HttpUtils.getBasePath(request);
		env.getOut().write(basePath + "/article/" + artcleId + ".htm");
	}

}
