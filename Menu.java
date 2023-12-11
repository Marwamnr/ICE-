import java.util.ArrayList;

public class Menu {
    TextUI ui = new TextUI();
    FileIO io = new FileIO();

    Livingroom livingroom = new Livingroom();
    Kitchen kitchen = new Kitchen();

    Bedroom bedroom = new Bedroom();

    Bathroom bathroom = new Bathroom();

    Basement basement= new Basement();

    ArrayList<User> login = new ArrayList<>();

    User user = new User("", "");

    public Menu() {
    }

    public void startMenu() {
        Boolean validInput = false;
        String password = "";
        String username = "";
        User user = new User(username, password);

        while (!validInput) {
            String input = String.valueOf(ui.getInput("Hello, welcome to Mystic Mansion! Do you want to create account or login?"));

            if (input.equalsIgnoreCase("create account")) {
                createLogin();
                validInput = true;
            } else if (input.equalsIgnoreCase("login")) {
                login(user);
                validInput = true;
            } else {
                ui.displayMessage("Something went wrong, please try again");
            }
        }
        io.readLoginFromFile("data.txt");
    }

    public void  mainMenu(User user) {
        String input = ui.getInput("Please select one of the following: " +
                "\n 1: Start a new game" +
                "\n 2: Save game" +
                "\n 3: Continue saved game" +
                "\n 4: End game" +
                "\n 5: Game rules");

        int inputInt = Integer.valueOf(input);
        switch (inputInt) {
            case 1:
                playGame();
                break;
            case 2:
                saveGame();
                break;
            case 3:
                continueGame();
                break;
            case 4:
                endGame();
                break;
            case 5:
                gameRules();
                break;
            default:
                ui.displayMessage("Please write a number between 1-5");
        }
    }

    public void createLogin() {
        FileIO io = new FileIO();
        String inputUsername = ui.getInput("Please write a username: ");
        String inputPassword = ui.getInput("Please write a password: ");
        User user = new User(inputUsername, inputPassword);
        login.add(user);
        io.saveLogin(login);
        mainMenu(user);
    }
    public void login(User user)
    {
        FileIO io = new FileIO();
        String inputUsername = ui.getInput("Please write your username: ");
        String inputPassword = ui.getInput("Please write your password: ");
        try {
            boolean loggedIn = (io.readFile(inputUsername, inputPassword, "data.txt"));
            if(loggedIn)
            {
                ui.displayMessage("Welcome back!");
                mainMenu(user);
            } else {
                ui.displayMessage("Sorry! Something went wrong, please try again later.");
                //Handle the unsuccessful login
            }
        } catch(RuntimeException e) {
            // Log or handle the exception
            ui.displayMessage("Error occurred: " + e.getMessage());

        }
    }

    public void playGame() {

        int input = ui.getIntInput(" Welcome to Mystic Mansion. You have the possibility to explore the house. Please select a room in the house to investigate:" +

                "\n 1: Livingroom" +
                "\n 2: Kitchen" +
                "\n 3: Bedroom" +
                "\n 4: Bathroom" +
                "\n 5: Basement");

        switch (input) {
            case 1:
                livingroom.Livingroom();
                break;
            case 2:
                kitchen.Kitchen();
                break;
            case 3:
                bedroom.Bedroom();
                break;
            case 4:
                bathroom.Bathroom();
                break;
            case 5:
                basement.Basement();
                break;
            default:
                ui.displayMessage("Please write a number between 1-5");


        }
    }

    public void saveGame() {

    }

    public void continueGame() {
    }

    public void endGame() {
    }

    public void gameRules() {
    }
}
