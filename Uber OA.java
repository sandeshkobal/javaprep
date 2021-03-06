/*
Given two integer arrays a and b, and an integer value d, your task is to find the comparator value between these arrays.

The comparator value is defined as the number of elements x ∈ a such that there are no elements y ∈ b where |x - y| ≤ d.
In other words, it's the number of elements in a that are more than d away from any element of b.

*/
public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
	TreeSet<Integer> treeSet = new TreeSet<>();
	for(int b : arr2){
	    treeSet.add(b);
	}

	int ans = 0;
	for(int a: arr1){
	    Integer floor = treeSet.floor(a);
	    Integer ceiling = treeSet.ceiling(a);

	    int diff1=Integer.MAX_VALUE;
	    int diff2=Integer.MAX_VALUE;

	    if(floor!= null)
		diff1 = Math.abs(a-floor);

	    if(ceiling!= null)
		diff2 = Math.abs(a-ceiling);

	    if(Math.min(diff1,diff2) > d)
		ans++;
	}

	return ans;
}



// Product of digits  - sum if digits 
public int subtractProductAndSum(int n) {
	int product=1, sum=0;

	while(n>0){
	    int i = n%10;
	    n = n/10;
	    product *= i;
	    sum += i;
	}

	return product-sum;
}


/*
Easy:
Given an array A return an output array B of size [A.length - 2] where B[i] = 1 if sides A[i],A[i+1] and A[i+2] form a triangle. Otherwise, set B[i] = 0.
ex. A = [1, 2, 2, 5, 5, 4] should return B = [1,0,0,1]
*/
// The sum of the length of two sides of a triangle is always greater than the length of the third side.
for(int i=0;i<A.length-2;i++){
  int a=A[i],b=A[i+1]c=A[i+2];
  
  if(a+b>c && b+c>a && c+a>b)
    b[i]=1;
  else
    b[i]=0;
}

/*
Given two strings a and b, merge the strings so that the letters are added in alternating order starting with string a.
If one string is longer than the other, then append the letters to the end of the merged string.
ex. "abcd", "efghi" -> "aebfcgdhi"
ex. "", "abcd" -> "abcd"
ex. "abcdefg", "zxy" -> "azbxycdefg"
*/

int i=0;
int j=0;
while(i<=str.length()-1 || j<=str2.length()-1);
  char a = i<=str.length()-1 ? str.chat(i) : "";
  char b = j<=str2.length()-1 ? str2.chat(j) : "";
  append(a);
  append(b);
  i++;j++;


/*
Given a string s, return the longest and lexicographically smallest palindromic string that can be formed from the characters.
ex. "abbaa" -> "abba"
ex. "adeadeadevue" -> "adeeaeeda"
*/
public class Main {
    public static String lexLongestPalimdrome(String str){
        if(str==null || str.isEmpty())
            return "";
        
        int[] count = new int[26];
        for(char ch : str.toCharArray())
            count[ch-'a']++;
        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<count.length;i++){
            if(count[i]==0 || count[i]==1)
                continue;
            
            int mid = sb.length()/2;
            int c = count[i];
            char ch = (char) ((int)'a'+i);
            String s = Character.toString(ch);
            if(c%2==0){
                sb.insert(mid,s.repeat(c));
            } else {
                sb.insert(mid,s.repeat(c-1));
            }
        }
        
        for(int i=0;i<count.length;i++){
            if(count[i]%2==1){
                int mid = sb.length()/2; 
                char ch = (char) ((int)'a'+i);
                sb.insert(mid,ch);
                break;
            }
        }
            
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(lexLongestPalimdrome(""));
        System.out.println(lexLongestPalimdrome("adeadeadevue"));
        System.out.println(lexLongestPalimdrome("adskassda"));
        System.out.println(lexLongestPalimdrome("aahslqjjd"));
    }
}

