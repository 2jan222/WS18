import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Janik Mayr on 17.10.2018
 */
public class FindFirstCommandLine {
    public static void main(String... args) {
        boolean p = false, f = false, a = false;
        String pattern = "",path = "";
        MatcherImplements algo = null;
        for(int i = 0; i < args.length-1; i+=2) {
            if (!p && "-p".equalsIgnoreCase(args[i])) {
                pattern = args[i+1];
                p = true;
            }
            if (!a && "-a".equalsIgnoreCase(args[i])) {
                if ("BF".equalsIgnoreCase(args[i+1])) {
                    algo = new BF();
                } else {
                    if ("KMP".equalsIgnoreCase(args[i+1])) {
                        algo = new KMP();
                    } else {
                        if ("BM".equalsIgnoreCase(args[i+1])) {
                            algo = new BM();
                        }
                    }
                }
                a = true;
            }
            if (!f && "-f".equalsIgnoreCase(args[i])) {
                path = args[i+1];
                f= true;
            }
        }
        if (p && f && a && algo != null) {
            //System.out.println("Execute:" + path + pattern + algo.toString());
            Path paths = Paths.get(path);
            File file = paths.toFile();
            String text;
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line, ls = System.getProperty("line.separator");
                StringBuilder stringBuilder = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    stringBuilder.append(line);
                    stringBuilder.append(ls);
                }
                text = stringBuilder.toString();
                System.out.println(algo.findFirst(pattern,text));
            } catch (IOException e) {
                System.err.println("An error occurred");
            }
        } else {
            System.err.println("Missing parameters");
        }
    }
}
