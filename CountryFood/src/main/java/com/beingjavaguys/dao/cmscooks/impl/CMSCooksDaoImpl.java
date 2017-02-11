package com.beingjavaguys.dao.cmscooks.impl;

import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.beingjavaguys.dao.cmscooks.CMSCooksDao;
import com.beingjavaguys.dao.core.CoreDao;
import com.beingjavaguys.models.cmscooks.CMSCooksData;

@Repository("cmsCooksDao")
public class CMSCooksDaoImpl implements CMSCooksDao{


	@Autowired
	CoreDao coreDao;
	
	@Override
	public void addCooks(CMSCooksData cmsCooksData, HttpServletResponse response) {

		String getCooks = "select count(C) from CMSCooksData C where C.name=:name";
		
		Session session = null;
		Query query = null;
		try {
			session = coreDao.getSession();
			session.beginTransaction();
			query = session.createQuery(getCooks);
			query.setParameter("name", cmsCooksData.getName());
			
			Long count = (Long) query.uniqueResult();
			
			if(count==0){
				session.saveOrUpdate(cmsCooksData);
				session.getTransaction().commit();
				response.setStatus(200);//for OK
			}else{
				response.setStatus(402);//for already exists
			}
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public void deleteCooks(CMSCooksData cmsCooksData, HttpServletResponse response) {

		Session session = null;
		try {
			session = coreDao.getSession();
			session.beginTransaction();
			session.delete(cmsCooksData);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();

		}
		
	}

	@Override
	public CMSCooksData getCooks(int id, HttpServletResponse response) {
		CMSCooksData cmsCooksData = null;
		Session session = null;
		String getCooks = "from CMSCooksData C where C.id=:id";
		Query query = null;
		try {
			session = coreDao.getSession();
			session.beginTransaction();
			query = session.createQuery(getCooks);
			query.setParameter("id", id);
			cmsCooksData = (CMSCooksData) query.uniqueResult();
		}
		catch (HibernateException e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return cmsCooksData;
	}

}
