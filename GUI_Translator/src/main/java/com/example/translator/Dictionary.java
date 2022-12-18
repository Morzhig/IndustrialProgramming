package com.example.translator;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Dictionary {
    public static Words[] Eng;
    public static Words[] Fr;

    public static int size;

    static Comparator<Words> comparator = new Comparator<Words>() {
        @Override
        public int compare(Words o1, Words o2) {
            return Integer.compare(o1.id, o2.id);
        }
    };

    public static void input_eng() throws IOException {
        FileReader fr = new FileReader("input_eng.txt");
        Scanner in = new Scanner(fr);

        int id;
        String tmp;

        size = in.nextInt();
        Eng = new Words[size];

        while (in.hasNext()) {
            id = in.nextInt();
            tmp = in.next();

            Words a = new Words(id, tmp);

            Eng[id - 1] = a;
        }

        fr.close();
    }

    public static void input_fr() throws IOException {
        FileReader fr = new FileReader("input_fr.txt");
        Scanner in = new Scanner(fr);

        int id;
        String tmp;

        size = in.nextInt();
        Fr = new Words[size];

        while (in.hasNext()) {
            id = in.nextInt();
            tmp = in.next();

            Words a = new Words(id, tmp);

            Fr[id - 1] = a;
        }

        fr.close();
    }

    public static String translate(String key) throws Exception {
        Arrays.sort(Dictionary.Eng);

        StringTokenizer st = new StringTokenizer(key, " ,.?!\n");

        StringBuilder result = new StringBuilder();

        while(st.hasMoreTokens()) {
            String b = st.nextToken();

            Words a = new Words(-1, b);

            int k = Arrays.binarySearch(Eng, a);

            if (k < 0)
                result.append("----").append(' ');

            else {
                int ke = Arrays.binarySearch(Fr, Eng[k], comparator);

                if (ke < 0)
                    result.append("----").append(' ');
                else
                    result.append(Fr[ke].Word).append(' ');
            }
        }

        return result.toString();
    }


}
