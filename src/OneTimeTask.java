import java.time.LocalDate;
import java.time.LocalDateTime;

public class OneTimeTask extends Task implements Repeatable{
    public OneTimeTask(String title, String description, LocalDateTime dateTime, int id, Type type)throws IncorrectArgumentException {
        super(title, description, dateTime, id, type);
    }

    @Override
    public boolean checkEntry(LocalDateTime date) {
        return getDateTime().toLocalDate().equals(date.toLocalDate());
    }
}
