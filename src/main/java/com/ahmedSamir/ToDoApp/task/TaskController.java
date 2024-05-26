package com.ahmedSamir.ToDoApp.task;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

//    @Autowired
//    private GoogleCalendarService googleCalendarService;


    @GetMapping
    public String getAllTasks(Model model) {
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "task";
    }
//    @GetMapping
//    public String getAllTasks(@RegisteredOAuth2AuthorizedClient("google") OAuth2AuthorizedClient authorizedClient, Model model) throws GeneralSecurityException, IOException {
//        List<Task> tasks = taskService.getAllTasks();
//        model.addAttribute("tasks", tasks);
//
//        List<Event> events = googleCalendarService.getUpcomingEvents(authorizedClient);
//        model.addAttribute("events", events);
//
//        return "task";
//    }

    @GetMapping("/{id}")
    public String getTaskById(@PathVariable Long id, Model model) {
        Task task = taskService.getTaskById(id);
        model.addAttribute("task", task);
        return "task-detail";
    }

    @GetMapping("/new")
    public String createTaskForm(Model model) {
        model.addAttribute("task", new Task());
        return "task-form";
    }

    @PostMapping
    public String createTask(@Valid @ModelAttribute Task task , BindingResult result)
            throws GeneralSecurityException, IOException {
        if (result.hasErrors()){
            return "task-form";
        }
        taskService.createTask(task);
        return "redirect:/tasks";
    }

    @GetMapping("/edit/{id}")
    public String updateTaskForm(@PathVariable Long id, Model model) {
        Task task = taskService.getTaskById(id);
        model.addAttribute("task", task);
        return "task-form";
    }

    @PutMapping("/update/{id}")
    public String updateTask(@PathVariable Long id, @ModelAttribute Task taskDetails) {
        taskService.updateTask(id, taskDetails);
        return "redirect:/tasks";
    }

    @GetMapping("/complete/{id}")
    public String completeTask(@PathVariable Long id) {
        taskService.completeTask(id);
        return "redirect:/tasks";
    }

    @GetMapping("/unComplete/{id}")
    public String unCompleteTask(@PathVariable Long id) {
        taskService.unCompleteTask(id);
        return "redirect:/tasks";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "redirect:/tasks";
    }
}
