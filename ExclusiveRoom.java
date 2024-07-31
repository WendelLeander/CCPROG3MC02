/**
 * The ExclusiveRoom class extends the Room class which represents a room with a name and a list of reservations. 
 * This Class serves as an Exclusive type of room which increases the base price of the hotel
 * It inherits methods to reserve the room, check availability, and get room details.
 * 
 * @version 1.0
 * @since 2024-07-31
 */
public class ExclusiveRoom extends Room{

    /**
     * Constructs a new Exclusive Room with the specified name.
     *
     * @param name the name of the room
     */
    public ExclusiveRoom(String name){
        super(name);
    }
}
