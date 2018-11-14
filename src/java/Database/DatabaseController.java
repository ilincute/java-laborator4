package Database;

import Data.Course;
import Data.Lecturer;
import Data.OptionalPackage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class DatabaseController {
    String url = "jdbc:mysql://localhost:3306/laborator4";
    String username = "root";
    String password = "";
    protected Connection connectionToDatabase;

    public DatabaseController() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        connectionToDatabase = DriverManager.getConnection(url, username, password);
    }
//    public void ConnectToDatabase() throws ClassNotFoundException {
//        Class.forName("com.mysql.jdbc.Driver");
//
//
//
//        try (
//                Connection connection = DriverManager.getConnection(url, username, password)) {
//            connectionToDatabase = connection;
//            System.out.println("Database connected!");
//        } catch (SQLException e) {
//            throw new IllegalStateException("Cannot connect the database!", e);
//        }
//    }

    public void InsertPackage() throws SQLException {
        String csvFile = "D:/Facultate/Master/Tehnologii Java/Laborator4.4_modificat/Laborator4.4/src/Database/pachete.csv"; //va trebui sa descarci si tu fisierele si sa pui calea din laptopul tau
        String line = "";
        String csvSplitBy = ",";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {
                Statement stmt = connectionToDatabase.createStatement();

                String[] pachete = line.split(csvSplitBy);
                String query = String.format("INSERT INTO `packages` (`Name`, `YearOfStudy`, `Semester`) VALUES (\"%s\", \"%s\", \"%s\")", pachete[0], pachete[1], pachete[2]);
                stmt.execute(query);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<OptionalPackage> GetPackages() throws SQLException {

        ArrayList<OptionalPackage> packages = new ArrayList<>();
        Statement stmt = connectionToDatabase.createStatement();
        String query = String.format("SELECT * FROM `packages`");
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next())
        {
            OptionalPackage optionalPackage  = new OptionalPackage();
            String name = rs.getString("Name");
            int yearOfStudy = rs.getInt("YearOfStudy");
            int semester = rs.getInt("Semester");

            optionalPackage.Name = name;
            optionalPackage.YearOfStudy = yearOfStudy;
            optionalPackage.Semester = semester;

            packages.add(optionalPackage);
        }
        return packages;
    }

    public void InsertLecturer() throws SQLException, ClassNotFoundException {
        String csvFile = "D:/Facultate/Master/Tehnologii Java/Laborator4.4_modificat/Laborator4.4/src/Database/discipline.csv";
        String line = "";
        String csvSplitBy = ",";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {
                Statement stmt = connectionToDatabase.createStatement();

                String[] lectures = line.split(csvSplitBy);
                if(lectures[5] != null) {
                    String query = String.format("INSERT INTO `lecturers` (Name) VALUES (\"%s\")", lectures[5]);
                    stmt.execute(query);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<Lecturer> GetLecturers() throws SQLException {
        ArrayList<Lecturer> lecturers = new ArrayList<>();
        Statement stmt = connectionToDatabase.createStatement();
        String query = String.format("SELECT * FROM `lecturers`");
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next())
        {
            Lecturer lecturer  = new Lecturer();
            String name = rs.getString("Name");
            int lecturerId = rs.getInt("Id");

            lecturer.Name = name;
            lecturer.Id = lecturerId;

            lecturers.add(lecturer);
        }
        return lecturers;
    }

    public void InsertCourse() throws SQLException {
        String csvFile = "D:/Facultate/Master/Tehnologii Java/NetBeans/Laborator4/Laborator4/src/java/Database/discipline.csv";
        String line = "";
        String csvSplitBy = ",";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {
                Statement stmt = connectionToDatabase.createStatement();

                String[] courses = line.split(csvSplitBy);
                String query = String.format("INSERT INTO `courses` (`Name`, `YearOfStudy`, `Semester`, `LecturerId`, `StudyGroup`, `PackageId`) VALUES (\"%s\",  \"%s\",  \"%s\",  \"%s\",  \"%s\",  \"%s\")", courses[2], courses[3], courses[4], courses[5], courses[8], courses[7]);
                stmt.execute(query);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Course> GetCourses() throws SQLException {
        ArrayList<Course> courses = new ArrayList<>();
        Statement stmt = connectionToDatabase.createStatement();
        String query = String.format("SELECT * FROM `courses`");
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next())
        {
            Course course  = new Course();
            String name = rs.getString("Name");
            int yearOfStudy = rs.getInt("YearOfStudy");
            int semester = rs.getInt("Semester");
            int lecturerId = rs.getInt("LecturerId");
            String studyGroup = rs.getString("StudyGroup");
            int packageId = rs.getInt("PackageId");

            course.Name = name;
            course.YearOfStudy = yearOfStudy;
            course.Semester = semester;
            course.LecturerId = lecturerId;
            course.StudyGroup = studyGroup;
            course.PackageId = packageId;
            // print the results
            courses.add(course);
        }
       return courses;
    }
    
    public ArrayList<OptionalPackage> GetOptionalPackages() throws SQLException {
        ArrayList<OptionalPackage> optionalPackages = new ArrayList<>();
        Statement stmt = connectionToDatabase.createStatement();
        String query = String.format("SELECT * FROM `packages`");
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next())
        {
            OptionalPackage optionalPackage  = new OptionalPackage();
            String name = rs.getString("Name");
            int yearOfStudy = rs.getInt("YearOfStudy");
            int semester = rs.getInt("Semester");

            optionalPackage.Name = name;
            optionalPackage.YearOfStudy = yearOfStudy;
            optionalPackage.Semester = semester;
            // print the results
            optionalPackages.add(optionalPackage);
        }
       return optionalPackages;
    }
}
