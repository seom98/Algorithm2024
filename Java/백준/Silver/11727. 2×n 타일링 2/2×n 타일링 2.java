interface Main{static void main(String[]z){int N=new java.util.Scanner(System.in).nextInt(),d[]=new int[N+3],i=2;d[1]=1;d[2]=3;while(i++<N)d[i]=(d[i-1]+d[i-2]*2)%10007;System.out.print(d[N]);}}