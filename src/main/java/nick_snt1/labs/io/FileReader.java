package nick_snt1.labs.io;

import java.util.Arrays;
import java.util.Scanner;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FileReader extends Reader {
    
    Scanner scnr;

    @Override public Integer readSize() throws Exception {
        Integer size = Integer.parseInt(scnr.nextLine());
        if (size <= 0) throw new Exception("Size must be positive integer.");
        return size;
    }
    
    @Override public Double[][] readMatrix() throws Exception {
        Integer    size   = readSize();
        Double[][] matrix = new Double[size][size+1];
        for (int i = 0; i < size; i++) {
            matrix[i] = Arrays.asList(scnr.nextLine().split(" ")).stream().map(x -> Double.valueOf(x.trim())) .toArray(Double[]::new);
            if (matrix[i].length != size + 1) throw new Exception("Not enough values!");
        } return matrix;
    }
}
