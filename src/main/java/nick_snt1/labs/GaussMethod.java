package nick_snt1.labs;

public class GaussMethod {

    private static void throwIfZero(Double n) throws Exception {
        if (n == 0) throw new Exception("Determinant of given matrix is 0, Gauss method can not be performed.");
    }

    private static int findMainRow(Double[][] A, int i) throws Exception {
        int max = i;
        for (int j = i; j < A.length; j++) 
            max = Math.abs(A[j][i]) > Math.abs(A[max][i]) ? j : max;
        throwIfZero(A[max][i]);
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

    private static Double determinant(Double[][] A) {
        Double det = 1.0;
        for (int i = 0; i < A.length; i++) det *= A[i][i];
        return det;
    }

    private static Double findX(Double[] row, Double[] vector, int vectorLn) {
        Double x = row[row.length-1];
        for (int i = row.length-2; i > row.length-2-vectorLn; i--)
            x += (-row[i]*vector[i]);
        return x;
    }

    public static Double[][] forwardMove(Double[][] A) throws Exception {
        for (int i = 0; i < A.length; i++)
            excludeColumn(A, normalizeRow(swapRows(A, i, findMainRow(A, i)), i), i);
        throwIfZero(determinant(A));
        return A;
    }

    public static Double[] backwardMove(Double[][] A) {
        Double[] vector = new Double[A.length]; 
        for (int i = vector.length-1; i >= 0; i--) 
            vector[i] = findX(A[i], vector, vector.length-i-1);
        return vector;
    }

    public static Double[] measureError(Double[][] A, Double[] vector) {
        Double[] errorVector = new Double[vector.length];
        for (int i = 0; i < A.length; i++) {
            Double rowSum = 0.0;
            for (int j = 0; j < vector.length; j++ ) rowSum += vector[j]*A[i][j];
            errorVector[i] = A[i][vector.length] - rowSum;
        } return errorVector;
    }
}

