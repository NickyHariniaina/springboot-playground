package com.application.repository.dao;

import com.application.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class UserDao {

  private EntityManager entityManager;

  public List<User> findByCriteria(
      User.Status status,
      User.Sex sex,
      String username,
      String email,
      String ref,
      String firstname,
      String lastname) {

    CriteriaBuilder builder = entityManager.getCriteriaBuilder();
    CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);
    Root<User> root = criteriaQuery.from(User.class);

    Predicate statusPredicate = builder.equal(root.get("status"), status);
    Predicate sexPredicate = builder.equal(root.get("sex"), sex);
    Predicate usernamePredicate = builder.equal(root.get("username"), username);
    Predicate emailPredicate = builder.equal(root.get("email"), email);
    Predicate refPredicate = builder.equal(root.get("ref"), ref);
    Predicate firstnamePredicate = builder.equal(root.get("firstname"), firstname);
    Predicate lastnamePredicate = builder.equal(root.get("lastname"), lastname);

    criteriaQuery
        .select(root)
        .where(
            statusPredicate,
            sexPredicate,
            usernamePredicate,
            emailPredicate,
            refPredicate,
            firstnamePredicate,
            lastnamePredicate)
        .distinct(true);

    return entityManager.createQuery(criteriaQuery).getResultList();
  }
}
