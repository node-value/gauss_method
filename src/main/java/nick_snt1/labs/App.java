package nick_snt1.labs;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

import nick_snt1.labs.io.*;

public class App {
    public static void main( String[] args ) {
        /*
        Double[][] matrix = new Double[][] {
            //{ 1.0, 1.0, 3.0 },
            //{ 1.0, 1.0, 6.0 }
            {2.0, 3.0, -1.0, 7.0},
            {1.0, -1.0, 6.0, 14.0},
            {6.0, -2.0, 1.0, 11.0},
        };
        Double[][] triangleMatrix = new Double[][] {
            //{1.0, 1.0, 3.0},
            //{1.0, 1.0, 6.0}
            {2.0, 3.0, -1.0, 7.0},
            {1.0, -1.0, 6.0, 14.0},
            {6.0, -2.0, 1.0, 11.0},
        };
         */ 
        try {
            Double[][] matrix, triangleMatrix; 
            Reader reader  = args.length == 0 ? 
                new InputReader(new Scanner(System.in)) :
                    new FileReader(new Scanner(new File(args[1])));
            
            matrix         = reader.readMatrix();
            triangleMatrix = deepCopyOf(matrix);

            GaussMethod.forwardMove(triangleMatrix);
            Double[] vector = GaussMethod.backwardMove(triangleMatrix);
            System.out.println(Arrays.toString(vector));
            System.out.println(Arrays.toString(GaussMethod.measureError(matrix, vector)));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static Double[][] deepCopyOf(Double[][] matrix) {
        Double[][] copy = new Double[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) copy[i] = Arrays.copyOf(matrix[i], matrix[i].length);
        return copy;
    }
}
