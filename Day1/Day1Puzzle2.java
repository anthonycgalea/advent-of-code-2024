package Day1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Day1Puzzle2 {
    public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
        System.out.println("Enter input:");
        String input = "";
        List<Integer> l1 = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        while(!input.equals("q")) {
            input = sc.nextLine();
            if (input.length() >= 2) {
                l1.add(Integer.parseInt(input.split("   ")[0]));
                int numToAdd = Integer.parseInt(input.split("   ")[1]);
                map.put(numToAdd, 1+map.getOrDefault(numToAdd, 0));
            }
        }
        sc.close();
        int diff = 0;
        for (int i = 0; i < l1.size(); i++) {
            diff += Math.abs(l1.get(i)*map.getOrDefault(l1.get(i), 0));
        }
        System.out.println(""+diff);
    }

}
