package nick_snt1.labs.io;

import java.text.DecimalFormat;

public class Printer {
    public static void greatings() {
        System.out.println(
            new StringBuilder("Hello, this is a tool build to solve system of linear equations with Gaussian elimination method.")
            .append(System.lineSeparator()) 
            .append("Please, use dot(\".\") as decimal delimetr.") 
            .append(System.lineSeparator())
            .append("To see all avaliable options run with \"--help\"") 
            .append(System.lineSeparator()).toString()
        );
    }

    public static void usage() {
        System.out.println(
            new StringBuilder("Usage: java -jar gauss_method-1.0.jar [OPTION] [FILE|SIZE RANGE]")
            .append(System.lineSeparator())
            .append("OPTION")
            .append(System.lineSeparator())
            .append("    -s               standart input mode (app run in this mode by default)")
            .append(System.lineSeparator())
            .append("    -f FILE          read matrix from given file")
            .append(System.lineSeparator())
            .append("    -r SIZE RANGE    generate random matrix of given size, in range of -RANGE...RANGE").toString()
        );
    }

    public static void matrix(Double[][] matrix) {
        System.out.println("Triangle matrix:");
        int         stdLn = maxNumLength(matrix);
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            res.append("    "); 
            for (int j = 0; j < matrix.length+1; j++)
                res.append((j == matrix.length ? "| " : "") + toStdLn(matrix[i][j], stdLn));
            res.append(System.lineSeparator());
        }
        System.out.println(res.toString()); 
    }

    public static void resultVector(Double[] vector) {
        System.out.println("Result vector:");
        System.out.println("    " + vector(vector, "#.###") + System.lineSeparator());
    }

    public static void errorVector(Double[] vector) {
        System.out.println("Error vector: ");
        System.out.println("    " + vector(vector, "#.##############") + System.lineSeparator());
    }

    public static void time(long time) {
        System.out.println("Method working time:");
        System.out.println("    " + time + " ms");
    }

    private static String vector(Double[] vector, String format) {
        StringBuilder res = new StringBuilder("{ ");
        DecimalFormat df  = new DecimalFormat(format);
        for (Double n: vector) res.append(df.format(n)).append(", ");
        res.replace(res.length()-2, res.length()-1, " }");
    
        return res.toString();
    }

    private static String toStdLn(Double n, int stdLn) {
        DecimalFormat df = new DecimalFormat("#.###");
        String res       = df.format(n);
        return res + nSpaces(stdLn - res.length()); 
    }

    private static String nSpaces(int n) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n ; i++) res.append(" ");
        return res.toString();
    }

    private static int maxNumLength(Double[][] matrix) {
        Double max = matrix[0][0];
        for (int i = 0; i < matrix.length; i++) for (int j = 0; j < matrix.length; j++)
            max = matrix[i][j] > max ? matrix[i][j] : max;
        return ("" + Math.floor(max)).length() + 4;
    }
}
