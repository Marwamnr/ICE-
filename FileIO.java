import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO {
    private ArrayList<User> login = new ArrayList<>();

    public ArrayList<User> readLoginFromFile(String path) throws RuntimeException {
        ArrayList<User> loginList = new ArrayList<>();
        TextUI ui = new TextUI();
        try {
            File myObj = new File(path);
            if (!myObj.exists()) {
                throw new FileNotFoundException("File not found"); // Throw an exception
            }
            try (Scanner myReader = new Scanner(myObj)) {
                String line = myReader.nextLine();
                while (myReader.hasNextLine()) {
                    String[] parts = line.split(",");
                    if (parts.length == 2) {
                        String username = parts[0];
                        String password = parts[1];
                        User user = new User(username, password);
                        loginList.add(user);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            // Log or handle the exception as needed
            throw new RuntimeException(e); // Re-throw the exception
        }

        return loginList;
    }
    public void saveLogin(ArrayList<User> login) {
        TextUI ui = new TextUI();
        try {
            FileWriter writer = new FileWriter("data.txt", true);
            for (User c : login) {
                String textTosave = c.getUsername() + "," + c.getPassword();
                writer.write(textTosave + "\n");
            }
            writer.close();
        } catch (IOException e) {
            ui.displayMessage("Something went wrong while writing to file ");
        }
    }

    public boolean readFile(String username, String password, String path) {
        Menu menu = new Menu();
        TextUI ui = new TextUI();
        try {
            File myObj = new File(path);
            if (!myObj.exists()) {
                ui.displayMessage("File not found: " + path);
                return false;
            }
            try (Scanner myReader = new Scanner(myObj)) {
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    String searchString = username + "," + password;
                    if (data.contains(searchString)) {
                        return true;
                    }
                }
                myReader.close();
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Something went wrong reading the file");
        }
        ui.displayMessage("Could not find login, please create account");
        User user = new User(username, password);
        menu.createLogin();
        return false;
    }

    public ArrayList<String> scanGame() {
        return null;
    }
}
