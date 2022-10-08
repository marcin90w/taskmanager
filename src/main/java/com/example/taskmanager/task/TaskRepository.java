package com.example.taskmanager.task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Long> {

    List<TaskEntity> findByDeadlineBeforeOrTaskDoneOrderByDeadlineAsc(LocalDate today, Boolean done);

    List<TaskEntity> findByTaskDoneOrderByDeadlineAsc(Boolean doneOrNot);

    List<TaskEntity> findByCategoryId(Long id);
}
