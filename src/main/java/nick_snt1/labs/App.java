package nick_snt1.labs;

import java.util.Arrays;

//import nick_snt1.labs.GaussMethod;

public class App {
    public static void main( String[] args ) {
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
        try {
            GaussMethod.forwardMove(triangleMatrix);
            Double[] vector = GaussMethod.backwardMove(triangleMatrix);
            System.out.println(Arrays.toString(vector));
            System.out.println(Arrays.toString(GaussMethod.measureError(matrix, vector)));
            System.out.println(7.0 - 7.000000000000001);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
