/*
In this kata we want to convert a string into an integer. The strings simply represent the numbers in words.

Examples:

"one" => 1
"twenty" => 20
"two hundred forty-six" => 246
"seven hundred eighty-three thousand nine hundred and nineteen" => 783919
Additional Notes:

The minimum number is "zero" (inclusively)
The maximum number, which must be supported is 1 million (inclusively)
The "and" in e.g. "one hundred and twenty-four" is optional, in some cases it's present and in others it's not
All tested numbers are valid, you don't need to validate them 
*/

import java.util.HashMap;
public class Parser {
    
    public static int parseInt(String numStr) {
      HashMap<String, Integer> pairs = new HashMap<String, Integer>(){
	        { put("zero", 0);put("one",1);put("two",2); put("three",3); put("four",4); put("five",5); 
	          put("six",6); put("seven",7); put("eight",8); put("nine",9); put("ten",10); put("eleven",11); 
	          put("twelve",12); put("thirteen",13); put("fourteen",14); put("fifteen",15); put("sixteen",16);
	          put("seventeen",17); put("eighteen",18); put("nineteen",19); put("twenty",20); put("thirty",30);
	          put("forty",40); put("fifty",50); put("sixty",60); put("seventy",70); put("eighty",80); 
	          put("ninety",90);
	        }};
	      HashMap<String, Integer> multipliers = new HashMap<String, Integer>(){
	        { put("hundred",100);put("thousand",1000);put("million",1000000);} };
	        
	      String[] words = numStr.replaceAll(" and", "").split("\\W");
	      
	      if(words.length == 1){
	        int res = pairs.get(words[0]) != null ? pairs.get(words[0]) : multipliers.get(words[0]);
	        return res;
	      }
	      
	      int part1 = 0;
	      int part2 = 0;
	      for(String w : words) {
	    	  if(pairs.get(w) != null) {
	    		  part1 += pairs.get(w);
	    	  }else if(multipliers.get(w) == 1000){
	    		  part1 *= multipliers.get(w);
	    		  part2 = part1; 
	    		  part1 = 0;
	    	  } else {
	    		  part1 *= multipliers.get(w);
	    	  }
	      }
	      return part1+part2;
	    }
}