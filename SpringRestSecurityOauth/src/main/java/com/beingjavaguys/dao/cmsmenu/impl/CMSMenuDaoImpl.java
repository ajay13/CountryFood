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
	public int addMenu(CMSMenuData cmsMenuData, HttpServletResponse response) {

		String getMenu = "select count(M) from CMSMenuData M where M.itemName=:itemName";
        int menuId = 0;
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
				menuId = cmsMenuData.getId();
				response.setStatus(200);// for OK
			} else {
				response.setStatus(402);// for already exists
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return menuId;
	}

	@Override
	public CMSMenuData getMenu(int menuId) {
		String getMenu = "select M from CMSMenuData M where M.id=:menuId";
		Session session = null;
		Query query = null;
		CMSMenuData cmsMenuData = null;
		try {
			session = coreDao.getSession();
			session.beginTransaction();
			query = session.createQuery(getMenu);
			query.setParameter("menuId", menuId);

			cmsMenuData = (CMSMenuData) query.uniqueResult();

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return cmsMenuData;
	}

	
	@Override
	public void updateMenu(CMSMenuData cmsMenuData, HttpServletResponse response) {
		Session session = null;
		try {
			session = coreDao.getSession();
			session.beginTransaction();
			session.update(cmsMenuData);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
