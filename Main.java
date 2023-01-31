import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CalendarsApp app = new CalendarsApp();
        System.out.println("Welcome to the Calendar App!\n");
        System.out.println("1. Log In");
        System.out.println("2. Create New User\n");
        Scanner myInput = new Scanner(System.in);
        System.out.println("What would you like to do?: ");
        int userInput = myInput.nextInt();
        String username;
        if (userInput == 1) {
            try (Scanner logInUserInput = new Scanner(System.in)) {
                System.out.println("\nWelcome back! Please enter your username:");
                username = logInUserInput.next();
                app.loginUser(username);
            }

        } else if (userInput == 2) {
            Scanner createUserInput = new Scanner(System.in);
            System.out.println("\nHello! Please enter your desired username:");
            username = createUserInput.next();
            app.createNewUser(username);

            // MAIN LOOP
            while (true) {
                System.out.println("\n" + username + "'s Calendars Page\n");
                System.out.println("1. Create Calendar");
                System.out.println("2. View Calendar");
                System.out.println("3. Update Calendar");
                System.out.println("4. Delete Calendar");
                System.out.println("5. Exit");
                Scanner calendarInput = new Scanner(System.in);
                System.out.println("What would you like to do?: ");
                int calendarChoice = calendarInput.nextInt();
                if (calendarChoice == 1) {
                    //app.createCalendar();
                } else if (calendarChoice == 2) {
                    System.out.println("Viewing calendar...");
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
        } else {
            System.out.println("Error! Restart app and try again.");
        }
        myInput.close();
    }
}
