package q00;

/**
 * Created by akyao on 2016/01/11.
 * 10進数でも2進数でも8進数でも回文になる数字
 */
public class Q01Kaibun {

    private static boolean isKaibun(String str) {
        // ちょっと無駄が多い
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(str.length() -1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static int calcKaibun() {
        for (int i = 10; ; i++) {
            boolean isKaibun10 = isKaibun(String.valueOf(i));
            boolean isKaibun2 = isKaibun(Integer.toBinaryString(i));
            boolean isKaibun8 = isKaibun(Integer.toOctalString(i));
            if (isKaibun10 && isKaibun2 && isKaibun8) {
                return i;
            }
        }
    }

    public static void main(String args[]) {
        int result = calcKaibun();
        System.out.println(String.format("10:%s, 2:%s, 8:%s", result, Integer.toBinaryString(result),Integer.toOctalString(result)));
//        System.out.println(isKaibun("1"));
//        System.out.println(isKaibun("11"));
//        System.out.println(isKaibun("12"));
//        System.out.println(isKaibun("121"));
//        System.out.println(isKaibun("12321"));
//        System.out.println(isKaibun("123421"));
    }
}
