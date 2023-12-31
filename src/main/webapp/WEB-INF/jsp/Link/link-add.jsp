<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid"%>

<rapid:override name="frame-content">
	<blockquote class="layui-elem-quote">
		<span class="layui-breadcrumb" lay-separator="/"> <a
			href="/admin">首页</a> <a href="/admin/link">链接列表</a> <a><cite>添加链接</cite></a>
		</span>
	</blockquote>
	<div class="layui-row">
		<div class="layui-col-md4">
			<form  action="link/add"  method="post"  class="layui-form"  id="myForm" >
			
				<div class="layui-form-item">
					<div class="layui-input-block">
						<strong>编辑链接</strong>
					</div>

					<div class="layui-input-block">
						名称 <span style="color: #FF5722;">*</span>
						 <input type="text" name="linkName" value="" autocomplete="off" class="layui-input"	required>
					</div>
					<br>
					<div class="layui-input-block">
						URL <span style="color: #FF5722;">*</span> 
						<input type="text"	name="linkUrl" autocomplete="off" class="layui-input" required>
					</div>
					<br>
					<div class="layui-input-block">
						联系方式 <input type="text" name="linkOwnerContact"  autocomplete="off" class="layui-input">
						
					</div>
					<br>
					<div class="layui-input-block">
						描述 <input type="text" name="linkDescription"  autocomplete="off" class="layui-input">
					</div>

					<br>
					<div class="layui-input-block">
						Order <input type="number" name="linkOrder" autocomplete="off" class="layui-input" min="0" max="10">
					</div>
					<br>
					<div class="layui-input-block">
						<button class="layui-btn" lay-filter="formDemo" type="submit">添加</button>
					</div>
				</div>
			</form>
			<blockquote class="layui-elem-quote layui-quote-nm">
				温馨提示：
				<ul>
					<li>URL：如 http://www.sina.com</li>
					<li>Order：默认是0，Order越大排名越靠前</li>
				</ul>
			</blockquote>
		</div>
		<div class="layui-col-md8">
			<table class="layui-table">
				<colgroup>
					<col width="50">
					<col width="300">
					<col width="100">
					<col width="50">
					<col width="100">
				</colgroup>
				<thead>
					<tr>
						<th>id</th>
						<th>名称</th>
						<th>URL</th>
						<th>Order</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="l" items="${linkList}" >
						<tr>
							<td>${l.linkId}</td>
							<td>${l.linkName}</td>
							<td>${l.linkUrl}</td>
							<td>${l.linkOrder}</td>
							<td>
								<a href="link/edit/${l.linkId}" class="layui-btn layui-btn-mini">编辑</a>
							    <a href="link/delete/${l.linkId}" class="layui-btn layui-btn-danger layui-btn-mini"  onclick="return confirmDelete()">删除</a>
							 </td> 
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</rapid:override>

<%@ include file="../framework.jsp"%>