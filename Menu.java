import java.sql.*;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {

        Scanner obj = new Scanner(System.in);
        int choice;


        while(true){
            System.out.println("Select the option below: ");
            System.out.println("1. Insert");
            System.out.println("2. Select");
            System.out.println("3. Search");
            System.out.println("4. Update");
            System.out.println("5. Delete");
            System.out.println("6. Exit");

//            Scanner obj = new Scanner(System.in);
//            int choice = obj.nextInt();
            choice = obj.nextInt();

            switch (choice){
                case 1:
                    System.out.println("Insert the data");
                    System.out.println("Enter the name of the student");
                    String name = obj.next();
                    System.out.println("Enter the admission number of the student");
                    int admin = obj.nextInt();
                    System.out.println("Enter the roll number of the student ");
                    int rollNo = obj.nextInt();
                    System.out.println("Enter the college name of the student ");
                    String collegeName = obj.next();
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db","root","");
                        String sql = "INSERT INTO `students`(`name`, `admNo`, `rollNo`, `collage`) VALUES (?,?,?,?)";
                        PreparedStatement stmt = con.prepareStatement(sql);
                        stmt.setString(1,name);
                        stmt.setInt(2,admin);
                        stmt.setInt(3,rollNo);
                        stmt.setString(4,collegeName);
                        stmt.executeUpdate();

                    }
                    catch (Exception e){
                        System.out.println((e));
                    }
                    //String sql = "INSERT INTO `students`(`name`, `admNo`, `rollNo`, `collage`) VALUES ('"+name+"','"+admin+"','"+rollNo+"','"+collegeName+"')";
                    break;
                case 2:
                    System.out.println("View the details of the student");
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db", "root", "");
                        String sql = "SELECT `name`, `admNo`, `rollNo`, `collage` FROM `students` ";
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(sql);
                        while (rs.next()){
                            String getName = rs.getString("name");
                            String getAdm = rs.getString("admNo");
                            String getRoll = rs.getString("rollNo");
                            String getCollege = rs.getString("collage");
                            System.out.println("Name="+getName);
                            System.out.println("Admission Number ="+getAdm);
                            System.out.println("Roll Number="+getRoll);
                            System.out.println("College="+getCollege+"\n");
                        }
                    }
                    catch (Exception e){
                        System.out.println((e));
                    }
                    break;
                case 3:
                    System.out.println("Search the data");
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db", "root", "");
                        System.out.println("Enter the admission number of the student to be searched");
                        int admno = obj.nextInt();
                        String sql = "SELECT `name`, `admNo`, `rollNo`, `collage` FROM `students` WHERE `admNo`= "+String.valueOf(admno);
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(sql);
                        while (rs.next()){
                            String getName = rs.getString("name");
                            String getAdm = rs.getString("admNo");
                            String getRoll = rs.getString("rollNo");
                            String getCollege = rs.getString("collage");
                            System.out.println("Name="+getName);
                            System.out.println("Admission Number ="+getAdm);
                            System.out.println("Roll Number="+getRoll);
                            System.out.println("College="+getCollege+"\n");
                        }
                    }
                    catch (Exception e){
                        System.out.println((e));
                    }
                    break;
                case 4:
                    System.out.println("Update the data");
                    break;
                case 5:
                    System.out.println("Delete the data");
                    break;
                case 6:
                    //break;
                    System.exit(0);
            }
        }
    }

}
