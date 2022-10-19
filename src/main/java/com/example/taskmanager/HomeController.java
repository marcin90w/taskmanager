package com.example.taskmanager;

import com.example.taskmanager.category.CategoryService;
import com.example.taskmanager.task.TaskService;
import com.example.taskmanager.user.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private CategoryService categoryService;
    private TaskService taskService;

    public HomeController(CategoryService categoryService, TaskService taskService) {
        this.categoryService = categoryService;
        this.taskService = taskService;
    }

/*    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("categories", categoryService.getCategoryList());
        model.addAttribute("tasks", taskService.findAll());
        return "home";
    }*/

    @GetMapping("")
    public String homepage(Model model) {
        model.addAttribute("user", new User());
        return "main";
    }
}
