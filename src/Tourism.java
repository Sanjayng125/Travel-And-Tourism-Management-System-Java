import javax.swing.*;
import java.awt.*;

public class Tourism extends JFrame implements Runnable {

    Thread thread;

    Tourism() {

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dest5.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1200, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        // setSize(1200, 600);
        // setLocation(50,50);
        setVisible(true);
        thread = new Thread(this);
        thread.start();

    }

    public void run() {
        try {
            Thread.sleep(5000);
            setVisible(false);
            new Login();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void main(String[] args) {
        Tourism frame = new Tourism();

        int x = 1;
        for (int i = 0; i <= 500; x += 7, i += 6) {
            frame.setLocation(700 - (x + i) / 2, 300 - (i / 2));
            frame.setSize(x + i, i);
            try {
                Thread.sleep(8);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
