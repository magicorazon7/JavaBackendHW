package com.finaltask.repository;

import com.finaltask.model.TaskGroup;
import com.finaltask.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskGroupRepository extends JpaRepository<TaskGroup, Long> {
    List<TaskGroup> findByUser(User user); // получение всех групп определенного пользователя
}