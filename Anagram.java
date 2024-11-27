/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true
		
		// Tests the preProcess function.
		System.out.println("preProcess Test: " + preProcess("What? No way!!!"));
		System.out.println("preProcess Test: " + preProcess("HEY YOU?"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		StringBuilder sb1 = new StringBuilder(preProcess(str1));
		StringBuilder sb2 = new StringBuilder(preProcess(str2));
		if (preProcess(str1).length() != preProcess(str2).length())
		{
			return false;	
		}
		for (int i = sb1.length() -1; i >= 0; i --)
		{
			int j = sb2.toString().indexOf(sb1.charAt(i));
			if (j != -1)
			{
				sb1.deleteCharAt(i);
				sb2.deleteCharAt(j);
			}else
			{
				return false;
			}
		}
		return true;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		StringBuilder sb = new StringBuilder(str);
		String charsToRemove = "!@#$%^&*:()_+-=?><;][]\"";
		for (int i = sb.length() - 1; i >= 0; i--) {
            if (charsToRemove.indexOf(sb.charAt(i)) != -1) {
                sb.deleteCharAt(i);
            }
        }
		return sb.toString().toLowerCase();
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		StringBuilder sb1 = new StringBuilder(str);
		StringBuilder sbNew = new StringBuilder();
		while (sb1.toString().length() > 0)
		{
			int index = (int)(Math.random() * sb1.toString().length());
			char charToReplace = sb1.toString().charAt(index);
			sb1.deleteCharAt(index);
			sbNew.append(charToReplace);
		}
		return sbNew.toString();
	}
}
