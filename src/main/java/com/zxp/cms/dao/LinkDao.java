package com.zxp.cms.dao;

import com.zxp.cms.entity.Link;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LinkDao {
    List<Link> list();

    Link get(Integer id);
}
