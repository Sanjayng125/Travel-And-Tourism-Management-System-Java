import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JButton loginBtn, signUpBtn, forgotBtn, cancelBtn;
    JTextField userNameField, passwordField;

    Login() {
        setSize(900, 400);
        setLocation(200, 160);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(100, 160, 250));
        p1.setBounds(0, 0, 400, 400);
        p1.setLayout(null);
        add(p1);

        ImageIcon log1 = new ImageIcon(ClassLoader.getSystemResource("icons/login3.png"));
        Image log2 = log1.getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT);
        ImageIcon log3 = new ImageIcon(log2);
        JLabel loginImg = new JLabel(log3);
        loginImg.setBounds(130, 80, 100, 100);
        p1.add(loginImg);

        JLabel t1 = new JLabel("Login");
        t1.setForeground(Color.WHITE);
        t1.setFont(new Font("Railway", Font.BOLD, 66));
        t1.setBounds(100, 160, 250, 100);
        p1.add(t1);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(400, 30, 450, 300);
        add(p2);

        JLabel userName = new JLabel("Username: ");
        userName.setBounds(60, 20, 120, 25);
        userName.setFont(new Font("Railway", Font.BOLD, 18));
        p2.add(userName);

        userNameField = new JTextField();
        userNameField.setBounds(60, 55, 350, 30);
        userNameField.setFont(new Font("Railway", Font.BOLD, 18));
        userNameField.setBorder(BorderFactory.createEmptyBorder());
        p2.add(userNameField);

        JLabel password = new JLabel("Password: ");
        password.setBounds(60, 95, 120, 25);
        password.setFont(new Font("Railway", Font.BOLD, 18));
        p2.add(password);

        passwordField = new JTextField();
        passwordField.setBounds(60, 125, 350, 30);
        passwordField.setFont(new Font("Railway", Font.BOLD, 18));
        passwordField.setBorder(BorderFactory.createEmptyBorder());
        p2.add(passwordField);

        loginBtn = new JButton("Login");
        loginBtn.setBackground(new Color(100, 160, 250));
        loginBtn.setForeground(Color.WHITE);
        loginBtn.setBounds(60, 180, 150, 30);
        loginBtn.addActionListener(this);
        p2.add(loginBtn);

        signUpBtn = new JButton("Sign Up");
        signUpBtn.setBackground(new Color(100, 160, 250));
        signUpBtn.setForeground(Color.WHITE);
        signUpBtn.setBounds(260, 180, 150, 30);
        signUpBtn.addActionListener(this);
        p2.add(signUpBtn);

        forgotBtn = new JButton("Forgot Password");
        forgotBtn.setBackground(new Color(100, 160, 250));
        forgotBtn.setForeground(Color.WHITE);
        forgotBtn.setBounds(160, 230, 150, 30);
        forgotBtn.addActionListener(this);
        p2.add(forgotBtn);

        cancelBtn = new JButton("Cancel");
        cancelBtn.setBackground(new Color(100, 160, 250));
        cancelBtn.setForeground(Color.WHITE);
        cancelBtn.setBounds(195, 270, 80, 20);
        cancelBtn.addActionListener(this);
        p2.add(cancelBtn);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == loginBtn) {
            try {
                String userName = userNameField.getText();
                String password = passwordField.getText();

                String query = "select * from account where userName='" + userName + "' and password='" + password
                        + "'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new DashBoard(userName).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Username or Password");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == signUpBtn) {
            setVisible(false);
            new SignUp().setVisible(true);
        } else if (ae.getSource() == forgotBtn) {
            setVisible(false);
            new ForgotPassword().setVisible(true);
        } else {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
