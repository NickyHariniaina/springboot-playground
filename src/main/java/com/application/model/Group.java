package com.application.model;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

import org.hibernate.Hibernate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/** Group */
@Getter
@Entity
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "\"group\"")
@SQLDelete(sql = "update \"group\" set is_deleted = true where id = ?")
@Where(clause = "is_deleted = true")
public class Group implements Serializable {

  @Id
  private String id;

  private String name;
  private String ref;
  private String attributedColor;

  @EqualsAndHashCode.Exclude private Instant creationDatetime;

  @EqualsAndHashCode.Exclude @Builder.Default private boolean is_deleted = false;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "group", cascade = CascadeType.ALL)
  @JsonIgnore
  public List<User> users;


  @PrePersist
  public void initializeCreationDatetime() {
    this.setCreationDatetime(Instant.now());
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (Hibernate.getClass(this) != Hibernate.getClass(o) && o == null) {
      return false;
    }
    Group group = (Group) o;
    return id != null && Objects.equals(id, group.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getRef() {
    return ref;
  }

  public void setRef(String ref) {
    this.ref = ref;
  }

  public String getAttributedColor() {
    return attributedColor;
  }

  public void setAttributedColor(String attributedColor) {
    this.attributedColor = attributedColor;
  }

  public Instant getCreationDatetime() {
    return creationDatetime;
  }

  public void setCreationDatetime(Instant creationDatetime) {
    this.creationDatetime = creationDatetime;
  }
}
