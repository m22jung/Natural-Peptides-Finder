import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Merfile {
    public static void main(String[] args) {
        BufferedReader br;
        BufferedWriter bwn, bwr;
        Map<String, Integer> natMer = new HashMap<>();
        Map<String, Integer> randMer = new HashMap<>();

        try {
            br = new BufferedReader(new FileReader(args[0]));
            bwn = new BufferedWriter(new FileWriter("outputNat.txt"));
            bwr = new BufferedWriter(new FileWriter("outputRan.txt"));
            int lnum = 0;
            String line = br.readLine();

            while (line != null) {
                for (int i = 0; i < line.length() - 2; ++i) {
                    String mer = line.substring(i, i + 3);

                    if (lnum % 2 == 0) {
                        if (natMer.containsKey(mer)) {
                            natMer.put(mer, natMer.get(mer) + 1);
                        } else {
                            natMer.put(mer, 1);
                        }
                    } else {
                        if (randMer.containsKey(mer)) {
                            randMer.put(mer, randMer.get(mer) + 1);
                        } else {
                            randMer.put(mer, 1);
                        }
                    }
                }
                lnum++;
                line = br.readLine();
            }
            br.close();

            for (Map.Entry<String, Integer> entry : natMer.entrySet()) {
                bwn.write(entry.getKey());
                bwn.write(' ');
                bwn.write(entry.getValue().toString());
                bwn.write('\n');
            }
            for (Map.Entry<String, Integer> entry : randMer.entrySet()) {
                bwr.write(entry.getKey());
                bwr.write(' ');
                bwr.write(entry.getValue().toString());
                bwr.write('\n');
            }

            bwn.close();
            bwr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
