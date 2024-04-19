package homeworks.hw1.scooter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScooterRentalTester {
    public static void main(String[] args) {
        // Create a rental company
        RentalCompany rentalCompany = new RentalCompany();

        // Add a scooter to the rental company's fleet
        Scooter scooter = new Scooter();
        scooter.setModel("Sparrow X10");
        scooter.setBatteryLevel(100);
        scooter.setAvailable(true);
        rentalCompany.addScooter(scooter);

        // Rent the scooter and go from home to the university
        int scooterId = scooter.getId(); // Get the ID of the rented scooter
        rentalCompany.rentScooter(scooterId); // Rent the scooter
        double universityX = 41.7121106; // University X coordinate
        double universityY = 44.7489232; // University Y coordinate
        double homeX = 41.721765; // X coordinate of my home
        double homeY = 44.805836; // Y coordinate of my home
        System.out.println("Scooter has been rented at location: " + homeX + ", " + homeY);
        System.out.println("Riding to the university...");
        System.out.println("Arrived at the university.");
        System.out.println("Scooter location: " + universityX + ", " + universityY);

        // Leave the scooter at the university
        rentalCompany.returnScooter(scooterId, universityX, universityY);

        // Schedule the task to rent the scooter again after 1 hour
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.schedule(() -> {

        // Rent the scooter again and go back home
        rentalCompany.rentScooter(scooterId); // Rent the scooter

        System.out.println("Scooter has been rented at location: " + scooter.getX() + ", " + scooter.getY());
        System.out.println("Riding back home...");
        System.out.println("Arrived back home.");
        System.out.println("Scooter location: " + homeX + ", " + homeY);
        // Leave the scooter near home
        rentalCompany.returnScooter(scooterId, homeX, homeY);
            scheduler.shutdown(); // Shutdown the scheduler after the task is completed
        }, 1, TimeUnit.HOURS); // Schedule the task to run after 1 hour

/* NOTE FOR PROFESSOR: I couldn't understand the task completely, so I wrote a code which runs the second part of renting automatically after one hour
* you can change the HOURS in line 47 into MINUTES to see that my code runs perfectly.*/

        // Shutdown the scheduler when the program exits
        Runtime.getRuntime().addShutdownHook(new Thread(scheduler::shutdown));
    }
}