import java.time.LocalDateTime;

public class MonthlyTask extends Task implements Repeatable{
    public MonthlyTask(String title, String description, LocalDateTime dateTime, int id, Type type) throws IncorrectArgumentException{
        super(title, description, dateTime, id, type);
    }
    @Override
    public boolean checkEntry(LocalDateTime date) {
        return getDateTime().getDayOfMonth() == (date.getDayOfMonth());
    }

}
