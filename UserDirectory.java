import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserDirectory implements iUserDirectory {
    private Map<Long, User> users;
    private Map<String, Long> usernameIDs;

    public UserDirectory(Map<Long, User> users, Map<String, Long> usernameIDs) {
        this.users = users;
        this.usernameIDs = usernameIDs;
    }

    @Override
    public void removeUser(long userID) {
        // TODO Auto-generated method stub
        users.remove(userID);

    }

    @Override
    public List<User> getUserList() {
        // TODO Auto-generated method stub
        List<User> userList = new ArrayList<User>();
        for (User user : users.values()) {
            userList.add(user);
        }
        return userList;
    }

    @Override
    public long getIDFor(String username) {
        // TODO Auto-generated method stub
        return usernameIDs.get(username);
    }

    @Override
    public User getUser(long userID) {
        // TODO Auto-generated method stub
        return users.get(userID);
    }

    @Override
    public void changeUsername(String oldUsername, String newUsername) {
        // TODO Auto-generated method stub
        users.get(usernameIDs.get(oldUsername)).setUsername(newUsername);
    }
}
