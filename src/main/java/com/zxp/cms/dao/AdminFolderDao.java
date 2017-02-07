package com.zxp.cms.dao;

import java.util.List;

import com.zxp.cms.entity.AdminFolder;
import com.zxp.cms.entity.vo.AdminFolderVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminFolderDao {

	int addAdminFolder(AdminFolder adminFolder);

	int deleteAdminFolder(@Param("adminId") long adminId,
			@Param("folderId") long folderId);

	List<AdminFolderVo> getAdminFolderListById(
			@Param("adminId") long adminId);

	AdminFolderVo getAdminFolderById(@Param("adminId") long adminId,
			@Param("folderId") long folderId);
}
