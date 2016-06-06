
public class ArrayStructures {

  private int[] theArray = new int[50];
  private int arraySize = 10;

  public static void main(String[] args){
    ArrayStructures newArray  = new ArrayStructures();

    newArray.generateRandomArray();


    System.out.println("\n---------------------- Iteration 1 -----------------------");
    newArray.printArray();
    newArray.insertionSort();

  }

  public void generateRandomArray(){

    for(int i = 0; i < arraySize; i++){
      theArray[i] = (int)(Math.random()*10)+10;
    }

  }

  public void bubbleSort(){

    for (int i = arraySize - 1; i > 1; i--){

      for (int j = 0; j < i; j++){

        if(theArray[j] > theArray[j + 1]){
          swapValues(j, j + 1);
          printArray();
        }

      }

    }

  }

  public void selectionSort(){

    for(int x = 0; x < arraySize; x++){

      int min = x;

      for(int y = x; y < arraySize; y++){

        System.out.println("min: "+ theArray[min] +", y: "+ theArray[y]);

        if(theArray[min] > theArray[y]){
          min = y;
          printArray();
        }

      }
      swapValues(x, min);

    }

  }

  public void insertionSort(){

    for(int i = 1; i < arraySize; i++){

      int j = i;
      int toInsert = theArray[i];

      while((j > 0) && (theArray[j - 1] > toInsert)){
        theArray[j] = theArray[j - 1];
        j--;
      }

      if(i == j){
        System.out.println(
          " | Index: "+ i +
          "\n | ————————-"+
          "\n | Value: "+ toInsert
        );
      } else {
        System.out.println(
          "Sorted: "+
          "\n————————-————————————————"+
          "\n  Index: | "+ i +"  | => | "+ j +"  | "+
          "\n  -----------------------"+
          "\n  Value: | "+ toInsert + " | => | "+ theArray[j + 1] +" | " +
          "\n————————-————————————————"
        );
      }
      System.out.println("\n---------------------- Iteration "+ (i + 1) +" ----------------------");

      theArray[j] = toInsert;

      printArray();

    }

  }

  public void swapValues(int idxOne, int idxTwo){

    int temp = theArray[idxOne];
    theArray[idxOne] = theArray[idxTwo];
    theArray[idxTwo] = temp;

  }

  public int getValueAtIndex(int index){

    if(index < arraySize) return theArray[index];
    return 0;

  }

  public boolean doesArrayContain(int searchValue){

    boolean valueInArray = false;

    for(int i = 0; i < arraySize; i++){

      if(theArray[i] == searchValue){
        valueInArray = true;
      }

    }

    return valueInArray;

  }

  public void deleteAtIndex(int index){

    if(index < arraySize){
      System.arraycopy(theArray, index + 1, theArray, index, arraySize - 1 - index);
      arraySize--;
    }

  }

  public void insertValue(int value){

    if(arraySize < 50){
      theArray[arraySize] = value;
      arraySize++;
    }

  }

  public void binarySearchForValue(int value){

    int lowIndex = 0;
    int highIndex = arraySize - 1;

    while(lowIndex <= highIndex){

      int middleIndex = (highIndex + lowIndex) / 2;

      System.out.println(lowIndex +", "+ middleIndex  +", "+ highIndex);

      if(theArray[middleIndex] < value) lowIndex = middleIndex + 1;

      else if(theArray[middleIndex] > value) highIndex = middleIndex - 1;

      else{
        System.out.println("Found match for "+ value +" at index: "+ middleIndex);
        lowIndex = highIndex + 1;
      }

    }

  }

  public String linearSearchForValue(int value){

    boolean valueInArray = false;
    String indicesWithValue = "";

    System.out.print( "Value "+ value +" was found in: " );

    for(int i = 0; i < arraySize; i++){
      if(theArray[i] == value){
        valueInArray = true;
        indicesWithValue += i +" ";
        System.out.print( indicesWithValue );
      }
    }
    if(!valueInArray){
      indicesWithValue = "None";
      System.out.print(indicesWithValue);
    }

    System.out.println();
    return indicesWithValue;

  }

  public void printArray(){

    String indexLine = "";
    String valueLine = "";

    for(int i = 0; i < arraySize; i++){
      indexLine += "| "+ i +"  ";
      valueLine += "| "+ theArray[i] +" ";
    }

    System.out.println("==========================================================");
    System.out.println("Index: "+ indexLine +"|");
    System.out.println("----------------------------------------------------------");
    System.out.println("Value: "+ valueLine +"|");
    System.out.println("——————————————————————————————————————————————————————————");

  }

}
