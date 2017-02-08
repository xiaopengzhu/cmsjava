package com.zxp.cms.action;

import com.zxp.cms.entity.Link;
import com.zxp.cms.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 链接控制器
 */
@Controller
@RequestMapping("/link")
public class LinkAction {

    @Autowired
    LinkService linkService;

    /**
     * 拉取链接列表
     * @return
     */
    @RequestMapping(value = "/list.htm", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<List<Link>> list() {
        List<Link> links = linkService.findAll();
        if(links.isEmpty()){
            return new ResponseEntity<List<Link>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Link>>(links, HttpStatus.OK);
    }
}
