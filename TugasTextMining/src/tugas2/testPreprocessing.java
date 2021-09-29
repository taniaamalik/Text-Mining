/*
Nama Kelompok :
Erlina Rohmawati (175150201111045)
Tania Malik Iryana (175150201111053)
Alvina Eka ((175150201111056)
Jeowandha Ria Wiyani (175150207111029)
 */

package tugas2;

import IndonesianStemmer.IndonesianStemmer;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class testPreprocessing {

    public static void main(String[] args) throws IOException {
        preprocessing dok1 = new preprocessing();
        preprocessing dok2 = new preprocessing();

        String direktori = "D:\\Tania\\UB\\Semester 5\\TEXT MINNING\\Tugas\\Tugas\\kriuk-renyah-ikan-goreng-enak-dipadu-bumbu-acar-hingga-saus-lada-hitam.txt";
        dok1.BacaFile(direktori);
        System.out.println("================= CLEANING ===========================");
        System.out.println(dok1.cleaning());
        System.out.println("================= CASE FOLDING========================");
        System.out.println(dok1.case_folding());

        System.out.println("================= TOKENISASI =========================");
        String[] hasilTokenisasiArray = dok1.GetStringArray(dok1.tokenisasi());
        String hasilTokenisasi = Arrays.toString(hasilTokenisasiArray);
        System.out.println(hasilTokenisasi);

        System.out.println("================= FILTERING =========================");
        String direktori2 = "D:\\Tania\\UB\\Semester 5\\TEXT MINNING\\Tugas\\Tugas\\tala.txt";
        dok2.BacaFile(direktori2);
        String[] hasilTokenisasiStoplistArray = dok1.GetStringArray(dok2.tokenisasi());
        String hasilTokenisasiStoplist = Arrays.toString(hasilTokenisasiStoplistArray);

        List<String> hasilFilteringList = dok1.filtering(hasilTokenisasiArray, hasilTokenisasiStoplistArray);
        String[] hasilFiltering = dok1.GetStringArray(hasilFilteringList);
        String hasilFiltering2 = Arrays.toString(hasilFiltering);
        System.out.println(hasilFiltering2);

        System.out.println("==================== STEMMING ====================");
        String[] sebelumStemming = dok1.GetStringArray(hasilFilteringList);
        String[] setelahStemming = new String[sebelumStemming.length];
        IndonesianStemmer indonesianStemmer = new IndonesianStemmer();
        for (int i = 0; i < sebelumStemming.length; i++) {
            setelahStemming[i] = indonesianStemmer.findRootWord(sebelumStemming[i]);
        }
        System.out.println(Arrays.toString(setelahStemming));
    }
    
}