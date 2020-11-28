package dev.boiarshinov.testbuildersdemo.controller;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;

public class InnHashValidator implements ConstraintValidator<ValidInnHash, String> {

    private static final Integer[] MULT_N1 = {7, 2, 4, 10, 3, 5, 9, 4, 6, 8};
    private static final Integer[] MULT_N2 = {3, 7, 2, 4, 10, 3, 5, 9, 4, 6, 8};
    private static final Integer[] MULT_N =  {2, 4, 10, 3, 5, 9, 4, 6, 8};

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) return true;
        return this.checkInn(value);
    }

    private boolean checkInn(final String innStr) {
        boolean valid;
        final Integer[] inn = stringToIntArray(innStr);

        final int innSize = inn.length;
        final int longInnLength = 12;
        final int shortInnLength = 10;
        switch (innSize) {
            case longInnLength:
                final Integer firstCheckSum = getChecksum(inn, MULT_N1);
                final Integer secondCheckSum = getChecksum(inn, MULT_N2);

                valid = (inn[inn.length - 1].equals(secondCheckSum) && inn[inn.length - 2].equals(firstCheckSum));
                break;
            case shortInnLength:
                final Integer checkSum = getChecksum(inn, MULT_N);
                valid = (inn[inn.length - 1].equals(checkSum));
                break;
            default:
                valid = false;
                break;
        }
        return valid;
    }

    private Integer[] stringToIntArray(final String src) {
        final char[] chars = src.toCharArray();
        final ArrayList<Integer> digits = new ArrayList<>();
        for (char aChar : chars) {
            digits.add(Character.getNumericValue(aChar));
        }
        return digits.toArray(new Integer[0]);
    }

    private Integer getChecksum(final Integer[] digits, final Integer[] multipliers) {
        int checksum = 0;
        for (int i = 0; i < multipliers.length; i++) {
            checksum += (digits[i] * multipliers[i]);
        }
        final int firstDivider = 11;
        final int secondDivider = 10;
        return (checksum % firstDivider) % secondDivider;
    }
}
