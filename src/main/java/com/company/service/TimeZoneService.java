package com.company.service;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.TimeZone;

public class TimeZoneService {
    public void basicsOfTimeZone(){
        System.out.println("-----------------------------------------");
        // get all the  timezones ids defined by TimeZone class
        String[] avilableTimezones = TimeZone.getAvailableIDs();

        // Print Total no of TimeZones
        System.out.println("Total No of Time Zone Available");

        System.out.println(avilableTimezones.length);

        // get all the  timezones  whose offset is
        // 7200000 milliseconds means 2 hour
        String[] timezones = TimeZone.getAvailableIDs(7200000);

        // Print Total no of TimeZones
        System.out.println("No of Time Zone having time offset 2 hour");

        System.out.println(timezones.length);

        // print all timezones names
        System.out.println("Timezone names having time offset 2 hour");

        for (int i = 0; i < timezones.length; i++)
            System.out.println(timezones[i]);

        System.out.println("------------------------------------------");
    }

    public void moreMethods(){
        // Get your Local Time Zone Where this Program is Running.
        TimeZone timezone = TimeZone.getDefault();

        // Get the Name of Time Zone
        String LocalTimeZoneDisplayName = timezone.getDisplayName();

        // Print the Name of Time Zone
        System.out.println(LocalTimeZoneDisplayName);
    }
    
    public void exploreMore(){
        System.out.println("---------------------------------");
        // creating Timezone object whose id is Europe/Berlin 
        TimeZone timezone = TimeZone.getTimeZone("Europe/Berlin");

        // printing the Display Name of this timezone object 
        System.out.println("Display Name");

        System.out.println(timezone.getDisplayName());

        // getting DST in milliseconds 
        int timeInMiliseconds = timezone.getDSTSavings();

        System.out.println("\nDST of Europe/Berlin is");
        System.out.println(timezone.getDSTSavings());

        // get Id of your Default Time Zone 
        TimeZone defaultTimezone = TimeZone.getDefault();

        System.out.println("\nThe id of default Time zone is");
        System.out.println(defaultTimezone.getID());
        System.out.println("---------------------------------");
    }

    public void explore(){
        System.out.println("---------------------------------");
        // creating Timezone object whose id is Europe/Berlin
        TimeZone timezone = TimeZone.getTimeZone("Europe/Berlin");

        // printing offset value
        System.out.println("Offset value of Europe/Berlin:");

        System.out.println(timezone.getOffset(Calendar.ZONE_OFFSET));

        // create Date Object
        Date date = new Date(2017, 04, 16);

        System.out.println("The date is: "+ date);

        // checking the date is in day light time of that Time Zone or not
        System.out.println("\nDate 16/04/2017 is in Day Light Time of");

        System.out.println("Timezone: timezone.getDisplayName()");
        System.out.println(timezone.inDaylightTime(date));

        // check this Time Zone observes Day Light Time or Not
        System.out.println("\nTimeZone name " + timezone.getDisplayName());

        System.out.println("---------------------------------");

    }
    
    public void cloneTimeZone(){
        // My previous Default Time Zone is 
        TimeZone DefaultTimeZone = TimeZone.getDefault();

        System.out.println("Current Default TimeZone:");
        System.out.println(DefaultTimeZone.getDisplayName());

        // Setting  Europe/Berlin as your Default Time Zone 
        TimeZone timezone = TimeZone.getTimeZone("Europe/Berlin");

        TimeZone.setDefault(timezone);
        TimeZone NewDefaultTimeZone = TimeZone.getDefault();
        System.out.println("\nNew Default TimeZone:");
        System.out.println(NewDefaultTimeZone.getDisplayName());

        // change Id Europe/Berlin to Eur/Ber 
        timezone.setID("Eur/Ber");

        System.out.println("\nNew Id of Europe/Berlin is");
        System.out.println(timezone.getID());

        // create copy of a time zone 
        System.out.println("\nOriginal TimeZone ID:");

        System.out.println(timezone.getID());
        TimeZone clonedTimezone = (TimeZone)timezone.clone();
        System.out.println("Cloned TimeZone ID:");
        System.out.println(clonedTimezone.getID());
    }

    public void timeDifference(){
        System.out.println("===================================");
        // Java program to find time difference in term of hour and
        // minute between two places.

        // Take Ids of both places as Input
        Scanner sc = new Scanner(System.in);

        String TimeZoneId1 = sc.nextLine();
        String TimeZoneId2 = sc.nextLine();

        // Using Id of First place find LocalDateTime of that place
        TimeZone timezone1 = TimeZone.getTimeZone(TimeZoneId1);

        LocalDateTime dateTime1 = getDateTime(timezone1);

        // Using Id of Second place find LocalDateTime of that place
        TimeZone timezone2 = TimeZone.getTimeZone(TimeZoneId2);

        LocalDateTime dateTime2 = getDateTime(timezone2);

        // Print the Date and Time of Both TimeZones
        System.out.println("Date and Time of place having Id " + TimeZoneId1);
        System.out.println("Date - " + dateTime1.toLocalDate());
        System.out.println("Time - " + dateTime1.toLocalTime());
        System.out.println("Date and Time of place having Id " + TimeZoneId2);
        System.out.println("Date - " + dateTime2.toLocalDate());
        System.out.println("Time - " + dateTime2.toLocalTime());

        // Find the Difference in terms of minutes between both places
        long diffInMinutes =
                java.time.Duration.between(dateTime1, dateTime2).toMinutes();
        System.out.println("\nDifference in Hour is "
                + Math.abs(diffInMinutes / 60));
        System.out.println("Difference in Minute is "
                + Math.abs(diffInMinutes % 60));

        System.out.println("=================================================");
    }

    static LocalDateTime getDateTime(TimeZone time)
    {

        // Using Time zone get calender object
        Calendar cal = new GregorianCalendar(time);

        // using calender object find the month, year, day, hour, minute
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);

        /*
         * construct LocalDateTime object
        using month, year, day, hour, minute
        */
        LocalDateTime dateTime = LocalDateTime.of(year, month + 1, day,
                hour, minute);

        return dateTime;
    }
}
