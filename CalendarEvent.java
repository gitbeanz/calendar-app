import java.time.ZonedDateTime;
import java.time.ZoneOffset;
import java.time.ZoneId;
import java.time.LocalDateTime;

public class CalendarEvent extends Identifiable implements Comparable<CalendarEvent>{
    private String description;
    private ZonedDateTime startTime;
    private ZonedDateTime endTime;
    public CalendarEvent(String description, ZonedDateTime startTime, ZonedDateTime endTime){
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
    }
    public void applyEventTimeZoneOffset(ZoneOffset offset){
        ZoneId zone = ZoneId.of(offset.getId());
        LocalDateTime localDateTimeStart = startTime.toLocalDateTime();
        LocalDateTime localDateTimeEnd = endTime.toLocalDateTime();
        this.startTime = ZonedDateTime.ofStrict(localDateTimeStart, offset, zone);
        this.endTime = ZonedDateTime.ofStrict(localDateTimeEnd, offset, zone);
    }
    @Override
    public int compareTo(CalendarEvent other){
        return startTime.compareTo(other.startTime);
    }
    public boolean equals(Object other){
        if (other instanceof CalendarEvent){
            CalendarEvent otherCalendar = (CalendarEvent) other;
            return (this.description == otherCalendar.description && this.startTime == otherCalendar.startTime && this.endTime == otherCalendar.endTime);
        }
        else{
            return false;
        }
    }
    public String toString(){
        String descriptionString = "Description: " + description;
        String startTimeString = "Start Time: " + startTime.toString();
        String endTimeString = "End Time: " + endTime.toString();
        return descriptionString + "\n" + startTimeString + "\n" + endTimeString + "\n";
    }
}

