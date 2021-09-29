/*
Nama Kelompok :
Erlina Rohmawati (175150201111045)
Tania Malik Iryana (175150201111053)
Alvina Eka ((175150201111056)
Jeowandha Ria Wiyani (175150207111029)
 */

package tugas2;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class preprocessing {

    public String input;
    public String stoplist;

    public void BacaFile(String direktori) throws IOException {
        try (BufferedReader b = new BufferedReader(new FileReader(direktori))) {
            input = b.readLine();

        }
    }

    public String cleaning() {
        StringBuffer alpha = new StringBuffer();
        boolean cekkk = false;
        for (int i = 0; i < input.length(); i++) {
            String cek = "";
            boolean cekk = false;
            if (i <= input.length() - 2) {
                cek = String.valueOf(input.charAt(i)) + String.valueOf(input.charAt(i + 1));
                if (String.valueOf(cek.charAt(0)).equals(".")) {
                    cekk = true;
                }
            }
            if (Character.isAlphabetic(input.charAt(i)) || input.charAt(i) == ' ' || input.charAt(i) == '.') {
                if (cekk) {
                    alpha.append(" ");
                    cekkk = true;
                } else {
                    if (input.charAt(i) != ' ' || !cekkk) {
                        alpha.append(input.charAt(i));
                    }
                    cekkk = false;
                }
            }
        }
        input = alpha.toString();
        return input;
    }

    public String case_folding() {
        input = input.toLowerCase();
        return input;
    }

    public List<String> tokenisasi() {
        String[] output = input.split(" ");
        List<String> outputlist = new ArrayList<>();
        for (int i = 0; i < output.length; i++) {
            if (!"".equals(output[i])) {
                outputlist.add(output[i]);
            }
        }

        return outputlist;
    }

    public List<String> filtering(String[] dokumen, String[] stoplist) {

        List<String> hasilFiltering = new ArrayList<>();
        for (int i = 0; i < dokumen.length; i++) {
            hasilFiltering.add(dokumen[i]);
            for (int j = 0; j < stoplist.length; j++) {

                if (dokumen[i].equalsIgnoreCase(stoplist[j])) {
                    hasilFiltering.remove(dokumen[i]);
                } else if (dokumen[i].equalsIgnoreCase("")) {
                    hasilFiltering.remove(dokumen[i]);
                }
            }
        }
        return hasilFiltering;
    }

    public static String[] GetStringArray(List<String> arr) {

        String str[] = new String[arr.size()];
        for (int j = 0; j < arr.size(); j++) {
            str[j] = arr.get(j);
        }
        return str;
    }

}