package com.company;

import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        int[] init = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<Matrice> allMatrices = new ArrayList<>();
        List<Matrice> matricesTemp = new ArrayList<>();

        Matrice test = new Matrice("123456789");
        StringBuilder sb = new StringBuilder();

        Map<String, Matrice> graph = new HashMap<>();

        String s;

        int i;
        for (int n = 2; n <= 9; n++) {
            if (n == 2) {
                allMatrices.add(new Matrice("12"));
                allMatrices.add(new Matrice("21"));
            } else {
                for (Matrice node : allMatrices) {
                    for (i = 0; i < n; i++) {
                        sb = new StringBuilder(node.getMatrix());
                        s = "" + n;
                        sb.insert(i, s.charAt(0));
                        matricesTemp.add(new Matrice(sb.toString()));
                    }
                }
                allMatrices.clear();
                for (Matrice node : matricesTemp) {

                    allMatrices.add(node);
                }

                matricesTemp.clear();
            }

        }

        for (Matrice m : allMatrices) {
            if (m.getMatrix().length() != 9)
                continue;
            graph.put(m.getMatrix(), m);
        }

        for (Matrice m : graph.values()) {
            m.computeVoisins(graph);
        }

        computeSolution(graph.get("143276598"), graph);
        computeSolution(graph.get("918273645"), graph);
        //computeSolution(graph.get("745981326"), graph);
        computeSolution(graph.get("657483912"), graph);
        computeSolution(graph.get("975431862"), graph);

        resetFlags(graph);
        System.out.println("Le nombre de composantes connexes est : " + nbComposanteConnexe(graph).size());
        //ArrayList<Matrice> mats = new ArrayList<>(graph.values());
        System.out.println("Le nombre de rotations minimal: " + nbRotationMinimal(graph));


    }

    public static List<Matrice> parcoursEnLargeur(Matrice m, Map<String, Matrice> graph) {
        resetFlags(graph);
        LinkedList<Matrice> s = new LinkedList<>();
        s.addFirst(m);
        m.marquer();
        while (!s.isEmpty()) {
            Matrice mat = s.pollFirst();
            for (Matrice cm : mat.voisins) {
                if (cm.flag)
                    continue;
                cm.parents.addAll(mat.parents);
                cm.parents.add(mat);

                cm.marquer();
                s.addLast(cm);

                if (s.contains(graph.get("123456789"))) {
                    cm.getParents().add(graph.get("123456789"));
                    return cm.getParents();
                }
            }
        }
        return null;
    }

    public static ArrayList<ArrayList<Matrice>> nbComposanteConnexe(Map<String, Matrice> graph) {
        List<Matrice> matrices = new ArrayList<>(graph.values());
        ArrayList<Matrice> courante = new ArrayList<>();
        ArrayList<ArrayList<Matrice>> returner = new ArrayList<ArrayList<Matrice>>();
        while (!matrices.isEmpty()) {
            parcoursQ3(courante, matrices.get(0));
            matrices.removeAll(courante);
            returner.add(new ArrayList<>(courante));
            courante.clear();
        }
        for (Matrice m : matrices) {
            m.flag = false;
        }
        return returner;
    }

    private static void parcoursQ3(ArrayList<Matrice> courante, Matrice m) {
        Stack<Matrice> s = new Stack();
        s.push(m);
        courante.add(m);
        m.marquer();
        int nbParcouru = 1;
        while(!s.empty()){
            for(Matrice cm : s.pop().voisins){
                if(cm.flag)
                    continue;
                cm.marquer();
                s.push(cm);
                courante.add(cm);
                nbParcouru = nbParcouru +1;
            }
        }
    }

    public static int nbRotationMinimal(Map<String, Matrice> graph){
        resetFlags(graph);
        LinkedList<Matrice> s = new LinkedList<>();
        Matrice m = graph.get("123456789");
        s.addFirst(m);
        m.marquer();
        m.niveau = 0;
        int max = 0;
        while (!s.isEmpty()) {
            Matrice mat = s.pollFirst();
            for (Matrice cm : mat.voisins) {
                if (cm.flag)
                    continue;

                cm.marquer();
                s.addLast(cm);
                cm.niveau = mat.niveau+1;
                max = Math.max(cm.niveau , max);
            }
        }
        return max;
    }

    public static void resetFlags(Map<String, Matrice> graph) {
        for (Matrice m : graph.values()) {
            m.flag = false;
            m.parents.clear();
        }
    }

    public static void computeSolution(Matrice matrice, Map<String, Matrice> graph) {
        int nbEtapes = 0;
        String matrix = matrice.getMatrix();
        System.out.println("Pour la matrice  : " + matrix);
        List<Matrice> parcours = new ArrayList<>(parcoursEnLargeur(graph.get(matrix), graph));
        nbEtapes = parcours.size() - 1;
        System.out.println("Il y a : " + nbEtapes + " rotations à effectuer");
        System.out.println("Les rotations sont :" + parcours);
        parcours.clear();
    }


}
