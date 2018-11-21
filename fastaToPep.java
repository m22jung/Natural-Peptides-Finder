// 20 common amino acids
// GAVLIP FYW STCMNQ KRH DE
// ARNDCEQGHILKMFPSTWYV

// length of each peptide [20, 40]
// most 50 peptides in testcase
// each testcase mixes equal number of natural and random peptides

// input:
// ID1 LLLSLYYPNDRKLLDYKE
// IDxy VSRVSSDADPAGGWCRKWYSAHRGPDQDAALG
// output:
// IDxy 1.73
// ID1 0.59

import java.io.*;

public class fastaToPep {
    public static void main(String[] args) {
        BufferedReader br;
        BufferedWriter bw;
        try {
            br = new BufferedReader(new FileReader(args[0]));
            bw = new BufferedWriter(new FileWriter("output.txt"));

            StringBuilder sb = new StringBuilder();
            int lnum = 0;
            int pepnum = 0;
            String line = br.readLine();

            while (line != null) {
                if (lnum == 0) {
                    lnum++;
                } else if (line.charAt(0) == '>') {
                    String peptide = sb.toString();
                    bw.write(peptide);
                    bw.write('\n');
                    sb.setLength(0);
                    lnum++;
                    pepnum++;
                } else {
                    sb.append(line);
                    lnum++;
                }
                line = br.readLine();
            }
            br.close();
            bw.close();
            System.out.println("total number of peptides: " + pepnum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
