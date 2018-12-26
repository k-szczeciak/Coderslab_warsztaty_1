package pl.coderslab;

import java.util.Random;
import java.util.Scanner;

public class Task4 {

    public static void main(String[] args){
        System.out.println("co chcesz robic?");

        //poukladac

        //read value
        Scanner scanner = new Scanner(System.in);
        String newMove = scanner.next();
        System.out.println(newMove);
        int dPos = newMove.indexOf("D");
        int plusPos = newMove.indexOf("+");
        int minusPos = newMove.indexOf("-");
        int numberOfthrows = 0;
        int diceSize = 0;
        int correction = 0;
        String subString = "";
        int throwResult = 0;
        int throwOne =  0;

        if (dPos < 0){
            System.out.println("niewłaściwy format...");
        }else{
            //System.out.println(dPos);
            if (dPos > 0){
                subString = newMove.substring(0, dPos);
                numberOfthrows = Integer.parseInt(subString);
            }else{
                numberOfthrows = 1;
            }

            if (plusPos > 0 ){
                subString = newMove.substring(dPos+1, plusPos);
                try{
                    diceSize = Integer.parseInt(subString);
                }catch (NumberFormatException e){
                    System.out.println("WTF?!");
                }

                subString = newMove.substring(plusPos+1, newMove.length());
                try{
                    correction = Integer.parseInt(subString);
                }catch(NumberFormatException e){
                    System.out.println("WTF?!");
                }

            }else if (minusPos > 0 ) {
                subString = newMove.substring(dPos + 1, minusPos);
                try{
                    diceSize = Integer.parseInt(subString);
                }catch (NumberFormatException e){
                    System.out.println("WTF?!");
                }
                subString = newMove.substring(minusPos + 1, newMove.length());
                try{
                    correction = Integer.parseInt(subString);
                }catch(NumberFormatException e){
                    System.out.println("WTF?!");
                }
            }else{
                subString = newMove.substring(dPos + 1, newMove.length());
                try{
                    diceSize = Integer.parseInt(subString);
                }catch (NumberFormatException e){
                    System.out.println("WTF?!");
                }
                correction = 0;
            }

            System.out.print(numberOfthrows + " ");
            System.out.print(diceSize + " ");
            System.out.print(correction + "\n");

            //result
            Random rand = new Random();
            for (int i = 0; i < numberOfthrows; i++){
                throwOne = rand.nextInt(diceSize + 1);
                throwResult += throwOne;
                System.out.println("throw "+ i + ": " + throwOne);
            }
            throwResult += correction;

            System.out.println("\n" + "throws total result: " + throwResult);

        }

    }
}
