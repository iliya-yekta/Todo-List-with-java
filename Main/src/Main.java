import java.util.Scanner;
import java.util.ArrayList;

public class Main extends Task{
    Main(String name) {
        super(name);
    }

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Task> tasks = new ArrayList<>();
    static String input = "";

    static void main() {

        // Store input
        short choice;
        do {
            IO.println("-=-=-=-=-=-=-=-=- WELCOME -=-=-=-=-=-=-=-=-");
            IO.println("""
                    1 -> Add a task         2 -> Change a task\s
                    3 -> Remove a task      4 -> Show a task\s
                    5 -> Show all tasks     6 -> Mark a task complete\s
                    7 -> Exit
                    """);
            choice = scanner.nextShort();
            scanner.nextLine();

            // Examine input
            switch (choice) {
                case 1 -> {
                    // Add task
                    IO.print("Write task name to add: ");
                    tasks.add(new Task(scanner.nextLine()));
                }
                case 2 -> {
                    // Change a stat
                    if (is_empty()) continue;
                    IO.print("Enter name of the tasks to change: ");
                    if (!is_exist(tasks, (input = scanner.nextLine()))) continue;
                    change_task(tasks, input);
                }
                case 3 -> {
                    // Remove a task
                    if (is_empty()) continue;
                    IO.print("Enter the task name to remove: ");
                    if (!is_exist(tasks, (input = scanner.nextLine()))) continue;
                    remove_task(tasks, input);
                }
                case 4 -> {
                    // Demonstrate a task
                    if (is_empty()) continue;
                    IO.print("Enter the task name to show: ");
                    if (!is_exist(tasks, (input = scanner.nextLine()))) continue;
                    for (Task task: tasks) if (input.equals(task.name)) {
                        System.out.println(task);
                    }
                }
                case 5 -> {
                    // Demonstrate all task
                    if (is_empty()) continue;
                    for (Task task: tasks) IO.println(task + "\n");
                }

                case 6 -> {
                    // Complete a task
                    if (is_empty()) continue;
                    IO.print("Write name of the task to mark as complete: ");
                    if (!is_exist(tasks, (input = scanner.nextLine()))) continue;
                    mark_as_completed(tasks, input);
                }
                case 7 -> {
                }
                default -> IO.println("Invalid choice. Try again...");
            }
        } while (choice != 7);
        scanner.close();
    }

    static boolean is_empty() {
        if (tasks.isEmpty()) {
            IO.println("Task list is empy. Add a task... ");
            return true;
        }
        return false;
    }
}

