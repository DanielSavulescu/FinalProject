import org.DanielSavulescu.Department;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DepartmentTest {

    @Test
    @DisplayName("isDepartmentNameValid: null -> false")
    public void isDepartmentNameValidTest1() {
        String departmentName = null;
        boolean expected = false;
        boolean actual = Department.isDepartmentNameValid(departmentName);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("isDepartmentNameValid: \"\" -> false")
    public void isDepartmentNameValidTest2() {
        String departmentName = "";
        boolean expected = false;
        boolean actual = Department.isDepartmentNameValid(departmentName);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("isDepartmentNameValid: \" \" -> false")
    public void isDepartmentNameValidTest3() {
        String departmentName = " ";
        boolean expected = false;
        boolean actual = Department.isDepartmentNameValid(departmentName);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("isDepartmentNameValid: Computer Science and Mathematics 1 -> false")
    public void isDepartmentNameValidTest4() {
        String departmentName = "Computer Science and Mathematics 1";
        boolean expected = false;
        boolean actual = Department.isDepartmentNameValid(departmentName);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("isDepartmentNameValid: Computer Science and Mathematics -> true")
    public void isDepartmentNameValidTest5() {
        String departmentName = "Computer Science and Mathematics";
        boolean expected = true;
        boolean actual = Department.isDepartmentNameValid(departmentName);

        Assertions.assertEquals(expected, actual);
    }
}
