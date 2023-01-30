import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.time.ZoneOffset;
import java.util.Map;
import java.time.temporal.ChronoField;

public class Calendar extends Identifiable{
    private Map<Long, CalendarEvent> events;
    private Map<String, List<CalendarEvent>> eventsPerDate;
    private boolean isPublic;
    private User owner;
    public Calendar(boolean isPublic){
        this.isPublic = isPublic;
    }
    public void addEvent(String description, ZonedDateTime startTime, ZonedDateTime endTime){
        CalendarEvent newEvent = new CalendarEvent(description, startTime, endTime);
        this.events.put(newEvent.getID(),newEvent);   
    }
    public void removeEvent(long eventID){
        this.events.remove(eventID);
    }
    public void updateEvent(long eventID, String description, ZonedDateTime startTime, ZonedDateTime endTime){
        this.removeEvent(eventID);
        this.addEvent(description, startTime, endTime);
    }
    public void applyEventTimeZoneOffset(ZoneOffset offset){
        for (CalendarEvent event : this.events.values()){
            event.applyEventTimeZoneOffset(offset);
        }
    }
    public List<CalendarEvent> getEventsForDay(ZonedDateTime date){
        List<CalendarEvent> eventList = new ArrayList<CalendarEvent>();
        int dayOfMonth = date.getDayOfMonth(); 
        int month = date.getMonthValue();
        int year = date.getYear();
        for (CalendarEvent event : this.events.values()){
            if (event.getStartTime().getDayOfMonth() == dayOfMonth && event.getStartTime().getMonthValue() == month && event.getStartTime().getYear() == year){
                eventList.add(event);
            }
        }
        return eventList;
    } 
    public List<CalendarEvent> getEventsForWeek(ZonedDateTime date){
        List<CalendarEvent> eventList = new ArrayList<CalendarEvent>();
        int week = date.get(ChronoField.ALIGNED_WEEK_OF_YEAR);
        int year = date.getYear();
        for (CalendarEvent event : this.events.values()){
            if (event.getStartTime().get(ChronoField.ALIGNED_WEEK_OF_YEAR) == week && event.getStartTime().getYear() == year){
                eventList.add(event);
            }
        }
        return eventList;
    } 
    public List<CalendarEvent> getEventsForMonth(ZonedDateTime date){
        List<CalendarEvent> eventList = new ArrayList<CalendarEvent>();
        int month = date.getMonthValue();
        int year = date.getYear();
        for (CalendarEvent event : this.events.values()){
            if (event.getStartTime().getMonthValue() == month && event.getStartTime().getYear() == year){
                eventList.add(event);
            }
        }
        return eventList;
    }
    public List<CalendarEvent> getEventsForYear(ZonedDateTime date){
        List<CalendarEvent> eventList = new ArrayList<CalendarEvent>();
        int year = date.getYear();
        for (CalendarEvent event : this.events.values()){
            if (event.getStartTime().getYear() == year){
                eventList.add(event);
            }
        }
        return eventList;
    }
    public String toString(){
        String userString = owner + "'s calendar";
        String calendarString = String.format("Number of calendars: %d", this.events.size());
        return userString + "\n" + calendarString + "\n";
    }
    



}
