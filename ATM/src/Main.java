import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Welcome to our ATM");

        menu n1 = new menu();
        n1.Check();
        sc.close();
    }
}