package com.example.sql_table;

public class PersonList implements  Cloneable{
    public Person[] persons;

    public int size;
    public int count;

    public PersonList() {
        size = 0;
        persons = new Person[0];
        count = 0;
    }

    public PersonList(int count_) {
        size = count_;
        count = 0;
        persons = new Person[size];
    }

    public void Add(Person b) throws Exception {
        if (count == size)
            throw new Exception();
        else {
            count++;
            persons[count] = b;
        }
    }

//    public void writeJson(String jsonFileName) throws IOException {
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        Writer writer = Files.newBufferedWriter(Paths.get(jsonFileName));
//        gson.toJson(this, writer);
//        writer.close();
//    }

//    public void readJson(String jsonFileName) throws IOException {
//        Gson gson = new Gson();
//        Reader reader = Files.newBufferedReader(Path.of(jsonFileName));
//        var bookList = gson.fromJson(reader, PersonList.class);
//        persons = bookList.persons;
//        bookList.print();
//        reader.close();
//    }

//    public void print() {
//        var stream = persons.stream();
//        stream.forEach(System.out::println);
//    }
}