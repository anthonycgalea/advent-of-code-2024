package Day2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day2Puzzle1 {
    public static void main(String[] args) {
        File f = new File(args[0]);
        int safe = 0;
        try (Scanner sc = new Scanner(f)) {
            while(sc.hasNextLine()) {
                String line = sc.nextLine();
                List<Integer> thisLine = new ArrayList<Integer>();
                for (String s : line.split(" ")) {
                    thisLine.add(Integer.parseInt(s));
                }
                if (thisLine.isEmpty()) {
                    break;
                }
                int neg = thisLine.get(0) > thisLine.get(thisLine.size()-1) ? -1 : 1;
                boolean flag = true;
                for (int i = 1; i < thisLine.size(); i++) {
                    int test = (thisLine.get(i) - thisLine.get(i-1))*neg;
                    if (test < 1 || test > 3) {
                        flag = false;
                        break;
                    }
                }
                safe += flag ? 1 : 0;
            }
        } catch (Exception e) {
            System.out.println("File exception");
            e.printStackTrace();
            return;
        }
        System.out.println("Answer: " + safe);
    }
}