/*
Given a string S, Count number of ways of splitting S into 3 non-empty a,b,c such 
that a+b, b+c, c+a are all different.

ex. xzxzx OP: 5
   x, z, xzx
	x, zx, zx
	xz, x, zx
	xz, xz, x
	xzx, z, x

// This is different NASTY problem but here is the solution 
this probem says there are only 2 characteres like above x and z and each substring must have specific number of x and z. 
https://leetcode.com/problems/number-of-ways-to-split-a-string/
https://leetcode.com/problems/number-of-ways-to-split-a-string/discuss/830455/JavaPython-3-Multiplication-of-the-ways-of-1st-and-2nd-cuts-w-explanation-and-analysis./685436
*/
// this is easy one if they are not similar like nasty problem one 
public class Main {
    public static int numberOfThreeWayCuts(String S){
        if(S==null || S.length()<3)
            return 0;
        
        int count=0;
        for(int i = 1; i<S.length()-1;i++){
            for(int j = i+1; j<S.length();j++){
                String a = S.substring(0,i);
                String b = S.substring(i,j);
                String c = S.substring(j);
                
                System.out.println(a +" "+b+" "+c);
                if(!((a+b).equals(b+c) || (b+c).equals(c+a) || (a+b).equals(c+a)))
                count++;
            }
        }
        return count;
    }
    
    public static void main(String[] args) {
        System.out.println(numberOfThreeWayCuts("xzxzx"));
        System.out.println(numberOfThreeWayCuts("XXX"));
    }
}

/*
We define a subarray of size m in an n-element array to be the contiguous block of elements in the inclusive range from index i to index j,
where j − i + 1 = m and 0 ≤ i ≤ j < n. For example, given array [8, 2, 4], the subarrays of size m = 2 would be [8, 2] and [2, 4] 
(but not [8, 4] since these elements aren't contiguous).

Given an array of integers arr, and an integer m, your task is the following:

Find the minimum value in each of the contiguous subarrays of size m;
Return the maximum value among these minimums.

This is like sliding window minimum problem ... and then finxidn max in it. 
*/
public int[] minSlidingWindow(int[] nums, int k) {
        
        if(nums==null||nums.length==0 ) 
            return new int[0];
        
        Deque<Integer> queue = new ArrayDeque<>();
    
        int[] ans = new int[nums.length-k+1];
        int ians=0;
        
        for(int i=0;i<nums.length;i++){
            // 1. if first index in  Q(Deque) < i-k+1
            if(!queue.isEmpty() && queue.peek() < i-k+1){
                queue.poll();
            }    
            
            // 2. loop: nums[i] < last element of the Q(Deque)?
            while(!queue.isEmpty() && nums[i] < nums[queue.peekLast()]){
                queue.pollLast();
            }
            
            // 3. offer(i)
            queue.offer(i);
            
            // 4. if window is complete then ouput nums[peek()]
            if(i>= k-1){ // OR   i-k+1 >= 0
                ans[ians++] = nums[queue.peek()];
            }
        }
        
        return ans;
    }


/*
Spiral matrix  you should sort elements in border. 

Traverse Spiral matrix and put it in HEAP ... make a list of heaps. 
second pass add those numbers in spiral.
*/
public List<Integer> spiralOrder(int[][] a) {
       
        List<Integer> list = new ArrayList<Integer>();
        if(a.length == 0) return list;

        int left=0, right=a[0].length-1;
        int top=0,  bottom=a.length-1;
        
        while(left<=right && top<=bottom){
            for(int i=left;i<=right;i++) 
                list.add(a[top][i]); 
            top++;
            for(int i=top;i<=bottom;i++) 
                list.add(a[i][right]);
            right--;
            
            if(top<=bottom){    // IMP 
                for(int i=right;i>=left;i--) 
                    list.add(a[bottom][i]);
                bottom--;
            }
            if(left<=right){   // IMP 
                for(int i=bottom;i>=top;i--) 
                    list.add(a[i][left]);
                left++;
            }
        }
        return list;
    }


