package com.company;

import java.sql.Timestamp;
import java.time.ZoneId;
import java.util.Date;
import com.company.service.DateService;
import com.company.service.TimeZoneService;

public class MainApplication {
    public static void main(String[] args) {
        final DateService dateService= new DateService();
        final TimeZoneService timeZoneService= new TimeZoneService();
        Timestamp timestamp= new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp);
        System.out.println(Date.from(timestamp.toInstant()));
        System.out.println(Date.from(timestamp.toInstant().atZone(ZoneId.of("Asia/Chita")).toInstant()));
        System.out.println("=========================================");
        
        dateService.dateConstructorEx();
        dateService.dateImpFunctions();
        timeZoneService.basicsOfTimeZone();
        timeZoneService.moreMethods();
        timeZoneService.exploreMore();
        timeZoneService.explore();
        timeZoneService.cloneTimeZone();
        timeZoneService.timeDifference();
    }
}
