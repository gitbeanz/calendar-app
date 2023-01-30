import java.util.List;
import java.util.Map;
public class EventSharer implements Sharer {
    private Map<Long, List<CalendarEvent>> sharedEvents;
    public EventSharer(){
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
}