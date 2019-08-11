package studio.tukan.v4t.app.server.core.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import studio.tukan.v4t.app.server.core.domain.Badge;
import studio.tukan.v4t.app.server.core.domain.User;
import studio.tukan.v4t.app.server.core.pojo.ResultBean;
import studio.tukan.v4t.app.server.core.service.BadgeService;

@Controller
@RequestMapping("/badge")
public class BadgeController {

	@Autowired
	BadgeService badgeService;

	@Autowired
	HttpSession session;

	@GetMapping("/getbadge")
	@ResponseBody
	public ResultBean<?> getUserBadgeListByUserId() {

		ResultBean<List<Badge>> result = new ResultBean<List<Badge>>();
		result.setCode(ResultBean.status.UNKNOWN.getCode());
		result.setMsg("Unknown!");

		User user = (User) session.getAttribute("User");

		if (user == null) {
			return result;
		} else {
			List<Badge> list = badgeService.getBadgeListByUserId(user.getId());
			if (list == null) {
				result.setCode(ResultBean.status.FAIL.getCode());
				result.setMsg("Fail!");
			} else {
				result.setData(list);
				result.setCode(ResultBean.status.SUCCESS.getCode());
				result.setMsg("Success!");
				//System.out.println(list.toString());
			}
		}

		return result;
	}
	
	@PostMapping("/addbadge")
	@ResponseBody
	public ResultBean<?> addBadge(@Param("badgeinfid")int badgeinfid){

		ResultBean<Boolean> result = new ResultBean<Boolean>();
		result.setCode(ResultBean.status.UNKNOWN.getCode());
		result.setMsg("Unknown!");

		User user = (User) session.getAttribute("User");

		if (user == null) {
			return result;
		} else {
			boolean e = badgeService.addBadge(user.getId(),badgeinfid);
			if (!e) {
				result.setCode(ResultBean.status.FAIL.getCode());
				result.setMsg("Fail!");
			} else {
				result.setData(e);
				result.setCode(ResultBean.status.SUCCESS.getCode());
				result.setMsg("Success!");
			}
		}

		return result;		
		
		
	}
	
	@GetMapping("/countbadge")
	@ResponseBody
	public  ResultBean<?> getCountBadge(@Param("badgeinfid")int badgeinfid){
		ResultBean<Integer> result = new ResultBean<Integer>();

			int e = badgeService.getBadgeCount(badgeinfid);

				result.setData(e);
				result.setCode(ResultBean.status.SUCCESS.getCode());
				result.setMsg("Success!");

		return result;		
		
		
	}
	

}
