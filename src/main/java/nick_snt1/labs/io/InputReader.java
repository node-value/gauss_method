package nick_snt1.labs.io;

import java.util.Arrays;
import java.util.Scanner;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class InputReader extends Reader {
    
    Scanner scnr;

    @Override public Integer readSize() throws Exception {
        Integer size = Integer.parseInt(scnr.nextLine());
        if (size <= 0) throw new Exception("Size must be positive integer.");
        return size;
    }

    @Override public Double[][] readMatrix() {
        Double[][]  matrix = null;
        Integer       size = null;
        boolean isNotValid = true;
        do {   
            System.out.print("Please, enter size of the matrix: ");
            try {
                size   = readSize();
                matrix = new Double[size][size+1];
                System.out.println("Please, enter matrix");
                for (int i = 0; i < size; i++) {
                    System.out.print("Row " + (i+1) + ": ");    
                    matrix[i] = Arrays.asList(scnr.nextLine().split(" ")).stream().map(x -> Double.valueOf(x.trim())).toArray(Double[]::new);
                    if (matrix[i].length != size+1) throw new Exception("Not enough values!");
                } isNotValid = false;                
            } catch (Exception e) {
                System.out.println("Invalid input, " + e.getMessage());
            }
        } while (isNotValid);
        return matrix;      
    }
}
