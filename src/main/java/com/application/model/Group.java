package com.application.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/** Group */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "\"group\"")
@SQLDelete(sql = "update \"group\" set is_deleted = true where id = ?")
@Where(clause = "is_deleted = true")
public class Group implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String id;

  private String name;
  private String ref;
  private String attributedColor;

  @EqualsAndHashCode.Exclude private Instant creationDatetime;

  @EqualsAndHashCode.Exclude @Builder.Default private boolean is_deleted = false;

  @PrePersist
  public void initializeCreationDatetime(Group group) {
    group.setCreationDatetime(Instant.now());
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
