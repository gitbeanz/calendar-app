import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;

public class Main {
    public static void main(String[] args) {
        CalendarsApp app = new CalendarsApp();
        System.out.println("Welcome to the Calendar App!\n");
        String username;
        Scanner createUserInput = new Scanner(System.in);
        System.out.println("\nPlease enter your desired username:");
        username = createUserInput.next();
        app.createNewUser(username);

        // MAIN LOOP
        while (true) {
            System.out.println("\n" + username + "'s Calendars Page\n");
            System.out.println("1. Create Calendar");
            System.out.println("2. View Calendar");
            System.out.println("3. Update Calendar");
            System.out.println("4. Delete Calendar");
            System.out.println("5. Exit\n");
            Scanner calendarInput = new Scanner(System.in);
            System.out.println("What would you like to do?: ");
            int calendarChoice = calendarInput.nextInt();
            if (calendarChoice == 1) {
                Scanner calendarNameScanner = new Scanner(System.in);
                System.out.println("\nPlease enter the name of your new calendar: ");
                String calendarName = calendarNameScanner.next();
                app.createCalendar(calendarName);
                System.out.println("\n" + calendarName + " successfully created!\n");
            } else if (calendarChoice == 2) {
                String calendarViewName = app.pickCalendar("view");
                int viewOption = app.pickView();
                List<CalendarEvent> events = new ArrayList<CalendarEvent>();
                Calendar calendar = app.getCalendar(calendarViewName);
                if (viewOption == 1) {
                    events = calendar.getEventsForDay(ZonedDateTime.now());
                    if (events.size() == 0) {
                        System.out.println("\nOops! No events to show");
                    } else {
                        for (CalendarEvent event : events) {
                            System.out.println(event.toString());
                        }
                    }
                } else if (viewOption == 2) {
                    events = calendar.getEventsForWeek(ZonedDateTime.now());
                    if (events.size() == 0) {
                        System.out.println("\nOops! No events to show");
                    } else {
                        for (CalendarEvent event : events) {
                            System.out.println(event.toString());
                        }
                    }
                } else if (viewOption == 3) {
                    events = calendar.getEventsForMonth(ZonedDateTime.now());
                    if (events.size() == 0) {
                        System.out.println("\nOops! No events to show");
                    } else {
                        for (CalendarEvent event : events) {
                            System.out.println(event.toString());
                        }
                    }
                } else if (viewOption == 4) {
                    events = calendar.getEventsForYear(ZonedDateTime.now());
                    if (events.size() == 0) {
                        System.out.println("\nOops! No events to show");
                    } else {
                        for (CalendarEvent event : events) {
                            System.out.println(event.toString());
                        }
                    }
                }

            } else if (calendarChoice == 3) {
                String calendarUpdateName = app.pickCalendar("update");
                int calendarOption = app.pickUpdate();
                if (calendarOption == 1) {
                    Scanner descriptionScanner = new Scanner(System.in);
                    System.out.println("\nEnter event description: ");
                    String descriptionString = descriptionScanner.nextLine();
                    Scanner yearScanner = new Scanner(System.in);
                    System.out.println("\nEnter year that event starts (ex: 2023): ");
                    int year = yearScanner.nextInt();
                    Scanner monthScanner = new Scanner(System.in);
                    System.out.println("\nEnter month number that event starts (ex: type 1 for January): ");
                    int month = monthScanner.nextInt();
                    Scanner dayScanner = new Scanner(System.in);
                    System.out.println("\nEnter day number that event starts (ex: 20): ");
                    int day = dayScanner.nextInt();
                    LocalDate date = LocalDate.of(year, month, day);
                    Scanner hourScanner = new Scanner(System.in);
                    System.out.println("\nEnter hour in military time that event starts (ex: type 13 for 1 PM): ");
                    int hour = hourScanner.nextInt();
                    Scanner minuteScanner = new Scanner(System.in);
                    System.out.println("\nEnter minute that event starts (ex: type 30 for 1:30): ");
                    int minute = minuteScanner.nextInt();
                    Scanner endYearScanner = new Scanner(System.in);
                    LocalTime time = LocalTime.of(hour, minute);
                    LocalDateTime dateTime = LocalDateTime.of(date, time);
                    System.out.println("\nEnter year that event ends (ex: 2023): ");
                    int endYear = endYearScanner.nextInt();
                    Scanner endMonthScanner = new Scanner(System.in);
                    System.out.println("\nEnter month number that event ends (ex: type 1 for January): ");
                    int endMonth = endMonthScanner.nextInt();
                    Scanner endDayScanner = new Scanner(System.in);
                    System.out.println("\nEnter day number that event ends (ex: 20): ");
                    int endDay = endDayScanner.nextInt();
                    LocalDate endDate = LocalDate.of(endYear, endMonth, endDay);
                    Scanner endHoursScanner = new Scanner(System.in);
                    System.out.println("\nEnter hour in military time that event ends (ex: type 13 for 1 PM): ");
                    int endHour = endHoursScanner.nextInt();
                    Scanner endMinutesScanner = new Scanner(System.in);
                    System.out.println("\nEnter minute that event ends (ex: type 30 for 1:30): ");
                    int endMinutes = endMinutesScanner.nextInt();
                    LocalTime endTime = LocalTime.of(endHour, endMinutes);
                    LocalDateTime endDateTime = LocalDateTime.of(endDate, endTime);
                    ZoneId zone = ZoneId.systemDefault();
                    ZonedDateTime eventStartTime = ZonedDateTime.of(dateTime, zone);
                    ZonedDateTime eventEndTime = ZonedDateTime.of(endDateTime, zone);
                    app.addEvent(descriptionString, eventStartTime, eventEndTime);

                }

            } else if (calendarChoice == 4) {
                System.out.println("Deleting calendar...");
            } else if (calendarChoice == 5) {
                System.out.println("Exiting...");
                break;
            }

        }
        createUserInput.close();
    }
}
