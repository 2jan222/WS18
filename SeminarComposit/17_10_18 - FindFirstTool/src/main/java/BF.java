/**
 * @author Janik Mayr on 17.10.2018
 */
public class BF implements MatcherImplements {
    public String findFirst(String pattern, String text) {
        int i = 0;
        int j = 0;
        int comp = 0;
        while ( j < pattern.length() && i < text.length()) {
             if (text.charAt(i) == pattern.charAt(j)) {
                 i++;j++;
             } else {
                 i++;
                 j=0;
             }
             comp++;
        }
        return (j == pattern.length())? "" + (i-pattern.length()) + "["+ comp + "]":"No Match Found";
    }
}
