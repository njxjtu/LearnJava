package LearnJava;
public class MergeSort {

	void sort(int[] arr, int low, int high){
		if(low < high) {
			int m = (low+high)/2;
			for(int i=low; i<=high; i++){
				System.out.print(arr[i]);
			}
			System.out.println(" with middle: "+m);
			sort(arr, low, m);
			sort(arr, m+1, high);
			merge(arr, low, m, high);
		}
		
	}
	
	void merge(int[] arr, int low, int m, int high){

				int n1=(m-low)+1;
				int n2= high-m;
				int[] arr1 = new int[n1];
				int[] arr2 = new int[n2];
				
				/*Copy data to temp arrays*/
		        for (int i=0; i<n1; ++i) 
		            arr1[i] = arr[low+i]; 
		        for (int j=0; j<n2; ++j) 
		            arr2[j] = arr[m+1+j]; 
				
		        int i=0, j=0, k=low;
				while(i<n1 && j<n2){
					if(arr1[i]<=arr2[j]){
						arr[k] = arr1[i];
						System.out.println("putting arr1[i] "+arr1[i]+" i is: "+i+" into arr[k] "+arr[k]+" k is: "+k);
						i++;
						k++;
						
					}
					else{
						arr[k] = arr2[j];
						System.out.println("putting arr2[j] "+arr2[j]+" j is: "+j+" into arr[k] "+arr[k]+" k is: "+k);
						j++;
						k++;
						
					}
				}

				while(i<n1){
					arr[k] = arr1[i];
					i++;k++;
				}
				while(j<n2){
					arr[k] = arr2[j];
					j++;k++;
				}
				
	}
	
	public static void main(String[] args){
		// 5,4,2,1,3  ==> 1,2,3,4,5
		// 3,2,1
		int[] test_arr = new int[]{5,4,2,1,3};
		MergeSort obj = new MergeSort();
		obj.sort(test_arr, 0, test_arr.length-1);
		for(int i=0; i<test_arr.length; i++){
			System.out.println(test_arr[i]);
		}
	}
}
