package q00;

import java.util.ArrayList;
import java.util.List;

import static java.util.Comparator.*;
import static java.util.Comparator.comparing;

/**
 * Created by akyao on 2016/01/16.
 */
public class Q04CutBar {

    private static List<Integer> cutToHalf(int bar) {
        List<Integer> result = new ArrayList<Integer>();
        double half = bar / 2.0;
        if (bar % 2 == 0) {
            result.add((int)half);
            result.add((int)half);
        } else {
            result.add((int)Math.ceil(half));
            result.add((int)Math.floor(half));
        }
        return result;
    }

    private static List<Integer> cut(List<Integer> bars, int m) {
        List<Integer> cutBars = new ArrayList<Integer>();
        int cutTimes = Math.min(bars.size(), m);
        for (int i = 0; i < cutTimes; i++) {
            int bar = bars.remove(0);
            if (bar == 1) {
                cutBars.add(bar);
                break;
            }
            cutBars.addAll(cutToHalf(bar));
        }
        cutBars.addAll(bars);
        cutBars.sort(reverseOrder());
        return cutBars;
    }

    private static boolean isAllFucked(List<Integer> bars) {
        return bars.stream().allMatch(n -> n == 1);
    }

    private static int calcCutTime(int n, int m) throws InterruptedException {
        if (n <= 1) {
            return 0;
        } else if (m < 1) {
            throw new IllegalArgumentException();
        }

        List<Integer> bars = new ArrayList<Integer>();
        bars.add(n);

        for (int i = 1; ; i++) {
//            System.out.println(bars);
            bars = cut(bars, m);
            if (isAllFucked(bars)) {
                return i;
            }
//            Thread.sleep(1000);
        }
    }

    private static void fuck(int n, int m) throws InterruptedException {
        System.out.println(String.format("n=%s, m=%s, result=%s", n, m, calcCutTime(n, m)));
    }

    public static void main(String[] args) throws InterruptedException {
        fuck(20, 3);
        fuck(100, 5);
    }
}
