package com.example.toolbar;

public class Tournament {
    private int day;
    private String month;
    private int year;
    private int resultat;

    public Tournament(int day, String month, int year, int resultat) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.resultat = resultat;
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

    public int getResultat() {
        return resultat;
    }

    public void setResultat(int resultat) {
        this.resultat = resultat;
    }
}
