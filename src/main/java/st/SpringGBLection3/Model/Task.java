package st.SpringGBLection3.Model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class Task {
    public enum Status {
        TO_DO,
        IN_PROGRESS,
        DONE
    }

    private UUID id;
    private String name;
    private String description;
    private Status status;
    private LocalDateTime completionTime;

    public Task(String name, String description) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.description = description;
    }
}