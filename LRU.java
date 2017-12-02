package algorithmOS;

import java.util.*;

class LRU
{
            Scanner num=new Scanner(System.in);
            int[] frame,page,present;
            int size,pages,pageframe=0,flag1=0,flag2=0;
            
            LRU(int size,int pages)
            {
                this.size=size;
                this.pages=pages;
                frame=new int[size];
                present=new int[size];
                page=new int[pages];
            }
            
            void get()
            {
            	for(int i=0;i < size;i++) 
            	{
                    frame[i]=-1;
                }
            	for(int i=0;i < pages;i++)
            	{
            		page[i]=(int)(Math.random()*10)+1;
            		System.out.println("난수 생성 : "+page[i]);
            	}
            }
                  
            int check(int x)
            {
            	flag1=-1;
                for(int i=0;i < size;i++)
                if(frame[i]==x)
                {
                	flag1=i;
                    break;
                }
                return flag1;            
            }
            int replace(int x)
            {
                int i;
                for(i=0;i < size;i++)
                    present[i]=0;
                    flag2=0;
                    for(i=x-1;i >= 0;i--)
                    {
                        if(check(page[i]) >= 0)
                        {
                        	flag2++;
                            present[check(page[i])]=1;
                        }
                        if(flag2==(size-1)) break;
                    }
                    for(i=0;i < size;i++)
                        if(present[i]==0)
                        {
                        	flag2=i;
                            break;
                        }
                        return i;
            }
            void lru()
            {
            	for(int i=0;i < pages;i++)
                {
                    if(i < size)
                    {
                        frame[i]=page[i];
                    	pageframe++;
                    for(int j=0;j < size;j++)
                                System.out.print(frame[j]+"    ");
                    System.out.println();
                }
                    else
                    {
                    	if(check(page[i])==-1)
                    	{
                            int r=replace(i);
                            frame[r]=page[i];
                            pageframe++;
                            for(int j=0;j < size;j++)
                                System.out.print(frame[j]+"    ");
                                System.out.println();
                        }
                    else
                    {
                        for(int j=0;j < size;j++)
                            System.out.print(frame[j]+"    ");
                        System.out.println();
                    }
                    }
                }
            	System.out.println("참조 실패 횟수 : "+pageframe);
            }
            public static void main(String arg[])
            {
            	Scanner example=new Scanner(System.in);
            	System.out.print("프레임 크기 :");
            	int n=example.nextInt();
            	System.out.print("참조 문자열 개수 :");
				int p=example.nextInt();
				LRU obj=new LRU(n,p);
				obj.get();
				obj.lru();
			}
}
