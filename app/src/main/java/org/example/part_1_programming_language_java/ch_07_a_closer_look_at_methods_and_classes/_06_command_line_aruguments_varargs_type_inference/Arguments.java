package org.example.part_1_programming_language_java.ch_07_a_closer_look_at_methods_and_classes._06_command_line_aruguments_varargs_type_inference;

public class Arguments {
    static void varargsTest(int... v) {
        for (int x : v) {
            System.out.println("x: " + x);
        }
    }

    static void varargsTest(boolean... v) {
        for (boolean x : v) {
            System.out.println("x: " + x);
        }
    }

    public static void main(String[] args) {
        // command line arguments
        for (int i = 0; i < args.length; i++) {
            System.out.println("args[" + i + "]: " + args[i]);
        }

        // variable length arguments
        System.out.println();
        varargsTest(1, 2, 3);
        System.out.println();
        varargsTest(true, false);
        System.out.println();

        //type inference
        var a = "hello";
        System.out.println("var a: " + a);
        a = "edit hello";
        System.out.println("var a: " + a);
        var b = 123;
        System.out.println("var b: " + b);
    }
}
