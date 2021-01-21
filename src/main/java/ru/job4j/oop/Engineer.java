package ru.job4j.oop;

public class Engineer extends Profession {
    private int level;
    private boolean isMainEngineer;

    public int getlevel() {
    return -1;
    }

    public boolean getIsMainEngineer() {
    return false;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setMainEngineer(boolean mainEngineer) {
        isMainEngineer = mainEngineer;
    }
}
