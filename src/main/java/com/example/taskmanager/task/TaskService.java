package com.example.taskmanager.task;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

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

    public String updateOrSaveTask(TaskDto taskDto) {
        if (taskDto.getDeadline() == null) {
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
        taskEntity.setDateOfSetup(taskDto.getDateOfSetup());
        taskEntity.setDescription(taskDto.getDescription());
        taskEntity.setTaskDone(taskDto.getTaskDone());
        taskEntity.setTaskDoneDate(taskDto.getTaskDoneDate());
        taskRepository.save(taskEntity);
    }

    private void setTaskDone(Long id) {
        TaskEntity task = taskRepository.findById(id).get();
        task.setTaskDone(true);
        task.setTaskDoneDate(LocalDate.now());
        taskRepository.save(task);
    }
}
