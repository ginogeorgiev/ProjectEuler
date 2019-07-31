import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Problems {

    private static int checksum(BigInteger bigInt) {
        String s = bigInt.toString();
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += Integer.parseInt(s.charAt(i) + "");
        }
        return sum;
    }

    private static long factorial(long n) {
        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }

    private static long sumical(long n) {
        return ((n * (n + 1)) / 2);
    }

    static boolean isPrimeA(long n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }


    static boolean isPrime(long n) {
        int i = 0;
        while (Constants.primes[i] <= n) {
            if (Constants.primes[i] == n) {
                return true;
            }
            i++;
        }
        return false;
    }

    static int[] sieveOfEratosthenes(int n) {
        List<Integer> primes = new ArrayList<>();
        boolean[] prime = new boolean[n + 1];
        for (int i = 0; i < n; i++)
            prime[i] = true;

        for (int p = 2; p * p <= n; p++) {
            if (prime[p]) {
                for (int i = p * p; i <= n; i += p)
                    prime[i] = false;
            }
        }

        for (int i = 2; i <= n; i++) {
            if (prime[i]) {
                primes.add(i);
            }
        }
        return ProjectEuler.toIntArray(primes);
    }

    static long factorAmount(long n) {
        long amount = 0;
        int num = (int) Math.sqrt(n);

        for (int i = 1; i <= num; i++) {
            if (n % i == 0) {
                amount += 2;
            }
            if (num * num == n) {
                amount--;
            }
        }
        return amount;
    }

    private static long[] primeFactorization(long n) {
        List<Long> factors = new ArrayList<>();
        if (isPrimeA(n)) {
            System.out.println("Number is Prime, no factorisation possible!");
            return new long[]{n};
        }
        for (int i = 2; i <= n; ) {
            if (isPrimeA(i) && n % i == 0) {
                factors.add((long) i);
                n /= i;
            } else {
                i++;
            }
        }
        long[] array = new long[factors.size()];
        for (int i = 0; i < factors.size(); i++) {
            array[i] = factors.get(i);
        }
        return array;
    }

    private static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    private static boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^0-9]", "");
        return s.equals(reverse(s));
    }

    private static int getNameScore(String s) {
        int score = 0;
        for (int i = 0; i < s.length(); i++) {
            score += (s.toUpperCase().charAt(i) - 64);
        }
        return score;
    }

    private static boolean isCircularPrime(long n) {
        long length = Long.toString(n).length();
        for (int i = 0; i < length; i++) {
            long firstDigitLvl = (long) Math.pow(10, length - 1);
            long last = n % 10;
            if (last % 10 == 1 || last % 10 == 3 || last % 10 == 7 || last % 10 == 9) {
                if (!isPrimeA((last * firstDigitLvl + n / 10))) {
                    return false;
                }
            }
            n = last * firstDigitLvl + n / 10;
        }
        return true;
    }

    private static boolean isPandigital(int n) {
        String number = Integer.toString(n);
        if (number.length() == 10) {
            boolean[] checker = new boolean[9];
            for (int i = 0; i < 9; i++) {
                int numberPos = number.charAt(i) % (int) Math.pow(10, i);
                checker[numberPos] = true;

            }
        }
        return false;
    }

    public int problem01() {
        int sum = 0;
        for (int i = 0; i < 1000; i++) {
            if (i % 3 == 0) {
                sum += i;
            }
            if (i % 5 == 0) {
                sum += i;
            }
            if (i % 15 == 0) {
                sum -= i;
            }
        }
        return sum;
    }

    public int problem02() {
        int f = 1;
        int g = 1;
        int h = f + g;
        int cap = 4 * 1000 * 1000;
        int sumEven = 0;
        while (f < cap) {
            sumEven += h;
            f = g + h;
            g = h + f;
            h = f + g;
        }
        return sumEven;
    }

    public long problem03() {                                        // largest prime factor of the number 600851475143
        long[] array = primeFactorization(600851475143L);
        return array[array.length - 1];
    }

    public int problem04(int min, int max) {                         // largest palindrome made from the product of two 3-digit numbers
        int product;
        int largestPalindrome = Integer.MIN_VALUE;
        for (int m = max; m > 1; m--) {
            for (int n = min; n < max + 1; n++) {
                product = n * m;
                if (largestPalindrome < product &&
                        isPalindrome(Integer.toString(product))) {
                    largestPalindrome = product;
                }
            }
        }
        return largestPalindrome;
    }

    public int problem05() {
        return 232792560;
    }

    public int problem06() {                                           // sum of the squares of 1-100 and the square of the sum
        int solution1 = 0;
        int solution2 = 0;
        for (int i = 1; i <= 100; i++) {
            solution1 += i * i;
            solution2 += i;
        }
        return solution2 * solution2 - solution1;
    }

    public int problem07() {                                           // 10001st prime
        int count = 0;
        int i = 2;
        while (count != 10001) {
            if (isPrime(i)) {
                count++;
            }
            i++;
        }
        System.out.print("The 10001st prime is:");
        return i - 1;
    }

    public long problem08() {
        long product = 1;
        long higherProduct = 1;

        for (int i = 0; i < Constants.oneThousandDigitNumber.length() - 13; i++) {
            for (int j = 0; j < 13; j++) {
                long value = Constants.oneThousandDigitNumber.charAt(i + j) - '0';
                product *= value;
            }
            if (product > higherProduct) {
                higherProduct = product;
            }
            product = 1;
        }
        return higherProduct;
    }

    public int problem09() {                                         // product of abc, where a + b + c = 1000 and a^2 + b^2 = c^2 is
        int result = 0;
        for (int c = 1; c <= 1000; c++) {
            for (int b = 1; b <= c; b++) {
                for (int a = 1; a <= b; a++) {
                    if (a + b + c == 1000 && a * a + b * b == c * c) {
                        System.out.println("a=" + a + " b=" + b + " c=" + c);
                        System.out.println(a + "+" + b + "+" + c + "=" + (a + b + c));
                        result = a * b * c;
                    }
                }
            }
        }
        return result;
    }

    public BigInteger problem10() {                                  // sum of all the primes below two million
        BigInteger bigInteger = new BigInteger("0");
        for (int i = 2; i < 2 * 1000 * 1000; i++) {
            if (isPrimeA(i)) {
                bigInteger = bigInteger.add(BigInteger.valueOf(i));
            }
        }
        return bigInteger;
    }

    // TODO
    public long problem11() {
        long produkt = 1;
        int highProduct = 0;

        int[][] array = {
                {8, 2, 22, 97, 38, 15, 0, 40, 0, 75, 4, 5, 7, 78, 52, 12, 50, 77, 91, 8},
                {49, 49, 99, 40, 17, 81, 18, 57, 60, 87, 17, 40, 98, 43, 69, 48, 4, 56, 62, 0},
                {81, 49, 31, 73, 55, 79, 14, 29, 93, 71, 40, 67, 53, 88, 30, 3, 49, 13, 36, 65},
                {52, 70, 95, 23, 4, 60, 11, 42, 69, 24, 68, 56, 1, 32, 56, 71, 37, 2, 36, 91},
                {22, 31, 16, 71, 51, 67, 63, 89, 41, 92, 36, 54, 22, 40, 40, 28, 66, 33, 13, 80},
                {24, 47, 32, 60, 99, 3, 45, 2, 44, 75, 33, 53, 78, 36, 84, 20, 35, 17, 12, 50},
                {32, 98, 81, 28, 64, 23, 67, 10, 26, 38, 40, 67, 59, 54, 70, 66, 18, 38, 64, 70},
                {67, 26, 20, 68, 2, 62, 12, 20, 95, 63, 94, 39, 63, 8, 40, 91, 66, 49, 94, 21},
                {24, 55, 58, 5, 66, 73, 99, 26, 97, 17, 78, 78, 96, 83, 14, 88, 34, 89, 63, 72},
                {21, 36, 23, 9, 75, 0, 76, 44, 20, 45, 35, 14, 0, 61, 33, 97, 34, 31, 33, 95},
                {78, 17, 53, 28, 22, 75, 31, 67, 15, 94, 3, 80, 4, 62, 16, 14, 9, 53, 56, 92},
                {16, 39, 5, 42, 96, 35, 31, 47, 55, 58, 88, 24, 0, 17, 54, 24, 36, 29, 85, 57},
                {86, 56, 0, 48, 35, 71, 89, 7, 5, 44, 44, 37, 44, 60, 21, 58, 51, 54, 17, 58},
                {19, 80, 81, 68, 5, 94, 47, 69, 28, 73, 92, 13, 86, 52, 17, 77, 4, 89, 55, 40},
                {4, 52, 8, 83, 97, 35, 99, 16, 7, 97, 57, 32, 16, 26, 26, 79, 33, 27, 98, 66},
                {88, 36, 68, 87, 57, 62, 20, 72, 3, 46, 33, 67, 46, 55, 12, 32, 63, 93, 53, 69},
                {4, 42, 16, 73, 38, 25, 39, 11, 24, 94, 72, 18, 8, 46, 29, 32, 40, 62, 76, 36},
                {20, 69, 36, 41, 72, 30, 23, 88, 34, 62, 99, 69, 82, 67, 59, 85, 74, 4, 36, 16},
                {20, 73, 35, 29, 78, 31, 90, 1, 74, 31, 49, 71, 48, 86, 81, 16, 23, 57, 5, 54},
                {1, 70, 54, 71, 83, 51, 54, 69, 16, 92, 33, 48, 61, 43, 52, 1, 89, 19, 67, 48},
        };

        return produkt;
    }

    public long problem12() {
        int num = 0;
        int i = 1;
        while (factorAmount(num) < 500) {
            num += i;
            i++;
        }
        return num;
    }

    public BigInteger problem13() {                                  // sum of 100 50-digit numbers

        String[] array = Constants.hundredFiftyDigitsNumber.split("\n");
        System.out.println(Arrays.toString(array));
        BigInteger bigInteger = new BigInteger("0");
        for (int i = 0; i < array.length; i++) {
            BigInteger bigInteger1 = new BigInteger(array[i]);
            System.out.println(bigInteger1);
            bigInteger = bigInteger.add(bigInteger1);
        }
        return bigInteger;
    }

    public long problem14() {
        long counter = 1;
        long counterOld = 0;
        long longestSeqNum = 1;
        long n;
        for (long i = 2; i < 1000000; i++) {
            n = i;
            counter = 1;
            while (n != 1) {
                if (n % 2 == 0) {
                    n /= 2;
                } else {
                    n = 3 * n + 1;
                }
                counter++;
            }
            if (counterOld < counter) {
                counterOld = counter;
                longestSeqNum = i;
            }
        }
        return longestSeqNum;
    }

    public int problem16() {
        int exponent = 1000;
        BigInteger number = new BigInteger("2");
        BigInteger result = number.pow(exponent);
        return checksum(result);
    }

    public int problem20() {
        BigInteger fac = new BigInteger("1");
        for (int i = 1; i < 100; i++) {
            fac = fac.multiply(BigInteger.valueOf(i));
        }
        return checksum(fac);
    }

    public int problem22() throws IOException {
        String[] names = {"", ""};
        int sum = 0;
        // String[] names = SelectionSortTest.getNames();
        SelectionSort.sortString(names);
        for (int i = 0; i < names.length; i++) {
            sum += getNameScore(names[i]) * (i + 1);
        }
        return sum;
    }

    public int problem25() {
        int i = 2;
        BigInteger f = new BigInteger("1");
        BigInteger h = new BigInteger("1");
        while (true) {
            BigInteger tmp = f;
            f = f.add(h);
            h = tmp;
            i++;
            if (f.toString().length() == 1000) {
                return i;
            }
        }
    }

    public int problem27() {
        int aMax = 0, bMax = 0, nMax = 0;

        for (int a = -999; a < 1000; a++) {
            for (int b = -1000; b <= 1000; b++) {
                int n = 0;
                while (isPrimeA(Math.abs(n * n + a * n + b))) {
                    n++;
                }
                if (n > nMax) {
                    aMax = a;
                    bMax = b;
                    nMax = n;
                }
            }
        }
        return aMax * bMax;
    }

    public int problem29() {
        HashSet<BigInteger> sequence = new HashSet<>();
        for (long a = 2; a <= 100; a++) {
            for (int b = 2; b <= 100; b++) {
                BigInteger bigA = BigInteger.valueOf(a);
                sequence.add(bigA.pow(b));
            }
        }
        return sequence.size();
    }

    public long problem34() {
        long sum = 0;
        for (int i = 3; i < 1000 * 1000; i++) {
            String number = Integer.toString(i);
            int[] array = new int[number.length()];
            int num = i;
            for (int j = 0; j < number.length(); j++) {
                array[j] = num % 10;
                num /= 10;
            }
            long facSum = 0;
            for (int value : array) {
                facSum += factorial(value);
            }
            if (facSum == i) {
                sum += i;
            }
        }
        return sum;
    }

    public int problem35() {
        int count = 0;
        for (int i = 2; i < 1000 * 1000; i++) {
            if (isPrimeA(i)) {
                if (isCircularPrime(i)) {
                    count++;
                }
            }
        }
        return count;
    }

    public int problem38() {
        return 0;
    }

    public int problem56() {
        int checker = 0;
        for (int i = 1; i < 100; i++) {
            for (int j = 1; j < 100; j++) {
                BigInteger bigInteger = BigInteger.valueOf(i);
                BigInteger result = bigInteger.pow(j);
                int max = checksum(result);
                if (max > checker) {
                    checker = max;
                }
            }
        }
        return checker;
    }

}
