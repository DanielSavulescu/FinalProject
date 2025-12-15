package util;

public class Util {

    /**
     * converts a string to title case
     * @param str the original string
     * @return the original string converted into title case
     */
    public static String toTitleCase(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        String[] words = str.split(" ");
        String strToTitleCase = "";

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (!word.isEmpty()) {
                String firstChar = word.substring(0, 1).toUpperCase();
                String restOfString = "";
                if (word.length() > 1) {
                    restOfString += word.substring(1).toLowerCase();
                }
                strToTitleCase += firstChar + restOfString;
            }

            if (i < words.length - 1) {
                strToTitleCase += " ";
            }
        }

        return strToTitleCase;
    }
}
