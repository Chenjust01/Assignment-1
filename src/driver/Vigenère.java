package driver;
import java.io.PrintWriter;

public class Vigenère {
  
  public static void main(String[] args) throws Exception {
    
    PrintWriter pen = new PrintWriter(System.out, true);
    
    if (args.length != 3) {                               // test if input has two input words
      pen.println("Incorrect number of parameters");
      pen.flush();
    } else {                                              // if it has the correct number of parameters
      char[] arr = args[1].toCharArray();                 // convert the word to en/decode into an array

      int i = 0;
      boolean done = false;
      while (arr.length > i) {
        if (Character.isUpperCase(arr[i])) {
          done = true;
        }
        i++;
      }

      if ((args[0].equals("encode")) && (done == false)) {
        Encode(arr, args[1], args[2]);
      } else if ((args[0].equals("decode")) && (done == false)) {
        Decode(arr, args[1], args[2]);
      } else if ((args[0].equals("decode")) || (args[0].equals("encode")) && (done == true)) {
        pen.println("String to be en/decoded must be all lowercase");
        pen.flush();
      } else {
        pen.println("Valid options are \"encode\" and \"decode\"");
        pen.flush();
      }
    }

  }
  
  public static void Encode(char arr[], String input, String key) {
//encode?


char[] MyKey = key.toCharArray();

int counter = 0;
for (int m = 0; m < arr.length; m++) {
    if (counter == (MyKey.length)) {
        counter = 0;
    }
    if (Character.isLowerCase(arr[m])) {
        if (Character.isUpperCase(MyKey[counter])) {
            MyKey[counter] = Character.toLowerCase(MyKey[counter]);
        }
        arr[m] = (char) ((((int) arr[m]) + ((int) MyKey[counter]) - 2 * 97) % 26 + 97); // lowercase
        System.out.print(arr[m]);
        counter++;
    } else if (Character.isUpperCase(arr[m])) {
        if (Character.isLowerCase(MyKey[counter])) {
            MyKey[counter] = Character.toUpperCase(MyKey[counter]);
        }
        arr[m] = (char) ((((int) arr[m]) + ((int) MyKey[counter]) - 2 * 65) % 26 + 65); // lowercase
        System.out.print(arr[m]);
        counter++;
    }
}
}

public static void Decode(char arr2[], String input,String key) {
// decode Vigenère Cipher
// formula (Ei - Ki + 26) mod 26

char[] MyKey = key.toCharArray();
int counter2 = 0;
for (int m = 0; m < arr2.length; m++) {
    if (counter2 == (MyKey.length)) {
        counter2 = 0;
    }
    if (Character.isLowerCase(arr2[m])) {
        if (Character.isUpperCase(MyKey[counter2])) {
            MyKey[counter2] = Character.toLowerCase(MyKey[counter2]);
        }
        arr2[m] = (char) ((((int) arr2[m]) - ((int) MyKey[counter2]) + 26) % 26 + 97); // lowercase
        System.out.print(arr2[m]);
        counter2++;
    } else if (Character.isUpperCase(arr2[m])) {
        if (Character.isLowerCase(MyKey[counter2])) {
            MyKey[counter2] = Character.toUpperCase(MyKey[counter2]);
        }
        arr2[m] = (char) ((((int) arr2[m]) - ((int) MyKey[counter2]) + 26) % 26 + 65); // lowercase
        System.out.print(arr2[m]);
        counter2++;
    }
}

}

}

