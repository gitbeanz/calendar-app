import java.time.LocalDate;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CalendarsApp {
    private UserDirectory userDirectory;
    private CalendarDirectory calendarDirectory;
    private EventSharer eventSharer;
    private User activeUser;
    private Calendar activeCalendar;

    public CalendarsApp() {
        this.userDirectory = new UserDirectory();
        this.calendarDirectory = new CalendarDirectory();
        this.eventSharer = new EventSharer();
    }

    public List<String> getUsernameList() {
        List<User> userList = this.userDirectory.getUserList();
        List<String> usernameList = new ArrayList<String>();
        for (User user : userList) {
            usernameList.add(user.getUsername());
        }
        // System.out.println("Here is the list of usernames\n");
        // System.out.println(usernameList);
        return usernameList;
    }

    public void createNewUser(String username) {
        User user = new User(username);
        this.activeUser = user;
        userDirectory.addUser(user.getID(), user);
        System.out.println("User " + username + " successfully created!");
    }

    public void loginUser(String username) {
        if (getUsernameList().contains(username)) {
            // login user
            activeUser = userDirectory.getUser(username);
        } else {
            System.out.println("Error! Could not log in. Username not found...\n");
        }
    }

    public void setTimeZone(ZoneOffset offset) {
        this.activeCalendar.applyEventTimeZoneOffset(offset);
    }

    public ArrayList<Calendar> getUserCalendars() {
        return calendarDirectory.getCalendarsFor(activeUser.getID());
    }

    public void setActiveCalendars(Calendar calendar) {
        this.activeCalendar = calendar;
    }

    public void createCalendar(String calendarName) {
        Calendar calendar = new Calendar(calendarName, this.activeUser);
        calendarDirectory.addCalendar(calendar, this.activeUser.getID());
    }

    public void removeCalendar(long calendarID) {
        List<Calendar> calendarList = calendarDirectory.getCalendarsFor(activeUser.getID());
        for (Calendar calendar : calendarList) {
            if (calendar.getID() == calendarID) {
                calendarDirectory.addCalendar(calendar, calendarID);
            }
        }
    }

    public List<CalendarEvent> getEventsForDay(ZonedDateTime date) {
        return this.activeCalendar.getEventsForDay(date);
    }

    public List<CalendarEvent> getEventsForWeek(ZonedDateTime date) {
        return this.activeCalendar.getEventsForWeek(date);
    }

    public List<CalendarEvent> getEventsForMonth(ZonedDateTime date) {
        return this.activeCalendar.getEventsForMonth(date);
    }

    public List<CalendarEvent> getEventsForYear(ZonedDateTime date) {
        return this.activeCalendar.getEventsForYear(date);
    }

    public void addEvent(String description, ZonedDateTime startTime, ZonedDateTime endTime) {
        this.activeCalendar.addEvent(description, startTime, endTime);
    }

    public void removeEvent(long eventID) {
        this.activeCalendar.removeEvent(eventID);
    }

    public void updateEvent(long eventID, String description, ZonedDateTime startTime, ZonedDateTime endTime) {
        this.activeCalendar.updateEvent(eventID, description, startTime, endTime);
    }

    public String pickCalendar(String action) {
        System.out.println("\nList of Calendars:\n");
        ArrayList<Calendar> userCalendars = this.getUserCalendars();
        ArrayList<String> calendarNames = new ArrayList<String>();
        String selectedCalendar;
        for (Calendar calendar : userCalendars) {
            System.out.println(calendar.getName());
            calendarNames.add(calendar.getName());
        }
        while (true) {
            Scanner calendarNameScanner = new Scanner(System.in);
            System.out.println("\nPlease enter the name of the calendar you wish to " + action);
            selectedCalendar = calendarNameScanner.next();
            if (calendarNames.contains(selectedCalendar)) {
                this.activeCalendar = getCalendar(selectedCalendar);
                break;
            } else {
                System.out.println("\nOops! name not found. Please try again.");
            }
        }
        return selectedCalendar;
    }

    public Calendar getCalendar(String calendarName) {
        return calendarDirectory.getCalendar(calendarName);
    }

    public int pickView() {
        int viewInt;
        while (true) {
            System.out.println("\nView Page");
            System.out.println("\n1. Today's Events");
            System.out.println("2. Week's Events");
            System.out.println("3. Month's Events");
            System.out.println("4. Year's Events");

            Scanner viewScanner = new Scanner(System.in);
            System.out.println("What would you like to view?");
            viewInt = viewScanner.nextInt();
            if (viewInt == 1 || viewInt == 2 || viewInt == 3 || viewInt == 4) {
                break;
            } else {
                System.out.println("\nOops! Please try again\n");
            }
        }
        return viewInt;
    }

    public int pickUpdate() {
        int updateInt;
        while (true) {
            System.out.println("\nUpdate Page");
            System.out.println("\n1. Add Event Page");
            System.out.println("2. Update Event Page");
            System.out.println("3. Remove Event Page\n");
            Scanner updateScanner = new Scanner(System.in);
            System.out.println("What would you like to update?");
            updateInt = updateScanner.nextInt();
            if (updateInt == 1 || updateInt == 2 || updateInt == 3) {
                break;
            }
        }
        return updateInt;
    }

}