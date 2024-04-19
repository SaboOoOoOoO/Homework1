package homeworks.hw1.scooter;

import java.util.ArrayList;
import java.util.List;

public class RentalCompany {

    private int uid = 0;

    List<Scooter> scooters = new ArrayList<>();

    public List<Scooter> availableScooters() {
            List<Scooter> result = new ArrayList<>();
            for (Scooter scooter : scooters) {
                if (scooter.isAvailable()) {
                    result.add(scooter);
                }
            }
        return result;
    }

    public void addScooter(Scooter scooter) {
        scooter.setId(uid++);
        scooters.add(scooter);
    }

    public boolean removeScooter(int id) {
        boolean removed = false;
        for (Scooter scooter: scooters) {
            if (scooter.getId() == id) {
                scooters.remove(scooter);
                removed = true;
                break;
            }
        }
        return removed;
    }

    /**
     * Rents a scooter from the rental company.
     * @param id The ID of the scooter to be rented.
     */
    public void rentScooter(int id) {
        for (Scooter scooter : scooters) {
        if (scooter.getId() == id && scooter.isAvailable()) {
            scooter.setAvailable(false);
            System.out.println("Scooter with ID " + id + " has been rented.");
            return;
        }
    }
        System.out.println("Scooter with ID " + id + " is not available for rent.");

    }

    /**
     * Returns a rented scooter to the rental company.
     * @param id The ID of the scooter to be returned.
     * @param x The new X coordinate of the scooter's location.
     * @param y The new Y coordinate of the scooter's location.
     */
    public void returnScooter(int id, double x, double y) {
        for (Scooter scooter : scooters) {
            if (scooter.getId() == id) {
                scooter.setAvailable(true);
                scooter.setX(x);
                scooter.setY(y);
                System.out.println("Scooter with ID " + id + " has been returned.");
                return;
            }
        }
        System.out.println("Scooter with ID " + id + " is not found.");

    }

    /**
     * Displays information about all scooters in the rental company's fleet.
     */
    public void displayAllScooters() {
        System.out.println("List of all scooters:");
        for (Scooter scooter : scooters) {
            System.out.println(scooter);
        }

    }
}