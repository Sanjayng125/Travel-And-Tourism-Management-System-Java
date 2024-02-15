import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class DeleteCustomer extends JFrame implements ActionListener {
    String username;
    JButton backBtn, deleteBtn;
    DeleteCustomer(String username){
        this.username = username;

        setBounds(200, 80, 850, 550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel userName = new JLabel("Username: ");
        userName.setBounds(30, 50, 150, 25);
        add(userName);

        JLabel getUserName = new JLabel();
        getUserName.setBounds(200, 50, 150, 25);
        add(getUserName);

        JLabel name = new JLabel("Name: ");
        name.setBounds(30, 95, 150, 25);
        add(name);

        JLabel getName = new JLabel();
        getName.setBounds(200, 95, 150, 25);
        add(getName);

        JLabel id = new JLabel("Id: ");
        id.setBounds(30, 140, 150, 25);
        add(id);

        JLabel getId = new JLabel();
        getId.setBounds(200, 140, 150, 25);
        add(getId);

        JLabel idNumber = new JLabel("Id Number: ");
        idNumber.setBounds(30, 185, 150, 25);
        add(idNumber);

        JLabel getIdNumber = new JLabel();
        getIdNumber.setBounds(200, 185, 150, 25);
        add(getIdNumber);

        JLabel gender = new JLabel("Gender: ");
        gender.setBounds(30, 230, 150, 25);
        add(gender);

        JLabel getGender = new JLabel();
        getGender.setBounds(200, 230, 150, 25);
        add(getGender);

        JLabel email = new JLabel("Email: ");
        email.setBounds(450, 50, 150, 25);
        add(email);

        JLabel getEmail = new JLabel();
        getEmail.setBounds(620, 50, 150, 25);
        add(getEmail);

        JLabel phone = new JLabel("Phone: ");
        phone.setBounds(450, 95, 150, 25);
        add(phone);

        JLabel getPhone = new JLabel();
        getPhone.setBounds(620, 95, 150, 25);
        add(getPhone);

        JLabel country = new JLabel("Country: ");
        country.setBounds(450, 140, 150, 25);
        add(country);

        JLabel getCountry = new JLabel();
        getCountry.setBounds(620, 140, 150, 25);
        add(getCountry);

        JLabel address = new JLabel("Address: ");
        address.setBounds(450, 185, 150, 25);
        add(address);

        JLabel getAddress = new JLabel();
        getAddress.setBounds(620, 185, 150, 25);
        add(getAddress);

        backBtn = new JButton("Back");
        backBtn.setBackground(Color.BLACK);
        backBtn.setForeground(Color.WHITE);
        backBtn.setBounds(30, 280, 100, 30);
        backBtn.addActionListener(this);
        add(backBtn);

        deleteBtn = new JButton("Delete");
        deleteBtn.setBackground(Color.BLACK);
        deleteBtn.setForeground(Color.WHITE);
        deleteBtn.setBounds(180, 280, 100, 30);
        deleteBtn.addActionListener(this);
        add(deleteBtn);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/travelGroup.jpg"));
        Image i2 = i1.getImage().getScaledInstance(550, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(20, 300, 550, 200);
        add(image);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/travelGroup.jpg"));
        Image i5 = i4.getImage().getScaledInstance(550, 200, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image1 = new JLabel(i6);
        image1.setBounds(550, 300, 550, 200);
        add(image1);

        try{
            Conn c = new Conn();
            String query = "select * from customer where userName='"+username+"'";
            ResultSet rs = c.s.executeQuery(query);
            if(rs.next()){
                getUserName.setText(rs.getString("userName"));
                getName.setText(rs.getString("name"));
                getId.setText(rs.getString("id"));
                getIdNumber.setText(rs.getString("idNumber"));
                getGender.setText(rs.getString("gender"));
                getEmail.setText(rs.getString("email"));
                getPhone.setText(rs.getString("phone"));
                getCountry.setText(rs.getString("country"));
                getAddress.setText(rs.getString("address"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == deleteBtn){
            try{
                Conn c = new Conn();
                c.s.executeUpdate("delete from account where userName='"+username+"'");
                c.s.executeUpdate("delete from customer where userName='"+username+"'");
                c.s.executeUpdate("delete from BookPackage where userName='"+username+"'");
                c.s.executeUpdate("delete from bookhotel where userName='"+username+"'");

                JOptionPane.showMessageDialog(null, "Your Account has been deleted successfully!!");
                System.exit(0);
            }
            catch (Exception e){
                e.printStackTrace();
            }

            setVisible(false);
        }
        else {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new DeleteCustomer("");
    }
}
