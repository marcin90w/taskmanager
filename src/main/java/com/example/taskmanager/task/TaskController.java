package com.example.taskmanager.task;

import org.springframework.stereotype.Controller;

@Controller
public class TaskController {

    TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
}
