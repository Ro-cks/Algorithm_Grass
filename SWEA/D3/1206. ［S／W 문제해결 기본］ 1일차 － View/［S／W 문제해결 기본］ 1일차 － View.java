import java.util.*;
import java.io.*;

class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int test_case = 0;
		
		while (test_case++ < 10) {
			int answer = 0;
			int buildingCount = Integer.parseInt(br.readLine());
			ArrayList<Integer> buildingsFloors = new ArrayList<>();
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < buildingCount; ++i) {
				buildingsFloors.add(Integer.parseInt(st.nextToken()));
			}
			
			int leftTop = 0;
			int rightTop = 0;
			int current = 0;
			for (int i = 2; i < buildingCount - 2; ++i) {
				current = buildingsFloors.get(i);
				
				leftTop = buildingsFloors.get(i - 1) > buildingsFloors.get(i - 2)
						? buildingsFloors.get(i - 1) : buildingsFloors.get(i - 2);
				rightTop = buildingsFloors.get(i + 1) > buildingsFloors.get(i + 2)
						? buildingsFloors.get(i + 1) : buildingsFloors.get(i + 2);
				
				if (current > leftTop && current > rightTop) {
					answer += leftTop > rightTop ? current - leftTop : current - rightTop;
				}
			}
			
			bw.write("#" + test_case + " " + answer + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
