package org.example;

public class abc {
    public static void main(String[] args) {
        int number = 50;
        System.out.print(positiveDivisor(number));

    }

    public static String positiveDivisor(int number) {
        String positiveDiv = "";
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                positiveDiv += i + " ";

            }
        }
        return positiveDiv;
    }

}
