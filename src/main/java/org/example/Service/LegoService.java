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

    // I can't make this delete part work.
    // * *

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
}
