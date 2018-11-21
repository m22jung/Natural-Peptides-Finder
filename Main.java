/*
 * CS 482 Assignment 2
 * Myungsun Jung
 * 20511678
 */

// 20 common amino acids
// GAVLIP FYW STCMNQ KRH DE
// ARNDCEQGHILKMFPSTWYV

// length of each peptide [20, 40]
// most 50 peptides in testcase
// each testcase mixes equal number of natural and random peptides

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        File filenat = new File("3merNat.txt");
        File filerand = new File("3merRan.txt");
        Map<String, Double> score = new HashMap<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(args[0]));
            String line = br.readLine();

            while (line != null) {
                Map<String, Double> merScore = new HashMap<>();

                Scanner input = new Scanner(line);
                input.useDelimiter(" ");

                String id = input.next();
                String peptide = input.next();
                // make 3-mer from input peptides and store it to merScore map
                for (int i = 0; i < peptide.length() - 2; ++i) {
                    String mer = peptide.substring(i, i + 3);
                    merScore.put(mer, 0.0d);
                }

                // find 3-mer frequency from 3mer file and store it to merScore
                // merScore = log(Natural 3-mer) - log(Random 3-mer) (here used log base 2)
                for (Map.Entry<String, Double> entry : merScore.entrySet()) {
                    Scanner scanNat = new Scanner(filenat);
                    Scanner scanRan = new Scanner(filerand);

                    while (scanNat.hasNextLine()) {
                        String lineNat = scanNat.nextLine();
                        if(lineNat.substring(0, 3).equals(entry.getKey())) {
                            merScore.put(entry.getKey(), (double)Integer.parseInt(lineNat.substring(4)));
                            break;
                        }
                    }
                    while (scanRan.hasNextLine()) {
                        String lineRan = scanRan.nextLine();
                        if (lineRan.substring(0, 3).equals(entry.getKey())) {
                            // here used log base 2
                            double val = Math.log(entry.getValue()) - Math.log(Integer.parseInt(lineRan.substring(4)));
                            merScore.put(entry.getKey(), val);
                            break;
                        }
                    }
                }

                // sum up all 3-mer score to get final score of a peptide
                double sum = 0.0d;
                for (Map.Entry<String, Double> entry : merScore.entrySet()) {
                    sum += entry.getValue();
                }
                score.put(id, sum);
                line = br.readLine();
            }
            br.close();

            // sort score map by its score from high to low
            List<Map.Entry<String, Double>> list = new LinkedList<>(score.entrySet());
            Collections.sort(list, new Comparator<Map.Entry<String, Double>>() {
                public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) {
                    return o2.getValue().compareTo(o1.getValue());
                }
            });

            // print sorted List
            for (Map.Entry<String , Double> entry : list) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
