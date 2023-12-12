import javax.swing.*;

public class Basement {
    TextUI ui = new TextUI();

    public void Basement() {
        int input = ui.getIntInput(" Now you are in the basement, with the creepy surroundings and darkness! \n" +
                "In the basement there is: " +

                "\n 1: Packages" +
                "\n 2: Doll");

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

    }
    private void Packages() {
    }
    private void Doll() {
    }
}
