
class Main {

  public static int max( int [] array) {
    int largest = 0;

    for(int i = 0; i < 3; i++){
      if(largest < array[i] ){
        largest = array[i];
      }
    }
    return largest;
  } 

  public static void main(String[] args){
    int [] someArray = {7, 2, 4};

    System.out.println(max(someArray));

    // System.out.println("hello world");
  }
}