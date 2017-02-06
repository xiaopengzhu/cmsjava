package com.zxp.cms.service;

import java.util.Date;
import java.util.List;

import com.zxp.cms.entity.vo.AdminFolderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import com.zxp.cms.dao.AdminFolderDao;
import com.zxp.cms.entity.AdminFolder;

@Service
public class AdminFolderService {

	@Autowired
	private AdminFolderDao adminFolderDao;

	@Autowired
	private FolderService folderService;

	@CacheEvict(value = "folder", allEntries = true)
	public AdminFolder addAdminFolder(long adminId, long folderId) {
		AdminFolder adminFolder = new AdminFolder();
		adminFolder.setAdminId(adminId);
		adminFolder.setFolderId(folderId);
		adminFolder.setCreateTime(new Date());
		adminFolderDao.addAdminFolder(adminFolder);
		return adminFolder;
	}

	@CacheEvict(value = "folder", allEntries = true)
	public int deleteAdminFolder(long adminId, long folderId) {
		return adminFolderDao.deleteAdminFolder(adminId, folderId);
	}

	public List<AdminFolderVo> getAdminFolderListById(long adminId) {
		List<AdminFolderVo> list = adminFolderDao
				.getAdminFolderListById(adminId);
		return list;
	}

	public AdminFolderVo getAdminFolderById(long adminId, long folderId) {
		return adminFolderDao.getAdminFolderById(adminId, folderId);
	}
}
