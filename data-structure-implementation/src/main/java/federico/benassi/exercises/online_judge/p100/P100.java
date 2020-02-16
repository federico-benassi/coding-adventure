package federico.benassi.exercises.online_judge.p100;

import federico.benassi.exercises.online_judge.input_files.InputFileReader;

import java.io.*;

// Link: https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=3&page=show_problem&problem=36
public class P100 {
    public static void algo(int i, int j){
        int max = Integer.MIN_VALUE;
        var lo = Math.min(i, j);
        var hi = Math.max(i, j);

        for(int k = lo; k <= hi; k++){
            var cyclicLength = cyclicLength(k);
            if(cyclicLength > max) max = cyclicLength;
        }

        System.out.println(i + " " + j + " " + max);
    }

    private static int cyclicLength(int n){
        int counter = 1;
        while(n > 1){
            if(n % 2 == 1) n = 3 * n + 1;
            else n = n / 2;
            counter++;
        }

        return counter;
    }

    public static void main(String[] args) throws IOException {
        InputFileReader ifr = new InputFileReader("p100.txt");
        String line;
        while((line = ifr.readLine()) != null){
            String[] arguments = line.split(" ");
            int i = Integer.parseInt(arguments[0].trim());
            int j = Integer.parseInt(arguments[1].trim());
            algo(i, j);
        }
        ifr.close();
    }
}
