import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ViewBookedHotel extends JFrame implements ActionListener {
    String username;
    JButton backBtn;
    ViewBookedHotel(String username){
        this.username = username;

        setBounds(200, 80, 850, 550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("VIEW BOOKED HOTEL DETAILS");
        heading.setBounds(50, 6, 500, 50);
        heading.setFont(new Font("Railway", Font.BOLD, 22));
        add(heading);

        JLabel userName = new JLabel("Username: ");
        userName.setBounds(30, 50, 150, 25);
        add(userName);

        JLabel getUserName = new JLabel();
        getUserName.setBounds(200, 50, 150, 25);
        add(getUserName);

        JLabel hotelName = new JLabel("Hotel Name: ");
        hotelName.setBounds(30, 95, 150, 25);
        add(hotelName);

        JLabel getHotelName = new JLabel();
        getHotelName.setBounds(200, 95, 150, 25);
        add(getHotelName);

        JLabel persons = new JLabel("Total Persons: ");
        persons.setBounds(30, 140, 150, 25);
        add(persons);

        JLabel getPersons = new JLabel();
        getPersons.setBounds(200, 140, 150, 25);
        add(getPersons);

        JLabel days = new JLabel("Total Days: ");
        days.setBounds(30, 185, 150, 25);
        add(days);

        JLabel getDays = new JLabel();
        getDays.setBounds(200, 185, 150, 25);
        add(getDays);

        JLabel ac = new JLabel("AC Included: ");
        ac.setBounds(30, 230, 150, 25);
        add(ac);

        JLabel getAc = new JLabel();
        getAc.setBounds(200, 230, 150, 25);
        add(getAc);

        JLabel food = new JLabel("Food Included: ");
        food.setBounds(30, 275, 150, 25);
        add(food);

        JLabel getFood = new JLabel();
        getFood.setBounds(200, 275, 150, 25);
        add(getFood);

        JLabel id = new JLabel("ID: ");
        id.setBounds(30, 320, 150, 25);
        add(id);

        JLabel getId = new JLabel();
        getId.setBounds(200, 320, 150, 25);
        add(getId);

        JLabel idNumber = new JLabel("ID Number: ");
        idNumber.setBounds(30, 365, 150, 25);
        add(idNumber);

        JLabel getIdNumber = new JLabel();
        getIdNumber.setBounds(200, 365, 150, 25);
        add(getIdNumber);

        JLabel phone = new JLabel("Phone: ");
        phone.setBounds(30, 410, 150, 25);
        add(phone);

        JLabel getPhone = new JLabel();
        getPhone.setBounds(200, 410, 150, 25);
        add(getPhone);

        JLabel price = new JLabel("Price: ");
        price.setBounds(30, 455, 150, 25);
        add(price);

        JLabel getPrice = new JLabel();
        getPrice.setBounds(200, 455, 150, 25);
        add(getPrice);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/viewbdhotel.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 550, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 550, 550);
        add(image);

        backBtn = new JButton("Back");
        backBtn.setBackground(Color.BLACK);
        backBtn.setForeground(Color.WHITE);
        backBtn.setBounds(240, 480, 100, 30);
        backBtn.addActionListener(this);
        add(backBtn);


        try{
            Conn c = new Conn();
            String query = "select * from bookhotel where userName='"+username+"'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()){
                getUserName.setText(rs.getString("userName"));
                getHotelName.setText(rs.getString("hotelName"));
                getPersons.setText(rs.getString("persons"));
                getDays.setText(rs.getString("days"));
                getAc.setText(rs.getString("ac"));
                getFood.setText(rs.getString("food"));
                getId.setText(rs.getString("id"));
                getIdNumber.setText(rs.getString("idNumber"));
                getPhone.setText(rs.getString("phone"));
                getPrice.setText(rs.getString("price"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == backBtn){
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new ViewBookedHotel("");
    }
}
