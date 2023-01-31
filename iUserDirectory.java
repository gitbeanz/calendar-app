import java.util.List;

interface iUserDirectory {
    public void addUser(long userID, User user);
    // DIFFERENCE added user parameter

    public void removeUser(long userID);

    public List<User> getUserList();

    public long getIDFor(String username);

    public User getUser(long userID);

    public User getUser(String username);
    // DIFFERENCE added getUser from username

    public void changeUsername(String oldUsername, String newUsername);
}
