/*
Move the first letter of each word to the end of it, then add "ay" to the end of the word. Leave punctuation marks untouched.

Examples
pigIt('Pig latin is cool'); // igPay atinlay siay oolcay
pigIt('Hello world !');     // elloHay orldway ! 
*/

public class PigLatin {
    public static String pigIt(String str) {
      String[] pieces = str.split(" ");
      for(int i = 0; i< pieces.length;i++){
        if(pieces[i].length() > 0 && Character.isLetter(pieces[i].charAt(0))){
          pieces[i] = pieces[i].substring(1) + pieces[i].charAt(0)+"ay";   
        }
      }
      return String.join(" ", pieces);
    }
}