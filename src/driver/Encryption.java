/*
 * https://stackoverflow.com/questions/10813154/how-do-i-convert-a-number-to-a-letter-in-java
 * https://beginnersbook.com/2013/12/java-string-tochararray-method-example/ Reilly Grant pointed us
 * towards the above command on turning strings into arrays (even though it was in the Assignment)
 * https://rosettacode.org/wiki/Vigen%C3%A8re_cipher#Java Jonathan Sadun helped with arithmetic for
 * looping from a to z when decoding https://www.geeksforgeeks.org/difference-equals-method-java/
 */

package driver;

import java.io.PrintWriter;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Encryption {

  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    Scanner in = new Scanner(System.in);

    String input;
    String MyInput;
    System.out.print("java CasearCipher ");

    MyInput = in.next();
    input = in.nextLine();

    // if (!in.hasNext())
    // pen.print("Incorrect number of parameters");
    // System.out.print("Please input a word or phrase: ");

    // System.out.println("TEST: "+ input);
    // pen.print("Please input a word or phrase: ");
    // String input = read.readLine();
    char[] arr = input.toCharArray();
    char[] arr2 = input.toCharArray();
    // System.out.println ((char)(arr[1] + 1));
    int i = 0;
    boolean done = false;
    while (!done) {
      if (Character.isUpperCase(arr[i])) {
        pen.println("String to be en/decoded must be all lowercase");
        pen.flush();
        done = true;
      }
      i++;
    }

    if ((MyInput.equals("encode")) && (done == false)) {
      Encode(arr, input);
    } else if ((MyInput.equals("decode")) && (done == false)) {
      Decode(arr, input);
    } else if ((MyInput.equals("decode")) || (MyInput.equals("encode")) && (done == true)) {
      pen.print("");
      pen.flush();
    } else {
      pen.println("Valid options are \"encode\" and \"decode\"");
      pen.flush();
    }



    /*
     * // Encode for (int n = 0; n < 26; n++) { System.out.println("n = " + n + ": "); for (int i =
     * 0; i < input.length(); i++) {
     * 
     * if (Character.isUpperCase(arr[i])) { char MyArray; MyArray = arr[i]; arr[i] = (char) (((int)
     * arr[i] + n - 65) % 26 + 65); // char test = (char)(((int)arr[i] + n - 65)%26 + 65); //
     * System.out.println("TEST: " + test); System.out.print(arr[i]); arr[i] = MyArray; // arr[i] =
     * (char)(((int)arr[i] - n + 65)%26 - 65); } else if (Character.isLowerCase(arr[i])) { char
     * MyArray2; MyArray2 = arr[i]; arr[i] = (char) (((int) arr[i] + n - 97) % 26 + 97);
     * System.out.print(arr[i]); arr[i] = MyArray2; } } System.out.println(""); } // decode
     * System.out.println(""); System.out.println("Decode"); for (int n = 0; n < 26; n++) {
     * System.out.println("n = " + n + ": "); for (int i = 0; i < input.length(); i++) {
     * 
     * if (Character.isUpperCase(arr[i])) { char MyArray; MyArray = arr[i]; arr[i] = (char) (((int)
     * arr[i] - n - 65 + 26) % 26 + 65); // char test = (char)(((int)arr[i] + n - 65)%26 + 65); //
     * System.out.println("TEST: " + test); System.out.print(arr[i]); arr[i] = MyArray; // arr[i] =
     * (char)(((int)arr[i] - n + 65)%26 - 65); } else if (Character.isLowerCase(arr[i])) { char
     * MyArray2; MyArray2 = arr[i]; arr[i] = (char) ((((int) arr[i] - n - 97 + 26 ) % 26 + 97));
     * //System.out.println("TEST:"+-1%26); int test = (int) arr[i]; // System.out.print("TEST: "
     * +test); System.out.print(arr[i]); arr[i] = MyArray2; } } System.out.println(""); }
     */

    /*
     * // encode? String key; System.out.println(""); System.out.print("Enter your key: "); key =
     * in.nextLine(); char[] MyKey = key.toCharArray();
     * 
     * int counter = 0; for (int m = 0; m < arr.length; m++) { if (counter == (MyKey.length)) {
     * counter = 0; } if (Character.isLowerCase(arr[m])) { if
     * (Character.isUpperCase(MyKey[counter])) { MyKey[counter] =
     * Character.toLowerCase(MyKey[counter]); } arr[m] = (char) ((((int) arr[m]) + ((int)
     * MyKey[counter]) - 2 * 97) % 26 + 97); // lowercase System.out.print(arr[m]); counter++; }
     * else if (Character.isUpperCase(arr[m])) { if (Character.isLowerCase(MyKey[counter])) {
     * MyKey[counter] = Character.toUpperCase(MyKey[counter]); } arr[m] = (char) ((((int) arr[m]) +
     * ((int) MyKey[counter]) - 2 * 65) % 26 + 65); // lowercase System.out.print(arr[m]);
     * counter++; } }
     * 
     * // decode Vigenère Cipher // formula (Ei - Ki + 26) mod 26 System.out.println(" ");
     * System.out.println("Decode Vigenère Cipher"); int counter2 = 0; for (int m = 0; m <
     * arr.length; m++) { if (counter2 == (MyKey.length)) { counter2 = 0; } if
     * (Character.isLowerCase(arr2[m])) { if (Character.isUpperCase(MyKey[counter2])) {
     * MyKey[counter2] = Character.toLowerCase(MyKey[counter2]); } arr2[m] = (char) ((((int)
     * arr2[m]) - ((int) MyKey[counter2]) + 26) % 26 + 97); // lowercase System.out.print(arr2[m]);
     * counter2++; } else if (Character.isUpperCase(arr2[m])) { if
     * (Character.isLowerCase(MyKey[counter2])) { MyKey[counter2] =
     * Character.toUpperCase(MyKey[counter2]); } arr2[m] = (char) ((((int) arr2[m]) - ((int)
     * MyKey[counter2]) + 26) % 26 + 65); // lowercase System.out.print(arr2[m]); counter2++; } }
     */

  }

  public static void Encode(char arr[], String input) {
    for (int n = 0; n < 26; n++) {
      System.out.print("n = " + n + ": ");
      for (int i = 0; i < input.length(); i++) {

        if (Character.isUpperCase(arr[i])) {
          char MyArray;
          MyArray = arr[i];
          arr[i] = (char) (((int) arr[i] + n - 65) % 26 + 65);
          // char test = (char)(((int)arr[i] + n - 65)%26 + 65);
          // System.out.println("TEST: " + test);
          System.out.print(arr[i]);
          arr[i] = MyArray;
          // arr[i] = (char)(((int)arr[i] - n + 65)%26 - 65);
        } else if (Character.isLowerCase(arr[i])) {
          char MyArray2;
          MyArray2 = arr[i];
          arr[i] = (char) (((int) arr[i] + n - 97) % 26 + 97);
          System.out.print(arr[i]);
          arr[i] = MyArray2;
        }
      }
      System.out.println("");
    }
  }

  public static void Decode(char arr[], String input) {
    System.out.println("");
    System.out.println("Decode");
    for (int n = 0; n < 26; n++) {
      System.out.println("n = " + n + ": ");
      for (int i = 0; i < input.length(); i++) {

        if (Character.isUpperCase(arr[i])) {
          char MyArray;
          MyArray = arr[i];
          arr[i] = (char) (((int) arr[i] - n - 65 + 26) % 26 + 65);
          // char test = (char)(((int)arr[i] + n - 65)%26 + 65);
          // System.out.println("TEST: " + test);
          System.out.print(arr[i]);
          arr[i] = MyArray;
          // arr[i] = (char)(((int)arr[i] - n + 65)%26 - 65);
        } else if (Character.isLowerCase(arr[i])) {
          char MyArray2;
          MyArray2 = arr[i];
          arr[i] = (char) ((((int) arr[i] - n - 97 + 26) % 26 + 97));
          // System.out.println("TEST:"+-1%26);
          int test = (int) arr[i];
          // System.out.print("TEST: " +test);
          System.out.print(arr[i]);
          arr[i] = MyArray2;
        }
      }
      System.out.println("");
    }
  }

}
