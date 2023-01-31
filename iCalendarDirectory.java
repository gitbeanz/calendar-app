import java.util.ArrayList;
import java.util.List;

interface iCalendarDirectory {

    public ArrayList<Calendar> getCalendarsFor(long userID);

    public void addCalendar(Calendar calendar, long userID);

    public void removeCalendar(Calendar calendar, long userID);

}