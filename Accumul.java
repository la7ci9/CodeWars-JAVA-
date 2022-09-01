/*
This time no story, no theory. The examples below show you how to write function accum:

Examples:
accum("abcd") -> "A-Bb-Ccc-Dddd"
accum("RqaEzty") -> "R-Qq-Aaa-Eeee-Zzzzz-Tttttt-Yyyyyyy"
accum("cwAt") -> "C-Ww-Aaa-Tttt"
The parameter of accum is a string which includes only letters from a..z and A..Z. 
*/

public class Accumul {
    
    public static String accum(String s) {
     // your code
      StringBuilder sb = new StringBuilder();
      char[] chrs = s.toUpperCase().toCharArray();
      
      for(int i = 0;i<chrs.length;i++){
        sb.append(chrs[i]);
        for(int j = 0; j<i;j++){
          sb.append(Character.toLowerCase(chrs[i]));
        }
        if(i != chrs.length-1){
          sb.append("-");  
        }
      }
      return sb.toString();
    }
}