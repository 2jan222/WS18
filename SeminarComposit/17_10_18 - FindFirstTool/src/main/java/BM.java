import java.util.HashMap;

/**
 * @author Janik Mayr on 17.10.2018
 */
public class BM implements MatcherImplements {
    public String findFirst(String pattern, String text) {
        if (pattern.length() > text.length()) {
            return "No Match Found";
        } else {
            if (pattern.length() == text.length()) {
                return (pattern.equals(text)) ? "0[1]":"No Match Found";
            }
        }
        HashMap<Character,Integer> shiftMap = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            shiftMap.put(pattern.charAt(i),i);
        }
        int skip;
        int comp = 0;
        for (int i = 0; i < text.length()-pattern.length()+1; i+=skip) {
            skip = 0;
            for (int j = pattern.length()-1; j >= 0; j--) {
                comp++;
                //System.out.println("COMP: " + (comp-1) +"\t" + pattern.charAt(j) + "[" + j + "]" + "\t:\t" + text.charAt(i+j) +"[" + (i+j) + "]");
                if (pattern.charAt(j) != text.charAt(i+j)) {
                    skip = Math.max(1, j - ((shiftMap.containsKey(text.charAt(i+j)))? shiftMap.get(text.charAt(i+j)):-1));
                    break;
                }
            }
            if (skip == 0) {
                return "" + i + "[" + comp + "]";
            }
        }
        return "No Match Found";
    }
}
