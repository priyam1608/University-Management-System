package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Project extends JFrame implements ActionListener {

    Project() {
        setTitle("University Management System");
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        setIconImage(icon.getImage());
        
        setSize(1600, 850);

//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Main1.jpg"));
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/college1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1600, 800, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        JMenuBar mb = new JMenuBar();
        mb.setPreferredSize(new Dimension(mb.getPreferredSize().width, 60));
        mb.add(Box.createRigidArea(new Dimension(20, 0)));

        // New Information
        JMenu newInformation = new JMenu("New Information");
        newInformation.setForeground(Color.BLUE);
        mb.add(newInformation);

        JMenuItem facultyInfo = new JMenuItem("New Faculty Information");
        facultyInfo.setBackground(Color.WHITE);
        facultyInfo.addActionListener(this);
        newInformation.add(facultyInfo);

        JMenuItem studentInfo = new JMenuItem("New Student Information");
        studentInfo.setBackground(Color.WHITE);
        studentInfo.addActionListener(this);
        newInformation.add(studentInfo);
        
        // Details
        JMenu details = new JMenu("View Details");
        details.setForeground(Color.RED);
        mb.add(details);

        JMenuItem facultydetails = new JMenuItem("View Faculty Details");
        facultydetails.setBackground(Color.WHITE);
        facultydetails.addActionListener(this);
        details.add(facultydetails);

        JMenuItem studentdetails = new JMenuItem("View Student Details");
        studentdetails.setBackground(Color.WHITE);
        studentdetails.addActionListener(this);
        details.add(studentdetails);

        // Leave
        JMenu leave = new JMenu("Apply Leave");
        leave.setForeground(Color.BLUE);
        mb.add(leave);

        JMenuItem facultyleave = new JMenuItem("Faculty Leave");
        facultyleave.setBackground(Color.WHITE);
        facultyleave.addActionListener(this);
        leave.add(facultyleave);

        JMenuItem studentleave = new JMenuItem("Student Leave");
        studentleave.setBackground(Color.WHITE);
        studentleave.addActionListener(this);
        leave.add(studentleave);

        // Leave Details
        JMenu leaveDetails = new JMenu("Leave Details");
        leaveDetails.setForeground(Color.RED);
        mb.add(leaveDetails);

        JMenuItem facultyleavedetails = new JMenuItem("Faculty Leave Details");
        facultyleavedetails.setBackground(Color.WHITE);
        facultyleavedetails.addActionListener(this);
        leaveDetails.add(facultyleavedetails);

        JMenuItem studentleavedetails = new JMenuItem("Student Leave Details");
        studentleavedetails.setBackground(Color.WHITE);
        studentleavedetails.addActionListener(this);
        leaveDetails.add(studentleavedetails);

        // Exams
        JMenu exam = new JMenu("Examination");
        exam.setForeground(Color.BLUE);
        mb.add(exam);

        JMenuItem examinationdetails = new JMenuItem("Examination Results");
        examinationdetails.setBackground(Color.WHITE);
        examinationdetails.addActionListener(this);
        exam.add(examinationdetails);

        JMenuItem entermarks = new JMenuItem("Enter Marks");
        entermarks.setBackground(Color.WHITE);
        entermarks.addActionListener(this);
        exam.add(entermarks);

        // UpdateInfo
        JMenu updateInfo = new JMenu("Update Details");
        updateInfo.setForeground(Color.RED);
        mb.add(updateInfo);

        JMenuItem updatefacultyinfo = new JMenuItem("Update Faculty Details");
        updatefacultyinfo.setBackground(Color.WHITE);
        updatefacultyinfo.addActionListener(this);
        updateInfo.add(updatefacultyinfo);

        JMenuItem updatestudentinfo = new JMenuItem("Update Student Details");
        updatestudentinfo.setBackground(Color.WHITE);
        updatestudentinfo.addActionListener(this);
        updateInfo.add(updatestudentinfo);

        // fee
        JMenu fee = new JMenu("Fee Details");
        fee.setForeground(Color.BLUE);
        mb.add(fee);

        JMenuItem feestructure = new JMenuItem("Fee Structure");
        feestructure.setBackground(Color.WHITE);
        feestructure.addActionListener(this);
        fee.add(feestructure);

        JMenuItem feeform = new JMenuItem("Student Fee Form");
        feeform.setBackground(Color.WHITE);
        feeform.addActionListener(this);
        fee.add(feeform);

        // Utility
        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.RED);
        mb.add(utility);

        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setBackground(Color.WHITE);
        notepad.addActionListener(this);
        utility.add(notepad);

        JMenuItem calc = new JMenuItem("Calculator");
        calc.setBackground(Color.WHITE);
        calc.addActionListener(this);
        utility.add(calc);

        // about
        JMenu about = new JMenu("About");
        about.setForeground(Color.BLUE);
        mb.add(about);

        JMenuItem ab = new JMenuItem("About");
        ab.setBackground(Color.WHITE);
        ab.addActionListener(this);
        about.add(ab);

        // exit
        JMenu exit = new JMenu("Exit");
        exit.setForeground(Color.RED);
        mb.add(exit);

        JMenuItem ex = new JMenuItem("Exit");
        ex.setBackground(Color.WHITE);
        ex.addActionListener(this);
        exit.add(ex);

        setJMenuBar(mb);

        setVisible(true);
    }
     
    public void actionPerformed(ActionEvent ae) {
        String msg = ae.getActionCommand();
        switch (msg) {
            case "Exit":
                setVisible(false);
                break;
           
            case "Calculator":
            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception e) {
                e.printStackTrace();
            }break;
            
            case "Notepad":
            try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception e) {
                e.printStackTrace();
            } break;
            
            case "New Faculty Information":
                new AddTeacher();
                break;
            
            case "New Student Information":
                new AddStudent();
                break;
                
            case "View Faculty Details":
                try {
                new TeacherDetails();
            } catch (Exception e) {
                e.printStackTrace();
            }break;
                
            case "View Student Details":
                try {
                new StudentDetails();
            } catch (Exception e) {
                e.printStackTrace();
            }break;
                
            case "Faculty Leave":
                try {
                new TeacherLeave();
            } catch (Exception e) {
                e.printStackTrace();
            }break;
            
            case "Student Leave":
                try {
                 new StudentLeave();
            } catch (Exception e) {
                e.printStackTrace();
            }break;
            
            case "Faculty Leave Details":
                try {
                new TeacherLeaveDetails();
            } catch (Exception e) {
                e.printStackTrace();
            } break;
            
            case "Student Leave Details":
                try {
                new StudentLeaveDetails();
            } catch (Exception e) {
                e.printStackTrace();
            }break;
            
            case "Update Faculty Details":
                try {
                new UpdateTeacher();
            } catch (Exception e) {
                e.printStackTrace();
            }break;
            
            case "Update Student Details":
                try {
                new UpdateStudent();
            } catch (Exception e) {
                e.printStackTrace();
            }break;
            
            case "Enter Marks":
                try {
                 new EnterMarks();
            } catch (Exception e) {
                e.printStackTrace();
            } break;
            
            case "Examination Results":
                new ExaminationDetails();
                break;
            
            case "Fee Structure":
                new FeeStructure();
                break;
            
            case "About":
                new About();
                break;
           
            case "Student Fee Form":
                try {
                new StudentFeeForm();
            } catch (Exception e) {
                e.printStackTrace();
            }break;
        }
    }
}
