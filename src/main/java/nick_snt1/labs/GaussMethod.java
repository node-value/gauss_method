package nick_snt1.labs;

public class GaussMethod {

    private static int findMainRow(Double[][] A, int i) {
        int max = i;
        for (int j = i; j < A.length; j++) 
            max = A[j][i] > A[max][i] ? j : max;
        return max;
    }

    private static Double[] swapRows(Double[][] A, int currI, int maxI) {
        Double[] temp = A[maxI]; A[maxI] = A[currI]; A[currI] = temp;
        return A[currI];
    } 

    private static Double[] normalizeRow(Double[] row, int startI) {
        Double c = 1/row[startI];
        for (int i = startI; i < row.length; i++) row[i] *= c;
        return row;
    }

    private static void excludeColumn(Double[][] A, Double[] normRow, int currI) {
        for (int i = currI+1; i < A.length; i++) {
            for (int j = currI+1; j < normRow.length; j++) 
                A[i][j] += A[i][currI] * (-normRow[j]);
            A[i][currI] = 0.0;
        }
    }

    private static Double[][] forwardMove(Double[][] A) { 
        for (int i = 0; i < A.length; i++)
           excludeColumn(A, normalizeRow(swapRows(A, i, findMainRow(A, i)), i), i);
        return A;
    }

    private static Double findX(Double[] row, Double[] vector, int vectorLn) {
        Double x = row[row.length-1];
        for (int i = row.length-2; i > row.length-2-vectorLn; i--)
            x += (-row[i]*vector[i]);
        return x;
    }

    private static Double[] backwardMove(Double[][] A) {
        Double[] vector = new Double[A.length]; 
        for (int i = vector.length-1; i >= 0; i--) 
            vector[i] = findX(A[i], vector, vector.length-i-1);
        return vector;
    }

    public static Double[] compute(Double[][] A) {
        return backwardMove(forwardMove(A));
    }
}

