import java.time.LocalDate;
import java.time.LocalDateTime;

public class OneTimeTask extends Task implements Repeatable{
    public OneTimeTask(String title, String description, LocalDateTime dateTime, Type type)throws IncorrectArgumentException {
        super(title, description, dateTime, type);
    }

    @Override
    public boolean checkEntry(LocalDateTime date) {
        return getDateTime().toLocalDate().equals(date.toLocalDate());
    }
}
