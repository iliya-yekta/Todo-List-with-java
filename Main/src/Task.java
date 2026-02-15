import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Task {

    String name;
    HashMap<String, String> time = new HashMap<>();
    boolean is_completed = false;


    Task(String name) {
        this.name = name;
        this.time.put("Created", LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    }
    Task(String name, String time, String stat) {
        this.name = name;
        this.time.put("Created", time);
        this.is_completed = !stat.equals("Not completed");
    }

    // Complete task
    public static void mark_as_completed(ArrayList<Task> tasks, String input) {
        for (Task task: tasks) if (task.name.equals(input)) task.is_completed = true;
    }

    // Change a task
    public static void change_task(ArrayList<Task> task_list, String input) {
        Scanner change_input = new Scanner(System.in);

        for (Task task : task_list)
            if (task.name.equals(input)) {
                IO.print("Enter name to replace: ");
                task.name = change_input.nextLine();
            }
    }

    // Remove a task
    public static void remove_task(ArrayList<Task> task_list, String input) {
        task_list.removeIf(task -> input.equals(task.name));
    }

    // Stats of a task
    public String toString() {
        return "Stats: \nname -> " + this.name + "\nTime created -> " + this.time.get("Created") + "\nCondition -> " + (!this.is_completed ? "not completed"  : "completed");

    }

    // Check existing task name
    public static boolean is_exist(ArrayList<Task> task_list, String input) {
        boolean exist = false;

        for (Task task: task_list)
            if (task.name.equals(input)) {
                exist = true;
                break;
            }
        if (!exist) {
            IO.println("This name doesn't exist...");
            return false;
        }
        return true;
    }
}
