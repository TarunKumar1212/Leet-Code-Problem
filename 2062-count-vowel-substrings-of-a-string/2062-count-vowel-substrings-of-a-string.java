import java.util.HashSet;

class Solution {
    public int countVowelSubstrings(String word) {
        int count = 0;
        
        
        for (int i = 0; i < word.length(); i++) {
            HashSet<Character> vowels = new HashSet<>();
            
        
            for (int j = i; j < word.length(); j++) {
                char ch = word.charAt(j);
                
               
                if (isVowel(ch)) {
                    vowels.add(ch);
                    
                
                    if (vowels.size() == 5) {
                        count++;
                    }
                } else {
                    
                    break;
                }
            }
        }
        
        return count;
    }
    
    // Helper function to check if a character is a vowel
    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
