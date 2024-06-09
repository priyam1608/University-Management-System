package university.management.system;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable {
    
    Thread t;
    Splash () {
        setTitle("University Management System");
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        setIconImage(icon.getImage());
        
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/1.jpg"));
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/entryclg.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        
        JLabel title = new JLabel("<html>University<br/>Management System</html>");
        title.setBounds(550, 5, 350, 100);
        title.setFont(new  Font("Tahoma",Font.BOLD,30));
        title.setForeground(Color.DARK_GRAY);
        image.add(title);
        
        t = new Thread(this);
        t.start();
        
        setVisible(true);
        
        // for animation 
        int x = 1;
        for (int i = 2; i <= 600; i+=6, x+=1) {
            setLocation(600 - ((i + x)/2), 350 - (i/2));
            setSize(i + 3*x, i + x/2);
            
            try {
                Thread.sleep(10);
            } catch (Exception e) {}
        }        
    }
    
    // for automatic closng
    public void run() {
        try {
            Thread.sleep(7000);
            setVisible(false);
            
            // Next Frame
            new Login();
        } catch (Exception e) {
            
        }
    }
    
    public static void main(String[] args) {
        new Splash();
    }
}
