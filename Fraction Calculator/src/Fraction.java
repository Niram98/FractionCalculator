public class Fraction {

    private Integer numerator;
    private Integer denominator;

    public Fraction(Integer numerator, Integer denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction(Integer numerator) {
        this.numerator = numerator;
        this.denominator = 1;
    }

   public String toString(){
        if (denominator == 1) {
            return numerator + "";
        } else if (numerator % denominator == 0) {
            return numerator / denominator + "";
        } else {
            return numerator + "/" + denominator;
        }

   }

   public Fraction add(Fraction other) {
       return new Fraction(this.numerator * other.denominator + other.numerator * this.denominator,
               this.denominator * other.denominator);
   }

   public Fraction subtract(Fraction other) {
        return new Fraction(other.numerator * this.denominator - this.numerator * other.denominator,
                this.denominator * other.denominator );
   }

   public Fraction multiply(Fraction other) {
        return  new Fraction(this.numerator * other.numerator,
                this.denominator * other.denominator);
   }

   public Fraction divide(Fraction other) {
        if (this.numerator * other.denominator == 0) {
            throw new IllegalArgumentException();
        }
        return new Fraction(other.numerator * this.denominator,
                this.numerator * other.denominator);
   }

   public boolean equals(Object other) {
        toLowestTerms();
        if (other.equals(this.numerator + "/" + this.denominator)) {
            return true;
        } else {
            return false;
        }
   }

   public void toLowestTerms() {

        Integer gcd = gcd(getNumerator(), getDenominator());
        numerator = getNumerator() / gcd;
        denominator = getDenominator() / gcd;
   }

   public static Integer gcd (Integer num, Integer den) {
         while(num != 0 && den != 0) {
            Integer remainder = num % den;
            num = den;
            den = remainder;
        }
        return num;
   }

    public Integer getNumerator() {
        return numerator;
    }

    public Integer getDenominator() {
        return denominator;
    }
}
