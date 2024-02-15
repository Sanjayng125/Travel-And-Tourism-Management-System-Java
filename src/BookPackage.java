import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BookPackage extends JFrame implements ActionListener {

    JButton checkPriceBtn, bookPackageBtn, backBtn;
    JLabel getUserName, getId, getIdNumber, getPhone, getPrice;
    JTextField personsField;
    JComboBox packages;

    String username;
    BookPackage(String username){
        this.username = username;

        setBounds(200, 80, 1000, 500);
        setLayout(null);

        JLabel heading = new JLabel("BOOK PACKAGE");
        heading.setBounds(100, 30, 200, 30);
        heading.setFont(new Font("Railway", Font.PLAIN, 20));
        add(heading);

        JLabel userName = new JLabel("Username: ");
        userName.setBounds(30, 80, 150, 25);
        userName.setFont(new Font("Railway", Font.PLAIN, 16));
        add(userName);

        getUserName = new JLabel();
        getUserName.setBounds(200, 80, 150, 25);
        add(getUserName);

        JLabel lblpackage = new JLabel("Select Package: ");
        lblpackage.setBounds(30, 115, 150, 25);
        lblpackage.setFont(new Font("Railway", Font.PLAIN, 16));
        add(lblpackage);

        String[] packs = {"GOLD PACKAGE", "SILVER PACKAGE", "BRONZE PACKAGE"};
        packages = new JComboBox(packs);
        packages.setBounds(200, 115, 150, 25);
        packages.setBackground(Color.WHITE);
        add(packages);

        JLabel persons = new JLabel("Total Persons: ");
        persons.setBounds(30, 150, 150, 25);
        persons.setFont(new Font("Railway", Font.PLAIN, 16));
        add(persons);

        personsField = new JTextField("1");
        personsField.setBounds(200, 150, 150, 25);
        personsField.setFont(new Font("Railway", Font.PLAIN, 16));
        add(personsField);

        JLabel id = new JLabel("ID: ");
        id.setBounds(30, 185, 150, 25);
        id.setFont(new Font("Railway", Font.PLAIN, 16));
        add(id);

        getId = new JLabel();
        getId.setBounds(200, 185, 150, 25);
        add(getId);

        JLabel idNumber = new JLabel("ID Number: ");
        idNumber.setBounds(30, 220, 150, 25);
        idNumber.setFont(new Font("Railway", Font.PLAIN, 16));
        add(idNumber);

        getIdNumber = new JLabel();
        getIdNumber.setBounds(200, 220, 150, 25);
        add(getIdNumber);

        JLabel phone = new JLabel("Phone: ");
        phone.setBounds(30, 255, 150, 25);
        phone.setFont(new Font("Railway", Font.PLAIN, 16));
        add(phone);

        getPhone = new JLabel();
        getPhone.setBounds(200, 255, 150, 25);
        add(getPhone);

        JLabel price = new JLabel("Total Price: ");
        price.setBounds(30, 290, 150, 25);
        price.setFont(new Font("Railway", Font.PLAIN, 16));
        add(price);

        getPrice = new JLabel();
        getPrice.setBounds(200, 290, 150, 25);
        add(getPrice);

        checkPriceBtn = new JButton("Check Price");
        checkPriceBtn.setBounds(50, 330, 140, 30);
        checkPriceBtn.setBackground(Color.BLACK);
        checkPriceBtn.setForeground(Color.WHITE);
        checkPriceBtn.addActionListener(this);
        add(checkPriceBtn);

        bookPackageBtn = new JButton("Book Package");
        bookPackageBtn.setBounds(220, 330, 140, 30);
        bookPackageBtn.setBackground(Color.BLACK);
        bookPackageBtn.setForeground(Color.WHITE);
        bookPackageBtn.addActionListener(this);
        add(bookPackageBtn);

        backBtn = new JButton("Back");
        backBtn.setBounds(140, 370, 140, 30);
        backBtn.setBackground(Color.BLACK);
        backBtn.setForeground(Color.WHITE);
        backBtn.addActionListener(this);
        add(backBtn);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(480, 20, 450, 400);
        add(image);

        try{
            Conn c = new Conn();
            String query = "select * from customer where userName='"+username+"'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()){
                getUserName.setText(rs.getString("userName"));
                getId.setText(rs.getString("id"));
                getIdNumber.setText(rs.getString("idNumber"));
                getPhone.setText(rs.getString("phone"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }


        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == checkPriceBtn){
            String pack = (String) packages.getSelectedItem();
            int cost = 0;
            if(pack.equals("GOLD PACKAGE")){
                cost += 33999;
            }
            else if(pack.equals("SILVER PACKAGE")){
                cost += 23999;
            }
            else if(pack.equals("BRONZE PACKAGE")){
                cost += 11999;
            }
            int persons = Integer.parseInt(personsField.getText());
            cost *= persons;
            getPrice.setText("Rs " + cost + "/-");
        }
        else if(ae.getSource() == bookPackageBtn){
            if(getPrice.getText().length() > 2){
            try{
                Conn c = new Conn();
                c.s.executeUpdate("insert into BookPackage values('"+getUserName.getText()+"', '"+packages.getSelectedItem()+"', '"+personsField.getText()+"', '"+getId.getText()+"', '"+getIdNumber.getText()+"', '"+getPhone.getText()+"', '"+getPrice.getText()+"')");

                JOptionPane.showMessageDialog(null,"Package booked successfully");
                setVisible(false);
            }
            catch(Exception e){
                e.printStackTrace();
            }
         }
        else {
         JOptionPane.showMessageDialog(null,"Please Check Price First");
          }
        }
        else {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new BookPackage("abc");
    }
}
