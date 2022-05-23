package executor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class TimeFinder {

    public void getTimeForTimezone(String timezone) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(timezone.toUpperCase()));
        String formattedDate = simpleDateFormat.format(date);
        System.out.printf("Date for %s is: %s \n", timezone, formattedDate);
    }
}
