package com.nisum.manage.users.repository.impl;

import com.nisum.manage.users.entity.Phone;
import com.nisum.manage.users.entity.User;
import com.nisum.manage.users.repository.UserRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User addUser(User user) {
        try{
            System.out.println("Session created");
            Session session = sessionFactory.getCurrentSession();
            // start transaction
            Transaction tx = session.beginTransaction();
            session.save(user);
            for (Phone phone: user.getPhones()) {
                session.save(phone);
            }
            tx.commit();
            System.out.println("User ID=" + user.getId());
        } catch (Exception e) {
            System.out.println("Exception occurred. " + e.getMessage());
            e.printStackTrace();
        }

        return user;

    }

    @Override
    public List<User> getUsers() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> criteria = builder.createQuery(User.class);
        Root<User> myObjectRoot = criteria.from(User.class);
        criteria.select(myObjectRoot);
        TypedQuery<User> query = session.createQuery(criteria);
        return query.getResultList();
    }

    @Override
    public User findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.get(User.class, id);
        return user;
    }

    @Override
    public User update(User user, int id) {
        Session session = sessionFactory.getCurrentSession();
        User userToUpdate = findById(id);
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setPassword(user.getPassword());
        session.update(userToUpdate);
        return userToUpdate;
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        User userToDelete = findById(id);
        session.delete(userToDelete);
    }
}
