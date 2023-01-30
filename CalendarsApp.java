import java.time.LocalDate;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.List;

public class CalendarsApp implements iUserDirectory, iCalendarDirectory, Sharer {
    private iUserDirectory userDirectory;
    private iCalendarDirectory calendarDirectory;
    private Sharer eventSharer;
    private Calendar activeCalendar;

    public CalendarsApps(){
        ;
    }

    public List<String> getUsernameList() {
        ;
    }

    public void createNewUser(String username) {
        ;
    }

    public void loginUser(String username) {
        ;
    }

    public void setTimeZone(ZoneOffset offset) {
        ;
    }

    public void setTheme(String theme) {
        ;
    }

    public String getTheme() {
        return "";
    }

    public List<Calendar> getPublicCalendars() {
        ;
    }

    public List<Calendar> getUserCalendars() {
        ;
    }

    public void setActiveCalendars(Calendar calendar) {
        ;
    }

    public void createCalendar(boolean isPublic) {
        ;
    }

    public void removeCalendar(long calendarID) {
        ;
    }

    public void changeCalendarPrivacy(boolean isPublic) {
        ;
    }

    public List<CalendarEvent> getEventsForDay(LocalDate date) {
        ;
    }

    public List<CalendarEvent> getEventsForWeek(LocalDate date) {
        ;
    }

    public List<CalendarEvent> getEventsForMonth(YearMonth month) {
        ;
    }

    public List<CalendarEvent> getEventsForYear(Year year) {
        ;
    }

    public void addEvent(String description, ZonedDateTime startTime, ZonedDateTime endTime) {
        ;
    }

    public void removeEvent(long eventID) {
        ;
    }

    public void updateEvent(long eventID, String description, ZonedDateTime startTime, ZonedDateTime endTime) {
        ;
    }

    public void shareEventTo(String username, CalendarEvent event) {
        ;
    }

    public CalendarEvent removeSharedEvent(long eventID) {
        ;
    }

    public void addSharedEventToCalendar(long eventID) {
        ;
    }

    @Override
    public void shareEvent(long userID, CalendarEvent event) {
        // TODO Auto-generated method stub

    }

    @Override
    public CalendarEvent removeSharedEvent(long userID, long eventID) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Calendar> getCalendarsFor(long userID) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void addCalendar(Calendar calendar) {
        // TODO Auto-generated method stub

    }

    @Override
    public void changeCalendarPrivacy(long userID, long calendarID, boolean isPublic) {
        // TODO Auto-generated method stub

    }

    @Override
    public void removeUser(long userID) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<User> getUserList() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getIDFor(String username) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public User getUser(long userID) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void changeUsername(String oldUsername, String newUsername) {
        // TODO Auto-generated method stub

    }

}
