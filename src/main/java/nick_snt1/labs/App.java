package nick_snt1.labs;

import java.util.Arrays;

//import nick_snt1.labs.GaussMethod;

public class App {
    public static void main( String[] args ) {
        Double[][] matrix = new Double[][] {
            {2.0, 3.0, -1.0, 7.0},
            {1.0, -1.0, 6.0, 14.0},
            {6.0, -2.0, 1.0, 11.0},
        }; 
        System.out.println( Arrays.toString(GaussMethod.compute(matrix)));
    }
}
