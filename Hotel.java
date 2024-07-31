
import java.util.ArrayList;

/**
 * The Hotel class represents a hotel with a name, a list of rooms, room price,
 * and reservations. It provides methods to manage rooms, change the hotel name,
 * set room prices, and handle reservations.
 * 
 * @version 1.0
 * @since 2024-07-31
 */
public class Hotel {

    private String name; // Hotel name
    private Room[] room; // List of rooms
    private float roomPrice; // Room price (same for all rooms)
    private int rooms; // Number of all rooms added
    private int floor; // Number of floors the hotel has
    private int removed; // Number of rooms removed
    private ArrayList<Reservation> reservation; // List of reservations the hotel has
    private float[] dayPriceMod; // Day price percentage

    /**
     * Constructs a new Hotel with the specified name.
     * Initializes the hotel with one room and default room price.
     * 
     * @param name the name of the hotel
     */
    public Hotel(String name) {
        int i;
        this.name = name;
        this.rooms = 1;
        this.floor = 1;
        this.removed = 0;
        this.roomPrice = 1299; // Defaults room price to 1299
        this.room = new Room[50];
        this.room[0] = new Room("101");
        reservation = new ArrayList<>();
        this.dayPriceMod = new float[31];
        for (i=0;i<31;i++)
            this.dayPriceMod[i] = 1;
    }

    /**
     * Changes the name of the hotel.
     * 
     * @param name the new name of the hotel
     */
    public void changeName(String name) {
        this.name = name;
    }

    /**
     * Sets the price of the rooms in the hotel.
     * 
     * @param roomPrice the new price of the rooms
     */
    public boolean setRoomPrice(float roomPrice) {
        if (roomPrice>=100)
        {
            this.roomPrice = roomPrice;
            return true;
        }
        return false; 
    }

    /**
     * Adds a new room to the hotel.
     * Prints a message if the maximum number of rooms is reached.
     * 
     * @param type the type of the room to be added
     * @return true if the room is successfully added, false otherwise
     */
    public boolean addRoom(int type) {

        if (type<1||type>3)
            return false; // return false if room type is invalid

        if (rooms - removed > 49) // Does not add room if rooms exceeds 50
            System.out.println("Maximum amount of rooms reached");
        else {
            this.rooms++; // Increments rooms if a room is added

            if (rooms % 10 == 1)
                this.floor++; // Increments to floor for every 10 rooms
            
            // Creates new room object and automates a unique room name for each room added
            switch (type) {
                case 1:
                    if (rooms % 10 != 0) {
                        this.room[rooms - 1 - removed] = new Room("" + floor + "0" + rooms % 10);
                        System.out.println("Room " + floor + "0" + rooms % 10 + " has been added");
                    } else {
                        this.room[rooms - 1 - removed] = new Room("" + floor + "10");
                        System.out.println("Room " + floor + "10 has been added");
                    }   break;
                case 2:
                    if (rooms % 10 != 0) {
                        this.room[rooms - 1 - removed] = new DeluxeRoom("" + floor + "0" + rooms % 10 + " - DELUXE");
                        System.out.println("Room " + floor + "0" + rooms % 10 + " - DELUXE has been added");
                    } else {
                        this.room[rooms - 1 - removed] = new DeluxeRoom("" + floor + "10" + " - DELUXE");
                        System.out.println("Room " + floor + "10 - DELUXE has been added");
                    }   break;
                case 3:
                    if (rooms % 10 != 0) {
                        this.room[rooms - 1 - removed] = new ExclusiveRoom("" + floor + "0" + rooms % 10 + " - EXCLUSIVE");
                        System.out.println("Room " + floor + "0" + rooms % 10 + " - EXCLUSIVE has been added");
                    } else {
                        this.room[rooms - 1 - removed] = new ExclusiveRoom("" + floor + "10" + " - EXCLUSIVE");
                        System.out.println("Room " + floor + "10 - EXCLUSIVE has been added");
                    }   break;
                default:
                    break;
            }
        }
        return true;
    }

