import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class ForgotPassword extends JFrame implements ActionListener {

    JButton backbtn, searchBtn, retrieveBtn;
    JTextField userNameField, nameField, answerField, passwordField, sqField;

    ForgotPassword(){
        setLayout(null);

        setBounds(200,160,900,400);
        getContentPane().setBackground(Color.WHITE);

        JPanel p1 = new JPanel();
        p1.setBounds(0,0,400,400);
        p1.setLayout(null);
        add(p1);

        ImageIcon log1 = new ImageIcon(ClassLoader.getSystemResource("icons/fp.png"));
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
        userNameField.setBounds(160, 20, 200, 25);
        userNameField.setFont(new Font("Railway", Font.BOLD, 18));
        userNameField.setBorder(BorderFactory.createEmptyBorder());
        p2.add(userNameField);

        searchBtn = new JButton("Search");
        searchBtn.setBounds(370, 20, 100, 25);
        searchBtn.setFont(new Font("Railway", Font.BOLD, 16));
        searchBtn.setBackground(Color.WHITE);
        searchBtn.setForeground(new Color(100, 160, 240));
        searchBtn.addActionListener(this);
        p2.add(searchBtn);

        JLabel name = new JLabel("Name: ");
        name.setBounds(30, 65, 120, 25);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("Railway", Font.BOLD, 18));
        p2.add(name);

        nameField = new JTextField();
        nameField.setBounds(160, 65, 200, 25);
        nameField.setFont(new Font("Railway", Font.BOLD, 18));
        nameField.setBorder(BorderFactory.createEmptyBorder());
        p2.add(nameField);

        JLabel sq = new JLabel("Question: ");
        sq.setBounds(30, 110, 120, 25);
        sq.setForeground(Color.WHITE);
        sq.setFont(new Font("Railway", Font.BOLD, 18));
        p2.add(sq);

        sqField = new JTextField();
        sqField.setBounds(160, 110, 250, 25);
        sqField.setFont(new Font("Railway", Font.BOLD, 18));
        sqField.setBorder(BorderFactory.createEmptyBorder());
        p2.add(sqField);

        JLabel answer = new JLabel("Answer: ");
        answer.setBounds(30, 150, 170, 25);
        answer.setForeground(Color.WHITE);
        answer.setFont(new Font("Railway", Font.BOLD, 18));
        p2.add(answer);

        answerField = new JTextField();
        answerField.setBackground(Color.WHITE);
        answerField.setBounds(160, 150, 200, 25);
        answerField.setFont(new Font("Railway", Font.BOLD, 18));
        p2.add(answerField);

        retrieveBtn = new JButton("Retrieve");
        retrieveBtn.setBounds(370, 150, 100, 25);
        retrieveBtn.setFont(new Font("Railway", Font.BOLD, 16));
        retrieveBtn.setBackground(Color.WHITE);
        retrieveBtn.setForeground(new Color(100, 160, 240));
        retrieveBtn.addActionListener(this);
        p2.add(retrieveBtn);

        JLabel password = new JLabel("Password: ");
        password.setBounds(30, 195, 120, 25);
        password.setForeground(Color.WHITE);
        password.setFont(new Font("Railway", Font.BOLD, 18));
        p2.add(password);

        passwordField = new JTextField();
        passwordField.setBounds(160, 195, 200, 25);
        passwordField.setFont(new Font("Railway", Font.BOLD, 18));
        passwordField.setBorder(BorderFactory.createEmptyBorder());
        p2.add(passwordField);

        backbtn = new JButton("BACK");
        backbtn.setBackground(Color.white);
        backbtn.setForeground(new Color(100,160,250));
        backbtn.setBounds(180,280,150,30);
        backbtn.addActionListener(this);
        p2.add(backbtn);


        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == searchBtn){
        String userName = userNameField.getText();
        String answer = answerField.getText();
        Conn c = new Conn();

        String query = "select * from account where userName='"+userName+"'";
        try{
            ResultSet rs = c.s.executeQuery(query);
            if(rs.next()){
                nameField.setText(rs.getString("name"));
                sqField.setText(rs.getString("securityQuestion"));
            }
            else {
                JOptionPane.showMessageDialog(null, "Incorrect username");
            }
        }
        catch (Exception e){
            e.printStackTrace();
            }
        }
        else if(ae.getSource() == retrieveBtn){
            if(nameField.getText().length() > 1){
                String answer = answerField.getText();
                Conn c = new Conn();
                String query = "select * from account where answer='"+answer+"'";
                try{
                    ResultSet rs = c.s.executeQuery(query);
                    if(rs.next()){
                        passwordField.setText(rs.getString("password"));
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Correct Answer is Required!");
                    }
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
            else {
                JOptionPane.showMessageDialog(null, "Username Required");
            }
        }
        else if(ae.getSource() == backbtn){
            setVisible(false);
            new Login().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new ForgotPassword();
    }
}
