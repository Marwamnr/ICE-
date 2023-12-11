import java.util.ArrayList;

public class Menu {
    TextUI ui = new TextUI();
    FileIO io = new FileIO();
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
                saveGame();
                break;
            case 2:
                playGame();
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

        ui.displayMessage(" Welcome to Mystic Mansion, Please select a room in the house to investigate");
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
