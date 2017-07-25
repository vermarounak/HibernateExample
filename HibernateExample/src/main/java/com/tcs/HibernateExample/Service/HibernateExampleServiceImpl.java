package com.tcs.HibernateExample.Service;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.HibernateExample.DAO.HibernateExampleDAO;
import com.tcs.HibernateExample.DTO.UsersDTO;

@Service
public class HibernateExampleServiceImpl implements HibernateExampleService {

	@Autowired
	private HibernateExampleDAO hibernateExampleDAO;

	@Override
	public void createOperation(UsersDTO usersDTO) throws HibernateException {

		try {
			hibernateExampleDAO.createOperation(usersDTO);
		} catch (HibernateException e) {
			throw e;
		}

	}

	@Override
	public List<UsersDTO> readAllOperation() throws HibernateException {

		List<UsersDTO> usersList = null;
		try {
			usersList = hibernateExampleDAO.readAllOperation();
		} catch (HibernateException e) {
			throw e;
		}

		return usersList;
	}

	@Override
	public void updateOperation(UsersDTO usersDTO) throws HibernateException {
		try {
			hibernateExampleDAO.updateOperation(usersDTO);
		} catch (HibernateException e) {
			throw e;
		}

	}

	@Override
	public UsersDTO readSpecificOperation(int userId) throws HibernateException {
		UsersDTO usersDTO = null;

		try {

			usersDTO = hibernateExampleDAO.readSpecificOperation(userId);

		} catch (HibernateException e) {
			throw e;
		}

		return usersDTO;
	}

	@Override
	public void deleteOperation(int userId) throws HibernateException {
		try {
			hibernateExampleDAO.deleteOperation(userId);
		} catch (HibernateException e) {
			throw e;
		}

	}

	@Override
	public void completeDeleteOperation() throws HibernateException {
		try {
			hibernateExampleDAO.completeDeleteOperation();
		} catch (HibernateException e) {
			throw e;
		}

	}

}
