import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.Util;

public class UtilTest {

    @Test
    @DisplayName("toTitleCase: null -> null")
    public void toTitleCaseTest1() {
        String str = null;
        String expected = null;
        String actual = Util.toTitleCase(str);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("toTitleCase: \"\" -> \"\"")
    public void toTitleCaseTest2() {
        String str = "";
        String expected = "";
        String actual = Util.toTitleCase(str);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("toTitleCase: cOmpuTer scIence -> Computer Science")
    public void toTitleCaseTest3() {
        String str = "cOmpuTer scIence";
        String expected = "Computer Science";
        String actual = Util.toTitleCase(str);

        Assertions.assertEquals(expected, actual);
    }
}
