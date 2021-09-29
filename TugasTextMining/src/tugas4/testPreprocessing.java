/*
Nama Kelompok :
Erlina Rohmawati (175150201111045)
Tania Malik Iryana (175150201111053)
Alvina Eka ((175150201111056)
Jeowandha Ria Wiyani (175150207111029)
 */

package tugas4;

import IndonesianStemmer.IndonesianStemmer;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class testPreprocessing {

    public static String[][] input = new String[4][4];

    public static void main(String[] args) throws IOException {
        String dataPrint = Arrays.toString(data());
    }

    static public String[][] data() throws IOException {

        String hasilTokenisasi1, hasilTokenisasi2, hasilTokenisasi3,
                hasilTokenisasi4, hasilTokenisasi5, hasilFiltering1, hasilFiltering2,
                hasilFiltering3, hasilFiltering4, hasilFiltering5, hasilStemming1,
                hasilStemming2, hasilStemming3, hasilStemming4, hasilStemming5;
        preprocessing dok1 = new preprocessing();
        String[] direktori = new String[5];
        String[] input = new String[5];
        String[] hasilCleaning = new String[5];
        String[] hasilCaseFolding = new String[5];

        direktori[0] = "D:\\Tania\\UB\\Semester 5\\TEXT MINNING\\Tugas\\Tugas\\3-alasan-utama-seseorang-selalu-bangun-kesiangan.txt";
        direktori[1] = "D:\\Tania\\UB\\Semester 5\\TEXT MINNING\\Tugas\\Tugas\\33-destinasi-di-toba-mulai-digarap.txt";
        direktori[2] = "D:\\Tania\\UB\\Semester 5\\TEXT MINNING\\Tugas\\Tugas\\ada-22-balapan-draf-kalender-formula-1-2020-dirilis.txt";
        direktori[3] = "D:\\Tania\\UB\\Semester 5\\TEXT MINNING\\Tugas\\Tugas\\asus-rog-phone-anyar-ponsel-perdana-dengan-snapdragon-855-plus.txt";
        direktori[4] = "D:\\Tania\\UB\\Semester 5\\TEXT MINNING\\Tugas\\Tugas\\kriuk-renyah-ikan-goreng-enak-dipadu-bumbu-acar-hingga-saus-lada-hitam.txt";

        System.out.println("TAHAP PREPROCESSING\n");

        System.out.println("================== CLEANING ==========================");
        for (int i = 0; i < input.length; i++) {
            input[i] = dok1.BacaFile(direktori[i]);
            if (input[i] != null) {
                hasilCleaning[i] = dok1.cleaning(input[i]);
                System.out.println(hasilCleaning[i]);
            }
        }

        System.out.println("\n================ CASE FOLDING ========================");
        for (int i = 0; i < input.length; i++) {
            if (input[i] != null) {
                hasilCaseFolding[i] = dok1.case_folding(hasilCleaning[i]);
                System.out.println(hasilCaseFolding[i]);
            }
        }

        System.out.println("\n================= TOKENISASI =========================");
        String[] hasilTokenisasiArray1 = dok1.tokenisasi(hasilCaseFolding[0]);
        hasilTokenisasi1 = Arrays.toString(hasilTokenisasiArray1);
        System.out.println(hasilTokenisasi1);
        String[] hasilTokenisasiArray2 = dok1.tokenisasi(hasilCaseFolding[1]);
        hasilTokenisasi2 = Arrays.toString(hasilTokenisasiArray2);
        System.out.println(hasilTokenisasi2);
        String[] hasilTokenisasiArray3 = dok1.tokenisasi(hasilCaseFolding[2]);
        hasilTokenisasi3 = Arrays.toString(hasilTokenisasiArray3);
        System.out.println(hasilTokenisasi3);
        String[] hasilTokenisasiArray4 = dok1.tokenisasi(hasilCaseFolding[3]);
        hasilTokenisasi4 = Arrays.toString(hasilTokenisasiArray4);
        System.out.println(hasilTokenisasi4);
        String[] hasilTokenisasiArray5 = dok1.tokenisasi(hasilCaseFolding[4]);
        hasilTokenisasi5 = Arrays.toString(hasilTokenisasiArray5);
        System.out.println(hasilTokenisasi5);

        System.out.println("\n================= FILTERING =========================");
        String direktoriStopword = "D:\\Tania\\UB\\Semester 5\\TEXT MINNING\\Tugas\\Tugas\\tala.txt";
        String[] hasilFilteringArray1 = dok1.filtering(hasilTokenisasiArray1, direktoriStopword);
        hasilFiltering1 = Arrays.toString(hasilFilteringArray1);
        System.out.println(hasilFiltering1);
        String[] hasilFilteringArray2 = dok1.filtering(hasilTokenisasiArray2, direktoriStopword);
        hasilFiltering2 = Arrays.toString(hasilFilteringArray2);
        System.out.println(hasilFiltering2);
        String[] hasilFilteringArray3 = dok1.filtering(hasilTokenisasiArray3, direktoriStopword);
        hasilFiltering3 = Arrays.toString(hasilFilteringArray3);
        System.out.println(hasilFiltering3);
        String[] hasilFilteringArray4 = dok1.filtering(hasilTokenisasiArray4, direktoriStopword);
        hasilFiltering4 = Arrays.toString(hasilFilteringArray4);
        System.out.println(hasilFiltering4);
        String[] hasilFilteringArray5 = dok1.filtering(hasilTokenisasiArray5, direktoriStopword);
        hasilFiltering5 = Arrays.toString(hasilFilteringArray5);
        System.out.println(hasilFiltering5);

        System.out.println("\n==================== STEMMING ====================");
        String[] hasilStemmingArray2 = dok1.Stemming(hasilFilteringArray2);
        hasilStemming2 = Arrays.toString(hasilStemmingArray2);
        System.out.println(hasilStemming2);
        String[] hasilStemmingArray3 = dok1.Stemming(hasilFilteringArray3);
        hasilStemming3 = Arrays.toString(hasilStemmingArray3);
        System.out.println(hasilStemming3);
        String[] hasilStemmingArray4 = dok1.Stemming(hasilFilteringArray4);
        hasilStemming4 = Arrays.toString(hasilStemmingArray4);
        System.out.println(hasilStemming4);
        String[] hasilStemmingArray5 = dok1.Stemming(hasilFilteringArray5);
        hasilStemming5 = Arrays.toString(hasilStemmingArray5);
        System.out.println(hasilStemming5);

        String[][] stem = {hasilStemmingArray2, hasilStemmingArray3, hasilStemmingArray4, hasilStemmingArray5};
        return stem;
    }
}