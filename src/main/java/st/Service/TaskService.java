package st.Service;

import org.springframework.stereotype.Service;
import st.Model.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TaskService {
    private final List<Task> tasks = new ArrayList<>();

    public List<Task> getAllTasks() {
        return tasks;
    }

    public Task getTask(UUID uuid) {
        return tasks.stream().filter(t -> t.getId().equals(uuid)).findFirst().orElse(null);
    }

    public Task addTask(Task task) {
        tasks.add(task);
        return task;
    }

    public void removeTask(UUID uuid) {
        tasks.removeIf(t -> t.getId().equals(uuid));
    }

    public Task updateTask(UUID uuid, Task task) {
        Task taskRequiresUpdate = getTask(uuid);
        if (task != null) {
            taskRequiresUpdate.setDescription(task.getDescription());
            taskRequiresUpdate.setName(task.getName());
            taskRequiresUpdate.setStatus(task.getStatus());
            taskRequiresUpdate.setCompletionTime(task.getCompletionTime());
        }
        return taskRequiresUpdate;
    }
}