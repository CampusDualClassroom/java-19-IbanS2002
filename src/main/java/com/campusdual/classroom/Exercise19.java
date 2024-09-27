package com.campusdual.classroom;

public class Exercise19 {


    public static String getUnidimensionalString(int[] uniArray) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < uniArray.length; i++) {
            sb.append(uniArray[i]);
            if (i < uniArray.length - 1) {
                sb.append(" "); // Espacio entre elementos
            }
        }
        return sb.toString();
    }


    public static String getBidimensionalString(int[][] intArrayBi) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < intArrayBi.length; i++) {
            sb.append(stringFlatMatrixRow(intArrayBi, i));
            if (i < intArrayBi.length - 1) {
                sb.append("\n"); // Nueva línea entre filas
            }
        }
        return sb.toString();
    }


    public static int[][] flatTridimensionalArray(int[][][] intArrayTri) {
        int depth = intArrayTri.length;
        int rows = intArrayTri[0].length;
        int cols = intArrayTri[0][0].length;
        int[][] flatMatrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k < depth; k++) {
                    flatMatrix[i][j] += intArrayTri[k][i][j]; // Suma los elementos correspondientes
                }
            }
        }
        return flatMatrix;
    }


    public static String getTridimensionalString(int[][][] intArrayTri) {
        int[][] flatMatrix = flatTridimensionalArray(intArrayTri);
        return getTridimensionalString(intArrayTri, flatMatrix);
    }


    private static String getTridimensionalString(int[][][] intArrayTri, int[][] flatMatrix) {
        StringBuilder sb = new StringBuilder();
        int rows = intArrayTri[0].length;
        for (int i = 0; i < rows; i++) {
            sb.append(stringFlatMatrixRow(flatMatrix, i));
            sb.append("   →   ");
            sb.append(stringTriMatrixRow(intArrayTri, i));
            sb.append("\n");
        }
        sb.deleteCharAt(sb.length() - 1); // Eliminar última nueva línea
        return sb.toString();
    }


    private static String stringTriMatrixRow(int[][][] intArrayTri, int row) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < intArrayTri.length; i++) {
            sb.append(getUnidimensionalString(intArrayTri[i][row]));
            if (i < intArrayTri.length - 1) {
                sb.append("   ");
            }
        }
        return sb.toString();
    }


    private static String stringFlatMatrixRow(int[][] flatMatrix, int row) {
        return getUnidimensionalString(flatMatrix[row]);
    }


    public static int[] createAndPopulateUnidimensionalArray(int columns) {
        int[] array = new int[columns];
        for (int i = 0; i < columns; i++) {
            array[i] = i + 1; // Población con números del 1 al 'columns'
        }
        return array;
    }


    public static int[][] createAndPopulateBidimensionalArray(int rows, int columns) {
        int[][] array = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                array[i][j] = (i * columns) + (j + 1); // Población con números secuenciales
            }
        }
        return array;
    }


    public static int[][][] createAndPopulateTridimensionalArray(int depth, int rows, int columns) {
        int[][][] array = new int[depth][rows][columns];
        for (int i = 0; i < depth; i++) {
            for (int j = 0; j < rows; j++) {
                for (int k = 0; k < columns; k++) {
                    array[i][j][k] = (i * rows * columns) + (j * columns) + (k + 1); // Población secuencial
                }
            }
        }
        return array;
    }


    public static void main(String[] args) {
        int[] uniArray = createAndPopulateUnidimensionalArray(5);
        System.out.println("Array unidimensional: " + getUnidimensionalString(uniArray));
        System.out.println("===================");

        int[][] intArrayBi = createAndPopulateBidimensionalArray(5, 5);
        System.out.println("Array bidimensional: \n" + getBidimensionalString(intArrayBi));
        System.out.println("===================");

        int[][][] intArrayTri = createAndPopulateTridimensionalArray(3, 3, 3);
        System.out.println("Array tridimensional: \n" + getTridimensionalString(intArrayTri));
    }
}
