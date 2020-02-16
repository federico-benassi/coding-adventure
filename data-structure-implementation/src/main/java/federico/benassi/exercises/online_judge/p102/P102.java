package federico.benassi.exercises.online_judge.p102;

import federico.benassi.exercises.online_judge.input_files.InputFileReader;

import java.io.IOException;

// link: https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=3&page=show_problem&problem=38
public class P102 {

    private static final String[][] permutations = new String[][]{
            new String[]{"B", "C", "G"},
            new String[]{"B", "G", "C"},
            new String[]{"C", "B", "G"},
            new String[]{"C", "G", "B"},
            new String[]{"G", "B", "C"},
            new String[]{"G", "C", "B"}
    };

    private int[] internalArray;


    public P102(){}

    public void readSequence(String line){
        String[] ints = line.split(" ");
        internalArray = new int[ints.length];

        for(int i = 0; i < ints.length; i++){
            internalArray[i] = Integer.parseInt(ints[i].trim());
        }
        var toJump = 0;
        var minMovements = Integer.MAX_VALUE;
        String[] minPermutation = new String[3];
        for(int i = 0; i < permutations.length; i++){
            var movements = 0;
            for(int j = 0; j < permutations[i].length; j++){
                var hop = 3 * j;
                switch (permutations[i][j]) {
                    case "B":
                        toJump = hop;
                        break;
                    case "G":
                        toJump = 1 + hop;
                        break;
                    case "C":
                        toJump = 2 + hop;
                        break;
                }

                for(int k = hop; k < hop + 3; k++){
                    if (toJump != k) movements += internalArray[k];
                }
            }
            if(minMovements > movements) {
                minPermutation = permutations[i];
                minMovements = movements;
            }
        }

        for(int i = 0; i < minPermutation.length; i++)
            System.out.print(minPermutation[i]);

        System.out.println(" " + minMovements);
    }

    public static void main(String[] args) throws IOException {
        P102 p102 = new P102();
        InputFileReader ifr = new InputFileReader("p102.txt");
        String line = null;
        while((line = ifr.readLine()) != null){
            p102.readSequence(line);
        }
        ifr.close();
    }
}
