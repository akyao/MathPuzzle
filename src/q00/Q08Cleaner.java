package q00;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akyao on 2016/01/17.
 */
public class Q08Cleaner {

    static class FootPrint {

        private int x;
        private int y;

        FootPrint(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof FootPrint) {

                FootPrint obj2 = (FootPrint) obj;
                return this.x == obj2.x && this.y == obj2.y;
            }
            return false;
        }

        private FootPrint move(int x, int y) {
            return new FootPrint(this.x + x, this.y + y);
        }

        @Override
        public String toString() {
            return String.format("[%s,%s]", this.x, this.y);
        }
    }

    static class Route {

        List<FootPrint> foots = new ArrayList<>();

        Route(){
        }

        Route(int initX, int initY){
            foots.add(new FootPrint(initX, initY));
        }

        private void add(FootPrint foot) {
            foots.add(foot);
        }

        private boolean isArelady(FootPrint foot) {
            return foots.contains(foot);
        }

        private FootPrint current() {
            return this.foots.get(foots.size() - 1);
        }

        private Route copy() {
            Route newRoute = new Route();
            newRoute.foots.addAll(this.foots);
            return newRoute;
        }
    }

    private static int countRoute(Route route, int nokori) {
        if (nokori == 0) {
            return 1;
        }

        FootPrint current = route.current();
        int[] moves = {-1, 1};
        int okRouteCount = 0;
        for (int x = 0; x < moves.length; x++) {
            for (int y = 0; y < moves.length; y++) {
                FootPrint next = current.move(moves[x], moves[y]);
//                System.out.println(next);
                if (!route.isArelady(next)) {
                    Route newRoute = route.copy();
                    newRoute.add(next);
                    okRouteCount += countRoute(newRoute, nokori - 1);
                }
            }
        }
        return okRouteCount;
    }

    private static int fuck(int n) {
        return countRoute(new Route(0, 0), n);
    }

    private static void printOut(int n) {
        System.out.println(String.format("n=%s, result=%s", n, fuck(n)));
    }

    public static void main(String[] args) {
        printOut(12);
    }
}
