public class Algorithms {

   public static int max( int [] array) {
    int largest = 0;

    for(int i = 0; i < 3; i++){
      if(largest < array[i] ){
        largest = array[i];
      }
    }
    return largest;
  } 
  
}
