import java.util.Calendar;
import java.util.Calendar.Builder;
import java.util.ArrayList.*;
public class Person {
    private String ID;
    private String firstName;
    private String lastName;
    private String title;  // a prefix: Mr. Mrs. Ms, Prof. Dr. Hon. Etc.
    private int YOB;  // Year of birth, Range should be 1940 - 2000

    private Calendar Calendar;
    private Calendar.Builder Builder = new Builder();

    public Person(String ID, String firstName, String lastName, String title, int YOB) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.YOB = YOB;
        this.Builder.setDate(this.YOB,1,1); //creates a date from YOB, assuming Jan. 1st
        this.Calendar = this.Builder.build(); //creates a Calendar for getAge()
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYOB() {
        return YOB;
    }

    public void setYOB(int YOB) {
        this.YOB = YOB;
    }

    public String fullName(){ //returns firstName space lastName
        return this.firstName + " " + this.lastName;
    }

    public String formalName(){ //returns title space fullName
        return this.title + " " + this.fullName();
    }

    public String getAge(){ //assumes current year
        Calendar now = java.util.Calendar.getInstance(); //new Calendar object with current time
        return this.getAge(now.get(java.util.Calendar.YEAR)); //calls getAge with the current year
    }

    public String getAge(int year){ // uses YOB to calculate age for a specified year
        return Integer.toString(year - Calendar.get(Calendar.YEAR));
    }

    public String toCSVDataRecord(){
        return this.ID + "," + this.firstName + "," + this.lastName + "," + this.title + "," + Integer.toString(this.YOB);
    }

    @Override
    public String toString() {
        return "Person{" +
                "ID='" + ID + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", title='" + title + '\'' +
                ", YOB=" + YOB +
                '}';
    }
}
