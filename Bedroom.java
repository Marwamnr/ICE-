public class Bedroom {
    TextUI ui = new TextUI();

    public boolean Bedroom() {
        int input = ui.getIntInput(" You are now in the master bedroom, with the quiz to be guessed! \n" +
                "In the bedroom there is: " +

                "\n 1: Diary " +
                "\n 2: Computer \n");

        switch (input) {
            case 1:
                Diary();
                break;
            case 2:
                Computer();
                break;
            default:
                ui.displayMessage("Please write a number between 1-3");
        }
        return true;
    }

    private void Computer() {
        Boolean isValid = false;
        while (!isValid) {
            String choice = String.valueOf(ui.getInput("You are looking directly at the computer, with a secret front page \n" +
                    "who was created first?? \n" +

                    "\n 1: Anders And" +
                    "\n 2: Pluto" +
                    "\n 3: Mickey Mouse"));

            if (choice.equals("1")) {
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

    private void Diary() {
        Boolean isValid = false;
        while (!isValid) {
            String choice = String.valueOf(ui.getInput("You have now opened the secret diary, with a question that can never be answered.. \n" +
                    "What is included in a sundial? \n" +

                    "\n 1: sun and shade" +
                    "\n 2: sun and wind" +
                    "\n 3: The Moon and the Sun"));

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
