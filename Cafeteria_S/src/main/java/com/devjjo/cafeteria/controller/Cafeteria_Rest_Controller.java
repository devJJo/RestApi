package com.devjjo.cafeteria.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.devjjo.cafeteria.constants.RestURIConstants;
import com.devjjo.cafeteria.model.User;
import com.devjjo.cafeteria.service.Cafeteria_Rest_Service;

/**
 * Handles requests for the Employee service.
 */
@Controller
public class Cafeteria_Rest_Controller {
	
	private static final Logger logger = LoggerFactory.getLogger(Cafeteria_Rest_Controller.class);
	
	@Autowired
	private Cafeteria_Rest_Service cafeteria_rest_service;

	/**
	 * 메인 페이지 연결 
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! the client locale is "+ locale.toString());
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );

		return "home";
	}
	
	/**
	 * 테스트 URI
	 * 등록된 모든 유저정보 가져옴
	 */
	@RequestMapping(value = RestURIConstants.GET_ALL_USER, method = RequestMethod.GET)
	public @ResponseBody List<User> get_all_user() {
		logger.info("##### Get All User");
		
		List<User> users = cafeteria_rest_service.selectUser();
		return users;
	}
	
	/**
	 * 테스트 URI
	 * 특정 유저정보 가져옴
	 */
	@RequestMapping(value = RestURIConstants.GET_USER, method = RequestMethod.GET)
	public @ResponseBody User get_user(@PathVariable("id") String userId) {
		logger.info("##### Get User");
		Map<String, Object> param = new HashMap<String, Object>();
		User user = new User();
		param.put("P_USER_ID", userId);
		user = cafeteria_rest_service.selectUserOne(param);
		
		return user;
	}
	
	/**
	 * 테스트 URI
	 * 새로운 유저정보 등록
	 */
	@RequestMapping(value = RestURIConstants.CREATE_USER, method = RequestMethod.POST)
	public @ResponseBody int create_user(@RequestBody User user) {
		logger.info("##### Create User");
		logger.info("##### " + user.getUser_Id());
		logger.info("##### " + user.getRemark());
		logger.info("##### " + user.getUser_Mail());
		logger.info("##### " + user.getUser_Nm());
		logger.info("##### " + user.getUser_Tel());
		int resultCount = cafeteria_rest_service.insertUser(user);
		
		return resultCount;
	}
	
	/**
	 * 테스트 URI
	 * 특정 유저정보 변경
	 */
	@RequestMapping(value = RestURIConstants.UPDATE_USER, method = RequestMethod.POST)
	public @ResponseBody int update_user(@RequestBody User user) {
		logger.info("##### Update User");
		logger.info("##### " + user.getUser_Id());
		logger.info("##### " + user.getRemark());
		logger.info("##### " + user.getUser_Mail());
		logger.info("##### " + user.getUser_Nm());
		logger.info("##### " + user.getUser_Tel());
		int resultCount = cafeteria_rest_service.updateUser(user);
		return resultCount;
	}
	
	/**
	 * 테스트 URI
	 * 특정 유저정보 삭제
	 */
	@RequestMapping(value = RestURIConstants.DELETE_USER, method = RequestMethod.DELETE)
	public @ResponseBody int delete_user(@PathVariable("id") String userId) {	
		logger.info("Delete User");
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("P_USER_ID", userId);
		int resultCount = cafeteria_rest_service.delete_user(param);
		return resultCount;
	}
	
}
