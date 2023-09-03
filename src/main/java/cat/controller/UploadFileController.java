package cat.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 上传文件
 * 在tomcat的配置文件中: <Context path="/uploads" docBase="D:/imguploads" debug="0" reloadable="true" />
 */
@Controller
public class UploadFileController {

    @ResponseBody  @RequestMapping(value = "/article/uploadimg")
    public String uploadFile(MultipartHttpServletRequest request) throws IllegalStateException, IOException {
    	
    	//imgFile  这个名称没有什么理由,就是个固定写法,在前台也找不到它的什么痕迹
    	MultipartFile file=    request.getFile("imgFile");

		//目标文件
		String newName= UUID.randomUUID().toString();
		File descFile = new File("/imguploads/"+ newName);
		file.transferTo(descFile);
	

		//这个图片地址,是要返给前台的 kindeditor 用的, 它要求以json格式返回
		 String path="http://localhost:8080/uploads/"+ newName; 
		 
		return  "{\"error\" : 0,\"url\" : \""+path+"\"}";
    	
    }
}