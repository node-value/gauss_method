package nick_snt1.labs;

import java.util.Random;

public class RandomMatrix {
    public static Double[][] generate(int size, int rangeModule) {
        Double[][] matrix = new Double[size][size+1];
        Random random     = new Random();
        for (int i = 0; i < size; i++) for (int j = 0; j < size+1; j++)
            matrix[i][j] = 2 * rangeModule * random.nextDouble() - rangeModule;
        return matrix;
    }
}
