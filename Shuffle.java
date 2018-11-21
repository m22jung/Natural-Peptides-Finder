import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class Shuffle {
    public static void main(String[] args) {
        Shuffle s = new Shuffle();

        BufferedReader br;
        BufferedWriter bw;

        try {
            br = new BufferedReader(new FileReader(args[0]));
            bw = new BufferedWriter(new FileWriter("output.txt"));

            String line = br.readLine();
            while (line != null) {
                String shuffled = s.shuffle(line);
                bw.write(line);
                bw.write('\n');
                bw.write(shuffled);
                bw.write('\n');
                line = br.readLine();
            }
            br.close();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String shuffle(String input) {
        List<Character> characters = new ArrayList<>();
        for(char c:input.toCharArray()){
            characters.add(c);
        }
        StringBuilder output = new StringBuilder(input.length());
        while(characters.size()!=0){
            int randPicker = (int)(Math.random()*characters.size());
            output.append(characters.remove(randPicker));
        }
        return output.toString();
    }
}