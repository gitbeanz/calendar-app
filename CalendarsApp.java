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

    public List<Calendar> getUserCalendars() {
        return calendarDirectory.getCalendarsFor(activeUser.getID());
    }

    public void setActiveCalendars(Calendar calendar) {
        this.activeCalendar = calendar;
    }

    public void createCalendar(String calendarName) {
        Calendar calendar = new Calendar(calendarName);
        calendarDirectory.addCalendar(calendar, calendar.getID());
    }

    public void removeCalendar(long calendarID) {
        List<Calendar> calendarList = calendarDirectory.getCalendarsFor(activeUser.getID());
        for (Calendar calendar : calendarList) {
            if (calendar.getID() == calendarID) {
                calendarDirectory.removeCalendar(calendar, calendarID);
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

    public void shareEventTo(String username, CalendarEvent event) {
        eventSharer.shareEvent(this.userDirectory.getUser(username).getID(), event);
    }

    public CalendarEvent removeSharedEvent(long eventID) {
        CalendarEvent event = this.activeCalendar.getEvents().get(eventID);
        eventSharer.removeSharedEvent(this.activeUser.getID(), eventID);
        return event;
    }

    public void addSharedEventToCalendar(long eventID) {
        CalendarEvent event = this.activeCalendar.getEvents().get(eventID);
        this.activeCalendar.addEvent(event.getDescription(), event.getStartTime(), event.getEndTime());
    }

}