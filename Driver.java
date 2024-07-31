
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The Driver class simulates the system that contains all the required objects and classes in order 
 * to create hotel, view hotel, manage hotel and manage bookings.
 * It calls the needed methods to set values, do actions and manipulate the variables in the system.
 * This class is where user input is needed in order to choose an action to be made or to set values.
 * 
 * @version 1.0
 * @since 2024-07-31
 */
public class Driver{
	
    /**
     * Main method of the whole system.
     * Contains code to execute or call other methods.
     * Initializes the needed objects, scanners, and other used variables.
     * 
     */
	public static void main(String[] args) {
		ArrayList<Hotel> hotel = new ArrayList<>(); // Initializes a Hotel ArrayList
		Scanner sc = new Scanner(System.in);  // Scanner used for integer input
		Scanner str = new Scanner(System.in); // Scanner used for string input
		Scanner fl = new Scanner(System.in); // Scanner used for float input
		int input, i, d, f, day, hour, min; // Integer variables used to contain user integer input
		String name;  // String used to contain user String input
		float j = 0; // String used to contain user float input
		boolean valid = true; // Used in checking conditions
		
		// Asks user to choose a feature, will continue to loop unless user selects Exit Program
		do {
			System.out.println("Select a feature");
			System.out.println("1 - Create Hotel");
			System.out.println("2 - View Hotel");
			System.out.println("3 - Manage Hotel");
			System.out.println("4 - Simulate Booking");
			System.out.println("0 - Exit Program");
			input = sc.nextInt();
			
			switch (input) // switch statement to redirect user 
			{
				case 1: 
					System.out.print("Set Hotel name: "); // Asks user for hotel name
					name = str.nextLine();
					i=0;
					if (!hotel.isEmpty())
						while (i<hotel.size()) // Checks if hotel name already exists
						{
							if (hotel.get(i).getName().equals(name)) // Loops until hotel name is unique
							{
								System.out.println("Hotel name already exists.");
								System.out.print("Set Hotel name: ");
								name = str.nextLine();
								i=-1;
							}
							i++;
						}
					hotel.add(new Hotel(name));
					
					do {
						System.out.print("Add room (Y/N)?: "); // Asks user if they want to add room
							if((name=str.nextLine()).equals("Y"))
							{
								do{
									System.out.println("Add what type of room?");
									System.out.println("1 - Standard");
									System.out.println("2 - Deluxe");
									System.out.println("3 - Executive");
									System.out.print("Type: ");
									d = sc.nextInt();
									
									if (d<1||d>3)
										System.out.println("Invalid Input\n");
									} while (d<1||d>3);

									hotel.get(hotel.size()-1).addRoom(d);
							}
								
							else if (!name.equals("N"))
								System.out.println("Invalid Input\n");
					}while(!name.equals("N")); // Will loop unless user inputs 'N'
					
					do {
						System.out.print("Set room price (Y/N)?: "); // Asks user if they want to set price
						if((name=str.nextLine()).equals("Y"))
						{
							do {
								System.out.print("Price: ");
								
								
							}while(!hotel.get(hotel.size()-1).setRoomPrice(j=fl.nextFloat()));
						}
						else if(!name.equals("N"))
							System.out.println("Invalid Input\\n");
					} while(!name.equals("N") && j<100); // Will loop unless user inputs 'N' and if a valid price is set
					System.out.print("\n");
					break;
				case 2: 
					System.out.println("Select a Hotel:"); // Asks user to select an existing hotel

					if (!hotel.isEmpty())
					{
						for (i=0;i<hotel.size();i++) // Displays all existing hotels
							System.out.println(i+1 + " - " + hotel.get(i).getName());
						
						do { // Loops if user inputs and invalid number
							if ((i=sc.nextInt())>hotel.size()||i<1)
								System.out.println("Invalid Input\n");
						}while(i>hotel.size()||i<1);
						
						i--;

						hotel.get(i).viewHotel();
						
						System.out.println("\n1 - View available and booked rooms for a certain date"); 
						System.out.println("2 - View room information"); 
						System.out.println("3 - View reservation information");
						// Asks user to choose an option and loops if user inputs an invalid number
						do {
							d = sc.nextInt();
							if (d<0||d>3)
								System.out.println("Invalid Input\n");
						}while(d<0||d>3);
						
						switch (d)
						{
							case 1: 
								Date inDate = new Date(); // inDate to contains user check-in date input
								Date outDate = new Date(); // outDate to contains user check-out date input
								System.out.println("Enter check-in date");
								do { // Asks for user to input dates, loops if dates are invalid
									System.out.print("Day: ");
									day = sc.nextInt();
									System.out.print("Hour: ");
									hour = sc.nextInt();
									System.out.print("Minute: ");
									min = sc.nextInt();
									
									valid = (inDate.setMinute(min) && inDate.setDay(day) && inDate.setHour(hour));
									
									if (!valid)
										System.out.println("Invalid Input\n");
								}while(!valid);
								
								System.out.println("Enter check-out date");
								do {
									System.out.print("Day: ");
									day = sc.nextInt();
									System.out.print("Hour: ");
									hour = sc.nextInt();
									System.out.print("Minute: ");
									min = sc.nextInt();
									
									valid = (outDate.setMinute(min) && outDate.setDay(day) && outDate.setHour(hour));
									if(outDate.getDay() <= inDate.getDay())
										valid = false;
									if (!valid)
										System.out.println("Invalid Input\n");
								}while(!valid);
								
								System.out.println("\nAvailability:");
								
								for(f=0;f<hotel.get(i).getRooms();f++) // Displays all rooms and also displays if they are available or booked on the given dates
								{
									System.out.print("Room "+hotel.get(i).getAllRooms()[f].getRoomName());
									if (hotel.get(i).getAllRooms()[f].isAvailable(inDate,outDate))
										System.out.println(" - Available");
									else
										System.out.println(" - Booked");
								}
								System.out.print("\n");
								break;
							case 2:
								
								hotel.get(i).displayAllRooms(); // Displays all rooms
									
								do { // Loops if selected room does not exist
									d=-1;
									System.out.print("Select a room: "); // Asks user to select a room
									name = str.nextLine();
									for(f=0;f<hotel.get(i).getRooms();f++)
										if(name.equals(hotel.get(i).getAllRooms()[f].getRoomName()))
											d = f;
									if (d==-1)
										System.out.println("Invalid input\n");
								}while(d==-1);
								// Displays room information, room price, and availability across the month
								System.out.println("\nRoom name: "+name);
								if (hotel.get(i).getAllRooms()[d] instanceof DeluxeRoom)
									System.out.printf("Price per night: %.2f\n",hotel.get(i).getRoomPrice()* 1.2F);
								else if (hotel.get(i).getAllRooms()[d] instanceof ExclusiveRoom)
									System.out.printf("Price per night: %.2f\n",hotel.get(i).getRoomPrice()* 1.35F);
								else 
									System.out.println("Price per night: "+hotel.get(i).getRoomPrice());
								System.out.println("Booking status:");
								if (hotel.get(i).getAllRooms()[d].getRoomReservations().isEmpty())
									System.out.println("Available across the month\n"); // Display if room has no reservations
								else
								{
									for(f=0;f<hotel.get(i).getAllRooms()[d].getRoomReservations().size();f++) // Display if room has reservations
										hotel.get(i).getAllRooms()[d].getRoomReservations().get(f).dispDate(); // Displays room reservation dates
								}
								System.out.print("\n");
								break;
							case 3:
								if (hotel.get(i).getReservations().isEmpty())
									System.out.println("There are no reservations at the moment\n"); // Display if there are no reservations in the hotel
								else
								{
									hotel.get(i).displayAllReservations(); // Display all reservations in the hotel and the guest name of each
										
									do { 
										System.out.print("Select a reservation: "); // Asks user to select a reservation
										d = sc.nextInt();
									}while(d<1||d>hotel.get(i).getReservations().size());
									d--;
									// Displays reservation information, reservation date, and price breakdown per night of the reservation 
									System.out.println("\nGuest Name: "+hotel.get(i).getReservations().get(d).getGuestName());
									System.out.println("Room Name: "+hotel.get(i).getReservations().get(d).getRoomReserved());
									System.out.print("Room ");
									hotel.get(i).getReservations().get(d).dispDate();
									hotel.get(i).getReservations().get(d).dispBreakdown(hotel.get(i));	
								}
								break;
						} 
						
						
					}
					else
						System.out.println("No Hotels in the system at the moment\n"); // Display if there are no hotels in the system
					break;
				case 3:
					System.out.println("Select a Hotel:"); // Asks user to select a hotel
					
					if (!hotel.isEmpty()) // if there are hotels in the system
					{
						// Displays all hotels
						for (i=0;i<hotel.size();i++)
							System.out.println(i+1 + " - " + hotel.get(i).getName());
						// User selects a hotel, loops if user input is invalid
						do {
							if ((i=sc.nextInt())>hotel.size()||i<1)
								System.out.println("Invalid Input\n");
						}while(i>hotel.size()||i<1);
						i--;
						
						System.out.println("1 - Change Name of Hotel");
						System.out.println("2 - Add Room");
						System.out.println("3 - Remove Room");
						System.out.println("4 - Update Room Pricing");
						System.out.println("5 - Remove Reservation");
						System.out.println("6 - Remove Hotel");
						System.out.println("7 - Date Price Modifier");
						// Asks user to choose an option, loops if user input is invalid
						do{
							d = sc.nextInt();
							if(d<1||d>7)
								System.out.println("Invalid Input\n");
						}while(d<1||d>7);
						
							switch (d)
							{
								case 1: 
									name = str.nextLine(); // Asks user for a new hotel name
									d=0;
									if (!hotel.isEmpty())
										while (d<hotel.size()) // Checks if hotel name is unique
										{
											if (hotel.get(d).getName().equals(name))
											{
												System.out.println("Hotel name already exists.");
												name = str.nextLine();
												d=-1;
											}
											d++;
										}
									hotel.get(i).changeName(name); // Changes hotel name
									break;
								case 2:

									do{
										System.out.println("Add what type of room?");
										System.out.println("1 - Standard");
										System.out.println("2 - Deluxe");
										System.out.println("3 - Executive");
										System.out.print("Type: ");
										d = sc.nextInt();
										
										if (d<1||d>3)
											System.out.println("Invalid Input\n");
										} while (d<1||d>3);

									hotel.get(i).addRoom(d); // Adds a room to the hotel
									do {
										System.out.print("Add more rooms (Y/N)?: "); // Asks user if they want to add more rooms
											if((name=str.nextLine()).equals("Y")) // Loops until user refuses to add room or user input is invalid
											{
												do{
													System.out.println("Add what type of room?");
													System.out.println("1 - Standard");
													System.out.println("2 - Deluxe");
													System.out.println("3 - Executive");
													System.out.print("Type: ");
													d = sc.nextInt();
													
													if (d<1||d>3)
														System.out.println("Invalid Input\n");
													} while (d<1||d>3);
													
												hotel.get(i).addRoom(d); // Adds a room to the hotel
											}
											else if (!name.equals("N"))
												System.out.println("Invalid Input\n"); 
									}while(!name.equals("N"));
									System.out.print("\n");
									break;
								case 3:
								
									hotel.get(i).displayAllRooms(); // Displays all rooms

									do { // Loops until a room is successfully removed
										System.out.print("Select a Room to be removed: "); // Asks user to select a room to be removed
										name = str.nextLine();
										valid = hotel.get(i).removeRoom(name); // valid is true if hotel is removed successfully otherwise, valid is false
										if(valid)
											System.out.println("Room "+ name + " sucessfully removed!\n");
										else
											System.out.println("Remove room unsuccessful\n");
									}while(!valid);
									break;
								case 4:
									if (hotel.get(i).getReservations().isEmpty()) // Room pricing can only be updated if there are no reservations in the hotel
									{
										do { // Loops until new price set is valid (must be price >= 100)
												System.out.print("Price: ");
												j=fl.nextFloat();
												hotel.get(i).setRoomPrice(j);
											if(j<100.0)
												System.out.println("Insufficient Price\n");
										} while(!hotel.get(i).setRoomPrice(j));
									}
									else
										System.out.println("Cannot change while there are reservations\n"); // Displays if there are reservations in the hotel
									break;
								case 5:
									if (hotel.get(i).getReservations().isEmpty()) // Displays if there are no reservations in the hotel
										System.out.println("There are no reservations at the moment\n");
									else
									{
										System.out.println("\nReservations:"); // Displays all reservations 
										for(d=0;d<hotel.get(i).getReservations().size();d++)
											System.out.println(d+1+" - Room "+hotel.get(i).getReservations().get(d).getRoomReserved()+" reservation "
													+ "by "+hotel.get(i).getReservations().get(d).getGuestName());
										d = hotel.get(i).getReservations().size();
										do { // Asks user to select a reservation to remove, loops if user input is invalid
											System.out.print("Select a reservation to remove: ");
											f = sc.nextInt();
											if (f<1||f>d)
												System.out.println("Invalid input\n");
										}while(f<1||f>d);
										f--;
										name = hotel.get(i).getReservations().get(f).getGuestName();
										hotel.get(i).getReservations().remove(f);
										// Removes reservation from hotel and room
										for (d=0;d<hotel.get(i).getRooms();d++)
											for(f=0;f<hotel.get(i).getAllRooms()[d].getRoomReservations().size();f++)
												if (name.equals(hotel.get(i).getAllRooms()[d].getRoomReservations().get(f).getGuestName()))
												{
													System.out.println("Room "+hotel.get(i).getAllRooms()[d].getRoomReservations().get(f).getRoomReserved()+" reservation by "
															+ hotel.get(i).getAllRooms()[d].getRoomReservations().get(f).getGuestName()+" succesfully removed\n");
													hotel.get(i).getAllRooms()[d].getRoomReservations().remove(f);
												}
									
									}
									break;
								case 6: 
									if (!hotel.get(i).getReservations().isEmpty())
									{
										System.out.println("There are currently reservations in this Hotel"); // informs user that there are still reservations 
	
										do {
											System.out.print("Remove anyway? (Y/N): "); // Asks user if they want to remove hotel anyway
												if((name=str.nextLine()).equals("Y"))
												{
													System.out.println("Hotel "+hotel.get(i).getName()+" successfully removed\n");
													hotel.remove(i); // Removes a hotel in the system
												}
												else if (!name.equals("N"))
													System.out.println("Invalid Input\n");
										}while(!name.equals("N")&&!name.equals("Y")); // Will loop unless user inputs 'N' or 'Y'

									}
									else
									{
										System.out.println("Hotel "+hotel.get(i).getName()+" successfully removed\n");
										hotel.remove(i); // Removes a hotel in the system
									}
								
									break;
								case 7:
								
									do{
										System.out.print("Select a date to modify its pricing: ");
										d = sc.nextInt();
							
										if(d<1||d>30)
											System.out.println("Invalid\n");
										}while(d<1||d>30);
									d--;
									do{
										System.out.print("Percentage(50%-150%): ");
										f = sc.nextInt();
								
										if(hotel.get(i).modifyDayPrice(d,f))
											System.out.println("Invalid\n");
										}while(f<50||f>150);
									
									break;
							}
					}
					else 
						System.out.println("No Hotels in the system at the moment\n"); // Displays if no hotels in the system
					break;
				case 4:
					System.out.println("Select a Hotel:"); // Asks user to select a hotel
					
					if (!hotel.isEmpty())
					{
						
						for (i=0;i<hotel.size();i++) // Displays all hotels
							System.out.println(i+1 + " - " + hotel.get(i).getName());
						
						do { // Loops if user input is invalid
							if ((i=sc.nextInt())>hotel.size()||i<1)
								System.out.println("Invalid Input\n");
						}while(i>hotel.size()||i<1);
						i--;
						System.out.println("Creating Reservation...");
						System.out.print("Guest Name: "); // Asks user for guest name
	
						name = str.nextLine();
						hotel.get(i).createReservation(name); // Creates a reservation with the guest name
						d = hotel.get(i).getReservations().size() - 1;
						// User inputs check-in and check-out dates, loops if user input is invalid
						do {
							System.out.println("Check-in Date");
							System.out.print("Day: ");
							day = sc.nextInt();
							System.out.print("Hour: ");
							hour = sc.nextInt();
							System.out.print("Minute: ");
							min = sc.nextInt();
						}while(!hotel.get(i).getReservations().get(d).setCheckIn(day, hour, min)); // sets the check-in date for the reservation
						
						do {
							System.out.println("Check-out Date");
							System.out.print("Day: ");
							day = sc.nextInt();
							System.out.print("Hour: ");
							hour = sc.nextInt();
							System.out.print("Minute: ");
							min = sc.nextInt();
						}while(!hotel.get(i).getReservations().get(d).setCheckOut(day, hour, min)); // sets the check-out date for the reservation
						
						System.out.println("\nRooms:"); 
						for(d=0;d<hotel.get(i).getRooms();d++) // Displays all rooms
							System.out.println(d+1 + " - Room " + hotel.get(i).getAllRooms()[d].getRoomName());
						
						do { // Loops if room chosen coincide with a reservation				
							do { // Loops if room selection by user is invalid
								System.out.print("Select a Room: "); // Asks user to select a room for the reservation
								d = sc.nextInt();
								if (d<1||d>hotel.get(i).getRooms()) 
									System.out.println("Invalid Input\n");
							}while(d<1||d>hotel.get(i).getRooms());
							
							valid = true; // valid is always set to true for looping purposes
							if (!hotel.get(i).getAllRooms()[d-1].getRoomReservations().isEmpty()) // Checks if there are reservations in this room
							{
								// valid will be false if the given dates were not available for this room, otherwise, valid will be true
								valid = hotel.get(i).getAllRooms()[d-1].isAvailable(hotel.get(i).getReservations().get(hotel.get(i).getReservations().size() - 1).getCheckInDate(),
										hotel.get(i).getReservations().get(hotel.get(i).getReservations().size() - 1).getCheckOutDate());
								if (valid) // Sets reservation if the given dates are available for this room
								{
									hotel.get(i).getReservations().get(hotel.get(i).getReservations().size() - 1).setRoomReserved(hotel.get(i).getAllRooms()[d-1]);
									do{
										System.out.print("Do you have a Discount Code (Y/N): ");
										name = str.nextLine();
								
										if(!name.equals("Y")&&!name.equals("N"))
											System.out.println("Invalid\n");
								
									}while(!name.equals("Y")&&!name.equals("N"));

									if(name.equals("Y"))
									{
										do{
											System.out.print("Enter Discount Code: "); 
											name = str.nextLine();
											valid = hotel.get(i).getReservations().get(hotel.get(i).getReservations().size() - 1).setDiscount(name);
											if(valid)
												System.out.println("Invalid\n");
										}while(!valid);
									}
								
									hotel.get(i).getReservations().get(hotel.get(i).getReservations().size() - 1).setTotalPrice(hotel.get(i));
									hotel.get(i).getAllRooms()[d-1].reserveRoom(hotel.get(i).getReservations().get(hotel.get(i).getReservations().size() - 1));
								}
							}
							else // Sets reservation if there are no reservations in the room
							{
								hotel.get(i).getReservations().get(hotel.get(i).getReservations().size() - 1).setRoomReserved(hotel.get(i).getAllRooms()[d-1]);

								do{
									System.out.print("Do you have a Discount Code (Y/N): ");
									name = str.nextLine();
							
									if(!name.equals("Y")&&!name.equals("N"))
										System.out.println("Invalid\n");
							
								}while(!name.equals("Y")&&!name.equals("N"));

								if(name.equals("Y"))
								{
									do{
										System.out.print("Enter Discount Code: "); 
										name = str.nextLine();
										valid = hotel.get(i).getReservations().get(hotel.get(i).getReservations().size() - 1).setDiscount(name);
										if(valid)
											System.out.println("Invalid\n");
									}while(!valid);
								}
								
								hotel.get(i).getReservations().get(hotel.get(i).getReservations().size() - 1).setTotalPrice(hotel.get(i));
								hotel.get(i).getAllRooms()[d-1].reserveRoom(hotel.get(i).getReservations().get(hotel.get(i).getReservations().size() - 1));
							}
							
							if(!valid)
								System.out.println("Dates already reserved, please try another room"); // Displays if given dates coincide with the room's prior reservations
						}while(!valid);
						System.out.println("Booking Successful!"); // Displays if given dates are available for this room
						
						System.out.print("\n");
						
						
					}
					else 
						System.out.println("No Hotels in the system at the moment\n"); // Displays if there are no hotels in the system
					break;
				case 0: System.out.println("Program Terminated...."); break; // Program will terminate if user selects 0
				default: System.out.println("Invalid Input\n"); break; // Displays invalid input and loops
					
			}
		}while(input != 0);
		sc.close(); // Closes sc scanner
		str.close(); // Closes str scanner
		fl.close(); // Closes fl scanner
	}
}
