package com.zxp.cms.tag;

import static freemarker.template.ObjectWrapper.DEFAULT_WRAPPER;

import java.io.IOException;
import java.util.Map;

import com.zxp.cms.constant.MediaConstant;
import com.zxp.cms.entity.vo.PageVo;
import com.zxp.cms.plugin.TagPlugin;
import com.zxp.cms.service.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zxp.cms.entity.Media;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

@Service
public class MediaFolderPhotoPageTag extends TagPlugin {

	@Autowired
	private MediaService attachmentService;

	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {

		// 获取页面的参数
		Integer kindId = Integer.parseInt(params.get("kindId").toString());
		Integer pageNum = Integer.parseInt(params.get("p").toString());
		Integer rows = Integer.parseInt(params.get("rows").toString());
		// 获得目录列表
		PageVo<Media> pageVo = attachmentService.getMediaPageByKindAndType(
				kindId, MediaConstant.Kind.folder, MediaConstant.Type.photo,
				rows, pageNum);
		env.setVariable("tag_attachment_page", DEFAULT_WRAPPER.wrap(pageVo));
		body.render(env.getOut());
	}

}
