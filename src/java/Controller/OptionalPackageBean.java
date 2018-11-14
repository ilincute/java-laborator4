/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Data.Lecturer;
import Data.OptionalPackage;
import Database.DatabaseController;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Ilinca
 */
@ManagedBean(name = "optionalPackageBean")
@RequestScoped
public class OptionalPackageBean {
   
    DatabaseController databaseController;
    private ArrayList<OptionalPackage> optionalPackages;
    public OptionalPackageBean() throws SQLException, ClassNotFoundException {
        this.databaseController = new DatabaseController();
//        databaseController.InsertCourse();
        this.optionalPackages = databaseController.GetOptionalPackages();
    } 

    public ArrayList<OptionalPackage> getOptionalPackages() {
        return optionalPackages;
    }

    public void setOptionalPackages(ArrayList<OptionalPackage> optionalPackages) {
        this.optionalPackages = optionalPackages;
    }

    

    
    
    
    
}
