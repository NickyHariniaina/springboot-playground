package com.application.model;

import java.time.Instant;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Grade
 */
@Entity
@Table(name = "\"grade\"")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Grade {

  @Id
  private String id;

  @ManyToOne
  @JoinColumn(name = "student_id", updatable = false)
  private User user;

  @Column(updatable = false)
  @CreationTimestamp
  @EqualsAndHashCode.Exclude
  private Instant creationDatetime;

}









