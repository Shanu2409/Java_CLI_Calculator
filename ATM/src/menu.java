import java.util.Scanner;

public class menu {
    Scanner sc = new Scanner(System.in);

    int id = 1;
    int password = 9;

    public void Check() {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.print("Please Enter your Account number : ");
        int userId = sc.nextInt();
        System.out.print("Please Enter your Password : ");
        int userPass = sc.nextInt();

        if (id == userId && password == userPass) {
            mainMenu();
        } else {
            System.out.println("\nWrong i'd or password !!!!");
            Check();
        }

    }

    public void mainMenu() {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println();
        System.out.println("1. Check Balance.");
        System.out.println("2. Withdraw Money.");
        System.out.println("3. Deposit money.");
        System.out.println("4. Settings.");
        System.out.println("5. Exit ATM.");

        System.out.println();
        System.out.print("Enter your Option : ");
        int op = sc.nextInt();

        switch (op) {
            case 1:
                show();
                break;
            case 2:
                withdraw();
                break;
            case 3:
                deposit();
                break;
            case 4:
                settings();
                break;
            case 5:
                break;
            default:
                System.out.println("INVALID OPTION!!! \nTry again");
                mainMenu();
        }
    }

    float balance = 0.00F;

    public void show() {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("Amount in your account : $" + balance);

        back();

    }

    public void withdraw() {

        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("Withdraw Money");

        System.out.print("Enter your Password : ");
        int z = sc.nextInt();

        boolean is = checkPassword(z);
        if (is) {
            System.out.print("Enter the Amount to Withdraw :");
            int withdraw = sc.nextInt();
            if (balance > 0) {
                balance -= withdraw;
                System.out.println();
                System.out.println("Please collect your money from below.....");

                back();
            } else {
                System.out.println("Not enough money to withdraw");
                show();
            }
        } else {
            System.out.println("Wrongs password");
            settings();
        }
    }

    public void deposit() {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("Deposit Money");
        System.out.print("Enter your Password : ");
        int z = sc.nextInt();

        boolean is = checkPassword(z);
        if (is) {
            System.out.print("Enter the Amount to Deposit :");
            int deposit = sc.nextInt();
            balance += deposit;
            System.out.println();
            System.out.println("Your money has been successfully deposited...");

            back();
        } else {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("Wrongs password");
            deposit();
        }

    }

    public void settings() {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("Settings");

        System.out.println("1. To change Account Password.");
        System.out.println("2. Show Account Number and Password.");
        System.out.println("3. Go back.");
        System.out.println();
        System.out.print("Enter your Option : ");
        int op = sc.nextInt();

        switch (op) {
            case 1:
                System.out.println();
                System.out.print("Enter your old Password : ");
                int z = sc.nextInt();

                boolean is = checkPassword(z);
                if (is) {
                    System.out.print("Enter new Password : ");
                    int y = sc.nextInt();

                    id = y;

                    System.out.println();
                    System.out.println("Your Account Password has been successfully changed.");
                    settings();
                } else {
                    System.out.println("Wrongs password");
                    settings();
                }

                break;

            case 2:
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("Your Account Number is : " + id);
                System.out.println("your Password is : " + password);

                back();

                break;

            case 3:
                mainMenu();
        }

    }

    public boolean checkPassword(int old) {
        boolean ans = (old == password) ? true : false;

        if (ans)
            System.out.println("Succesfully Set");

        return ans;
    }

    public void exit() {
        System.out.println();
        System.out.println("Thank you for using out ATM.......");
        System.exit(0);
    }

    public void back() {
        System.out.println();
        System.out.println("1. Go back to menu.");
        System.out.println("2. Exit ATM");
        System.out.println();
        System.out.print("Enter your Option : ");
        int op = sc.nextInt();

        switch (op) {
            case 1:
                mainMenu();
            case 2:
                exit();
        }
    }
}
