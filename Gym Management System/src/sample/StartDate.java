package sample;

public class StartDate  {

    private int Day;
    private int Month;
    private int Year;
    private String Date;



    public StartDate(){}

    public StartDate(int startDay, int startMonth, int startYear){
        this.Day = startDay;
        this.Month= startMonth;
        this.Year= startYear;

    }


    public void setDay(int startDay){
        this.Day = startDay;

    }
    public int getDay(){
        return Day;
    }


    public void setMonth( int startMonth){
        this.Month = startMonth;
    }

    public int getMonth(){
        return Month;
    }

    public void setYear( int startYear){
        this.Year = startYear;
    }

    public int getYear(){
        return Year;
    }


    public String getDate() {
        Date = Day + "/" + Month + "/" + Year;
        return Date;
    }

    public String toString() {
        return "," + getDate();
    }
}