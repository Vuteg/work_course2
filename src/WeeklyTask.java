import java.time.LocalDateTime;

public class WeeklyTask extends Task implements Repeatable{
    public WeeklyTask(String title, String description, LocalDateTime dateTime, Type type) throws IncorrectArgumentException{
        super(title, description, dateTime, type);
    }

    @Override
    public boolean checkEntry(LocalDateTime date) {
        return getDateTime().getDayOfWeek().equals(date.getDayOfWeek());
    }
}
