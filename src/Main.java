import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Neste exemplo, temos um programa Java simples que permite ao usuário adicionar tarefas e visualizar
//todas as tarefas adicionadas. Este é um exemplo de aplicativo monolítico porque toda a lógica
//de negócios está contida em um único arquivo Main.java.

public class Main {
    private static List<Task> taskList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Adicionar tarefa");
            System.out.println("2. Ver todas as tarefas");
            System.out.println("3. Sair");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addTask(scanner);
                    break;
                case 2:
                    viewAllTasks();
                    break;
                case 3:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (choice != 3);
    }

    private static void addTask(Scanner scanner) {
        System.out.println("Digite a descrição da tarefa:");
        String description = scanner.next();
        Task task = new Task(description);
        taskList.add(task);
        System.out.println("Tarefa adicionada com sucesso!");
    }

    private static void viewAllTasks() {
        System.out.println("Tarefas:");
        for (int i = 0; i < taskList.size(); i++) {
            System.out.println((i + 1) + ". " + taskList.get(i).getDescription());
        }
    }

    private static class Task {
        private String description;

        public Task(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
}