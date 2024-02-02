//  Service is responsible for creating and managing Lego objects

package org.example.Service;


import org.example.Exception.LegoException;
import org.example.Main;
import org.example.Model.Lego;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class LegoService {
    static List<Lego> legos;
    public LegoService() {
        legos = new ArrayList<>();
    }

    public void addLego(String name, int itemNumber, String difficultyRate) throws LegoException {
        Main.log.info("Attempting to add a Lego." + name +", " +itemNumber +", " + difficultyRate);
        if (name.length()<1) {
            Main.log.warn("throwing Lego exception due to misformatted name: "+name);
            throw new LegoException("Lego name cannot be blank");
        } else if (itemNumber < 0) {
            Main.log.warn("throwing Lego exception due to misformatted item number: "+itemNumber);
            throw new LegoException("Please enter a NUMBER!");
        } else if (difficultyRate.length()<1) {
            Main.log.warn("throwing Lego exception due to misformatted difficulty rate: "+difficultyRate);
            throw new LegoException("Difficulty Rate cannot be blank");
        }

        Lego l = new Lego(name, itemNumber, difficultyRate);
        legos.add(l);

    }
    public static List<Lego> getAllLego(){
        Main.log.info("Now retrieving all Lego: "+legos);
        return legos;

    }

    public void delLego (String name) throws LegoException {
        Main.log.info("Attempting to delete a Lego." + name);

              if (name.length() < 1) {
            Main.log.warn("throwing Lego exception due to empty name: " + name);
           throw new LegoException("Lego name cannot be blank");
        }
        Iterator<Lego> iterator = legos.iterator();
        while (iterator.hasNext()) {
            Lego lego = iterator.next();
            if (lego.getName().equalsIgnoreCase(name)) {
                iterator.remove();
                System.out.println("Lego set has been deleted!");
                return;
            }
        }

   }
    /*public void editLego (String name, int itemNumber, String difficultyRate) throws LegoException {
        Main.log.info("Attempting to edit a Lego entry." + name + ", " + itemNumber + ", " + difficultyRate);

        if (name.length()<1) {
            Main.log.warn("throwing Lego exception due to misformatted name: "+name);
            throw new LegoException("Lego name cannot be BLANK!");
        } else if (itemNumber < 0) {
            Main.log.warn("throwing Lego exception due to misformatted item number: "+itemNumber);
            throw new LegoException("Please enter a NUMBER!");
        } else if (difficultyRate.length()<1) {
            Main.log.warn("throwing Lego exception due to misformatted difficulty rate: "+difficultyRate);
            throw new LegoException("Difficulty Rate cannot be BLANK!");
        }


    }*/

    public void editLego (String name, int editItemNumber, String editDifficultyRate, Lego newLego) throws LegoException {
        Main.log.info("Attempting to edit a Lego entry." + name + ", " + editItemNumber + ", " + editDifficultyRate);

        if (name.length() < 1) {
            Main.log.warn("throwing Lego exception due to misformatted name: " + name);
            throw new LegoException("Lego name cannot be BLANK!");
        } else if (editItemNumber < 0) {
            Main.log.warn("throwing Lego exception due to misformatted item number: " + editItemNumber);
            throw new LegoException("Please enter a NUMBER!");
        } else if (editDifficultyRate.length() < 1) {
            Main.log.warn("throwing Lego exception due to misformatted difficulty rate: " + editDifficultyRate);
            throw new LegoException("Difficulty Rate cannot be BLANK!");
        }

        for (Lego l : legos) {
            if (l.getName().equals(name)) {
                legos.set(editItemNumber, new Lego (name, editItemNumber, editDifficultyRate));
                return;
            }
        }
        throw new LegoException("Lego with name " + name + " not found");

      //  Lego l = new Lego(name, editItemNumber, editDifficultyRate);
       // editLego(name, editItemNumber, editDifficultyRate, newLego);

    }
}
