package converter;

import converter.exceptions.MalformedNumberException;
import converter.exceptions.ValueOutOfBoundsException;

import java.util.Arrays;
import java.util.ArrayList;

/**
 * This class implements a converter that takes a string that represents a number in either the
 * Elbonian or Arabic numeral form. This class has methods that will return a value in the chosen form.
 *
 * @version 3/18/17
 */
public class ElbonianArabicConverter {

    // A string that holds the number (Elbonian or Arabic) you would like to convert
    private final String number;


    /**
     * Constructor for the ElbonianArabic class that takes a string. The string should contain a valid
     * Elbonian or Arabic numeral. The String can have leading or trailing spaces. But there should be no
     * spaces within the actual number (ie. "9 9" is not ok, but " 99 " is ok). If the String is an Arabic
     * number it should be checked to make sure it is within the Elbonian number systems bounds. If the
     * number is Elbonian, it must be a valid Elbonian representation of a number.
     *
     * @param number A string that represents either a Elbonian or Arabic number.
     * @throws MalformedNumberException Thrown if the value is an Elbonian number that does not conform
     * to the rules of the Elbonian number system. Leading and trailing spaces should not throw an error.
     * @throws ValueOutOfBoundsException Thrown if the value is an Arabic number that cannot be represented
     * in the Elbonian number system.
     */
    public ElbonianArabicConverter(String number) throws MalformedNumberException, ValueOutOfBoundsException {

        if(number.matches("") || number.matches("0")) {
            throw new MalformedNumberException("");
        }

        if (number.matches("[MCDXLIVemw]*")){
            if (this.isE(number) && this.checkRepeated(number)) {
                this.number = number;
            }else {
                throw new MalformedNumberException("");
            }
        } else if (isNumber(number))/*number.matches("[0-9]+"*/ {
            if (Integer.parseInt(number) <= 3999 && Integer.parseInt(number) > 0){
                this.number = number;
            } else {
                throw new ValueOutOfBoundsException("");
            }
        } else {
            throw new MalformedNumberException("");
        }
    }

    /**
     * Converts the number to an Arabic numeral or returns the current value as an int if it is already
     * in the Arabic form.
     *
     * @return An arabic value
     */
    public int toArabic() {
        int sum = 0;
        if (!this.number.matches("[MCDXLIVemw]*")){
            return Integer.parseInt(this.number);
        }else{
            for (char n : this.number.toCharArray()){
                sum += eToA(n);
            }
        }

        return sum;
    }

    /**
     * Converts the number to an Elbonian numeral or returns the current value if it is already in the Elbonian form.
     *
     * @return An Elbonian value
     */
    public String toElbonian() {
        int number;
        ArrayList<Character> elbonian = new ArrayList<Character>();
        if (!this.number.matches("[0-9]+")){
            return this.number;
        }else {
            number = Integer.parseInt(this.number);
            ArrayList<Integer> quotients = new ArrayList<Integer>(Arrays.asList(1000, 500, 400, 100, 50, 40, 10, 5, 4, 1));
            for (Integer n : quotients) {
                if (number / n >= 1) {
                    for(int i =0; i < number/n; i++){
                        elbonian.add(aToE(n));
                    }
                    number %= n;
                }
            }
        }
        return elbonian.toString().replaceAll("[,\\s\\[\\]]", "");
    }

//    public boolean isInteger() {
//        int size = this.number.length();
//        for(int i = 0; i < size; i++){
//            if(!Character.isDigit(this.number.charAt(i))){
//                return false;
//            }
//        }
//        return true;
//    }

    public int eToA(char num) {
        switch(num) {
            case 'M':
                return 1000;
            case 'C':
                return 100;
            case 'X':
                return 10;
            case 'I':
                return 1;
            case 'D':
                return 500;
            case 'L':
                return 50;
            case 'V':
                return 5;
            case 'e':
                return 400;
            case 'm':
                return 40;
            case 'w':
                return 4;
            default:
                return 0;
        }
    }

    public char aToE(int num) {
        switch(num) {
            case 1000:
                return 'M';
            case 100:
                return 'C';
            case 10:
                return 'X';
            case 1:
                return 'I';
            case 500:
                return 'D';
            case 50:
                return 'L';
            case 5:
                return 'V';
            case 400:
                return 'e';
            case 40:
                return 'm';
            case 4:
                return 'w';
            default:
                return 0;
        }
    }

    public boolean isNumber (String number){
        try {
            new Integer(number);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }


    public boolean isE(String number) {
        int size = number.length();
        for(int i = 0; i < size - 1; i++){
            if(this.eToA(number.charAt(i)) < this.eToA(number.charAt(i + 1))){
                return false;
            }
        }
        return true;
    }

    public boolean checkRepeated(String number) {
        int Ms = 0, Cs = 0, Xs = 0, Is = 0, Ds = 0, es = 0, Ls = 0, ms = 0, Vs = 0, ws = 0;
        for (char n : number.toCharArray()) {
            switch (n) {
                case 'M':
                    Ms++;
                    break;
                case 'C':
                    Cs++;
                    break;
                case 'X':
                    Xs++;
                    break;
                case 'I':
                    Is++;
                    break;
                case 'D':
                    Ds++;
                    break;
                case 'e':
                    es++;
                    break;
                case 'L':
                    Ls++;
                    break;
                case 'm':
                    ms++;
                    break;
                case 'V':
                    Vs++;
                    break;
                case 'w':
                    ws++;
                    break;
                default:
                    break;
            }
        }
        return (Ms <= 3 && Cs <= 3 && Xs <= 3 && Is <= 3 && Ds < 2 && es < 2 && Ls < 2 && ms < 2 && Vs < 2 && ws < 2);
    }
}
