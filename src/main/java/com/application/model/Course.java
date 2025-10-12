package com.application.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/** Course */
@Entity
@Table(name = "\"course\"")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Getter
@Setter
@EqualsAndHashCode
@SQLDelete(sql = "update \"course\" set is_deleted = true where id = ?")
@Where(clause = "is_deleted = true")
public class Course implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String id;

  private String code;

  private String name;

  private Integer credits;

  private Integer totalHours;

  @EqualsAndHashCode.Exclude @Builder.Default private boolean is_deleted = false;

  @OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
  @ToString.Exclude
  private List<User> students;

}







