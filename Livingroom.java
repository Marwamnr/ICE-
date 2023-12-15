public class Livingroom {
    TextUI ui = new TextUI();

    public boolean Livingroom() {
        int input = ui.getIntInput(" You are now in the living room! Here,there are various things you can examine to progress to the next room. \n" +
                "You can choose to examine the following items: " +

                "\n 1: TV" +
                "\n 2: Sofa" +
                "\n 3: Magazine \n");

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
        return true;
    }

    private void TV() {
        Boolean isValid = false;
        while (!isValid) {
            String choice = String.valueOf(ui.getInput("You are now watching a quiz program on television, the host is asking the following question: \n" +
                    "When was the United Nations established?" +

                    "\n 1: 1945" +
                    "\n 2: 1955" +
                    "\n 3: 1972 \n"));

            if (choice.equals("1")) {
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

        Boolean isValid = false;
        while (!isValid) {
            String choice = String.valueOf(ui.getInput("You sit down on the sofa and suddenly find a book next to you, with the title \"The clock\": \n" +
                    "Which author wrote the fairy tale \"The Clock\"?" +

                    "\n 1: The Brothers Grimm" +
                    "\n 2: H.C. Andersen" +
                    "\n 3: Carl Ewald \n"));

            if (choice.equals("1")) {
                ui.displayMessage("Your answer is incorrect! ");
                isValid = false;
            } else if (choice.equals("2")) {
                ui.displayMessage("your answer is correct!");
                isValid = true;
            } else if (choice.equals("3")) {
                ui.displayMessage("Your answer is incorrect!");
                isValid = false;
            } else {
                ui.displayMessage("Please write a number between 1-3");
            }
        }
    }


    private void Magazine() {

        Boolean isValid = false;
        while (!isValid) {
            String choice = String.valueOf(ui.getInput("You find a Traveler magazine on the coffee table and read an article about the City of Lions. \n" +
                    "Which city translates to City of Lions?" +

                    "\n 1: Kathmandu" +
                    "\n 2: Singapore" +
                    "\n 3: Addis Ababa \n"));

            if (choice.equals("1")) {
                ui.displayMessage("Your answer is incorrect!");
                isValid = false;
            } else if (choice.equals("2")) {
                ui.displayMessage("your answer is correct! ");
                isValid = true;
            } else if (choice.equals("3")) {
                ui.displayMessage("Your answer is incorrect!");
                isValid = false;
            } else {
                ui.displayMessage("Please write a number between 1-3");
            }
        }
    }
}

