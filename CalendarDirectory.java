import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CalendarDirectory implements iCalendarDirectory {
    private Map<String, Calendar> calendars;
    private Map<Long, ArrayList<Calendar>> userCalendars;
    // DIFFERENCE

    public CalendarDirectory() {
        this.calendars = new HashMap<String, Calendar>();
        this.userCalendars = new HashMap<Long, ArrayList<Calendar>>();

    }

    @Override
    public ArrayList<Calendar> getCalendarsFor(long userID) {
        // TODO Auto-generated method stub
        return this.userCalendars.get(userID);
    }

    @Override
    public void addCalendar(Calendar calendar, long userID) {
        // TODO Auto-generated method stub
        this.calendars.put(calendar.getName(), calendar);
        if (userCalendars.containsKey(userID)) {
            userCalendars.get(userID).add(calendar);
        } else {
            ArrayList<Calendar> calendarList = new ArrayList<Calendar>();
            this.calendars.put(calendar.getName(), calendar);
            this.userCalendars.put(userID, calendarList);
            this.userCalendars.get(userID).add(calendar);
        }

    }

    public void removeCalendar(Calendar calendar, long userID) {
        // TODO Auto-generated method stub
        calendars.remove(calendar.getName());
        userCalendars.get(userID).remove(calendar);
    }

    @Override
    public Calendar getCalendar(String calendarName) {
        // TODO Auto-generated method stub
        return calendars.get(calendarName);
    }
}