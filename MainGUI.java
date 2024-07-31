
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * The MainGUI class extends JFrame to display a user interface for the Hotel Reservation System. 
 * It creates an application type for the user to easily input variables through buttons, textboxes, etc.
 * It calls the needed methods to show values, do actions and manipulate the variables in the system.
 * 
 * @version 1.0
 * @since 2024-07-31
 */
public class MainGUI extends JFrame{
    // All important variables of the GUI class to show the different panels and interfaces
    private ArrayList<Hotel> hotel;
    private CustomPanel MenuPanel;
    private CustomPanel CreateHotel;
    private CustomPanel AddRoomPanel;
    private CustomPanel SelectRoomType;
    private CustomPanel SetPricePanel;
    private CustomPanel ViewHotelPanel;
    private CustomPanel HotelInfoPanel;
    private CustomPanel ViewRoomPanel;
    private CustomPanel RoomInfoPanel;
    private CustomPanel BookingInfoPanel;
    private CustomPanel BookingPanel;
    private CustomPanel BookRoomPanel;
    private CustomPanel MoreBookingInfo;
    private CustomPanel DatesPanel;
    private CustomPanel NamePanel;
    private CustomPanel DiscountPanel;
    private CustomPanel CheckDatePanel;
    private CustomPanel AvailabilityPanel;
    private CustomPanel ModifyHotelPanel;
    private CustomPanel ManageHotelPanel;
    private CustomPanel ChangeNamePanel;
    private CustomPanel AddRoomAgain;
    private CustomPanel AddMoreRoom;
    private CustomPanel RemoveRoomPanel;
    private CustomPanel UpdatePricePanel;
    private CustomPanel RemoveBooking;
    private CustomPanel RemoveHotelPanel;
    private CustomPanel SelectDayPanel;
    private CustomPanel ModifyDayPanel;
    private JPanel MainPanel;
    private CardLayout Layout;
    private int hotelIndex;
    private int roomIndex;
    private int reserveIndex;
    private int dayIndex;
    private JComboBox<String> hotelSelection;
    private JComboBox<String> hotelSelection2;
    private JComboBox<String> hotelSelection3;
    private JComboBox<String> roomSelection;
    private JComboBox<String> roomSelection2;
    private JComboBox<String> roomSelection3;
    private JComboBox<String> bookingSelection;
    private JComboBox<String> bookingSelection2;
    private Date CheckIn;
    private Date CheckOut;
    private Date CheckIn2;
    private Date CheckOut2;
    private BufferedImage backgroundImage;

    /**
     * Constructs a GUI with the final name of "Hotel Reservation System".
     *
     */
    public MainGUI() {
        super("Hotel Reservation System"); // Frame name
        setLayout(new BorderLayout());
        
        Layout = new CardLayout(); // Layout to show different panels of the frame
        MainPanel = new JPanel(Layout); // Layout panel
        this.hotel = new ArrayList<>(); // Model class used in the system

        // All void methods to set the panels and action listeners
        MainMenu(); // Sets up the Main menu interface and panel
        CreateHotel(); // Sets up the create hotel interface and panel
        AddRoom(); // Sets up the add room interface and panel
        RoomType(); // Sets up the set room type interface and panel
        SetPrice(); // Sets up the set price interface and panel
        ViewHotel(); // Sets up the view hotel info interface and panel
        ViewRoom(); // Sets up the view room info interface and panel
        BookHotel(); // Sets up the simulate booking interface and panel
        BookRoom(); // Sets up the room booking interface and panel
        InputDates(); // Sets up date booking interface and panel
        GuestName(); // Sets up the guest name input interface and panel
        SetDiscount(); // Sets up the discount code input interface and panel
        CheckAvailable(); // Sets up the check if dates are available interface and panel
        BookingInfo(); // Sets up the booking info interface and panel
        ModifyHotel(); // Sets up the hotel selection for managing interface and panel
        ManageHotel(); // Sets up the manage hotel options interface and panel
        ChangeName(); // Sets up the change hotel name interface and panel
        SelectRoomAgain(); // Sets up the select room type interface and panel
        AddMore(); // Sets up the add more room interface and panel
        RemoveRoom(); // Sets up the remove room interface and panel
        UpdatePricing(); // Sets up the room price update interface and panel
        RemoveReservation(); // Sets up the remove reservation interface and panel
        RemoveHotel(); // Sets up the add remove hotel interface and panel
        SelectDay(); // Sets up the day selection for price modification interface and panel
        ModifyDay(); // Sets up the day price modification interface and panel

        // Panels added to the main panel to be used for showing different panels depending on user selection
        MainPanel.add(MenuPanel, "MenuPanel");
        MainPanel.add(CreateHotel, "CreateHotel");
        MainPanel.add(AddRoomPanel, "AddRoomPanel");
        MainPanel.add(SelectRoomType, "SelectRoomType");
        MainPanel.add(SetPricePanel, "SetPricePanel");
        MainPanel.add(ViewHotelPanel, "ViewHotelPanel");
        MainPanel.add(HotelInfoPanel, "HotelInfoPanel");
        MainPanel.add(ViewRoomPanel, "ViewRoomPanel");
        MainPanel.add(BookingPanel, "BookingPanel");
        MainPanel.add(BookRoomPanel, "BookRoomPanel");
        MainPanel.add(DatesPanel, "DatesPanel");
        MainPanel.add(NamePanel, "NamePanel");
        MainPanel.add(DiscountPanel, "DiscountPanel");
        MainPanel.add(CheckDatePanel, "CheckDatePanel");
        MainPanel.add(AvailabilityPanel, "AvailabilityPanel");
        MainPanel.add(RoomInfoPanel, "RoomInfoPanel");
        MainPanel.add(BookingInfoPanel, "BookingInfoPanel");
        MainPanel.add(MoreBookingInfo, "MoreBookingInfo");
        MainPanel.add(ModifyHotelPanel, "ModifyHotelPanel");
        MainPanel.add(ManageHotelPanel, "ManageHotelPanel");
        MainPanel.add(ChangeNamePanel, "ChangeNamePanel");
        MainPanel.add(AddRoomAgain, "AddRoomAgain");
        MainPanel.add(AddMoreRoom, "AddMoreRoom");
        MainPanel.add(RemoveRoomPanel, "RemoveRoomPanel");
        MainPanel.add(UpdatePricePanel, "UpdatePricePanel");
        MainPanel.add(RemoveBooking, "RemoveBooking");
        MainPanel.add(RemoveHotelPanel, "RemoveHotelPanel");
        MainPanel.add(SelectDayPanel, "SelectDayPanel");
        MainPanel.add(ModifyDayPanel, "ModifyDayPanel");
        Layout.show(MainPanel, "MenuPanel");
        this.add(MainPanel);

        
        setSize(350,400); // Adjusts dimension of the frame 
        setVisible(true); // Sets the frame to visible
        setResizable(false); // Sets the frame to be unresizable
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Sets the default close to exit the program


    }

