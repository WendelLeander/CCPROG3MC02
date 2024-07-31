

/**
 * The Reservation class represents a reservation made by a guest.
 * It includes details such as the guest's name, the room reserved,
 * check-in and check-out dates, the total price, and the number of nights.
 * The class provides methods to set and get these properties, as well as 
 * to display the reservation details and a price breakdown.
 * 
 * @version 1.0
 * @since 2024-07-31
 */
public class Reservation {

    private String guestName; // Guest name
    private String roomReserved; // Stores the reserved room's name
    private Date checkInDate; // Date of check-in
    private Date checkOutDate; // Date of check-out
    private float totalPrice; // Total price of reservation
    private int night; // Number of nights of the reservation
    private float discount; // base percentage of the price of the reservation

    /**
     * Constructs a new Reservation with the specified guest name.
     *
     * @param guestName the name of the guest
     */
    public Reservation(String guestName) {
        this.guestName = guestName;
        this.checkInDate = new Date();
        this.checkOutDate = new Date();
        this.discount = 1;
    }

    /**
     * Sets the check-in date and time.
     * 
     * @param day the day of check-in
     * @param hour the hour of check-in
     * @param minute the minute of check-in
     * @return true if the check-in date and time are valid and set, false otherwise
     */
    public boolean setCheckIn(int day, int hour, int minute) {
        boolean valid = true;
        if (!checkInDate.setDay(day)) // Checks day validity
            valid = false;
        if (!checkInDate.setHour(hour)) // Checks hour validity
            valid = false;
        if (!checkInDate.setMinute(minute)) // Checks minute validity
            valid = false;

        if(checkInDate.getDay() == 31) // Check-in day cannot be on day 31
            valid = false;

        if(!valid)
            System.out.println("Invalid Input\n"); // Displays input invalidity
        return valid;
    }

    /**
     * Sets the check-out date and time.
     * 
     * @param day the day of check-out
     * @param hour the hour of check-out
     * @param minute the minute of check-out
     * @return true if the check-out date and time are valid and set, false otherwise
     */
    public boolean setCheckOut(int day, int hour, int minute) {
        boolean valid = true;
        if (!checkOutDate.setDay(day)) // Checks day validity
            valid = false;
        if (!checkOutDate.setHour(hour)) // Checks hour validity
            valid = false;
        if (!checkOutDate.setMinute(minute)) // Checks minute validity
            valid = false;

        if(checkOutDate.getDay() == 1) // Check-out day cannot be on day 1
            valid = false;
        if(checkOutDate.getDay() <= checkInDate.getDay())
            valid = false;
        if (valid)
            this.night = checkOutDate.getDay() - checkInDate.getDay();
        else
            System.out.println("Invalid Input\n"); // Displays input invalidity
        return valid;
    }

    /**
     * Sets the room reserved for this reservation.
     * 
     * @param room the room to reserve
     */
    public void setRoomReserved(Room room) {
        this.roomReserved = room.getRoomName();
    }

    /**
     * Sets the total price for this reservation.
     * 
     * @param hotel the hotel to get the room price from
     */
    public void setTotalPrice(Hotel hotel) {
        int i,d=-1;
        float price=0;
        for(i=0;i<hotel.getRooms();i++)
        {
            if(roomReserved.equals(hotel.getAllRooms()[i].getRoomName()))
                d=i;    
        }

        for(i=checkOutDate.getDay()-night-1;i<checkOutDate.getDay()-1;i++)
            price += hotel.getDayPriceModifications()[i] * hotel.getRoomPrice();
        // Calculates the total price of the reservation 
        if (hotel.getAllRooms()[d] instanceof DeluxeRoom) // Modifies total price if room is an instance of a deluxe room
            this.totalPrice = price * 1.2F * discount;
        else if (hotel.getAllRooms()[d] instanceof ExclusiveRoom) // Modifies total price if room is an instance of a exclusive room
            this.totalPrice = price * 1.35F * discount;
        else
            this.totalPrice = price * discount;
    }

    /**
     * Returns the name of the guest.
     * 
     * @return the name of the guest
     */
    public String getGuestName() {
        return guestName;
    }

    /**
     * Returns the total price of this reservation.
     * 
     * @return the total price of this reservation
     */
    public float getTotalPrice() {
        return totalPrice;
    }

    /**
     * Returns the check-in date of this reservation.
     * 
     * @return the check-in date of this reservation
     */
    public Date getCheckInDate() {
        return checkInDate;
    }

    /**
     * Returns the check-out date of this reservation.
     * 
     * @return the check-out date of this reservation
     */
    public Date getCheckOutDate() {
        return checkOutDate;
    }

    /**
     * Returns the name of the room reserved for this reservation.
     * 
     * @return the name of the room reserved
     */
    public String getRoomReserved() {
        return roomReserved;
    }

    /**
     * Displays the check-in and check-out dates and times in a readable format.
     */
    public void dispDate() {
        int inHour, outHour;
        
        // Formats hour into 12-hour clock format
        if(checkInDate.getHour() > 12)
            inHour = checkInDate.getHour() - 12;
        else if (checkInDate.getHour() == 0)
            inHour = 12;
        else
            inHour = checkInDate.getHour();

        if(checkOutDate.getHour() > 12)
            outHour = checkOutDate.getHour() - 12;
        else if (checkOutDate.getHour() == 0)
            outHour = 12;
        else
            outHour = checkOutDate.getHour();
        // Displays check-in and check-out date in a readable format
        System.out.print("Booked on Day " + checkInDate.getDay() + ", " + inHour + ":"); 
        System.out.printf("%02d ", checkInDate.getMinute()); // Displays minute into 2 digits
        if(checkInDate.getHour() > 12)
            System.out.print("PM"); // Displays PM if hour is greater than 12 otherwise, displays AM
        else
            System.out.print("AM"); 
        System.out.print(" to Day " + checkOutDate.getDay() + ", " + outHour + ":");
        System.out.printf("%02d ", checkOutDate.getMinute());
        if(checkOutDate.getHour() > 12)
            System.out.println("PM"); // Displays PM if hour is greater than 12 otherwise, displays AM
        else
            System.out.println("AM"); 
    }

