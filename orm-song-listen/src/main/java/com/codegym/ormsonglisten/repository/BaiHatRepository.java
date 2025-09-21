package com.codegym.ormsonglisten.repository;

import com.codegym.ormsonglisten.model.BaiHat;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BaiHatRepository {
    @Autowired
    private static EntityManager entityManager;
    private static SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.conf.xml")
                    .buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    public List<BaiHat> findAll() {
        return entityManager.createQuery("SELECT b FROM BaiHat b", BaiHat.class).getResultList();
    }

    @Transactional
    public void save(BaiHat baihat) {
//        if (baihat.getId() == null) {
//            entityManager.persist(baihat);
//        } else {
//            entityManager.merge(baihat);
//        }
        Transaction transaction = null;
        BaiHat origin;
        if (baihat.getId() == null) {
            origin = new BaiHat();
        } else {
            origin = findById(baihat.getId());
        }
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            origin.setTenBaiHat(baihat.getTenBaiHat());
            origin.setTheLoai(baihat.getTheLoai());
            origin.setNgheSi(baihat.getNgheSi());
            if (baihat.getFileBaiHat() != null && !baihat.getFileBaiHat().isEmpty()) {
                origin.setFileBaiHat(baihat.getFileBaiHat());
            }
            session.saveOrUpdate(origin);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public BaiHat findById(Long id) {
        return entityManager.find(BaiHat.class, id);
    }

    public void delete(Long id) {
        Transaction transaction = null;
        BaiHat baihat = findById(id);
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.remove(baihat);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}
