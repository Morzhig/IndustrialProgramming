package com.example.table_books;

public class Books implements Comparable<Books> {
    public String Name;
    public String Author;
    public int Id;

    public Books(String name, String author, int id) {
        Name = name;
        Author = author;
        Id = id;
    }

    public Books() {
    }

    public String getAuthor() {
        return Author;
    }

    public void setName (String name){
        this.Name = name;
    }

    public void setAuthor(String author) {
        this.Author = author;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public int getId(){
        return Id;
    }

    public void print() {
        System.out.println(this.toString());
    }

    @Override
    public int compareTo(Books book) {
        return Author.compareTo(book.Author);
    }

    @Override
    public String toString() {
        return '"' + Name + '"' + " " + Author;
    }
}