    private void MainMenu(){

        MenuPanel = new CustomPanel("Background.jpg");
        MenuPanel.setLayout(new BoxLayout(MenuPanel, BoxLayout.Y_AXIS));

        MenuPanel.setAlignmentX(Component.CENTER_ALIGNMENT); 

        MenuPanel.add(Box.createVerticalStrut(10));

        JLabel MainLbl1 = new JLabel("Select a Feature:");
        MainLbl1.setAlignmentX(Component.CENTER_ALIGNMENT); 
        MainLbl1.setFont(new Font("Segoe UI", Font.BOLD, 20));
        MenuPanel.add(MainLbl1);

        MenuPanel.add(Box.createVerticalStrut(25));

        JButton MainOpt1 = new JButton("Create New Hotel");
        MainOpt1.setAlignmentX(Component.CENTER_ALIGNMENT); 
        MainOpt1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        MainOpt1.setMaximumSize(new Dimension(130, 25));
        MenuPanel.add(MainOpt1);

        MenuPanel.add(Box.createVerticalStrut(25));

        JButton MainOpt2 = new JButton("View Hotel");
        MainOpt2.setAlignmentX(Component.CENTER_ALIGNMENT);
        MainOpt2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        MainOpt2.setMaximumSize(new Dimension(130, 25));
        MenuPanel.add(MainOpt2);

        MenuPanel.add(Box.createVerticalStrut(25));

        JButton MainOpt3 = new JButton("Manage Hotel");
        MainOpt3.setAlignmentX(Component.CENTER_ALIGNMENT);
        MainOpt3.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        MainOpt3.setMaximumSize(new Dimension(130, 25));
        MenuPanel.add(MainOpt3);

        MenuPanel.add(Box.createVerticalStrut(25));

        JButton MainOpt4 = new JButton("Simulate Booking");
        MainOpt4.setAlignmentX(Component.CENTER_ALIGNMENT);
        MainOpt4.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        MainOpt4.setMaximumSize(new Dimension(130, 25));
        MenuPanel.add(MainOpt4);

        MenuPanel.add(Box.createVerticalStrut(25));

        JButton MainOpt5 = new JButton("Exit");
        MainOpt5.setAlignmentX(Component.CENTER_ALIGNMENT);
        MainOpt5.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        MainOpt5.setMaximumSize(new Dimension(130, 25));
        MenuPanel.add(MainOpt5);

        MenuPanel.add(Box.createVerticalStrut(10));
        
        JLabel notify = new JLabel();
        notify.setAlignmentX(Component.CENTER_ALIGNMENT);
        notify.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        

        MainOpt1.addActionListener(e -> {
            notify.setText("");
            Layout.show(MainPanel, "CreateHotel");
        });

        MainOpt2.addActionListener(e -> {
            if (hotel.isEmpty())
            {
                notify.setText("There are no hotels in the system at the moment");
                notify.setForeground(Color.RED);
                MenuPanel.add(notify);
                MenuPanel.revalidate();
                MenuPanel.repaint();
            }
            else
            {
                hotelSelection.removeAllItems();
                for(int i=0;i<hotel.size();i++)
                {
                    hotelSelection.addItem(hotel.get(i).getName());
                }

                Layout.show(MainPanel, "ViewHotelPanel");
            }
                
        });

        MainOpt3.addActionListener(e -> {
            if (hotel.isEmpty())
            {
                notify.setText("There are no hotels in the system at the moment");
                notify.setForeground(Color.RED);
                MenuPanel.add(notify);
                MenuPanel.revalidate();
                MenuPanel.repaint();
            }
            else
            {
                hotelSelection3.removeAllItems();
                for(int i=0;i<hotel.size();i++)
                {
                    hotelSelection3.addItem(hotel.get(i).getName());
                }

                Layout.show(MainPanel, "ModifyHotelPanel");
            }
                
        });

        MainOpt4.addActionListener(e -> {
            if (hotel.isEmpty())
            {
                notify.setText("There are no hotels in the system at the moment");
                notify.setForeground(Color.RED);
                MenuPanel.add(notify);
                MenuPanel.revalidate();
                MenuPanel.repaint();
            }
            else
            {
                hotelSelection2.removeAllItems();
                for(int i=0;i<hotel.size();i++)
                {
                    hotelSelection2.addItem(hotel.get(i).getName());
                }

                Layout.show(MainPanel, "BookingPanel");
            }
                
        });

        MainOpt5.addActionListener(e -> {
            System.exit(0);
        });
    }
    private void CreateHotel(){

        CreateHotel = new CustomPanel("Background.jpg");
        CreateHotel.setLayout(new BoxLayout(CreateHotel, BoxLayout.Y_AXIS));

        CreateHotel.add(Box.createVerticalStrut(80));

        JLabel createHotel = new JLabel("Create a hotel name that is unique:");
        createHotel.setAlignmentX(Component.CENTER_ALIGNMENT);
        createHotel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        CreateHotel.add(createHotel);
       
        CreateHotel.add(Box.createVerticalStrut(20));

        JTextField textField = new JTextField(30); 
        Dimension preferredSize = new Dimension(300, 20);
        textField.setAlignmentX(Component.CENTER_ALIGNMENT);
        textField.setMaximumSize(preferredSize);
        CreateHotel.add(textField);

        CreateHotel.add(Box.createVerticalStrut(20));

        JButton confirmButton = new JButton("Confirm");
        confirmButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        confirmButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        CreateHotel.add(confirmButton);

        CreateHotel.add(Box.createVerticalStrut(20));
        JLabel notify = new JLabel(); 
        notify.setAlignmentX(CENTER_ALIGNMENT);
        notify.setFont(new Font("Segoe UI", Font.PLAIN, 12));

        confirmButton.addActionListener(e -> {

            String inputText = textField.getText();
            boolean valid = true;
            int i=0;
                if (inputText.equals(""))
                {
                    notify.setText("Hotel name cannot be blank");
                    notify.setForeground(Color.RED);
                    CreateHotel.add(notify);
                    CreateHotel.revalidate();
                    CreateHotel.repaint();
                    valid = false;
                }
				else if (!hotel.isEmpty())
					while (i<hotel.size()) // Checks if hotel name already exists
					{
						if (hotel.get(i).getName().equals(inputText)) // Loops until hotel name is unique
							{
                            notify.setText(inputText + " already in exists");
                            notify.setForeground(Color.RED);
							CreateHotel.add(notify);
							CreateHotel.revalidate();
                            CreateHotel.repaint();
                            valid = false;
							
							
						}
						i++;
					}
            if (valid)
            {
				hotel.add(new Hotel(inputText));
                hotelIndex = hotel.size()-1;
                notify.setText("");
                Layout.show(MainPanel, "AddRoomPanel");
                
                
            }
            textField.setText("");
            
            
        });



    }
    private void AddRoom(){
        
        AddRoomPanel = new CustomPanel("Background.jpg");
        AddRoomPanel.setLayout(new BoxLayout(AddRoomPanel, BoxLayout.Y_AXIS));

        AddRoomPanel.add(Box.createVerticalStrut(120));
        JLabel addRoom = new JLabel("Add more rooms?");
        addRoom.setAlignmentX(Component.CENTER_ALIGNMENT);
        addRoom.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        AddRoomPanel.add(addRoom);

        CustomPanel AddRoomPanelSouth = new CustomPanel("Background.jpg");
        AddRoomPanelSouth.setLayout(new FlowLayout());
        

        JButton yesButton = new JButton("Yes");
        yesButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        yesButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        AddRoomPanelSouth.add(yesButton);

        JButton noButton = new JButton("No");
        noButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        noButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        AddRoomPanelSouth.add(noButton);

        JLabel notify = new JLabel();
        notify.setAlignmentX(CENTER_ALIGNMENT);
        notify.setFont(new Font("Segoe UI", Font.PLAIN, 12));

        AddRoomPanel.add(AddRoomPanelSouth);

        yesButton.addActionListener(e -> {

            if (hotel.get(hotelIndex).getRooms()==50)
            {
                notify.setText("            Maximum amount of rooms reached");
                notify.setForeground(Color.RED);
				AddRoomPanelSouth.add(notify);
				AddRoomPanelSouth.revalidate();
                AddRoomPanelSouth.repaint();
            }
            else
            Layout.show(MainPanel, "SelectRoomType");
        });
 
        noButton.addActionListener(e -> {
            notify.setText("");
            Layout.show(MainPanel, "SetPricePanel");

        });
    }

    private void RoomType(){
        SelectRoomType = new CustomPanel("Background.jpg");
        SelectRoomType.setLayout(new BoxLayout(SelectRoomType, BoxLayout.Y_AXIS));

        SelectRoomType.add(Box.createVerticalStrut(100));
        JLabel selectType = new JLabel("Add what type of room?");
        selectType.setAlignmentX(Component.CENTER_ALIGNMENT);
        selectType.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        SelectRoomType.add(selectType);

        CustomPanel RoomTypeSouth = new CustomPanel("Background.jpg");
        RoomTypeSouth.setLayout(new FlowLayout());

        JButton standardButton = new JButton("Standard");
        standardButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        standardButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        RoomTypeSouth.add(standardButton);

        JButton deluxeButton = new JButton("Deluxe");
        deluxeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        deluxeButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        RoomTypeSouth.add(deluxeButton);

        JButton exclusiveButton = new JButton("Exclusive");
        exclusiveButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exclusiveButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        RoomTypeSouth.add(exclusiveButton);

        SelectRoomType.add(RoomTypeSouth);

        standardButton.addActionListener(e -> {
            hotel.get(hotelIndex).addRoom(1);
            Layout.show(MainPanel, "AddRoomPanel");
        });

        deluxeButton.addActionListener(e -> {
            hotel.get(hotelIndex).addRoom(2);
            Layout.show(MainPanel, "AddRoomPanel");
        });

        exclusiveButton.addActionListener(e -> {
            hotel.get(hotelIndex).addRoom(3);
            Layout.show(MainPanel, "AddRoomPanel");
        });
    }
    
    private  void SetPrice(){

        SetPricePanel = new CustomPanel("Background.jpg");
        SetPricePanel.setLayout(new BoxLayout(SetPricePanel, BoxLayout.Y_AXIS));

        SetPricePanel.add(Box.createVerticalStrut(80));

        JLabel setPrice = new JLabel("Set Room Price:");
        setPrice.setAlignmentX(Component.CENTER_ALIGNMENT);
        setPrice.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        SetPricePanel.add(setPrice);
       
        SetPricePanel.add(Box.createVerticalStrut(20));

        JTextField textField = new JTextField(30); 
        Dimension preferredSize = new Dimension(200, 20);
        textField.setAlignmentX(Component.CENTER_ALIGNMENT);
        textField.setMaximumSize(preferredSize);
        SetPricePanel.add(textField);

        CustomPanel ButtonPricePanel = new CustomPanel("Background.jpg");
        ButtonPricePanel.setLayout(new FlowLayout());

        JButton skipButton = new JButton("Skip");
        skipButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        skipButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        ButtonPricePanel.add(skipButton);

        JButton confirmButton = new JButton("Confirm");
        confirmButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        confirmButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        ButtonPricePanel.add(confirmButton);


        JLabel notify = new JLabel();
        notify.setAlignmentX(CENTER_ALIGNMENT);
        notify.setFont(new Font("Segoe UI", Font.PLAIN, 12));

        SetPricePanel.add(ButtonPricePanel);

        confirmButton.addActionListener(e -> {

            try {
				float num = Float.parseFloat(textField.getText());
                if (num < 100)
                {
                    notify.setText("Set price not enough, try a higher number");
                    notify.setForeground(Color.RED);
                    ButtonPricePanel.add(notify);
                    ButtonPricePanel.revalidate();
                    ButtonPricePanel.repaint();
                }
                else
                {
                    notify.setText("");
                    textField.setText(""); 
                    hotel.get(hotelIndex).setRoomPrice(num);
                    Layout.show(MainPanel, "MenuPanel");
                }
			} catch (Exception ex) {
				notify.setText("           Invalid input, Please try again");
                notify.setForeground(Color.RED);
				ButtonPricePanel.add(notify);
				ButtonPricePanel.revalidate();
                ButtonPricePanel.repaint();
			}
        });

        skipButton.addActionListener(e -> {
            notify.setText("");
            textField.setText(""); 
            Layout.show(MainPanel, "MenuPanel");
        });


    }

