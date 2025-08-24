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
    @DisplayName("ทดสอบการหานักเรียนจาก Id (เจอ)")
    void testFindStudentByID_Found() {
        studentList.addNewStudent("66xxxxxxxx", "Steve Miller", 15.00);
        Student found = studentList.findStudentById("66xxxxxxxx");
        assertNotNull(found);
        assertEquals("Steve Miller", found.getName());
        // assertEquals(15.00, found.getScore());
    }

    @Test
    @DisplayName("ทดสอบการหานักเรียนจาก Id (ไม่เจอ)")
    void testFindStudentByID_NotFound() {
        Student found = studentList.findStudentById("69xxxxxxxx"); // 69xxxxxxxx is not existed
        assertNull(found);
    }

    @Test
    @DisplayName("ทดสอบการกรองหานักเรียนจากชื่อ")
    void testFilterByName() {
        studentList.addNewStudent("661xxxxxxx", "Marty Friedman");
        studentList.addNewStudent("671xxxxxxx", "Layne Staley");
        StudentList filter = studentList.filterByName("Friedman");
        assertEquals(1, filter.getStudents().size()); // used .size() to show that how many students were found
        assertEquals("Marty Friedman", filter.getStudents().get(0).getName()); // get(0) -> pull the first index then compare the name
    }

    @Test
    @DisplayName("ทดสอบการให้คะแนนผ่าน ID")
    void testGiveScoreToId() {
        studentList.addNewStudent("66xxxxxxxx", "Steve Miller");
        studentList.giveScoreToId("66xxxxxxxx", 50.00);
        assertEquals(50.00, studentList.findStudentById("66xxxxxxxx").getScore());
    }

    @Test
    @DisplayName("ทดสอบระบบดูเกรดผ่าน Id")
    void testViewGradeOfId() {
        studentList.addNewStudent("66xxxxxxxx", "Steve Miller", 75.00);
        assertEquals("B", studentList.viewGradeOfId("66xxxxxxxx"));
    }

}