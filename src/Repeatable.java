import java.time.LocalDateTime;

public interface Repeatable {

    boolean checkEntry(LocalDateTime date);

    void setTitle(String title);

    LocalDateTime getDateTime();

    void setArchived(boolean archived);
}
