package ArifZahirOOPCW;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.Serializable;

public class formulea1Driver extends driver implements Comparable<formulea1Driver> , Serializable {
    //initilizing variables
    private static final long serialVersionUID = 1L;
    public String firstName ,surname, location, team;
    public int age, points, racesParticipated, racesCompleted;
    
    //store all the past positions of drivers in an arraylist so that it can be updated once a driver completes a race
    ArrayList<Integer> positions = new ArrayList<Integer>();
    
    //contructor
    public formulea1Driver(String firstName, String surname, String location, String team, int age, int points, int racesParticipated, int racesCompleted) {
        //mapping the variables in the constructor to the object variables
        this.firstName = firstName;
        this.surname = surname;
        this.location = location;
        this.team = team;
        this.age = age;
        this.points = points;
        //may participate in a race but may not nessasarily complete it
        this.racesParticipated = racesParticipated;
        this.racesCompleted = racesCompleted;
        //add defualt attributes
    }

    //getters and setters
    public void setTeam(String newName, String newSurname, String Location, int Age){
        firstName = newName;
        surname = newSurname;
        location = Location;
        age = Age;
    }
    
    public String getName() {
        return surname;
    }

    public int getPoints()
    {
        return this.points;
    }

    //methods
    //https://www.geeksforgeeks.org/how-to-sort-an-arraylist-of-objects-by-property-in-java/
    @Override public int compareTo(formulea1Driver comparestu)
    {
        int compareage
            = ((formulea1Driver)comparestu).getPoints();
  
        //  For Ascending order
        return this.points - compareage;
  
        // For Descending order do like this
        // return compareage-this.studentage;
    }

    //HOW DOES THIS WORK OMG THIS DOPE AS h i mean- i will have to modify this to fit my critera and create a cool table and ofcourse do some more testing to ensure this override thing doesnt mess with anything else

    @Override public String toString()
    {
        return "[ Name = " + firstName + surname + ", age = "
            + age + ", Location = " + location + ", Team = " + team + ", Points = " + points + ", Races Participated = " + racesParticipated + ", Races Completed = " + racesCompleted + "]";
    }
    public void addPointsToDriver() {

        int driverPoints = 0;
        System.out.println("Enter the position the driver achieved: ");
        System.out.println();
        Scanner pointScanner = new Scanner(System.in);
        int pointInput = pointScanner.nextInt();

        switch (pointInput) {
            case 1:
                driverPoints += 25;
                break;
            case 2:
                driverPoints += 18;
                break;
            case 3:
                driverPoints += 15;
                break;
            case 4:
                driverPoints += 12;
                break;
            case 5:
                driverPoints += 10;
                break;
            case 6:
                driverPoints += 8;
                break;
            case 7:
                driverPoints += 6;
                break;
            case 8:
                driverPoints += 4;
                break;
            case 9:
                driverPoints += 2;
                break;
            case 10:
                driverPoints += 1;
                break;

            
        }

        points += driverPoints;

    }

    //public int showPositionStats() {
        //will look through arraylist and check instances of each position
        //find/loop that goes thru and adds 1 to a variable for each first positions it finds
            //repeats the process for second and third places

        //prints all the variables
    //}
    
    //public void showPoints() {
        //will calculate points based on the arraylist of position details
        //new array with points in order(can skip 0)
        //variables multipy by the 1 second and 3rd thingys and all added to a single new variable called points
        //boom print points
    //}

}