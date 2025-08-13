package LearnJava;
public class HeapSort {

	void sort(int[] arr){
		//build heap tree
		for(int i=arr.length/2-1;i>=0;i--){
			heapify(arr, arr.length, i);
		}
		//fetch max
		for(int i=arr.length-1; i>=0; i--){
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			heapify(arr, i, 0);
		}
	}
	
	void heapify(int[] arr, int n, int curr){
		if((curr*2+1)<n && arr[curr]<arr[curr*2+1] ){
			int temp = arr[curr];
			arr[curr] = arr[curr*2+1];
			arr[curr*2+1] = temp;
			heapify(arr, n, curr*2+1);
		}
		if((curr*2+2)<n &&arr[curr]<arr[curr*2+2]  ){
			int temp = arr[curr];
			arr[curr] = arr[curr*2+2];
			arr[curr*2+2] = temp;
			heapify(arr, n, curr*2+2);
		}
	}
	
	public static void main(String[] args){
/*		     8,3,2,7,9,1,4
 * 
		          8 (0)
		     3 (1)       2 (2)
	 7 (3)  9 (4)    1 (5)    4 (6)
*/
		int[] test_arr = new int[]{8,3,2,7,9,1,4};
		HeapSort obj = new HeapSort();
		obj.sort(test_arr);
		for(int i=0; i<test_arr.length; i++){
			System.out.println(test_arr[i]);
		}
	}
}
