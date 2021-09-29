/*
Nama Kelompok :
Erlina Rohmawati (175150201111045)
Tania Malik Iryana (175150201111053)
Alvina Eka ((175150201111056)
Jeowandha Ria Wiyani (175150207111029)
 */

package tugas4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class testWeighting {

    public static void main(String[] args) throws IOException {
        weighting dok1 = new weighting();
        testPreprocessing prepocessing = new testPreprocessing();
        String[][] inputKata = prepocessing.data();

        dok1.setText(inputKata);
        System.out.println("\nTAHAP WEIGHTING");
        System.out.println("================= Hasil Tf =====================");

        Set<String> feature = dok1.getFeatures();
        List<String> feature2 = new ArrayList<>(feature);

        int[][] TFMatrix = dok1.getTF();

        for (int i = 0; i < TFMatrix.length; i++) {
            System.out.print(feature2.get(i) + " = ");
            for (int j = 0; j < TFMatrix[i].length; j++) {
                System.out.print(TFMatrix[i][j]);
                System.out.print(" ");
            }
            System.out.println("");
        }
        System.out.println("\n================= Hasil Tf-Idf =====================");

        double[][] TfIdf = dok1.getTFIDF();

        for (int k = 0; k < TfIdf.length; k++) {
            System.out.print(feature2.get(k) + " = ");
            for (int j = 0; j < TfIdf[k].length; j++) {
                System.out.print(TfIdf[k][j]);
                System.out.print(" ");
            }
            System.out.println("");

        }

    }
}