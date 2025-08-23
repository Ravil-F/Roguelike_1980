package domain.utils;

import java.util.Scanner;

public class inputScan {
    private final Scanner scan;

    public inputScan(){
        scan = new Scanner(System.in);
    }

    public String scanLine(String prompt) {
        String line;
        while (true) {
            System.out.print(prompt);
            line = scan.nextLine();
            if (line.isEmpty())
                System.out.println("Line empty. Please, try again.");
            else break;
        }
        return line;
    }

}
