

import java.util.ArrayList;

/**
 * The Room class represents a room with a name and a list of reservations.
 * It provides methods to reserve the room, check availability, and get room details.
 * 
 * @version 1.0
 * @since 2024-07-31
 */
public class Room {

    private String name; // Room name
    private ArrayList<Reservation> reservation; // List of reservations the room has

    /**
     * Constructs a new Room with the specified name.
     *
     * @param name the name of the room
     */
    public Room(String name) {
        reservation = new ArrayList<>();
        this.name = name;
    }

    /**
     * Returns the name of this room.
     *
     * @return the name of this room
     */
    public String getRoomName() {
        return name;
    }

    /**
     * Adds a reservation to this room.
     *
     * @param reservation the reservation to add
     */
    public void reserveRoom(Reservation reservation) {
        this.reservation.add(reservation);
    }

    /**
     * Returns a list of reservations for this room.
     *
     * @return a list of reservations for this room
     */
    public ArrayList<Reservation> getRoomReservations() {
        return reservation;
    }

    /**
     * Checks if the room is available for the specified check-in and check-out dates.
     * 
     * @param checkIn the check-in date
     * @param checkOut the check-out date
     * @return true if the room is available, false otherwise
     */
    public boolean isAvailable(Date checkIn, Date checkOut) {
        boolean valid = true;
        int index;
        for (index = 0; index < reservation.size(); index++) {
            if (checkIn.getDay() < reservation.get(index).getCheckOutDate().getDay()) {
                if (checkIn.getDay() >= reservation.get(index).getCheckInDate().getDay()) {
                    valid = false; // valid is initialized to false if check-in day coincides with an existing reservation
                }
            }

            if (checkOut.getDay() > reservation.get(index).getCheckInDate().getDay()) {
                if (checkOut.getDay() < reservation.get(index).getCheckOutDate().getDay()) {
                    valid = false; // valid is initialized to false if check-out day coincides with an existing reservation
                }
            }

            if (checkIn.getDay() == reservation.get(index).getCheckOutDate().getDay()) {
                if (checkIn.getHour() < reservation.get(index).getCheckOutDate().getHour()) {
                    valid = false; // valid is initialized to false if check-in hour is before reservation's check-out hour
                } else if (checkIn.getHour() == reservation.get(index).getCheckOutDate().getHour()) {
                    if (checkIn.getMinute() <= reservation.get(index).getCheckOutDate().getMinute()) {
                        valid = false; // valid is initialized to false if check-in date is the same as reservation's check-out date
                    } 
                }
            }

            if (checkOut.getDay() == reservation.get(index).getCheckInDate().getDay()) {
                if (checkOut.getHour() > reservation.get(index).getCheckInDate().getHour()) {
                    valid = false; // valid is initialized to false if check-out hour is after reservation's check-in hour
                } else if (checkOut.getHour() == reservation.get(index).getCheckInDate().getHour()) {
                    if (checkOut.getMinute() >= reservation.get(index).getCheckInDate().getMinute()) {
                        valid = false; // valid is initialized to false if check-out date is the same as reservation's check-in date
                    }
                }
            }
        }
        return valid;
    }
}
