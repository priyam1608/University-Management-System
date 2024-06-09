package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class About extends JFrame implements ActionListener {

    About() {
        setUndecorated(true);
        
        setSize(700, 500);
        setLocation(400, 150);
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/about.jpg"));
        Image i2 = i1.getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 300, 200);
        add(image);
        
        JLabel heading = new JLabel("<html>University<br/>Management System</html>");
        heading.setBounds(70, 20, 300, 130);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(heading);
        
        JLabel name = new JLabel("<html>Developed By: -<br> <ul><li>Priyam Sharma - 210613106184 </li> <li>Vaishnavi Chauhan - 210613106276</li><li>Varsha Kumari - 210613106280</li></ul></html>");
        name.setBounds(70, 200, 350, 97);
        name.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(name);
        
        JLabel dept = new JLabel("Department: Bachelors of Computer Applications (BCA)");
        dept.setBounds(70, 310, 500, 20);
        dept.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(dept);
        
        JLabel clg = new JLabel("College: IIMT College of Management, Greater Noida");
        clg.setBounds(70, 340, 500, 20);
        clg.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(clg);
        
        JLabel contact = new JLabel("Contact: sharmapriyam1608@gmail.com");
        contact.setBounds(70, 400, 550, 40);
        contact.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(contact);
        
        JButton cancel = new JButton("Back");
        cancel.setBounds(500, 450, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);
        
        setLayout(null);
        
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
    }
    
}
