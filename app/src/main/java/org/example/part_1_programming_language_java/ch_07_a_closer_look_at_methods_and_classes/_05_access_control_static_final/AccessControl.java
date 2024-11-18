package org.example.part_1_programming_language_java.ch_07_a_closer_look_at_methods_and_classes._05_access_control_static_final;

class Test {
    int a; // default access
    public int b; // public access
    private int c; // private access

    // cannot modify its value
    final double PI = 3.14;

    // static variables are like global variables - can be accessed without a reference to any object
    // static methods can only access other static methods and variables. can't refer to this or super
    static double g = 9.8;

    static {
        System.out.println("Static block initialized...");
        g = g + 1;
        System.out.println("static function -> g+1 = " + g);
        System.out.println();
    }

    // method to set ca
    public void setC(int c) {
        this.c = c;
    }

    // method to get c
    public int getC() {
        return c;
    }
}

public class AccessControl {
    public static void main(String[] args) {
        System.out.println("static -> g = " + Test.g);

        Test test = new Test();
        test.a = 11;
        test.b = 12;
        test.setC(13);
        System.out.println("public -> a & b are: " + test.a + " " + test.b);
        System.out.println("private -> c is: " + test.getC());
        System.out.println("final -> PI = " + test.PI);
    }
}
