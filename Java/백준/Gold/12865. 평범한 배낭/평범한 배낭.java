import java.util.*;
interface Main{
	static void main(String[]z){
		Scanner c=new Scanner(System.in);
		int N=c.nextInt(),M=c.nextInt(),d[]=new int[M+1];
		while(N-->0)for(int i=M,W=c.nextInt(),C=c.nextInt();i>=W;i--)d[i]=Math.max(d[i],d[i-W]+C);
		System.out.print(d[M]);
	}
}