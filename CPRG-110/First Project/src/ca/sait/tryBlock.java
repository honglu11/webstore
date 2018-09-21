package ca.sait;

public class tryBlock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        try{
    	    int a[]=new int[5];
    	    a[5]=30000000/0;
    	   }    	   
    	   //catch(ArithmeticException e){System.out.println("task1 is completed");}
    	   catch(ArrayIndexOutOfBoundsException e){System.out.println("task 2 completed");}
           catch(Exception e){System.out.println("common task completed");}
           finally {
        	   System.out.println("finally ....");
           }
    	   
    	   System.out.println("rest of the code...");

	}

}
