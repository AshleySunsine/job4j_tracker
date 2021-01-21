package ru.job4j.oop;

public class Programmer extends Engineer {
    private String lang;

    public Programmer() {
        super.setBirthday("12.12.2003");
        super.setEducation("Hight");
        super.setMainEngineer(true);
    }

    public String getLang() {
        return "Nul;";
    }
}
