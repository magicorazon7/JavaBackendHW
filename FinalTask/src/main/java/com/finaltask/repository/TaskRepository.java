package com.finaltask.repository;

import com.finaltask.model.Task;
import com.finaltask.model.TaskGroup;
import com.finaltask.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByUser(User user);
    List<Task> findByUserAndGroup(User user, TaskGroup group);

    // JPQL запрос для статистики по статусам задач
    @Query("SELECT t.status as status, COUNT(t) as count FROM Task t WHERE t.user = :user GROUP BY t.status")
    List<Map<String, Object>> getTaskStatisticsByStatus(User user);

    // JPQL запрос для статистики по группам задач
    @Query("SELECT COALESCE(g.name, 'Без группы') as groupName, COUNT(t) as count " +
            "FROM Task t LEFT JOIN t.group g WHERE t.user = :user GROUP BY g.name")
    List<Map<String, Object>> getTaskStatisticsByGroup(User user);
}