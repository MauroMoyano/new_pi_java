package utils;

import java.util.Scanner;

public class ExpenseValidateAnswer {
    public static boolean validateAnswer(String answer){
        Scanner scanner = new Scanner(System.in);

        do{
            if(answer.equals("SI")) return true;
            if(answer.equals("NO")) return false;
            System.out.println("Debe ingresar SI o NO");
            answer = scanner.nextLine().toUpperCase().trim();
        } while (true);

    }
}
