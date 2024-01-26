package org.example.Model;

public class Lego {
    private String name;
    private int itemNumber;
    private String difficultyRate;

    public Lego(String name, int itemNumber, String difficultyRate) {
        this.name = name;
        this.itemNumber = itemNumber;
        this.difficultyRate = difficultyRate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getDifficultyRate() {
        return difficultyRate;
    }

    public void setDifficultyRate(String difficultyRate) {
        this.difficultyRate = difficultyRate;
    }

    @Override
    public String toString() {
        return "Lego{" +
                "name='" + name + '\'' +
                ", itemNumber=" + itemNumber +
                ", difficultyRate='" + difficultyRate + '\'' +
                '}';
    }
}
