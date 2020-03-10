package problems.algorithms.p13;

import java.util.HashMap;
import java.util.Map;

import static utils.PrintUtils.print;

public class RomanToInteger {

    static Map<Character, Integer> values = new HashMap<>();

    static {
        values.put('M', 1000);
        values.put('D', 500);
        values.put('C', 100);
        values.put('L', 50);
        values.put('X', 10);
        values.put('V', 5);
        values.put('I', 1);
    }

    public int romanToInt(String s) {
        if (s.length() == 1) {
            return values.get(s.charAt(0));
        }

        int sum = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(i + 1);
            if (values.get(c1) >= values.get(c2)) {
                sum += values.get(c1);
            } else {
                sum -= values.get(c1);
            }
        }

        return sum + values.get(s.charAt(s.length() - 1));
    }

    public static void main(String[] args) {

        int ix = new RomanToInteger().romanToInt("MCMXCIV");
        print(ix);
    }


}
