import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class AddCustomer extends JFrame implements ActionListener {
    JLabel labelUserName, labelName;
    JComboBox ids;
    JTextField numberField, countryField, addressField, emailField, phoneField;
    JRadioButton g1, g2;
    JButton addBtn, backBtn;

    String username;

    AddCustomer(String username){
        this.username = username;
        setBounds(200,80,850,550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel userName = new JLabel("Username: ");
        userName.setBounds(30,50,150,25);
        add(userName);

        labelUserName = new JLabel();
        labelUserName.setBounds(200,50,150,25);
        add(labelUserName);

        JLabel id = new JLabel("id");
        id.setBounds(30,85,150,25);
        add(id);

        String[] valId = {"Aadhar Card", "Passport", "Pan Card", "Ration Card"};
        ids = new JComboBox(valId);
        ids.setBounds(200, 85, 150, 25);
        ids.setBackground(Color.WHITE);
        add(ids);

        JLabel number = new JLabel("Number: ");
        number.setBounds(30,120,150,25);
        add(number);

        numberField = new JTextField();
        numberField.setBounds(200, 120, 150, 25);
        add(numberField);

        JLabel name = new JLabel("Name: ");
        name.setBounds(30, 155, 150, 25);
        add(name);

        labelName = new JLabel("abcd");
        labelName.setBounds(200, 155, 150, 25);
        add(labelName);

        JLabel gender = new JLabel("Gender: ");
        gender.setBounds(30, 190, 150, 25);
        add(gender);

        g1 = new JRadioButton("Male");
        g1.setBounds(200, 190, 75, 25);
        g1.setBackground(Color.WHITE);
        add(g1);
        g2 = new JRadioButton("Female");
        g2.setBounds(275, 190, 75, 25);
        g2.setBackground(Color.WHITE);
        add(g2);
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(g1);
        genderGroup.add(g2);

        JLabel country = new JLabel("Country: ");
        country.setBounds(30, 225, 150, 25);
        add(country);

        countryField = new JTextField();
        countryField.setBounds(200, 225, 150, 25);
        add(countryField);

        JLabel address = new JLabel("Address: ");
        address.setBounds(30, 260, 150, 25);
        add(address);

        addressField = new JTextField();
        addressField.setBounds(200, 260, 150, 25);
        add(addressField);

        JLabel email = new JLabel("Email: ");
        email.setBounds(30, 295, 150, 25);
        add(email);

        emailField = new JTextField();
        emailField.setBounds(200, 295, 150, 25);
        add(emailField);

        JLabel phone = new JLabel("Phone: ");
        phone.setBounds(30, 330, 150, 25);
        add(phone);

        phoneField = new JTextField();
        phoneField.setBounds(200, 330, 150, 25);
        add(phoneField);

        backBtn = new JButton("Back");
        backBtn.setBounds(50, 370, 100, 25);
        backBtn.setBackground(Color.BLACK);
        backBtn.setForeground(Color.WHITE);
        backBtn.addActionListener(this);
        add(backBtn);

        addBtn = new JButton("Add");
        addBtn.setBounds(220, 370, 100, 25);
        addBtn.setBackground(Color.BLACK);
        addBtn.setForeground(Color.WHITE);
        addBtn.addActionListener(this);
        add(addBtn);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tp.png"));
        Image i2 = i1.getImage().getScaledInstance(250, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450, 50, 250, 400);
        add(image);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from account where userName='"+username+"'");
            while (rs.next()){
                labelUserName.setText(rs.getString("userName"));
                labelName.setText(rs.getString("name"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }


        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == addBtn){
            String userName = labelUserName.getText();
            String id = (String) ids.getSelectedItem();
            String idNumber = numberField.getText();
            String name = labelName.getText();
            String gender= null;
            if(g1.isSelected()){
                gender = "Male";
            }
            else if(g2.isSelected()){
                gender = "Female";
            }
            String country = countryField.getText();
            String address = addressField.getText();
            String phone = phoneField.getText();
            String email = emailField.getText();

            try{
                Conn c = new Conn();
                String query = "insert into customer values('"+userName+"', '"+id+"', '"+idNumber+"', '"+name+"', '"+gender+"', '"+email+"', '"+phone+"', '"+country+"', '"+address+"')";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
                setVisible(false);
            }
            catch (Exception e){
                e.printStackTrace();
            }

        }
        else if(ae.getSource() == backBtn){
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new AddCustomer("");
    }
}
