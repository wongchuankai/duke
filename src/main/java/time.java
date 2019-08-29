public class time {
    private String day;
    private String month;
    private String year;
    private String time;

    public time (int day, int month, int year, String time) {
        if(day == 1) {
            this.day = day +"st";
        }
        else if (day == 2) {
            this.day = day + "nd";
        }
        else if (day == 3) {
            this.day = day + "rd";
        }
        else {
            this.day = day + "th";
        }

        if (month == 1) {
            this.month = "January";
        }
        else if (month == 2) {
            this.month = "February";
        }
        else if (month == 3) {
            this.month = "March";
        }

        else if (month == 4) {
            this.month = "April";
        }
        else if (month == 5) {
            this.month = "May";
        }
        else if (month == 6) {
            this.month = "June";
        }
        else if (month == 7) {
            this.month = "July";
        }
        else if (month == 8) {
            this.month = "August";
        }
        else if (month == 9) {
            this.month = "September";
        }
        else if (month == 10) {
            this.month = "October";
        }
        else if (month == 11) {
            this.month = "November";
        }
        else if (month == 12) {
            this.month = "December";
        }
        this.year = year +"";
        //1800
        this.time = convert(time);

    }

    public String convert(String time) {
        String output = "";
        String t = time;
        String hour = time.charAt(0) + "" + time.charAt(1);
        String mins = time.charAt(2) + "" + time.charAt(3);
        int hourr = Integer.parseInt(hour);
        if (hourr<12) {
            output = hour + "." + mins + "am";
        } else if (hourr == 12) {
            output = hour + "." + mins + "pm";
        }
       else {
           hourr = hourr - 12;
           output = hourr + "." + mins + "pm";
        }
       return output;
    }

    public String toString() {
        String t = this.day + " of " + this.month + " " + this.year + ", " + this.time;
        return t;
    }
}