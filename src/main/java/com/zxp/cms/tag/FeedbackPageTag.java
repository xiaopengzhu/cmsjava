
package com.zxp.cms.tag;

import static freemarker.template.ObjectWrapper.BEANS_WRAPPER;

import java.io.IOException;
import java.util.Map;

import com.zxp.cms.constant.GuestbookConstant;
import com.zxp.cms.entity.vo.PageVo;
import com.zxp.cms.plugin.TagPlugin;
import com.zxp.cms.service.GuestbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zxp.cms.entity.vo.GuestbookVo;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

@Service
public class FeedbackPageTag extends TagPlugin {

	@Autowired
	private GuestbookService messageBoardService;

	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		// 获取页面的参数
		Integer p = Integer.parseInt(params.get("p").toString());
		PageVo<GuestbookVo> pageVo = messageBoardService.getMessageBoardPage(p,
				GuestbookConstant.status.display, "number");
		env.setVariable("tag_feedback_page", BEANS_WRAPPER.wrap(pageVo));

		body.render(env.getOut());
	}
}
