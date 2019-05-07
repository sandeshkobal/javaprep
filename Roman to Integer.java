https://leetcode.com/problems/roman-to-integer/

Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
Example 1:

Input: "III"
Output: 3
Input: "IV"
Output: 4
Input: "IX"
Output: 9
Input: "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.
Input: "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

class Solution {
    public int romanToInt(String s) {
        if(s==null || s.isEmpty())
            return 0;
        int []nums = new int[s.length()];
        int total = 0;
        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        
        for(int i=0;i<s.length();i++)
            nums[i] = map.getOrDefault(s.charAt(i),0);
        
        for(int i=0;i<s.length();i++){
            total += nums[i];
            if(i!=0 && nums[i]>nums[i-1])
                total = total - (2*nums[i-1]);
        }
        return total;
    }
}

