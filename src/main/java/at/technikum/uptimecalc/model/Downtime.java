package at.technikum.uptimecalc.model;

public class Downtime {

    private String daily;
    private String weekly;
    private String monthly;
    private String quarterly;
    private String yearly;

    public Downtime(String daily, String weekly, String monthly, String quarterly, String yearly) {
        this.daily = daily;
        this.weekly = weekly;
        this.monthly = monthly;
        this.quarterly = quarterly;
        this.yearly = yearly;
    }

    public String getDaily() {
        return daily;
    }

    public void setDaily(String daily) {
        this.daily = daily;
    }

    public String getWeekly() {
        return weekly;
    }

    public void setWeekly(String weekly) {
        this.weekly = weekly;
    }

    public String getMonthly() {
        return monthly;
    }

    public void setMonthly(String monthly) {
        this.monthly = monthly;
    }

    public String getQuarterly() {
        return quarterly;
    }

    public void setQuarterly(String quarterly) {
        this.quarterly = quarterly;
    }

    public String getYearly() {
        return yearly;
    }

    public void setYearly(String yearly) {
        this.yearly = yearly;
    }
}
