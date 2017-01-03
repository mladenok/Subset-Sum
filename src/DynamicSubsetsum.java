/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KONSTANTIN
 * Dynamic Programming Subset-Sum Algorithm
 * Complexity Big O Notation: O(n*t)
 */
public class DynamicSubsetsum {
    static boolean isSubset(int S[], int n, int t) {
        boolean sub[][] = new boolean[n + 1][t + 1];
        
        for(int i = 0; i <= n; i++) {
            sub[i][0] = true;
        }
        for(int i = 1; i <= t; i++) {
            sub[0][i] = false;
        }
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= t; j++) {
                if (j - S[i - 1] >= 0) {
                    sub[i][j] = sub[i-1][j] || sub[i-1][j-S[i-1]]; }
                else {
                    sub[i][j] = sub[i-1][j];
                }
            }
        }
        
        return sub[n][t];
    }
    
    public static void main (String args[]) {
        int S[] = {2,3,5,7,12,2,45};
        int t = 10;
        int n = S.length;
        
        if(isSubset(S, n, t) == true)
            System.out.println("Found");
        else
            System.out.println("Not Found");
    }
}
