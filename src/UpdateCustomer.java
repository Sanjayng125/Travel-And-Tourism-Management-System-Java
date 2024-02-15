import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateCustomer extends JFrame implements ActionListener {
    JLabel labelUserName, labelName;
    JTextField idField, numberField, genderField, countryField, addressField, emailField, phoneField;
    JButton updateBtn, backBtn;

    String username;

    UpdateCustomer(String username){
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

        JLabel id = new JLabel("id: ");
        id.setBounds(30,85,150,25);
        add(id);

        idField = new JTextField();
        idField.setBounds(200, 85, 150, 25);
        idField.setBackground(Color.WHITE);
        add(idField);

        JLabel number = new JLabel("Number: ");
        number.setBounds(30,120,150,25);
        add(number);

        numberField = new JTextField();
        numberField.setBounds(200, 120, 150, 25);
        add(numberField);

        JLabel name = new JLabel("Name: ");
        name.setBounds(30, 155, 150, 25);
        add(name);

        labelName = new JLabel();
        labelName.setBounds(200, 155, 150, 25);
        add(labelName);

        JLabel gender = new JLabel("Gender: ");
        gender.setBounds(30, 190, 150, 25);
        add(gender);

       genderField = new JTextField();
       genderField.setBounds(200, 190, 150, 25);
       add(genderField);

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

        updateBtn = new JButton("Update");
        updateBtn.setBounds(220, 370, 100, 25);
        updateBtn.setBackground(Color.BLACK);
        updateBtn.setForeground(Color.WHITE);
        updateBtn.addActionListener(this);
        add(updateBtn);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/update.jpg"));
        Image i2 = i1.getImage().getScaledInstance(350, 350, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(420, 100, 350, 270);
        add(image);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where userName='"+username+"'");
            while (rs.next()){
                labelUserName.setText(rs.getString("userName"));
                labelName.setText(rs.getString("name"));
                idField.setText(rs.getString("id"));
                numberField.setText(rs.getString("idNumber"));
                genderField.setText(rs.getString("gender"));
                emailField.setText(rs.getString("email"));
                phoneField.setText(rs.getString("phone"));
                countryField.setText(rs.getString("country"));
                addressField.setText(rs.getString("address"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }


        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == updateBtn){
            String userName = labelUserName.getText();
            String id = idField.getText();
            String idNumber = numberField.getText();
            String name = labelName.getText();
            String gender = genderField.getText();
            String country = countryField.getText();
            String address = addressField.getText();
            String phone = phoneField.getText();
            String email = emailField.getText();

            try{
                if(!id.equals("") || !idNumber.equals("") || !gender.equals("") || !country.equals("") || address.equals("") || !phone.equals("") || !email.equals("")){
                Conn c = new Conn();
                String query = "update customer set userName='"+userName+"', id='"+id+"', idNumber='"+idNumber+"', name='"+name+"', gender='"+gender+"', email='"+email+"', phone='"+phone+"', country='"+country+"', address='"+address+"'";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Customer Details Updated Successfully");
                setVisible(false);
                }
                else {
                JOptionPane.showMessageDialog(null, "All Fields Are Required!!");
                }
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
        new UpdateCustomer("");
    }
}
