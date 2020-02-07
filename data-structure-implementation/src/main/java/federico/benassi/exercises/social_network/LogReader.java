package federico.benassi.exercises.social_network;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LogReader {
    private Log[] logs;
    private int index = 0;

    public LogReader(int numberOfLines){
        this.logs = new Log[numberOfLines];

        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File("logs")));
            for(int i = 0; i < numberOfLines; i++){
                var splitArray = reader.readLine().split("!!");
                logs[i] = new Log(splitArray[0], Integer.valueOf(splitArray[1].trim()), Integer.valueOf(splitArray[2].trim()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean hasNext(){
        if(index < this.logs.length)
            return true;
        else return false;
    }

    public Log nextLog(){
        if(index < this.logs.length)
            return logs[index++];
        else throw new NoMoreLogLinesException();
    }

    class NoMoreLogLinesException extends RuntimeException{

    }
}
