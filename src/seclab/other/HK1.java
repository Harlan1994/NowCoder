package seclab.other;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * User: Harlan1994
 * Date: 2017/9/14
 * Time: 15:46
 * Description:
 */
public class HK1 {

    public static void main(String[] args) {
        Depart root = new Depart();
        root.setId(0);

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] as = input.split(";");

        if (as.length < 3) {
            System.out.println("incorrect data");
            return;
        }

        for (int i = 0; i < as.length; i++) {
            String[] attrs = as[i].split(",");
            if (attrs.length < 3 || as[i].length() <= 0 || as[i].length() > 5) {
                System.out.println("incorrect data");
                return;
            }

            Depart depart = new Depart();
            depart.setId(Integer.parseInt(attrs[0]));
            depart.setName(attrs[1]);
            depart.setUpper(Integer.parseInt(attrs[2]));

            Depart findTarget = find(root, depart);
            if (findTarget != null) {
                findTarget.children.add(depart);
            }
        }
        List<String> result = new ArrayList<>();
        String path = "";
        traverse(root, result, path);

        for (int i = 0; i < result.size(); i++) {
            if (i == 0) System.out.print(result.get(i));
            else System.out.print(";" + result.get(i));
        }
    }

    // 1,A,0;2,B,1;3,C,1
    // 1,A,0;B,1,2;
    // 1,A,0;2,B,1;3,C,2;4,D,2
    // 2,A,0; 1,B,1;3,C,2
    public static void traverse(Depart root, List<String> result, String path) {
        Stack<Depart> nodes = new Stack<>();
        if (root == null) return;

        if (root.children.size() == 0) {
            if (path.equals("")) {
                path += root.getName();
            } else {
                path += "-" + root.getName();
            }

            result.add(path.substring(5));
        }

        if (path.equals("")) {
            path += root.getName();
        } else {
            path += "-" + root.getName();
        }

        for (Depart temp : root.children) {
            traverse(temp, result, path);
        }
    }

    public static Depart find(Depart root, Depart target) {
        if (target.getUpper() == root.getId()) return root;
        else {
            if (root.children != null) {
                for (Depart temp : root.children) {
                    return find(temp, target);
                }
            }
        }
        return null;
    }

    static class Depart {
        int upper;
        String name;
        int id;

        List<Depart> children = new ArrayList<>();

        public int getUpper() {
            return upper;
        }

        public void setUpper(int upper) {
            this.upper = upper;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}