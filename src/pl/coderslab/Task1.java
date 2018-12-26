package pl.coderslab;


import java.util.Random;
import java.util.Scanner;

public class Task1 {


    public static void main(String[] args){

        // choose random number
        int randomNumber = randomNumber(100);
        System.out.println("Wylosowano liczbę z zakresu 0..100, spróbuj zgadnąć tą liczbę...");
        boolean result = false;
        do {
            // read number from console
            int readNumber = readNumber();
            // check number
            result = checkNumber(randomNumber, readNumber);
        }while(result == false);
    }

    static int readNumber(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Zgadnij liczbę: ");
        String enteredNumber = scanner.next();
        int number = 0;
        try{
            number = Integer.parseInt(enteredNumber);
        }catch(NumberFormatException e){
            System.out.println("to nie jest liczba, p****u!!!");
        }
        return number;
    }

    static int randomNumber(int range){
        Random rand = new Random();
        return rand.nextInt(range);
    }


    static boolean checkNumber(int randomNumber, int guessedNumber){
        boolean result = false;
        if (guessedNumber > randomNumber) {
            System.out.println("podana liczba jest za duza, pruboj dalej...");
            result = false;
        }else if (guessedNumber < randomNumber){
            System.out.println("podana liczba jest za mała, pruboj dalej...");
            result = false;
        }else if (guessedNumber == randomNumber){
            System.out.println("BINGO !!!, szukana liczba to: " + randomNumber);
            result = true;
        }
        return result;
    }



}
