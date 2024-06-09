package university.management.system;

import javax.swing.JOptionPane;
import java.sql.*;

public class DAOLayer {
// All Database Interaction Done Here
    Conn conn = new Conn();

    public ResultSet LoginAuthentication(String username, String password) {
        try {
            String query = "select * from login where username='" + username + "' and password='" + password + "'";
            return conn.s.executeQuery(query);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void AddDetails(String user, String name, String fname, String id, String dob, String address, String phone, String email, String x, String xii, String aadhar, String course, String branch) {
        if (user == "student") {
            try {
                String query = "insert into student values('" + name + "', '" + fname + "', '" + id + "', '" + dob + "', '" + address + "', '" + phone + "', '" + email + "', '" + x + "', '" + xii + "', '" + aadhar + "', '" + course + "', '" + branch + "')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Student Details Inserted Successfully");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (user == "teacher") {
            try {
                String query = "insert into teacher values('" + name + "', '" + fname + "', '" + id + "', '" + dob + "', '" + address + "', '" + phone + "', '" + email + "', '" + x + "', '" + xii + "', '" + aadhar + "', '" + course + "', '" + branch + "')";

                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Teacher Details Inserted Successfully");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public ResultSet FetchDetails(String user) {
        if (user == "student") {
            try {
                return conn.s.executeQuery("select * from student");
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else if (user == "teacher") {
            try {
                return conn.s.executeQuery("select * from teacher");
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else {
            System.out.println("DAO user error");
            return null;
        }

    }

    public ResultSet FetchDetails(String user, String id) {
        if (user == "student") {
            try {
                String query = "select * from student where rollno = '" + id + "'";
                return conn.s.executeQuery(query);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else if (user == "teacher") {
            try {
                String query = "select * from teacher where empid = '" + id + "'";
                return conn.s.executeQuery(query);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else {
            System.out.println("DAO user error");
            return null;
        }

    }

    public void AddLeavedetails(String user, String id, String date, String duration) {
        if (user == "student") {
            String query = "insert into studentleave values('" + id + "', '" + date + "', '" + duration + "')";
            try {
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Leave Confirmed");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (user == "teacher") {
            String query = "insert into teacherleave values('" + id + "', '" + date + "', '" + duration + "')";
            try {
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Leave Confirmed");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public ResultSet FetchLeavedetails(String user) {
        if (user == "student") {
            try {
                return conn.s.executeQuery("select * from studentleave");
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else if (user == "teacher") {
            try {
                return conn.s.executeQuery("select * from teacherleave");
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else {
            System.out.println("DAO user error");
            return null;
        }
    }

    public ResultSet FetchLeavedetails(String user, String id) {
        if (user == "student") {
            String query = "select * from studentleave where rollno = '" + id + "'";
            try {
                return conn.s.executeQuery(query);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else if (user == "teacher") {
            String query = "select * from teacherleave where rollno = '" + id + "'";
            try {
                return conn.s.executeQuery(query);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else {
            System.out.println("DAO user error");
            return null;
        }
    }

    public void UpdateDetails(String user, String address, String phone, String email, String course, String branch, String id) {
        if (user == "student") {
            try {
                String query = "update student set address='" + address + "', phone='" + phone + "', email='" + email + "', course='" + course + "', branch='" + branch + "' where rollno='" + id + "'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Student Details Updated Successfully");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (user == "teacher") {
            try {
                String query = "update teacher set address='" + address + "', phone='" + phone + "', email='" + email + "', education='" + course + "', department='" + branch + "' where empId='" + id + "'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Teacher Details Updated Successfully");
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public void AddSubjectMarks(String rollno, String semester, String sub1, String sub2, String sub3, String sub4, String sub5, String marks1, String marks2, String marks3, String marks4, String marks5) {
        try {
            String query1 = "insert into subject values('" + rollno + "', '" + semester + "', '" + sub1 + "', '" + sub2 + "', '" + sub3 + "', '" + sub4 + "', '" + sub5 + "')";
            String query2 = "insert into marks values('" + rollno + "', '" + semester + "', '" + marks1 + "', '" + marks2 + "', '" + marks3 + "', '" + marks4 + "', '" + marks5 + "')";
            conn.s.executeUpdate(query1);
            conn.s.executeUpdate(query2);
            JOptionPane.showMessageDialog(null, "Marks Inserted Sucessfully");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public ResultSet FetchResult(String source,String rollno,String semester){
        if(source == "subject"){
            try {
            return  conn.s.executeQuery("select * from subject where rollno = '"+rollno+"' and semester ='"+semester+"'");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        }
        else if(source == "marks"){
            try {
                return conn.s.executeQuery("select * from marks where rollno = '"+rollno+"' and semester ='"+semester+"'");
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        else{
            System.out.println("DAO Source error");
            return null;
        }
    }
    
    public ResultSet FetchFeeStructure(){
        try {
            return conn.s.executeQuery("select * from fee");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResultSet FetchCourseFee(String course){
        try {
            return conn.s.executeQuery("select * from fee where course = '"+course+"'");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public void AddFeeRecord(String rollno,String course,String branch,String semester,String total){
        try {
            String query = "insert into collegefee values('"+rollno+"', '"+course+"', '"+branch+"', '"+semester+"', '"+total+"')";
            conn.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "College fee submitted successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
}
