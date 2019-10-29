import java.util.Arrays;
public class Test0519{
	public static int max(int [] array){
		//int maxArray = 0;
		int maxValue = Integer.MIN_VALUE;
		//for(int i=0;i<array.length;i++){
		//if(array[i]>array[i+1]){
			//return	maxArray = array[i];
		//}
		for(int item:array){
			if(item > maxValue){
			maxValue=item;
			}
		}
		return maxValue;
	}
	public static int indexOf(int[] array,int key){
		for(int i=0;i<array.length;i++){
			if(array[i]==key){
				return 1;
			}
		}
		return -1;
		
	}
	public static double averge(int [] scores){
		int minValue = scores[0];
		int maxValue = scores[0];
		int sum = 0;
		for(int i=1;i<scores.length;i++){
			if(scores[i]<minValue){
			minValue=scores[i];
		}
		if(scores[i]>maxValue){
			maxValue=scores[i];
		}
		sum+=scores[i];
	}
	return (double)(sum - minValue - maxValue)/(scores.length - 2);
}
	public static int[] copyOf(int[] src,int newLength){
	 int[]dest = new int[newLength];
	 int minLength = src.length<newLength?src.length:newLength;
	 for(int i=0;i<minLength;i++){
		 dest[i]=src[i];
	}
	return dest;
}
public static int binarySearch(int[]array,int key){
	int left=0;
	int right=array.length-1;
	//[left,right)区间内还有数---left<right
	//[left,right]区间内还有数
		while(left<=right){
			//int mid=(left+right)/2;
		int mid=left+(right-left)/2;//防止越界
		if(key==array[mid]){
		return mid;
		}
		else if(key<array[mid]){
			right = mid-1;
		}else{
			left = mid+1;
		}
	}
	return -1;
}
//交换array数组 i和j下标位置的数
public static void swap(int[]array,int i,int j){
	int t=array[i];
	array[i]=array[j];
	array[j]=t;
}
public static void bubbleSort(int[] array){
	//减治算法
	for(int i=0;i<array.length;i++){
		//需要经过 array.length次冒泡
		//所谓的冒泡过程
		//在无序区间内，经过两两比较，把最大的数冒泡至最后
		boolean isSwapped = false;
		//无序：[0,array.length-i]
		//有序：[array.length-i,array.length]
		//进行冒泡过程，遍历整个无序区间
		for(int j=0;j<array.length-i-1;j++ ){
			//冒泡的过程中保证大的数在后边
			if(array[j]>array[j+1]){
				swap(array,j,j+1);
				isSwapped = true;
			}
		}
		//如果一次完整的冒泡过程中，一次交换都没有发生
		//表明数组已经有序，所以排序完成
		if(!isSwapped){
		break;
		}
	}
}
				
			
			
			
	public static void main(String[] args){
		int[] array=new int[]{1,2,3,4,5,6,7};
		int maxValue = max(array);
		System.out.println("最大值是 "+maxValue);
		
		int index = indexOf(array,3);
		System.out.println("3的下标是 "+index);
		
		double avergeScore = averge(array);
		System.out.printf("平均分是 %.4f%n",avergeScore);
		
		System.out.println(Arrays.toString(copyOf(array,3)));
		System.out.println(Arrays.toString(copyOf(array,10)));
		
		int index2 = binarySearch(array,7);
		System.out.printf("7所在的下标是%d%n",index2);
		int[] randomArray = new int[]{9,5,2,7,4,8,6,3};
		bubbleSort(randomArray);
	    System.out.println(Arrays.toString(randomArray));
	}
}