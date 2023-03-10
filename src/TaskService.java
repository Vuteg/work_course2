import java.sql.SQLOutput;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class TaskService {

    private static final Map<Integer, Repeatable> actualTask = new HashMap<>();
    private static final Map<Integer, Repeatable> pastTask = new HashMap<>();

    public static void addTask(Scanner scanner) {

        scanner.nextLine();
        System.out.println("Введите заголовок задачи");
        String title = ValidateUtils.checkString(scanner.nextLine());
        System.out.println("Введите описание задачи");
        String description = ValidateUtils.checkString(scanner.nextLine());
        System.out.println("Введите тип задачи: 0-рабочая, 1-личная");
        Type type = Type.values()[scanner.nextInt()];
        System.out.println("Введите повторяемость задачи: 0-одноразовая, 1-ежедневная, 2-еженедельная, 3-ежемесячная, 4-ежегодная");
        int repeatability = scanner.nextInt();
        System.out.println("Введите дату dd.MM.yyyy HH.mm");
        scanner.nextLine();
        try {
            LocalDateTime eventDate = LocalDateTime.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd.MM.yyyy HH.mm"));
            Repeatable task = null;
            task = creatTask(repeatability, title, description, type, eventDate);
            System.out.println("Создана задача" + task);
        } catch (DateTimeException d) {
            System.err.println("неверный формат даты");
        }
        System.out.println("нажмите Enter для выхода");

    }

private static Repeatable creatTask (int repeatability, String title, String description, Type type, LocalDateTime dateTime){
        return switch (repeatability){
            case 0 -> {
                OneTimeTask oneTimeTask = new OneTimeTask(title, description, dateTime, type);
                actualTask.put(oneTimeTask.getId(), oneTimeTask);
                yield  oneTimeTask;
            }
            case 1 -> {
                DailyTask dailyTask = new DailyTask(title, description, dateTime, type);
                actualTask.put(dailyTask.getId(), dailyTask);
                yield  dailyTask;
            }
            case 2 -> {
                WeeklyTask weeklyTask = new WeeklyTask(title, description, dateTime, type);
                actualTask.put(weeklyTask.getId(), weeklyTask);
                yield  weeklyTask;
            }
            case 3 -> {
                MonthlyTask monthlyTask = new MonthlyTask(title, description, dateTime, type);
                actualTask.put(monthlyTask.getId(), monthlyTask);
                yield  monthlyTask;
            }
            case 4 -> {
                YearlyTask yearlyTask = new YearlyTask(title, description, dateTime, type);
                actualTask.put(yearlyTask.getId(), yearlyTask);
                 yield  yearlyTask;
            }
            default -> null;
        };
}

    public static void printActualTask() {
        for (Repeatable task : actualTask.values()) {
            System.out.println(task);
        }
    }

    public static void printPastTask() {
        for (Repeatable task : pastTask.values()) {
            System.out.println(task);
        }
    }
    public static void deleteTask(Scanner scanner) {
        System.out.println("Текущие задачи \n");
        printActualTask();
        System.out.println("для удалени введите id задачи");
        int id = scanner.nextInt();
        if (actualTask.containsKey(id)) {
            Repeatable removedTask = actualTask.get(id);
            removedTask.setArchived(true);
            pastTask.put(id, removedTask);
            actualTask.remove(id);
            System.out.println("Задача по номеру" + id + " удалена");
        } else {
            System.out.println("Такой задачи не существует");
        }
    }

    public static List<Repeatable> findTaskOrDay(LocalDate date) {
        List<Repeatable> list = new ArrayList<>();
        for (Repeatable task : actualTask.values()) {
            if (task.checkEntry(date.atStartOfDay())) {
                list.add(task);
            }
        }
        return list;
    }
    public static void getTaskOrDay(Scanner scanner) {
        System.out.println("Введите число: dd.MM.yyyy");
        try {
            String date = scanner.next();
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalDate localDate = LocalDate.parse(date, dateTimeFormatter);
            List<Repeatable> repeatableList = findTaskOrDay(localDate);
            System.out.println("событие на " + localDate);
            for (Repeatable task : repeatableList) {
                System.out.println(task);
            }
        } catch (DateTimeException d) {
            System.err.println("неправельный формат даты");
        }
        scanner.nextLine();
    }
}
