
package com.zxp.cms.dao;

import java.util.List;

import com.zxp.cms.constant.ArticleConstant;
import com.zxp.cms.entity.Article;
import com.zxp.cms.entity.vo.ArticleVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 文件服务
 * 
 * @author Harbored
 * 
 */
@Repository
public interface ArticleDao {

	// ///////////////////////////////
	// ///// 增加 ////////
	// ///////////////////////////////

	/**
	 * 增加文件
	 * 
	 * @return Integer
	 */
	int addArticle(Article article);

	// ///////////////////////////////
	// ///// 刪除 ////////
	// ///////////////////////////////

	/**
	 * 删除文件
	 * 
	 * @return boolean
	 */
	boolean deleteArticleById(@Param("articleId") long articleId);

	// ///////////////////////////////
	// ///// 修改 ////////
	// ///////////////////////////////

	/**
	 * 修改文件
	 * 
	 * @param article
	 * @return Integer
	 */
	int updateArticle(Article article);

	/**
	 * 更新浏览人数
	 * 
	 * @param articleId
	 * @param viewCount
	 * @return int
	 */
	int updateViewCount(@Param("articleId") long articleId,
			@Param("viewCount") int viewCount);

	/**
	 * 更新评论数
	 * 
	 * @param articleId
	 * @param commentCount
	 * @return int
	 */

	int updateCommentCount(@Param("articleId") long articleId,
			@Param("commentCount") int commentCount);

	int updateCheck(@Param("articleId") long articleId,
			@Param("check") ArticleConstant.check check);

	// ///////////////////////////////
	// ///// 查詢 ////////
	// ///////////////////////////////

	/**
	 * 得到文件
	 * 
	 * @param articleId
	 * @return File
	 */
	ArticleVo getArticleById(@Param("articleId") long articleId);

	/**
	 * 得到目录的文件的列表
	 * 
	 * @return List<FileVo>
	 */
	List<ArticleVo> getArticleListOfDisplayByPath(
			@Param("path") String path, @Param("offset") long offset,
			@Param("rows") long rows);

	/**
	 * 得到目录的所有文件的数量
	 * 
	 * @return Integer
	 */
	int getArticleCountOfDisplayByPath(@Param("path") String path);

	/**
	 * 得到某种显示的文件的列表
	 *
	 * @return List<FileVo>
	 */
	List<ArticleVo> getArticleListByAdminIdAndPath(
			@Param("adminId") long adminId, @Param("path") String path,
			@Param("check") ArticleConstant.check check,
			@Param("offset") long offset, @Param("rows") long rows);

	/**
	 *
	 * @param adminId
	 * @param path
	 * @param check
	 * @return
	 */
	int getArticleCountByAdminIdAndPath(@Param("adminId") long adminId,
			@Param("path") String path,
			@Param("check") ArticleConstant.check check);

	/**
	 *
	 * @param folderId
	 * @return
	 */
	int getArticleCountByFolderId(@Param("folderId") long folderId);

}
