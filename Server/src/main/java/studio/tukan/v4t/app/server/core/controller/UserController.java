package studio.tukan.v4t.app.server.core.controller;

import javax.servlet.http.HttpSession;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import studio.tukan.v4t.app.server.core.domain.User;
import studio.tukan.v4t.app.server.core.pojo.ResultBean;
import studio.tukan.v4t.app.server.core.service.UserService;

@CrossOrigin
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	HttpSession session;

	@Autowired
	UserService userService;

	@PostMapping("/login")
	@ResponseBody
	public ResultBean<?> login(@Param("id") int id, @Param("password") String password) {
		ResultBean<User> result = new ResultBean<>();
		User e = userService.getUserByIdAndPassword(id, password);

		result.setCode(ResultBean.status.UNKNOWN.getCode());
		result.setMsg("Unknown!");

		if (e == null) {

			result.setCode(ResultBean.status.FAIL.getCode());
			result.setMsg("Fail!");

		} else {

			result.setCode(ResultBean.status.SUCCESS.getCode());
			result.setMsg("Success!");
			session.setAttribute("User", e);
			session.setAttribute("Login", System.currentTimeMillis());
			session.setMaxInactiveInterval(-1);
			

		}

		return result;
	}
	
	@GetMapping("/time")
	@ResponseBody
	public ResultBean<?> getUserTime() {
		ResultBean<Long> result = new ResultBean<>();

		result.setCode(ResultBean.status.UNKNOWN.getCode());
		result.setMsg("Unknown!");
		
		Long time = (Long)session.getAttribute("Login");

		if (time==null) {

			result.setCode(ResultBean.status.FAIL.getCode());
			result.setMsg("Fail!");

		} else {

			result.setCode(ResultBean.status.SUCCESS.getCode());
			result.setMsg("Success!");;
			result.setData(time);

		}

		return result;
	}
	

	@GetMapping("/getUser")
	@ResponseBody
	public ResultBean<?> getUser() {
		ResultBean<User> result = new ResultBean<>();
		User e = (User) session.getAttribute("User");
		result.setCode(ResultBean.status.UNKNOWN.getCode());
		result.setMsg("Unknown!");
		result.setData(e);

		if (e == null) {

			result.setCode(ResultBean.status.FAIL.getCode());
			result.setMsg("Fail!");

		} else {

			result.setCode(ResultBean.status.SUCCESS.getCode());
			result.setMsg("Success!");

		}

		return result;
	}

	@PostMapping("/register")
	@ResponseBody
	public ResultBean<?> register(@Param("username")String username,@Param("password") String password) {
		ResultBean<User> result = new ResultBean<>();
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		int n = userService.insertUserByPassword(user);
		int id = user.getId();
		
		result.setCode(ResultBean.status.UNKNOWN.getCode());
		result.setMsg("Unknown!");

		if (id <= 0) {

			result.setCode(ResultBean.status.FAIL.getCode());
			result.setMsg("Fail!");

		} else {

			result.setCode(ResultBean.status.SUCCESS.getCode());
			result.setMsg("Success!");

			User e = userService.getUserById(id);
			result.setData(e);

			//session.setAttribute("User", e);
			//session.setMaxInactiveInterval(0);

		}

		return result;
	}

	@PostMapping("/changepassword")
	@ResponseBody
	public ResultBean<?> changePassword(@Param("password") String password) {
		ResultBean<Boolean> result = new ResultBean<>();

		User user = (User) session.getAttribute("User");

		result.setCode(ResultBean.status.UNKNOWN.getCode());
		result.setMsg("Unknown!");

		if (user == null) {

			result.setCode(ResultBean.status.FAIL.getCode());
			result.setMsg("Fail!");

		} else {

			boolean flag = userService.updateUserPassword(user.getId(), password);
			if (flag) {
				result.setCode(ResultBean.status.SUCCESS.getCode());
				result.setMsg("Success!");
				session.setAttribute("User", userService.getUserById(user.getId()));
			} else {
				result.setCode(ResultBean.status.FAIL.getCode());
				result.setMsg("Fail!");
			}

		}

		return result;
	}

	@PostMapping("/changeimghead")
	@ResponseBody
	public ResultBean<?> changeImgHead(@Param("imghead") String imghead) {
		ResultBean<Boolean> result = new ResultBean<>();
		User user = (User) session.getAttribute("User");

		result.setCode(ResultBean.status.UNKNOWN.getCode());
		result.setMsg("Unknown!");

		if (user == null) {

			result.setCode(ResultBean.status.FAIL.getCode());
			result.setMsg("Fail!");

		} else {

			boolean flag = userService.changeUserImgHead(user.getId(), imghead);
			if (flag) {
				result.setCode(ResultBean.status.SUCCESS.getCode());
				result.setMsg("Success!");
				session.setAttribute("User", userService.getUserById(user.getId()));
			} else {
				result.setCode(ResultBean.status.FAIL.getCode());
				result.setMsg("Fail!");
			}
		}

		return result;
	}

	@PostMapping("/changename")
	@ResponseBody
	public ResultBean<?> changeName(@Param("username") String username) {
		ResultBean<Boolean> result = new ResultBean<>();
		User user = (User) session.getAttribute("User");

		result.setCode(ResultBean.status.UNKNOWN.getCode());
		result.setMsg("Unknown!");
		if (user == null) {

			result.setCode(ResultBean.status.FAIL.getCode());
			result.setMsg("Fail!");

		} else {
			boolean flag = userService.UpdateUsername(username, user.getId());
			if (flag) {
				result.setCode(ResultBean.status.SUCCESS.getCode());
				result.setMsg("Success!");
				session.setAttribute("User", userService.getUserById(user.getId()));
			} else {
				result.setCode(ResultBean.status.FAIL.getCode());
				result.setMsg("Fail!");
			}

		}
		return result;
	}

	@PostMapping("/changecolor")
	@ResponseBody
	public ResultBean<?> changeColor(@Param("color") String color) {
		ResultBean<Boolean> result = new ResultBean<>();
		User user = (User) session.getAttribute("User");

		result.setCode(ResultBean.status.UNKNOWN.getCode());
		result.setMsg("Unknown!");
		if (user == null) {

			result.setCode(ResultBean.status.FAIL.getCode());
			result.setMsg("Fail!");

		} else {
			boolean flag = userService.UpdateColor(color, user.getId());
			if (flag) {
				result.setCode(ResultBean.status.SUCCESS.getCode());
				result.setMsg("Success!");
				session.setAttribute("User", userService.getUserById(user.getId()));
			} else {
				result.setCode(ResultBean.status.FAIL.getCode());
				result.setMsg("Fail!");
			}

		}
		return result;
	}

	@PostMapping("/changewallpaper")
	@ResponseBody
	public ResultBean<?> changeWallpaper(@Param("wallpaper") String wallpaper) {
		ResultBean<Boolean> result = new ResultBean<>();
		User user = (User) session.getAttribute("User");

		result.setCode(ResultBean.status.UNKNOWN.getCode());
		result.setMsg("Unknown!");
		if (user == null) {

			result.setCode(ResultBean.status.FAIL.getCode());
			result.setMsg("Fail!");

		} else {
			boolean flag = userService.UpdateWallpaper(wallpaper, user.getId());
			if (flag) {
				result.setCode(ResultBean.status.SUCCESS.getCode());
				result.setMsg("Success!");
				session.setAttribute("User", userService.getUserById(user.getId()));
			} else {
				result.setCode(ResultBean.status.FAIL.getCode());
				result.setMsg("Fail!");
			}

		}
		return result;
	}

	@PostMapping("/logout")
	public ResultBean<?> logout() {
		ResultBean<Boolean> result = new ResultBean<>();

		result.setCode(ResultBean.status.UNKNOWN.getCode());

		session.invalidate();

		result.setMsg("Unknown!");
		if (session != null) {

			result.setCode(ResultBean.status.FAIL.getCode());
			result.setMsg("Fail!");

		} else {

			result.setCode(ResultBean.status.SUCCESS.getCode());
			result.setMsg("Success!");

		}
		return result;
	}

}
