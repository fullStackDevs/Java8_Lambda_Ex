package chapter_3;

import java.io.*;

public class ReadFromFile {

    public String processFile(BufferedReaderPorcessor brp) throws IOException{
        try(BufferedReader br = new BufferedReader(new FileReader(new File("cars.txt")))){
            return brp.process(br);
        }
    }
}
