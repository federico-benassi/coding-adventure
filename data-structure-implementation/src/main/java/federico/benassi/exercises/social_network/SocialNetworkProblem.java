package federico.benassi.exercises.social_network;

import com.google.common.base.Stopwatch;

public class SocialNetworkProblem {
    /*
    Problem Description
    Social network connectivity. Given a social network containing nn members and a log file containing mm timestamps at
    which times pairs of members formed friendships, design an algorithm to determine the earliest time at which all
    members are connected (i.e., every member is a friend of a friend of a friend ... of a friend). Assume that the log
    file is sorted by timestamp and that friendship is an equivalence relation. The running time of your algorithm
    should be m \log nmlogn or better and use extra space proportional to nn.
     */

    private int[] graph;
    private int[] sizes;


    public SocialNetworkProblem(int m){
        new LogGenerator(m).generate();
        this.graph = new int[m];
        this.sizes = new int[m];
        for(int i = 0; i < m; i++){
            this.graph[i] = i;
            this.sizes[i] = 1;
        }
        LogReader reader = new LogReader(m);
        Stopwatch stopwatch = Stopwatch.createStarted();
        while(reader.hasNext()){
            this.union(reader.nextLog());
        }
        System.out.println(stopwatch.elapsed());
    }

    // Union find but with check of set on root operation
    private void union(Log log){
        int pRoot = root(log.getFriendP());
        int qRoot = root(log.getFriendQ());
        if(pRoot == qRoot) return;
        if(sizes[pRoot] < sizes[qRoot]) {
            this.graph[pRoot] = qRoot;
            this.sizes[qRoot] += this.sizes[pRoot];
            if(this.checkRoot(qRoot)) System.out.println("All are friends at: " + log.getTimestamp());
        } else {
            this.graph[qRoot] = pRoot;
            this.sizes[pRoot] += this.sizes[qRoot];
            if(this.checkRoot(pRoot)) System.out.println("All are friends at: " + log.getTimestamp());
        }
    }

    private boolean checkRoot(int root){
        return this.sizes[root] == this.graph.length;
    }

    private int root(int i){
        int m = i;
        while(m != this.graph[m]) {
            m = this.graph[m];
        }
        int n = i;
        while(n != this.graph[n]){
            var previousIndex = n;
            n = this.graph[n];
            this.graph[previousIndex] = m;
        }

        return m;
    }


    public static void main(String[] args) {
        new SocialNetworkProblem(999999);
    }
}
