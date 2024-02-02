package org.example.View;

import org.example.Exception.CLIException;
import org.example.Exception.LegoException;
import org.example.Model.Lego;
import org.example.Service.LegoService;

import java.util.List;
import java.util.Scanner;

public class CLIParser {

    static LegoService legoService;

    public CLIParser(){
        legoService = new LegoService();

    }


    public static String parseCommandReturnOutput(String command) throws CLIException, LegoException {
        if(command.equals("Add")){
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Lego set name: ");
            String nameInput = sc.nextLine();
            System.out.println("Enter Lego set item number (must be numbers only): ");
            int itemNumberInput = Integer.parseInt(sc.nextLine());
            System.out.println("Enter Lego set difficulty level: ");
            String difficultyRateInput = sc.nextLine();
            legoService.addLego(nameInput, itemNumberInput, difficultyRateInput);
            return "Lego set added! ";

        }else if(command.equals("Delete")) {
            Scanner sc = new Scanner(System.in);
            List<Lego> legos = LegoService.getAllLego();
            if (legos.isEmpty()){
              throw new LegoException("Your Lego list is empty.");
            }
           // System.out.println(legos.toString());
            System.out.println("Enter the Lego set name you want to DELETE: ");
            String nameInput = sc.nextLine();
            legoService.delLego(nameInput);
            return "The Lego set, " + nameInput + ", was successfully deleted! ";


        }else if(command.equals("Edit")){
            Scanner sc = new Scanner(System.in);
            List<Lego> legos = LegoService.getAllLego();
            if (legos.isEmpty()){
                throw new LegoException("Your Lego list is empty.");
            }
         //   System.out.println(legos.toString());
            System.out.println("Enter the name of the Lego set you want to EDIT: ");
            String nameInput = sc.nextLine();
            System.out.println("Enter the new item number (must be numbers only): ");
         //   int newItemNumber = Integer.parseInt(sc.nextLine());
            int editItemNumber = Integer.parseInt(sc.nextLine());
          //  legos.set(1,newItemNumber);
            System.out.println("Enter the new difficulty level: ");
          //  String newDifficultyRating = sc.nextLine();
            String editDifficultyRating = sc.nextLine();
          //  legoService.editLego(nameInput, newItemNumber, newDifficultyRating);
            Lego newLego = new Lego(nameInput, editItemNumber, editDifficultyRating);
            legoService.editLego(nameInput, editItemNumber, editDifficultyRating, newLego);
          //  legos.replaceAll();
            return "The Lego set, " + nameInput + ", was successfully updated! ";



        }else if(command.equals("View")){
            List<Lego> legos = LegoService.getAllLego();
            if (legos.isEmpty()) {
                throw new LegoException("Your Lego list is empty.");
            }else {
                return "Here are your Lego sets: " + legos.toString();
            }

        }else{
          //  return "";  // this will return nothing ("Enter Add or View" will display again)
            throw new CLIException("not a valid entry");
        }
    }
}

