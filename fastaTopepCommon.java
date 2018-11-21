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
import java.util.HashSet;
import java.util.Set;

public class fastaTopepCommon {
    public static void main(String[] args) {
        BufferedReader br;
        BufferedWriter bw;
        Set<Character> commonPeptides = new HashSet<>();
        commonPeptides.add('A');commonPeptides.add('R');commonPeptides.add('N');
        commonPeptides.add('D');commonPeptides.add('C');commonPeptides.add('E');
        commonPeptides.add('Q');commonPeptides.add('G');commonPeptides.add('H');
        commonPeptides.add('I');commonPeptides.add('L');commonPeptides.add('K');
        commonPeptides.add('M');commonPeptides.add('F');commonPeptides.add('P');
        commonPeptides.add('S');commonPeptides.add('T');commonPeptides.add('W');
        commonPeptides.add('Y');commonPeptides.add('V');

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
                    boolean flag = false;
                    Character c;

                    for (int i = 0; i < peptide.length(); i++) {
                        c = peptide.charAt(i);
                        if (!commonPeptides.contains(c)) {
                            flag = true;
                            break;
                        }
                    }

                    if (!flag) {
                        bw.write(peptide);
                        bw.write('\n');
                        pepnum++;
                    }
                    sb.setLength(0);
                    lnum++;

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
