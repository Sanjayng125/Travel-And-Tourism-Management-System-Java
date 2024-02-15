import javax.swing.*;
import java.awt.*;

public class ViewHotels extends JFrame implements Runnable{

    Thread t1;
    JLabel l1, l2, l3, l4, l5;
    JLabel[] images4 = new JLabel[]{l1, l2, l3, l4, l5};
    JLabel caption;

    public void run(){
        String[] hotelNames = {"Radisson Blu Hotel", "Ruchi The Prince", "Grand Mercure Hotel", "Silent shores", "Southren Star"};
        try{
            for(int i=0;i<5;i++){
                images4[i].setVisible(true);
                caption.setText(hotelNames[i]);
                Thread.sleep(2000);
                images4[i].setVisible(false);
                if(i==4){
                    setVisible(false);
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    ViewHotels(){
        setBounds(200, 80, 800, 550);

        caption = new JLabel();
        caption.setBounds(50, 450, 500, 50);
        caption.setFont(new Font("Railway", Font.BOLD, 40));
        caption.setForeground(Color.WHITE);
        add(caption);

        ImageIcon i1 = null, i2 = null, i3 = null, i4 = null, i5 = null;
        ImageIcon[] images1 = new ImageIcon[]{i1, i2, i3, i4, i5};

        Image j1 = null, j2 = null, j3 = null, j4 = null, j5 = null;
        Image[] images2 = new Image[]{j1, j2, j3, j4, j5};

        ImageIcon k1 = null, k2 = null, k3 = null, k4 = null, k5 = null;
        ImageIcon[] images3 = new ImageIcon[]{k1, k2, k3, k4, k5};

        for(int i=0;i<5;i++){
            images1[i] = new ImageIcon(ClassLoader.getSystemResource("icons/hotel"+(i+1)+".jpeg"));
            images2[i] = images1[i].getImage().getScaledInstance(800, 550, Image.SCALE_DEFAULT);
            images3[i] = new ImageIcon(images2[i]);
            images4[i] = new JLabel(images3[i]);
            images4[i].setBounds(0, 0, 800, 550);
            add(images4[i]);
        }

        t1 = new Thread(this);
        t1.start();

        setVisible(true);
    }
    public static void main(String[] args) {
        new ViewHotels();
    }
}
