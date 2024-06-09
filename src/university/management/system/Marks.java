package university.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class Marks extends JFrame implements ActionListener {

    String rollno;
    JButton cancel;
    JComboBox cbsemester;
    JLabel sub1, sub2, sub3, sub4, sub5, TotalMarks, Percentage;
    DAOLayer dao = new DAOLayer();

    Marks(String rollno) throws SQLException {
        setUndecorated(true);
        
        this.rollno = rollno;

        setSize(500, 600);
        setLocation(500, 100);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("   CCS University");
        heading.setBounds(100, 10, 500, 25);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(heading);

        JLabel subheading = new JLabel("Result of Examination 2024");
        subheading.setBounds(100, 50, 500, 20);
        subheading.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(subheading);

        JLabel lblrollno = new JLabel("Roll Number " + rollno);
        lblrollno.setBounds(60, 100, 500, 20);
        lblrollno.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblrollno);

        JLabel lblsemester = new JLabel("Semester");
        lblsemester.setBounds(60, 130, 300, 20);
        lblsemester.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblsemester);

        String Semester[] = {"Semester 1", "Semester 2", "Semester 3", "Semester 4", "Semester 5", "Semester 6", "Semester 7", "Semester 8"};
        cbsemester = new JComboBox(Semester);
        cbsemester.setBounds(200, 130, 150, 20);
        cbsemester.setBackground(Color.WHITE);
        cbsemester.addActionListener(this);
        add(cbsemester);

        sub1 = new JLabel();
        sub1.setBounds(100, 200, 500, 20);
        sub1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(sub1);

        sub2 = new JLabel();
        sub2.setBounds(100, 230, 500, 20);
        sub2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(sub2);

        sub3 = new JLabel();
        sub3.setBounds(100, 260, 500, 20);
        sub3.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(sub3);

        sub4 = new JLabel();
        sub4.setBounds(100, 290, 500, 20);
        sub4.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(sub4);

        sub5 = new JLabel();
        sub5.setBounds(100, 320, 500, 20);
        sub5.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(sub5);

        TotalMarks = new JLabel();
        TotalMarks.setBounds(100, 360, 500, 20);
        TotalMarks.setFont(new Font("serif", Font.BOLD, 20));
        add(TotalMarks);

        Percentage = new JLabel();
        Percentage.setBounds(100, 400, 500, 20);
        Percentage.setFont(new Font("serif", Font.BOLD, 20));
        add(Percentage);

        try {
            FetchResults();
        } catch (Exception e) {
            e.printStackTrace();
        }
        

        cancel = new JButton("Back");
        cancel.setBounds(250, 500, 120, 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==cancel){
            setVisible(false);
        }
        else if(ae.getSource() == cbsemester){
            try {
                FetchResults();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void FetchResults() throws SQLException{
        String semester = (String) cbsemester.getSelectedItem();
        ResultSet rs1 = dao.FetchResult("subject", rollno, semester);
        while (rs1.next()) {
            sub1.setText(rs1.getString("subject1"));
            sub2.setText(rs1.getString("subject2"));
            sub3.setText(rs1.getString("subject3"));
            sub4.setText(rs1.getString("subject4"));
            sub5.setText(rs1.getString("subject5"));
        }
        
        ResultSet rs2 = dao.FetchResult("marks", rollno, semester);
        while (rs2.next()) {
            sub1.setText(sub1.getText() + "------------" + rs2.getString("marks1"));
            sub2.setText(sub2.getText() + "------------" + rs2.getString("marks2"));
            sub3.setText(sub3.getText() + "------------" + rs2.getString("marks3"));
            sub4.setText(sub4.getText() + "------------" + rs2.getString("marks4"));
            sub5.setText(sub5.getText() + "------------" + rs2.getString("marks5"));

            int marks1 = Integer.parseInt(rs2.getString("marks1"));
            int marks2 = Integer.parseInt(rs2.getString("marks2"));
            int marks3 = Integer.parseInt(rs2.getString("marks3"));
            int marks4 = Integer.parseInt(rs2.getString("marks4"));
            int marks5 = Integer.parseInt(rs2.getString("marks5"));

            int total = marks1 + marks2 + marks3 + marks4 + marks5;
            float percentage = (float) total / 5;
            String formattedPercentage = String.format("%.2f", percentage);
            TotalMarks.setText("Total Marks          =    " + total);
            Percentage.setText("Percentage     =    " + formattedPercentage);
        }
    }
    
   
}
