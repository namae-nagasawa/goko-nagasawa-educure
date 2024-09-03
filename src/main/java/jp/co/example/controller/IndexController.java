package jp.co.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.example.controller.form.IndexForm;
import jp.co.example.entity.User;

public class IndexController {

	@RequestMapping("/index")
	public String index(@ModelAttribute("index") IndexForm form,Model model){
		List<User> userList =new ArrayList<>();
		userList.add(new User(1,"田中","0311112222"));
		userList.add(new User(2,"鈴木","0571112222"));
		
		model.addAttribute("userList",userList);
		
		return "index";
	}

	@RequestMapping(value="/result",method=RequestMethod.POST)
	public String result(@ModelAttribute("index") IndexForm form,Model model) {
		int userId =form.getUserId();
		
		User user =null;
		
		switch(userId){
			case 1:
			user =new User(1,"田中","0311112222");
			break;
			
			case 2:
			user =new User(2,"鈴木","0571112222");
			break;
		}
		
		model.addAttribute("user",user);
		
		return "result";
	}
}

