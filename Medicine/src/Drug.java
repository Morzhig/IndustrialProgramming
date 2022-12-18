import java.util.Comparator;

public class Drug implements Comparable<Drug> {
    public String Name;
    public String Author;
    public int Est;
    public int Quan;
    public double Price;

    public Drug(String name, String author, int est, int quan, double price) {
        Name = name;
        Author = author;
        Est = est;
        Quan = quan;
        Price = price;
    }

    public void print() {
        System.out.println(this.toString());
    }

    @Override
    public int compareTo(Drug drug) {
        if (drug.Price > Price)
            return 1;
        else
            return 0;
    }

    @Override
    public String toString() {
        return '"' + Name + '"' + " " + Author + " " + Est + " " + Quan + " " + Price;
    }
}