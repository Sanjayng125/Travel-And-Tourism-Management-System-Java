import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Reviews extends JFrame implements ActionListener {
    String username;
    Choice getHotel, getPackage, getStars;
    JTextField getReview;
    JLabel getUserName, getDate;
    JButton backBtn, submitBtn;
    Reviews(String username){
        this.username = username;
        setBounds(240, 50, 800, 600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JPanel p1 = new JPanel();
        p1.setBounds(0, 0, 800, 160);
        p1.setBackground(new Color(100, 160, 240));
        p1.setLayout(null);
        add(p1);

        JLabel userName = new JLabel("Username: ");
        userName.setBounds(20, 5, 80, 30);
        userName.setForeground(Color.WHITE);
        p1.add(userName);

        getUserName = new JLabel("Tommmmmmmmmm");
        getUserName.setBounds(110, 5, 120, 30);
        getUserName.setForeground(Color.WHITE);
        p1.add(getUserName);

        JLabel hotel = new JLabel("Hotel Name: ");
        hotel.setBounds(240, 5, 80, 30);
        hotel.setForeground(Color.WHITE);
        p1.add(hotel);

        getHotel = new Choice();
        getHotel.setBounds(330, 10, 150, 30);
        p1.add(getHotel);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from hotel");
            while (rs.next()){
                getHotel.add(rs.getString("name"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        JLabel packageName = new JLabel("Package: ");
        packageName.setBounds(490, 5, 70, 30);
        packageName.setForeground(Color.WHITE);
        p1.add(packageName);

        getPackage = new Choice();
        getPackage.add("GOLD PACKAGE");
        getPackage.add("SILVER PACKAGE");
        getPackage.add("BRONZE PACKAGE");
        getPackage.setBounds(570, 10, 150, 30);
        p1.add(getPackage);

        JLabel stars = new JLabel("Ratings: ");
        stars.setBounds(20, 40, 70, 30);
        stars.setForeground(Color.WHITE);
        p1.add(stars);

        getStars = new Choice();
        getStars.add("⭐ 1/5");
        getStars.add("⭐⭐ 2/5");
        getStars.add("⭐⭐⭐ 3/5");
        getStars.add("⭐⭐⭐⭐ 4/5");
        getStars.add("⭐⭐⭐⭐⭐ 5/5");
        getStars.setBounds(100, 45, 150, 30);
        p1.add(getStars);

        JLabel review = new JLabel("Review: ");
        review.setBounds(280, 40, 80, 30);
        review.setForeground(Color.WHITE);
        p1.add(review);

        getReview = new JTextField();
        getReview.setBounds(350, 45, 350, 25);
        getReview.setBorder(BorderFactory.createEmptyBorder());
        p1.add(getReview);

        JLabel date = new JLabel("Date: ");
        review.setBounds(280, 40, 80, 30);
        review.setForeground(Color.WHITE);
        p1.add(review);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/ratings1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 440, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 150, 800, 450);
        add(image);


        backBtn = new JButton("Back");
        backBtn.setBackground(Color.WHITE);
        backBtn.setForeground(new Color(100, 160, 240));
        backBtn.setBounds(540, 100, 100, 30);
        backBtn.setBorder(BorderFactory.createEmptyBorder());
        backBtn.addActionListener(this);
        p1.add(backBtn);

        submitBtn = new JButton("Submit");
        submitBtn.setBackground(Color.WHITE);
        submitBtn.setForeground(new Color(100, 160, 240));
        submitBtn.setBounds(650, 100, 100, 30);
        submitBtn.setBorder(BorderFactory.createEmptyBorder());
        submitBtn.addActionListener(this);
        p1.add(submitBtn);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where userName='Tom753'");
            while (rs.next()){
                getUserName.setText(rs.getString("userName"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }


        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submitBtn){
            String userName = getUserName.getText();
            String hotelName = getHotel.getSelectedItem();
            String packageName = getPackage.getSelectedItem();
            String rating = getStars.getSelectedItem();
            String review = getReview.getText().length() > 1 ? getReview.getText() : "N/A";

            try{
                Date date = new Date();
                Conn c = new Conn();
                c.s.executeUpdate("insert into reviews values('"+userName+"', '"+hotelName+"', '"+packageName+"', '"+rating+"', '"+review+"', '"+date+"')");

                JOptionPane.showMessageDialog(null, "Thank You. Review Added!");
                setVisible(false);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        else {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new Reviews("");
    }
}