    private void ViewHotel(){

        ViewHotelPanel = new CustomPanel("Background.jpg");
        ViewHotelPanel.setLayout(new BoxLayout(ViewHotelPanel, BoxLayout.Y_AXIS));

        ViewHotelPanel.add(Box.createVerticalStrut(80));

        JLabel hotelSelect = new JLabel("Please Select a Hotel:");
        hotelSelect.setAlignmentX(Component.CENTER_ALIGNMENT);
        hotelSelect.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        ViewHotelPanel.add(hotelSelect);

        ViewHotelPanel.add(Box.createVerticalStrut(20));

        hotelSelection = new JComboBox<>();
        Dimension preferredSize = new Dimension(300, 20);
        hotelSelection.setMaximumSize(preferredSize);
        hotelSelection.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        ViewHotelPanel.add(hotelSelection);

        ViewHotelPanel.add(Box.createVerticalStrut(20));

        JButton confirmButton = new JButton("Confirm");
        confirmButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        confirmButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        ViewHotelPanel.add(confirmButton);

        HotelInfoPanel = new CustomPanel("Background.jpg");
        HotelInfoPanel.setLayout(new BoxLayout(HotelInfoPanel, BoxLayout.Y_AXIS));

        HotelInfoPanel.add(Box.createVerticalStrut(40));
        
        JLabel hotelName = new JLabel();
        hotelName.setFont(new Font("Segoe UI", Font.BOLD, 16));
        hotelName.setAlignmentX(Component.CENTER_ALIGNMENT);
        HotelInfoPanel.add(hotelName);
        
        JLabel totalRoom = new JLabel();
        totalRoom.setFont(new Font("Segoe UI", Font.BOLD, 16));
        totalRoom.setAlignmentX(Component.CENTER_ALIGNMENT);
        HotelInfoPanel.add(totalRoom);

        JLabel earnings = new JLabel();
        earnings.setFont(new Font("Segoe UI", Font.BOLD, 16));
        earnings.setAlignmentX(Component.CENTER_ALIGNMENT);
        HotelInfoPanel.add(earnings);

        HotelInfoPanel.add(Box.createVerticalStrut(20));

        JButton Opt1 = new JButton("View available and booked rooms for a certain date");
        Opt1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        Opt1.setAlignmentX(Component.CENTER_ALIGNMENT);
        HotelInfoPanel.add(Opt1);

        HotelInfoPanel.add(Box.createVerticalStrut(20));

        JButton Opt2 = new JButton("View room information");
        Opt2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        Opt2.setAlignmentX(Component.CENTER_ALIGNMENT);
        HotelInfoPanel.add(Opt2);

        HotelInfoPanel.add(Box.createVerticalStrut(20));

        JButton Opt3 = new JButton("View reservation information");
        Opt3.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        Opt3.setAlignmentX(Component.CENTER_ALIGNMENT);
        HotelInfoPanel.add(Opt3);

        HotelInfoPanel.add(Box.createVerticalStrut(20));

        JButton Opt4 = new JButton("Return to Main Menu");
        Opt4.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        Opt4.setAlignmentX(Component.CENTER_ALIGNMENT);
        HotelInfoPanel.add(Opt4);

        HotelInfoPanel.add(Box.createVerticalStrut(20));

        JLabel notify = new JLabel();
        notify.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        notify.setAlignmentX(Component.CENTER_ALIGNMENT);
        

        confirmButton.addActionListener(e -> {

            float j = 0;
            hotelIndex = hotelSelection.getSelectedIndex();

            for(int d=0;d<hotel.get(hotelIndex).getReservations().size();d++) // Sums up all the total earnings of each reservation in the hotel
                j += hotel.get(hotelIndex).getReservations().get(d).getTotalPrice();

            hotelName.setText("Hotel Name: "+hotel.get(hotelIndex).getName());
            totalRoom.setText("Total Rooms: "+hotel.get(hotelIndex).getRooms());
            earnings.setText("Estimate Earnings: "+ String.format("%.2f", j));
            Layout.show(MainPanel, "HotelInfoPanel");
        });

        Opt1.addActionListener(e -> {
            if (hotel.get(hotelIndex).getRooms()==0)
            {
                notify.setText("There are no rooms at the moment");
                notify.setForeground(Color.RED);
                HotelInfoPanel.add(notify);
                HotelInfoPanel.revalidate();
                HotelInfoPanel.repaint();
            }
            else
            {
                notify.setText("");
                Layout.show(MainPanel, "CheckDatePanel");
            }
            
        });

        Opt2.addActionListener(e -> {
            if (hotel.get(hotelIndex).getRooms()==0)
            {
                notify.setText("There are no rooms at the moment");
                notify.setForeground(Color.RED);
                HotelInfoPanel.add(notify);
                HotelInfoPanel.revalidate();
                HotelInfoPanel.repaint();
            }
            else
            {
                notify.setText("");
                roomSelection.removeAllItems();
                for(int i=0;i<hotel.get(hotelIndex).getRooms();i++)
                {
                    roomSelection.addItem("Room "+hotel.get(hotelIndex).getAllRooms()[i].getRoomName());
                }
                Layout.show(MainPanel, "ViewRoomPanel");
            }
        });

        Opt3.addActionListener(e -> {
            if (hotel.get(hotelIndex).getReservations().isEmpty())
            {
                notify.setText("There are no reservations at the moment");
                notify.setForeground(Color.RED);
                HotelInfoPanel.add(notify);
                HotelInfoPanel.revalidate();
                HotelInfoPanel.repaint();
            }
            else
            {
                notify.setText("");
                bookingSelection.removeAllItems();
                for(int i=0;i<hotel.get(hotelIndex).getReservations().size();i++)
                {
                    bookingSelection.addItem("Room "+hotel.get(hotelIndex).getReservations().get(i).getRoomReserved()+
                    " reservation "+ "by "+hotel.get(hotelIndex).getReservations().get(i).getGuestName());
					                        
                }
                Layout.show(MainPanel, "BookingInfoPanel");
            }

        });

        Opt4.addActionListener(e -> {
            Layout.show(MainPanel, "MenuPanel");
        });

    }

    private void ViewRoom(){

        ViewRoomPanel = new CustomPanel("Background.jpg");
        ViewRoomPanel.setLayout(new BoxLayout(ViewRoomPanel, BoxLayout.Y_AXIS));

        ViewRoomPanel.add(Box.createVerticalStrut(80));

        JLabel roomSelect = new JLabel("Please Select a Room:");
        roomSelect.setAlignmentX(Component.CENTER_ALIGNMENT);
        roomSelect.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        ViewRoomPanel.add(roomSelect);

        ViewRoomPanel.add(Box.createVerticalStrut(20));

        roomSelection = new JComboBox<>();
        Dimension preferredSize = new Dimension(300, 20);
        roomSelection.setMaximumSize(preferredSize);
        roomSelection.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        ViewRoomPanel.add(roomSelection);

        ViewRoomPanel.add(Box.createVerticalStrut(20));

        JButton confirmButton = new JButton("Confirm");
        confirmButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        confirmButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        ViewRoomPanel.add(confirmButton);

        RoomInfoPanel = new CustomPanel("Background.jpg");
        RoomInfoPanel.setLayout(new BoxLayout(RoomInfoPanel, BoxLayout.Y_AXIS));

        RoomInfoPanel.add(Box.createVerticalStrut(20));

        JLabel roomName = new JLabel();
        roomName.setAlignmentX(Component.CENTER_ALIGNMENT);
        roomName.setFont(new Font("Segoe UI", Font.BOLD, 16));
        RoomInfoPanel.add(roomName);

        JLabel roomPrice = new JLabel();
        roomPrice.setAlignmentX(Component.CENTER_ALIGNMENT);
        roomPrice.setFont(new Font("Segoe UI", Font.BOLD, 16));
        RoomInfoPanel.add(roomPrice);

        JLabel bookingStatus = new JLabel("Booking Status:");
        bookingStatus.setAlignmentX(Component.CENTER_ALIGNMENT);
        bookingStatus.setFont(new Font("Segoe UI", Font.BOLD, 16));
        RoomInfoPanel.add(bookingStatus);
        
        JTextArea textLogArea = new JTextArea();
        textLogArea.setEditable(false); 
        textLogArea.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        textLogArea.setMaximumSize(new Dimension(100, 10));
        textLogArea.setVisible(false);
        RoomInfoPanel.add(textLogArea);
        

        JScrollPane scrollPane = new JScrollPane(textLogArea);    
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setVisible(false);
        RoomInfoPanel.add(scrollPane);

        RoomInfoPanel.add(Box.createVerticalStrut(20));

        JButton returnButton = new JButton("Return to Main Menu");
        returnButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        returnButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        

        confirmButton.addActionListener(e -> {

            roomIndex = roomSelection.getSelectedIndex();

            roomName.setText("Room Name: Room "+hotel.get(hotelIndex).getAllRooms()[roomIndex].getRoomName());

            if (hotel.get(hotelIndex).getAllRooms()[roomIndex] instanceof DeluxeRoom)
                roomPrice.setText("Price per night: "+hotel.get(hotelIndex).getRoomPrice()*1.2);
            else if (hotel.get(hotelIndex).getAllRooms()[roomIndex] instanceof ExclusiveRoom)
                roomPrice.setText("Price per night: "+hotel.get(hotelIndex).getRoomPrice()*1.35);
            else 
                roomPrice.setText("Price per night: "+hotel.get(hotelIndex).getRoomPrice());
            
            if(hotel.get(hotelIndex).getAllRooms()[roomIndex].getRoomReservations().isEmpty())
                bookingStatus.setText("Booking Status: Available across the month");
            else
            {


                textLogArea.setVisible(true);
                scrollPane.setVisible(true);
                for(int i=0;i<hotel.get(hotelIndex).getAllRooms()[roomIndex].getRoomReservations().size();i++) 
                {
                    int inHour = hotel.get(hotelIndex).getAllRooms()[roomIndex].getRoomReservations().get(i).getCheckInDate().getHour();
                    int outHour = hotel.get(hotelIndex).getAllRooms()[roomIndex].getRoomReservations().get(i).getCheckOutDate().getHour();
                
                    if(inHour > 12)
                        inHour -= 12;
                    else if (inHour == 0)
                        inHour = 12;

                    if(outHour > 12)
                        outHour -= 12;
                    else if (outHour == 0)
                        outHour = 12;
                    

                    textLogArea.append(" Booked on Day "+hotel.get(hotelIndex).getAllRooms()[roomIndex].getRoomReservations().get(i).getCheckInDate().getDay()+", "+inHour+
                                      ":"+String.format("%02d",hotel.get(hotelIndex).getAllRooms()[roomIndex].getRoomReservations().get(i).getCheckInDate().getMinute()));
                    if(hotel.get(hotelIndex).getAllRooms()[roomIndex].getRoomReservations().get(i).getCheckInDate().getHour() > 12)
                        textLogArea.append(" PM");
                    else
                        textLogArea.append(" AM");

                    textLogArea.append(" to Day "+hotel.get(hotelIndex).getAllRooms()[roomIndex].getRoomReservations().get(i).getCheckOutDate().getDay()+", "+outHour+
                        ":"+String.format("%02d",hotel.get(hotelIndex).getAllRooms()[roomIndex].getRoomReservations().get(i).getCheckOutDate().getMinute()));
                    if(hotel.get(hotelIndex).getAllRooms()[roomIndex].getRoomReservations().get(i).getCheckOutDate().getHour() > 12)
                        textLogArea.append(" PM\n");
                    else
                        textLogArea.append(" AM\n");
                }
						
                
            }
            textLogArea.setCaretPosition(0);
            RoomInfoPanel.add(returnButton);
            Layout.show(MainPanel, "RoomInfoPanel");
        });

        returnButton.addActionListener(e -> {
            textLogArea.setText("");
            textLogArea.setVisible(false);
            scrollPane.setVisible(false);
            Layout.show(MainPanel, "MenuPanel");
        });
    }

    private void BookHotel(){

        BookingPanel = new CustomPanel("Background.jpg");
        BookingPanel.setLayout(new BoxLayout(BookingPanel, BoxLayout.Y_AXIS));

        BookingPanel.add(Box.createVerticalStrut(80));

        JLabel hotelSelect = new JLabel("Please Select a Hotel:");
        hotelSelect.setAlignmentX(Component.CENTER_ALIGNMENT);
        hotelSelect.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        BookingPanel.add(hotelSelect);

        BookingPanel.add(Box.createVerticalStrut(20));

        hotelSelection2 = new JComboBox<>();
        Dimension preferredSize = new Dimension(300, 20);
        hotelSelection2.setMaximumSize(preferredSize);
        hotelSelection2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        BookingPanel.add(hotelSelection2);

        BookingPanel.add(Box.createVerticalStrut(20));

        JButton confirmButton = new JButton("Confirm");
        confirmButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        confirmButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        BookingPanel.add(confirmButton);

        BookingPanel.add(Box.createVerticalStrut(20));

        JLabel notify = new JLabel();
        notify.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        notify.setAlignmentX(Component.CENTER_ALIGNMENT);

        confirmButton.addActionListener(e -> {
            hotelIndex = hotelSelection2.getSelectedIndex();
            if (hotel.get(hotelIndex).getRooms()==0)
            {
                notify.setText("There are no rooms at the moment");
                notify.setForeground(Color.RED);
                BookingPanel.add(notify);
                BookingPanel.revalidate();
                BookingPanel.repaint();
            }
            else
            {
                notify.setText("");
                Layout.show(MainPanel, "DatesPanel");
            }
                
        });
    }

