package com.ahmedSamir.ToDoApp.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id).get();
    }

    public void createTask(Task task) {
        taskRepository.save(task);
    }

    public void updateTask(Long id, Task taskDetails) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Todo not found"));
        task.setTitle(taskDetails.getTitle());
        task.setDescription(taskDetails.getDescription());
        task.setStart_date(taskDetails.getStart_date());
        task.setFinish_date(taskDetails.getFinish_date());
        task.setCompleted(taskDetails.isCompleted());
        taskRepository.save(task);
    }

    public void completeTask(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Todo not found"));
        task.setCompleted(true);
        taskRepository.save(task);
    }

    public void unCompleteTask(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Todo not found"));
        task.setCompleted(false);
        taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
