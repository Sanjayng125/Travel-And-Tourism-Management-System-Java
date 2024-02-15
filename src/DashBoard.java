import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DashBoard extends JFrame implements ActionListener {

    JButton addPersonalDetails,viewPersonalDetails, updatePersonalDetails, deletePersonalDetails, checkPackages, bookPackage, viewPackage, viewHotels, bookHotels, viewBookedHotel, destinations, payments, reviews, logout;
    String userName;
    DashBoard(String userName){
        this.userName = userName;

    //setBounds(0,0,1300,800);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(100,160,240));
        p1.setBounds(0,0,1300,65);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/icon.png"));
        Image i2 = i1.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(5,5,50,50);
        p1.add(icon);

        JLabel dashboard = new JLabel("Dashboard");
        dashboard.setFont(new Font("Railway",Font.BOLD, 24));
        dashboard.setForeground(new Color(100,30,22));
        dashboard.setBounds(70,20,160,20);
        p1.add(dashboard);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(100,160,240));
        p2.setBounds(0,65,252,900);
        add(p2);

        addPersonalDetails = new JButton("Add Personal Details");
        addPersonalDetails.setFont(new Font("Railway",Font.BOLD, 20));
        addPersonalDetails.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        addPersonalDetails.setBounds(0,0,250,40);
        addPersonalDetails.setBackground(new Color(100,160,240));
        addPersonalDetails.setForeground(new Color(100,30,22));
        addPersonalDetails.setMargin(new Insets(0,0,0,100));
        addPersonalDetails.addActionListener(this);
        p2.add(addPersonalDetails);

        updatePersonalDetails = new JButton("Update Personal Details");
        updatePersonalDetails.setFont(new Font("Railway",Font.BOLD, 20));
        updatePersonalDetails.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        updatePersonalDetails.setBounds(0,40,250,40);
        updatePersonalDetails.setBackground(new Color(100,160,240));
        updatePersonalDetails.setForeground(new Color(100,30,22));
        updatePersonalDetails.setMargin(new Insets(0,0,0,100));
        updatePersonalDetails.addActionListener(this);
        p2.add(updatePersonalDetails);

        viewPersonalDetails = new JButton("View Personal Details");
        viewPersonalDetails.setFont(new Font("Railway",Font.BOLD, 20));
        viewPersonalDetails.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        viewPersonalDetails.setBounds(0,80,250,40);
        viewPersonalDetails.setBackground(new Color(100,160,240));
        viewPersonalDetails.setForeground(new Color(100,30,22));
        viewPersonalDetails.setMargin(new Insets(0,0,0,100));
        viewPersonalDetails.addActionListener(this);
        p2.add(viewPersonalDetails);

        deletePersonalDetails = new JButton("Delete Personal Details");
        deletePersonalDetails.setFont(new Font("Railway",Font.BOLD, 20));
        deletePersonalDetails.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        deletePersonalDetails.setBounds(0,120,250,40);
        deletePersonalDetails.setBackground(new Color(100,160,240));
        deletePersonalDetails.setForeground(new Color(100,30,22));
        deletePersonalDetails.setMargin(new Insets(0,0,0,100));
        deletePersonalDetails.addActionListener(this);
        p2.add(deletePersonalDetails);

        checkPackages = new JButton("Check Packages");
        checkPackages.setFont(new Font("Railway",Font.BOLD, 20));
        checkPackages.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        checkPackages.setBounds(0,160,250,40);
        checkPackages.setBackground(new Color(100,160,240));
        checkPackages.setForeground(new Color(100,30,22));
        checkPackages.setMargin(new Insets(0,0,0,100));
        checkPackages.addActionListener(this);
        p2.add(checkPackages);

        bookPackage = new JButton("Book Package");
        bookPackage.setFont(new Font("Railway",Font.BOLD, 20));
        bookPackage.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        bookPackage.setBounds(0,200,250,40);
        bookPackage.setBackground(new Color(100,160,240));
        bookPackage.setForeground(new Color(100,30,22));
        bookPackage.setMargin(new Insets(0,0,0,100));
        bookPackage.addActionListener(this);
        p2.add(bookPackage);

        viewPackage = new JButton("View Package");
        viewPackage.setFont(new Font("Railway",Font.BOLD, 20));
        viewPackage.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        viewPackage.setBounds(0,240,250,40);
        viewPackage.setBackground(new Color(100,160,240));
        viewPackage.setForeground(new Color(100,30,22));
        viewPackage.setMargin(new Insets(0,0,0,100));
        viewPackage.addActionListener(this);
        p2.add(viewPackage);

        viewHotels = new JButton("View Hotels");
        viewHotels.setFont(new Font("Railway",Font.BOLD, 20));
        viewHotels.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        viewHotels.setBounds(0,280,250,40);
        viewHotels.setBackground(new Color(100,160,240));
        viewHotels.setForeground(new Color(100,30,22));
        viewHotels.setMargin(new Insets(0,0,0,100));
        viewHotels.addActionListener(this);
        p2.add(viewHotels);

        bookHotels = new JButton("Book Hotels");
        bookHotels.setFont(new Font("Railway",Font.BOLD, 20));
        bookHotels.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        bookHotels.setBounds(0,320,250,40);
        bookHotels.setBackground(new Color(100,160,240));
        bookHotels.setForeground(new Color(100,30,22));
        bookHotels.setMargin(new Insets(0,0,0,100));
        bookHotels.addActionListener(this);
        p2.add(bookHotels);

        viewBookedHotel = new JButton("View Booked Hotel");
        viewBookedHotel.setFont(new Font("Railway",Font.BOLD, 20));
        viewBookedHotel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        viewBookedHotel.setBounds(0,360,250,40);
        viewBookedHotel.setBackground(new Color(100,160,240));
        viewBookedHotel.setForeground(new Color(100,30,22));
        viewBookedHotel.setMargin(new Insets(0,0,0,100));
        viewBookedHotel.addActionListener(this);
        p2.add(viewBookedHotel);

        destinations = new JButton("Destinations");
        destinations.setFont(new Font("Railway",Font.BOLD, 20));
        destinations.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        destinations.setBounds(0,400,250,40);
        destinations.setBackground(new Color(100,160,240));
        destinations.setForeground(new Color(100,30,22));
        destinations.setMargin(new Insets(0,0,0,100));
        destinations.addActionListener(this);
        p2.add(destinations);

        payments = new JButton("Payments");
        payments.setFont(new Font("Railway",Font.BOLD, 20));
        payments.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        payments.setBounds(0,440,250,40);
        payments.setBackground(new Color(100,160,240));
        payments.setForeground(new Color(100,30,22));
        payments.setMargin(new Insets(0,0,0,100));
        payments.addActionListener(this);
        p2.add(payments);

        reviews = new JButton("Reviews");
        reviews.setFont(new Font("Railway",Font.BOLD, 20));
        reviews.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        reviews.setBounds(0,480,250,40);
        reviews.setBackground(new Color(100,160,240));
        reviews.setForeground(new Color(100,30,22));
        reviews.setMargin(new Insets(0,0,0,100));
        reviews.addActionListener(this);
        p2.add(reviews);

        logout = new JButton("Logout");
        logout.setFont(new Font("Railway",Font.BOLD, 20));
        logout.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        logout.setBounds(0,520,250,40);
        logout.setBackground(new Color(100,160,240));
        logout.setForeground(new Color(100,30,22));
        logout.setMargin(new Insets(0,0,0,100));
        logout.addActionListener(this);
        p2.add(logout);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i5 = i4.getImage().getScaledInstance(1050,600,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(250,65,1050,600);
        add(image);

        JLabel text = new JLabel("Travel And Tourism Management System");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Railway", Font.BOLD, 44));
        text.setBounds(80, 30, 1000, 50);
        image.add(text);


        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == addPersonalDetails){
            new AddCustomer(userName);
        }
        else if(ae.getSource() == viewPersonalDetails){
            new ViewCustomer(userName).setVisible(true);
        }
        else if(ae.getSource() == updatePersonalDetails){
            new UpdateCustomer(userName).setVisible(true);
        }
        else if(ae.getSource() == checkPackages){
            new CheckPackage().setVisible(true);
        }
        else if(ae.getSource() == bookPackage){
            new BookPackage(userName).setVisible(true);
        }
        else if(ae.getSource() == viewPackage){
            new ViewPackage(userName).setVisible(true);
        }
        else if(ae.getSource() == viewHotels){
            new ViewHotels().setVisible(true);
        }
        else if(ae.getSource() == destinations){
            new Destinations().setVisible(true);
        }
        else if(ae.getSource() == bookHotels){
            new BookHotel(userName).setVisible(true);
        }
        else if(ae.getSource() == viewBookedHotel){
            new ViewBookedHotel(userName).setVisible(true);
        }
        else if(ae.getSource() == payments){
            new Payment(userName).setVisible(true);
        }
        else if(ae.getSource() == deletePersonalDetails){
            new DeleteCustomer(userName).setVisible(true);
        }
        else if(ae.getSource() == reviews){
            new Reviews(userName).setVisible(true);
        }
        else if(ae.getSource() == logout){
            System.exit(0);
        }
    }
    public static void main(String[] args) {
    new DashBoard("");
    }
}
