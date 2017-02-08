package com.zxp.cms.action;

import com.zxp.cms.entity.Link;
import com.zxp.cms.service.LinkService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * 链接控制器
 */
@Controller
@RequestMapping("/link")
public class LinkAction extends BaseAction {

    @Autowired
    LinkService linkService;

    /**
     * 列表
     * @return
     */
    @RequestMapping(value = "/list.htm", method = RequestMethod.GET)
    public @ResponseBody String list() {
        return "test";
    }

    /**
     * 查
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}.htm", method = RequestMethod.GET)
    public @ResponseBody Link get(@PathVariable int id) {
        Link link = linkService.getById(id);
        logger.info("参数：" + link);
        return link;
    }
}
