package org.example;

import org.example.Exception.CLIException;
import org.example.Exception.LegoException;
import org.example.View.CLIParser;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CLIParser cliParser = new CLIParser();

        while(true){
            System.out.println("Enter Add or View");
            String input = sc.nextLine();
            try {
                // 'try' means that this block of code could potentially throw an exception
                // If an exception is thrown during code execution, then the code will switch over
                // to the matching "catch" block
                String output = CLIParser.parseCommandReturnOutput(input);
                System.out.print(output);

            }catch(CLIException exception) {
                // this block w/in "catch" handles the exception if it occurs
                System.out.println("You caused a CLIException! You may have mis-used the CLI.");
                exception.printStackTrace();

            }catch (LegoException exception) {
                System.out.println("You caused a LegoException! Most likely caused by bad input.");
                exception.printStackTrace();

            }

        }
    }
}