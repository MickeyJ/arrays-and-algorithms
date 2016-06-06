
public class ArrayStructures {

  private int[] theArray = new int[50];
  private int arraySize = 10;

  public static void main(String[] args){
    ArrayStructures newArray  = new ArrayStructures();

    newArray.generateRandomArray();
    newArray.printArray();

    newArray.bubbleSort();
    newArray.printArray();

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
        }

      }

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

    System.out.println("---------------");
    for(int i = 0; i < arraySize; i++){

      System.out.print( "| idx: "+ i +" | " );
      System.out.println( theArray[i] +" | " );
      System.out.println("---------------");
    }

    System.out.println();

  }

}
