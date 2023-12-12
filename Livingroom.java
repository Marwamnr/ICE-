public class Livingroom {
    TextUI ui = new TextUI();

    public void Livingroom() {
        int input = ui.getIntInput(" You are now in the livingroom! And you now have more choices to advance to the next room \n" +
                "In the livingroom there is: " +

                "\n 1: TV" +
                "\n 2: Sofa" +
                "\n 3: Magazine");

        switch (input) {
            case 1:
                TV();
                break;
            case 2:
                Sofa();
                break;
            case 3:
                Magazine();
                break;
            default:
                ui.displayMessage("Please write a number between 1-3");
        }
    }
    private void TV() {
        Boolean isValid = false;
        while(!isValid) {
            String choice = String.valueOf(ui.getInput("You are now watching a quiz program on television \n" +
                    "When was the United Nations established?" +

                    "\n 1: 1945" +
                    "\n 2: 1955" +
                    "\n 3: 1972"));

            if(choice.equals("1")) {
                ui.displayMessage("your answer is correct! ");
                isValid = true;
            } else if (choice.equals("2")) {
                ui.displayMessage("Your answer is incorrect!");
                isValid = false;
            } else if (choice.equals("3")) {
                ui.displayMessage("Your answer is incorrect!");
                isValid = false;
            } else {
                ui.displayMessage("Please write a number between 1-3");
            }
        }
    }
    private void Sofa() {

    }
    private void Magazine() {

    }
}
