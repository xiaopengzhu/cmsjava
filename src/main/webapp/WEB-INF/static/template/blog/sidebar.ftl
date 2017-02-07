<div class="col-sm-3 col-sm-offset-1 blog-sidebar">
	<div class="sidebar-module sidebar-module-inset">
		<h4><a href="<@xpcms_folder_url_tag folderId=1/>">博客目录</a></h4>
		<ol class="list-unstyled">
			<@xpcms_folder_list_tag folderId= 1>
					<#list tag_folder_list as tag_folder>
			<li><a href="<@xpcms_folder_url_tag folderId=tag_folder.folderId/>">${tag_folder.name}</a><li>
			</#list>
					</@xpcms_folder_list_tag>
		</ol>
	</div>
	<div class="sidebar-module sidebar-module-inset">
		<h4>功能</h4>
		<ol class="list-unstyled">
			<li><a href="${BASE_PATH}/admin/login.htm">登录</a><li>
		</ol>
	</div>
</div>