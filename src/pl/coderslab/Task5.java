package pl.coderslab;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


public class Task5 {
    public static void main(String[] args){
        System.out.println("What do you want to do today Brain?");


        String[] excludedWrods = {"ponieważ", "lub", "oraz"};
        Connection connect = Jsoup.connect("http://www.onet.pl/");

        //Lists
        ArrayList<String> popularWords = new ArrayList<>();
        ArrayList<String> allWords = new ArrayList<>();


        try {
            Document document = connect.get();
            Elements links = document.select("span.title");
            for (Element elem : links) {

                System.out.println(elem.text());
                String lineText = elem.text();
                String[] wordsInLine = lineText.split(" ");


                for (String word: wordsInLine
                     ) {
                    if (word.length() > 2) {
                        if (popularWords.size()!=0){
                            if (isWordNew(word, popularWords)){
                                popularWords.add(removeCharacters(word));
                            }
                        }else {
                            popularWords.add(word);
                        }
                        allWords.add(removeCharacters(word));
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("No connection or...");
        }

        // aggregation
        System.out.println();

        for (int i = 0; i < popularWords.size(); i++) {
            System.out.println(popularWords.get(i));

        }

        // write all titles to file
        Path path2 = Paths.get("all_words.txt");
        Path path3 = Paths.get("popular_words.txt");

        try {
            Files.write(path2, allWords); } catch (IOException ex) {
            System.out.println("Nie można zapisać pliku.");
        }
        try {
            Files.write(path3, popularWords); } catch (IOException ex) {
            System.out.println("Nie można zapisać pliku.");
        }
    }

    static String removeCharacters(String wordToBeTrimmed){
        String result = "";
        result = wordToBeTrimmed.replace("?", "");
        result = result.replace("\"", "");
        result = result.replace(".", "");
        result = result.replace(",", "");
        result = result.replace(":", "");
        result = result.replace("'", "");
        return result;
    }

    static Boolean isWordNew(String word, ArrayList<String> popularWords){
        Boolean result = true;
        for (int i = 0; i < popularWords.size(); i++) {
            if (word.equals(popularWords.get(i))){
                result = false;
                break;
            }
        }
        return result;
    }

//todo: other tasks not included: - aggregate and sort list according to quantity. 2 dim list





}
