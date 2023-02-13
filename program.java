import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import javax.swing.SwingWorker.StateValue;

public class program {
    public static void main(String[] args) {
        System.out.println("1. Sum of numbers");
        sumToMyNumber();
        System.out.println("2. Factorial");
        factorialMe();
        try {
        System.out.println("Calculating prime num to 1000, wait 3 sec :)");
        TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException ie) {
        Thread.currentThread().interrupt();
        }
        System.out.println("3. Prime numbers to 1000");
        primeNumbers();
        simpleCalculator();
    }

    static void sumToMyNumber() {
        // Вычислить n-ое треугольного число(сумма чисел от 1 до n)
        short stopNum, num, sum;
        Scanner input = new Scanner(System.in); // Resource leak: 'input' is never closedJava(536871799) - если input.close() то он не работает в других методах, пишет ошибку((
        System.out.println("Number, please: ");
        stopNum = input.nextShort();
        sum = 0;
        for (num = 1; num <= stopNum; num++) {
            sum += num;
        }
        System.out.printf("Your sum from 1 to %d is %d\n", stopNum, sum);
    }

    static void factorialMe() {
        // Вычислить n! (произведение чисел от 1 до n)
        short stopNum, num, fac;
        Scanner input = new Scanner(System.in);
        System.out.println("Number, please: ");
        stopNum = input.nextShort();
        fac = 1;
        for (num = 1; num <= stopNum; num++) {
            fac *= num;
        }
        System.out.printf("(factorial) Your %d! is %d\n", stopNum, fac);
        System.out.println();
    }

    static void primeNumbers() {
        // Вывести все простые числа от 1 до 1000
        short i, j, counter;
        i = 2;
        j = 0;
        counter = 0;
        for (i = 2; i <= 1000; i++) {
            for (j = 1; j <= i; j++) {
                if (i % j == 0)
                    counter++;
            }
            if (counter == 2)
                System.out.printf("%d is a prime\n", i);
            counter = 0;
        }
    }

    static void simpleCalculator() {
        double num1, num2, result;
        char sign;
        Scanner input = new Scanner(System.in);
        System.out.println("Input the first number: ");
        num1 = input.nextInt();
        System.out.println("Input a sign of operation, it must be {+, -, *, /} only: ");
        sign = input.next().charAt(0);
        System.out.println("Input the second number: ");
        num2 = input.nextInt();
        switch (sign) { //вроде как плохой тон использовать свитч-кейс, но тут вроде как раз исключение)
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
                System.out.printf("Uncorrect symbol of operation! Use only +,-,*,/");
                return; //Resource leak: 'input' is not closed at this locationJava(536871800) не понимаю почему!
        }
        System.out.printf("\n%s %s %s = %s", num1, sign, num2,result);
        // System.out.printf("%d %d %d = %d", num1, num2, sign, result);
        input.close();
    }
}
