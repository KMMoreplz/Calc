package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String value11;
        String value22;
        int value1 = 0;
        int value2 = 0;
        String operation;
        Scanner scanner = new Scanner(System.in);
        value11 = scanner.next();
        operation = scanner.next();
        value22 = scanner.next();
        if (value22==null){System.out.println("throws Exception!");  System.exit(0);}
        transformerToInts(value11, value22, value1, value2,  operation);
        value1 = Integer.parseInt(value11);
        value2 = Integer.parseInt(value22);

        if (value1==0||value2==0){System.out.println("throws Exception!");  System.exit(0);}
        if (operation.equals("+")) {
            System.out.println(value1 + value2);
            System.exit(0);
        }
        if (operation.equals("-")) {

            System.out.println(value1 - value2);
            System.exit(0);
        }
        if (operation.equals("*")) {
            System.out.println(value1 * value2);
            System.exit(0);
        }
        if (operation.equals("/") && value2 != 0) {
            System.out.println(value1 / value2);
        } else {

            System.out.println("throws Exception!");
        }
        System.exit(0);
    }


    public static String getRoman(int number) {

        String[] riman = {"M","XM","CM","D","XD","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] arab = {1000, 990, 900, 500, 490, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (number > 0 || arab.length == (i - 1)) {
            while ((number - arab[i]) >= 0) {
                number -= arab[i];
                result.append(riman[i]);
            }
            i++;
        }
        return result.toString();
    }


    public static void transformerToInts(String one, String two, int oneSaver, int twoSaver,
                                           String operation) {
        boolean transformed = false;
        boolean transformed2 = false;
        String[] romans = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",};
        for (int i = 0; i < 10; i++) {
            if (one.equals(romans[i])) {
                oneSaver = i + 1;
                transformed = true;
                break;
            }
        }
        for (int i = 0; i < 10; i++) {
            if (two.equals(romans[i])) {
                twoSaver = i + 1;
                transformed2 = true;
                break;
            }
        }

        if (transformed != transformed2) {
            System.out.println("throws Exception!");
            System.exit(0);
        }
        if (operation.equals("+") && transformed) {
            System.out.println(romans[(oneSaver + twoSaver) - 1]);
            System.exit(0);
        }
        if (operation.equals("-") && oneSaver >= twoSaver && transformed) {
            if (oneSaver-twoSaver==0){System.out.println(0);} //Либо System.out.println("throws Exception!");
            else
            System.out.println(romans[oneSaver - twoSaver - 1]);
            System.exit(0);
        }
        if (operation.equals("*") && transformed) {
            System.out.println(getRoman(oneSaver*twoSaver));
            System.exit(0);
        }
        if (operation.equals("/") && twoSaver != 0 && transformed) {
            if (oneSaver % twoSaver == 0) {
                System.out.println(romans[(oneSaver / twoSaver) - 1]);
                System.exit(0);
            }
        }
    }
}