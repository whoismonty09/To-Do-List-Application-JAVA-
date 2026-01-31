import java.util.ArrayList;
import java.util.Scanner;

class Task {
    String title;
    boolean isCompleted;

    Task(String title) {
        this.title = title;
        this.isCompleted = false;
    }

    void displayTask(int index) {
        String status = isCompleted ? "✔ Completed" : "❌ Pending";
        System.out.println(index + ". " + title + " - " + status);
    }
}

public class Main {

    static ArrayList<Task> tasks = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n📝 To-Do List Application developed by Monty");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    completeTask();
                    break;
                case 4:
                    deleteTask();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);
    }

    static void addTask() {
        System.out.print("Enter task title: ");
        String title = scanner.nextLine();

        tasks.add(new Task(title));
        System.out.println("✅ Task added successfully!");
    }

    static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            System.out.println("\nYour Tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                tasks.get(i).displayTask(i + 1);
            }
        }
    }

    static void completeTask() {
        System.out.print("Enter task number to mark completed: ");
        int taskNum = scanner.nextInt();

        if (taskNum > 0 && taskNum <= tasks.size()) {
            tasks.get(taskNum - 1).isCompleted = true;
            System.out.println("✅ Task marked as completed!");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    static void deleteTask() {
        System.out.print("Enter task number to delete: ");
        int taskNum = scanner.nextInt();

        if (taskNum > 0 && taskNum <= tasks.size()) {
            tasks.remove(taskNum - 1);
            System.out.println("🗑 Task deleted successfully!");
        } else {
            System.out.println("Invalid task number.");
        }
    }
}
