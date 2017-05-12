package chapter_3;

import java.io.BufferedReader;
import java.io.IOException;

public interface BufferedReaderPorcessor {

    String process(BufferedReader br) throws IOException;
}
