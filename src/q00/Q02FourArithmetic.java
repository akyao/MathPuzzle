package q00;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akyao on 2016/01/14.
 * 4桁の数字
 * 任意の箇所で分割して、それを四則演算で計算
 * その結果が元の数値の逆順と一致するもののを抽出
 * 
 * TODO evalがない言語には辛い
 */
public class Q02FourArithmetic {

    private static List<Integer> split(int i) {
        return null;
    }

    private static int reverse(int num) {
        List<Integer> splited = split(num);
        String s = "";
        for (int i = splited.size() - 1; i < 0; i--) {
            s += String.valueOf(splited.get(i));
        }
        return Integer.valueOf(s);
    }

    private static boolean isAnswer(int num) {
        List<Integer> splited = split(num);
        int answer = reverse(num);

    }

    public static void main(String[] args) {
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 1000; i < 10000; i++) {
            if (isAnswer(i)) {
                result.add(i);
            }
        }
        System.out.println(result);
    }
}
