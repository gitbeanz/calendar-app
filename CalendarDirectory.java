import java.util.Map;
import java.util.List;

public class CalendarDirectory implements iCalendarDirectory {
    private List<Calendar> publicCalendars;
    private Map<Long, List<Calendar>> privateCalendars;

    public CalendarDirectory(List<Calendar> publicCalendars, Map<Long, List<Calendar>> privateCalendars) {
        this.publicCalendars = publicCalendars;
        this.privateCalendars = privateCalendars;
    }

    @Override
    public List<Calendar> getPublicCalendars() {
        // TODO Auto-generated method stub
        return publicCalendars;
    }

    @Override
    public List<Calendar> getCalendarsFor(long userID) {
        // TODO Auto-generated method stub
        return privateCalendars.get(userID);
    }

    @Override
    public void addCalendar(Calendar calendar, long userID) {
        // TODO Auto-generated method stub
        if (calendar.getIsPublic()) {
            publicCalendars.add(calendar);
        } else {
            privateCalendars.get(userID).add(calendar);
        }

    }

    @Override
    public void changeCalendarPrivacy(long userID, long calendarID, boolean isPublic) {
        // TODO Auto-generated method stub
        if (isPublic) {
            for (Calendar calendar : publicCalendars) {
                if (calendar.getID() == calendarID) {
                    calendar.setIsPublic(false);
                    publicCalendars.remove(calendar);
                    privateCalendars.get(userID).add(calendar);
                }
            }
        } else {
            for (Calendar calendar : privateCalendars.get(userID) {
                calendar.setIsPublic(true);
                privateCalendars.remove(userID);
                publicCalendars.add(calendar);

            }
        }

    }
}