    /**
     * Displays a breakdown of the price per night for this reservation.
     * 
     * @param hotel the hotel to get the room price from
     */
    public void dispBreakdown(Hotel hotel) {
        int index,i,d=-1;
        index = checkInDate.getDay() - 2;
        // Lists the number of nights and cost per night and displays the total price of the reservation

        for(i=0;i<hotel.getRooms();i++)
        {
            if(roomReserved.equals(hotel.getAllRooms()[i].getRoomName()))
                d=i;
                
        }
        // Displays breakdown of the price of the reservation based on nights, type of room, and discounts
        System.out.println("\n        PRICE PER NIGHT BREAKDOWN");

        if (night!=checkOutDate.getDay()-checkInDate.getDay())
        {
            if (hotel.getAllRooms()[d] instanceof DeluxeRoom)
            {
                for(i = 1; i <= night+1; i++) {
                    if(i==1)
                    {
                        System.out.printf("Night#%2d", i);
                        System.out.printf("            FREE\n");
                    }
                    else
                    {
                    System.out.printf("Night#%2d", i);
                    System.out.printf("            %.2f\n", hotel.getRoomPrice()*1.2*hotel.getDayPriceModifications()[index+i]);
                    }
                }

            }
            else if (hotel.getAllRooms()[d] instanceof ExclusiveRoom)
            {
                for(i = 1; i <= night+1; i++) {
                    if(i==1)
                    {
                        System.out.printf("Night#%2d", i);
                        System.out.printf("            FREE\n");
                    }
                    else
                    {
                    System.out.printf("Night#%2d", i);
                    System.out.printf("            %.2f\n", hotel.getRoomPrice()*1.35*hotel.getDayPriceModifications()[index+i]);
                    }
                }

            }
            else
            {
                for(i = 1; i <= night+1; i++) {
                    if(i==1)
                    {
                        System.out.printf("Night#%2d", i);
                        System.out.printf("            FREE\n");
                    }
                    else
                    {
                    System.out.printf("Night#%2d", i);
                    System.out.printf("            %.2f\n", hotel.getRoomPrice()*hotel.getDayPriceModifications()[index+i]);
                    }
                }
            }
        }
        else
        {
            if (hotel.getAllRooms()[d] instanceof DeluxeRoom)
            {
                for(i = 1; i <= night; i++) {
                    System.out.printf("Night#%2d", i);
                    System.out.printf("            %.2f\n", hotel.getRoomPrice()*1.2*hotel.getDayPriceModifications()[index+i]);
                }

            }
            else if (hotel.getAllRooms()[d] instanceof ExclusiveRoom)
            {
                for(i = 1; i <= night; i++) {
                    System.out.printf("Night#%2d", i);
                    System.out.printf("            %.2f\n", hotel.getRoomPrice()*1.35*hotel.getDayPriceModifications()[index+i]);
                }

            }
            else
            {
                for(i = 1; i <= night; i++) {
                    System.out.printf("Night#%2d", i);
                    System.out.printf("            %.2f\n", hotel.getRoomPrice()*hotel.getDayPriceModifications()[index+i]);
                }
            }
        }
        if(discount<1)
            System.out.printf("Discount           -%.2f\n",totalPrice/discount*(1-discount));

        System.out.println("_________________________________________");
        System.out.printf("Total:              %.2f\n\n", totalPrice);
    }

    /**
     * Sets the discount for this reservation.
     * 
     * @param input the discount code used by the guest
     * @return true if the disscount code is set, false otherwise
     */
    public boolean setDiscount(String input){
            // Returns false if input string is not a valid discount code
            if(!input.equals("I_WORK_HERE")&&!input.equals("STAY4_GET1")&&!input.equals("PAYDAY"))
                return false;
            else
            {
                if (input.equals("I_WORK_HERE"))
                {
                    this.discount -= 0.1;
                    System.out.println("Discount code successfully applied");
                }
                else if(input.equals("STAY4_GET1"))
                {
                    if (night>=4)
                    {
                        night--;
                        System.out.println("Discount code successfully applied");
                    }
                    else
                    {
                        System.out.println("Discount code does not meet certain conditions");
                        return false; // Returns false if discount code does not meet the required conditions for the discout code
                    }
                        
                }
                else if(input.equals("PAYDAY"))
                {
                    if((checkInDate.getDay()<=15&&checkOutDate.getDay()>15)||(checkInDate.getDay()<=30&&checkOutDate.getDay()>31))
                        this.discount -= 0.07;
                    else
                    {
                        System.out.println("Discount code does not meet certain conditions");
                        return false; // Returns false if discount code does not meet the required conditions for the discout code
                    }
                }
            }
            return true; // Returns true if input string is a valid discount code
    }

    /**
     * Returns the number nights of this reservation.
     * 
     * @return the nights of this reservation.
     */
    public int getNights(){
        return night;
    }

    /**
     * Returns the discount in float for this reservation.
     * 
     * @return the discount of this reservation.
     */
    public float getDiscount(){
        return discount;
    }
}
