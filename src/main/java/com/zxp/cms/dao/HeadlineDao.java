package com.zxp.cms.dao;

import java.util.List;

import com.zxp.cms.entity.vo.HeadlineVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zxp.cms.entity.Headline;

@Repository
public interface HeadlineDao {

	int addHeadline(Headline headline);

	List<HeadlineVo> getHeadlineList();

	HeadlineVo getHeadlineById(@Param("headlineId") long headlineId);

	int deleteHeadline(@Param("headlineId") long headlineId);

	int updateHeadlineById(@Param("headlineId") long headlineId,
			@Param("name") String name, @Param("picture") String picture,
			@Param("url") String url);

	void updateSortById(@Param("headlineId") long headlineId,
			@Param("sort") int sort);

}
