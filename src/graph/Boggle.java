package graph;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Ravikanth on 5/20/2018.
 */
public class Boggle {

    private boolean[][] visited;
    private Set<String> dictionary;
    private Set<String> found;

    public Boggle(String[] dict, char[][] bogle) {
        visited = new boolean[bogle.length][bogle[0].length];
        dictionary = new HashSet<>();
        for (String s : dict) {
            dictionary.add(s);
        }
        found = new TreeSet<>();

        for (int i = 0; i < bogle.length; i++) {
            for (int j = 0; j < bogle[0].length; j++) {
                dfs(bogle, i, j, "");
            }
        }

        for (String s : found){
            System.out.println(s);
        }
    }

    private void dfs(char[][] bogle, int i, int j, String soFar) {
        visited[i][j] = true;

        soFar = soFar + bogle[i][j];

        if (dictionary.contains(soFar)) {
            found.add(soFar);
        }
        for (int k = i - 1; k <= i + 1; k++) {
            for (int l = j - 1; l <= j + 1; l++) {
                if (isValid(bogle, k, l) && !visited[k][l]) {
                    dfs(bogle, k, l, soFar);
                }
            }
        }


        visited[i][j] = false;
    }

    private boolean isValid(char[][] A, int i, int j) {
        return i >= 0 && j >= 0 && i < A.length && j < A[0].length;
    }

    public static void main(String[] args) {
        char boggle[][] = {{'G', 'I', 'Z'},
                {'U', 'E', 'K'},
                {'Q', 'S', 'E'}};

        String dictionary[] = {"GEEKS", "FOR", "QUIZ", "QSE"};

        Boggle boggle1 = new Boggle(dictionary, boggle);


    }
}
