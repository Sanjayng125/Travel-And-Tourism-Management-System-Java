import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignUp extends JFrame implements ActionListener {

    JButton backbtn, createbtn;
    JTextField userNameField, nameField, answerField;
    JPasswordField passwordField;
    JComboBox sqBox;

    SignUp(){
        setLayout(null);

        setBounds(200,160,900,400);
        getContentPane().setBackground(Color.WHITE);

        JPanel p1 = new JPanel();
        p1.setBounds(0,0,400,400);
        p1.setLayout(null);
        add(p1);

        ImageIcon log1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image log2 = log1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon log3 = new ImageIcon(log2);
        JLabel loginImg = new JLabel(log3);
        loginImg.setBounds(50, 30, 300 , 300);
        p1.add(loginImg);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(100,160,250));
        p2.setBounds(400, 0, 500, 400);
        add(p2);

        JLabel userName = new JLabel("Username: ");
        userName.setBounds(30, 20, 120, 25);
        userName.setForeground(Color.WHITE);
        userName.setFont(new Font("Railway", Font.BOLD, 18));
        p2.add(userName);

        userNameField = new JTextField();
        userNameField.setBounds(200, 20, 250, 25);
        userNameField.setFont(new Font("Railway", Font.BOLD, 18));
        userNameField.setBorder(BorderFactory.createEmptyBorder());
        p2.add(userNameField);

        JLabel name = new JLabel("Name: ");
        name.setBounds(30, 65, 120, 25);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("Railway", Font.BOLD, 18));
        p2.add(name);

        nameField = new JTextField();
        nameField.setBounds(200, 65, 250, 25);
        nameField.setFont(new Font("Railway", Font.BOLD, 18));
        nameField.setBorder(BorderFactory.createEmptyBorder());
        p2.add(nameField);

        JLabel password = new JLabel("Password: ");
        password.setBounds(30, 110, 120, 25);
        password.setForeground(Color.WHITE);
        password.setFont(new Font("Railway", Font.BOLD, 18));
        p2.add(password);

        passwordField = new JPasswordField();
        passwordField.setBounds(200, 110, 250, 25);
        passwordField.setFont(new Font("Railway", Font.BOLD, 18));
        passwordField.setBorder(BorderFactory.createEmptyBorder());
        p2.add(passwordField);

        JLabel sq = new JLabel("Security Question: ");
        sq.setBounds(30, 150, 170, 25);
        sq.setForeground(Color.WHITE);
        sq.setFont(new Font("Railway", Font.BOLD, 18));
        p2.add(sq);

        String[] valSq = {"What is your fav food","What is your fav sports","What is your fav color","Which is your born place"};
        sqBox = new JComboBox(valSq);
        sqBox.setBackground(Color.WHITE);
        sqBox.setBounds(200, 150, 250, 25);
        sqBox.setFont(new Font("Railway", Font.BOLD, 18));
        p2.add(sqBox);

        JLabel answer = new JLabel("Answer: ");
        answer.setBounds(30, 195, 120, 25);
        answer.setForeground(Color.WHITE);
        answer.setFont(new Font("Railway", Font.BOLD, 18));
        p2.add(answer);

        answerField = new JTextField();
        answerField.setBounds(200, 195, 250, 25);
        answerField.setFont(new Font("Railway", Font.BOLD, 18));
        answerField.setBorder(BorderFactory.createEmptyBorder());
        p2.add(answerField);

        createbtn = new JButton("CREATE");
        createbtn.setBackground(Color.white);
        createbtn.setForeground(new Color(100,160,250));
        createbtn.setBounds(60,280,150,30);
        createbtn.addActionListener(this);
        p2.add(createbtn);

        backbtn = new JButton("BACK");
        backbtn.setBackground(Color.white);
        backbtn.setForeground(new Color(100,160,250));
        backbtn.setBounds(260,280,150,30);
        backbtn.addActionListener(this);
        p2.add(backbtn);


        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
    if(ae.getSource() == backbtn){
        setVisible(false);
        new Login().setVisible(true);
    }
    else if(ae.getSource() == createbtn){
        String userName = userNameField.getText();
        String name = nameField.getText();
        String password = passwordField.getText();
        String sq = (String) sqBox.getSelectedItem();
        String answer = answerField.getText();

        if(userName.equals("") || name.equals("") || password.equals("") || sq.equals("") || answer.equals("")){
            JOptionPane.showMessageDialog(null, "All fields are required!!");
        }
        String query = "insert into account values('"+userName+"', '"+name+"', '"+password+"', '"+sq+"', '"+answer+"')";
        try{
        Conn c = new Conn();
        c.s.executeUpdate(query);
        JOptionPane.showMessageDialog(null, "Account Created Successfully");
        setVisible(false);
        new Login().setVisible(true);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    }

    public static void main(String[] args) {
        new SignUp();
    }
}
