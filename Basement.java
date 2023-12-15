import javax.swing.*;
public class Basement {
    TextUI ui = new TextUI();

    public boolean Basement() {
        int input = ui.getIntInput(" Now you are in the basement, with the creepy surroundings and darkness! \n" +
                "In the basement there is: " +

                "\n 1: Packages" +
                "\n 2: Doll \n");

        switch (input) {
            case 1:
                Packages();
                break;
            case 2:
                Doll();
                break;
            default:
                ui.displayMessage("Please write a number between 1-2");
        }
        return true;
    }

    private void Packages() {
        Boolean isValid = false;
        while(!isValid) {
            String choice = String.valueOf(ui.getInput("You have now opened the box and must guess the question correctly \n" +
                    "Why is Halloween celebrated? \n" +

                    "\n 1: To worship vampires" +
                    "\n 2: To honor the divine" +
                    "\n 3: To remember the dead"));

            if(choice.equals("1")) {
                ui.displayMessage("your answer is incorrect! ");
                isValid = false;
            } else if (choice.equals("2")) {
                ui.displayMessage("Your answer is incorrect! ");
                isValid = false;
            } else if (choice.equals("3")) {
                ui.displayMessage("Your answer is correct! ");
                isValid = true;
            } else {
                ui.displayMessage("Please write a number between 1-3");
            }
        }
    }
    private void Doll() {
        Boolean isValid = false;
        while(!isValid) {
            String choice = String.valueOf(ui.getInput("The talking doll tells if you can't answer the question you will be locked in the basement \n" +
                    "Why is Halloween celebrated? \n" +

                    "\n 1: Fastelavn " +
                    "\n 2: Allehelgensaften " +
                    "\n 3: Trekongersaften"));

            if(choice.equals("1")) {
                ui.displayMessage("your answer is incorrect! ");
                isValid = false;
            } else if (choice.equals("2")) {
                ui.displayMessage("Your answer is correct! ");
                isValid = true;
            } else if (choice.equals("3")) {
                ui.displayMessage("Your answer is incorrect! ");
                isValid = false;
            } else {
                ui.displayMessage("Please write a number between 1-3");
            }
        }
    }
}