/*
Q Given a string str and an integer k, your task is to split str into a minimal possible number of 
substrings so that there are no more than k different symbols in each of them. Return the minimal possible number of such substrings.

eg: s = "aabeefegeeccrr" k = 3 Output = 3
*/
int solve(String string) {
    int ans = 1;
    Set<Character> set = new HashSet<>();
    for(int i = 0; i < string.length(); i++) {
        
	if(set.contains(string.charAt(i))
	   continue; 
	   
        if(set.size() == K) {
           set = new HashSet<>();
           ans += 1;
        }
	   
        set.add(string.charAt(i));
    }
    return ans;
}
/*
 Prefix String - given two string arrays A & B, find if all strings in B are prefixes of a concatenation of strings in A. 
 For example if A = {"one", "two", "three"} B = {"onetwo", "one"}, return True
 
 .. this is a word break problem called m times. for B strings. 
 
 https://leetcode.com/problems/word-break/solution/
*/
	   
/*
Roatet matrix K time but dont rotate diagonals -> just do k = k%4;
https://github.com/xXLogicNotFoundXx/LeetCode-Java/blob/master/2D/101.java
*/
public int[][] rotate_without_extra_space(int[][] matrix) {
	int n = matrix.length;
	// transpose matrix
	for (int i = 0; i < n; i++) {
		for (int j = i; j < n; j++) {
			if (i == j || i + j == matrix.length - 1) {
				//Diagonal
			} else {
				int tmp = matrix[j][i];
				matrix[j][i] = matrix[i][j];
				matrix[i][j] = tmp;
			}
		}
	}
	// reverse each row
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n / 2; j++) {
			if (i == j || i + j == matrix.length - 1) {
				//Diagonal
			} else {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[i][n - j - 1];
				matrix[i][n - j - 1] = tmp;
			}
		}
	}
	return matrix;
}

	   
/*
Implement Increment function for all values in hashmap .. this one is easy 
*/
for(int key: map.keySet()){
   map.put(key, map.get(key)+1);
}
/*
Implement Increment function for all keys in hashmap ... 
1. extra o(n) space we can just craet another map 
2. for no extra map we can sort keys in reverse order and start putting key,value pairs  
*/
1. O(N) extra space & Time O(N)
HashMap<Integer,Integer> newMap = new HashMap<>();
for(int key: map.keySet()){
   newMap.put(key+1, map.get(key));
}
map = newMap;

2. O(1) space & Time O(NlogN)
List list = new ArrayList(map.keySet());
Collections.sort(list, Collections.reverseOrder);
for(Integer i: list) {
	map.put(i+1, map.get(i));
	map.remove(i);
}

/*
Group array by mean values:
*/
private static int[][] meanGroups(int[][] nums) {
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) {
            
            int mean = getMean(nums[i]);
            if(!map.containsKey(mean)) map.put(mean, new ArrayList<>());
            map.get(mean).add(i);
            
        }
        
        int[][] ret = new int[map.size()][];
        
        int j = 0;
        
        for(int key: map.keySet()) 
            ret[i++] = map.get(key).stream().mapToInt(j -> j).toArray();
           
        
        Arrays.sort(ret, (a,b) -> a[0] - b[0]);
        return ret;
    }
    
    private static int getMean(int[] A) {
        int sum = 0;
        for(int a: A) {
            sum += a;
        }
        
        return sum/A.length;
    }

	   
	   
	   
	   
/*
delete min of peak elements one by one in an array
Peak element defined as it should be greater than it’s neighbors.
2,7,8,5,1,6,3,9,4

8,6,9 are peak elements. You should remove 6 first.

Ans: 6,8,7,5,9,2,4,3,1
https://www.geeksforgeeks.org/minimum-peak-elements-from-an-array-by-their-repeated-removal-at-every-iteration-of-the-array/
*/
static List<Integer> deleteMinPeaks(int[] nums){
        
        List<Integer> ans = new ArrayList();
        
        if(nums==null || nums.length==0)
            return ans; 
        
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            list.add(nums[i]);
        }
        
        while(list.size() > 1){
            int index = getMinPeakIndex(list);
            ans.add(list.get(index));
            list.remove(index);
        }
        
        Collections.sort(list,Collections.reverseOrder());
        while(list.size()>0){
            ans.add(list.get(0));
            list.remove(0);
        }
        
        return ans; 
    }
    
    static int getMinPeakIndex(List<Integer> nums){
        int n=nums.size()-1;
        
        int index = -1;
        int minPeak = Integer.MAX_VALUE;
        
        for(int i=1;i<n;i++){
            
            if(nums.get(i) > nums.get(i-1) && 
               nums.get(i) > nums.get(i+1) &&
               nums.get(i) < minPeak  ){
                
                index=i;
                minPeak=nums.get(i);   
            }
        }
        // System.out.println(minPeak + " " + index);
        // Check boundaries 0 and n'th position .. think if the array was sorted dec,asc
        if(index==-1){
            if(nums.get(0) > nums.get(1)){
                index = 0;
            }
            
            if(index ==-1)
                return n;
            
            if(nums.get(n) > nums.get(n-1) &&  nums.get(n) < nums.get(0)){
                index = n;
            }
        }
        return index;
    }
    
    public static void main(String[] args) {
        int[] array= new int[]{2,7,8,5,1,6,3,9,4};
        // Ans: 6,8,7,5,9,2,4,3,1
        List<Integer> ans = deleteMinPeaks(array);
        System.out.println(ans);
    }
