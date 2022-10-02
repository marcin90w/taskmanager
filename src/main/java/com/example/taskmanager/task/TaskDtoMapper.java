package com.example.taskmanager.task;

import org.springframework.stereotype.Service;

@Service
public class TaskDtoMapper {

    public TaskDto map(TaskEntity taskEntity) {
        TaskDto dto = new TaskDto();
        dto.setId(taskEntity.getId());
        dto.setCategory(taskEntity.getCategory());
        dto.setDescription(taskEntity.getDescription());
        dto.setDateOfSetup(taskEntity.getDateOfSetup());
        dto.setDeadline(taskEntity.getDeadline());
        dto.setTaskDone(taskEntity.getTaskDone());
        dto.setTaskDoneDate(taskEntity.getTaskDoneDate());
        return dto;
    }
}
