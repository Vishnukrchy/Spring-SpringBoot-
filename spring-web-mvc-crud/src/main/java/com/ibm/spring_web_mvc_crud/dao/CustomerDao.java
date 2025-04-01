package com.ibm.spring_web_mvc_crud.dao;

import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.ibm.spring_web_mvc_crud.dto.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

@Repository
public class CustomerDao {

	EntityManager em = Persistence.createEntityManagerFactory("mvc").createEntityManager();
	EntityTransaction et = em.getTransaction();

	public User saveUserDao(User user) {

		et.begin();
		em.persist(user);
		et.commit();

		return user;
	}

	public List<User> getAllUserDetailsDao() {
		List<User> users = em.createQuery("from User").getResultList();

		return users.stream()
				.map(user -> new User(user.getId(), user.getName(), user.getEmail(), encodeImageDao(user.getImage())))
				.collect(Collectors.toList());
	}

	public String encodeImageDao(byte[] image) {
		return Base64.getEncoder().encodeToString(image);
	}

	public boolean deleteUserByIdDao(int id) {
		try {
			User user = em.find(User.class, id);
			if (user != null) {
				et.begin();
				em.remove(user);
				et.commit();
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {

			return false;
		}
	}

	public User fetchUserByIdDao(int id) {
		return em.find(User.class, id);
	}

	public void updateUserDao(User user1) {
		et.begin();
		em.merge(user1);
		et.commit();
	}
}
