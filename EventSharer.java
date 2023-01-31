import java.util.List;
import java.util.Map;

public class EventSharer implements Sharer {
    private Map<Long, List<CalendarEvent>> sharedEvents;

    public EventSharer() {
        ;
    }

    @Override
    public void shareEvent(long userID, CalendarEvent event) {
        // TODO Auto-generated method stub
        sharedEvents.get(userID).add(event);
    }

    @Override
    public CalendarEvent removeSharedEvent(long userID, long eventID) {
        // TODO Auto-generated method stub
        for (CalendarEvent event : sharedEvents.get(userID)) {
            if (event.getID() == eventID) {
                CalendarEvent returnEvent = event;
                sharedEvents.get(userID).remove(event);
                return returnEvent;
            }
        }
        return null;
    }
}