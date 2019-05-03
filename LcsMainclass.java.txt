import java.util.Scanner; 

public class LcsMainclass
{ 

 public static void main (String[] args)  
    { 

     Scanner scanner = new Scanner(System. in); 
     System.out.println("Input first String:");
     String A = scanner. nextLine();
     System.out.println("Input second String:");
     String B = scanner. nextLine();
      
        int m = A.length(); 
        int n = B.length(); 
        lcs(A, B, m, n); 
    } 
 
    static void lcs(String A, String B, int m, int n) 
    { 
        int[][] L = new int[m+1][n+1];   
        for (int i=0; i<=m; i++) 
        { 
            for (int j=0; j<=n; j++) 
            { 
                if (i == 0 || j == 0) 
                    L[i][j] = 0; 
                else if (A.charAt(i-1) == B.charAt(j-1)) 
                    L[i][j] = L[i-1][j-1] + 1; 
                else
                    L[i][j] = Math.max(L[i-1][j], L[i][j-1]); 
            } 
        } 
    
        int index = L[m][n]; 
		int i = m, j = n; 
        int temp = index;  
        char[] lcs = new char[index+1]; 
        lcs[index] = ' '; // Setting the terminating character 
        
        while (i > 0 && j > 0) 
        { 
            
            if (A.charAt(i-1) == B.charAt(j-1)) 
            {  
                lcs[index-1] = A.charAt(i-1);  
                i--;  
                j--;  
                index--;      
            } 
   
            else if (L[i-1][j] > L[i][j-1]) 
                i--; 
            else
                j--; 
        } 
        System.out.print("LCS of "+A+" and "+B+" is "); 
        for(int k=0;k<=temp;k++) 
            System.out.print(lcs[k]); 
    } 
      
} 