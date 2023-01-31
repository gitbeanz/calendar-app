import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CalendarDirectory implements iCalendarDirectory {
    private Map<String, Calendar> calendars;
    private Map<Long, ArrayList<Calendar>> userCalendars;
    // DIFFERENCE

    public CalendarDirectory() {
        calendars = new HashMap<String, Calendar>();

    }

    @Override
    public List<Calendar> getCalendarsFor(long userID) {
        // TODO Auto-generated method stub
        return userCalendars.get(userID);
    }

    @Override
    public void addCalendar(Calendar calendar, long userID) {
        // TODO Auto-generated method stub
        calendars.put(calendar.getName(), calendar);
        userCalendars.get(userID).add(calendar);

    }

    public void removeCalendar(Calendar calendar, long userID) {
        // TODO Auto-generated method stub
        calendars.remove(calendar.getName());
        userCalendars.get(userID).remove(calendar);
    }
}