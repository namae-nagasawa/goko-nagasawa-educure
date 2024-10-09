package jp.co.hoge.web.controller;

import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.hoge.web.controller.form.UserForm;
import jp.co.hoge.web.entity.User;
import jp.co.hoge.web.service.UserService;

@Controller
public class InsertController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert(@ModelAttribute("insert") UserForm form, Model model, HttpSession session,
			HttpSession request) {

		session.setAttribute("msg3", "登録情報を入力してください");
		session.setAttribute("msg5", "※は必須です。");
		return "insert";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insertDate(@Validated @ModelAttribute("insert") UserForm form, BindingResult bindingResult,
			Model model, HttpSession session, HttpSession request) {
		List<User> resultList2 = new ArrayList<>();

		resultList2 = userService.selectId(form);

		if (!resultList2.isEmpty()) {
			model.addAttribute("msg6", "IDが重複しています");
			return "insert";
		}

		if (bindingResult.hasErrors()) {
			return "insert";
		}

		session.setAttribute("loginId", form.getLoginId());
		session.setAttribute("userName", form.getName());
		session.setAttribute("telephone", form.getTelephone());
		session.setAttribute("roleId", form.getRoleId());
		session.setAttribute("password", form.getPassword());

		return "insertConfirm";

	}

	@RequestMapping(value = "/insertConfirm", method = RequestMethod.POST)
	public String insertConfirm(@ModelAttribute("insertConfirm") UserForm form, Model model, HttpSession session) {
		
		String pass = (String) session.getAttribute("password");
		Integer id = (Integer) session.getAttribute("roleId");

		if (!pass.equals(form.getPassword())) {
			model.addAttribute("msg9", "前画面で入力したPASSと一致しません");
			return "insertConfirm";
		}
		if (id != null) {
			form.setRoleId(id); // sessionに格納されているroleIdをformクラスのセッターに入れられることで適用できる
		}
		userService.insert(form);

		model.addAttribute("msg8", "登録が完了しました");
		return "insertResult";
	}

}
