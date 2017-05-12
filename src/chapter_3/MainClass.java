package chapter_3;

import java.io.IOException;

public class MainClass {

    public static void main(String[] args){
        try {
            ReadFromFile readFromFile = new ReadFromFile();
            System.out.println("Read from the file with the one line reader: " + readFromFile.processFile(br -> br.readLine()));
            System.out.println("Read from the file with the two line reader: " + readFromFile.processFile(bufferedReader -> bufferedReader.readLine() + " " + bufferedReader.readLine()));

        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
