package com.tcs.HibernateExample.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tcs.HibernateExample.DTO.UsersDTO;
import com.tcs.HibernateExample.Service.HibernateExampleService;

@RestController
@RequestMapping(value = "/springplushibernate")
public class HibernateExampleController {

	private static Logger LOG = Logger
			.getLogger(HibernateExampleController.class);

	@Autowired
	private HibernateExampleService hibernateExampleService;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public void createOperation(@RequestBody String str,
			HttpServletRequest request) {

		try {

			ObjectMapper objectMapper = new ObjectMapper();
			UsersDTO usersDTO = objectMapper.readValue(str, UsersDTO.class);

			hibernateExampleService.createOperation(usersDTO);
		} catch (HibernateException e) {
			LOG.error(
					"HibernateExampleController | createOperation | Exception --->>>> ",
					e);
		} catch (JsonParseException e) {
			LOG.error(
					"HibernateExampleController | createOperation | Exception --->>>> ",
					e);
		} catch (JsonMappingException e) {
			LOG.error(
					"HibernateExampleController | createOperation | Exception --->>>> ",
					e);
		} catch (IOException e) {
			LOG.error(
					"HibernateExampleController | createOperation | Exception --->>>> ",
					e);
		}

	}

	@RequestMapping(value = "/readAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<UsersDTO> readAllOperation(HttpServletRequest request) {
		List<UsersDTO> usersList = null;
		try {
			usersList = hibernateExampleService.readAllOperation();
		} catch (HibernateException e) {
			LOG.error(
					"HibernateExampleController | readAllOperation | Exception --->>>> ",
					e);
		}

		return usersList;
	}

	@RequestMapping(value = "/read", method = RequestMethod.POST)
	@ResponseBody
	public UsersDTO readSpecificOperation(@RequestBody String str,
			HttpServletRequest request) {
		UsersDTO usersDTO = null;
		try {

			ObjectMapper objectMapper = new ObjectMapper();

			usersDTO = objectMapper.readValue(str, UsersDTO.class);

			usersDTO = hibernateExampleService.readSpecificOperation(usersDTO
					.getUserId());
		} catch (HibernateException e) {
			LOG.error(
					"HibernateExampleController | readSpecificOperation | Exception --->>>> ",
					e);
		} catch (JsonParseException e) {
			LOG.error(
					"HibernateExampleController | readSpecificOperation | Exception --->>>> ",
					e);
		} catch (JsonMappingException e) {
			LOG.error(
					"HibernateExampleController | readSpecificOperation | Exception --->>>> ",
					e);
		} catch (IOException e) {
			LOG.error(
					"HibernateExampleController | readSpecificOperation | Exception --->>>> ",
					e);
		}

		return usersDTO;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public void updateOperation(@RequestBody String str,
			HttpServletRequest request) {

		try {

			ObjectMapper objectMapper = new ObjectMapper();

			UsersDTO usersDTO = objectMapper.readValue(str, UsersDTO.class);

			hibernateExampleService.updateOperation(usersDTO);

		} catch (HibernateException e) {
			LOG.error(
					"HibernateExampleController | updateOperation | Exception --->>>> ",
					e);
		} catch (JsonParseException e) {
			LOG.error(
					"HibernateExampleController | updateOperation | Exception --->>>> ",
					e);
		} catch (JsonMappingException e) {
			LOG.error(
					"HibernateExampleController | updateOperation | Exception --->>>> ",
					e);
		} catch (IOException e) {
			LOG.error(
					"HibernateExampleController | updateOperation | Exception --->>>> ",
					e);
		}

	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public void deleteOperation(@RequestBody String str,
			HttpServletRequest request) {

		try {

			ObjectMapper objectMapper = new ObjectMapper();
			UsersDTO usersDTO = objectMapper.readValue(str, UsersDTO.class);

			hibernateExampleService.deleteOperation(usersDTO.getUserId());

		} catch (HibernateException e) {
			LOG.error(
					"HibernateExampleController | deleteOperation | Exception --->>>> ",
					e);
		} catch (JsonParseException e) {
			LOG.error(
					"HibernateExampleController | deleteOperation | Exception --->>>> ",
					e);
		} catch (JsonMappingException e) {
			LOG.error(
					"HibernateExampleController | deleteOperation | Exception --->>>> ",
					e);
		} catch (IOException e) {
			LOG.error(
					"HibernateExampleController | deleteOperation | Exception --->>>> ",
					e);
		}

	}

	@RequestMapping(value = "/completeDelete", method = RequestMethod.POST)
	public void completeDeleteOperation(HttpServletRequest request) {

		try {
			hibernateExampleService.completeDeleteOperation();
		} catch (HibernateException e) {
			LOG.error(
					"HibernateExampleController | completeDeleteOperation | Exception --->>>> ",
					e);
		}

	}

}
