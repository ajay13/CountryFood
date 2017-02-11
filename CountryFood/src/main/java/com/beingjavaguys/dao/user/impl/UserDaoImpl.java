package com.beingjavaguys.dao.user.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.beingjavaguys.dao.core.CoreDao;
import com.beingjavaguys.dao.user.UserDao;
import com.beingjavaguys.models.UserData;

@Component("userDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	CoreDao coreDao;

	@Override
	public void add(UserData userData) {
		Session session = null;
		try {
			session = coreDao.getSession();
			session.beginTransaction();
			session.saveOrUpdate(userData);
			session.getTransaction().commit();
		} catch (HibernateException e) {
                 e.printStackTrace();
		} finally {
			session.close();

		}
	}

	
	@Override
	public List<Object> get(int limit, int pageno) {

		List<Object> list = new ArrayList<Object>();
		List<UserData> userDataList = new ArrayList<UserData>();

		String getUser = " select U from UserData U";
		String getUserCount = "select count(U) from UserData U";

		Session session = null;
		Query query = null;
		try {
			session = coreDao.getSession();
			session.beginTransaction();
			query = session.createQuery(getUser);
			query.setFirstResult((pageno * limit) - limit);
			query.setMaxResults(limit);
			userDataList = query.list();

			query = session.createQuery(getUserCount);
			Long count = (Long) query.uniqueResult();

			int pagination = (int) (count / limit);

			if (pagination * limit < count) {
				pagination++;
			}

			list.add(userDataList);
			list.add(pagination);

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}
	
	@Override
	public UserData get(int userId) {
		UserData userData = null;
		Session session = null;
		String getSMSData = "from UserData U where U.id=:userId";
		Query query = null;
		try {
			session = coreDao.getSession();
			session.beginTransaction();
			query = session.createQuery(getSMSData);
			query.setParameter("userId", userId);
			userData = (UserData) query.uniqueResult();
		}
		catch (HibernateException e) {
		}
		finally {
			session.close();
		}
		return userData;
	}
	
	@Override
	public void delete(UserData userData) {
		Session session = null;
		try {
			session = coreDao.getSession();
			session.beginTransaction();
			session.delete(userData);
			session.getTransaction().commit();
		} catch (HibernateException e) {

		} finally {
			session.close();

		}
	}

}
