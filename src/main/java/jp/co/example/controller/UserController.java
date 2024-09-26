package jp.co.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.example.controller.form.UserForm;
import jp.co.example.entity.User;
import jp.co.example.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/index")
	public String index(@ModelAttribute("index") UserForm form, Model model) {
		//model.addAttribute("msg", "検索または登録情報を入力してください");

		return "top";
	}

	@RequestMapping(value = "/result", params = "select", method = RequestMethod.POST)
	public String search(@Validated @ModelAttribute("select") UserForm form, BindingResult bindingResult, Model model) {
		List<User> list = new ArrayList<>();//あらかじめリストを作っておく、のちに更新するため

		String userName = form.getUserName();
		Integer userPrice = form.getUserPrice();
		if (userName.isEmpty() && userPrice == 0) {//name,price両方null(データがない)場合に

			list = userService.findAll();//全件取得
			model.addAttribute("resultList", list);
		} else if (userPrice != 0) {//nameはnullでもnullじゃなくてもよくて、priceに何かしらデータが入っているとき

		
			list = userService.search(form);
			model.addAttribute("resultList", list);

		} else if (userPrice ==0) {//priceにデータが入っていないとき

			list = userService.search(form);
			model.addAttribute("resultList", list);//左側は引用するときに使う一次的な名前で右側は内容物

		}
		return "searchResult";

	}

	@RequestMapping(value = "/result", params = "insert", method = RequestMethod.POST)
	public String insert(@Validated @ModelAttribute("insert") UserForm form, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "top";
		}
		userService.insert(form);
		model.addAttribute("msg", "登録が完了しました");
		return "insertResult";

	}

}
