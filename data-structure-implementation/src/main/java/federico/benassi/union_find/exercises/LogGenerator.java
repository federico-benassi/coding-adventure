package federico.benassi.union_find.exercises;

import java.io.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class LogGenerator {

    private int numberOfLines;

    public LogGenerator(int numberOfLines){
        this.numberOfLines = numberOfLines;
    }

    public void generate(){
        this.tryGenerateLogsFiles(numberOfLines);
    }

    private void tryGenerateLogsFiles(int m){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("logs"), 32768);
            this.generateLogsFiles(m, bw);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void generateLogsFiles(int m, BufferedWriter bw) throws IOException, InterruptedException {
        Random random = new Random(new Date().getTime());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss:SSS");
        for(int i = 0; i < m; i++){
            String date = LocalTime.now().format(formatter);
            bw.write(date.toString() + "!!" + String.format("%3d!!%3d", 0, i));
            bw.newLine();
        }
        bw.close();
    }

    public static void main(String[] args) {
        new LogGenerator(999999999).generate();
    }
}
