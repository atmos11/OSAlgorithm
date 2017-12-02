package algorithmOS;

import java.util.*;

class PageReplacementFIFO{
	Scanner num = new Scanner(System.in);
	int frameSize, no_of_pages, element, replace = 0, pageHits = 0, pageMiss = 0;
	int frames[];
	
	void getData(){
		System.out.println("페이지 프레임 크기 입력");
		frameSize = num.nextInt();
		System.out.println("페이지 개수 입력");
		no_of_pages = num.nextInt();
		frames = new int[frameSize];

		for(int i = 0; i < frameSize; i++)
			frames[i] = -1;

		for(int i = 0; i < no_of_pages; i++)
		{
			element = (int)(Math.random()*5)+1;
			System.out.println("새로운 난수 생성 : "+element);
			find(element);
		}
		show();
	}
	
	void find(int element){
		int i;

		for(i = 0; i < frameSize; i++)

			if(frames[i] == element)
			{
				pageHits ++;
				break;
			}

		if(i==3){
			pageMiss++;
			frames[replace++] = element;

			if(replace == frameSize)
				replace = 0;
		}
		System.out.print("프레임 내 원소 : ");
		for(i=0; i < frameSize; i++)
			System.out.print(frames[i] + "\t");
		System.out.println();
	}
	void show(){
		float hitRatio, missRatio;
		hitRatio = (pageHits / (float)no_of_pages) * 100;
		missRatio = (pageMiss / (float)no_of_pages) * 100;

		System.out.println("일치 횟수 = "+pageHits);
		System.out.println("불일치 횟수 = "+pageMiss);
		System.out.println("일치 비율 = "+hitRatio);
		System.out.println("불일치 비율 = "+missRatio);
	}
	public static void main(String[] args){
		PageReplacementFIFO ob = new PageReplacementFIFO();
		ob.getData();	
	}
}