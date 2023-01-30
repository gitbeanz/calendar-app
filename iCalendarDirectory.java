import java.util.List;

interface iCalendarDirectory{
    public List<Calendar> getPublicCalendars();
    public List<Calendar> getCalendarsFor(long userID);
    public void addCalendar(Calendar calendar);
    public void changeCalendarPrivacy(long userID, long calendarID, boolean isPublic);
}