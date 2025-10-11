package com.todolist.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/** TodoModel */
@Entity
@Table(name = "todo")
public class TodoModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(nullable = false, unique = true, length = 50)
  private String title;

  @Column(nullable = true, unique = false)
  private String description;

  private boolean completed;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = UserModel.class)
  private int userId;

  public TodoModel(String title, String description, boolean completed, int userId) {
    this.title = title;
    this.description = description;
    this.completed = completed;
    this.userId = userId;
  }

  public TodoModel() {}

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public boolean isCompleted() {
    return completed;
  }

  public void setCompleted(boolean completed) {
    this.completed = completed;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }
}
