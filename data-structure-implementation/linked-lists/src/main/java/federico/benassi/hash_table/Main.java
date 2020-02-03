package federico.benassi.hash_table;

import com.google.common.base.Stopwatch;

import java.math.BigInteger;

public class Main {
    static HashTable<String, Long> cache;

    public static void main(String[] args) {
        cache = new HashTable<>();
        Stopwatch stopwatch = Stopwatch.createStarted();
        System.out.println(fibonacci(100));
        System.out.println(stopwatch.elapsed());
    }

    public static long fibonacci(long n){
        var toTest = cache.get("" + n);
        if(toTest != null){
            return toTest;
        } else {
            if ((n == 0) || (n == 1))
                return n;
            else{
                cache.put("" + n, n);
                return fibonacci(n - 1) + fibonacci(n - 2);
            }
        }
    }

    public static BigInteger factorial(BigInteger input){
        if(input.equals(BigInteger.ONE)) return BigInteger.ONE;
        else return input.multiply(factorial(input.subtract(BigInteger.ONE)));
    }
}
