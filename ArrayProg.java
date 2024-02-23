import java.util.Scanner;
public class ArrayProg {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] values = new double[20];
        int count = 0;

        System.out.println("Enter up to 20 double values, or enter any non-double value number to stop:");

        while (count < 20 && sc.hasNextDouble()) {
            double value = sc.nextDouble();
            values[count] = value;
            count++;
            System.out.println("Values entered:");
            for (int val = 0; val < count; val++) {
                System.out.println(values[val]);
            }
        }
    }

}

