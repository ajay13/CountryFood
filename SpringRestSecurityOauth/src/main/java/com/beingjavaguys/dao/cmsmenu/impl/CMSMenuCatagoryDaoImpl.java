package com.beingjavaguys.dao.cmsmenu.impl;

import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.beingjavaguys.dao.cmsmenu.CMSMenuCatagoryDao;
import com.beingjavaguys.dao.core.CoreDao;
import com.beingjavaguys.models.cmsmenu.CMSMenuCatagoryData;
import com.beingjavaguys.models.user.RoleData;

@Repository("cmsMenuCatagoryDao")
public class CMSMenuCatagoryDaoImpl implements CMSMenuCatagoryDao {

	@Autowired
	CoreDao coreDao;

	@Override
	public void addCatagory(CMSMenuCatagoryData cmsMenuCatagoryData,HttpServletResponse response) {

		
		//RoleData roleData = null;
		
		String getCatagory = "select count(C) from CMSMenuCatagoryData C where C.name=:name";
		
		Session session = null;
		Query query = null;
		try {
			session = coreDao.getSession();
			session.beginTransaction();
			query = session.createQuery(getCatagory);
			query.setParameter("name", cmsMenuCatagoryData.getName());
			
			Long count = (Long) query.uniqueResult();
			
			if(count==0){
				session.saveOrUpdate(cmsMenuCatagoryData);
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

}
