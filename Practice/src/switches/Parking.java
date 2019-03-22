package switches;

import java.util.Scanner;

public class Parking {

    private Scanner myScanner = new Scanner(System.in);

    private String dataEntry(String field) {
        String newInput;

        System.out.println("Enter " + field + ":");
        newInput = myScanner.nextLine();

        return newInput;
    }

    private String getDay(String day) {
        boolean init = (day.equals(""));

        if (init) {
            System.out.println("What day is it?");
            day = dataEntry("day");
        }

        switch (day) {
            case "monday":
            case "tuesday":
            case "wednesday":
            case "thursday":
            case "friday":
            case "saturday":
            case "sunday":
                break;
            default:
                System.out.println(day + " is not a recognised day.\n" +
                        "Options are 'Monday', 'Tuesday', 'Wednesday', 'Thursday', " +
                        "'Friday', 'Saturday', or 'Sunday'.");
                day = dataEntry("new day").toLowerCase();
                day = getDay(day);
        }

        return day;

    }

    private String getPosition(String position) {
        boolean init = (position.equals(""));

        if (init) {
            System.out.println("What position do you hold within the college?\n" +
                    "(Staff/Student/Visitor)");
            position = dataEntry("position");
        }

        switch (position) {
            case "staff":
            case "student":
            case "visitor":
                break;
            default:
                System.out.println(position + " is not a recognised position.\n" +
                        "Options are 'Staff', 'Student', or 'Visitor'.");
                position = dataEntry("new position").toLowerCase();
                position = getPosition(position);
        }

        return position;

    }

    private int getDuration() {
        int duration;
        String input;

        System.out.println("How long will you be staying?");
        input = dataEntry("time (in hours)");
        //TODO make this check if it will parse, first
        duration = Integer.parseInt(input);
        return duration;
    }


    private int calculateFees(String day, int duration, String position) {

        int multiplier = 0, hourlyrate = 0;

        switch (position) {
            case "staff":
                multiplier = 2;
                break;
            case "student":
                multiplier = 1;
                break;
            case "visitor":
                multiplier = 3;
                break;
        }

        switch (day) {
            case "monday":
            case "tuesday":
            case "thursday":
                hourlyrate = 2;
                break;
            case "wednesday":
            case "friday":
                hourlyrate = 3;
                break;
            case "saturday":
                hourlyrate = 4;
                break;
            case "sunday":
                hourlyrate = 5;
                break;
        }

        return (hourlyrate * multiplier) * duration;

    }

    private void getInput() {
        String day, position;
        int duration, cost;

        day = getDay("");

        duration = getDuration();

        position = getPosition("");

        cost = calculateFees(day, duration, position);
        System.out.println("Thanks for parking at Gateshead College, please pay: " + cost);

    }

    public static void main(String[] args) {
        Parking ghParking = new Parking();
        ghParking.getInput();
    }

}
