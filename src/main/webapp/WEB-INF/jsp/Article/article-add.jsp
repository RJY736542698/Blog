<%@ page language="java"  import="java.util.*"  contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid"%>

<rapid:override name="frame-content">
	<blockquote class="layui-elem-quote">
		<span class="layui-breadcrumb" lay-separator="/"> 
			<a href="/admin">首页</a> <a href="/admin/article">文章列表</a> <a><cite>添加文章</cite></a>
		</span>
	</blockquote>
	
	<form class="layui-form" method="post" id="myForm" action="article/add">		
		<div class="layui-form-item">
			<label class="layui-form-label">标题 <span style="color: #FF5722;" >*</span></label>	
			<div class="layui-input-block">
				<input type="text" name="articleTitle" lay-verify="title" id="title"
					autocomplete="off" placeholder="请输入标题" class="layui-input">
			</div>
		</div>

		<div class="layui-form-item layui-form-text">
			<label class="layui-form-label">内容 <span style="color: #FF5722;">*</span></label>		
			<div class="layui-input-block">
			    <%--下面的内容将被渲染成富文本编辑器 --%>
				<textarea  name="articleContent" lay-verify="content" id="content"></textarea>
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">分类 <span
				style="color: #FF5722;">*</span>
			</label>
			<div class="layui-input-inline">
				    <select name="articleParentCategoryId" id="articleParentCategoryId"  lay-filter="articleParentCategoryId" required>
                    <option value="" >一级分类</option>
	                    <c:forEach items="${categoryList}" var="c">
	                        <c:if test="${c.categoryPid==0}">
	                            <option value="${c.categoryId}">${c.categoryName}</option>
	                        </c:if>
	                    </c:forEach>
                    </select>
                   
			</div>
			<div class="layui-input-inline">
				<select name="articleChildCategoryId" id="articleChildCategoryId">
					<option value="" selected>二级分类</option>
				</select>
			</div>
		</div>

		<div class="layui-form-item" pane="">
			<label class="layui-form-label">标签</label>
			<div class="layui-input-block">
			    <c:forEach var="t" items="${tagList}" >
                    <input type="checkbox" name="articleTagIds" lay-skin="primary" title="${t.tagName}" value="${t.tagId}">
                </c:forEach>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">状态</label>
			<div class="layui-input-block">
				<input type="radio" name="articleStatus" value="1" title="发布"
					checked> <input type="radio" name="articleStatus" value="0"
					title="草稿">
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
				<button type="reset" class="layui-btn layui-btn-primary"
					onclick="getCateIds()">重置</button>
			</div>
		</div>
		<blockquote class="layui-elem-quote layui-quote-nm">
			温馨提示：<br> 1、文章内容的数据表字段类型为MEDIUMTEXT,每篇文章内容请不要超过500万字 <br>
			2、写文章之前，请确保标签和分类存在，否则可以先新建；请勿刷新页面，博客不会自动保存 <br> 3、插入代码前，可以点击 <a
				href="javascript:void(0)" target="_blank">代码高亮</a>,将代码转成HTML格式
		</blockquote>
	</form>
</rapid:override>

<rapid:override name="frame-footer-script">
    <script>
        //这是模块化加载layui 的方法,它加载了layui内置的 form,  layedit ,laydate 三个模块
        layui.use(['form','laydate'], function() {
            var form = layui.form;
            var layer = layui.layer;
            var laydate = layui.laydate;    

            //自定义验证规则
            form.verify({
                title: function (value) {
                    if (value.length < 5) {
                        return '标题至少得5个字符啊';
                    }
                }
                , pass: [/(.+){6,12}$/, '密码必须6到12位']
                , content: function (value) {
                    layedit.sync(editIndex);
                }
            });

            //二级联动 败类的layui,破坏了原来的 onchange的写法,必须这样写
            form.on("select(articleParentCategoryId)",function(){
            	//取得父级分类id
            	var parentCateId=$("#articleParentCategoryId").val();
      
            	$("#articleChildCategoryId").empty();
            	$.ajax({        	
            		url:"category/listsub",
            		data:{parentCateId:parentCateId},
            		type:"post",
            		dataType:"json",
            		async:false,
            		cache:false,
            		success:function(cateList){
            			$.each(cateList,function(k,cate){
            				var option="<option name='childCategory' value='"+cate.categoryId+"'>  "+cate.categoryName+"  </option>";
                			$("#articleChildCategoryId").append(option);
            			});
            		}	
            	});
            	
            	//layui败类,这句必须写
            	 form.render('select'); 
            });
       });
        
	
    </script>
 
        <link rel="stylesheet" href="resources/kindeditor/themes/default/default.css" />
     	<link rel="stylesheet" href="resources/kindeditor/plugins/code/prettify.css" />
     	<script charset="utf-8" src="resources/kindeditor/kindeditor-all-min.js"></script>
     	<script charset="utf-8" src="resources/kindeditor/lang/zh-CN.js"></script>
     	<script charset="utf-8" src="resources/kindeditor/plugins/code/prettify.js"></script>
     	<script>
     
     		KindEditor.ready(function(K) {
     			var editor1 = K.create('textarea[id="content"]', {
     				cssPath : 'resources/kindeditor/plugins/code/prettify.css',
     				width : '900px',
     				height:'400px',

     				uploadJson : 'article/uploadimg',
     			//	fileManagerJson : 'resources/kindeditor/jsp/file_manager_json.jsp',
     				allowFileManager : true,
     			});
     			prettyPrint();
     		});
     		
 	    
     	</script>
 
    

</rapid:override>

<%@ include file="../framework.jsp"%>