import java.io.*;
import java.text.*;
import java.util.Scanner;

// Разложить корень из (1+х) в ряды Тейлора
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your 'x' (x is (-1; 1)): ");
        double x = in.nextDouble();
        if(x > 1 || x < -1){
            System.out.print("x should be > 1 and < -1.");
        }
        else {
            System.out.print("Enter the power of comparable number: ");
            int n = in.nextInt();
            zadanie(x, n);
        }
    }
    public static void zadanie(double a, int n){
        double res = 1, verh = 1, niz = 1, temp = 1, fact = 1, fact_ = 1;
        double i = 0;
        double exp = Math.pow(10, -n);
        while (Math.abs(temp) > exp) {
            temp *= (1 - 2 * i) / (2 * (i + 1)) * a;
            res += temp;
            i++;
        }
        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMaximumFractionDigits(n);
        System.out.print("My Sqrt: ");
        System.out.print(formatter.format(res));
        System.out.println();
        System.out.print("Java's Sqrt: ");
        System.out.print(formatter.format(Math.sqrt(1+a)));
    }
}