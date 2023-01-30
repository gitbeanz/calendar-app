public class User extends Identifiable {
    private String username;

    // private Settings settings;
    public User(String username) {
        this.username = username;
    }

    public void setUsername(String newUsername) {
        this.username = newUsername;
    }
}
