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
}