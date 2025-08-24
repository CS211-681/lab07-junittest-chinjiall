package ku.cs.services;

import ku.cs.models.Student;
import ku.cs.models.StudentList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentHardCodeDatasourceTest {
    private StudentHardCodeDatasource datasource;

    @BeforeEach
    void setup() {
        datasource = new StudentHardCodeDatasource();
    }

    @Test
    @DisplayName("ทดสอบการอ่านไฟล์นักเรียนจำนวน 4 คน")
    void testReadData_Size() {
        StudentList list = datasource.readData();
    }

    @Test
    @DisplayName("ทดสอบการ add นักเรียน")
    void testReadData() {
        StudentList list = datasource.readData();

        Student first = list.findStudentById("6710400001");
        assertNotNull(first);
        assertEquals("First", first.getName());

        Student second = list.findStudentById("6710400002");
        assertNotNull(second);
        assertEquals("Second", second.getName());

        Student third = list.findStudentById("6710400003");
        assertNotNull(third);
        assertEquals("Third", third.getName());

        Student fourth = list.findStudentById("6710400004");
        assertNotNull(fourth);
        assertEquals("Fourth", fourth.getName());
    }
}