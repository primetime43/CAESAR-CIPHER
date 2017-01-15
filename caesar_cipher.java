import java.util.HashMap;
import java.util.Random;
public class CaesarCipher 
{
	private HashMap<Character, Integer> mapAlphabet = new HashMap<Character, Integer>();
	private HashMap<Integer, Character> mapInteger = new HashMap<Integer, Character>();
	private Random gen = new Random();
	private int privateKey;
	private String[] cryptWords;

	public CaesarCipher(){createMap('A', 0);}

	public CaesarCipher(String input)
	{
		input = input.toUpperCase();
		privateKey = gen.nextInt(100) + 1;
		System.out.println("Private Key: " + privateKey);
		String[] words = input.split(" ");
		cryptWords = new String[words.length];
		createMap('A', 0);
		encrypt(words);
	}

	private void encrypt(String words[])
	{
		String buildWord = "", word = "";
		for(int i = 0; i < words.length; i++)
		{
			word = words[i];
			for(int k = 0; k < word.length(); k++)
			{
				char letter = word.charAt(k);
				if(mapAlphabet.containsKey(letter))
				{
					int p = mapAlphabet.get(letter);
					int encryptedChar = (p + privateKey)%26;
					buildWord += Character.toString(mapInteger.get(encryptedChar));
				}
				else
					buildWord += Character.toString(letter);
			}
			buildWord += " ";
			cryptWords[i] = buildWord;
		}
		cryptWords = buildWord.split(" ");
		System.out.println("\nEncrypted sentence: " + buildWord + "\n");
	}

	public void decryptMyOwnMessage()
	{
		String buildWord = "", word = "";
		for(int i = 0; i < cryptWords.length; i++)
		{
			word = cryptWords[i];
			for(int k = 0; k < word.length(); k++)
			{
				char letter = word.charAt(k);
				if(mapAlphabet.containsKey(letter))
				{
					int p = mapAlphabet.get(letter);
					int encryptedChar = (p - privateKey)%26;
					if(encryptedChar < 0)
						encryptedChar = 26 + encryptedChar;
					buildWord += Character.toString(mapInteger.get(encryptedChar));
				}
				else
					buildWord += Character.toString(letter);
			}
			buildWord += " ";
		}
		System.out.print("Decrypted sentence: " + buildWord);
	}
	
	public void decryptFriendsMessage(int privateKey, String friendsEncryptedMessage)
	{
		String[] cryptWords = friendsEncryptedMessage.split(" ");
		String buildWord = "", word = "";
		for(int i = 0; i < cryptWords.length; i++)
		{
			word = cryptWords[i];
			for(int k = 0; k < word.length(); k++)
			{
				char letter = word.charAt(k);
				if(mapAlphabet.containsKey(letter))
				{
					int p = mapAlphabet.get(letter);
					int encryptedChar = (p - privateKey)%26;
					if(encryptedChar < 0)
						encryptedChar = 26 + encryptedChar;
					buildWord += Character.toString(mapInteger.get(encryptedChar));
				}
				else
					buildWord += Character.toString(letter);
			}
			buildWord += " ";
		}
		System.out.print("Decrypted sentence: " + buildWord);
	}
	
	private void createMap(char alpha, int value)
	{
		if(alpha == 'Z')
		{
			mapAlphabet.put(alpha, value);
			mapInteger.put(value, alpha);
		}
		else
		{
			mapAlphabet.put(alpha, value);
			mapInteger.put(value, alpha);
			alpha = (char)(((int)alpha) + 1);
			createMap(alpha, value+1);
		}
	}
}