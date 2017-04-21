package com.example.database;


import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

import org.apache.catalina.User;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import javax.persistence.criteria.CriteriaQuery;

@Component
public class DBManager {

    private SessionFactory factory;

    /* Method to  READ all the employees */
    public List<UsersEntity> listUsers() {
        Session session = getSession();
        Transaction tx = null;
        List<UsersEntity> users = new ArrayList();
        try {
            tx = session.beginTransaction();
    /*          session.createQuery("FROM UsersEntity").list()*/
                users = session.createCriteria(UsersEntity.class).list();

            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return users;
    }

    public List<TimestampsEntity> listTimes() {
        Session session = getSession();
        Transaction tx = null;
        List<TimestampsEntity> times = new ArrayList();
        try {
            tx = session.beginTransaction();
            times = session.createQuery("FROM TimestampsEntity ").list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return times;
    }

    public List<TimestampsEntity> getTimesFromUser(int id) {
        Session session = getSession();
        Transaction tx = null;
        List<TimestampsEntity> times = new ArrayList();
        try {
            tx = session.beginTransaction();

            Criteria crit = session.createCriteria(TimestampsEntity.class);
            crit.add(Restrictions.eq("userId", id));
            times = crit.list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return times;
    }

    public void createTimeStamp(int userId) {
        Session session = getSession();
        Transaction tx = null;
        List<TimestampsEntity> times = new ArrayList();
        try {
            tx = session.beginTransaction();

            TimestampsEntity timestamp = new TimestampsEntity();
            timestamp.setUserId(3);
            timestamp.setStartdate(Timestamp.valueOf(LocalDateTime.now()));
            session.save("TimestampsEntity", timestamp);

            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    private Session getSession() {
        if(factory == null) {
            try {
                factory = new Configuration().configure().buildSessionFactory();
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return factory.openSession();
    }


}




