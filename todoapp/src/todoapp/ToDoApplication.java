package todoapp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

class Task {
    private String name;
    private Date deadline;

    public Task(String name, Date deadline) {
        this.name = name;
        this.deadline = deadline;
    }

    public String getName() {
        return name;
    }

    public Date getDeadline() {
        return deadline;
    }

    @Override
    public String toString() {
        return "Task: " + name + ", Deadline: " + deadline;
    }
}

class ToDoList {
    private List<Task> tasks;

    public ToDoList() {
        tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            for (Task task : tasks) {
                System.out.println(task);
            }
        }
    }
}

public class ToDoApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ToDoList toDoList = new ToDoList();

        while (true) {
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            if (choice == 1) {
                System.out.print("Enter task name: ");
                String name = scanner.nextLine();
                System.out.print("Enter deadline (yyyy-MM-dd): ");
                String dateString = scanner.nextLine();
                Date deadline = java.sql.Date.valueOf(dateString);
                Task task = new Task(name, deadline);
                toDoList.addTask(task);
            } else if (choice == 2) {
                toDoList.displayTasks();
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}

