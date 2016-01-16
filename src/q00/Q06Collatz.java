package q00;

/**
 * Created by akyao on 2016/01/16.
 * nが偶数の場合n = n /2
 * nが奇数の場合 n = n * 3 + 1
 * 繰り返す
 * 10000以下の偶数のうち、最初の数に戻る数はいくつあるか？
 */
public class Q06Collatz {

    private static boolean checkCollatz(final int n) {
        int n2 = (n % 2 == 0) ? n * 3 + 1 : n;
        while (true) {
//            System.out.println(n2);
            n2 = (n2 % 2 == 0) ? n2 /2 : n2 * 3 + 1;
            if (n2 == 1) {
                return false;
            } else if (n2 == n) {
                return true;
            }
        }
    }

    private static int calcCollatzCount(int n) {
        if (n <= 1) {
            return 0;
        } else {
            return (checkCollatz(n) ? 1 : 0) + calcCollatzCount(n - 2);
        }
    }

    private static void printOut(int n) throws InterruptedException {
        System.out.println(String.format("n=%s, result=%s", n, calcCollatzCount(n)));
    }

    public static void main(String[] args) throws InterruptedException {
        printOut(10000);
//        checkCollatz(4);
    }
}
