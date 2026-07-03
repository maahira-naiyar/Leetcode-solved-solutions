// class Solution {
//     public String reversePrefix(String word, char ch) {
     
//         int targetIndex = word.indexOf(ch);
 
//         if (targetIndex == -1) {
//             return word;
//         }

//         char[] charArray = word.toCharArray();

//         int left = 0;
//         int right = targetIndex;
      
//         while (left < right) {

//             char temp = charArray[left];
//             charArray[left] = charArray[right];
//             charArray[right] = temp;

//             left++;
//             right--;
//         }
      
       
//         return String.valueOf(charArray);
//     }
// }


class Solution {
  public String reversePrefix(String word, char ch) {
    final int i = word.indexOf(ch) + 1;
    return new StringBuilder(word.substring(0, i)) //
        .reverse()                                 //
        .append(word.substring(i))                 //
        .toString();
  }
}
