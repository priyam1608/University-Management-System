package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class FeeStructure extends JFrame implements ActionListener{

    DAOLayer dao = new DAOLayer();

    FeeStructure() {
        setUndecorated(true);
        
        setSize(1000, 450);
        setLocation(250, 50);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/FeesIcon.png"));
        Image i2 = i1.getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(800,0,120,120);
        add(image);

        JLabel heading = new JLabel("Fee Structure");
        heading.setBounds(50, 40, 400, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(heading);

        JTable table = new JTable();
        ResultSet rs = dao.FetchFeeStructure();
        table.setModel(DbUtils.resultSetToTableModel(rs));

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 125, 1000, 500);
        add(jsp);

        JButton cancel = new JButton("Back");
        cancel.setBounds(450, 40, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
    }
}
