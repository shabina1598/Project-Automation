package utility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class DateUtility {

    
    public static String getCurrentDate(String pattern) {
        return LocalDate.now().format(DateTimeFormatter.ofPattern(pattern));
    }

    
    public static String addDaysToCurrentDate(int days, String pattern) {
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern(pattern));
    }

    
    public static String subtractDaysFromCurrentDate(int days, String pattern) {
        return LocalDate.now().minusDays(days).format(DateTimeFormatter.ofPattern(pattern));
    }

    
    public static LocalDate parseDate(String dateStr, String pattern) {
        return LocalDate.parse(dateStr, DateTimeFormatter.ofPattern(pattern));
    }

    
    public static String formatDate(LocalDate date, String pattern) {
        return date.format(DateTimeFormatter.ofPattern(pattern));
    }

    
    public static boolean isDateAfter(String date1, String date2, String pattern) {
        LocalDate d1 = parseDate(date1, pattern);
        LocalDate d2 = parseDate(date2, pattern);
        return d1.isAfter(d2);
    }

   
    public static boolean isDateBefore(String date1, String date2, String pattern) {
        LocalDate d1 = parseDate(date1, pattern);
        LocalDate d2 = parseDate(date2, pattern);
        return d1.isBefore(d2);
    }

    
    public static long getDaysBetween(String start, String end, String pattern) {
        LocalDate s = parseDate(start, pattern);
        LocalDate e = parseDate(end, pattern);
        return ChronoUnit.DAYS.between(s, e);
    }

    
    public static String getFirstDayOfMonth(String pattern) {
        return LocalDate.now().withDayOfMonth(1).format(DateTimeFormatter.ofPattern(pattern));
    }

    
    public static String getLastDayOfMonth(String pattern) {
        return LocalDate.now().withDayOfMonth(LocalDate.now().lengthOfMonth()).format(DateTimeFormatter.ofPattern(pattern));
    }

    
    public static String convertDateFormat(String date, String fromPattern, String toPattern) {
        LocalDate parsed = LocalDate.parse(date, DateTimeFormatter.ofPattern(fromPattern));
        return parsed.format(DateTimeFormatter.ofPattern(toPattern));
    }

    
    public static String getRandomDateBetween(String start, String end, String pattern) {
        LocalDate startDate = parseDate(start, pattern);
        LocalDate endDate = parseDate(end, pattern);
        long days = ChronoUnit.DAYS.between(startDate, endDate);
        LocalDate randomDate = startDate.plusDays(new Random().nextInt((int) days + 1));
        return randomDate.format(DateTimeFormatter.ofPattern(pattern));
    }

}
