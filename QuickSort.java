public class QuickSort {

	int partition(int[] arr, int low, int high){

		int pivot = arr[high];
		
		int i= low-1;
		for (int j=low; j<high; j++){
			if (arr[j]<= pivot){
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		
		int tem = arr[i+1];
		arr[i+1] = pivot;
		arr[high] = tem;
		
		return i+1;
	}
	
	void sort(int[] arr, int low, int high){
		if(low >= high) return;
		int pp = partition(arr, low, high);
		sort(arr, low, pp-1);
		sort(arr, pp+1, high);
	}
	
	public static void main(String[] args){
		// 5, 3, 2, 4, 1   ==> 1,2,3,4,5
		int[] test_arr = new int[]{5,3,2,4,1};
		QuickSort obj = new QuickSort();
		obj.sort(test_arr, 0, test_arr.length-1);
		for(int i=0; i<test_arr.length; i++){
			System.out.println(test_arr[i]);
		}
	}
}
