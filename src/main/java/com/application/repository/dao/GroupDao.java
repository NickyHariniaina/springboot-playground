package com.application.repository.dao;

import com.application.model.Group;
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
public class GroupDao {

  private EntityManager entityManager;

  public List<Group> findByCriteria(String id, String name, String ref, String attributedColor) {
    CriteriaBuilder builder = entityManager.getCriteriaBuilder();
    CriteriaQuery<Group> query = builder.createQuery(Group.class);
    Root<Group> root = query.from(Group.class);

    Predicate idPredicate = builder.equal(root.get("id"), id);
    Predicate namePredicate = builder.like(builder.lower(root.get("name")), name);
    Predicate refPredicate = builder.equal(root.get("ref"), ref);
    Predicate aPredicate = builder.equal(root.get("attributedColor"), attributedColor);

    query.select(root).where(idPredicate, namePredicate, refPredicate, aPredicate).distinct(true);

    return entityManager.createQuery(query).getResultList();
  }
}
