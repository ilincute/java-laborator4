package Data;

import javax.persistence.Entity;
import javax.persistence.Id;


public class Lecturer {

    public int Id;
    public String Name;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }
    
    
}