    private void BookRoom(){

    BookRoomPanel = new CustomPanel("Background.jpg");
    BookRoomPanel.setLayout(new BoxLayout(BookRoomPanel, BoxLayout.Y_AXIS));

    BookRoomPanel.add(Box.createVerticalStrut(80));

    JLabel roomSelect = new JLabel("Please Select a Room:");
    roomSelect.setAlignmentX(Component.CENTER_ALIGNMENT);
    roomSelect.setFont(new Font("Segoe UI", Font.PLAIN, 16));
    BookRoomPanel.add(roomSelect);

    BookRoomPanel.add(Box.createVerticalStrut(20));

    roomSelection2 = new JComboBox<>();
    Dimension preferredSize = new Dimension(300, 20);
    roomSelection2.setMaximumSize(preferredSize);
    roomSelection2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
    BookRoomPanel.add(roomSelection2);

    BookRoomPanel.add(Box.createVerticalStrut(20));

    JButton confirmButton = new JButton("Confirm");
    confirmButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    confirmButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
    BookRoomPanel.add(confirmButton);

    JButton backButton = new JButton("Go Back");
    backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    backButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));

    JButton returnButton = new JButton("Return to Main Menu");
    returnButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    returnButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));

    JLabel notify = new JLabel(); 
    notify.setAlignmentX(CENTER_ALIGNMENT);
    notify.setFont(new Font("Segoe UI", Font.PLAIN, 12));

    confirmButton.addActionListener(e -> {
        roomIndex = roomSelection2.getSelectedIndex();
        if(!hotel.get(hotelIndex).getAllRooms()[roomIndex].getRoomReservations().isEmpty())
        {
            if(hotel.get(hotelIndex).getAllRooms()[roomIndex].isAvailable(CheckIn, CheckOut))
            {
                BookRoomPanel.remove(backButton);
                BookRoomPanel.remove(returnButton);
                Layout.show(MainPanel, "NamePanel");
            }
            else
            {
                BookRoomPanel.add(backButton);

                BookRoomPanel.add(returnButton);

                notify.setText("Dates already reserved, please try another room or date");
                notify.setForeground(Color.RED);
                BookRoomPanel.add(notify);
                BookRoomPanel.revalidate();
                BookRoomPanel.repaint();
            }
        }
        else 
        {
            notify.setText("");
            Layout.show(MainPanel, "NamePanel");
        }
            
    });

    returnButton.addActionListener(e -> {
        BookRoomPanel.remove(backButton);
        BookRoomPanel.remove(returnButton);
        notify.setText("");
        Layout.show(MainPanel, "MenuPanel");  
    });

    backButton.addActionListener(e -> {
        BookRoomPanel.remove(backButton);
        BookRoomPanel.remove(returnButton);
        notify.setText("");
        Layout.show(MainPanel, "DatesPanel");     
    });

    }

    private void InputDates(){

        CheckIn = new Date();
        CheckOut = new Date();

        DatesPanel = new CustomPanel("Background.jpg");
        DatesPanel.setLayout(new BoxLayout(DatesPanel, BoxLayout.Y_AXIS));

        DatesPanel.add(Box.createVerticalStrut(20));

        JLabel checkIn = new JLabel("Input Check-In Date");
        checkIn.setFont(new Font("Segoe UI", Font.BOLD, 16));
        checkIn.setAlignmentX(Component.CENTER_ALIGNMENT);
        DatesPanel.add(checkIn);

        DatesPanel.add(Box.createVerticalStrut(20));

        JLabel indayLabel = new JLabel("Select Day:");
        indayLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        indayLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        DatesPanel.add(indayLabel);

        JComboBox<Integer> indaySelection = new JComboBox<>();
        Dimension preferredSize = new Dimension(55, 20);
        indaySelection.setMaximumSize(preferredSize);
        indaySelection.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        DatesPanel.add(indaySelection);
            
        for(int i=1;i<=31;i++)
            indaySelection.addItem(i);

        JLabel intimeLabel = new JLabel("Select Time:");
        intimeLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        intimeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        DatesPanel.add(intimeLabel);

        SpinnerDateModel dateModel = new SpinnerDateModel();
        JSpinner timeSpinner = new JSpinner(dateModel);
        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "HH:mm");
        timeSpinner.setEditor(timeEditor);
        timeSpinner.setMaximumSize(preferredSize);
        timeSpinner.setFont(new Font("Segoe UI", Font.BOLD, 12));
        DatesPanel.add(timeSpinner);
        JFormattedTextField textField = timeEditor.getTextField();
        textField.setEditable(false);

        DatesPanel.add(Box.createVerticalStrut(10));

        JLabel checkOut = new JLabel("Input Check-Out Date:");
        checkOut.setFont(new Font("Segoe UI", Font.BOLD, 16));
        checkOut.setAlignmentX(Component.CENTER_ALIGNMENT);
        DatesPanel.add(checkOut);

        DatesPanel.add(Box.createVerticalStrut(20));
    
        JLabel outdayLabel = new JLabel("Select Day:");
        outdayLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        outdayLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        DatesPanel.add(outdayLabel);

        JComboBox<Integer> outdaySelection = new JComboBox<>();
        outdaySelection.setMaximumSize(preferredSize);
        outdaySelection.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        DatesPanel.add(outdaySelection);
            
        for(int i=1;i<=31;i++)
            outdaySelection.addItem(i);

        JLabel outtimeLabel = new JLabel("Select Time:");
        outtimeLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        outtimeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        DatesPanel.add(outtimeLabel);

        SpinnerDateModel dateModel2 = new SpinnerDateModel();
        JSpinner timeSpinner2 = new JSpinner(dateModel2);
        JSpinner.DateEditor timeEditor2 = new JSpinner.DateEditor(timeSpinner2, "HH:mm");
        timeSpinner2.setEditor(timeEditor2);
        timeSpinner2.setMaximumSize(preferredSize);
        timeSpinner2.setFont(new Font("Segoe UI", Font.BOLD, 12));
        DatesPanel.add(timeSpinner2);
        JFormattedTextField textField2 = timeEditor2.getTextField();
        textField2.setEditable(false);

        DatesPanel.add(Box.createVerticalStrut(20));
        
        JButton confirmButton = new JButton("Confirm");
        confirmButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        confirmButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        DatesPanel.add(confirmButton);
        
        DatesPanel.add(Box.createVerticalStrut(10));

        JLabel notify = new JLabel();
        notify.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        notify.setAlignmentX(Component.CENTER_ALIGNMENT);
        

        timeSpinner.addChangeListener(e -> {
            
            java.util.Date selectedTime = (java.util.Date) timeSpinner.getValue();

            // Use Calendar to get the hour, minute, and second
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(selectedTime);
            CheckIn.setHour(calendar.get(Calendar.HOUR_OF_DAY));
            CheckIn.setMinute(calendar.get(Calendar.MINUTE));
            
        });

        timeSpinner2.addChangeListener(e -> {
            
            java.util.Date selectedTime = (java.util.Date) timeSpinner.getValue();

            // Use Calendar to get the hour, minute, and second
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(selectedTime);
            CheckOut.setHour(calendar.get(Calendar.HOUR_OF_DAY));
            CheckOut.setMinute(calendar.get(Calendar.MINUTE));
            
        });

        confirmButton.addActionListener(e -> {
            
            CheckIn.setDay((int)indaySelection.getSelectedItem());
            CheckOut.setDay((int)outdaySelection.getSelectedItem());

            if (CheckOut.getDay()<=CheckIn.getDay())
            {
                notify.setText("Invalid, check-out date must be before check-in date");
                notify.setForeground(Color.RED);
                DatesPanel.add(notify);
                DatesPanel.revalidate();
                DatesPanel.repaint();
            }
            else
            {
                roomSelection2.removeAllItems();
                for(int i=0;i<hotel.get(hotelIndex).getRooms();i++)
                {
                    roomSelection2.addItem("Room "+hotel.get(hotelIndex).getAllRooms()[i].getRoomName());
                }
                notify.setText("");
                Layout.show(MainPanel, "BookRoomPanel");
            }
            
        });
    }

    private void GuestName(){
        NamePanel = new CustomPanel("Background.jpg");
        NamePanel.setLayout(new BoxLayout(NamePanel, BoxLayout.Y_AXIS));

        NamePanel.add(Box.createVerticalStrut(80));

        JLabel enterName = new JLabel("Enter Guest Name:");
        enterName.setAlignmentX(Component.CENTER_ALIGNMENT);
        enterName.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        NamePanel.add(enterName);
       
        NamePanel.add(Box.createVerticalStrut(20));

        JTextField textField = new JTextField(30); 
        Dimension preferredSize = new Dimension(300, 20);
        textField.setAlignmentX(Component.CENTER_ALIGNMENT);
        textField.setMaximumSize(preferredSize);
        NamePanel.add(textField);

        NamePanel.add(Box.createVerticalStrut(20));

        JButton confirmButton = new JButton("Confirm");
        confirmButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        confirmButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        NamePanel.add(confirmButton);

        NamePanel.add(Box.createVerticalStrut(20));

        JLabel notify = new JLabel(); 
        notify.setAlignmentX(CENTER_ALIGNMENT);
        notify.setFont(new Font("Segoe UI", Font.PLAIN, 12));

        confirmButton.addActionListener(e -> {

            String inputText = textField.getText();

            if(inputText.equals(""))
            {
                notify.setText("Guest name cannot be blank");
                notify.setForeground(Color.RED);
                NamePanel.add(notify);
                NamePanel.revalidate();
                NamePanel.repaint();
            }
            else
            {
                notify.setText("");

                hotel.get(hotelIndex).createReservation(inputText);
                reserveIndex = hotel.get(hotelIndex).getReservations().size()-1;
                hotel.get(hotelIndex).getReservations().get(reserveIndex).setCheckIn(CheckIn.getDay(), CheckIn.getHour(), CheckIn.getMinute());
                hotel.get(hotelIndex).getReservations().get(reserveIndex).setCheckOut(CheckOut.getDay(), CheckOut.getHour(), CheckOut.getMinute());
                hotel.get(hotelIndex).getReservations().get(reserveIndex).setRoomReserved(hotel.get(hotelIndex).getAllRooms()[roomIndex]);
                Layout.show(MainPanel, "DiscountPanel");
            }
            textField.setText("");
 
        });
    }

    private void SetDiscount(){

        DiscountPanel = new CustomPanel("Background.jpg");
        DiscountPanel.setLayout(new BoxLayout(DiscountPanel, BoxLayout.Y_AXIS));

        DiscountPanel.add(Box.createVerticalStrut(80));

        JLabel enterDisc = new JLabel("Enter Discount Code:");
        enterDisc.setAlignmentX(Component.CENTER_ALIGNMENT);
        enterDisc.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        DiscountPanel.add(enterDisc);
       
        DiscountPanel.add(Box.createVerticalStrut(20));

        JTextField textField = new JTextField(30); 
        Dimension preferredSize = new Dimension(200, 20);
        textField.setAlignmentX(Component.CENTER_ALIGNMENT);
        textField.setMaximumSize(preferredSize);
        DiscountPanel.add(textField);

        CustomPanel ButtonDiscPanel = new CustomPanel("Background.jpg");
        ButtonDiscPanel.setLayout(new FlowLayout());

        JButton skipButton = new JButton("Skip");
        skipButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        skipButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        ButtonDiscPanel.add(skipButton);

        JButton confirmButton = new JButton("Confirm");
        confirmButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        confirmButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        ButtonDiscPanel.add(confirmButton);

        JLabel notify = new JLabel();
        notify.setAlignmentX(CENTER_ALIGNMENT);
        notify.setFont(new Font("Segoe UI", Font.PLAIN, 12));

        DiscountPanel.add(ButtonDiscPanel);
        
        confirmButton.addActionListener(e -> {
            String inputText = textField.getText();
            if(inputText.equals(""))
            {
                notify.setText("        Discount code cannot be blank");
                notify.setForeground(Color.RED);
                ButtonDiscPanel.add(notify);
                ButtonDiscPanel.revalidate();
                ButtonDiscPanel.repaint(); 
            }
            else if(hotel.get(hotelIndex).getReservations().get(reserveIndex).setDiscount(inputText))
            {
                hotel.get(hotelIndex).getReservations().get(reserveIndex).setTotalPrice(hotel.get(hotelIndex));
                hotel.get(hotelIndex).getAllRooms()[roomIndex].reserveRoom(hotel.get(hotelIndex).getReservations().get(reserveIndex));
                notify.setText("");
                Layout.show(MainPanel, "MenuPanel");
            }
            else
            {
                notify.setText("        Discount code "+inputText+" cannot be applied");
                notify.setForeground(Color.RED);
                ButtonDiscPanel.add(notify);
                ButtonDiscPanel.revalidate();
                ButtonDiscPanel.repaint();   
            }
            
            textField.setText(""); 
        });

        skipButton.addActionListener(e -> {
            notify.setText("");
            hotel.get(hotelIndex).getReservations().get(reserveIndex).setTotalPrice(hotel.get(hotelIndex));
            hotel.get(hotelIndex).getAllRooms()[roomIndex].reserveRoom(hotel.get(hotelIndex).getReservations().get(reserveIndex));
            Layout.show(MainPanel, "MenuPanel");
        });
    }

    private void CheckAvailable(){

        CheckDatePanel = new CustomPanel("Background.jpg");
        
        CheckIn2 = new Date();
        CheckOut2 = new Date();

        CheckDatePanel = new CustomPanel("Background.jpg");
        CheckDatePanel.setLayout(new BoxLayout(CheckDatePanel, BoxLayout.Y_AXIS));

        CheckDatePanel.add(Box.createVerticalStrut(20));

        JLabel checkIn = new JLabel("Input Check-In Date");
        checkIn.setFont(new Font("Segoe UI", Font.BOLD, 16));
        checkIn.setAlignmentX(Component.CENTER_ALIGNMENT);
        CheckDatePanel.add(checkIn);

        CheckDatePanel.add(Box.createVerticalStrut(20));

        JLabel indayLabel = new JLabel("Select Day:");
        indayLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        indayLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        CheckDatePanel.add(indayLabel);

        JComboBox<Integer> indaySelection = new JComboBox<>();
        Dimension preferredSize = new Dimension(55, 20);
        indaySelection.setMaximumSize(preferredSize);
        indaySelection.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        CheckDatePanel.add(indaySelection);
            
        for(int i=1;i<=31;i++)
            indaySelection.addItem(i);

        JLabel intimeLabel = new JLabel("Select Time:");
        intimeLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        intimeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        CheckDatePanel.add(intimeLabel);

        SpinnerDateModel dateModel = new SpinnerDateModel();
        JSpinner timeSpinner = new JSpinner(dateModel);
        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "HH:mm");
        timeSpinner.setEditor(timeEditor);
        timeSpinner.setMaximumSize(preferredSize);
        timeSpinner.setFont(new Font("Segoe UI", Font.BOLD, 12));
        CheckDatePanel.add(timeSpinner);
        JFormattedTextField textField = timeEditor.getTextField();
        textField.setEditable(false);

        CheckDatePanel.add(Box.createVerticalStrut(10));

        JLabel checkOut = new JLabel("Input Check-Out Date:");
        checkOut.setFont(new Font("Segoe UI", Font.BOLD, 16));
        checkOut.setAlignmentX(Component.CENTER_ALIGNMENT);
        CheckDatePanel.add(checkOut);

        CheckDatePanel.add(Box.createVerticalStrut(20));
    
        JLabel outdayLabel = new JLabel("Select Day:");
        outdayLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        outdayLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        CheckDatePanel.add(outdayLabel);

        JComboBox<Integer> outdaySelection = new JComboBox<>();
        outdaySelection.setMaximumSize(preferredSize);
        outdaySelection.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        CheckDatePanel.add(outdaySelection);
            
        for(int i=1;i<=31;i++)
            outdaySelection.addItem(i);

        JLabel outtimeLabel = new JLabel("Select Time:");
        outtimeLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        outtimeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        CheckDatePanel.add(outtimeLabel);

        SpinnerDateModel dateModel2 = new SpinnerDateModel();
        JSpinner timeSpinner2 = new JSpinner(dateModel2);
        JSpinner.DateEditor timeEditor2 = new JSpinner.DateEditor(timeSpinner2, "HH:mm");
        timeSpinner2.setEditor(timeEditor2);
        timeSpinner2.setMaximumSize(preferredSize);
        timeSpinner2.setFont(new Font("Segoe UI", Font.BOLD, 12));
        CheckDatePanel.add(timeSpinner2);
        JFormattedTextField textField2 = timeEditor2.getTextField();
        textField2.setEditable(false);

        CheckDatePanel.add(Box.createVerticalStrut(20));
        
        JButton confirmButton = new JButton("Confirm");
        confirmButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        confirmButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        CheckDatePanel.add(confirmButton);
        
        CheckDatePanel.add(Box.createVerticalStrut(10));

        AvailabilityPanel = new CustomPanel("Background.jpg");
        AvailabilityPanel.setLayout(new BoxLayout(AvailabilityPanel, BoxLayout.Y_AXIS));

        AvailabilityPanel.add(Box.createVerticalStrut(20));

        JLabel availability = new JLabel("Availability:");
        availability.setFont(new Font("Segoe UI", Font.BOLD, 16));
        availability.setAlignmentX(Component.CENTER_ALIGNMENT);
        AvailabilityPanel.add(availability);

        AvailabilityPanel.add(Box.createVerticalStrut(10));

        JTextArea textLogArea = new JTextArea();
        textLogArea.setEditable(false); 
        textLogArea.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        textLogArea.setMaximumSize(new Dimension(100, 10));
        AvailabilityPanel.add(textLogArea);

        JScrollPane scrollPane = new JScrollPane(textLogArea);    
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        AvailabilityPanel.add(scrollPane);

        JButton returnButton = new JButton("Return to Main Menu");
        returnButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        returnButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        AvailabilityPanel.add(returnButton);

        JLabel notify = new JLabel();
        notify.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        notify.setAlignmentX(Component.CENTER_ALIGNMENT);
        

        timeSpinner.addChangeListener(e -> {
            
            java.util.Date selectedTime = (java.util.Date) timeSpinner.getValue();

            // Use Calendar to get the hour, minute, and second
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(selectedTime);
            CheckIn2.setHour(calendar.get(Calendar.HOUR_OF_DAY));
            CheckIn2.setMinute(calendar.get(Calendar.MINUTE));
            
        });

        timeSpinner2.addChangeListener(e -> {
            
            java.util.Date selectedTime = (java.util.Date) timeSpinner.getValue();

            // Use Calendar to get the hour, minute, and second
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(selectedTime);
            CheckOut2.setHour(calendar.get(Calendar.HOUR_OF_DAY));
            CheckOut2.setMinute(calendar.get(Calendar.MINUTE));
            
        });

        confirmButton.addActionListener(e -> {
            
            CheckIn2.setDay((int)indaySelection.getSelectedItem());
            CheckOut2.setDay((int)outdaySelection.getSelectedItem());

            if (CheckOut2.getDay()<=CheckIn2.getDay())
            {
                notify.setText("Invalid, check-out date must be before check-in date");
                notify.setForeground(Color.RED);
                CheckDatePanel.add(notify);
                CheckDatePanel.revalidate();
                CheckDatePanel.repaint();
            }
            else
            {
                for(int i=0;i<hotel.get(hotelIndex).getRooms();i++)
                {
                    if(hotel.get(hotelIndex).getAllRooms()[i].isAvailable(CheckIn2, CheckOut2))
                        textLogArea.append("            Room "+hotel.get(hotelIndex).getAllRooms()[i].getRoomName()+" - Available\n");
                    else
                        textLogArea.append("            Room "+hotel.get(hotelIndex).getAllRooms()[i].getRoomName()+" - Booked\n");                                 
                }
                textLogArea.setCaretPosition(0);
                notify.setText("");
                Layout.show(MainPanel, "AvailabilityPanel");
            }
            
        });

        returnButton.addActionListener(e -> {
            textLogArea.setText("");
            Layout.show(MainPanel, "MenuPanel");
        });
    }

    private void BookingInfo(){

        BookingInfoPanel = new CustomPanel("Background.jpg");
        BookingInfoPanel.setLayout(new BoxLayout(BookingInfoPanel, BoxLayout.Y_AXIS));

        BookingInfoPanel.add(Box.createVerticalStrut(80));

        JLabel bookingSelect = new JLabel("Please Select a Reservation:");
        bookingSelect.setAlignmentX(Component.CENTER_ALIGNMENT);
        bookingSelect.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        BookingInfoPanel.add(bookingSelect);
    
        BookingInfoPanel.add(Box.createVerticalStrut(20));
    
        bookingSelection = new JComboBox<>();
        Dimension preferredSize = new Dimension(300, 20);
        bookingSelection.setMaximumSize(preferredSize);
        bookingSelection.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        BookingInfoPanel.add(bookingSelection);
    
        BookingInfoPanel.add(Box.createVerticalStrut(20));
    
        JButton confirmButton = new JButton("Confirm");
        confirmButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        confirmButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        BookingInfoPanel.add(confirmButton);

        MoreBookingInfo = new CustomPanel("Background.jpg");
        MoreBookingInfo.setLayout(new BoxLayout( MoreBookingInfo, BoxLayout.Y_AXIS));

        MoreBookingInfo.add(Box.createVerticalStrut(20));

        JLabel guestName = new JLabel();
        guestName.setAlignmentX(Component.CENTER_ALIGNMENT);
        guestName.setFont(new Font("Segoe UI", Font.BOLD, 16));
        MoreBookingInfo.add(guestName);

        JLabel roomName = new JLabel();
        roomName.setAlignmentX(Component.CENTER_ALIGNMENT);
        roomName.setFont(new Font("Segoe UI", Font.BOLD, 16));
        MoreBookingInfo.add(roomName);

        JLabel bookingDate = new JLabel();
        bookingDate.setAlignmentX(Component.CENTER_ALIGNMENT);
        bookingDate.setFont(new Font("Segoe UI", Font.BOLD, 14));
        MoreBookingInfo.add(bookingDate);

        JTextArea textLogArea = new JTextArea();
        textLogArea.setEditable(false); 
        textLogArea.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        textLogArea.setMaximumSize(new Dimension(100, 10));
        MoreBookingInfo.add(textLogArea);
        

        JScrollPane scrollPane = new JScrollPane(textLogArea);    
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        MoreBookingInfo.add(scrollPane);

        JButton returnButton = new JButton("Return to Main Menu");
        returnButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        returnButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        MoreBookingInfo.add(returnButton);

        confirmButton.addActionListener(e -> {

            reserveIndex = bookingSelection.getSelectedIndex();

            guestName.setText("Guest Name: "+hotel.get(hotelIndex).getReservations().get(reserveIndex).getGuestName());
            roomName.setText("Room Name: Room "+hotel.get(hotelIndex).getReservations().get(reserveIndex).getRoomReserved());


            int inHour = hotel.get(hotelIndex).getReservations().get(reserveIndex).getCheckInDate().getHour();
            int outHour = hotel.get(hotelIndex).getReservations().get(reserveIndex).getCheckOutDate().getHour();
        
            if(inHour > 12)
                inHour -= 12;
            else if (inHour == 0)
                inHour = 12;

            if(outHour > 12)
                outHour -= 12;
            else if (outHour == 0)
                outHour = 12;
            

            String checkinDate = " Booked on Day "+hotel.get(hotelIndex).getReservations().get(reserveIndex).getCheckInDate().getDay()+", "+inHour+
                              ":"+String.format("%02d",hotel.get(hotelIndex).getReservations().get(reserveIndex).getCheckInDate().getMinute());
            if(hotel.get(hotelIndex).getReservations().get(reserveIndex).getCheckInDate().getHour() > 12)
                checkinDate += " PM";
            else
                checkinDate += " AM";

            String checkoutDate =" to Day "+hotel.get(hotelIndex).getReservations().get(reserveIndex).getCheckOutDate().getDay()+", "+outHour+
                ":"+String.format("%02d",hotel.get(hotelIndex).getReservations().get(reserveIndex).getCheckOutDate().getMinute());
            if(hotel.get(hotelIndex).getReservations().get(reserveIndex).getCheckOutDate().getHour() > 12)
                checkoutDate += " PM";
            else
                checkoutDate += " AM";

            bookingDate.setText(checkinDate + checkoutDate);

            int i,d = -1;
            int index = hotel.get(hotelIndex).getReservations().get(reserveIndex).getCheckInDate().getDay() - 2;
            int night = hotel.get(hotelIndex).getReservations().get(reserveIndex).getNights();
            float discount = hotel.get(hotelIndex).getReservations().get(reserveIndex).getDiscount();
            float totalPrice = hotel.get(hotelIndex).getReservations().get(reserveIndex).getTotalPrice();
            for(i=0;i<hotel.get(hotelIndex).getRooms();i++)
            {
                if(hotel.get(hotelIndex).getReservations().get(reserveIndex).getRoomReserved().equals(hotel.get(hotelIndex).getAllRooms()[i].getRoomName()))
                    d=i;
                    
            }

            textLogArea.append("   PRICE PER NIGHT BREAKDOWN\n");
            
            if (night!=hotel.get(hotelIndex).getReservations().get(reserveIndex).getCheckOutDate().getDay()
                      - hotel.get(hotelIndex).getReservations().get(reserveIndex).getCheckInDate().getDay())
            {
                if (hotel.get(hotelIndex).getAllRooms()[d] instanceof DeluxeRoom)
                {
                    for(i = 1; i <= night+1; i++) {
                        if(i==1)
                        {
                            textLogArea.append("Night#"+String.format("%2d",i));
                            textLogArea.append("            FREE\n");
                        }
                        else
                        {
                            textLogArea.append("Night#"+String.format("%2d",i));
                            textLogArea.append("            "+String.format("%.2f",hotel.get(hotelIndex).getRoomPrice()*1.2*hotel.get(hotelIndex).getDayPriceModifications()[index+i])+"\n");
                        }
                    }

                }
                else if (hotel.get(hotelIndex).getAllRooms()[d] instanceof ExclusiveRoom)
                {
                    for(i = 1; i <= night+1; i++) {
                        if(i==1)
                        {
                            textLogArea.append("Night#"+String.format("%2d",i));
                            textLogArea.append("            FREE\n");
                        }
                        else
                        {
                            textLogArea.append("Night#"+String.format("%2d",i));
                            textLogArea.append("            "+String.format("%.2f",hotel.get(hotelIndex).getRoomPrice()*1.35*hotel.get(hotelIndex).getDayPriceModifications()[index+i])+"\n");
                        }
                    }

                }
                else
                {
                    for(i = 1; i <= night+1; i++) {
                        if(i==1)
                        {
                            textLogArea.append("Night#"+String.format("%2d",i));
                            textLogArea.append("            FREE\n");
                        }
                        else
                        {
                            textLogArea.append("Night#"+String.format("%2d",i));
                            textLogArea.append("            "+String.format("%.2f",hotel.get(hotelIndex).getRoomPrice()*hotel.get(hotelIndex).getDayPriceModifications()[index+i])+"\n");
                        }
                    }
                }
            }
            else
            {
                if (hotel.get(hotelIndex).getAllRooms()[d] instanceof DeluxeRoom)
                {
                    for(i = 1; i <= night; i++) {
                        textLogArea.append("Night#"+String.format("%2d",i)); 
                        textLogArea.append("            "+String.format("%.2f",hotel.get(hotelIndex).getRoomPrice()*1.2*hotel.get(hotelIndex).getDayPriceModifications()[index+i])+"\n");
                    }

                }
                else if (hotel.get(hotelIndex).getAllRooms()[d] instanceof ExclusiveRoom)
                {
                    for(i = 1; i <= night; i++) {
                        textLogArea.append("Night#"+String.format("%2d",i));
                        textLogArea.append("            "+String.format("%.2f",hotel.get(hotelIndex).getRoomPrice()*1.35*hotel.get(hotelIndex).getDayPriceModifications()[index+i])+"\n");
                    }

                }
                else
                {
                    for(i = 1; i <= night; i++) {
                        textLogArea.append("Night#"+String.format("%2d",i));
                        textLogArea.append("            "+String.format("%.2f",hotel.get(hotelIndex).getRoomPrice()*hotel.get(hotelIndex).getDayPriceModifications()[index+i])+"\n");
                    }
                }
            }
            if(discount<1)
                textLogArea.append("Discount           -"+String.format("%.2f",totalPrice/discount*(1-discount))+"\n");

            textLogArea.append("_________________________________________\n");
            textLogArea.append("Total:               "+String.format("%.2f",totalPrice));
        

            textLogArea.setCaretPosition(0);
            Layout.show(MainPanel, "MoreBookingInfo");
        });

        returnButton.addActionListener(e -> {
            textLogArea.setText("");
            Layout.show(MainPanel, "MenuPanel");
        });

    }

    private void ModifyHotel(){

        ModifyHotelPanel = new CustomPanel("Background.jpg");
        ModifyHotelPanel.setLayout(new BoxLayout(ModifyHotelPanel, BoxLayout.Y_AXIS));

        ModifyHotelPanel.add(Box.createVerticalStrut(80));

        JLabel hotelSelect = new JLabel("Please Select a Hotel:");
        hotelSelect.setAlignmentX(Component.CENTER_ALIGNMENT);
        hotelSelect.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        ModifyHotelPanel.add(hotelSelect);

        ModifyHotelPanel.add(Box.createVerticalStrut(20));

        hotelSelection3 = new JComboBox<>();
        Dimension preferredSize = new Dimension(300, 20);
        hotelSelection3.setMaximumSize(preferredSize);
        hotelSelection3.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        ModifyHotelPanel.add(hotelSelection3);

        ModifyHotelPanel.add(Box.createVerticalStrut(20));

        JButton confirmButton = new JButton("Confirm");
        confirmButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        confirmButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        ModifyHotelPanel.add(confirmButton);

        ModifyHotelPanel.add(Box.createVerticalStrut(20));

        confirmButton.addActionListener(e -> {
            hotelIndex = hotelSelection3.getSelectedIndex();
            Layout.show(MainPanel, "ManageHotelPanel");
        });
    }

    private void ManageHotel(){
        ManageHotelPanel = new CustomPanel("Background.jpg");
        ManageHotelPanel.setLayout(new BoxLayout(ManageHotelPanel, BoxLayout.Y_AXIS));

        ManageHotelPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        ManageHotelPanel.add(Box.createVerticalStrut(10));

        JLabel MainLbl1 = new JLabel("Select an Option:");
        MainLbl1.setAlignmentX(Component.CENTER_ALIGNMENT);
        MainLbl1.setFont(new Font("Segoe UI", Font.BOLD, 20));
        ManageHotelPanel.add(MainLbl1);

        ManageHotelPanel.add(Box.createVerticalStrut(15));

        JButton Opt1 = new JButton("Change Name of Hotel");
        Opt1.setAlignmentX(Component.CENTER_ALIGNMENT);
        Opt1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        Opt1.setMaximumSize(new Dimension(160, 25));
        ManageHotelPanel.add(Opt1);

        ManageHotelPanel.add(Box.createVerticalStrut(15));

        JButton Opt2 = new JButton("Add Room");
        Opt2.setAlignmentX(Component.CENTER_ALIGNMENT);
        Opt2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        Opt2.setMaximumSize(new Dimension(160, 25));
        ManageHotelPanel.add(Opt2);

        ManageHotelPanel.add(Box.createVerticalStrut(15));

        JButton Opt3 = new JButton("Remove Room");
        Opt3.setAlignmentX(Component.CENTER_ALIGNMENT);
        Opt3.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        Opt3.setMaximumSize(new Dimension(160, 25));
        ManageHotelPanel.add(Opt3);

        ManageHotelPanel.add(Box.createVerticalStrut(15));

        JButton Opt4 = new JButton("Update Room Pricing");
        Opt4.setAlignmentX(Component.CENTER_ALIGNMENT);
        Opt4.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        Opt4.setMaximumSize(new Dimension(160, 25));
        ManageHotelPanel.add(Opt4);

        ManageHotelPanel.add(Box.createVerticalStrut(15));

        JButton Opt5 = new JButton("Remove Reservation");
        Opt5.setAlignmentX(Component.CENTER_ALIGNMENT);
        Opt5.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        Opt5.setMaximumSize(new Dimension(160, 25));
        ManageHotelPanel.add(Opt5);

        ManageHotelPanel.add(Box.createVerticalStrut(15));

        JButton Opt6 = new JButton("Remove Hotel");
        Opt6.setAlignmentX(Component.CENTER_ALIGNMENT);
        Opt6.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        Opt6.setMaximumSize(new Dimension(160, 25));
        ManageHotelPanel.add(Opt6);

        ManageHotelPanel.add(Box.createVerticalStrut(15));

        JButton Opt7 = new JButton("Date Price Modifier");
        Opt7.setAlignmentX(Component.CENTER_ALIGNMENT);
        Opt7.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        Opt7.setMaximumSize(new Dimension(160, 25));
        ManageHotelPanel.add(Opt7);

        ManageHotelPanel.add(Box.createVerticalStrut(10));
        
        JLabel notify = new JLabel();
        notify.setAlignmentX(Component.CENTER_ALIGNMENT);
        notify.setFont(new Font("Segoe UI", Font.PLAIN, 12));

        Opt1.addActionListener(e -> {
            notify.setText("");
            Layout.show(MainPanel, "ChangeNamePanel");
        });

        Opt2.addActionListener(e -> {
            if (hotel.get(hotelIndex).getRooms()==50)
            {
                notify.setText("Maximum amount of rooms reached");
                notify.setForeground(Color.RED);
                ManageHotelPanel.add(notify);
                ManageHotelPanel.revalidate();
                ManageHotelPanel.repaint();
            }
            else
            {
                notify.setText("");
                Layout.show(MainPanel, "AddRoomAgain");
            }  
        });
        
        Opt3.addActionListener(e -> {
            if (hotel.get(hotelIndex).getRooms()==0)
            {
                notify.setText("Hotel has no rooms at the moment");
                notify.setForeground(Color.RED);
                ManageHotelPanel.add(notify);
                ManageHotelPanel.revalidate();
                ManageHotelPanel.repaint();
            }
            else
            {
                notify.setText("");
                roomSelection3.removeAllItems();
                for(int i=0;i<hotel.get(hotelIndex).getRooms();i++)
                {
                    roomSelection3.addItem("Room "+hotel.get(hotelIndex).getAllRooms()[i].getRoomName());
                }
                Layout.show(MainPanel, "RemoveRoomPanel");
            }
                
        });

        Opt4.addActionListener(e -> {
            notify.setText("");
            Layout.show(MainPanel, "UpdatePricePanel");
        });

        Opt5.addActionListener(e -> {
            if (hotel.get(hotelIndex).getReservations().isEmpty())
            {
                notify.setText("Hotel has no reservations at the moment");
                notify.setForeground(Color.RED);
                ManageHotelPanel.add(notify);
                ManageHotelPanel.revalidate();
                ManageHotelPanel.repaint();
            }
            else
            {
                notify.setText("");
                bookingSelection2.removeAllItems();
                for(int i=0;i<hotel.get(hotelIndex).getReservations().size();i++)
                {
                    bookingSelection2.addItem("Room "+hotel.get(hotelIndex).getReservations().get(i).getRoomReserved()+
                    " reservation "+ "by "+hotel.get(hotelIndex).getReservations().get(i).getGuestName());
                                            
                }
                Layout.show(MainPanel, "RemoveBooking");
            }
        });

        Opt6.addActionListener(e -> {
            notify.setText("");
            if(hotel.get(hotelIndex).getReservations().isEmpty())
                hotel.remove(hotelIndex);
            else
                Layout.show(MainPanel, "RemoveHotelPanel");
            Layout.show(MainPanel, "MenuPanel");
        });

        Opt7.addActionListener(e -> {
            notify.setText("");
            Layout.show(MainPanel, "SelectDayPanel");
        });
    }

    

    private void ChangeName(){
        ChangeNamePanel = new CustomPanel("Background.jpg");
        ChangeNamePanel.setLayout(new BoxLayout(ChangeNamePanel, BoxLayout.Y_AXIS));

        ChangeNamePanel.add(Box.createVerticalStrut(80));

        JLabel change = new JLabel("Change hotel name:");
        change.setAlignmentX(Component.CENTER_ALIGNMENT);
        change.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        ChangeNamePanel.add(change);
       
        ChangeNamePanel.add(Box.createVerticalStrut(20));

        JTextField textField = new JTextField(30); 
        Dimension preferredSize = new Dimension(300, 20);
        textField.setAlignmentX(Component.CENTER_ALIGNMENT);
        textField.setMaximumSize(preferredSize);
        ChangeNamePanel.add(textField);

        ChangeNamePanel.add(Box.createVerticalStrut(20));

        JButton confirmButton = new JButton("Confirm");
        confirmButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        confirmButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        ChangeNamePanel.add(confirmButton);

        ChangeNamePanel.add(Box.createVerticalStrut(20));
        JLabel notify = new JLabel(); 
        notify.setAlignmentX(CENTER_ALIGNMENT);
        notify.setFont(new Font("Segoe UI", Font.PLAIN, 12));

        confirmButton.addActionListener(e -> {

            String inputText = textField.getText();
            boolean valid = true;
            int i=0;

            if (inputText.equals(""))
            {
                notify.setText("Hotel name cannot be blank");
                notify.setForeground(Color.RED);
                ChangeNamePanel.add(notify);
                ChangeNamePanel.revalidate();
                ChangeNamePanel.repaint();
                valid = false;
            }
            else if (inputText.equals(hotel.get(hotelIndex).getName()))
            {
                notify.setText("Hotel name must be different");
                notify.setForeground(Color.RED);
                ChangeNamePanel.add(notify);
                ChangeNamePanel.revalidate();
                ChangeNamePanel.repaint();
                valid = false;
            }
			else if (!hotel.isEmpty())
				while (i<hotel.size()) // Checks if hotel name already exists
				{
					if (hotel.get(i).getName().equals(inputText)) // Loops until hotel name is unique
					{   
                       notify.setText(inputText + " already in exists");
                        notify.setForeground(Color.RED);
						ChangeNamePanel.add(notify);
						ChangeNamePanel.revalidate();
                        ChangeNamePanel.repaint();
                        valid = false;
					}
						i++;
				}
            if (valid)
            {
				hotel.get(hotelIndex).changeName(inputText);
                notify.setText("");
                Layout.show(MainPanel, "MenuPanel");
                
                
            }
            textField.setText("");
            
            
        });
    }

    private void SelectRoomAgain(){
        AddRoomAgain = new CustomPanel("Background.jpg");
        AddRoomAgain.setLayout(new BoxLayout(AddRoomAgain, BoxLayout.Y_AXIS));

        AddRoomAgain.add(Box.createVerticalStrut(100));
        JLabel selectType = new JLabel("Add what type of room?");
        selectType.setAlignmentX(Component.CENTER_ALIGNMENT);
        selectType.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        AddRoomAgain.add(selectType);

        CustomPanel RoomTypeButton = new CustomPanel("Background.jpg");
        RoomTypeButton.setLayout(new FlowLayout());

        JButton standardButton = new JButton("Standard");
        standardButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        standardButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        RoomTypeButton.add(standardButton);

        JButton deluxeButton = new JButton("Deluxe");
        deluxeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        deluxeButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        RoomTypeButton.add(deluxeButton);

        JButton exclusiveButton = new JButton("Exclusive");
        exclusiveButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exclusiveButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        RoomTypeButton.add(exclusiveButton);

        AddRoomAgain.add(RoomTypeButton);

        standardButton.addActionListener(e -> {
            hotel.get(hotelIndex).addRoom(1);
            Layout.show(MainPanel, "AddMoreRoom");
        });

        deluxeButton.addActionListener(e -> {
            hotel.get(hotelIndex).addRoom(2);
            Layout.show(MainPanel, "AddMoreRoom");
        });

        exclusiveButton.addActionListener(e -> {
            hotel.get(hotelIndex).addRoom(3);
            Layout.show(MainPanel, "AddMoreRoom");
        });
    }

    private void AddMore(){
        AddMoreRoom = new CustomPanel("Background.jpg");
        AddMoreRoom.setLayout(new BoxLayout(AddMoreRoom, BoxLayout.Y_AXIS));

        AddMoreRoom.add(Box.createVerticalStrut(120));
        JLabel addRoom = new JLabel("Add more rooms?");
        addRoom.setAlignmentX(Component.CENTER_ALIGNMENT);
        addRoom.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        AddMoreRoom.add(addRoom);

        CustomPanel AddMoreRoomSouth = new CustomPanel("Background.jpg");
        AddMoreRoomSouth.setLayout(new FlowLayout());
        

        JButton yesButton = new JButton("Yes");
        yesButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        yesButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        AddMoreRoomSouth.add(yesButton);

        JButton noButton = new JButton("No");
        noButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        noButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        AddMoreRoomSouth.add(noButton);

        JLabel notify = new JLabel();
        notify.setAlignmentX(CENTER_ALIGNMENT);
        notify.setFont(new Font("Segoe UI", Font.PLAIN, 12));

        AddMoreRoom.add(AddMoreRoomSouth);

        yesButton.addActionListener(e -> {

            if (hotel.get(hotelIndex).getRooms()==50)
            {
                notify.setText("            Maximum amount of rooms reached");
                notify.setForeground(Color.RED);
				AddMoreRoomSouth.add(notify);
				AddMoreRoomSouth.revalidate();
                AddMoreRoomSouth.repaint();
            }
            else
            Layout.show(MainPanel, "AddRoomAgain");
        });
 
        noButton.addActionListener(e -> {
            notify.setText("");
            Layout.show(MainPanel, "MenuPanel");

        });
    }
    
    private void RemoveRoom(){

        RemoveRoomPanel = new CustomPanel("Background.jpg");
        RemoveRoomPanel.setLayout(new BoxLayout(RemoveRoomPanel, BoxLayout.Y_AXIS));

        RemoveRoomPanel.add(Box.createVerticalStrut(80));

        JLabel roomSelect = new JLabel("Please Remove a Room:");
        roomSelect.setAlignmentX(Component.CENTER_ALIGNMENT);
        roomSelect.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        RemoveRoomPanel.add(roomSelect);

        RemoveRoomPanel.add(Box.createVerticalStrut(20));

        roomSelection3 = new JComboBox<>();
        Dimension preferredSize = new Dimension(300, 20);
        roomSelection3.setMaximumSize(preferredSize);
        roomSelection3.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        RemoveRoomPanel.add(roomSelection3);

        RemoveRoomPanel.add(Box.createVerticalStrut(20));

        JButton confirmButton = new JButton("Confirm");
        confirmButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        confirmButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        RemoveRoomPanel.add(confirmButton);

        JLabel notify = new JLabel();
        notify.setAlignmentX(CENTER_ALIGNMENT);
        notify.setFont(new Font("Segoe UI", Font.PLAIN, 12));

        confirmButton.addActionListener(e -> {
            roomIndex = roomSelection3.getSelectedIndex();
            String roomName = hotel.get(hotelIndex).getAllRooms()[roomIndex].getRoomName();
            if (!hotel.get(hotelIndex).removeRoom(roomName))
            {
                notify.setText("Room "+roomName+" currently has reservations");
                notify.setForeground(Color.RED);
				RemoveRoomPanel.add(notify);
				RemoveRoomPanel.revalidate();
                RemoveRoomPanel.repaint();
            }
            else
            {
                notify.setText("");
                Layout.show(MainPanel, "MenuPanel");
            }
        });

    }

    private void UpdatePricing(){

        UpdatePricePanel = new CustomPanel("Background.jpg");
        UpdatePricePanel.setLayout(new BoxLayout(UpdatePricePanel, BoxLayout.Y_AXIS));

        UpdatePricePanel.add(Box.createVerticalStrut(80));

        JLabel setPrice = new JLabel("Set Room Price:");
        setPrice.setAlignmentX(Component.CENTER_ALIGNMENT);
        setPrice.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        UpdatePricePanel.add(setPrice);
       
        UpdatePricePanel.add(Box.createVerticalStrut(20));

        JTextField textField = new JTextField(30); 
        Dimension preferredSize = new Dimension(200, 20);
        textField.setAlignmentX(Component.CENTER_ALIGNMENT);
        textField.setMaximumSize(preferredSize);
        UpdatePricePanel.add(textField);

        UpdatePricePanel.add(Box.createVerticalStrut(20));

        JButton confirmButton = new JButton("Confirm");
        confirmButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        confirmButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        UpdatePricePanel.add(confirmButton);


        JLabel notify = new JLabel();
        notify.setAlignmentX(CENTER_ALIGNMENT);
        notify.setFont(new Font("Segoe UI", Font.PLAIN, 12));


        confirmButton.addActionListener(e -> {

            try {
				float num = Float.parseFloat(textField.getText());
                if (num < 100)
                {
                    notify.setText("Set price not enough, try a higher number");
                    notify.setForeground(Color.RED);
                    UpdatePricePanel.add(notify);
                    UpdatePricePanel.revalidate();
                    UpdatePricePanel.repaint();
                }
                else
                {
                    notify.setText("");
                    textField.setText(""); 
                    hotel.get(hotelIndex).setRoomPrice(num);
                    Layout.show(MainPanel, "MenuPanel");
                }
			} catch (Exception ex) {
				notify.setText("           Invalid input, Please try again");
                notify.setForeground(Color.RED);
				UpdatePricePanel.add(notify);
				UpdatePricePanel.revalidate();
                UpdatePricePanel.repaint();
			}
        });
    }

    private void RemoveReservation(){
        RemoveBooking = new CustomPanel("Background.jpg");
        RemoveBooking.setLayout(new BoxLayout(RemoveBooking, BoxLayout.Y_AXIS));

        RemoveBooking.add(Box.createVerticalStrut(80));

        JLabel bookingSelect = new JLabel("Select a Reservation to Remove:");
        bookingSelect.setAlignmentX(Component.CENTER_ALIGNMENT);
        bookingSelect.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        RemoveBooking.add(bookingSelect);
    
        RemoveBooking.add(Box.createVerticalStrut(20));
    
        bookingSelection2 = new JComboBox<>();
        Dimension preferredSize = new Dimension(300, 20);
        bookingSelection2.setMaximumSize(preferredSize);
        bookingSelection2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        RemoveBooking.add(bookingSelection2);
    
        RemoveBooking.add(Box.createVerticalStrut(20));
    
        JButton confirmButton = new JButton("Confirm");
        confirmButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        confirmButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        RemoveBooking.add(confirmButton);

        confirmButton.addActionListener(e -> {

            reserveIndex = bookingSelection2.getSelectedIndex();
            String name = hotel.get(hotelIndex).getReservations().get(reserveIndex).getGuestName();
            hotel.get(hotelIndex).getReservations().remove(reserveIndex);
            for (int d=0;d<hotel.get(hotelIndex).getRooms();d++)
                for(int f=0;f<hotel.get(hotelIndex).getAllRooms()[d].getRoomReservations().size();f++)
                    if (name.equals(hotel.get(hotelIndex).getAllRooms()[d].getRoomReservations().get(f).getGuestName()))
                    {
                        hotel.get(hotelIndex).getAllRooms()[d].getRoomReservations().remove(f);
                    }
            Layout.show(MainPanel, "MenuPanel");
        });
    }

    private void RemoveHotel(){
           
        RemoveHotelPanel = new CustomPanel("Background.jpg");
        RemoveHotelPanel.setLayout(new BoxLayout(RemoveHotelPanel, BoxLayout.Y_AXIS));

        RemoveHotelPanel.add(Box.createVerticalStrut(120));
        JLabel addRoom = new JLabel("Hotel currently has reservations, proceed anyway?");
        addRoom.setAlignmentX(Component.CENTER_ALIGNMENT);
        addRoom.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        RemoveHotelPanel.add(addRoom);

        CustomPanel RemoveHotelPanelSouth = new CustomPanel("Background.jpg");
        RemoveHotelPanelSouth.setLayout(new FlowLayout());
        
        JButton yesButton = new JButton("Yes");
        yesButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        yesButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        RemoveHotelPanelSouth.add(yesButton);

        JButton noButton = new JButton("No");
        noButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        noButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        RemoveHotelPanelSouth.add(noButton);

        RemoveHotelPanel.add(RemoveHotelPanelSouth);

        yesButton.addActionListener(e -> {
            hotel.remove(hotelIndex);
            Layout.show(MainPanel, "MenuPanel");
        });

        noButton.addActionListener(e -> {
            Layout.show(MainPanel, "MenuPanel");
        });

    }

    private void SelectDay(){  
        SelectDayPanel = new CustomPanel("Background.jpg");
        SelectDayPanel.setLayout(new BoxLayout(SelectDayPanel, BoxLayout.Y_AXIS));

        SelectDayPanel.add(Box.createVerticalStrut(80));

        JLabel daySelect = new JLabel("Select a Day to Modify:");
        daySelect.setAlignmentX(Component.CENTER_ALIGNMENT);
        daySelect.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        SelectDayPanel.add(daySelect);
    
        SelectDayPanel.add(Box.createVerticalStrut(20));
    
        JComboBox<Integer> daySelection = new JComboBox<>();
        Dimension preferredSize = new Dimension(55, 20);
        daySelection.setMaximumSize(preferredSize);
        daySelection.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        SelectDayPanel.add(daySelection);
    
        for(int i=1;i<31;i++)
            daySelection.addItem(i);

        SelectDayPanel.add(Box.createVerticalStrut(20));
    
        JButton confirmButton = new JButton("Confirm");
        confirmButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        confirmButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        SelectDayPanel.add(confirmButton);

        confirmButton.addActionListener(e -> {
            dayIndex = (int)daySelection.getSelectedItem()-1;
            Layout.show(MainPanel, "ModifyDayPanel");
        });
    }
    
    private void ModifyDay(){  
        ModifyDayPanel = new CustomPanel("Background.jpg");
        ModifyDayPanel.setLayout(new BoxLayout(ModifyDayPanel, BoxLayout.Y_AXIS));

        ModifyDayPanel.add(Box.createVerticalStrut(80));

        JLabel daySelect = new JLabel("Select Percentage:");
        daySelect.setAlignmentX(Component.CENTER_ALIGNMENT);
        daySelect.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        ModifyDayPanel.add(daySelect);
    
        ModifyDayPanel.add(Box.createVerticalStrut(20));
    
        SpinnerNumberModel numberModel = new SpinnerNumberModel(100, 50, 150, 1);
        JSpinner percentSelection = new JSpinner(numberModel);
        Dimension preferredSize = new Dimension(55, 20);
        percentSelection.setMaximumSize(preferredSize);
        percentSelection.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        JSpinner.DefaultEditor editor = (JSpinner.DefaultEditor) percentSelection.getEditor();
        JFormattedTextField textField = editor.getTextField();
        textField.setEditable(false);
        ModifyDayPanel.add(percentSelection);
    
        ModifyDayPanel.add(Box.createVerticalStrut(20));
    
        JButton confirmButton = new JButton("Confirm");
        confirmButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        confirmButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        ModifyDayPanel.add(confirmButton);

        confirmButton.addActionListener(e -> {
            int percentage = (Integer)percentSelection.getValue();
            if(hotel.get(hotelIndex).modifyDayPrice(dayIndex,percentage))
                Layout.show(MainPanel, "MenuPanel");
        });
    }

    /**
     * The CustomPanel extends JPanel to display a background image. 
     * 
     * @version 1.0
     * @since 2024-07-31
     */
    class CustomPanel extends JPanel { // CustomPanel class for panels to be set with a background image
        private BufferedImage backgroundImage;

        public CustomPanel(String imagePath) {
            try {
                backgroundImage = ImageIO.read(new File(imagePath)); // Reads image path
            } catch (IOException e) {
                e.printStackTrace(); // Catches exceptions
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g); // Paints the panel background
            if (backgroundImage != null) { // Checks if image is null
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }
}
