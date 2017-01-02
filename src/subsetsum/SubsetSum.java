/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subsetsum;

/**
 *
 * @author KONSTANTIN
 * Exhaustive search - recursive
 * Goes through all possible subsets and returns true/false
 * 
 */
public class SubsetSum {

    static boolean isSubset(int S[], int n, int t) {
        //check if the target is 0 and if yes return true
        if (t == 0)
            return true;
        //if the number of elements if the list is 0 and target is not 0
        //return false
        if (n == 0 && t != 0)
            return false;
        
        //optional check if the last element of the list is greater than the target
        //if yes -> ignore it
        if (S[n-1] > t)
            return isSubset(S, n-1, t);
        
        //go through the list and check if target can be met
        //first without the last item and than with the last item
        //return isSubset(S, n-1, t) || isSubset(S, n-1, t-S[n-1]);
        return isSubset(S, n-1, t-S[n-1]) || isSubset(S, n-1, t);       
    }
    
    
    public static void main(String[] args) {
        int S[] = {7,2,14,18,123,23,53,21,54,12,64,213,53453,12};
        int t = 2123;
        int n = S.length;
        if(isSubset(S, n, t) == true)
            System.out.println("True!");
        else
            System.out.println("False!");
    }
    
}
