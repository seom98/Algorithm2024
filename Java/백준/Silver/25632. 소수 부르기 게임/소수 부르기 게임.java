import java.util.*;
interface Main{
    static int b[]={0,1,2,3},p[]=new int[1001];
    static void main(String[]z){
        Scanner c=new Scanner(System.in);
        p[1]=0;p[2]=1;for(int x:b)b[x]=c.nextInt();
        for(int n=3;n<1001;n++)p[n]=p[n-1]+P(n);
        System.out.print(b[1]<b[2]?(G(0,1)>G(2,3)?"yt":"yj"):G(0,1)>G(2,3)?"yt":G(0,1)<G(2,3)?"yj":Math.min(G(2,1),G(0,3))%2<1?"yj":"yt");
    }
    static int P(int n){for(int i=2;i<=Math.sqrt(n);i++){if(n%i<1)return 0;}return 1;}
    static int G(int x,int y){return p[b[y]]-p[b[x]-1];}
}