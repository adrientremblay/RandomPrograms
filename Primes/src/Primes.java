public class Primes {
    public static void main(String args[]) {
        int n = 2;

        while (true) {
            boolean prime = true;

            for (int t = 2 ; t < n ; t++) {
                if (n % t == 0) {
                    prime = false;
                    break;
                }
            }

            if (prime)
                System.out.println(n);

            n++;
        }
    }
}
