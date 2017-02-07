package com.zxp.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zxp.cms.constant.MediaConstant;
import com.zxp.cms.constant.MediaConstant.Kind;
import com.zxp.cms.constant.MediaConstant.Type;
import com.zxp.cms.entity.Media;

@Repository
public interface MediaDao {

	// ///////////////////////////////
	// ///// 增加 ////////
	// ///////////////////////////////

	/**
	 * @param att
	 * @return
	 */
	int addMedia(Media att);

	// ///////////////////////////////
	// ///// 删除 ////////
	// ///////////////////////////////

	/**
	 * @param mediaId
	 * @return
	 */
	int deleteMedia(@Param("mediaId") long mediaId);

	// ///////////////////////////////
	// ///// 修改////////
	// ///////////////////////////////

	int updateLinkByMediaId(@Param("mediaId") long mediaId,
			@Param("link") String link);

	int updateNameByMediaId(@Param("mediaId") long mediaId,
			@Param("name") String name);

	// ///////////////////////////////
	// ///// 查询////////
	// ///////////////////////////////

	/**
	 * @param mediaId
	 * @return
	 */
	Media getMediaById(@Param("mediaId") long mediaId);

	/**
	 * @return
	 */
	int getMediaCountByKindId(@Param("kindId") long kindId,
			@Param("kind") MediaConstant.Kind kind);

	/**
	 * @param offset
	 * @param rows
	 * @return
	 */
	List<Media> getMediaListByKindId(@Param("kindId") long kindId,
			@Param("kind") MediaConstant.Kind kind,
			@Param("offset") int offset, @Param("rows") int rows);

	/**
	 * @param kindId
	 * @param kind
	 * @param type
	 * @return
	 */
	int getMediaCountByKindAndType(@Param("kindId") long kindId,
			@Param("kind") Kind kind, @Param("type") Type type);

	/**
	 * @param kindId
	 * @param kind
	 * @param type
	 * @param offset
	 * @param rows
	 * @return
	 */
	List<Media> getMediaListByKindAndType(@Param("kindId") long kindId,
			@Param("kind") Kind kind, @Param("type") Type type,
			@Param("offset") int offset, @Param("rows") int rows);

}
