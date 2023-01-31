import java.util.List;

interface iCalendarDirectory {

    public List<Calendar> getCalendarsFor(long userID);

    public void addCalendar(Calendar calendar, long userID);

    public void removeCalendar(Calendar calendar, long userID);

}