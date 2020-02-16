package federico.benassi.exercises.online_judge.p103;

import federico.benassi.exercises.online_judge.input_files.InputFileReader;

import java.io.IOException;

// link: https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=3&page=show_problem&problem=39
public class P103 {

    private int numberOfBoxes;
    private int numberOfDimensions;
    private String[][] boxes;

    public static void main(String[] args) throws IOException {
        P103 p103 = new P103();
        InputFileReader ifr = new InputFileReader("p102.txt");
        String line = null;
        while((line = ifr.readLine()) != null){
            p103.readHeader(line);
            for(int i = 0; i < p103.numberOfBoxes; i++){
                p103.readBox(i, ifr.readLine());
            }
            p103.printResult();
        }
        ifr.close();
    }

    private void printResult() {
        
    }

    private void readHeader(String line) {
        String[] args = line.split(" ");
        numberOfBoxes = Integer.parseInt(args[0].trim());
        numberOfDimensions = Integer.parseInt(args[1].trim());
        boxes = new String[numberOfBoxes][numberOfDimensions];
    }

    private void readBox(int index, String line){
        String[] args = line.split(" ");
        for(int i = 0; i < numberOfDimensions; i++){
            boxes[index][i] = args[i];
        }
    }
}
