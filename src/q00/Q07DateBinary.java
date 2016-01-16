package q00;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by akyao on 2016/01/16.
 *
 * 日付を8桁で表現
 * それを2進数に変換
 * 逆に並び替え
 * それを再度10進数に戻す
 * その時下の日付と同じになるものはいくつ
 * 期間は19641010 -> 20200724
 */
public class Q07DateBinary {

    private static boolean isOk(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String date10 = date.format(formatter);
        int date10AsInt = Integer.parseInt(date10);
        String date2 = Integer.toBinaryString(date10AsInt);
        String date2r = reverse(date2);
        int date10r = Integer.parseUnsignedInt(date2r, 2);
        return date10AsInt == date10r;
    }

    private static List<LocalDate> check(LocalDate fromDate, LocalDate toDate) {
        List<LocalDate> result = new ArrayList<>();
        for (LocalDate loopDate = fromDate; loopDate.isBefore(toDate) || loopDate.isEqual(toDate); loopDate = loopDate.plusDays(1) ) {
            if (isOk(loopDate)) {
                result.add(loopDate);
            }
        }
        return result;
    }

    private static void printOut(LocalDate fromDate, LocalDate toDate) {
        List<LocalDate> result = check(fromDate, toDate);
        System.out.println(String.format("fromDate=%s, toDate=%s", fromDate, toDate));
        result.stream().forEach(ld -> System.out.println(" " + ld));
    }

    private static String reverse(String s) {
        StringBuffer sb = new StringBuffer(s);
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
//        System.out.println(isOk(LocalDate.of(1966, 7, 14)));

        printOut(LocalDate.of(1964, 10, 10), LocalDate.of(2020, 7, 24));

//        printOut(10000);
//        checkCollatz(4);
    }
}

