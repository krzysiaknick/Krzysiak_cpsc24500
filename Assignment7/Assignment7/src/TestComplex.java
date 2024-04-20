
import java.util.Scanner;

public class TestComplex {


    public static void main(String[] args) {
        System.out.print("Enter the fist complex number: ");
        Scanner scan = new Scanner(System.in);

        double a = scan.nextDouble();
        double b = scan.nextDouble();

        Complex first = new Complex(a, b);

        System.out.print("Enter the second complex number: ");
        double c = scan.nextDouble();
        double d = scan.nextDouble();

        Complex second = new Complex(c, d);


        System.out.println("Addition: " + first.add(second));
        System.out.println("Subtraction: " + first.sub(second));
        System.out.println("Multiplication: " + first.multiply(second));
        System.out.println("Division: " + first.divide(second));
        System.out.println("Absolute: " + first.abs());

    }
}
