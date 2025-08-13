package LearnJava;
/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Example:
Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6 
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        int water = 0, leftmax, rightmax;
        if(height.length==0 || height.length==1){
        	return 0;
        }
        for(int i=1; i<height.length-1; i++){
        	leftmax=height[0]; 
    		rightmax=height[i+1];
    		for(int k=0; k<i; k++){
    			if(leftmax<height[k]){
    				leftmax=height[k];
    			}
    		}
    		for(int k=i+1; k<height.length; k++){
    			if(rightmax<height[k]){
    				rightmax=height[k];
    			}
    		}
    		if(Math.min(leftmax, rightmax)>height[i]){
    			water = water + Math.min(leftmax, rightmax)-height[i];
    		}
        }
        return water;
    }
    
    public static void main(String[] args){
    	TrappingRainWater obj = new TrappingRainWater();
    	int[] height={0,1,0,2,1,0,1,3,2,1,2,1};
    	System.out.println("Water: "+obj.trap(height));
    }
}
