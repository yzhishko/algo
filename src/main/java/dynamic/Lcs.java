class Main {
  public static void main(String[] args) {
    int[][] x = new int[2][3];
    x[0][0] = 1;
    //x[1][0] = 2;
    
    x[0][1] = 3;
    //x[1][1] = 4;
    
    x[0][2] = 5;
    //x[1][2] = 6;
    
    int[] arr1 = new int[]{1,2,3,2,7,9};
    int[] arr2 = new int[]{9,2,3,2,7,88,10, 9};
    LongestCommonSubsesuence lcs = new LongestCommonSubsesuence(arr1, arr2);
    lcs.print();
    System.out.println("\n" + lcs.lcs());
  }
}

class LongestCommonSubsesuence {
  int[] arr1; 
  int[] arr2;
  int[][] result;
  
  LongestCommonSubsesuence(int[] arr1, int[] arr2){
    this.arr1 = arr1;
    this.arr2 = arr2;
    result = init();
  }
  
  int[][] init(){
    int[][] result = new int[arr1.length][arr2.length];
    
    for(int i=0; i < arr1.length; i++ ){
      for(int j =0; j<arr2.length; j++){
        if(arr1[i] == arr2[j]){
          if(i == 0 || j == 0){
            result[i][j] = 1;
          } else {
            result[i][i] = result[i-1][i-1] + 1;
          }
        }
      }
    }
    
    return result;
  }
  
  int lcs(){
    int[][] result = new int[arr1.length][arr2.length];
    
    int max = 0;
    
    for(int i=0; i < arr1.length; i++ ){
      for(int j =0; j<arr2.length; j++){
        if(arr1[i] == arr2[j]){
          if(i == 0 || j == 0){
            result[i][j] = 1;
          } else {
            result[i][i] = result[i-1][i-1] + 1;
            max = Math.max(max, result[i][i]);
          }
        }
      }
    }
    
    return max;
  }
  
  public void print() {
    for(int[] row: result){
      System.out.println("");
      for(int col: row){
        System.out.print(col + " ");
      }
    }
  }
}
