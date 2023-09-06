import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    Person testGuy;
    @BeforeEach
    void setUp() {
        testGuy = new Person("000001","Test","Guy","Sir",1984);
    }

    @org.junit.jupiter.api.Test
    void setID() {
        testGuy.setID("000002");
        assertEquals("000002",testGuy.getID());
    }

    @org.junit.jupiter.api.Test
    void setFirstName() {
        testGuy.setFirstName("Hank");
        assertEquals("Hank",testGuy.getFirstName());
    }

    @org.junit.jupiter.api.Test
    void setLastName() {
        testGuy.setLastName("Hernandez");
        assertEquals("Hernandez",testGuy.getLastName());
    }

    @org.junit.jupiter.api.Test
    void setTitle() {
        testGuy.setTitle("Dr.");
        assertEquals("Dr.",testGuy.getTitle());
    }

    @org.junit.jupiter.api.Test
    void setYOB() {
        testGuy.setYOB(1987);
        assertEquals(1987,testGuy.getYOB());
    }

    @org.junit.jupiter.api.Test
    void fullName() {
        assertEquals("Test Guy",testGuy.fullName());
    }

    @org.junit.jupiter.api.Test
    void formalName() {
        assertEquals("Sir Test Guy",testGuy.formalName());
    }

    @org.junit.jupiter.api.Test
    void getAge() {
        assertEquals("39",testGuy.getAge());
    }

    @org.junit.jupiter.api.Test
    void testGetAge() {
        assertEquals("5",testGuy.getAge(1989));
    }

    @org.junit.jupiter.api.Test
    void toCSVDataRecord() {
        assertEquals("000001,Test,Guy,Sir,1984",testGuy.toCSVDataRecord());
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        assertEquals("Person{ID='000001', firstName='Test', lastName='Guy', title='Sir', YOB=1984}",testGuy.toString());
    }

}