package com.tcs.HibernateExample.DAO;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.tcs.HibernateExample.DTO.UsersDTO;
import com.tcs.HibernateExample.Utilities.DBConnectionUtil;

@Repository
public class HibernateExampleDAOImpl implements HibernateExampleDAO {

	@Override
	public void createOperation(UsersDTO usersDTO) throws HibernateException {

		try {
			Session session = DBConnectionUtil.getSessionFactory()
					.openSession();

			session.beginTransaction();

			session.save(usersDTO);

			session.getTransaction().commit();

			session.close();

		} catch (Exception e) {
			throw new HibernateException(e);
		}
	}

	@Override
	public List<UsersDTO> readAllOperation() throws HibernateException {

		List<UsersDTO> usersList = null;
		try {
			Session session = DBConnectionUtil.getSessionFactory()
					.openSession();
			Criteria criteria = session.createCriteria(UsersDTO.class);
			usersList = criteria.list();
			session.close();
		} catch (Exception e) {
			throw new HibernateException(e);
		}

		return usersList;
	}

	@Override
	public void updateOperation(UsersDTO usersDTO) throws HibernateException {

		try {

			Session session = DBConnectionUtil.getSessionFactory()
					.openSession();

			session.beginTransaction();

			UsersDTO oldUserDTO = (UsersDTO) session.load(UsersDTO.class,
					usersDTO.getUserId());

			oldUserDTO.setUserName(usersDTO.getUserName());
			oldUserDTO.setUpdatedDate(LocalDate.now());

			session.update(oldUserDTO);

			session.getTransaction().commit();

			session.close();

		} catch (Exception e) {
			throw new HibernateException(e);
		}

	}

	@Override
	public UsersDTO readSpecificOperation(int userId) throws HibernateException {

		UsersDTO usersDTO = null;
		try {

			Session session = DBConnectionUtil.getSessionFactory()
					.openSession();
			session.beginTransaction();

			usersDTO = (UsersDTO) session
					.createQuery(" from UsersDTO where userId = ?")
					.setParameter(0, userId).list().get(0);

			session.getTransaction().commit();

			session.close();

		} catch (Exception e) {
			throw new HibernateException(e);
		}
		return usersDTO;
	}

	@Override
	public void deleteOperation(int userId) throws HibernateException {

		try {

			Session session = DBConnectionUtil.getSessionFactory()
					.openSession();

			session.beginTransaction();

			UsersDTO usersDTO = session.get(UsersDTO.class, userId);

			session.delete(usersDTO);

			session.getTransaction().commit();

			session.close();
		} catch (Exception e) {
			throw new HibernateException(e);
		}

	}

	@Override
	public void completeDeleteOperation() throws HibernateException {
		try {

			Session session = DBConnectionUtil.getSessionFactory()
					.openSession();

			session.beginTransaction();

			session.createQuery("from UsersDTO");

			session.getTransaction().commit();

			session.close();

		} catch (Exception e) {
			throw new HibernateException(e);
		}

	}
}
