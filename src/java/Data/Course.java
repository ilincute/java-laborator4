package Data;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Entity;
import javax.persistence.Id;

public class Course {

    public int Id;
    public String Name;
    public Integer YearOfStudy;
    public Integer Semester;
    public Integer LecturerId;
    public String StudyGroup;
    public Integer PackageId;

    public Course() {}

    public Course(String name, Integer yearOfStudy, Integer semester, Integer lecturerId, String studyGroup, Integer packageId) {
        Name = name;
        YearOfStudy = yearOfStudy;
        Semester = semester;
        LecturerId = lecturerId;
        StudyGroup = studyGroup;
        PackageId = packageId;
    }

    public String getName() {
        return Name;
    }

    public Integer getYearOfStudy() {
        return YearOfStudy;
    }

    public Integer getSemester() {
        return Semester;
    }

    public Integer getLecturerId() {
        return LecturerId;
    }

    public String getStudyGroup() {
        return StudyGroup;
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

    public void setLecturerId(Integer lecturerId) {
        LecturerId = lecturerId;
    }

    public void setStudyGroup(String studyGroup) {
        StudyGroup = studyGroup;
    }
}
