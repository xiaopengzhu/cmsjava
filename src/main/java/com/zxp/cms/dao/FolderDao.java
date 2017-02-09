
package com.zxp.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zxp.cms.constant.FolderConstant;
import com.zxp.cms.constant.FolderConstant.status;
import com.zxp.cms.entity.Folder;
import com.zxp.cms.entity.vo.FolderVo;

@Repository
public interface FolderDao {

	// ///////////////////////////////
	// ///// 增加 ////////
	// ///////////////////////////////
	/**
	 * 增加目录
	 * 
	 * @return Integer
	 */
	int addFolder(Folder folder);

	// ///////////////////////////////
	// ///// 刪除 ////////
	// ///////////////////////////////
	/**
	 * 删除目录
	 * 
	 * @param folder
	 * @return boolean
	 */
	boolean deleteFolder(@Param("folderId") long folderId);

	// ///////////////////////////////
	// ///// 修改 ////////
	// ///////////////////////////////

	/**
	 * @param folderId
	 * @param name
	 * @param ename
	 * @param content
	 * @param status
	 */
	void updateFolderById(@Param("folderId") long folderId,
			@Param("name") String name, @Param("ename") String ename,
			@Param("status") FolderConstant.status status,
			@Param("content") String content, @Param("height") int height,
			@Param("width") int width);

	int updateSort(@Param("folderId") long folderId,
			@Param("sort") int sort);

	int updateCount(@Param("folderId") long folderId,
			@Param("count") int count);

	// ///////////////////////////////
	// ///// 查询 ////////
	// ///////////////////////////////
	/**
	 * 得到目录
	 * 
	 * @param folderId
	 * @return Folder
	 */
	FolderVo getFolderById(@Param("folderId") long folderId);

	/**
	 * 得到所有子目录
	 * 
	 * @param fatherId
	 * @return List<FolderVo>
	 */
	List<FolderVo> getFolderListByFatherId(
			@Param("fatherId") long fatherId,
			@Param("status") FolderConstant.status status);

	/**
	 * 通过ename和fatherId获得指定目录
	 * 
	 * @param ename
	 * @param fatherId
	 * @return
	 */
	Folder getFolderByEname(@Param("ename") String ename);

	/**
	 * @param folderId
	 * @param status
	 */
	void updateStatus(@Param("folderId") long folderId,
			@Param("status") status status);

	int updatePath(@Param("folderId") long folderId,
			@Param("path") String path);

	List<FolderVo> getAllFolderList();

}