/*
You are given two arrays of integers a and b, and two integers lower and upper.
Your task is to find the number of pairs (i, j) such that lower ≤ a[i] * a[i] + b[j] * b[j] ≤ upper.
Example:
For a = [3, -1, 9], b = [100, 5, -2], lower = 7, and upper = 99, the output should be boundedSquareSum(a, b, lower, upper) = 4.
There are only four pairs that satisfy the requirement:
If i = 0 and j = 1, then a[0] = 3, b[1] = 5, and 7 ≤ 3 * 3 + 5 * 5 = 9 + 25 = 36 ≤ 99.
If i = 0 and j = 2, then a[0] = 3, b[2] = -2, and 7 ≤ 3 * 3 + (-2) * (-2) = 9 + 4 = 13 ≤ 99.
If i = 1 and j = 1, then a[1] = -1, b[1] = 5, and 7 ≤ (-1) * (-1) + 5 * 5 = 1 + 25 = 26 ≤ 99.
If i = 2 and j = 2, then a[2] = 9, b[2] = -2, and 7 ≤ 9 * 9 + (-2) * (-2) = 81 + 4 = 85 ≤ 99.
For a = [1, 2, 3, -1, -2, -3], b = [10], lower = 0, and upper = 100, the output should be boundedSquareSum(a, b, lower, upper) = 0.
Since the array b contains only one element 10 and the array a does not contain 0, it is not possible to satisfy 0 ≤ a[i] * a[i] + 10 * 10 ≤ 100.

*/
Sort the smaller array using the absolute value of the elements,
then for each element in the unsorted array, binary search the interval on the sorted one
https://stackoverflow.com/questions/64671811/bounded-square-sum-algorithm

	   
/*
Given a positive integer n, starting from 0 to n, if the number contains 0, 2, 4, count once. 
Implement a function that requires returning the count. Examples are:
*/
public int Count024UpToN(int N){
    int count = 1;
    for (int n = 1; n <= N; n++)
    {
	if (IsDigitPresent(n))
	    count++;
    }
    return count;
}

private bool IsDigitPresent(int n){
    while (n > 0)
    {
	int digit = n % 10;
	if (digit == 0 || digit == 2 || digit == 4)
	    return true;
	n /= 10;
    }
    return false;
}


/*
The 3rd question: Player 1 and Player 2 are playing a game:

Given an array A, delete the adjacent pair of the same value from A at each step (A == A[i+1], remove the pair of ( i, i+1) from A).
Game starts from Player 1, one step at a time. If there are no numbers to delete, the game is over. 
The one who takes the last step wins. 
The question asks to return who won.
Solution of Q3. Observe that the number or rounds will be the same no matter of the players choice [it would be good to see a proof for this, math related stuff].
If we accept this then the solution is trivial, runs in O(n) time using stack.
*/
string winner(vector<int> v){
    
    stack<int>S;
    
    for(int x:v){
        if(!S.empty() && S.top()==x)  S.pop();
        else S.push(x);
    }
    
    return ((v.size()-S.size())/2)%2==1?"Player 1":"Player 2";
}

int main(void){
    
    cout<<winner({1,0,1,0,0,1,0})<<endl;
    
    return 0;
}	   
	   

