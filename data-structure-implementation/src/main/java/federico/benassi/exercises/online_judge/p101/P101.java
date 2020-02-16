package federico.benassi.exercises.online_judge.p101;

import federico.benassi.exercises.online_judge.input_files.InputFileReader;

import java.io.IOException;


// link: https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=3&page=show_problem&problem=37
public class P101 {

    private Node[] internalArray;

    public P101(int numberOfBlocks){
        internalArray = new Node[numberOfBlocks];
        for(int i = 0; i < internalArray.length; i++)
            internalArray[i] = new Node(i, null, null);
    }

    public void readMove(String move){
        String[] splitArray = move.split(" ");
        String typeOfMove = splitArray[0].trim();
        if(typeOfMove.equals("quit")) {
            printResult();
            return;
        }
        String howWillBePlaced = splitArray[2].trim();
        int blockA = Integer.parseInt(splitArray[1].trim());
        int blockB = Integer.parseInt(splitArray[3].trim());

        processMove(typeOfMove, howWillBePlaced, blockA, blockB);
    }

    private void printResult() {
        for(int i = 0; i < internalArray.length; i++){
            var currentNode = internalArray[i];
            System.out.print(i + ":");
            if(internalArray[i].previousNode == null && internalArray[i].nextNode == null)
                System.out.println(" " + i);
            else if(internalArray[i].previousNode == null && internalArray[i].nextNode != null) {
                while (currentNode.nextNode != null) {
                    System.out.print(" " + currentNode.value);
                    currentNode = currentNode.nextNode;
                }
                System.out.println(" " + currentNode.value);
            }
            else{
                System.out.println();
            }
        }
    }

    private Node findRoot(int block){
        var currentNode = internalArray[block];
        while(currentNode.previousNode != null)
            currentNode = currentNode.previousNode;
        return currentNode;
    }

    private void processMove(String typeOfMove, String howWillBePlaced, int blockA, int blockB) {
        if(blockA == blockB) return;
        if(findRoot(blockA) == findRoot(blockB)) return;
        if(typeOfMove.equals("move")){
            if(howWillBePlaced.equals("onto")){
                moveBlockAOntoBlockB(blockA, blockB);
            } else if(howWillBePlaced.equals("over")){
                moveBlockAOverBlockB(blockA, blockB);
            }
        } else if(typeOfMove.equals("pile")){
            if(howWillBePlaced.equals("onto")){
                pileBlockAOntoBlockB(blockA, blockB);
            } else if(howWillBePlaced.equals("over")){
                pileBlockAOverBlockB(blockA, blockB);
            }
        }
    }

    private void moveBlockAOntoBlockB(int blockA, int blockB){
        if(internalArray[blockA].previousNode != null) internalArray[blockA].previousNode.nextNode = null;
        freeBlocks(blockA);
        freeBlocks(blockB);

        internalArray[blockB].nextNode = internalArray[blockA];
        internalArray[blockA].previousNode = internalArray[blockB];
    }

    private void pileBlockAOntoBlockB(int blockA, int blockB){
        if(internalArray[blockA].previousNode != null) internalArray[blockA].previousNode.nextNode = null;
        freeBlocks(blockB);
        internalArray[blockB].nextNode = internalArray[blockA];
        internalArray[blockA].previousNode = internalArray[blockB];
    }

    private void moveBlockAOverBlockB(int blockA, int blockB){
        if(internalArray[blockA].previousNode != null) internalArray[blockA].previousNode.nextNode = null;
        freeBlocks(blockA);

        var currentNode = internalArray[blockB];
        while(currentNode.nextNode != null){
            currentNode = currentNode.nextNode;
        }

        currentNode.nextNode = internalArray[blockA];
        internalArray[blockA].previousNode = currentNode;
    }

    private void pileBlockAOverBlockB(int blockA, int blockB){
        if(internalArray[blockA].previousNode != null) internalArray[blockA].previousNode.nextNode = null;

        var currentNode = internalArray[blockB];
        while(currentNode.nextNode != null){
            currentNode = currentNode.nextNode;
        }

        currentNode.nextNode = internalArray[blockA];
        internalArray[blockA].previousNode = currentNode;
    }

    private void freeBlocks(int block){
        var currentNode = internalArray[block];


        while(currentNode.nextNode != null){
            var tempNode = currentNode.nextNode;
            currentNode.nextNode = null;
            currentNode = tempNode;
            currentNode.previousNode = null;
        }
    }

    public static void main(String[] args) throws IOException {
        InputFileReader ifr = new InputFileReader("p101.txt");
        String line;
        P101 p101 = new P101(Integer.parseInt(ifr.readLine().trim()));
        while((line = ifr.readLine()) != null){
            p101.readMove(line);
        }
        ifr.close();
    }

    private class Node{
        private int value;
        private Node previousNode;
        private Node nextNode;

        public Node(int value, Node previousNode, Node nextNode) {
            this.value = value;
            this.previousNode = previousNode;
            this.nextNode = nextNode;
        }
    }
}
