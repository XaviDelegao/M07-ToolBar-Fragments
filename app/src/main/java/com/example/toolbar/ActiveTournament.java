package com.example.toolbar;

public class ActiveTournament {

    private String game;
    private String weekDay;
    private String info;
    private int day;
    private String month;
    private int year;

    public ActiveTournament(String game, String weekDay, String info, int day, String month, int year) {
        this.game = game;
        this.weekDay = weekDay;
        this.info = info;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public String getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
