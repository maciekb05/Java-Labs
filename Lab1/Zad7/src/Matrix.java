import java.util.Scanner;

class Matrix {
    private Integer[][] matrix;
    Matrix(){
        int a, b;
        Scanner in = new Scanner(System.in);
        System.out.println("Podaj ilosc wierszy i kolumn macierzy: ");
        a = in.nextInt();
        b = in.nextInt();
        matrix = new Integer[a][b];
        fillMatrix();
    }
    Matrix(int r, int c){
        matrix = new Integer[r][c];
    }
    private void fillMatrix(){
        Scanner in = new Scanner(System.in);
        System.out.println("Podaj kolejne elementy macierzy: ");
        for(int i=0; i<matrix.length; ++i){
            for(int j=0; j<matrix[0].length; ++j){
                matrix[i][j] = in.nextInt();
            }
        }
    }
    void printMatrix(){
        for(int i = 0; i < matrix.length; ++i){
            for(int j = 0; j < matrix[i].length; ++j){
                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    Matrix add(Matrix b) throws MatrixDimensionException {
        if(matrix.length != b.matrix.length || matrix[0].length != b.matrix[0].length){
            throw new MatrixDimensionException();
        }
        Matrix c = new Matrix(b.matrix.length, b.matrix[0].length);
        for(int i = 0; i < c.matrix.length; ++i){
            for(int j = 0; j < c.matrix[i].length; ++j){
                c.matrix[i][j] = b.matrix[i][j] + matrix[i][j];
            }
        }
        return c;
    }
    Matrix sub(Matrix b) throws MatrixDimensionException {
        if(matrix.length != b.matrix.length || matrix[0].length != b.matrix[0].length){
            throw new MatrixDimensionException();
        }
        Matrix c = new Matrix(b.matrix.length, b.matrix[0].length);
        for(int i = 0; i < c.matrix.length; ++i){
            for(int j = 0; j < c.matrix[i].length; ++j){
                c.matrix[i][j] = matrix[i][j] - b.matrix[i][j];
            }
        }
        return c;
    }
    Matrix mul(Matrix b) throws MatrixDimensionException {
        if(matrix[0].length != b.matrix.length) {
            throw new MatrixDimensionException();
        }
        Matrix c = new Matrix(matrix.length, b.matrix[0].length);
        for(int i = 0; i < matrix.length; ++i){
            for(int j = 0; j < b.matrix[i].length; ++j){
                int sum = 0;
                for(int k = 0; k < matrix[i].length; ++k){
                    sum += matrix[i][k] * b.matrix[k][j];
                }
                c.matrix[i][j] = sum;
            }
        }
        return c;
    }
}