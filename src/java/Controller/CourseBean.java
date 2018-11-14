/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Data.Course;
import Database.DatabaseController;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Ilinca
 */

@ManagedBean(name = "courseBean")
@RequestScoped
public class CourseBean implements Serializable {
    private Course course = new Course("TEST", 223, 1, 1, "a1", 1);
    DatabaseController databaseController;
    private ArrayList<Course> courses;
    public CourseBean() throws SQLException, ClassNotFoundException {
        this.databaseController = new DatabaseController();
//        databaseController.InsertCourse();
        this.courses = databaseController.GetCourses();
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Course getCourse() {
        return course;
    }
    
    
    
    
}
