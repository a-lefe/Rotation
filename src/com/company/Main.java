package com.company;

import com.sun.prism.shader.Solid_ImagePattern_Loader;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<Matrice> matrices = new ArrayList<>();
    List<Matrice> matricesTemp = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    String s = new String();

    public static void main(String[] args) {

        System.out.println("Helloworld");
        int[] init = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(matrices);
    }

    public void generateMatrix(){
        for(int n = 2; n <=9; n++){
            if(n == 2){
                matrices.add(new Matrice("12"));
                matrices.add(new Matrice("21"));
            }else{
                for(Matrice matrice: matrices){
                    for(int i = 1; i<=n; i++){
                        sb = new StringBuilder(matrice.getMatrix());
                        s = ""+n;
                        sb.insert(i-1, s.charAt(0));
                        matricesTemp.add(new Matrice(sb.toString()));
                    }
                }
                matrices.clear();
                for(Matrice node: matricesTemp){
                    matrices.add(node);
                }
                matricesTemp.clear();
            }
        }
    }
}
