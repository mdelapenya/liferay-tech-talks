package io.github.migue.java8.dateandtime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalUnit;
import java.util.Locale;

/**
 * Finally, Java designers have decided to revisit the awful Java Date and Time API. Some of the new features are:
 *
 * 1. All the objects present in the "java.time" are immutable
 * 2. New concept of "point in time" represented by objects of type Instant
 * 3. No leap seconds (86400 seconds per day)
 * 4. Durations: differences between two instants
 * 5. Calendar computations
 * 6. Time formatters
 *
 * @author Miguel Pastor
 */
public class DateAndTimeIntro {

    public static void main(String[] args) {

        // Dealing with instants

        Instant start = Instant.now();
        myComplexAlgorithm();
        Instant end = Instant.now();

        final Duration elapsedTime = Duration.between(start, end);

        System.out.println("Elapsed time " + elapsedTime.toMillis() + " miliseconds");

        // Dealing with local dates

        LocalDate today = LocalDate.now();

        LocalDate myBirthday = LocalDate.of(1982, Month.APRIL, 12);

        // Looking for the 256th day of the year

        LocalDate programmersDay = LocalDate.of(2014, Month.JANUARY, 1).plusDays(255);

        System.out.println("Programmers day is " + programmersDay);

        // Temporal adjusters: very useful for scheduling purposes

        // looking for the first Friday of May

        LocalDate firstFriday = LocalDate.of(2014, Month.MAY, 1).with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY));

        // local time
        LocalTime now = LocalTime.now();

        LocalTime workTime = LocalTime.of(6, 0, 0);

        // Zoned time
        ZonedDateTime zonedDateTime = ZonedDateTime.of(1982, 4, 12, 9, 0, 0, 0, ZoneId.of("Europe/Madrid"));

        System.out.println("I was born in " + zonedDateTime);

        // Formatting: predefined, locale-specific or custom patterns

        System.out.println(DateTimeFormatter.ISO_DATE_TIME.format(zonedDateTime));

        DateTimeFormatter formatter = DateTimeFormatter.BASIC_ISO_DATE.ofLocalizedDate(FormatStyle.FULL);
        String formatted = formatter.format(zonedDateTime);
        System.out.println(formatted);

        System.out.println(formatter.withLocale(Locale.JAPANESE).format(zonedDateTime));
    }

    private static void myComplexAlgorithm() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
