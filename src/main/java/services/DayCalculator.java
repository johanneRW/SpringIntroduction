package services;

import java.time.LocalDate;

public class DayCalculator {

    public String isItFriday() {
        LocalDate date = LocalDate.now();

        int day = date.getDayOfMonth();
        int month = date.getMonthValue();
        int year = date.getYear();

      /*int day = 4;
        int month = 2;
        int year = 2022;*/

        int dayOfWeek = zellersConguense(day, month, year);

        String isItFriday = getDayOfTheWeekAsString(dayOfWeek);

        return isItFriday;
    }

    private String getDayOfTheWeekAsString(int dayOfWeek) {
        if (dayOfWeek == 5) {
            return "JA! Det er fredag!";
        } else return "Nej, det er " + getDayOfTheWeek(dayOfWeek);

    }

    private int zellersConguense(int day, int month, int year) {
        int zellerYear = getZellerValueOfYear(year, month);
        int q = day;
        int m = getZellerValueOfMonth(month);
        int j = zellerYear / 100;
        int k = zellerYear % 100;

        int h = (q + ((13 * (m + 1)) / 5) + k + (k / 4) + (j / 4) - (2 * j)) % 7;

        int dayOfWeek = (((h + 5) % 7) + 1);

        return dayOfWeek;
    }

    private int getZellerValueOfYear(int year, int month) {
        int zellerYear;
        if (month == 1 || month == 2) {
            zellerYear = year - 1;
        } else zellerYear = year;
        return zellerYear;

    }

    private int getZellerValueOfMonth(int month) {
        int zellerMonth;
        if (month == 1) {
            zellerMonth = 13;
        } else if (month == 2) {
            zellerMonth = 14;
        } else zellerMonth = month;
        return zellerMonth;
    }


    private String getDayOfTheWeek(int dayOfWeek) {
        String[] dayNames = {"mandag", "tirsdag", "onsdag", "torsdag", "fredag", "lørdag", "søndag"};
        String day = dayNames[dayOfWeek - 1];
        return day;
    }
}
