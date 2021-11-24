package rahul.faq;

//praveen badminton question

public class StudentsViva {

	public static void main(String[] args) {

		int[] rollNo = { 3, 6, 2, 7, 5, 4 };
		//3 2 5 4 - 6, 7
		//3 2 4 - 5
		//3 2   - 4
		
		int days = 0;
        int[] index = new int[rollNo.length];
        
		while (true) {
         
		 int size = 0;
         boolean noViva = true;
         for(int i=1 ; i<rollNo.length ; i++) {
        	 boolean viva = true;
        	 for(int j=i-1 ; j>=0 ; j--) {        		  
        		 if(rollNo[j] > rollNo[i]) {
        			 viva = false;
        			 break;
        		 }
        	 }
        	 if(viva) {
        		 index[size++] = i;
        		 noViva = false;
        	 }
         }
 		
         for(int i = 0 ; i<size ; i++) 
          rollNo[index[i]] = -1;
         
         if(noViva)
        	 break;
         
         days++;
		}

//		for(int i : rollNo)if(i != -1)System.out.print(i+" ");
//		System.out.println();
		System.out.println(days+" viva completed");
	}
}
