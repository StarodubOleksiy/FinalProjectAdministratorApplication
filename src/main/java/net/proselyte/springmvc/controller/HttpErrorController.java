package net.proselyte.springmvc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.NestedServletException;

import java.io.IOException;

@Controller
public class HttpErrorController {
	private static final String GENERAL_ERROR_VIEW = "error";

	@RequestMapping(value = "/errors/400.html")
	public ModelAndView handle400() {

		ModelAndView modelAndView = new ModelAndView(GENERAL_ERROR_VIEW);
		modelAndView.addObject("message","Ви зробили неприпустимі дії." +
				" Можливо ви не ввели дані, або ввели їх неправильно!!! Наприклад в числове поле ввели літери і т.д." );

		return modelAndView;
	}
	@RequestMapping(value = "/errors/404.html")
	public ModelAndView handle404() {

		ModelAndView modelAndView = new ModelAndView(GENERAL_ERROR_VIEW);
		modelAndView.addObject("errorCode", "404");
		modelAndView.addObject("message", " Ви зробили неприпустимі дії. Можливо ви  хочете видалити елемент з бази даних" +
				" який неможливо видалити або ввели сторінку якої не існує або не ввели потрібних даних");
		return modelAndView;
	}

	@RequestMapping(value = "/errors/405.html")
	public ModelAndView handle405(Model model) {

		ModelAndView modelAndView = new ModelAndView(GENERAL_ERROR_VIEW);
		modelAndView.addObject("errorCode", "405");
		modelAndView.addObject("message", "Error 405 happens");

		return modelAndView;
	}

	@RequestMapping(value = "/errors/406.html")
	public ModelAndView handle406(Model model) {

		ModelAndView modelAndView = new ModelAndView(GENERAL_ERROR_VIEW);
		modelAndView.addObject("errorCode", "406");
		modelAndView.addObject("message", "Error 406 happens");

		return modelAndView;
	}

	@RequestMapping(value = "/errors/408.html")
	public ModelAndView handle408(Model model) {

		ModelAndView modelAndView = new ModelAndView(GENERAL_ERROR_VIEW);
		modelAndView.addObject("errorCode", "408");
		modelAndView.addObject("message", "Error 408 happens");

		return modelAndView;
	}

	@RequestMapping(value = "/errors/415.html")
	public ModelAndView handle415(Model model) {

		ModelAndView modelAndView = new ModelAndView(GENERAL_ERROR_VIEW);
		modelAndView.addObject("errorCode", "415");
		modelAndView.addObject("message", "Error 415 happens");

		return modelAndView;
	}

	@RequestMapping(value = "/errors/500.html")
	public ModelAndView handle500(Exception exception) {

		ModelAndView modelAndView = new ModelAndView(GENERAL_ERROR_VIEW);
		modelAndView.addObject("errorCode", "500");
		modelAndView.addObject("message", "Error 500 happens!!!");

		return modelAndView;
	}

	@RequestMapping(value = "/errors/503.html")

	public ModelAndView handle503(Exception exception) {

		ModelAndView modelAndView = new ModelAndView(GENERAL_ERROR_VIEW);
		modelAndView.addObject("errorCode", "503");
		modelAndView.addObject("message", "Error 503 happens");

		return modelAndView;
	}

	@ExceptionHandler(IOException.class)
	public ModelAndView ioException(IOException exception) {
		ModelAndView modelAndView = new ModelAndView("page-not-found");
		modelAndView.addObject("message", exception.getMessage());
		return modelAndView;
	}



}
