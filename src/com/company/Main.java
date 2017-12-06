package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        int[] init = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<Matrice> matrices = new ArrayList<>();
        List<Matrice> matricesTemp = new ArrayList<>();

        Matrice test = new Matrice("123456789");
        StringBuilder sb = new StringBuilder();

        Map<String, Matrice> graph = new HashMap<>();

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

        for (Matrice node : matrices) {
            if (node.getMatrix().length() != 9)
                continue;
            graph.put(node.getMatrix(), node);
        }

        for(Matrice node : graph.values()){
            node.computeVoisins(graph);
        }

        Matrice m1 = graph.get("123456789").voisins.get(0);
        Matrice m2 = graph.get("1");

        for(Matrice m : graph.values()){
            if (m.getMatrix().length() < 10){
                System.out.println(m.getMatrix() + " length" + m.getMatrix().length());
            }

        }

        //List<Matrice> parcours = parcoursEnLargeur(graph.get("143276598"), graph);
        //System.out.println(parcours);
        parcours(graph.get("143276598"));
        System.out.println("test");

    }

    public static List<Matrice> parcoursEnLargeur(Matrice m,Map<String, Matrice> graph){
        LinkedList<Matrice> s = new LinkedList<>();
        s.addFirst(m);
        m.marquer();
        while(!s.isEmpty()){
            Matrice mat = s.pollFirst();
            for(Matrice cm : mat.voisins){
                if(cm.flag)
                    continue;
                cm.parents.addAll(mat.parents);
                cm.parents.add(mat);

                cm.marquer();
                s.addLast(cm);

                if(s.contains(graph.get("123456789"))){
                    cm.getParents().add(graph.get("123456789"));
                    return cm.getParents();
                }
            }
        }
        return null;
    }

    public static void parcours(Matrice m){
        LinkedList<Matrice> s = new LinkedList<>();
        s.addFirst(m);
        m.marquer();
        int nbParcourus = 0;
        while(!s.isEmpty()){
            Matrice mat = s.pollFirst();
            for(Matrice cm : mat.voisins){
                if(cm.flag)
                    continue;

                cm.marquer();
                s.addLast(cm);
                nbParcourus = nbParcourus + 1;
            }

        }
        System.out.println(nbParcourus);
    }

}
