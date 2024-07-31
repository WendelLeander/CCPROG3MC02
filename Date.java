
/**
 * The Date class represents a specific date and time with a day, hour, and minute.
 * It provides methods to set and get these properties, with validation to ensure
 * the values are within acceptable ranges.
 * 
 * @version 1.0
 * @since 2024-06-22
 */
public class Date {

    private int day;
    private int hour;
    private int minute;

    /**
     * Sets the day of this date.
     * The day must be between 1 and 31 inclusive.
     * 
     * @param day the day to set
     * @return true if the day is valid and set, false otherwise
     */
    public boolean setDay(int day) {
        if (day > 0 && day < 32) { // returns true if day is between 1 and 31 otherwise, false
            this.day = day;
            return true;
        }
        return false;
    }

    /**
     * Sets the hour of this date.
     * The hour must be between 0 and 23 inclusive.
     * 
     * @param hour the hour to set
     * @return true if the hour is valid and set, false otherwise
     */
    public boolean setHour(int hour) {
        if (hour > -1 && hour < 24) { // returns true if hour is between 0 and 23 otherwise, false
            this.hour = hour;
            return true;
        }
        return false;
    }

    /**
     * Sets the minute of this date.
     * The minute must be between 0 and 59 inclusive.
     * 
     * @param minute the minute to set
     * @return true if the minute is valid and set, false otherwise
     */
    public boolean setMinute(int minute) {
        if (minute > -1 && minute < 60) { // returns true if minute is between 0 and 59 otherwise, false
            this.minute = minute;
            return true;
        }
        return false;
    }

    /**
     * Returns the day of this date.
     * 
     * @return the day of this date
     */
    public int getDay() {
        return day;
    }

    /**
     * Returns the hour of this date.
     * 
     * @return the hour of this date
     */
    public int getHour() {
        return hour;
    }

    /**
     * Returns the minute of this date.
     * 
     * @return the minute of this date
     */
    public int getMinute() {
        return minute;
    }
}
