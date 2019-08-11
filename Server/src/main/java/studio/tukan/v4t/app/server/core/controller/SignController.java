package studio.tukan.v4t.app.server.core.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import studio.tukan.v4t.app.server.core.domain.User;
import studio.tukan.v4t.app.server.core.pojo.ResultBean;
import studio.tukan.v4t.app.server.core.service.SignService;

@CrossOrigin
@Controller
@RequestMapping("/sign")
public class SignController {

	@Autowired
	HttpSession session;
	
	@Autowired
	SignService signService;
	
	
	@GetMapping("/getSign")
	@ResponseBody
	public ResultBean<?> getSign() {
		ResultBean<Integer> result = new ResultBean<>();
		result.setCode(ResultBean.status.UNKNOWN.getCode());
		result.setMsg("Unknown!");
		
		
		User user =  (User)session.getAttribute("User");
		
		if(user==null) {return result;}
		
		int e = signService.getSignTotal(user.getId());
		

		

		if (e < 0) {

			result.setCode(ResultBean.status.FAIL.getCode());
			result.setMsg("Fail!");

		} else {

			result.setCode(ResultBean.status.SUCCESS.getCode());
			result.setMsg("Success!");
			result.setData(e);

		}

		return result;
	}
	
	@PostMapping("/doSign")
	@ResponseBody
	public ResultBean<?> postSign() {
		ResultBean<Integer> result = new ResultBean<>();
		result.setCode(ResultBean.status.UNKNOWN.getCode());
		result.setMsg("Unknown!");
		
		
		User user =  (User)session.getAttribute("User");
		
		
		if(user==null) {return result;}
		
		int e = signService.doSign(user.getId());
		result.setData(e);

		if (e<=0) {

			result.setCode(ResultBean.status.FAIL.getCode());
			result.setMsg("Fail!");

		} else {

			result.setCode(ResultBean.status.SUCCESS.getCode());
			result.setMsg("Success!");
			

		}

		return result;
	}
	
	
	
}
