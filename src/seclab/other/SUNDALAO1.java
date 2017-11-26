package seclab.other;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * User: Harlan1994
 * Date: 2017/9/10
 * Time: 16:47
 * Description:
 */
public class SUNDALAO1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        Set<Fileds> set = new HashSet<>();

        int max = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i < j) {
                    if (isZero(i, j, array)) {
                        for(Fileds fileds:set){
                            if(!ok(fileds, new Fileds(i, j))){
                                set.add(new Fileds(i, j));
                            }
                        }
                    }
                }
            }
        }

        System.out.println(set.size());
    }

    public static boolean ok(Fileds a, Fileds b) {
        return a.getJ() < b.getI() || b.getJ() < a.getI();
    }

    static boolean isZero(int i, int j, int[] array) {
        int a = array[0];
        for (int x = i; x <= j; x++) {
            a ^= array[x];
        }
        return a == 0;
    }

    static class Fileds {
        int i;
        int j;

        public Fileds(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
        }

        public int getJ() {
            return j;
        }

        public void setJ(int j) {
            this.j = j;
        }



        @Override
        public boolean equals(Object obj) {
            return this.getI() == ((Fileds) obj).getI() && this.getJ() == ((Fileds) obj).getJ();
        }
    }
}