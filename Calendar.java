import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.time.ZoneOffset;
import java.util.Map;
import java.time.temporal.ChronoField;

public class Calendar extends Identifiable {
    private Map<Long, CalendarEvent> events;
    private Map<String, List<CalendarEvent>> eventsPerDate;
    private User owner;
    private String name;
    private int eventSize;

    public Calendar(String name, User owner) {
        this.name = name;
        this.events = new HashMap<Long, CalendarEvent>();
        this.eventsPerDate = new HashMap<String, List<CalendarEvent>>();
        this.eventSize = 0;
        this.owner = owner;

    }

    public String getName() {
        return this.name;
    }

    public Map<Long, CalendarEvent> getEvents() {
        return events;
    }

    public void addEvent(String description, ZonedDateTime startTime, ZonedDateTime endTime) {
        CalendarEvent newEvent = new CalendarEvent(description, startTime, endTime);
        System.out.println("Event successfully created");
        this.events.put(newEvent.getID(), newEvent);
        this.eventSize += 1;
    }

    public void removeEvent(long eventID) {
        this.events.remove(eventID);
        this.eventSize -= 1;
    }

    public void updateEvent(long eventID, String description, ZonedDateTime startTime, ZonedDateTime endTime) {
        this.removeEvent(eventID);
        this.addEvent(description, startTime, endTime);
    }

    public void applyEventTimeZoneOffset(ZoneOffset offset) {
        for (CalendarEvent event : this.events.values()) {
            event.applyEventTimeZoneOffset(offset);
        }
    }

    public List<CalendarEvent> getEventsForDay(ZonedDateTime date) {
        List<CalendarEvent> eventList = new ArrayList<CalendarEvent>();
        int dayOfMonth = date.getDayOfMonth();
        int month = date.getMonthValue();
        int year = date.getYear();
        for (CalendarEvent event : this.events.values()) {
            if (event.getStartTime().getDayOfMonth() == dayOfMonth && event.getStartTime().getMonthValue() == month
                    && event.getStartTime().getYear() == year) {
                eventList.add(event);
            }
        }
        return eventList;
    }

    public List<CalendarEvent> getEventsForWeek(ZonedDateTime date) {
        List<CalendarEvent> eventList = new ArrayList<CalendarEvent>();
        int week = date.get(ChronoField.ALIGNED_WEEK_OF_YEAR);
        int year = date.getYear();
        for (CalendarEvent event : this.events.values()) {
            if (event.getStartTime().get(ChronoField.ALIGNED_WEEK_OF_YEAR) == week
                    && event.getStartTime().getYear() == year) {
                eventList.add(event);
            }
        }
        return eventList;
    }

    public List<CalendarEvent> getEventsForMonth(ZonedDateTime date) {
        List<CalendarEvent> eventList = new ArrayList<CalendarEvent>();
        int month = date.getMonthValue();
        int year = date.getYear();
        for (CalendarEvent event : this.events.values()) {
            if (event.getStartTime().getMonthValue() == month && event.getStartTime().getYear() == year) {
                eventList.add(event);
            }
        }
        return eventList;
    }

    public List<CalendarEvent> getEventsForYear(ZonedDateTime date) {
        List<CalendarEvent> eventList = new ArrayList<CalendarEvent>();
        int year = date.getYear();
        for (CalendarEvent event : this.events.values()) {
            if (event.getStartTime().getYear() == year) {
                eventList.add(event);
            }
        }
        return eventList;
    }

    public String toString() {
        String userString = owner.getUsername() + "'s calendar";
        String calendarString = String.format("Number of events: %d", this.eventSize);
        return userString + "\n" + calendarString + "\n";
    }

}
