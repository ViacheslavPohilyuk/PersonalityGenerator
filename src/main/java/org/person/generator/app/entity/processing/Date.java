package org.person.generator.app.entity.processing;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * Created by mac on 23.02.17.
 */
public class Date {
    private String dateString;
    private int monthIndex;

    public Date(String dateString) {
        this.dateString = dateString;
        this.monthIndex = (dateString.indexOf(' ') + 1);
    }

    public LocalDate getLocaleDate() {
        Instant instant = dateFormater().toInstant();
        ZoneId zoneId = ZoneId.of ("Africa/Cairo");
        ZonedDateTime zoneTime = ZonedDateTime.ofInstant (instant, zoneId);
        return zoneTime.toLocalDate();
    }

    private java.util.Date dateFormater() {
        SimpleDateFormat dataFormat = new SimpleDateFormat("dd.MM.yyyy");

        String day = getDay();
        String month = monthIndex(getMonth());
        String year = getYear();

        java.util.Date birthday = null;
        try {
            String birthdayString = day + "." + month + "." + year;
            birthday = dataFormat.parse(birthdayString);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        return birthday;
    }

    private String getDay() {
        String day = (monthIndex < 3)? "0" : "";
        for(int i = 0; i < (monthIndex - 1); i++)
            day += dateString.charAt(i);

        return day;
    }

    private String getYear() {
        String year = "";
        final int yearSize = 4;
        char[] buffer = new char[yearSize];
        int dateSize = (dateString.length() - 1);

        int j = 0;
        for(int i = dateSize; i > (dateSize - 4); i--) {
            buffer[yearSize - 1 - j] = dateString.charAt(i);
            j++;
        }

        for(char buff : buffer)
            year += buff;

        return year;
    }

    private String getMonth() {
        char symbol;
        boolean flag = false;

        StringBuilder buffer = new StringBuilder(12);
        String month = "";
        while (!flag) {
            symbol = dateString.charAt(monthIndex);
            if(symbol != ' ') {
                buffer.append(symbol);
                monthIndex++;
            }
            else {
                flag = true;
                month = buffer.toString();
            }
        }
        return month;
    }

    private String monthIndex(String month) {
        String[] months = {
                "января", "февраля", "марта",
                "апреля", "мая", "июня",
                "июля", "августа", "сентября",
                "октября", "ноября","декабря"
        };
        int i = 1;
        for (String m : months) {
            if (month.equals(m))
                break;
            i++;
        }

        String number = Integer.toString(i);
        String monthNumber = (i < 10)? ("0" + number) : number;

        return monthNumber;
    }
}
