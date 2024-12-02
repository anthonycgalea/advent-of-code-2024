package Day2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day2Puzzle2 {
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
                boolean flagR = true;
                for (int i = 1; i < thisLine.size(); i++) {
                    int test = (thisLine.get(i) - thisLine.get(i-1))*neg;
                    if (test < 1 || test > 3) {
                        if (flagR) {
                            if (i+1 == thisLine.size()) {
                                flag = false;
                                break;
                            }
                            test = (thisLine.get(i+1) - thisLine.get(i-1))*neg;
                            if (test < 1 || test > 3) {
                                flag = false;
                                break;
                            }
                            i++;
                            flagR = false;
                        } else {
                            flag = false;
                            break;
                        }
                    }
                }
                if (flag) {
                    safe++;
                    continue;
                } 
                //skip 1
                flag = true;
                neg = thisLine.get(1) > thisLine.get(thisLine.size()-1) ? -1 : 1;
                for (int i = 2; i < thisLine.size(); i++) {
                    int test = (thisLine.get(i) - thisLine.get(i-1))*neg;
                    if (test < 1 || test > 3) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    safe++;
                    continue;
                }
                //skip end
                flag = true;
                neg = thisLine.get(0) > thisLine.get(thisLine.size()-2) ? -1 : 1;
                for (int i = 1; i < thisLine.size()-1; i++) {
                    int test = (thisLine.get(i) - thisLine.get(i-1))*neg;
                    if (test < 1 || test > 3) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    safe++;
                }
            }
        } catch (Exception e) {
            System.out.println("File exception");
            e.printStackTrace();
            return;
        }
        System.out.println("Answer: " + safe);
    }
}
