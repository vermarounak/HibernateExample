package com.tcs.HibernateExample.DAO;

import java.util.List;

import org.hibernate.HibernateException;

import com.tcs.HibernateExample.DTO.UsersDTO;

public interface HibernateExampleDAO {

	public void createOperation(UsersDTO usersDTO) throws HibernateException;

	public List<UsersDTO> readAllOperation() throws HibernateException;

	public void updateOperation(UsersDTO usersDTO) throws HibernateException;

	public UsersDTO readSpecificOperation(int userId) throws HibernateException;
	
	public void deleteOperation(int userId) throws HibernateException;
	
	public void completeDeleteOperation() throws HibernateException;

}
