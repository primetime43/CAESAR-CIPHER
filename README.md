Here I made a tool that uses one of the earliest known uses of encryption. This method of encryption was created by Julius Caesar, who would shift each letter three letters forward in the alphabet (sending the last three letters of the alphabet to the first three). I just made this for fun and thought it was a neat way to show how long encryption has actually been around before computers and how a very simple encryption works.

Here's a main you can use to test it out if you want:

import java.util.Scanner;
public class Test 
{
    private static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) 
    {
        System.out.print("Enter input: ");
        String input = scan.nextLine();
        CaesarCipher message = new CaesarCipher(input);
        message.decrypt();
    }
}

Console Output:

Enter input: Hello members

Encrypted sentence: KHOOR PHPEHUV

Decrypted sentence: HELLO MEMBERS
