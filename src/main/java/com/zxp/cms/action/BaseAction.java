package com.zxp.cms.action;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.zxp.cms.service.ArticleService;
import com.zxp.cms.service.FolderService;
import com.zxp.cms.service.HeadlineService;
import com.zxp.cms.service.TemplateService;

public class BaseAction {

	@Autowired
	protected FolderService folderService;

	@Autowired
	protected ArticleService fileService;

	@Autowired
	protected TemplateService themeService;

	@Autowired
	protected HeadlineService headlineService;

	protected final Logger logger = Logger.getLogger(this.getClass());
}
