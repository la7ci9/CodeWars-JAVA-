/*
Write a function, which takes a non-negative integer (seconds) as input and returns the time in a human-readable format (HH:MM:SS)

HH = hours, padded to 2 digits, range: 00 - 99
MM = minutes, padded to 2 digits, range: 00 - 59
SS = seconds, padded to 2 digits, range: 00 - 59
The maximum time never exceeds 359999 (99:59:59)

You can find some examples in the test fixtures.
*/

public class HumanReadableTime {
    public static String makeReadable(int seconds) {
      // Do something
      int[] pieces = new int[2];
      int[] time = {3600,60};
      int remainingSec = seconds;
      for(int i = 0; i < time.length;i++){
        pieces[i] = remainingSec / time[i];
        remainingSec = remainingSec % time[i];
      }
      return String.format("%02d:%02d:%02d",pieces[0],pieces[1],remainingSec);
    }
}