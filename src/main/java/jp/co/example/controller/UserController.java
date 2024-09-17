package jp.co.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.example.controller.form.TestForm;
import jp.co.example.entity.User;
import jp.co.example.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/index")
	public String index(@ModelAttribute("index") TestForm form, Model model) {
		model.addAttribute("msg", "検索または登録情報を入力してください");

		return "top";
	}

	@RequestMapping(value = "/result", params = "search", method = RequestMethod.POST)
	public String search(@ModelAttribute("select") TestForm form, Model model) {
		List<User> list = new ArrayList<>();//あらかじめリストを作っておく、のちに更新するため

		String name = form.getName();
		String price = form.getPrice();
		if (name.isEmpty() && price.isEmpty()) {//name,price両方null(データがない)場合に

			list = userService.findAll();//全件取得
		} else if (!price.isEmpty()) {//nameはnullでもnullじゃなくてもよくて、priceに何かしらデータが入っているとき

			int price1 = Integer.parseInt(form.getPrice());
			list = userService.search(name, price1);

		} else if (price.isEmpty()) {//priceにデータが入っていないとき

			list = userService.search(name, 0);

		}
		model.addAttribute("resultList", list);//左側は引用するときに使う一次的な名前で右側は内容物
		return "searchResult";//ここはｊｓｐを返すためのreturnだと思っていた

	}

	@RequestMapping(value = "/result", params = "register", method = RequestMethod.POST)
	public String register(@ModelAttribute("register") TestForm form, Model model) {
		int select = 0;
		String name = form.getName();
		String price = form.getPrice();

		if (!name.isEmpty() && !price.isEmpty()) {
			int price1 = Integer.parseInt(form.getPrice());
			select = userService.register(name, price1);
		}
		model.addAttribute("resultList", select);
		return "insertResult";

	}

}
