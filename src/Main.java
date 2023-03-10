import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        getScan(scanner);















    }
public static void getScan(Scanner scan) {

    try {
        while (true) {
            System.out.println("Выберите пункт меню");
            printMenu();
            if (scan.hasNextLine()) {
                int menu = scan.nextInt();
                switch (menu) {
                    case 1 -> {
                        TaskService.addTask(scan);
                        break;
                    }
                    case 2 -> {
                        TaskService.deleteTask(scan);
                        break;
                    }
                    case 3 -> {
                        TaskService.getTaskOrDay(scan);
                        break;
                    }
                    case 4 -> {
                        TaskService.printActualTask();
                        break;
                    }
                    case 5 -> {
                        TaskService.printPastTask();
                        break;
                    }
                    case 6 -> {
                        break;
                    }
                }
            } else {
                scan.next();
                System.out.println("Выберите пункт меню");
            }
        }

    } catch (IncorrectArgumentException e) {
        System.err.println("некоректный ввод, попробуйте снова");
        getScan(scan);
    } catch (ArrayIndexOutOfBoundsException a) {
        System.err.println("некоректный ввод, попробуйте снова");
        getScan(scan);
    } catch (InputMismatchException b) {
        System.err.println("некоректный ввод, перезапусти программу");
    }

}
    private static void printMenu() {
        System.out.println(" \n" +
                "  1. Добавить задачу \n" +
                "  2. Удалить задачу \n" +
                "  3. Посмотреть задачу на указанную дату \n" +
                "  4. Посмотреть список актуальных задач \n" +
                "  5. Посмотреть список архивных задач \n" +
                "  6. Выход");
    }
}
