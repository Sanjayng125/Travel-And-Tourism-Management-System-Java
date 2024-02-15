import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.Book;
import java.sql.ResultSet;

public class BookHotel extends JFrame implements ActionListener {

    JTextField personField, daysField;
    JButton chechPriceBtn, bookBtn, backBtn;
    JLabel getUserName, getId, getIdNumber, getPhone, getPrice;
    JComboBox acField, foodField;
    Choice hotelField;

    String username;

    BookHotel(String username){
        this.username = username;

    setBounds(200,60,900,600);
    setLayout(null);

    JLabel heading = new JLabel("BOOK HOTEL");
    heading.setBounds(100,20,200,30);
    heading.setFont(new Font("Railway", Font.BOLD, 22));
    add(heading);

    JLabel userName = new JLabel("Username: ");
    userName.setBounds(30,60,150,25);
    userName.setFont(new Font("Railway", Font.BOLD, 16));
    add(userName);

    getUserName = new JLabel();
    getUserName.setBounds(200,60,150,25);
    getUserName.setFont(new Font("Railway", Font.BOLD, 16));
    add(getUserName);

    JLabel selectHotel = new JLabel("Select Hotel: ");
    selectHotel.setBounds(30,95,150,25);
    selectHotel.setFont(new Font("Railway", Font.BOLD, 16));
    add(selectHotel);

    hotelField = new Choice();
    hotelField.setBackground(Color.WHITE);
    hotelField.setBounds(200,95,150,25);
    hotelField.setFont(new Font("Railway", Font.BOLD, 16));
    add(hotelField);

    try{
        Conn c = new Conn();
        ResultSet rs = c.s.executeQuery("select * from hotel");
        while (rs.next()){
            hotelField.add(rs.getString("name"));
        }
    }
    catch (Exception e){
        e.printStackTrace();
    }

    JLabel persons = new JLabel("Total Persons: ");
    persons.setBounds(30,130,150,25);
    persons.setFont(new Font("Railway", Font.BOLD, 16));
    add(persons);

    personField = new JTextField("1");
    personField.setBounds(200,130,150,25);
    personField.setFont(new Font("Railway", Font.BOLD, 16));
    add(personField);

    JLabel days = new JLabel("No. Of Days: ");
    days.setBounds(30,165,150,25);
    days.setFont(new Font("Railway", Font.BOLD, 16));
    add(days);

    daysField = new JTextField("1");
    daysField.setBounds(200,165,150,25);
    daysField.setFont(new Font("Railway", Font.BOLD, 16));
    add(daysField);

    JLabel ac = new JLabel("AC/Non-AC: ");
    ac.setBounds(30,200,150,25);
    ac.setFont(new Font("Railway", Font.BOLD, 16));
    add(ac);

    String[] options = {"Yes", "No"};
    acField = new JComboBox(options);
    acField.setBackground(Color.WHITE);
    acField.setBounds(200,200,150,25);
    acField.setFont(new Font("Railway", Font.BOLD, 16));
    add(acField);

    JLabel food = new JLabel("Food: ");
    food.setBounds(30,235,150,25);
    food.setFont(new Font("Railway", Font.BOLD, 16));
    add(food);

    String[] options2 = {"Yes", "No"};
    foodField = new JComboBox(options2);
    foodField.setBackground(Color.WHITE);
    foodField.setBounds(200,235,150,25);
    foodField.setFont(new Font("Railway", Font.BOLD, 16));
    add(foodField);

    JLabel id = new JLabel("ID: ");
    id.setBounds(30,270,150,25);
    id.setFont(new Font("Railway", Font.BOLD, 16));
    add(id);

    getId = new JLabel();
    getId.setBounds(200,270,150,25);
    getId.setFont(new Font("Railway", Font.BOLD, 16));
    add(getId);

    JLabel idNumber = new JLabel("ID Number: ");
    idNumber.setBounds(30,305,150,25);
    idNumber.setFont(new Font("Railway", Font.BOLD, 16));
    add(idNumber);

    getIdNumber = new JLabel();
    getIdNumber.setBounds(200,305,150,25);
    getIdNumber.setFont(new Font("Railway", Font.BOLD, 16));
    add(getIdNumber);

    JLabel phone = new JLabel("Phone: ");
    phone.setBounds(30,340,150,25);
    phone.setFont(new Font("Railway", Font.BOLD, 16));
    add(phone);

    getPhone = new JLabel();
    getPhone.setBounds(200,340,150,25);
    getPhone.setFont(new Font("Railway", Font.BOLD, 16));
    add(getPhone);

    JLabel price = new JLabel("Price: ");
    price.setBounds(30,375,150,25);
    price.setFont(new Font("Railway", Font.BOLD, 16));
    add(price);

    getPrice = new JLabel();
    getPrice.setBounds(200,375,150,25);
    getPrice.setFont(new Font("Railway", Font.BOLD, 16));
    add(getPrice);

    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookhotel.jpg"));
    Image i2 = i1.getImage().getScaledInstance(500, 550, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(350, 0, 550, 550);
    add(image);

    chechPriceBtn = new JButton("Check Price");
    chechPriceBtn.setBounds(30, 430, 150, 30);
    chechPriceBtn.setBackground(Color.BLACK);
    chechPriceBtn.setForeground(Color.WHITE);
    chechPriceBtn.addActionListener(this);
    add(chechPriceBtn);

    bookBtn = new JButton("Book");
    bookBtn.setBounds(200, 430, 150, 30);
    bookBtn.setBackground(Color.BLACK);
    bookBtn.setForeground(Color.WHITE);
    bookBtn.addActionListener(this);
    add(bookBtn);

    backBtn = new JButton("Back");
    backBtn.setBounds(115, 480, 150, 30);
    backBtn.setBackground(Color.BLACK);
    backBtn.setForeground(Color.WHITE);
    backBtn.addActionListener(this);
    add(backBtn);

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
        if(ae.getSource() == chechPriceBtn){
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from hotel where name='"+hotelField.getSelectedItem()+"'");
                while (rs.next()){
                    int cost = Integer.parseInt(rs.getString("costperperson"));
                    int food = Integer.parseInt(rs.getString("foodIncluded"));
                    int ac = Integer.parseInt(rs.getString("acroom"));

                    int persons = Integer.parseInt(personField.getText());
                    int days = Integer.parseInt(daysField.getText());

                    String acSelected = (String) acField.getSelectedItem();
                    String foodSelected = (String) foodField.getSelectedItem();

                    if(persons * days > 0){
                        int totalCost = 0;
                        totalCost += acSelected.equals("Yes") ? ac : 0;
                        totalCost += foodSelected.equals("Yes") ? food : 0;
                        totalCost += cost;
                        totalCost = totalCost * persons * days;
                        getPrice.setText("Rs " + totalCost + "/-");
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Please Fill all fields!!");
                    }
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == bookBtn){
            if(getPrice.getText().length() > 1){

            try{
                Conn c = new Conn();
                c.s.executeUpdate("insert into bookhotel values('"+getUserName.getText()+"', '"+hotelField.getSelectedItem()+"', '"+personField.getText()+"', '"+daysField.getText()+"', '"+acField.getSelectedItem()+"', '"+foodField.getSelectedItem()+"', '"+getId.getText()+"', '"+getIdNumber.getText()+"', '"+getPhone.getText()+"', '"+getPrice.getText()+"')");

                JOptionPane.showMessageDialog(null, "Hotel Booked Successfully");
                setVisible(false);
            }
            catch (Exception e){
                e.printStackTrace();
            }
            }
            else {
                JOptionPane.showMessageDialog(null, "Please Check Price First!!");
            }
        }
        else{
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new BookHotel("");
    }
}

