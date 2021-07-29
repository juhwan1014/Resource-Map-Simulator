package practise_2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	static class node {
		int startAddress;
		int endAddress;
		
public node(int a, int b) {
	this.startAddress = a;
	this.endAddress = b;
}

	}
	
	public static void main(String[] args) {
		
		ArrayList<node> al = new ArrayList<>(); 
		ArrayList<node> free = new ArrayList<>();
		
               al = new ArrayList<>();
               free = new ArrayList<>();
               int enter_mem;
               
               System.out.println("The whole memory : <0,0x100000>");
               
               free.add(new node(0,0x100000));
               
               
              StringBuilder buffer = new StringBuilder();
              System.out.println("Please enter the number of lines : ");
              Scanner scan = new Scanner (System.in);
              String number = scan.nextLine();
              int num = Integer.parseInt(number);
              
              for (int i = 0; i < num; i++) {
            	  
            	  Scanner input = new Scanner (System.in);
            	  String value = input.nextLine();
            	
            	  if(value.charAt(0) == '+') {
            		  buffer.append(value);
            		  buffer.deleteCharAt(2);
            		  buffer.deleteCharAt(1);
            		  buffer.deleteCharAt(0);
            		 
            		  enter_mem = Integer.parseInt(buffer.toString(),16);
            		  
            		  int fspace [] = new int [free.size()];
        			  int difference [] = new int [free.size()];
            		  for(int j = 0; j < free.size(); j++) {
            			 
            			fspace[j] = free.get(j).endAddress - free.get(j).startAddress;
            			difference[j] = fspace[j] - enter_mem;
            					
            		  }
       
            			 int min=1048576, m=0;
         	            for(int p=0;p < free.size();p++){
         	                if(difference[p] < min && difference[p] >= 0){
         	                    min = difference[p];
         	                    m = p;
         	                }
         	            }
            		  
         	          al.add(new node (free.get(m).startAddress , free.get(m).startAddress + enter_mem));  
         	          
         	          if(difference[m]==0) {
         	        	free.remove(m);  
         	          }else {
         	         free.add(m, new node (free.get(m).startAddress + enter_mem +1 , free.get(m).endAddress));
         	         free.remove(m+1);
         	          }
         	          
         	          
         	         for(int j=0; j < free.size()-1; j++) {
             			
                 		if(free.get(j).endAddress+1 == free.get(j+1).startAddress ) {
                 			
                 			free.add(j, new node (free.get(j).startAddress , free.get(j+1).endAddress));  
                        	  
                 	         free.remove(j+1);
                 	         free.remove(j+1);
                 			j--;
                 		}
                 		}
         	         
         	       
         	          
         	          
         	        System.out.println("Free space : ");
         	         for(int q=0; q < free.size(); q++) {
         	        	String hex1 = Integer.toHexString(free.get(q).startAddress);
         	        	String hex2 = Integer.toHexString(free.get(q).endAddress);
         	        	
         	        	
         	        	

            		  System.out.println("<"+"0x"+hex1.toUpperCase()+","+"0x"+hex2.toUpperCase()+">");
         	         }
         	         
         	        System.out.println("allocated space : ");
        	         for(int q=0; q < al.size(); q++) {
        	        	 String hex3 = Integer.toHexString(al.get(q).startAddress);
          	        	String hex4 = Integer.toHexString(al.get(q).endAddress);
          	        	
           		  System.out.println("<"+"0x"+hex3.toUpperCase()+","+"0x"+hex4.toUpperCase()+">");
        	         }
            		 
            		  buffer.setLength(0);
            	  }
            	  
            	  
            	  
            	  else if(value.charAt(0) == '-') {
            		  buffer.append(value);
            		  buffer.deleteCharAt(0);
            		  int rmv_num = Integer.parseInt(buffer.toString());
            		  Integer k = null;
            		  for(int q=0; k == null; q++) {
            		  if(al.get(rmv_num-1).endAddress < free.get(q).endAddress)
            			  k=q;
            		  
            		  }
            		  
            		  free.add(k, al.get(rmv_num-1));
            		al.remove(rmv_num-1);
            		
            		
            		for(int j=0; j < free.size()-1; j++) {
            			
            		if(free.get(j).endAddress+1 == free.get(j+1).startAddress ) {
            			
            			free.add(j, new node (free.get(j).startAddress , free.get(j+1).endAddress));  
                   	  
            	         free.remove(j+1);
            	         free.remove(j+1);
            			j--;
            		}
            		
            		}
            		
            	    System.out.println("Free space : ");
        	         for(int q=0; q < free.size(); q++) {
        	        	String hex1 = Integer.toHexString(free.get(q).startAddress);
        	        	String hex2 = Integer.toHexString(free.get(q).endAddress);
        	        	
        	        	
        	        	

           		  System.out.println("<"+"0x"+hex1.toUpperCase()+","+"0x"+hex2.toUpperCase()+">");
        	         }
        	         
        	        System.out.println("allocated space : ");
       	         for(int q=0; q < al.size(); q++) {
       	        	 String hex3 = Integer.toHexString(al.get(q).startAddress);
         	        	String hex4 = Integer.toHexString(al.get(q).endAddress);
         	        	
          		  System.out.println("<"+"0x"+hex3.toUpperCase()+","+"0x"+hex4.toUpperCase()+">");
       	         }
            		
            		 buffer.setLength(0);
            	  }
            
            	  }
            	  
            	  }
        
	}

	
