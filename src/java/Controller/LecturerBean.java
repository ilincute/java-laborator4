/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Data.Course;
import Data.Lecturer;
import Database.DatabaseController;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Ilinca
 */
@ManagedBean(name = "lecturerBean")
@RequestScoped
public class LecturerBean {

    DatabaseController databaseController;
    private ArrayList<Lecturer> lecturers;
    public LecturerBean() throws SQLException, ClassNotFoundException {
        this.databaseController = new DatabaseController();
//        databaseController.InsertCourse();
        this.lecturers = databaseController.GetLecturers();
    }

    public ArrayList<Lecturer> getLecturers() {
        return lecturers;
    }

    public void setLecturers(ArrayList<Lecturer> lecturers) {
        this.lecturers = lecturers;
    }
    
    
}
