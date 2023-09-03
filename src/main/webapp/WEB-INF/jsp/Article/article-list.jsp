<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid"%>

<rapid:override name="frame-content">
	<blockquote class="layui-elem-quote">
		<span class="layui-breadcrumb" lay-separator="/"> <a
			href="/admin">首页</a> <a><cite>文章列表</cite></a>
		</span>
	</blockquote>

	<div class="layui-tab layui-tab-card">
		<form id="articleForm" method="post">
			<input type="hidden" name="currentUrl" id="currentUrl" value="">
			<table class="layui-table">
				<colgroup>
					<col width="300">
					<col width="150">
					<col width="100">
					<col width="150">
					<col width="100">
					<col width="50">
				</colgroup>
				<thead>
					<tr>
						<th>标题</th>
						<th>所属分类</th>
						<th>状态</th>
						<th>发布时间</th>
						<th>操作</th>
						<th>id</th>
					</tr>
				</thead>
				<tbody>
                	<c:forEach var="a" items="${pageInfo.list}">
					<tr>
						<td>
							<a href="/article/${a.articleId}" target="_blank"> ${a.articleTitle}</a>						
						</td>
						
						<td>
							<c:forEach items="${a.categoryList}" var="c">
                                <a href="/category/${c.categoryId}" target="_blank">${c.categoryName}</a> &nbsp;
                            </c:forEach>
						</td>
						
						<td>
                            <c:if test="${a.articleStatus == 1}">
                                 <span style="color:#5FB878">已发布</span>
                            </c:if>
                            <c:if test="${a.articleStatus == 0}">
                                <span style="color:#FF5722">草稿</span>
                            </c:if> 
						</td>

						<td> <fmt:formatDate value="${a.articleCreateTime}"   pattern="yyyy-MM-dd HH:mm:ss"/></td>    
						              
						<td>
							<a href="article/edit/${a.articleId }" class="layui-btn layui-btn-mini">编辑</a>
						    <a href="article/delete/${a.articleId }"  onclick="return confirm('确定要删除吗')" class="layui-btn layui-btn-danger layui-btn-mini" >删除</a>
						</td>
							
						<td>${a.articleId}</td>
					</tr>
					</c:forEach>

				</tbody>
			</table>
		</form>

		 <%@ include file="../paging.jsp" %>
	</div>
</rapid:override>

<%@ include file="../framework.jsp"%>