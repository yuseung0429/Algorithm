import java.io.*;
import java.util.*;

class Main {
	
	static ArrayList<Integer> maxHeap = new ArrayList<Integer>();
	
	public static int poll() {
		if(maxHeap.size() <= 1) {
			return 0;
		}
		
		int result = maxHeap.get(1);
		maxHeap.set(1, maxHeap.get(maxHeap.size()-1));
		maxHeap.remove(maxHeap.size()-1);
		
		if(maxHeap.size() == 1) {
			return result;
		}
		
		int currentIdx = 1;
		int currentValue = maxHeap.get(currentIdx);
		
		while(true) {
			if(currentIdx > maxHeap.size()-1) {
				return result;
			}
			
			int leftChildIdx = currentIdx*2;
			int rightChildIdx = currentIdx*2+1;
            
			if (leftChildIdx > maxHeap.size()-1) {
				return result;
			}
			
			int targetIdx = 0;
			if (leftChildIdx == maxHeap.size()-1) {
				targetIdx = leftChildIdx;
			} else {
				if (maxHeap.get(leftChildIdx) >= maxHeap.get(rightChildIdx)) {
					targetIdx = leftChildIdx;
				} else {
					targetIdx = rightChildIdx;
				}
			}
			
			int targetValue = maxHeap.get(targetIdx);
			if (targetValue <= currentValue) {
				return result;
			}
			
			maxHeap.set(targetIdx, currentValue);
			maxHeap.set(currentIdx, targetValue);
			
			currentIdx = targetIdx;
		}
	}
	
	public static void add(int value) {
		maxHeap.add(value);
		
		int currentIdx = maxHeap.size()-1;
		int currentValue = value;
		
		while (true) {
			int parentIdx = currentIdx/2;
			if (parentIdx == 0) {
				return;
			}
			
			int parentValue = maxHeap.get(parentIdx);
			if(parentValue >= currentValue) {
				return;
			}
			
			maxHeap.set(parentIdx, currentValue);
			maxHeap.set(currentIdx, parentValue);
			currentIdx /= 2;
		}
	}
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		maxHeap.add(0);
			
 		for (int i=0; i<n; i++) {
			int value = Integer.parseInt(br.readLine());
			if (value == 0) {
				sb.append(poll()).append("\n");
			} else {
				add(value);
			}
		}
		
		System.out.println(sb.toString());
	}
}