import java.util.ArrayList;
import java.util.Scanner;

class Task {
    String name;
    String description;
    String dueDate;

    public Task(String name, String description, String dueDate) {
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
    }
}

public class TaskManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Task> tasks = new ArrayList<>();

        while (true) {
        	System.out.println();
            System.out.println("\t\t\tTask Management System");
            System.out.println("\t\t---------------------------------------");
            System.out.println("\t\t  1. Add Task");
            System.out.println("\t\t  2. Remove Task");
            System.out.println("\t\t  3. List Tasks");
            System.out.println("\t\t  4. Exit");
            System.out.println("\t\t---------------------------------------");
            System.out.println();

            System.out.print("\t\t\tEnter your choice: ");
            System.out.println();
            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
            } catch (Exception e) {
            	System.out.println();
                System.out.println("\t\t  Invalid input. Please enter a valid option.");
                scanner.nextLine(); // Consume the invalid input
                continue;
            }

            switch (choice) {
                case 1:
                    addTask(scanner, tasks);
                    break;
                case 2:
                    removeTask(scanner, tasks);
                    break;
                case 3:
                    listTasks(tasks);
                    break;
                case 4:
                	System.out.println();
                    System.out.println("\t\t  Exiting Task Management System. Goodbye!");
                    System.exit(0);
                    break;
                default:
                	System.out.println();
                    System.out.println("\t\t  Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void addTask(Scanner scanner, ArrayList<Task> tasks) {
        System.out.print("\t\t  Enter task name: ");
        String name = scanner.nextLine(); // Read the entire line

        System.out.print("\t\t  Enter task description: ");
        String description = scanner.nextLine(); // Read the entire line

        System.out.print("\t\t  Enter due date: ");
        String dueDate = scanner.nextLine(); // Read the entire line
        System.out.println();

        Task newTask = new Task(name, description, dueDate);
        tasks.add(newTask);

        System.out.println("\t\t  Task added successfully!");
        System.out.println("\t\t---------------------------------------");
        System.out.println();
    }

    private static void removeTask(Scanner scanner, ArrayList<Task> tasks) {
        if (tasks.isEmpty()) {
            System.out.println("\t\t  No tasks to remove.");
            System.out.println();
            return;
        }

        System.out.println("\t\t  Select task to remove:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i).name);
        }

        System.out.print("\t\t  Enter task number to remove: ");
        int taskNumber;
        try {
            taskNumber = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
        } catch (Exception e) {
            System.out.println("\t\t  Invalid input. Please enter a valid task number.");
            scanner.nextLine(); // Consume the invalid input
            System.out.println();
            return;
        }

        if (taskNumber >= 1 && taskNumber <= tasks.size()) {
            Task removedTask = tasks.remove(taskNumber - 1);
            System.out.println("\t\t  Task removed: " + removedTask.name);
        } else {
            System.out.println("\t\t  Invalid task number.");
            System.out.println();
        }
    }

    private static void listTasks(ArrayList<Task> tasks) {
        if (tasks.isEmpty()) {
            System.out.println("\t\t  No tasks available.");
            System.out.println();
            return;
        }

        System.out.println("\t\t  Tasks:");
        System.out.println("\t\t --------");
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            System.out.println();
            System.out.println("\t\tTask No.\t:\t"+(i+1));
            System.out.println("\t===========================================");
            System.out.println();
            System.out.println("\tName\t\t:\t" + task.name);
            System.out.println("\tDescription\t:\t" + task.description);
            System.out.println("\tDue Date\t:\t" + task.dueDate);
            System.out.println("\t============================================");
        }
    }
}
