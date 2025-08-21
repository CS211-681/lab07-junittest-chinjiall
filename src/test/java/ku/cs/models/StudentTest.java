package ku.cs.models;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    static Student s;
    // create signature test methods
    @BeforeAll // runs 1 time before test
    static void init() {
        // s = new Student("67xxxxxxxx", "Test" ); : this will be use in the whole test program
    }

    @BeforeEach // runs everytime when test is called
    void setup() {
        s = new Student("67xxxxxxxx", "Test" );
    }

    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน 45.15")
    void testAddScore() {
        // Student s = new Student("67xxxxxxxx", "Test" );
        s.addScore(80.00);
        assertEquals(80.00, s.getScore()); // compare 2 values, including expected value, real value.

    }

    @Test
    @DisplayName("ทดสอบการคำนวณเกรด")
    void testCalculateGrade() {
        // Student s = new Student("67xxxxxxxx", "Test" );
        s.addScore(1);
        assertEquals("F", s.grade());
    }

    @Test
    @DisplayName("ทดสอบ method isID, return bool type")
    void testIsID() {
        String id = "67xxxxxxxx";
        s.isId(id);
        assertEquals(true, s.isId(id));
    }

    @Test
    @DisplayName("ทดสอบ method isNameContains, return bool type")
    void testIsNameContains() {
        String name = "Test"; // s's name is "Test"
        s.isNameContains(name);
        assertEquals(true, s.isNameContains(name));
    }

    @Test
    @DisplayName("ทดสอบ method changeName")
    void testChangeName() {
        String name = "Lebron James";
        s.changeName(name);
        assertEquals("Lebron James", s.getName());
    }

}