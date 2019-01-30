/**
https://stackoverflow.com/questions/10813154/how-do-i-convert-a-number-to-a-letter-in-java
https://beginnersbook.com/2013/12/java-string-tochararray-method-example/
Reilly Grant pointed us towards the above command on turning strings into arrays

 * 
 */
package driver;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * @author chahannah
 *
 */
public class CaesarCipher {

  /**
   * @param args
   */
  public static void main(String[] args) throws Exception {
    // TODO Auto-generated method stub

    PrintWriter pen = new PrintWriter(System.out, true);
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    
    pen.print("Please input a word or phrase: ");
    String input = read.readLine(); // take in the user's string
    char [] arr = input.toCharArray(); // transform the string into an array of chars
    
    for (int n = 0; n < 26; n++) { 
      pen.print("n = " + n + ": ");
      for(int i = 0; i< input.length();i++) {
        arr[i] = (char)(arr[i] + n);
        //char o = (char) ('A' + n);
        pen.print(arr[i]);
      }
      pen.println();
      pen.flush();
    }

  }

}
