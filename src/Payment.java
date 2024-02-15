import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Payment extends JFrame implements ActionListener {
    String username;
    JButton payBtn, backBtn;
    JLabel getUserName, getId, getIdNumber, getPhone, getHotel, getPersons, getDays, getAc, getFood, getHotelPrice, getPackageName, getPackagePrice, getTotalPrice;
    Payment(String username){
        this.username = username;

        setBounds(200, 60, 800, 600);
        setLayout(null);

        JLabel userName = new JLabel("Username: ");
        userName.setBounds(30, 30, 100, 30);
        add(userName);

        getUserName = new JLabel();
        getUserName.setBounds(140, 30, 100, 30);
        add(getUserName);

        JLabel id = new JLabel("ID: ");
        id.setBounds(30, 80, 100, 30);
        add(id);

        getId = new JLabel();
        getId.setBounds(140, 80, 100, 30);
        add(getId);

        JLabel idNumber = new JLabel("ID Number: ");
        idNumber.setBounds(30, 130, 100, 30);
        add(idNumber);

        getIdNumber = new JLabel();
        getIdNumber.setBounds(140, 130, 100, 30);
        add(getIdNumber);

        JLabel phone = new JLabel("Phone: ");
        phone.setBounds(30, 180, 100, 30);
        add(phone);

        getPhone = new JLabel();
        getPhone.setBounds(140, 180, 100, 30);
        add(getPhone);


        //Hotel
        JLabel hotel = new JLabel("Hotel Name: ");
        hotel.setBounds(320, 30, 100, 30);
        add(hotel);

        getHotel = new JLabel();
        getHotel.setBounds(430, 30, 100, 30);
        add(getHotel);

        JLabel persons = new JLabel("Total Persons: ");
        persons.setBounds(320, 80, 100, 30);
        add(persons);

        getPersons = new JLabel();
        getPersons.setBounds(430, 80, 100, 30);
        add(getPersons);

        JLabel days = new JLabel("Total Days: ");
        days.setBounds(320, 130, 100, 30);
        add(days);

        getDays = new JLabel();
        getDays.setBounds(430, 130, 100, 30);
        add(getDays);

        JLabel ac = new JLabel("AC Included: ");
        ac.setBounds(320, 180, 100, 30);
        add(ac);

        getAc = new JLabel();
        getAc.setBounds(430, 180, 100, 30);
        add(getAc);

        JLabel food = new JLabel("Food Included: ");
        food.setBounds(320, 230, 100, 30);
        add(food);

        getFood = new JLabel();
        getFood.setBounds(430, 230, 100, 30);
        add(getFood);

        //Package
        JLabel packageName = new JLabel("Package: ");
        packageName.setBounds(550, 30, 60, 30);
        add(packageName);

        getPackageName = new JLabel();
        getPackageName.setBounds(630, 30, 100, 30);
        add(getPackageName);

        JLabel packagePrice = new JLabel("Package Price: ");
        packagePrice.setBounds(550, 80, 100, 30);
        add(packagePrice);

        getPackagePrice = new JLabel();
        getPackagePrice.setBounds(650, 80, 100, 30);
        add(getPackagePrice);

        JLabel hotelPrice = new JLabel("Hotel Price: ");
        hotelPrice.setBounds(550, 130, 100, 30);
        add(hotelPrice);

        getHotelPrice = new JLabel();
        getHotelPrice.setBounds(630, 130, 100, 30);
        add(getHotelPrice);

        JLabel totalPrice = new JLabel("Total Price: ");
        totalPrice.setBounds(550, 180, 100, 30);
        add(totalPrice);

        getTotalPrice = new JLabel();
        getTotalPrice.setBounds(630, 180, 100, 30);
        add(getTotalPrice);

        payBtn = new JButton("Pay");
        payBtn.setBounds(630, 225, 100, 30);
        payBtn.setBackground(new Color(100, 160, 250));
        payBtn.setForeground(Color.WHITE);
        payBtn.addActionListener(this);
        add(payBtn);

        backBtn = new JButton("Back");
        backBtn.setBounds(520, 225, 100, 30);
        backBtn.setBackground(new Color(100, 160, 250));
        backBtn.setForeground(Color.WHITE);
        backBtn.addActionListener(this);
        add(backBtn);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/payment.png"));
        Image i2 = i1.getImage().getScaledInstance(800, 340, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 260, 800, 350);
        add(image);

        try{
            int total = 0;
            Conn c = new Conn();
            ResultSet rs1 = c.s.executeQuery("select * from customer where userName='"+username+"'");
            while (rs1.next()){
                getUserName.setText(rs1.getString("userName"));
                getId.setText(rs1.getString("id"));
                getIdNumber.setText(rs1.getString("idNumber"));
                getPhone.setText(rs1.getString("phone"));
            }
            ResultSet rs2 = c.s.executeQuery("select * from bookhotel where userName='"+username+"'");
            while (rs2.next()){
                getHotel.setText(rs2.getString("hotelName"));
                getPersons.setText(rs2.getString("persons"));
                getDays.setText(rs2.getString("days"));
                getAc.setText(rs2.getString("ac"));
                getFood.setText(rs2.getString("food"));
                getHotelPrice.setText(rs2.getString("price"));
            }
            ResultSet rs3 = c.s.executeQuery("select * from BookPackage where userName='"+username+"'");
            while (rs3.next()){
                getPackageName.setText(rs3.getString("package"));
                getPackagePrice.setText(rs3.getString("price"));
            }
            if(getHotelPrice.getText().length() > 1){
                total += Integer.parseInt(getHotelPrice.getText().substring(3,(getHotelPrice.getText().length()-3)));
            }
            if(getPackagePrice.getText().length() > 1){
                total += Integer.parseInt(getPackagePrice.getText().substring(3,(getPackagePrice.getText().length()-3)));
            }
            getTotalPrice.setText("Rs " + total + "/-");
        }
        catch (Exception e){
            e.printStackTrace();
        }


        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == payBtn){
            String userName = getUserName.getText();
            String hotelName = getHotel.getText();
            String packageName = getPackageName.getText();
            String phone = getPhone.getText();
            String totalPrice = getTotalPrice.getText();
            if(totalPrice.equals("Rs 0/-")){
                JOptionPane.showMessageDialog(null, "Amount already paid!!");
            }
            else {
                try {
                    Conn c = new Conn();
                    String query = "insert into payments values('" + userName + "','" + packageName + "','" + hotelName + "','" + phone + "','" + totalPrice + "')";
                    c.s.executeUpdate(query);

                    JOptionPane.showMessageDialog(null, "Payment successful");
                    getTotalPrice.setText("Rs 0/-");
                    setVisible(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        else {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new Payment("");
    }
}