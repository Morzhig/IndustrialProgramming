package com.example.translator;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Words implements Comparable<Words>{
    public String Word;

    public int id;

    Words() {
        Word = "";
        id = 0;
    }

    Words(int id_, String Word_) {
        Word = Word_;
        id = id_;
    }

    @Override
    public int compareTo(Words word) {
        return Word.toLowerCase().compareTo(word.Word.toLowerCase());
    }

    @Override
    public String toString() {
        return  Integer.toString(id) + ' ' + Word;
    }
}
