package com.github.sankulgarg.hackerrank;

import java.util.Arrays;
import java.util.Scanner;

public class SamAndHorses {

  public static void main(String args[] ) throws Exception {
      /* Enter your code here. Read input from STDIN. Print output to STDOUT */
  
  Scanner sc=new Scanner(System.in);
  int n=sc.nextInt();
  int arr[][]=new int[n][n];
  
  for(int i=0;i<n;i++){
      for(int j=0;j<n;j++){
          arr[i][j]=sc.nextInt();
      }
  }
 System.out.println(Arrays.deepToString(arr));
  }
  
 
}
