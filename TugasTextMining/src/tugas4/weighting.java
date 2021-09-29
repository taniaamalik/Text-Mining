/*
Nama Kelompok :
Erlina Rohmawati (175150201111045)
Tania Malik Iryana (175150201111053)
Alvina Eka ((175150201111056)
Jeowandha Ria Wiyani (175150207111029)
 */

package tugas4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class weighting {

    private String[][] stem;

    public void setText(String[][] stem) {
        this.stem = stem;
    }

    public List<HashMap<String, Integer>> getTFDokumen() {
        List<HashMap<String, Integer>> myMap = new ArrayList<HashMap<String, Integer>>();

        HashMap<String, Integer> freq2 = new HashMap<>();
        String[] dok;

        for (int i = 0; i < stem.length; i++) {
            dok = stem[i];
            HashMap<String, Integer> freq = new HashMap<>();

            for (int j = 0; j < dok.length; j++) {
                String kata = dok[j];
                if (kata != null) {
                    if (freq.containsKey(kata)) {
                        int count = freq.get(kata);
                        count++;
                        freq.put(kata, count);
                    } else {
                        freq.put(kata, 1);
                    }
                }

            }
            myMap.add(freq);
        }

        return myMap;
    }

    public int[][] getTF() {
        List<HashMap<String, Integer>> freq = getTFDokumen();
        List<String> feature = new ArrayList<>(getFeatures());
        int n_doc = freq.size();
        int n_terms = feature.size();

        int[][] TFMatrix = new int[n_terms][n_doc];
        for (int i = 0; i < n_doc; i++) {
            for (int j = 0; j < n_terms; j++) {
                if (freq.get(i).containsKey(feature.get(j))) {
                    TFMatrix[j][i] = freq.get(i).get(feature.get(j));
                }
            }
        }

        return TFMatrix;
    }

    public Set<String> getFeatures() {
        String[] data;
        Set<String> feature = new HashSet<String>();
        for (int i = 0; i < getTFDokumen().size(); i++) {
            feature.addAll(getTFDokumen().get(i).keySet());
        }
        return feature;

    }

    public double[][] getTFIDF() {
        List<HashMap<String, Integer>> freq = getTFDokumen();
        List<String> feature = new ArrayList<>(getFeatures());
        int n_doc = freq.size();
        int n_terms = feature.size();

        double[][] DocFreq = new double[n_terms][n_doc + 2];
        double[][] tfIdf = new double[n_terms][n_doc];
        for (int i = 0; i < n_doc + 2; i++) {
            for (int j = 0; j < n_terms; j++) {
                if (i < n_doc) {
                    if (getTF()[j][i] != 0) {
                        DocFreq[j][i] = 1 + Math.log10(getTF()[j][i]); //Log Frequency Weighting
                        DocFreq[j][n_doc] += 1; //df
                        DocFreq[j][n_doc + 1] = Math.log10(n_doc / DocFreq[j][n_doc]); //idf
                        tfIdf[j][i] = DocFreq[j][i] * DocFreq[j][n_doc + 1];
                    }
                }
            }

        }
        return tfIdf;
    }
}