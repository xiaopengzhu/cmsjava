package com.zxp.cms.action;

import com.zxp.cms.entity.Link;
import com.zxp.cms.service.LinkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 链接控制器
 */
@Controller
@RequestMapping("/link")
public class LinkAction extends BaseAction {

    LinkService linkService;

    /**
     * 拉取链接列表
     * @return
     */
    @RequestMapping(value = "/list.htm", method = RequestMethod.GET)

    public ResponseEntity<List<Link>> listAllUsers() {
        List<Link> users = linkService.list();
        if(users.isEmpty()){
            return new ResponseEntity<List<Link>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Link>>(users, HttpStatus.OK);
    }

}
