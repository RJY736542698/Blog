<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid"%>

<rapid:override name="frame-content">
	<blockquote class="layui-elem-quote">
		<span class="layui-breadcrumb" lay-separator="/"> <a
			href="/admin">首页</a> <a><cite>基本信息</cite></a>
		</span>
	</blockquote>

	<form class="layui-form" action="options/edit" method="post" enctype="multipart/form-data">
		<div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
			<ul class="layui-tab-title">
				<li class="layui-this">基本信息</li>
				<li>小工具</li>
			</ul>
			<div class="layui-tab-content">
				<br>
				<br>
				
				<!-- 选项卡一 -->
				<div class="layui-tab-item layui-show">
					<div class="layui-form-item">
						<label class="layui-form-label">站点名称</label>
						<div class="layui-input-inline">
							<input type="text" name="optionSiteTitle" value="${option.optionSiteTitle}" autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">站点描述</label>
						<div class="layui-input-block">
							<input type="text" name="optionSiteDescrption"  value="${option.optionSiteDescrption}" 	autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">首页描述</label>
						<div class="layui-input-block">
							<input type="text" name="optionMetaDescrption" 	value="${option.optionMetaDescrption}"  autocomplete="off" 	class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">首页关键词</label>
						<div class="layui-input-block">
							<input type="text" name="optionMetaKeyword"  value="${option.optionMetaKeyword}" autocomplete="off" class="layui-input">
						</div>
					</div>
				</div>
				
				<!-- 选项卡二 -->
				<div class="layui-tab-item">
					<div class="layui-form-item">
						<label class="layui-form-label">头像</label>
						<div class="layui-input-inline">
							<div class="layui-upload">
								<div class="layui-upload-list" id="localImag">
									<img class="layui-upload-img" src="options/photo/sitephoto" id="img1" width="200"  	height="200">
									<p id="demoText"></p>
								</div>
								<button type="button" class="layui-btn"  onclick="$('#file1').click()"  >上传图片</button>
								<input  id="file1" type="file"	name="sitePhoto" style="display:none"  onchange="preview(this,localImag,img1,'200px','200px')" >
								
							</div>
						</div>
						<div class="layui-form-mid layui-word-aux">&nbsp;&nbsp;  建议 150px*150px</div>

					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">昵称</label>
						<div class="layui-input-inline">
							<input type="text" name="optionAboutsiteTitle"   value="${option.optionAboutsiteTitle}" 	autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">说明</label>
						<div class="layui-input-block">
							<input type="text" name="optionAboutsiteContent" value="${option.optionAboutsiteContent}"   autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">微信二维码</label>
						<div class="layui-input-inline">
							<div class="layui-upload">
								<div class="layui-upload-list" id="localImag2" >
									<img class="layui-upload-img" 	src="options/photo/webchatphoto" id="img2"	width="200" height="200">
									<p id="demoText2"></p>
								</div>
								<button type="button" class="layui-btn"    onclick="$('#file2').click()" >上传图片</button>
								<input  id="file2" type="file"	name="webChatPhoto" style="display:none"  onchange="preview(this,localImag2,img2,'200px','200px')"  >
									
							</div>
						</div>
						<div class="layui-form-mid layui-word-aux">&nbsp;&nbsp;  建议 430px*430px</div>

					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">QQ</label>
						<div class="layui-input-inline">
							<input type="text" name="optionAboutsiteQq" value="${option.optionAboutsiteQq}"   autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">微博</label>
						<div class="layui-input-inline">
							<input type="text" name="optionAboutsiteWeibo" value="${option.optionAboutsiteWeibo}"  autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">Github</label>
						<div class="layui-input-inline">
							<input type="text" name="optionAboutsiteGithub"   value="${option.optionAboutsiteGithub}"  	autocomplete="off" class="layui-input">
						</div>
					</div>
				</div>
			</div>

		</div>

		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit lay-filter="formDemo">保存设置</button>
			</div>
		</div>
	</form>
</rapid:override>

<rapid:override name="frame-footer-script">
	<script>
	
	  //预览图片  
	  function preview(docObj, localImagId, imgObjPreview, width, height) {
			if (docObj.files && docObj.files[0]) { //火狐下，直接设img属性        
				imgObjPreview.style.display = 'block';
				imgObjPreview.style.width = width;
				imgObjPreview.style.height = height;
				//火狐7以上版本不能用上面的getAsDataURL()方式获取，需要一下方式        
				imgObjPreview.src = window.URL.createObjectURL(docObj.files[0]);
			} else { //IE下，使用滤镜      
				docObj.select();
				var imgSrc = document.selection.createRange().text;
				//必须设置初始大小        
				localImagId.style.width = width;
				localImagId.style.height = height;
				//图片异常的捕捉，防止用户修改后缀来伪造图片        
				try {
					localImagId.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
					localImagId.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc;
				} catch (e) {
					alert("您上传的图片格式不正确，请重新选择!");
					return false;
				}
				imgObjPreview.style.display = 'none';
				document.selection.empty();
			}
		}
 	
	</script>
</rapid:override>

<%@ include file="../framework.jsp"%>