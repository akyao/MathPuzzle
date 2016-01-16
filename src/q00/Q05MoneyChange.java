package q00;

/**
 * Created by akyao on 2016/01/16.
 */
public class Q05MoneyChange {

    private static int countChangeType(int money){

        int count = 0;
        for (int y500 = 0; (y500 < 15) && (y500 * 500 <= money); y500++) {
            for (int y100 = 0; (y500 + y100  < 15) && (y500 * 500 + y100 * 100 <= money); y100++) {
                //for (int y50 = 0; (y500 + y100 + y50 < 15) || (y500 * 500 + y100 * 100 + y50 * 50 > money); y50++) {
                for (int y50 = 0; (y500 + y100 + y50 <= 15); y50++) {
                    //for (int y10 = 0; (y500 + y100 + y50 + y10 < 15) || (y500 * 500 + y100 * 100 + y50 * 50 + y10 * 10 > money); y10++) {
                    for (int y10 = 0; (y500 + y100 + y50 + y10 <= 15); y10++) {
                        int sum = y500 * 500 + y100 * 100 + y50 * 50 + y10 * 10;
                        if (sum == money) {
//                            System.out.println(String.format("500=%s, 100=%s, 50=%s, 10=%s", y500, y100, y50, y10));
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    private static void printOut(int money) throws InterruptedException {
        System.out.println(String.format("money=%s, result=%s", money, countChangeType(money)));
    }

    public static void main(String[] args) throws InterruptedException {
        printOut(1000);
    }
}
