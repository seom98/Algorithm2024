import java.util.*;interface Main{static void main(String[]z){Scanner s=new Scanner(System.in);int N=s.nextInt(),S=s.nextInt()-1,E=s.nextInt()-1,M=s.nextInt(),i,j,C=-1,n[],v[]=new int[N];ArrayList<ArrayList<Integer>>l=new ArrayList<>();Queue<int[]>q=new LinkedList<>();q.add(new int[]{S,0});v[S]=1;while(N-->0)l.add(new ArrayList<>());while(M-->0){i=s.nextInt()-1;j=s.nextInt()-1;l.get(i).add(j);l.get(j).add(i);}w:while(!q.isEmpty()){n=q.poll();for(int f:l.get(n[0])){if(f==E){C=n[1]+1;break w;}if(v[f]==0){v[f]=1;q.add(new int[]{f,n[1]+1});}}}System.out.print(C);}}