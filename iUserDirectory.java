import java.util.List;

interface iUserDirectory {

    

    public void removeUser(long userID);

    public List<User> getUserList();

    public long getIDFor(String username);
    public User getUser(long userID);
    public void changeUsername(String oldUsername, String newUsername);
}
