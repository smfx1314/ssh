<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>OA后台管理 </title>

<link rel="stylesheet" href="css/index.css" type="text/css" media="screen" />

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/tendina.min.js"></script>
<script type="text/javascript" src="js/common.js"></script>

</head>
<body>
    <!--顶部-->
    <div class="layout_top_header">
            <div style="float: left"><span style="font-size: 16px;line-height: 45px;padding-left: 20px;color: #8d8d8d">未来公司后台管理系统</h1></span></div>
            <div id="ad_setting" class="ad_setting">
                <a class="ad_setting_a" href="javascript:; ">
                    <i class="icon-user glyph-icon" style="font-size: 20px"></i>
                    <span>${username }</span>
                    <i class="icon-chevron-down glyph-icon"></i>
                </a>
                <ul class="dropdown-menu-uu" style="display: none" id="ad_setting_ul">
                    <li class="ad_setting_ul_li"> <a href="javascript:;"><i class="icon-user glyph-icon"></i> 个人中心 </a> </li>
                    <li class="ad_setting_ul_li"> <a href="javascript:;"><i class="icon-cog glyph-icon"></i> 设置 </a> </li>
                    <li class="ad_setting_ul_li"> <a href="javascript:;"><i class="icon-signout glyph-icon"></i> <span class="font-bold">退出</span> </a> </li>
                </ul>
            </div>
    </div>
    <!--顶部结束-->
    <!--菜单-->
    <div class="layout_left_menu">
        <ul id="menu">
            <!-- <li class="childUlLi">
               <a href="main.html"  target="menuFrame"><i class="glyph-icon icon-home"></i>首页</a>
                <ul>
                    <li><a href="user_add.html" target="menuFrame"><i class="glyph-icon icon-chevron-right"></i>用户添加</a></li>
                </ul>
            </li> -->
            <li class="childUlLi">
                <a target="menuFrame"> <i class="glyph-icon icon-reorder"></i>员工管理</a>
                <ul>
                    <li><a href="${pageContext.request.contextPath }/emp_findAll.action" target="menuFrame"><i class="glyph-icon icon-chevron-right"></i>显示员工列表</a></li>
                	<li><a href="${pageContext.request.contextPath }/emp_addPage.action" target="menuFrame"><i class="glyph-icon icon-chevron-right"></i>添加员工</a></li>
                	<li><a href="${pageContext.request.contextPath }/emp_listPage.action?currenPage=1" target="menuFrame"><i class="glyph-icon icon-chevron-right"></i>分页查询</a></li>
                </ul>
            </li>
            <li class="childUlLi">
                <a target="menuFrame"> <i class="glyph-icon icon-reorder"></i>部门管理</a>
                <ul>
                    <li><a href="${pageContext.request.contextPath }/dept_findAll.action" target="menuFrame"><i class="glyph-icon icon-chevron-right"></i>查看部门</a></li>
                	<li><a href="${pageContext.request.contextPath }/dept_addDeptPage.action" target="menuFrame"><i class="glyph-icon icon-chevron-right"></i>添加部门</a></li>
                	<li><a href="${pageContext.request.contextPath }/dept_listDeptPage.action?currenPage=1" target="menuFrame"><i class="glyph-icon icon-chevron-right"></i>分页查询</a></li>
                </ul>
            </li>
            <!-- <li class="childUlLi">
                <a href="#"> <i class="glyph-icon  icon-location-arrow"></i>菜单管理</a>
                <ul>
                    <li><a href="meunbox.html" target="menuFrame"><i class="glyph-icon icon-chevron-right"></i>平台菜单</a></li>
                    <li><a href="meunbox_add.html" target="menuFrame"><i class="glyph-icon icon-chevron-right"></i>运行商菜单</a></li>
                    <li><a href="#" target="menuFrame"><i class="glyph-icon icon-chevron-right"></i>服务站菜单</a></li>
                    <li><a href="#" target="menuFrame"><i class="glyph-icon icon-chevron-right"></i>商家菜单</a></li>
                </ul>
            </li> -->
        </ul>
    </div>
    <!--菜单-->
    <div id="layout_right_content" class="layout_right_content">
        <div class="mian_content">
             <div id="page_content">
                <iframe name="menuFrame" src="jsp/welcome.jsp" style="overflow:visible;"
                        scrolling="yes" frameborder="no" width="100%" height="100%">
				
				</iframe> 
            </div> 
        </div>
    </div>
    <div class="layout_footer">
        <p>Copyright © 2014 - XXXX科技</p>
    </div>
</body>
</html>