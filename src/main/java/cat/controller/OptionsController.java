package cat.controller;
import java.io.IOException;
import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import cat.entity.Options;
import cat.service.OptionsService;

/**
 * Option (站点选项 ) 相关信息
 */
@Controller @RequestMapping("/options")
public class OptionsController {

    @Resource
    private OptionsService optionsService;

    /**
     * 转到基本信息页面
     */
    @RequestMapping(value = "")
    public String index(ModelMap m)  {
        m.put("option", optionsService.getOptions());
        return "/Options/options";
    }

    /**
     * 转到信息编辑页
     */
    @RequestMapping(value = "/edit",method = RequestMethod.GET)
    public String toOptionsEditPage(ModelMap m)  {
        m.put("option", optionsService.getOptions());
        return "Options/options";
    }

    /**
     * 更新基本信息,注意要有两张图片要处理 
     * @throws IOException 
     */
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public String updateOption(MultipartFile sitePhoto ,MultipartFile webChatPhoto,Options options,ModelMap m) throws IOException  {
    	options.setOptionAboutsitePhoto(sitePhoto.getBytes());
    	options.setOptionAboutsiteWechatphoto(webChatPhoto.getBytes());
        optionsService.updateOptions(options);
        
        m.put("option", optionsService.getOptions());
        return "/Options/options";
        
       // return "forward:/options";
    }
    
   
    /**
	 * 提取出的图片数据,传到前台展示,由于有站点头象,还有微信图片,所以前面要传一个 photoType 区分一下
	 */
	@RequestMapping("/photo/{photoType}")
	public void showPhoto(@PathVariable("photoType") String photoType,HttpServletResponse response) throws IOException
	{
		
  		Options options =optionsService.getOptions();
  		response.setContentType("image/jpg");		
  		ServletOutputStream outstream =response.getOutputStream();	
  		
  		if("sitephoto".equals(photoType)) {
  			outstream.write(options.getOptionAboutsitePhoto());
  		}
  		else {
  			outstream.write(options.getOptionAboutsiteWechatphoto());
  		}
  		
  		outstream.flush();
	}	
}
