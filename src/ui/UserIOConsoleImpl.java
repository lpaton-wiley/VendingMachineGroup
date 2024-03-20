package ui;

import java.util.Scanner;

public class UserIOConsoleImpl implements UserIO {
    
    private Scanner scanner = new Scanner(System.in);

    public void print(String message){
        System.out.println(message);
    };

    public String readString(String prompt){
        print(prompt);
        String userInput = scanner.nextLine();
        return userInput;
    };

    public int readInt(String prompt){
        print(prompt);
        int userInput = Integer.parseInt(scanner.nextLine().trim());
        return userInput;
    };

    public int readInt(String prompt, int min, int max){
        while (true) {
            print(prompt);
            int userInput = Integer.parseInt(scanner.nextLine().trim());
            if ((userInput >= min) && (userInput <= max)){
                return userInput;
            }
        }
    };

    public double readDouble(String prompt){
        print(prompt);
        double userInput = Double.parseDouble(scanner.nextLine().trim());
        return userInput;
    };

    public double readDouble(String prompt, double min, double max){
        while (true) {
            print(prompt);
            double userInput = Double.parseDouble(scanner.nextLine().trim());
            if ((userInput >= min) && (userInput <= max)){
                return userInput;
            }
        }
    };

    public float readFloat(String prompt){
        print(prompt);
        float userInput = Float.parseFloat(scanner.nextLine().trim());
        return userInput;
    };

    public float readFloat(String prompt, float min, float max){
        while (true) {
            print(prompt);
            float userInput = Float.parseFloat(scanner.nextLine().trim());
            if ((userInput >= min) && (userInput <= max)){
                return userInput;
            }
        }
    };

    public long readLong(String prompt){
        print(prompt);
        Long userInput = scanner.nextLong();
        return userInput;
    };

    public long readLong(String prompt, long min, long max) {
        while (true) {
            print(prompt);
            Long userInput = scanner.nextLong();
            if ((userInput >= min) && (userInput <= max)) {
                return userInput;
            }
        }
    }

}


