import java.time.LocalDateTime;

public class DailyTask extends Task implements Repeatable{
    public DailyTask(String title, String description, LocalDateTime dateTime, Type type)throws IncorrectArgumentException {
        super(title, description, dateTime, type);
    }


    @Override
    public boolean checkEntry(LocalDateTime date) {
        return getDateTime().toLocalDate().equals(date.toLocalDate());
    }
}
