import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        int n;
        int base;
        n = cin.nextInt();
        base = cin.nextInt();
        int a, b;
        int p, q;
        int fenzi = 0, fenmu = 0;
        Fraction f = new Fraction(base, 1);
        while (n-- != 0) {
            a = cin.nextInt();
            b = cin.nextInt();
            p = cin.nextInt();
            q = cin.nextInt();

            f = f.add(new Fraction(a * p * -1, q));
            f = f.add(new Fraction(b * (q - p), q));
        }
        System.out.println(f);
    }
}

class Fraction {
    int nume;
    int deno;

    public Fraction(int nume, int deno) {
        this.nume = nume;
        this.deno = deno;
    }

    public Fraction add(Fraction b) {
        int lcm = lcm(this.deno, b.deno);
        int tempNume = (this.nume * lcm / this.deno + b.nume * lcm / b.deno);
        int gcd = gcd(tempNume > 0 ? tempNume : -tempNume, lcm);
        return new Fraction(tempNume / gcd, lcm / gcd);
    }

    private int gcd(int a, int b) {
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }

        if (b == 0) return 1;

        int r = a % b;
        if (r == 0) return b;
        else return gcd(b, r);
    }

    private int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    @Override
    public String toString() {
        if (nume == 0) return "0";
        else if (deno == 1) return "" + nume;
        else if (nume > deno) return (nume / deno) + "+" + (nume % deno) + "/" + deno;
        else if (nume == deno) return "1";
        else return nume + "/" + deno;
    }
}
