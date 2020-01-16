package ca.bcit.comp2522.quizzes.quiz01;

public class Calendar {
    private int days;
    private int daysOfWeek;

    public Calendar(int days, int daysOfWeek) {
        this.days = days;
        this.daysOfWeek = daysOfWeek;
    }

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

    public static void main(String[] args) {
        Calendar cal = new Calendar(30, 5);
        System.out.println(cal.toString());
    }
}