    /**
     * Removes a room from the hotel if it has no reservations.
     * 
     * @param roomName the name of the room to be removed
     * @return true if the room is successfully removed, false otherwise
     */
    public boolean removeRoom(String roomName) {
        int i, index = -1, j = 0;

        for (i = 0; i < rooms - removed; i++) // Returns false if room has reservations otherwise, initializes i to index
            if (roomName.equals(room[i].getRoomName())) {
                if (!room[i].getRoomReservations().isEmpty()) {
                    System.out.println("Cannot be removed, room has reservations");
                    return false;
                }
                index = i;
            }
        // if index is not equals to -1, room will be removed
        if (index != -1) {
            Room[] room2 = new Room[50]; // Creates a new Room array 
            for (i = 0; i < rooms - 1 - removed; i++) { // Copies the Room array to the new Room array but skips the removed room
                if (i == index)
                    j++;
                room2[i] = room[j];
                j++;
            }
            this.room = room2;
            this.removed++;
            return true;
        } else { // index will remain -1 if room is not found and will return false
            System.out.println("Invalid input");
            return false;
        }
    }

    /**
     * Creates a new reservation in the hotel.
     * 
     * @param name the name of the guest
     */
    public void createReservation(String name) {
        reservation.add(new Reservation(name));
    }

    /**
     * Returns the name of the hotel.
     * 
     * @return the name of the hotel
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the number of rooms in the hotel.
     * 
     * @return the number of rooms in the hotel
     */
    public int getRooms() {
        return rooms - removed;
    }

    /**
     * Returns the price of the rooms in the hotel.
     * 
     * @return the price of the rooms in the hotel
     */
    public float getRoomPrice() {
        return roomPrice;
    }

    /**
     * Returns a list of all reservations in the hotel.
     * 
     * @return a list of all reservations in the hotel
     */
    public ArrayList<Reservation> getReservations() {
        return reservation;
    }

    /**
     * Returns an array of all rooms in the hotel.
     * 
     * @return an array of all rooms in the hotel
     */
    public Room[] getAllRooms() {
        return room;
    }

    /**
     * Returns an the day price modification.
     * 
     * @return a float of the day price percentage
     */
    public float[] getDayPriceModifications(){
        return dayPriceMod;
    }

    /**
     * Modifies a day price percentage.
     * 
     * @param index the day to be modified
     * @param percent the percentage of the day price
     * @return true if the room is successfully removed, false otherwise
     */
    public boolean modifyDayPrice(int index, int percent){
        if(percent<50||percent>150)
            return false;
        
        this.dayPriceMod[index] = (float)percent/100f;
        System.out.println("Date Price Modification Success!");
        return true;
    }

    /**
     * Displays the hotel name, total rooms and estimate earnings of the hotel.
     * 
     */
    public void viewHotel(){
        int d;
        float j=0;
        for(d=0;d<reservation.size();d++) // Sums up all the total earnings of each reservation in the hotel
            j += reservation.get(d).getTotalPrice();
        
        System.out.println("\nHotel Name: " + name); // Displays hotel name
        System.out.println("Total Rooms: " + rooms); // Displays the total rooms of the hotel
        System.out.printf("Estimate Earnings: %.2f",j); // Displays estimate earnings for the month
    }

    /**
     * Displays all the room names of the hotel.
     * 
     */
    public void displayAllRooms(){
    int f;
        System.out.println("Rooms:");
			for(f=0;f<rooms;f++) // Displays all rooms
					System.out.println("Room "+room[f].getRoomName());
    }

    /**
     * Displays all the reservations of the hotel and the guest name of each.
     * 
     */
    public void displayAllReservations(){
        int d;
        System.out.println("Reservations:");
			for(d=0;d<reservation.size();d++) // Display all reservations in the hotel and the guest name of each
					System.out.println(d+1+" - Room "+reservation.get(d).getRoomReserved()+" reservation "
					+ "by "+reservation.get(d).getGuestName());
    }
}
