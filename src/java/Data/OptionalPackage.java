package Data;

import javax.persistence.Entity;
import javax.persistence.Id;

public class OptionalPackage {
    
    public int Id;
    public String Name;
    public Integer YearOfStudy;
    public Integer Semester;

    public String getName() {
        return Name;
    }

    public Integer getYearOfStudy() {
        return YearOfStudy;
    }

    public Integer getSemester() {
        return Semester;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setYearOfStudy(Integer yearOfStudy) {
        YearOfStudy = yearOfStudy;
    }

    public void setSemester(Integer semester) {
        Semester = semester;
    }
}
