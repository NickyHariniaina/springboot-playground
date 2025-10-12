package com.application.model;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;
import org.hibernate.type.SqlTypes;

@Entity
@Builder
@Table(name = "\"user\"")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@SQLDelete(sql = "update \"user\" set is_deleted = true where id = ?")
@Where(clause = "is_deleted = false")
public class User implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String id;

  @NotBlank(message = "firstname is mandatory.")
  private String firstname;

  private String lastname;

  @NotBlank(message = "reference is mandatory.")
  private String ref;

  private String phone;

  @NotBlank(message = "email is mandatory.")
  @Email(message = "email must be valid.")
  private String email;

  @EqualsAndHashCode.Exclude @Builder.Default private boolean isDeleted = false;

  private LocalDate birthDate;

  @CreationTimestamp private Instant creationDatetime;

  @UpdateTimestamp private Instant lastUpdateDatetime;

  @ManyToOne
  @JoinColumn(name = "course_id")
  private Course course;

  private Double longitude;
  private Double latitude;

  @Enumerated(EnumType.STRING)
  @JdbcTypeCode(SqlTypes.NAMED_ENUM)
  private Status status;

  @Enumerated(EnumType.STRING)
  @JdbcTypeCode(SqlTypes.NAMED_ENUM)
  private Sex sex;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
      return false;
    }
    User user = (User) o;
    return id != null && Objects.equals(id, user.id);
  }

  public enum Sex {
    M,
    F
  }

  public enum Status {
    ENABLED,
    DISABLED,
    SUSPENDED
  }
}
