package com.nowon.test.service;


import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;


public interface GoodsService {

	ModelAndView getList(ModelAndView model);

	void getglist(Model model);


}
