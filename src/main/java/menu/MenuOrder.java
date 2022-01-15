package menu;

import model.Customer;
import model.Order;
import persistence.RepositoryOrder;

import java.util.List;
import java.util.Scanner;

public class MenuOrder {

    RepositoryOrder repositoryOrder = new RepositoryOrder();

    private int menuOptions(Scanner input) {
        System.out.println("\n/***************************************************/");
        System.out.println("Select the submenu option: ");
        System.out.println("-------------------------\n");
        System.out.println();
        System.out.println("1: All registered orders");
        System.out.println("2: List orders by order status");
        System.out.println("3: List orders by customer");
        System.out.println("100 - Return to Main Menu");
        System.out.println("\n/***************************************************/");
        return input.nextInt();
    }

    protected void menuChoice(Scanner input) {

        int userChoice;
        do {
            userChoice = menuOptions(input);
            switch (userChoice) {
                case 1:
                    menuListAllRegisteredOrders(input);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 100:
                    MainMenu.getMainMenu();
                    break;
                default:
                    System.out.println("\nSorry, please enter valid Option");
                    menuOptions(input);
                    break;
            }// End of switch statement
        } while (userChoice != 100);
    }

    private void menuListAllRegisteredOrders(Scanner input) {
        List<Order> orderList = repositoryOrder.listAllRegisteredOrders();

        if (orderList.size() > 0) {
            System.out.println("\nList of registered orders:");
            for (Order order : orderList) {
                System.out.println(order.toString());
            }
        } else {
            System.out.println("\nNo registered orders\n");
            menuOptions(input);
        }
    }
}
