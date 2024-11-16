
package model;

public class Suplier extends Person{
    private String city;
    private String date;
    private String Name;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public Suplier(String city, String date, String Name, String typePerson) {
        super(typePerson);
        this.city = city;
        this.date = date;
        this.Name = Name;
    }
 
    }
    
    

