package org.DanielSavulescu;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import util.Util;

@ToString
@EqualsAndHashCode
@Getter
public class Department {
    private String departmentId;
    @Setter
    private String departmentName;

    private static int nextId = 1;

    public Department(String departmentName) {

        if (isDepartmentNameValid(departmentName)) {
            this.departmentId = String.format("D%02d", nextId++);
            this.departmentName = Util.toTitleCase(departmentName);
        } else {
            this.departmentId = null;
            this.departmentName = null;
        }
    }

    /**
     * checks if the department name is valid or not, the name should only contain letters or space
     * @param departmentName the department name to be checked
     * @return whether the department name is valid or not, true if it is, false if it isn't
     */
    public static boolean isDepartmentNameValid(String departmentName) {
        if (departmentName == null || departmentName.isBlank()) {
            return false;
        }

        for (int i = 0; i < departmentName.length(); i++) {
            if (!Character.isLetter(departmentName.charAt(i)) && departmentName.charAt(i) != ' ') {
                return false;
            }
        }

        return true;
    }
}
