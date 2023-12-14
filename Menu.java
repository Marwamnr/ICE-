import java.util.ArrayList;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;



public class Menu {
    TextUI ui = new TextUI();
    FileIO io = new FileIO();

    Livingroom livingroom = new Livingroom();
    Kitchen kitchen = new Kitchen();
    Bedroom bedroom = new Bedroom();
    Bathroom bathroom = new Bathroom();
    Basement basement = new Basement();

    ArrayList<User> login = new ArrayList<>();

    User user = new User("", "");

    private String saveGame = "saveGame.txt";

    public String currentRoom;


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

    public void mainMenu(User user) {
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

    public void login(User user) {
        FileIO io = new FileIO();
        String inputUsername = ui.getInput("Please write your username: ");
        String inputPassword = ui.getInput("Please write your password: ");
        try {
            boolean loggedIn = (io.readFile(inputUsername, inputPassword, "data.txt"));
            if (loggedIn) {
                ui.displayMessage("Welcome back!");
                mainMenu(user);
            } else {
                ui.displayMessage("Sorry! Something went wrong, please try again later.");
                //Handle the unsuccessful login
            }
        } catch (RuntimeException e) {
            // Log or handle the exception
            ui.displayMessage("Error occurred: " + e.getMessage());
        }
    }

    public void playGame() {

        boolean continueGame = true;

        ui.displayMessage(" Welcome to Mystic Mansion. You have the possibility to explore the house.");


        while (continueGame) {
            int input = ui.getIntInput(" Please select a room in the house to investigate:" +


                    "\n 1: Livingroom" +
                    "\n 2: Kitchen" +
                    "\n 3: Bedroom" +
                    "\n 4: Bathroom" +
                    "\n 5: Basement" +
                    "\n 6: Back to Main menu");

            switch (input) {
                case 1:
                    continueGame = livingroom.Livingroom();
                    currentRoom="Livingroom";
                    break;
                case 2:
                    continueGame = kitchen.Kitchen();
                    currentRoom="Kitchen";
                    break;
                case 3:
                    continueGame = bedroom.Bedroom();
                    currentRoom="Bedroom";
                    break;
                case 4:
                    continueGame = bathroom.Bathroom();
                    currentRoom="Bathroom";
                    break;
                case 5:
                    continueGame = basement.Basement();
                    currentRoom="Basement";
                    break;
                case 6:
                    BacktoMainmenu();
                    break;
                default:
                    ui.displayMessage("Please write a number between 1-6");
            }
        }
        ui.displayMessage("Thank you for visiting Mystic Mansion. See you next time");
    }

    private boolean BacktoMainmenu() {

        boolean backToMainMenu = true;


        if (backToMainMenu) {
            saveGame();
            mainMenu(user);

        }

        return false;

    }


    public void saveGame() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(saveGame))) {
            writer.write("Currentroom:" + currentRoom);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    String continueGame() {
        try (BufferedReader reader = new BufferedReader(new FileReader(saveGame))) {
            String room = reader.readLine();
            if (room != null && room.startsWith("Currentroom:")) {
                String savedGame = room.substring("Currentroom:".length());
                System.out.print("Welcome back. You are in room: "+ savedGame +".");
                return savedGame;
            } else {
                System.out.println("There is no saved game, would you like to start a new game?");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "something went wrong";

    }
        public void endGame () {
        }

        public void gameRules () {
            ui.displayMessage("Games rules for the Mystic Mansion");
            ui.displayMessage("The house contains different rooms, such as kitchen, bedroom, bathroom, living room and basement, \n" +
                    "each filled with puzzles and challenges. \n" +
                    "Selecting a room gives you a list of items to explore.");
        }
    }

