import java.util.Scanner;

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
                String calendar = app.pickCalendar();
            } else if (calendarChoice == 3) {
                System.out.println("Updating calendar...");
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
