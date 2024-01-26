//  Service is responsible for creating and managing Lego objects

package org.example.Service;


import org.example.Exception.LegoException;
import org.example.Model.Lego;

import java.util.ArrayList;
import java.util.List;

public class LegoService {
    static List<Lego> legos;
    public LegoService() {
        legos = new ArrayList<>();
    }

    public void addLego(String name, int itemNumber, String difficultyRate) throws LegoException {
        if (name.length()<1) {
            throw new LegoException("Lego name cannot be blank");
        } else if (itemNumber < 0) {
            throw new LegoException("Please enter a NUMBER!");
        } else if (difficultyRate.length()<1) {
            throw new LegoException("Difficulty Rate cannot be blank");
        }

        Lego l = new Lego(name, itemNumber, difficultyRate);
        legos.add(l);

    }
    public static List<Lego> getAllLego(){
        return legos;

    }
}
