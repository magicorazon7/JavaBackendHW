package com.finaltask.controller;

import com.finaltask.model.Task;
import com.finaltask.model.TaskStatus;
import com.finaltask.model.User;
import com.finaltask.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @GetMapping // получить задачи пользователя
    public ResponseEntity<List<Task>> getAllTasks(@AuthenticationPrincipal User user) {
        return ResponseEntity.ok(taskService.getTasksByUser(user));
    }

    @GetMapping("/group/{groupId}") // получить задачи группы
    public ResponseEntity<List<Task>> getTasksByGroup(
            @PathVariable Long groupId,
            @AuthenticationPrincipal User user) {
        return ResponseEntity.ok(taskService.getTasksByGroup(user, groupId));
    }

    @PostMapping // создание задачм
    public ResponseEntity<Task> createTask(
            @RequestParam String title,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) Long groupId,
            @AuthenticationPrincipal User user) {
        return ResponseEntity.ok(taskService.createTask(title, description, groupId, user));
    }

    @PutMapping("/{id}") // обновление задачи
    public ResponseEntity<Task> updateTask(
            @PathVariable Long id,
            @RequestParam String title,
            @RequestParam(required = false) String description,
            @RequestParam TaskStatus status,
            @RequestParam(required = false) Long groupId,
            @AuthenticationPrincipal User user) {
        return ResponseEntity.ok(taskService.updateTask(id, title, description, status, groupId, user));
    }

    @PutMapping("/{id}/status") // обновить статус задачи
    public ResponseEntity<Task> updateTaskStatus(
            @PathVariable Long id,
            @RequestParam TaskStatus status,
            @AuthenticationPrincipal User user) {
        return ResponseEntity.ok(taskService.updateTaskStatus(id, status, user));
    }

    @DeleteMapping("/{id}") // удалить задачу
    public ResponseEntity<Void> deleteTask(
            @PathVariable Long id,
            @AuthenticationPrincipal User user) {
        taskService.deleteTask(id, user);
        return ResponseEntity.noContent().build();
    }
}