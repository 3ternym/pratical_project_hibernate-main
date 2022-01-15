package menu;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.Customer;
import persistence.RepositoryCustomer;

public class MenuCustomer {

    private static Scanner input = new Scanner(System.in);

    RepositoryCustomer repositoryCustomer = new RepositoryCustomer();
    private static UpdateCustomerMenu updateCustomerMenu;

    public MenuCustomer() {
        this.updateCustomerMenu = new UpdateCustomerMenu();
    }

    public static void getCustomerMenu() {
        MenuCustomer menuCustomer = new MenuCustomer();
        menuCustomer.menuChoice(input);
    }

    private int menuOptions(Scanner input) {
        System.out.println("\n/***************************************************/");
        System.out.println("Select the submenu option: ");
        System.out.println("-------------------------\n");
        System.out.println();
        System.out.println("1: List all customers");
        System.out.println("2: Customer updating menu");
        System.out.println("3: Total active customers");
        System.out.println("4: List total active and not active customers");
        System.out.println("5: ");
        System.out.println("6: Create new customer");
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
                    menuListAllCustomers(input);
                    break;
                case 2:
                    this.updateCustomerMenu.menuChoice(input);
                    break;
                case 3:
                    menuAllActiveCustomers(input);
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    menuRegisterNewCustomer(input);
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

    private void menuListAllCustomers(Scanner input) {
        List<Customer> listCustomer = repositoryCustomer.listAllCustomers();

        if (listCustomer.size() > 0) {
            System.out.println("\nList of Customers:");
            for (Customer cust : listCustomer) {
                System.out.println(cust.toString());
            }
        } else {
            System.out.println("\nNo customers registered\n");
            menuOptions(input);
        }
    }

    private void menuAllActiveCustomers(Scanner input) {
        Long activeCustomers = repositoryCustomer.listActiveCustomers();

        if (activeCustomers > 0) {
            System.out.println("\nList of active customers:");
            System.out.println(activeCustomers);
        } else {
            System.out.println("\nNo active customers\n");
            menuOptions(input);
        }
    }

    private void menuRegisterNewCustomer(Scanner input) {

        Customer customer = new Customer();

        System.out.println("Enter customer first name:");
        String firstName = input.next();

        //TODO: LEAVE EMPTY IF NO MIDDLE NAME
        System.out.println("Enter middle name (leave empty if no middle name): ");
        String middleName = input.next();
        if(middleName.isEmpty()) {
            middleName=null;
        }

        System.out.println("Enter customer last name:");
        String lastName = input.next();

        String email = null;
        boolean validForm = false;

        while (!validForm) {
            System.out.println("Enter email:");
            email = input.next();
            boolean emailResult = validateEmail(email);
            if(!emailResult) {
                System.out.println("Email invalid");
            } else {
                validForm = true;
            }
        }


        String username = null;
        boolean validateUsernameBooleanCheck = false;

        while (!validateUsernameBooleanCheck) {
            System.out.println("Enter username: "); //TODO:
            username = input.next();
            boolean userNameResult = validateUsername(username);

            if(userNameResult) {
                System.out.println("Username already exists in database!\n Please try again!");
            } else {
                validateUsernameBooleanCheck = true;
            }
        }


        String phone = null;
        boolean validPhoneNumber = false;

        while (!validPhoneNumber) {
            System.out.println("Enter phone number");
            phone = input.next();
             boolean validatedPhoneNumber = validatePhoneNumber(phone);
            if(!validatedPhoneNumber) {
                System.out.println("Phone number invalid! (Requirements: 7-8 digits)");
            } else {
                validPhoneNumber = true;
            }
        }


        customer.setFirstName(firstName);
        customer.setMiddleName(middleName);
        customer.setLastName(lastName);
        customer.setEmail(email);
        customer.setPhoneNumber(phone);
        customer.setAccountStatus(true);
        customer.setUserName(username);
        repositoryCustomer.create(customer);
    }



    private boolean validateEmail(String email) {
        String EMAIL_PATTERN = "^[\\\\w!#$%&’*+/=?`{|}~^-]+(?:\\\\.[\\\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\\\.)+[a-zA-Z]{2,6}$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private boolean validateUsername(String username) {
        if(repositoryCustomer.listAllCustomersByUserName().contains(username)) {
            return false;
        } else {
            return true;
        }
    }

    private boolean validatePhoneNumber(String phoneNumber) {
        String PHONE_PATTERN = "\\\\d{8}|\\\\d{7}";

        Pattern pattern = Pattern.compile(PHONE_PATTERN);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }

}
