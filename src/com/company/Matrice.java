package com.company;

import java.util.ArrayList;
import java.util.List;

public class Matrice {


    public String matrix;

    public Matrice (String string){
        this.matrix = string;
    }

    public String getMatrix() {
        return matrix;
    }

    public void setMatrix(String matrix) {
        this.matrix = matrix;
    }


    @Override
    public String toString() {
        return this.getMatrix();
    }
}
