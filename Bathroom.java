public class Bathroom {
    TextUI ui = new TextUI();

    public boolean Bathroom() {
        int input = ui.getIntInput(" You are trapped in the kitchen \n" +
                "In the bathroom there is: " +

                "\n 1: Mirror" +
                "\n 2: Toilet \n");

        switch (input) {
            case 1:
                Mirror();
                break;
            case 2:
                Toilet();
                break;
            default:
                ui.displayMessage("Please write a number between 1-3");
        }
        return true;
    }

    private void Mirror() {
        Boolean isValid = false;
        while(!isValid) {
            String choice = String.valueOf(ui.getInput("You look at yourself and the mirror, behind the mirror there is a question! \n" +
                    "Who painted the Mona Lisa? \n" +

                    "\n 1: Vincent Van Gogh" +
                    "\n 2: Leonardo da Vinci" +
                    "\n 3: Claude Monet"));

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

    private void Toilet() {
        Boolean isValid = false;
        while(!isValid) {
            String choice = String.valueOf(ui.getInput("The white toilet, with black letters on the board it says \n" +
                    "Who gave the famous 'I have a dream' speech? \n" +

                    "\n 1: Marthin Luther King Jr." +
                    "\n 2: Abraham Lincoln" +
                    "\n 3: Rosa Parks"));

            if(choice.equals("1")) {
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
