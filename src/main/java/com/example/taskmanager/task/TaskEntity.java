package com.example.taskmanager.task;

import com.example.taskmanager.category.Category;
import com.example.taskmanager.user.User;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfSetup;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate deadline;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate taskDoneDate;
    @ManyToOne
    private Category category;
    @ManyToOne
    private User user;
    private Boolean taskDone;

    public TaskEntity() {
        dateOfSetup = LocalDate.now();
        taskDone = Boolean.FALSE;
    }

    public TaskEntity(Long id, String description, LocalDate dateOfSetup, LocalDate deadline, LocalDate taskDoneDate, Category category, Boolean taskDone, User user) {
        this.id = id;
        this.description = description;
        this.dateOfSetup = dateOfSetup;
        this.deadline = deadline;
        this.taskDoneDate = taskDoneDate;
        this.category = category;
        this.taskDone = taskDone;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateOfSetup() {
        return dateOfSetup;
    }

    public void setDateOfSetup(LocalDate dateOfSetup) {
        this.dateOfSetup = dateOfSetup;
    }

    public LocalDate getTaskDoneDate() {
        return taskDoneDate;
    }

    public void setTaskDoneDate(LocalDate taskDoneDate) {
        this.taskDoneDate = taskDoneDate;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Boolean getTaskDone() {
        return taskDone;
    }

    public void setTaskDone(Boolean taskDone) {
        this.taskDone = taskDone;
    }
}
