package lv.polarisit.salarycalc.fidavista.helpers;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class FidavistaHelper {

    public static String generateCurrentTimestamp() {
        // Get the current date and time
        LocalDateTime now = LocalDateTime.now();

        // Define the formatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");

        // Format the current date and time
        return now.format(formatter);
    }

    public static String formatCurrentDate() {
        // Get the current date
        LocalDate today = LocalDate.now();

        // Define the formatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Format the current date
        return today.format(formatter);
    }

}