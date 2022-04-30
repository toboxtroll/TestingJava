package com.javatest.util;

import java.util.*;

public class RomanNumerals {
    enum RomanNumeral {

        M(1000),CM(900),D(500),CD(400),
        C(100),XC(90),L(50),XL(40),
        X(10),IX(9),V(5),IV(4),
        I(1);

        private int value;

        RomanNumeral(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static List<RomanNumeral> getRomanNumerals() {
            return Arrays.asList(RomanNumeral.values());
        }

    }

    public static String arabicToRoman(int number) {

        StringBuilder collator = new StringBuilder();
        List<RomanNumeral> romanNumerals = RomanNumeral.getRomanNumerals();
        System.out.println(romanNumerals);
        //Valida que el número sea menor a 4000 debido a que el formato cambia
        if (number > 0 && number < 4000) {

            int i = 0;

            while (number > 0 && i < romanNumerals.size()) {
//                System.out.println(i);
                RomanNumeral currentRoman = romanNumerals.get(i);
                System.out.println(currentRoman.getValue());

                if (number >= currentRoman.getValue()) {
                    collator.append(currentRoman);
                    System.out.println(collator);
                    number -= currentRoman.getValue();
                } else {
                    i++;
                }

            }

            String roman = collator.toString();
            return roman;

        } else {
            throw new IllegalArgumentException(number + "no está en el rango (0,4000)");
        }
    }

//        String result = "";
//
//        Map<Integer, String> arabicRomanMap = new TreeMap<>();
//        arabicRomanMap.put(1, "I");
//        arabicRomanMap.put(4, "IV");
//        arabicRomanMap.put(5, "V");
//        arabicRomanMap.put(9, "IX");
//        arabicRomanMap.put(10, "X");
//        arabicRomanMap.put(40, "XL");
//        arabicRomanMap.put(50, "L");
//        arabicRomanMap.put(100, "C");
//
////        if (number == 1) result = "I";
////        if (number == 2) result = "II";
////        if (number == 3) result = "III";
////        if (number == 5) result = "V";
////        if (number == 6) result = "VI";
////        if (number == 7) result = "VII";
////        if (number == 8) result = "VIII";
////        if (number == 10) result = "X";
//        System.out.println(number);
//
//        while (number > 0){
//            for (Integer key : arabicRomanMap.keySet()) {
//
//                if (number <= 3){
//                    result += (arabicRomanMap.get(key));
//                    number -= key;
//                    System.out.println("1. " + result);
//                    break;
//                } else if(number == 4 || number == 9){
//                    result += (arabicRomanMap.get(number));
//                    number -= number;
//                    System.out.println("2. " + result);
//                    break;
//
//                } else if (number >= 5 && number <= 8){
//                    result += (arabicRomanMap.get(5));
//                    number -= 5;
//                    System.out.println("3. " + result);
//
//                    break;
//                } else if(number >= 10 && number <= 39) {
//                    result += (arabicRomanMap.get(10));
//                    number -= 10;
//                    System.out.println("4. " + result);
//                    break;
//                } else if(number >= 40 && number < 50) {
//                    result += (arabicRomanMap.get(40));
//                    number -= 40;
//                    System.out.println("5. " + result);
//                    break;
//                } else if(number >= 50 && number < 89) {
//                    result += (arabicRomanMap.get(50));
//                    number -= 50;
//                    System.out.println("6   . " + result);
//                    break;
//                } else if(number >= 90 && number < 100) {
//                    result += (arabicRomanMap.get(40));
//                    number -= 40;
//                    System.out.println("5. " + result);
//                    break;
//                }
//
//
//
//
//            }
//        }
//        return result;
//    }



}
