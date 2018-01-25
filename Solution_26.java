public class Solution_26 {
	  
	public static void main(String[] args){
		
		int[] nums = {1,2,3};
		int r = removeElement2(nums, 1);
		
		System.out.println(r);
		for(int n : nums){
			System.out.print(" " + n);
		}
		System.out.println();
	}
	
	
	public static int removeElement(int[] nums, int val) {
	    int i = 0;
	    for (int j = 0; j < nums.length; j++) {
	        if (nums[j] != val) {
	            nums[i] = nums[j];
	            i++;
	        }
	    }
	    return i;
	}
	
	public static int removeElement2(int[] nums, int val) {
	    int i = 0;
	    int n = nums.length;
	    while (i < n) {
	        if (nums[i] == val) {
	            nums[i] = nums[n - 1];
	            // reduce array size by one
	            n--;
	        } else {
	            i++;
	        }
	    }
	    return n;
	}
	
    public int removeDuplicates(int[] nums) {
        
        int i = 0;
        int l = nums.length;
        for(int j=0; j<(l-1) ; j++){
          
            if(nums[j]!=nums[j+1]){
                
                i++;
                nums[i] = nums[j+1];
            }
        }
        
        return i+1;
    }
	
	// solution 80
	public int removeDuplicates(int[] nums) {
        
        int c = 0;
        
        int l = nums.length;
        int j=1;
        
        for(int i=1; i<l; i++){
                        
            if(nums[i-1]!=nums[i]){
                nums[j] = nums[i];    
                j++;
                c=0;
            }
            else if(nums[i-1]==nums[i]){
                c++;
                if(c<2){
                    nums[j] = nums[i];    
                    j++;
                }
            }
        }
        return j;
            
    }
	
	
}
