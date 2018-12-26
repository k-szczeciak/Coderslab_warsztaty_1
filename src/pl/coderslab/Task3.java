package pl.coderslab;

import java.util.Scanner;

public class Task3 {

    public static void main(String[] arg){

        // choose number from 0 - 1000
        int max = 1000;
        int min = 0;
        int guessedNumber = 0;
        System.out.println("pomyśl o liczbie z zakresu 0 - 1000 a ja ją zgadnę w max 10 ruchach");
        System.out.println("czy możemy zaczynać... nacisnij ENTER");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        // guess
        String reply = "";
        do{
            guessedNumber = guessNumber(min, max);
            System.out.println("Zgaduję, że jest to liczba: " + guessedNumber);
            System.out.println(" odpowiedz: za duzo / za malo / zgadles");
            reply = scanner.nextLine();
            if (reply.equals("za duzo")){
                max =guessedNumber;
            }else if (reply.equals("za malo")){
                min =guessedNumber;
            } else if (reply.equals("zgadles")){
                System.out.println(" zajefajnie ....");
            } else {
                System.out.println("WTF!?");
            }
        }while(!reply.equals("zgadles"));


    }


    static int guessNumber(int min, int max){
        int result = 0;
        result = (max - min) / 2 + min;
        return result;
    }
}
