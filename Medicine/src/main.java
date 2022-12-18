import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class main {
    public static void main(String[] args) throws IOException {
        Pharma A1 = new Pharma(5);

        try {
            A1.input();
        } catch (Exception e) {
            System.out.println("\nНеправильный формат ввода срока годности или количества упаковок.\n");
            throw new RuntimeException(e);
        }

        System.out.println("\nСписок лекарств: ");
        A1.print();

        A1.Namesort();
        System.out.println("\nСписок, отсортированный по названиям: ");
        A1.print();

        Drug key = new Drug("Кватрос", "ХИМФАРМ", 2022, 14, 4.93);
        try {
            System.out.println("\nНомер лекарства " + key.toString() + ": " + A1.binsearchN(key));
        }
        catch(Exception ex) {
            System.out.println("\nЗдесь нет: " + key.toString());
        }

        A1.group_by_Author();
        A1.Pricesort();
        System.out.println("\nСписок, отсортированный по убыванию цены: ");
        A1.print();

        A1.group_by_Author();
        System.out.println();

        A1.filter_("ХИМФАРМ");
    }
}
