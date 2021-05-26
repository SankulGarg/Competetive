package com.github.sankulgarg.hackerrank;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CostBouqet {


    /*
     * Complete the 'flowerBouquets' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER p
     *  2. INTEGER q
     *  3. STRING s
     */
    public static int findCostBouqet(int p,int q, List<Integer> curr, int [] garden, int currentIndex, int price){
        if(currentIndex>=garden.length)
          return price;
        int bouqetPrice=0;
        if(curr.size()==2 && curr.get(0)==0 && curr.get(1)==0 && garden[currentIndex]==0)
          bouqetPrice=p;
        
        if(curr.size()>=1 && q>p && (curr.get(curr.size()-1)^garden[currentIndex])==1)
             bouqetPrice=q;
    
        curr.add(garden[currentIndex]);
        if(bouqetPrice>0){
        price=price+bouqetPrice;
        curr=new ArrayList<>();
        }
      
       int cost1= findCostBouqet(p, q, curr, garden, currentIndex+1, price);
        int cost2=findCostBouqet(p, q, new ArrayList<>(), garden, currentIndex+2, price);
        
        if (cost1>cost2)
        return cost1;
        else return cost2;
        
    }

    /*
     * 2
     * 3
     * 0001000
     * 
     * 5
     */

    public static int flowerBouquets(int p, int q, String s) {
    
    int garden[] =new int[s.length()];
    
    for(int i=0;i<s.length();i++){
        garden[i]=Integer.parseInt(""+s.charAt(i));
    }
    
    
    return findCostBouqet(p, q, new ArrayList<>(), garden, 0, 0);
    
    

    }


    public static void main(String[] args) throws IOException {
       
      Scanner sc=new Scanner(System.in);

        int p = sc.nextInt();

        int q = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();

        int result = flowerBouquets(p, q, s);
        System.out.println(result);

    }
}
