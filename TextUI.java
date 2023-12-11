import java.util.Scanner;

public class TextUI {
    private Scanner scan = new Scanner(System.in);
    public String getInput(String msg) {
        this.displayMessage(msg);
        return scan.nextLine();
    }

    public void displayMessage(String msg){

        System.out.println(msg);
    }
    public int getIntInput (String msg){
        int userInput = 0;
        boolean isValidInput = false;

        while (!isValidInput) {
            try {
                System.out.print(msg);
                userInput = Integer.parseInt(scan.nextLine());
                isValidInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input.Please enter a valid number.");
            }

        }
        return userInput;
    }
}
