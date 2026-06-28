import java.util.Arrays;

class Leetcode {

  // Leetcode word mapping problem
  
  public static String mapWordWeights(String[] words, int[] weights) {
    StringBuilder result = new StringBuilder();

    for (String word : words ) {
      int sumWeight = 0;

      for (char ch : word.toCharArray()) {
        sumWeight += weights[ch - 'a'];
      }

      int value = sumWeight % 26;

      result.append((char)('z' - value));
    }
    return result.toString();
  }


  // Process string with special operations I

  public static String processStr(String s) {
    StringBuilder result = new StringBuilder();

    for (char ch : s.toCharArray()) {
        
        if (ch >= 'a' && ch <= 'z') {
            result.append(ch);
        }
        
        else if (ch == '*' && result.length() > 0) {
            result.deleteCharAt(result.length() - 1);
        }
        
        else if (ch == '#') {
            result.append(result.toString());
        }
        
        else if (ch == '%') {
            result.reverse(); 
        }
    }
    
    return result.toString();
  }

  

  // 1846. Maximum Element After Decreasing and Rearranging
  //below is a tempted solution that passed 48 of the test cases 
  public static int maximumElementAfterDecrementingAndRearranging(int[] arr) {
    Arrays.sort(arr);

    for (int i = 0;  i < arr.length; i++) {
        if (arr[i] > 3) {
            arr[i] = i + 1;
        }
    }

    if (arr[0] != 1) {
        for (int i = 1;  i < arr.length; i++) {
            if (arr[i] == 1) {
                int temp = arr[0];
                arr[0] = arr[i];
                arr[i] = temp;
            }
        }
    }


    for (int i = 1;  i < arr.length-1; i++) {

        if (Math.abs(arr[i] - arr[i + 1]) > 1) {
            for (int j = i + 2; j < arr.length; j++) {
                if (Math.abs(arr[i] - arr[j]) <= 1) {
                    int temp = arr[i + 1];
                    arr[i + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
            
    }




    return Arrays.stream(arr)
              .max()
              .getAsInt();
  }


  // 1846. Maximum Element After Decreasing and Rearranging
  // after making making research on how to make it correct and optimised, came up with this solution 




  public static int maximumElementAfterDecrementingAndRearrangingOptimal(int[] arr) {
    // 1. Sort the array to get the optimal rearrangement
    Arrays.sort(arr);

    // 2. The first element must always be 1
    arr[0] = 1;

    // 3. Iterate through and ensure no adjacent element grows by more than 1
    for (int i = 1; i < arr.length; i++) {
        if (arr[i] - arr[i - 1] > 1) {
            arr[i] = arr[i - 1] + 1; // Decrement it to the maximum allowed value
        }
    }

    // 4. After sorting and capping, the last element is guaranteed to be the max
    return arr[arr.length - 1];
  }
}
    