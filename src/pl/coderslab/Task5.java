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



        Path filePath = Paths.get("test11.txt");
        try {
            Files.createFile(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Connection connect = Jsoup.connect("http://www.onet.pl/");
        try {
            Document document = connect.get();
            Elements links = document.select("span.title"); for (Element elem : links) {
                System.out.println(elem.text()); }
        } catch (IOException e) { e.printStackTrace();
        }

        Path path1 = Paths.get("path1.txt");
        ArrayList<String> outList = new ArrayList<>();
        outList.add("first line");
        outList.add("second line");
        try {
            Files.write(path1, outList); } catch (IOException ex) {
            System.out.println("Nie można zapisać pliku."); }

        /*try {
            Files.write(filePath, elem.text());
        } catch (IOException ex) {
            System.out.println("Nie można zapisać pliku.");
        }*/

    }


}
