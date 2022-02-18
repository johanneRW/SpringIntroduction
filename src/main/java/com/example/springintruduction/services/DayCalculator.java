package com.example.springintruduction.services;

import java.time.LocalDate;

public class DayCalculator {

    public String isItFriday() {
        LocalDate date = LocalDate.now();

        int day = date.getDayOfMonth();
        int month = date.getMonthValue();
        int year = date.getYear();

        int dayOfWeek = zellersCongruence(day, month, year);

        String isItFriday = getDayOfTheWeekAsString(dayOfWeek);

        return isItFriday;
    }

    private String getDayOfTheWeekAsString(int dayOfWeek) {
        if (dayOfWeek == 5) {
            return "JA! Det er fredag!";
        } else {
            return "Nej, det er " + getDayOfTheWeek(dayOfWeek);
        }
    }

    private int zellersCongruence(int day, int month, int year) {
        int zellerYear = getZellerYearValue(year, month);
        int q = day;
        int m = getZellerMonthValue(month);
        int j = zellerYear / 100;
        int k = zellerYear % 100;

        int h = (q + ((13 * (m + 1)) / 5) + k + (k / 4) + (j / 4) - (2 * j)) % 7;

        // værdien fra Zeller's Congruence ændres så den svarer til en uge der starter med mandag.
        int dayOfWeek = (((h + 5) % 7) + 1);

        return dayOfWeek;
    }

    private int getZellerYearValue(int year, int month) {
        // hvis vi er i jan eller feb, skal der trækkes 1 fra årstallet, da månederne regnes som 13 og 14 i det foregående år
        int zellerYear;

        if (month == 1 || month == 2) {
            zellerYear = year - 1;
        } else {
            zellerYear = year;
        }

        return zellerYear;
    }

    private int getZellerMonthValue(int month) {
        // jan og feb regnes som månederne 13 og 14
        int zellerMonth;

        if (month == 1) {
            zellerMonth = 13;
        } else if (month == 2) {
            zellerMonth = 14;
        } else {
            zellerMonth = month;
        }

        return zellerMonth;
    }

    private String getDayOfTheWeek(int dayOfWeek) {
        // fredag er med i arrayet, så dagens nummer svare til pladsen minus 1, også for lørdag og søndag.
        String[] dayNames = {"mandag", "tirsdag", "onsdag", "torsdag", "fredag", "lørdag", "søndag"};
        String day = dayNames[dayOfWeek - 1];
        return day;
    }
}
