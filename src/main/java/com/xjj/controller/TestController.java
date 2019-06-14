package com.xjj.controller;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.xjj.pojo.User;
import com.xjj.service.UserService;
@Controller
public class TestController {
	@Resource
	UserService userService;
	@RequestMapping("/test")
	@ResponseBody
	public List<User> test(HttpServletResponse res) {
		return userService.getUsers();
	}
	@RequestMapping("/uploadController")
	public void upload(MultipartFile file,HttpServletResponse res,HttpServletRequest req) {
		try {
			System.out.println(req.getServletContext().getRealPath(file.getOriginalFilename()));
			file.transferTo(new File(req.getServletContext().getRealPath(file.getOriginalFilename())));
			res.getWriter().write("ddd");
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
