import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Task {
    private String title;
    private String description;
    private LocalDateTime dateTime;

    private boolean archived;
    private final int id;
    private static int idGenerator = 1;
    private Type type;

    public Task(String title, String description, LocalDateTime dateTime, int id, Type type) throws RuntimeException {
        this.title = ValidateUtils.checkString(title);
        this.description = ValidateUtils.checkString(description);
        this.dateTime = dateTime;
        this.id = idGenerator;
        idGenerator++;
        this.type = type;
    }

    public String getTitle() {return title;}

    public void setTitle(String title) {this.title = title;}

    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}

    public boolean isArchived() {return archived;}

    public void setArchived(boolean archived) {this.archived = archived;}

    public LocalDateTime getDateTime() {return dateTime;}

    public int getId() {return id;}

    public Type getType() {return type;}

    public void setType(Type type) {this.type = type;}

    public void setDateTime(LocalDateTime dateTime) {this.dateTime = dateTime;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return archived == task.archived && id == task.id && Objects.equals(title, task.title) && Objects.equals(description, task.description) && Objects.equals(dateTime, task.dateTime) && type == task.type;
    }

    @Override
    public int hashCode() {return Objects.hash(title, description, dateTime, archived, id, type);}

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", dateTime=" + dateTime +
                ", archived=" + archived +
                ", id=" + id +
                ", type=" + type +
                '}';
    }
}
