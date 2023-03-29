package nick_snt1.labs;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

import nick_snt1.labs.io.*;

public class App {
    public static void main( String[] args ) {
        try {
            AppMode mode = init(args);

            if (mode == AppMode.HELP) { Printer.usage(); return; }

            Printer.greatings();

            Double[][] matrix         = getMatrix(mode, args),
                       triangleMatrix = deepCopyOf(matrix);

            long startTime = System.currentTimeMillis();

            GaussMethod.forwardMove(triangleMatrix);

            Double[] vector      = GaussMethod.backwardMove(triangleMatrix),
                     errorVector = GaussMethod.measureError(matrix, vector);
            
            long finishTime = System.currentTimeMillis();
            
            Printer.matrix(triangleMatrix);         
            Printer.resultVector(vector);
            Printer.errorVector(errorVector);
            Printer.time(finishTime - startTime);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static Double[][] getMatrix(AppMode mode, String[] args) throws Exception {
        if (mode == AppMode.RANDOM) return RandomMatrix.generate(Integer.parseInt(args[1]), Integer.parseInt(args[2]));
        else return ( mode == AppMode.STANDART ?
                new InputReader(new Scanner(System.in)) : 
                    new FileReader(new Scanner(new File(args[1]))) ).readMatrix();
            
        
    }
    
    public static AppMode init(String[] args) throws Exception {
        if (args.length == 0 || (args.length == 1 && args[0].equals("-s")))                     return AppMode.STANDART;
        if (args.length == 1 && args[0].equals("--help"))                                       return AppMode.HELP;
        if (args.length == 2 && args[0].equals("-f"))                                           return AppMode.FILE; 
        if (args.length == 3 && args[0].equals("-r") && isNumber(args[1]) && isNumber(args[2])) return AppMode.RANDOM;
        throw new Exception("Unknown option: " + args[0] + System.lineSeparator() + "Run with \"--help\" to see available options.");
    }

    public static boolean isNumber(String str) {
        try { Integer.parseInt(str); return true; } catch (NumberFormatException ignore) { return false; }
    }

    public static Double[][] deepCopyOf(Double[][] matrix) {
        Double[][] copy = new Double[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) copy[i] = Arrays.copyOf(matrix[i], matrix[i].length);
        return copy;
    }
}
