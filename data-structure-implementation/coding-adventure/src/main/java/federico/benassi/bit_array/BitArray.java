package federico.benassi.bit_array;

public class BitArray implements Comparable<BitArray> {

    private boolean[] internalArray;

    BitArray(int capacity){
        this.internalArray = new boolean[capacity];
    }

    public BitArray not(){
        for(int i = 0; i < this.internalArray.length; i++){
            this.internalArray[i] = !this.internalArray[i];
        }
        return this;
    }

    public BitArray or(BitArray other){
        this.testLengthOfBitArrays(other);


        for(int i = 0; i < this.internalArray.length; i++){
            this.internalArray[i] = this.internalArray[i] || other.internalArray[i];
        }

        return this;
    }



    public BitArray xor(BitArray other){
        this.testLengthOfBitArrays(other);

        for(int i = 0; i < this.internalArray.length; i++){
            this.internalArray[i] = this.internalArray[i] ^ other.internalArray[i];
        }

        return this;
    }


    public BitArray and(BitArray other){
        this.testLengthOfBitArrays(other);

        for(int i = 0; i < this.internalArray.length; i++){
            this.internalArray[i] = this.internalArray[i] && other.internalArray[i];
        }

        return this;
    }

    private void testLengthOfBitArrays(BitArray other){
        if(this.internalArray.length != other.internalArray.length){
            throw new DifferentLengthException();
        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0; i < this.internalArray.length; i++){
            if(this.internalArray[i] == false) sb.append("0, ");
            else sb.append("1, ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append("]");
        return sb.toString();
    }

    @Override
    public int compareTo(BitArray o) {

        return 0;
    }


}
