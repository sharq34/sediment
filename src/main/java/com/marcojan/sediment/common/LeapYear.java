package com.marcojan.sediment.common;

/**
 * Created by Marco on 21/04/2017.
 */
public class LeapYear {

    private static int[] daysInMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    int dayOfYear(int year, int month, int day) {

        verifyParameters(year, month, day);

        int dayOfYear = 0, baseDays = 0;

        for (int i = 0; i < month; i++) {
            baseDays += daysInMonth[i];
        }

        dayOfYear = baseDays + day;

        return isLeapYear(year) && month > 2 ? dayOfYear + 1 : dayOfYear;
    }

    private boolean isLeapYear(int year) {

        boolean isLeapYear = false;

        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
            isLeapYear = true;

        return isLeapYear;
    }

    private void verifyParameters(int year, int month, int day) {

        if (month < 1 || month > 12)
            throw new DateUtilException("Value of month cannot be more than 12 or less than 1.");

        if (month == 2) {

            if (isLeapYear(year)) {

                if (day < 0 || day > 29)
                    throw new DateUtilException("Value of day is incorrect.");

            } else {

                if (day < 0 || day > 28)
                    throw new DateUtilException("Value of day is incorrect.");
            }

        } else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {

            if (day < 0 || day > 31)
                throw new DateUtilException("Value of day is incorrect.");

        } else if (month == 4 || month == 6 || month == 9 || month == 11) {

            if (day < 0 || day > 30)
                throw new DateUtilException("Value of day is incorrect.");

        }

    }

    private class DateUtilException extends RuntimeException {

        public DateUtilException(String msg) {
            super(msg);
        }
    }

}
