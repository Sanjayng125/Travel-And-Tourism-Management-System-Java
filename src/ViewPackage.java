import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ViewPackage extends JFrame implements ActionListener {
    String username;
    JButton backBtn;
    ViewPackage(String username){
        this.username = username;

        setBounds(200, 80, 850, 550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("VIEW PACKAGE DETAILS");
        heading.setBounds(50, 6, 500, 50);
        heading.setFont(new Font("Railway", Font.BOLD, 22));
        add(heading);

        JLabel userName = new JLabel("Username: ");
        userName.setBounds(30, 50, 150, 25);
        add(userName);

        JLabel getUserName = new JLabel();
        getUserName.setBounds(200, 50, 150, 25);
        add(getUserName);

        JLabel packageName = new JLabel("Package: ");
        packageName.setBounds(30, 95, 150, 25);
        add(packageName);

        JLabel getPackageName = new JLabel();
        getPackageName.setBounds(200, 95, 150, 25);
        add(getPackageName);

        JLabel persons = new JLabel("Total Persons: ");
        persons.setBounds(30, 140, 150, 25);
        add(persons);

        JLabel getPersons = new JLabel();
        getPersons.setBounds(200, 140, 150, 25);
        add(getPersons);

        JLabel id = new JLabel("ID: ");
        id.setBounds(30, 185, 150, 25);
        add(id);

        JLabel getId = new JLabel();
        getId.setBounds(200, 185, 150, 25);
        add(getId);

        JLabel idNumber = new JLabel("ID Number: ");
        idNumber.setBounds(30, 230, 150, 25);
        add(idNumber);

        JLabel getIdNumber = new JLabel();
        getIdNumber.setBounds(200, 230, 150, 25);
        add(getIdNumber);

        JLabel phone = new JLabel("Phone: ");
        phone.setBounds(30, 275, 150, 25);
        add(phone);

        JLabel getPhone = new JLabel();
        getPhone.setBounds(200, 275, 150, 25);
        add(getPhone);

        JLabel price = new JLabel("Price: ");
        price.setBounds(30, 320, 150, 25);
        add(price);

        JLabel getPrice = new JLabel();
        getPrice.setBounds(200, 320, 150, 25);
        add(getPrice);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/viewpackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 550, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 550, 550);
        add(image);

        backBtn = new JButton("Back");
        backBtn.setBackground(Color.BLACK);
        backBtn.setForeground(Color.WHITE);
        backBtn.setBounds(30, 380, 100, 30);
        backBtn.addActionListener(this);
        add(backBtn);


        try{
            Conn c = new Conn();
            String query = "select * from BookPackage where userName='"+username+"'";
            ResultSet rs = c.s.executeQuery(query);
            if(rs.next()){
                getUserName.setText(rs.getString("userName"));
                getId.setText(rs.getString("id"));
                getIdNumber.setText(rs.getString("idNumber"));
                getPhone.setText(rs.getString("phone"));
                getPrice.setText(rs.getString("price"));
                getPersons.setText(rs.getString("persons"));
                getPackageName.setText(rs.getString("package"));
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
        new ViewPackage("");
    }
}
