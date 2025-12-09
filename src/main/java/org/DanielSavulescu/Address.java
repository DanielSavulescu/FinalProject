package org.DanielSavulescu;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Getter
@Setter
public class Address {
    private int streetNo;
    private String street;
    private String city;
    private Province province;
    private String postalCode;

    public Address(int streetNo, String street, String city, Province province, String postalCode) {

        if (isPostalCodeValid(postalCode)) {
            this.streetNo = streetNo;
            this.street = street;
            this.city = city;
            this.province = province;
            this.postalCode = postalCode.toUpperCase();
        } else {
            this.streetNo = -1;
            this.street = null;
            this.city = null;
            this.province = null;
            this.postalCode = null;
        }
    }

    /**
     * checks if the postal code is valid or not, to be valid it has to follow the CDCDCD structure,
     * where C is a character and D is a digit and the length is 6
     * @param postalCode the postal code to be verified
     * @return whether the postal code is valid or not, true if it is, false if it isn't
     */
    public static boolean isPostalCodeValid(String postalCode) {
        if (postalCode == null || postalCode.length() != 6) {
            return false;
        }

        for (int i = 1; i < 6; i++) {
            char c = postalCode.charAt(i);

            if (i % 2 == 0) {
                if (!Character.isLetter(c)) {
                    return false;
                }
            } else {
                if (!Character.isDigit(c)) {
                    return false;
                }
            }
        }

        return true;
    }

    public enum Province {
        AB,
        MB,
        ON,
        QC,
        SK,
        BC,
        NB,
        NS,
        PEI,
        NL,
    }
}
