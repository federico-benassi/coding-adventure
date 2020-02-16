package federico.benassi.algorithm.pattern_matching;

public class SimplePatternMatching {

    public int findMatch(String s, String m){
        int index = -1;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == m.charAt(0)){
                var counter = 0;
                for(int j = i; j < s.length(); j++){
                    if(s.charAt(j) != m.charAt(counter)){
                        break;
                    }
                    if(j == s.length() - 1 && s.charAt(j) == m.charAt(counter)){
                        index = j - m.length() + 1;
                    }
                    counter++;
                }
            }
        }

        return index;
    }


    public static void main(String[] args) {
        String s = "Ciao Mi chiamo Federico";
        String m = "Federico";

        int index = new SimplePatternMatching().findMatch(s, m);
        System.out.println(index);
    }
}
