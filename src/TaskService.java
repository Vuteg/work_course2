import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TaskService {

    private static final Map<Integer, Repeatable> actualTask = new HashMap<>();
    private static final Map<Integer, Repeatable> pastTask = new HashMap<>();

    public static void addTask(Scanner scanner) {

            scanner.nextLine();
            System.out.println("Введите заголовок");
            String title = ValidateUtils.checkString(scanner.nextLine());
            System.out.println("Введите описание");
            String description = ValidateUtils.checkString(scanner.nextLine());
            System.out.println("Введите тип задачи (работа) - (личное)");
            Type type = Type.valueOf(scanner.nextLine());


    }



}
