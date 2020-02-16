package federico.benassi.exercises.online_judge.input_files;

import java.io.*;
import java.util.Objects;

public class InputFileReader {

    private final static String PREFIX = "src/main/java/federico/benassi/exercises/online_judge/input_files/";

    private BufferedReader br;
    private int lineCounter = 0;



    public InputFileReader(String fileName) throws FileNotFoundException {
        br = new BufferedReader(new FileReader(new File(PREFIX + fileName)));
    }

    public boolean wasTheLastLineReadTheFirstLineInTheFile(){
        return lineCounter == 1;
    }

    public String readLine() throws IOException {
        var toReturn = br.readLine();
        if(Objects.nonNull(toReturn)) lineCounter++;
        return toReturn;
    }

    public void close() throws IOException {
        br.close();
    }


}
