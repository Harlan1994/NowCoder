package seclab.other;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * User: Harlan1994
 * Date: 2017/9/2
 * Time: 15:26
 * Description:
 */
public class PinDuoDuo2 {

    public static void main(String[] args) {
        FileTree fileTree = new FileTree();
        Scanner scanner = new Scanner(System.in);
        int ops = Integer.parseInt((scanner.nextLine()));
        for(int i = 0; i < ops; i++){
            String line = scanner.nextLine();
            String[] lineSplit = line.split(" ");
            String file = lineSplit[0];
            int op = Integer.parseInt(lineSplit[1]);
            //fileTree.addNode(file, op);
        }


    }
}