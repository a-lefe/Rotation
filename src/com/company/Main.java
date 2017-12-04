package com.company;

import com.sun.prism.shader.Solid_ImagePattern_Loader;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        int[] init = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Matrice matrice = new Matrice("123456789");


        List<Matrice> matrices = new ArrayList<>();
        List<Matrice> matricesTemp = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        String s;

        int i;
        for (int n = 2; n <= 9; n++) {
            if (n == 2) {
                matrices.add(new Matrice("12"));
                matrices.add(new Matrice("21"));
            } else {
                for (Matrice node : matrices) {
                    for (i = 0; i < n; i++) {
                        sb = new StringBuilder(node.getMatrix());
                        s = "" + n;
                        sb.insert(i, s.charAt(0));
                        matricesTemp.add(new Matrice(sb.toString()));
                    }
                }
                matrices.clear();
                for (Matrice node : matricesTemp) {
                    matrices.add(node);
                }
                matricesTemp.clear();
            }
        }

        System.out.println(matrices.size());
    }
}
