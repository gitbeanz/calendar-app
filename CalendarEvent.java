import java.time.ZonedDateTime;
import java.time.ZoneOffset;
import java.time.ZoneId;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

public class CalendarEvent extends Identifiable implements Comparable<CalendarEvent> {
    private String description;
    private ZonedDateTime startTime;
    private ZonedDateTime endTime;

    public CalendarEvent(String description, ZonedDateTime startTime, ZonedDateTime endTime) {
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public void applyEventTimeZoneOffset(ZoneOffset offset) {
        ZoneId zone = ZoneId.of(offset.getId());
        LocalDateTime localDateTimeStart = startTime.toLocalDateTime();
        LocalDateTime localDateTimeEnd = endTime.toLocalDateTime();
        this.startTime = ZonedDateTime.ofStrict(localDateTimeStart, offset, zone);
        this.endTime = ZonedDateTime.ofStrict(localDateTimeEnd, offset, zone);
    }

    @Override
    public int compareTo(CalendarEvent other) {
        return startTime.compareTo(other.startTime);
    }

    public boolean equals(Object other) {
        if (other instanceof CalendarEvent) {
            CalendarEvent otherCalendar = (CalendarEvent) other;
            return (this == otherCalendar);
        } else {
            return false;
        }
    }

    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E MMM dd uuuu hh:mm a z");
        String descriptionString = "Description: " + description;
        String startTimeString = "Start Time: " + startTime.format(formatter);
        String endTimeString = "End Time: " + endTime.format(formatter);
        return "\n" + descriptionString + "\n" + startTimeString + "\n" + endTimeString + "\n";
    }

    public ZonedDateTime getStartTime() {
        return this.startTime;
    }

    public String getDescription() {
        return this.description;
    }

    public ZonedDateTime getEndTime() {
        return this.endTime;
    }

    public static void main(String[] args) {
        // CalendarEvent event = new CalendarEvent("test", ZonedDateTime.now(),
        // ZonedDateTime.now());
        ;
    }
}
