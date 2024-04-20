/*
Nicholas Krzysiak
04/19/2024
Assignment 7

This program reads complex numbers and performs multiple operations including
addition
subtraction
multiplication
division
absolute values

See testComplex.java for test implementation
 */



public class Complex implements Comparable<Complex>{
    private double real;
    private double imag;

    // Default constructor
    public Complex() {
        this(0, 0);
    }

    public Complex(double real,double imag) {
        this.real = real;
        this.imag = imag;

    }

    public Complex(double real){
        this(real, 0);
    }


    public Complex(Complex complexNumber){
        this(complexNumber.real, complexNumber.imag);
    }


    public double getRealPart() {
        return real;
    }


    public double getImagPart(){
        return imag;
    }

    //adds complex numbers
    public Complex add(Complex other){
        return new Complex(real + other.real, imag + other.imag);
    }



    //subtracts complex numbers
    public Complex sub(Complex other){
        return new Complex(real - other.real, imag - other.imag);
    }



    //multiplies complex numbers
    public Complex multiply(Complex other) {
        return new Complex(real * other.real - imag * other.imag,
                real * other.imag + imag * other.real);
    }




    //divides complex numbers
    public Complex divide(Complex other) {
        double denominator = other.real * other.real + other.imag * other.imag;
        double realPart = (real * other.real + imag * other.imag) / denominator;
        double imagPart = (imag * other.real - real * other.imag) / denominator;
        return new Complex(realPart, imagPart);
    }


    //finds absolute values
    public double abs() {
        return Math.sqrt(real * real + imag * imag);
    }


    @Override
    public int compareTo(Complex other) {
        return Double.compare(this.abs(), other.abs());
    }




    //converts to sting and rounds to 2 decimal places
    @Override
    public String toString() {
        if (imag == 0) return String.format("%.2f", real);
        return String.format("(%s + %si)", String.format("%.2f", real), String.format("%.2f", imag));
    }



}
