package com.finaltask.service;

import com.finaltask.model.TaskGroup;
import com.finaltask.model.User;
import com.finaltask.repository.TaskGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskGroupService {

    private final TaskGroupRepository taskGroupRepository;

    public List<TaskGroup> getGroupsByUser(User user) {
        return taskGroupRepository.findByUser(user);
    }

    public TaskGroup createGroup(String name, User user) {
        TaskGroup group = TaskGroup.builder()
                .name(name)
                .user(user)
                .build();
        return taskGroupRepository.save(group);
    }

    public TaskGroup updateGroup(Long id, String name, User user) {
        TaskGroup group = taskGroupRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Group not found with id: " + id));

        if (!group.getUser().getId().equals(user.getId())) {
            throw new RuntimeException("You don't have permission to update this group");
        }

        group.setName(name);
        return taskGroupRepository.save(group);
    }

    public void deleteGroup(Long id, User user) {
        TaskGroup group = taskGroupRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Group not found with id: " + id));

        if (!group.getUser().getId().equals(user.getId())) {
            throw new RuntimeException("You don't have permission to delete this group");
        }

        taskGroupRepository.delete(group);
    }
}