/*
Let's define the beauty of a square matrix as the minimal positive integer which doesn't appear in this matrix. 
For example, if the square matrix 2 x 2 contains the numbers 1, 2, 4, and 6, then the beauty of this matrix will be equal to 3.
You are given a square matrix of positive integers called 'numbers', and an integer 'size' which evenly divides numbers.length.
You task is to arrange the matrix elements in the following way:

Split the matrix into non-overlapping 'size x size' submatrices;
Arrange all the submatrices in ascending order of their beauty, then put them back into the matrix.
*/
// "static void main" must be defined in a public class.
// "static void main" must be defined in a public class.
public class Main {
   
    public static void beautyOfMatrix(int[][] matrix, int k){
        if(matrix.length%k!=0 || matrix[0].length%k!=0 )
            return;
        // Build a map with Block code and insert values 
        Map<String, List<Integer>> map = new HashMap<>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                String key = "Block"+i/k+":"+j/k;
                map.putIfAbsent(key,new ArrayList<Integer>());
                map.get(key).add(matrix[i][j]);
            }
        }
        
        // System.out.println(map);
       
        // get Sorted blocks by missing minimum value 
        TreeMap<Integer, List<List<Integer>> > treeMap = getTreeMapByMinValueMissing(map);
        
        // System.out.println(treeMap);
        // get all sorted block in order 
        List<List<Integer>> sortedBlocks = new ArrayList<List<Integer>>();
        for(List<List<Integer>> blocks : treeMap.values()){
            for(List<Integer> block : blocks){
                sortedBlocks.add(block);
            }
        }
        // System.out.println(sortedBlocks);
        int ind =0;
        for(int i=0;i<matrix.length/k;i++){
            for(int j=0;j<matrix[0].length/k;j++){
                fillBlock(i,j, k, sortedBlocks.get(ind++), matrix);
            }
        }
        
    }
    
    static void fillBlock(int blocki, int blockj, int k, List<Integer> block, int[][] matrix){
        int starti = blocki*k;
        int startj = blockj*k;
        int ind =0;
        for(int i=starti;i<starti+k;i++){
            for(int j=startj;j<startj+k;j++){
                matrix[i][j] = block.get(ind++);
            }
        }    
    }
    
    static TreeMap getTreeMapByMinValueMissing(Map<String, List<Integer>> map){
        TreeMap<Integer, List<List<Integer>> > treeMap = new TreeMap<>();
        for(List<Integer> block : map.values()){
            int missing = getMinValueMissing(block);
            treeMap.putIfAbsent(missing, new ArrayList<List<Integer>>());
            treeMap.get(missing).add(block);
        }
        return treeMap;
    }
    
    
    static int getMinValueMissing(List<Integer> block){
        int missing=1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.addAll(block);
        while(!pq.isEmpty()){
            if(pq.poll()==missing)
                missing++;
        }
        return missing;
    }
    
    
    static void printMatrix(int [][] matrix){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        int [][] matrix = new int[][]{
            {1 ,  2 ,  3 ,  1 ,  2 ,  3 , 1 ,   2 ,  3 },
            {4 ,  5 ,  6 ,  4 ,  5 ,  6 , 4 ,  5 ,  6 },
            {7 ,  8 , 10 ,  7 ,  8 , 10 , 8 ,  9 , 10 },
            {1 ,  2 ,  3 ,  1 ,  2 ,  3 , 1 ,  2 ,  3 }, 
            {4 ,  5 ,  7 ,  4 ,  6 ,  7 , 5 ,  6 ,  7 },
            {8 ,  9 , 10 ,  8 ,  9 , 10 , 8 ,  9 , 10 },
            {1 ,  2 ,  4 ,  1 ,  3 ,  4 , 2 ,  3 ,  4 }, 
            {5 ,  6 ,  7 ,  5 ,  6 ,  7 , 5 ,  6 ,  7 },
            {8 ,  9 , 10 ,  8 ,  9 , 10 , 8 ,  9 , 10 },
            
        };
        
        beautyOfMatrix(matrix,3);
        printMatrix(matrix);
        System.out.println("Hello World!");
    }
}
