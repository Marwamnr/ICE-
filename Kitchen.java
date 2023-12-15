public class Kitchen {
    TextUI ui = new TextUI();

    public boolean Kitchen() {
        int input = ui.getIntInput(" You are trapped in the kitchen \n" +
                "In the kitchen there is: " +

                "\n 1: Knife" +
                "\n 2: Window \n");

        switch (input) {
            case 1:
                Knife();
                break;
            case 2:
                Window();
                break;
            default:
                ui.displayMessage("Please write a number between 1-3");
        }
        return true;
    }

    private void Knife() {
        Boolean isValid = false;
        while (!isValid) {
            String choice = String.valueOf(ui.getInput("You have pulled out the big and sharp knife, and there is a question \n" +
                    "How many countries are there in Africa? \n" +

                    "\n 1: 49" +
                    "\n 2: 54" +
                    "\n 3: 68"));

            if (choice.equals("1")) {
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

    private void Window() {
        Boolean isValid = false;
        while (!isValid) {
            String choice = String.valueOf(ui.getInput("The window creaks and has been opened \n" +
                    "In what year were women allowed to compete in the Olympics? \n" +

                    "\n 1: 1900" +
                    "\n 2: 1930" +
                    "\n 3: 2000"));

            if (choice.equals("1")) {
                ui.displayMessage("your answer is correct! ");
                isValid = true;
            } else if (choice.equals("2")) {
                ui.displayMessage("Your answer is incorrect! ");
                isValid = false;
            } else if (choice.equals("3")) {
                ui.displayMessage("Your answer is incorrect! ");
                isValid = false;
            } else {
                ui.displayMessage("Please write a number between 1-3");
            }
        }
    }
}
