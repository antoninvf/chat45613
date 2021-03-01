package com.company;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // scanner :OO::OO::O ::o:O: wow scanner :O:O:O: : o:O: o: O:o:op:o

        String username;
        String receivemsg = "";
        String entermsg;

        //Reading
        try {
            BufferedReader br = new BufferedReader(new FileReader("messageHistory.txt"));
            String next = br.readLine();
            while (next != null) {
                receivemsg += next + "\n";
                next = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            System.out.println("!! ### Reading Error ### !!");
        }

        //GUI
        System.out.println("##########################");
        System.out.println("# Welcome to #chat45613! #");
        System.out.println("##########################");
        System.out.println();
        System.out.println("> What is your USERNAME?");
        username = sc.nextLine();
        System.out.println("Login Successful!");
        System.out.println();
        System.out.println("> Welcome " + username + "!");
        System.out.println("> Messages:");
        System.out.println("----------------------");
        System.out.println(receivemsg); //Receive message
        System.out.println("----------------------");
        System.out.println("> Would you like to send a message? (Y/N)");
        String answer = sc.nextLine().toLowerCase();
        while(true) {
            if (answer.equals("no") || answer.equals("n")) { //NO = exits the program
                System.out.println();
                System.out.println("Goodbye " + username + "!");
                System.exit(0);
            } else if (answer.equals("yes") || answer.equals("y")) { //YES = brings the user into "send message mode"
                System.out.println();
                System.out.println("> To exit out of the program type '!quit'");
                System.out.println();
                while (true) {
                    //Enter message
                    entermsg = sc.nextLine();
                    if (entermsg.equals("!quit")) {
                        System.out.println();
                        System.out.println("Goodbye " + username + "!");
                        System.exit(0);
                    }
                    //Writing
                    try {
                        BufferedWriter bw = new BufferedWriter(new FileWriter("messageHistory.txt", true));
                        bw.write(username + ": " + entermsg);
                        bw.newLine();
                        bw.close();

                    } catch (IOException e) {
                        System.out.println("!! ### Writing Error ### !!");
                    }
                }
            } else { //Simple stupid proofing
                System.out.println("You're stupid, that's not a valid option.");
                System.out.println("I'm gonna presume you wanted to send a message.");
                System.out.println();
                answer = "yes"; // lol
            }
        }
    }
}
