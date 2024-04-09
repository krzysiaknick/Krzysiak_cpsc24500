
package a6;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Nodes nodes = new Nodes();
        boolean exit = false;


        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("1. Fill");
            System.out.println("2. Clear");
            System.out.println("3. Count Nodes");
            System.out.println("4. Count ThreeDNodes");
            System.out.println("5. Sort");
            System.out.println("6. Display");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the size to fill: ");
                    int size = scanner.nextInt();
                    nodes.fill(size);
                    System.out.println("Filled with " + size + " nodes.");
                    break;
                case 2:
                    nodes.clear();
                    System.out.println("Nodes cleared.");
                    break;
                case 3:
                    System.out.println("Number of Node objects: " + nodes.countNodes());
                    break;
                case 4:
                    System.out.println("Number of ThreeDNode objects: " + nodes.countThreeDNodes());
                    break;
                case 5:
                    nodes.sort();
                    System.out.println("Nodes sorted.");
                    break;
                case 6:
                    System.out.println("Nodes:\n" + nodes.toString());
                    break;
                case 7:
                    exit = true;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 7.");
            }
        }
        scanner.close();
    }


    }


