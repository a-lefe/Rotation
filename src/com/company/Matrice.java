package com.company;

import java.util.*;

public class Matrice {


    public String matrix;

    public List<Matrice> voisins = new ArrayList<>();
    public int niveau = 0;

    public Matrice (String string){
        this.matrix = string;
    }

    public String getMatrix() {
        return matrix;
    }

    public List<Matrice> parents = new ArrayList<>();

    public boolean flag = false;


    public List<Matrice> computeVoisins(Map<String, Matrice> graph) {
        List<Matrice> voisins = new ArrayList<>();
        char c0, c1, c2, c3, c4, c5, c6, c7, c8, c9;
        StringBuilder string = null;
        String initial = this.getMatrix();
        for(int i = 1; i<=8; i++){
            switch(i){
                case 1:
                    string = new StringBuilder(initial);
                    c0 = initial.charAt(0);
                    c1 = initial.charAt(1);
                    c3 = initial.charAt(3);
                    c4 = initial.charAt(4);
                    string.setCharAt(0, c3);
                    string.setCharAt(1,c0);
                    string.setCharAt(3,c4);
                    string.setCharAt(4, c1);
                    break;
                case 2:
                    string = new StringBuilder(initial);
                    c1= initial.charAt(1);
                    c2 = initial.charAt(2);
                    c4 = initial.charAt(4);
                    c5 = initial.charAt(5);
                    string.setCharAt(1, c4);
                    string.setCharAt(2,c1);
                    string.setCharAt(4,c5);
                    string.setCharAt(5, c2);
                    break;
                case 3:
                    string = new StringBuilder(initial);
                    c3 = initial.charAt(3);
                    c4 = initial.charAt(4);
                    c6 = initial.charAt(6);
                    c7 = initial.charAt(7);
                    string.setCharAt(3, c6);
                    string.setCharAt(4,c3);
                    string.setCharAt(6,c7);
                    string.setCharAt(7, c4);
                    break;
                case 4:
                    string = new StringBuilder(initial);
                    c4 = initial.charAt(4);
                    c5 = initial.charAt(5);
                    c7 = initial.charAt(7);
                    c8 = initial.charAt(8);
                    string.setCharAt(4, c7);
                    string.setCharAt(5,c4);
                    string.setCharAt(7,c8);
                    string.setCharAt(8, c5);
                    break;
                case 5:
                    string = new StringBuilder(initial);
                    c0 = initial.charAt(0);
                    c1 = initial.charAt(1);
                    c3 = initial.charAt(3);
                    c4 = initial.charAt(4);
                    string.setCharAt(0, c1);
                    string.setCharAt(1,c4);
                    string.setCharAt(3,c0);
                    string.setCharAt(4, c3);
                    break;
                case 6:
                    string = new StringBuilder(initial);
                    c1 = initial.charAt(1);
                    c2 = initial.charAt(2);
                    c4 = initial.charAt(4);
                    c5 = initial.charAt(5);
                    string.setCharAt(1, c2);
                    string.setCharAt(2,c5);
                    string.setCharAt(4,c1);
                    string.setCharAt(5, c4);
                    break;
                case 7:
                    string = new StringBuilder(initial);
                    c3 = initial.charAt(3);
                    c4 = initial.charAt(4);
                    c6 = initial.charAt(6);
                    c7 = initial.charAt(7);
                    string.setCharAt(3, c4);
                    string.setCharAt(4,c7);
                    string.setCharAt(6,c3);
                    string.setCharAt(7, c6);
                    break;
                case 8:
                    string = new StringBuilder(initial);
                    c4 = initial.charAt(4);
                    c5 = initial.charAt(5);
                    c7 = initial.charAt(7);
                    c8= initial.charAt(8);
                    string.setCharAt(4, c5);
                    string.setCharAt(5,c8);
                    string.setCharAt(7,c4);
                    string.setCharAt(8, c7);
                    break;
                default:
                    break;
            }
            this.voisins.add(graph.get(string.toString()));
        }


        return this.voisins;
    }

    public void marquer(){
        this.flag = true;
    }

    public List<Matrice> getParents() {
        return parents;
    }

    public void setParents(List<Matrice> parents) {
        this.parents = parents;
    }

    @Override
    public String toString() {
        return this.getMatrix();
    }

}
