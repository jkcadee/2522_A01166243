package ca.bcit.comp2522.quizzes.quiz01;

public class Calendar {
    private int days;
    private int daysOfWeek;

    /**
     * Initializes the attributes of days and daysOfWeek when constructed.
     *
     * @param days The first parameter. It is an integer type value.
     * @param daysOfWeek The second parameter. It is an integer type value.
     */

    public Calendar(int days, int daysOfWeek) {
        this.days = days;
        this.daysOfWeek = daysOfWeek;
    }

    /**
     * Returns a string formatted into a traditional calendar.
     *
     * @return A formatted string.
     */

    public String toString() {
        String c = "\tSun\tMon\tTue\tWed\tThu\tFri\tSat\n";
        for (int i = 1; i <= days + daysOfWeek; i++) {
            if (i > daysOfWeek) {
                c += "\t" + (i - daysOfWeek);
            } else {
                c += "\t";
            }
            if (i % 7 == 0) {
                c += "\n";
            }
        }
        return c;
    }

    /**
     * Instantiates a new Calendar object and prints out the string returned from toString.
     *
     * @param args Not used.
     */

    public static void main(String[] args) {
        Calendar cal = new Calendar(30, 5);
        System.out.println(cal.toString());
    }
}
