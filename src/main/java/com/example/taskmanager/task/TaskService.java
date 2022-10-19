package com.example.taskmanager.task;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {

    TaskRepository taskRepository;
    TaskDtoMapper taskDtoMapper;

    public TaskService(TaskRepository taskRepository, TaskDtoMapper taskDtoMapper) {
        this.taskRepository = taskRepository;
        this.taskDtoMapper = taskDtoMapper;
    }

    public TaskDto findTaskById(Long id) {
        return taskRepository.findById(id)
                .map(taskDtoMapper::map)
                .get();
    }

    public void deleteTaskById(Long id) {
        taskRepository.deleteById(id);
    }

    public Long tasksListSize() {
        return taskRepository.count();
    }

    public String updateOrSaveTask(TaskDto taskDto) {
        if (taskDto.getDateOfSetup() == null) {
            setTask(taskDto, new TaskEntity());
            return "Dodawanie nowego zadania zakończone sukcesem";
        } else {
            TaskEntity task = taskRepository.findById(taskDto.getId()).get();
            setTask(taskDto, task);
            return "Edycja zadania zakończona sukcesem";
        }
    }

    private void setTask(TaskDto taskDto, TaskEntity taskEntity) {
        taskEntity.setId(taskDto.getId());
        taskEntity.setCategory(taskDto.getCategory());
        taskEntity.setDeadline(taskDto.getDeadline());
        if (taskDto.getDateOfSetup() == null) {
            taskEntity.setDateOfSetup(LocalDate.now());
        } else {
            taskEntity.setDateOfSetup(taskDto.getDateOfSetup());
        }
        taskEntity.setDescription(taskDto.getDescription());
        if (taskDto.getTaskDone() == Boolean.TRUE) {
            taskEntity.setTaskDone(Boolean.TRUE);
            taskEntity.setTaskDoneDate(LocalDate.now());
        }
        taskRepository.save(taskEntity);
    }

    //  Zostawiam na przyszłą rozbudowę o osobny przycisk zakańczania zadania używany w liście zadań a nie w formularzu
/*    private void setTaskDone(Long id) {
        TaskEntity task = taskRepository.findById(id).get();
        task.setTaskDone(true);
        task.setTaskDoneDate(LocalDate.now());
        taskRepository.save(task);
    }*/

    public List<TaskDto> findAll() {
        return taskRepository
                .findByTaskDoneOrderByDeadlineAsc(Boolean.FALSE)
                .stream()
                .map(taskDtoMapper::map).collect(Collectors.toList());
    }

    public List<TaskDto> findAllByCategoryId(Long id) {
        return taskRepository
                .findByCategoryId(id)
                .stream()
                .map(taskDtoMapper::map).collect(Collectors.toList());
    }

    public List<TaskDto> findDoneOrExpiredTasks() {
        return taskRepository
                .findByDeadlineBeforeOrTaskDoneOrderByDeadlineAsc(LocalDate.now(), Boolean.TRUE)
                .stream()
                .map(taskDtoMapper::map).collect(Collectors.toList());
    }

    public List<TaskDto> findDoneTasks() {
        return taskRepository
                .findByTaskDoneOrderByDeadlineAsc(Boolean.TRUE)
                .stream()
                .map(taskDtoMapper::map).collect(Collectors.toList());
    }
}
