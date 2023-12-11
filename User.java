import java.util.HashSet;

public class User {
    private String username;
    private String password;

    private HashSet<String> saveGame = new HashSet<>();

    public User(String username, String password)
    {
        this.username = username;
        this.password = password;
    }
    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }

    public HashSet<String> getSaveGame(User user) {
        TextUI ui = new TextUI();
        return saveGame;
    }

    public String toString()
    {
        return "Username: " + getUsername() +  " " + "Password: " + getPassword();
    }
}
