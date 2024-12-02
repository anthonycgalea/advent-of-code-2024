package Day1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Day1Puzzle1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter input:");
        String input = "";
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        while(!input.equals("q")) {
            input = sc.nextLine();
            if (input.length() >= 2) {
                l1.add(Integer.parseInt(input.split("   ")[0]));
                l2.add(Integer.parseInt(input.split("   ")[1]));
            }
        }
        sc.close();
        Collections.sort(l1);
        Collections.sort(l2);
        int diff = 0;
        for (int i = 0; i < l1.size(); i++) {
            diff += Math.abs(l1.get(i)-l2.get(i));
        }
        System.out.println(""+diff);
    }

}