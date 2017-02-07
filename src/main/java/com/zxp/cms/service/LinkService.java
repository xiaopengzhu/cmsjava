package com.zxp.cms.service;

import com.zxp.cms.dao.LinkDao;
import com.zxp.cms.entity.Link;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 10000638 on 2017/2/7.
 */
@Service
public class LinkService {

    private LinkDao linkDao;

    public List<Link> list() {
        return linkDao.list();
    }
}
