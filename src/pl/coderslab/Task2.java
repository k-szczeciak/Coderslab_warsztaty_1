package pl.coderslab;

import java.util.Random;
import java.util.Scanner;

public class Task2 {

    public static void main(String[] args){
    System.out.println("wyloswowana tabela:");
        // 6 random not repeating number choosing from 0-49
        int[] randomTableresult = randomNumbersTable(49);
        displayTable(randomTableresult);
        // read 6 guess numbers from console
        int[] guessedNumbers = readTable();
        displayTable(guessedNumbers);
        // compare numbers
        int numberOfHits = compareResults(randomTableresult, guessedNumbers);
        System.out.println("inosc wlasciwie zgadnietych liczb: " + numberOfHits);

        // display result, i.e. random numbers, guessed numbers and comparison


    }

    static int[] randomNumbersTable(int range){
        int[] result = new int[6];
        // other option shuffle - see materials
        int i = 1;
        int newResult = 0;
        boolean scan = true;
        result[0] = randomNumber(range);
        do{
            newResult = randomNumber(range);
            for (int j = 0; j <= i; j++){
                if (result[j] == newResult){
                    scan = false;
                }
            }
            if (scan == true){
                result[i] = newResult;
                i++;
            } else {
                scan = true;
            }
        }while(i < 6);
        return result;
    }

    static int randomNumber(int range){
        Random rand = new Random();
        return rand.nextInt(range);
    }

    static void displayTable(int[] table){
        for (int element:table
             ) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    static int[] readTable(){
        int[] result = new int[6];
        int i = 0;
        String readString = "";
        System.out.println("podaj 6 liczb: ");
        Scanner scanner = new Scanner(System.in);
        do{
            readString = scanner.next();
            try{
                result[i] = Integer.parseInt(readString);
                i++;
            }catch (NumberFormatException e){
                System.out.println("to nie jest liczba... ");
            }
        }while (i < 6);
        return result;
    }

    static int compareResults(int[] randomTable, int[] guessTable){
        int result = 0;
        for(int i = 0; i < guessTable.length; i++){
            for (int j = 0; j < randomTable.length; j++){
                if (guessTable[i] == randomTable[j]){
                    result++;
                }
            }
        }
        return result;
    }
}
