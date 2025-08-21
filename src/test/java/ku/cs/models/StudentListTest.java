package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentListTest {
    static StudentList studentList;
    static Student student;

    @BeforeEach
    void setup() {
        studentList = new StudentList();
        student = new Student("67xxxxxxxx", "Test");
    }

    @Test
    @DisplayName("ทดสอบการเพิ่มนักเรียนคนใหม่ --included overload method")
    void testAddNewStudent() {
        studentList.addNewStudent("66xxxxxxxx", "Steve Miller", 15.00);
        assertEquals(true, studentList.findStudentById("66xxxxxxxx").isId("66xxxxxxxx"));
        assertEquals(true, studentList.findStudentById("66xxxxxxxx").isNameContains("Steve Miller"));
        assertEquals(15.00, studentList.findStudentById("66xxxxxxxx").getScore());
    }

    @Test
    @DisplayName("การหานักเรียนจาก Id")
    void testFindStudentByID() {
        String id

    }


}