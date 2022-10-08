package com.example.taskmanager.task;

import com.example.taskmanager.category.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TaskController {

    private TaskService taskService;
    private CategoryService categoryService;

    public TaskController(TaskService taskService, CategoryService categoryService) {
        this.taskService = taskService;
        this.categoryService = categoryService;
    }

    @GetMapping("/task/archive")
    public String taskArchive(Model model) {
        model.addAttribute("categories", categoryService.getCategoryList());
        model.addAttribute("tasks", taskService.findDoneOrExpiredTasks());
        return "archive-tasks";
    }

    @GetMapping("/task/archive-done")
    public String taskArchiveDone(Model model) {
        model.addAttribute("categories", categoryService.getCategoryList());
        model.addAttribute("tasks", taskService.findDoneTasks());
        return "archive-tasks";
    }

    @GetMapping("/category/{id}")
    public String tasksByCategory(@PathVariable Long id, Model model) {
        model.addAttribute("categories", categoryService.getCategoryList());
        model.addAttribute("tasks", taskService.findAllByCategoryId(id));
        return "task-by-category";
    }

    @GetMapping("/task/add")
    public String taskForm(Model model) {
        TaskDto taskDto = new TaskDto();
        model.addAttribute("categories", categoryService.getCategoryList());
        model.addAttribute("taskToEdit", taskDto);
        return "task-form";
    }

    @GetMapping("/edit")
    public String editTask(@RequestParam Long id, Model model) {
        TaskDto taskDto = taskService.findTaskById(id);
        if (taskDto == null) {
            return "error";
        } else {
            model.addAttribute("taskToEdit", taskService.findTaskById(id));
            model.addAttribute("categories", categoryService.getCategoryList());
            return "task-form";
        }
    }

    @PostMapping("/edit-or-add")
    public String edit(TaskDto taskDto, Model model) {
        model.addAttribute("categories", categoryService.getCategoryList());
        model.addAttribute("taskToEdit", taskDto);
        String attribute = taskService.updateOrSaveTask(taskDto);
        model.addAttribute("info", attribute);
        return "addOrEditSuccess";
        }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id, Model model) {
        if (id > taskService.tasksListSize()) {
            return "error";
        } else {
            model.addAttribute("categories", categoryService.getCategoryList());
            taskService.deleteTaskById(id);
            model.addAttribute("info", "Usunięto zadanie o id: " + id + ".");
            return "addOrEditSuccess";
        }
    }
}
