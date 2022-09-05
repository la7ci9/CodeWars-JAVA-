/*
Detailed rules
The resulting expression is made of components like 4 seconds, 1 year, etc. In general, a positive integer and one of the valid units of time, separated by a space. The unit of time is used in plural if the integer is greater than 1.

The components are separated by a comma and a space (", "). Except the last component, which is separated by " and ", just like it would be written in English.

A more significant units of time will occur before than a least significant one. Therefore, 1 second and 1 year is not correct, but 1 year and 1 second is.

Different components have different unit of times. So there is not repeated units like in 5 seconds and 1 second.

A component will not appear at all if its value happens to be zero. Hence, 1 minute and 0 seconds is not valid, but it should be just 1 minute.

A unit of time must be used "as much as possible". It means that the function should not return 61 seconds, but 1 minute and 1 second instead. Formally, the duration specified by of a component must not be greater than any valid more significant unit of time.
*/

public class TimeFormatter {
    
    public static String formatDuration(int seconds) {
        // your code goes here
        String res = "";
        int[] units = new int[] {31536000, 86400, 3600, 60, 1};
        String[] labels = new String[] {"year", "day", "hour", "minute", "second"};
        
        if (seconds == 0){
          return "now";
        }
        
        for (int i = 0; i < 5; i++) {
          if (seconds >= units[i]) {
            int q = seconds / units[i];
            seconds = seconds % units[i];
            res += (res.equals("") ? "" : (seconds == 0 ? " and " : ", ")) + q + " " + labels[i] + (q > 1 ? "s" : "");              
          }
        }
        return res;
    }
}