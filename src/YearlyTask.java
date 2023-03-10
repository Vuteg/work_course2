import java.time.LocalDateTime;

public class YearlyTask extends Task implements Repeatable{
    public YearlyTask(String title, String description, LocalDateTime dateTime, Type type) throws IncorrectArgumentException{
        super(title, description, dateTime, type);
    }
    @Override
    public boolean checkEntry(LocalDateTime date) {
        return getDateTime().getYear() == date.getYear();
    }

}
