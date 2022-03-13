package ArifZahirOOPCW;
import java.util.Scanner;  // Import the Scanner class
import java.util.ArrayList; // import the ArrayList class
import java.util.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class formulea1ChampionshipManager extends championshipManager {
    
    public static void main(String[] args) {

        ArrayList<formulea1Driver> driverList = new ArrayList<formulea1Driver>(); // Create an ArrayList object
        

        //https://mkyong.com/java/how-to-read-and-write-java-object-to-a-file/
        //https://howtodoinjava.com/java/collections/arraylist/serialize-deserialize-arraylist/
        
        
        /*try {
            File programSave = new File("driverSave1.txt");
            if (programSave.createNewFile()) {
              System.out.println("File created: " + programSave.getName());
            } else {
                System.out.println("Loading last Save......");
                //read then assign to arraylist
                try {
                FileInputStream fis = new FileInputStream("employeeData");
                ObjectInputStream ois = new ObjectInputStream(fis);
 
                driverList = (ArrayList) ois.readObject();
 
                ois.close();
                fis.close();

                } catch (IOException ioe) {
                    ioe.printStackTrace();
                    return;
                } catch (ClassNotFoundException c) {
                    System.out.println("Class not found");
                    c.printStackTrace();
                    return;
                }
         
                //Verify list data
                

            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }*/
        
        
         //Console interface
        System.out.println();
        System.out.println("----------------------------------------------");
        System.out.println("Welcome to the Formulea 1 Championship Manager");

        boolean flagVariable = true;
        
        

        
        //loop for console interface to keep running until exit function;
        do {
            
            System.out.println("-------------------------------------------------------------------------------------------------------");
            System.out.println();
 
            System.out.println("Select the number of the choice according to the menu:");
            System.out.println();
            Scanner myScanner = new Scanner(System.in);  // Create a Scanner object
            //options list for user
            System.out.println("Press 1 - Create new Driver");
            //the rest goes here i guess
            System.out.println("Press 2 - Delete a Driver and Team");
            System.out.println("Press 3 - Change the Driver for an existing Team");
            System.out.println("Press 4 - Display Statistics for a certain Driver");
            System.out.println("Press 5 - Display Formulea 1 Standings Table");
            System.out.println("Press 6 - Add new Race statistics");
            System.out.println("Press 7 - Save Program");
            System.out.println("Press 8 - Exit the Program");
            System.out.println(); //for space

            //input from user
            int userChoice = myScanner.nextInt();
            switch (userChoice) {
                case 1:
                    //create Driver function
                    //add defualt constructor
                    //new scanner for taking in the details of the driver
                    Scanner driverDetails = new Scanner(System.in);

                    System.out.println("Please Input the driver's first name");
                    //storing the input in a variable to use in the constructor
                    String inputFirstName = driverDetails.nextLine();
                    
                    System.out.println("Please Input the driver's last name");
                    String inputSurname = driverDetails.nextLine();

                    System.out.println("Please Input the driver's current Location(enter null if unknown)");
                    String inputLocation = driverDetails.nextLine();

                    System.out.println("Please Input the driver's Team");
                    String inputTeam = driverDetails.nextLine();

                    //will have to add a try catch here incase the user inputs the wrong data type
                    System.out.println("Please Input the driver's age");
                    int inputAge = driverDetails.nextInt();

                    System.out.println("Please Input the driver's Points(enter 0 if no points)");
                    int inputPoints = driverDetails.nextInt();

                    System.out.println("Please Input the number of races participated by the driver this season");
                    int inputParticipation = driverDetails.nextInt();

                    System.out.println("Please Input the number of races completed this season(in the case of the driver not finishing a race/s this number would be less than the participation)");
                    int inputCompletedRaces = driverDetails.nextInt();

                    //using the input into the constructor
                    //formulea1Driver Driver1  = new formulea1Driver(inputFirstName, inputSurname, inputLocation, inputTeam, inputAge, inputPoints, inputParticipation, inputCompletedRaces);
                    formulea1Driver Driver1 = new formulea1Driver(inputFirstName, inputSurname, inputLocation, inputTeam, inputAge, inputPoints, inputParticipation, inputCompletedRaces);
                    
                    System.out.println();
                    driverList.add(Driver1);
                    //driverList.remove(SampleDriver);
                    System.out.println("New driver has been created Successfully.");
                    
                    
                    break;

                case 2:
                    System.out.println("Enter the number of the driver You want to delete: ");
                    //make this a function so i dont have to reuse this
                    for (int i = 0; i < driverList.size(); i++) {
                        System.out.println(i+ ") " + driverList.get(i).surname);
                    }
                    Scanner DeleteDriver = new Scanner(System.in);
                    int deleteDriverInput = DeleteDriver.nextInt();
                    //System.out.println("Are you sure you want to delete this driver?");
                    driverList.remove(deleteDriverInput);

                    
                    //add an are you sure just in case
                    for (int i = 0; i < driverList.size(); i++) {
                        System.out.println(i+ ") " + driverList.get(i).surname);
                    }
                    System.out.println();
                    System.out.println("Driver deleted Successfully.");
                    break;

                case 3:
                    //
                    System.out.println("Which team would you like to change the driver for? (enter the index number) ");

                    for (int i = 0; i < driverList.size(); i++) {
                        System.out.println(i+ ") " + driverList.get(i).surname);
                    }

                    Scanner TeamChanger = new Scanner(System.in);
                    int teamChangeInput = TeamChanger.nextInt();

                    System.out.println("");

                    Scanner TeamChangerScan = new Scanner(System.in);
                    System.out.println("Enter the new first name of the new Driver for this team: ");
                    String newFirstName = TeamChangerScan.nextLine();
                    System.out.println("Enter the new Surname name of the new Driver for this team: ");
                    String newSurnameinnit = TeamChangerScan.nextLine();
                    System.out.println("Enter the Location of the new Driver for this team: ");
                    String newLoactioninnit = TeamChangerScan.nextLine();
                    System.out.println("Enter the new Age name of the new Driver for this team: ");
                    int newAgeinnit = TeamChangerScan.nextInt();

                    driverList.get(teamChangeInput).setTeam(newFirstName, newSurnameinnit, newLoactioninnit, newAgeinnit);

                    System.out.println();
                    //change driver for existing team
                    for (int i = 0; i < driverList.size(); i++) {
                        System.out.println(i+ ") " + driverList.get(i).surname);
                    }
                    System.out.println("New Driver added to team Successfully.");
                    break;

                case 4:
                    //display statistics functions
                    System.out.println("Which driver's statistics would you like to see? (Enter the index number please) : ");
                    //yep i definetly need a function for this code efficiency 100
                    for (int i = 0; i < driverList.size(); i++) {
                        System.out.println(i+ ") " + driverList.get(i).surname);
                    }
                    
                    System.out.println();
                    Scanner StatisticsScanner = new Scanner(System.in);
                    int driverStatisticsInput = StatisticsScanner.nextInt();
                    System.out.println("First Name: " + driverList.get(driverStatisticsInput).firstName);
                    System.out.println("Last Name: " + driverList.get(driverStatisticsInput).surname);
                    System.out.println("Location: " + driverList.get(driverStatisticsInput).location);
                    System.out.println("Team: " + driverList.get(driverStatisticsInput).team);
                    System.out.println("Age: " + driverList.get(driverStatisticsInput).age);
                    System.out.println("Points: " + driverList.get(driverStatisticsInput).points);
                    System.out.println("Races Participated in: " + driverList.get(driverStatisticsInput).racesParticipated);
                    System.out.println("Races Completed: " + driverList.get(driverStatisticsInput).racesCompleted);

                    System.out.println();
                    System.out.println("*Cool statistics successfully displayed");
                    break;

                case 5:
                    //displays driver table
                    //driverList.sort(Comparator.comparing(Driver1::points));
                    //check out sorting mechanisms and then sort boom
                    Collections.sort(driverList);
  
                    for (formulea1Driver str : driverList) {
                        System.out.println(str);
                    }
                    System.out.println();
                    System.out.println("*Displays table");
                    break;
                    
                case 6: 
                    //add race function
                    System.out.println("Enter the date of the race: ");
                    Scanner DateChecker = new Scanner(System.in);
                    String dateOfTheRace = DateChecker.nextLine();

                    ArrayList<String> dates = new ArrayList<String>();
                    dates.add(dateOfTheRace);

                    Boolean raceLoop = true;

                    while (raceLoop = true) {
                        for (int i = 0; i < driverList.size(); i++) {
                            System.out.println(i+ ") " + driverList.get(i).surname);
                        }

                        System.out.println();
                        System.out.println("Select the index number of a driver to update his/her position statistics (Points will be calculated automatically)");
                        Scanner newRaceStats = new Scanner(System.in);
                        int raceStatSelector = newRaceStats.nextInt();

                        driverList.get(raceStatSelector).racesParticipated++;
                        driverList.get(raceStatSelector).addPointsToDriver();

                        /*System.out.println("Did the driver complete the race? (press 'y' or 'n') ");
                        Scanner confirmationScanner = new Scanner(System.in);
                        String confirmation = confirmationScanner.nextLine();

                        if (confirmation == "y") {
                            driverList.get(raceStatSelector).racesCompleted++;
                        }*/

                        System.out.println();
                        System.out.println("Would you like to add another position? (Press 'y' or 'n') : ");
                        Scanner confirmationScanner = new Scanner(System.in);
                        String confirmation = confirmationScanner.nextLine();
                        if (confirmation == "y") {
                            continue;
                        } else {
                            break;
                        }

                    }
                    
                    System.out.println("*new race details added Successfully.");
                    break;

                case 7: 
                    //save file
                    try {
                        FileOutputStream f = new FileOutputStream("driverSave1.txt");
                        ObjectOutputStream o = new ObjectOutputStream(f);
                        
                        o.writeObject(driverList);
                        // Write objects to file
                        // (int i = 0; i < driverList.size(); i++) {
                            //o.writeObject(driverList.get(i));
                        //}
                        
                        o.close();
                        f.close();
            
                    } catch (FileNotFoundException e) {
                        System.out.println("File not found");
                    } catch (IOException e) {
                        System.out.println("Error initializing stream");
                    } 
                    System.out.println();
                    System.out.println("Data written to file driverSave1.txt successfully.");
                    break;

                case 8:
                    System.out.println("");
                    //exit handled in the if else code below
                    break;

                default:
                    System.out.println("Please choose a number from the menu options given.");
            }
            
            //exit program
            if (userChoice == 8) {
                System.out.println("Are you sure you want to Exit the program? All unsaved data will be lost!");
                    System.out.println("Press 'yes' for yes or 'no' for no");
                    Scanner exitScanner = new Scanner(System.in); //scanner for the user choice
                    String exitConfirmation = exitScanner.nextLine();

                    if (exitConfirmation.equals("yes")) {
                        flagVariable = false;
                        break;
                    } else if (exitConfirmation.equals("no")) {
                        continue;
                    } else {
                        System.out.println("Please choose between 'yes' or 'no'");
                        continue;
                    }
            }

        } while(flagVariable == true);

        System.out.println("-------------------------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("Thank you for using The Formulea 1 Championship Manager =)");

    }
    


}
