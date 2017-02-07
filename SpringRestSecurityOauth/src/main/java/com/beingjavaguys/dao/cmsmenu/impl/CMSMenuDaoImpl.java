package com.beingjavaguys.dao.cmsmenu.impl;

import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.beingjavaguys.dao.cmsmenu.CMSMenuDao;
import com.beingjavaguys.dao.core.CoreDao;
import com.beingjavaguys.models.cmsmenu.CMSMenuData;

@Repository("cmsMenuDao")
public class CMSMenuDaoImpl implements CMSMenuDao {

	@Autowired
	CoreDao coreDao;

	@Override
	public void addMenu(CMSMenuData cmsMenuData, HttpServletResponse response) {

		String getMenu = "select count(M) from CMSMenuData M where M.itemName=:itemName";

		Session session = null;
		Query query = null;
		try {
			session = coreDao.getSession();
			session.beginTransaction();
			query = session.createQuery(getMenu);
			query.setParameter("itemName", cmsMenuData.getItemName());

			Long count = (Long) query.uniqueResult();

			if (count == 0) {
				session.saveOrUpdate(cmsMenuData);
				session.getTransaction().commit();
				response.setStatus(200);// for OK
			} else {
				response.setStatus(402);// for already exists
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

}
