package com.example.table_books;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class BookShelf {
    public Books[] shelf;
    public int size;
    public int count;

    public BookShelf() {
        size = 0;
        count = 0;
        shelf = new Books[size];
    }

    public BookShelf(int size_) {
        size = size_;
        count = 0;
        shelf = new Books[size];
    }
}
