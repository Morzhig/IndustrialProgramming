import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;
import java.util.Arrays;
import java.util.stream.Collectors;

enum State{Start, Quantity, Estimated, Price, Name_Start, Author_Start, Numbers}

public class Pharma {
    public Drug[] shelf;
    public int size;
    public int count;

    Comparator<Drug> comparator = new Comparator<Drug>() {
        @Override
        public int compare(Drug o1, Drug o2) {
            return o1.Name.compareTo(o2.Name);
        }
    };

    public Pharma() {
        size = 0;
        count = 0;
        shelf = new Drug[size];
    }

    public Pharma(int size_) {
        size = size_;
        count = 0;
        shelf = new Drug[size];
    }

    public void input() throws Exception {
        Scanner in = new Scanner(new FileReader("input.txt"));

        size = in.nextInt();

        String name = null;
        String author = null;
        int est = 0;
        int quan = 0;
        double price = 0;

        while (in.hasNext()) {
            name = in.next();
            author = in.next();
            est = in.nextInt();
            quan = in.nextInt();
            price = in.nextDouble();

            if (est > 2025 || est < 2022)
                throw new Exception();
            if (quan > 100 || quan < 1)
                throw new Exception();

            Drug drug = new Drug(name, author, est, quan, price);

            add(drug);
        }
    }

    public void add(Drug drug) {
        try {
            shelf[count] = drug;
            count++;
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("\nСлишком много лекарств.");
        }
    }

//    public void unite(BookShelf bs) {
//        try {
//            for (int i = 0; i < bs.count; i++) {
//                shelf[count] = bs.shelf[i];
//                count++;
//            }
//        } catch (ArrayIndexOutOfBoundsException ex) {
//            System.out.println("\nToo many books. No other books will be added.");
//        }
//    }

    public Drug pop() {
        Drug temp = shelf[size - 1];
        size--;
        return temp;
    }

    public void Namesort() { Arrays.sort(shelf, comparator); }

    public void Pricesort() { Arrays.sort(this.shelf, ((o1, o2) -> {
        if (o1.Price > o2.Price)
            return -1;
        else if (o1.Price < o2.Price)
            return 1;
        else
            return 0;
    }));}

    public int binsearchN(Drug key) throws Exception {
        int k = Arrays.binarySearch(shelf, key, comparator) + 1;

        if (k > 0)
            return k;
        else
            throw new Exception();
    }

    public void print() {
        for (int i = 0; i < count; i++)
            System.out.println(shelf[i]);
    }

    public void group_by_Author() {
        Map<Object, List<Drug>> group = Arrays.asList(shelf)
                .stream()
                .collect(Collectors.groupingBy(s -> s.Author));

        System.out.println("\nЛекарства, отгруппированные по авторам:\n" + group);
    }

    public void filter_(String A) {
        System.out.println("Лекарства, принадлежащие компании " + A + ":");

        List<Drug> filter_ = Arrays.asList(shelf);
        filter_.stream().filter(s -> s.Author.equals(A)).forEach(Drug::print);
    }

//    static List<String> parse(String s) {
//        State state = State.Start;
//        List<String> result = new ArrayList<>();
//
//        StringBuilder name = new StringBuilder();
//        StringBuilder author = new StringBuilder();
//        StringBuilder quan = new StringBuilder();
//        StringBuilder price = new StringBuilder();
//        StringBuilder est = new StringBuilder();
//
//        for (char c : s.toCharArray()) {
//            switch (state) {
//                case Start:
//                    if (c == '"')
//                        state = State.Name_Start;
//
//                    else if (c == '<')
//                        state = State.Author_Start;
//
//                    else if (Character.isDigit(c))
//                        state = State.Numbers;
//
//                    else
//                        state = State.Start;
//
//                    break;
//
//                case Name_Start:
//                    if (c == '"') {
//                        state = State.Start;
//                    }
//
//                    else {
//                        name.append(c);
//                        state = State.Name_Start;
//                    }
//
//                    break;
//                case Author_Start:
//                    if (c == '>')
//                        state = State.Start;
//
//                    else {
//                        author.append(c);
//                        state = State.Author_Start;
//                    }
//
//                    break;
//
//                case Numbers:
//                    .append(c);
//                    state = State.Str_Const;
//
//                    break;
//
//                case Symb_Const:
//                    if (c == '\\') {
//                        fieldValue.append(c);
//                        state = State.Ctrl_SymbC;
//                    }
//
//                    else {
//                        fieldValue.append(c);
//                        state = State.Symb_End;
//                    }
//
//                    break;
//
//                case Ctrl_SymbC:
//                    fieldValue.append(c);
//                    state = State.Symb_Const;
//
//                    break;
//
//                case Symb_End:
//                    if (c == '/')
//                        state = State.Com_Beg;
//                    else if (c == '"') {
//                        fieldValue.append(c);
//                        state = State.Str_Const;
//                    }
//                    else {
//                        fieldValue.append(c);
//                        state = State.Start;
//                    }
//
//                    break;
//            }
//        }
//        result.add(fieldValue.toString());
//        return result;
}
