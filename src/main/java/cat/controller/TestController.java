package cat.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	@RequestMapping("/test")
	public String test(ModelMap m)
	{
		m.put("msg","springmvc流程跑通");
		System.out.println("进入到了控制层");
		return "index";
	}
}
