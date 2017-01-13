import java.io.*;
import java.util.*;
public class NQueenFinal {
	public static int a[],b[],c[],d[],e[],f[];
	public static int [] fitnessValue;
	public static long crossover,mutation;
	public static int waitformutation = 0;
	public static boolean o = true;
	public static int minx = Integer.MAX_VALUE,miny = Integer.MAX_VALUE;
	public static int size;
	
	public static void Merge(int i,int j){
		
		
		int [] saveindex1 = new int[size];
		int [] saveindex2 = new int[size];
		int [] parent = new int[size];
		int [] child = new int[size];
		Arrays.fill(parent,-1);
		Arrays.fill(child,-1);
		
		for(int s = 0;s<i;s++){
			c[s] = a[s];
			saveindex1[c[s]] = s;
			
			d[s] = b[s];
			saveindex2[d[s]] = s;
		}
		
		
		boolean [] mark = new boolean[size];
		for(int s = i;s<=j;s++){
			c[s] = b[s];
			d[s] = a[s];
			parent[c[s]] = d[s];
			child[d[s]] = c[s];
			mark[d[s]] = true;
			mark[c[s]] = false;
		}
		
		
		
		for(int s = j+1;s<size;s++){
			c[s] = a[s];
			saveindex1[c[s]] = s;
			
			d[s] = b[s];
			saveindex2[d[s]] = s;
		}
		
		
		
		for(int s = 0;s<size;s++){
			if(mark[s] && parent[s] == -1){
				int value = s;
				int u = 0;
				int v = s;
				
				while(child[value] != -1){
					value = child[value];
				}
				
				u = value;
				int z = c[saveindex1[u]];
				c[saveindex1[u]] = d[saveindex2[v]];
				d[saveindex2[v]] = z;
				
			}
			
		}
		
	}
	
	

	
	
	static class Pair{
		int index;
		int value;
		public Pair(int index,int value){
			this.index = index;
			this.value = value;
		}
	}
	
	public static void Merging(int[] c,int [] d,int [] a,int [] b,int i,int j){
		
		
		int [] saveindex1 = new int[size];
		int [] saveindex2 = new int[size];
		int [] parent = new int[size];
		int [] child = new int[size];
		Arrays.fill(parent,-1);
		Arrays.fill(child,-1);
		
		for(int s = 0;s<i;s++){
			c[s] = a[s];
			saveindex1[c[s]] = s;
			
			d[s] = b[s];
			saveindex2[d[s]] = s;
		}
		
		
		boolean [] mark = new boolean[size];
		for(int s = i;s<=j;s++){
			c[s] = b[s];
			d[s] = a[s];
			parent[c[s]] = d[s];
			child[d[s]] = c[s];
			mark[d[s]] = true;
			mark[c[s]] = false;
		}
		
		
		
		for(int s = j+1;s<size;s++){
			c[s] = a[s];
			saveindex1[c[s]] = s;
			
			d[s] = b[s];
			saveindex2[d[s]] = s;
		}
		
		
		
		for(int s = 0;s<size;s++){
			if(mark[s] && parent[s] == -1){
				int value = s;
				int u = 0;
				int v = s;
				
				while(child[value] != -1){
					value = child[value];
				}
				
				u = value;
				int z = c[saveindex1[u]];
				c[saveindex1[u]] = d[saveindex2[v]];
				d[saveindex2[v]] = z;
				
			}
			
		}

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static int[] Merg2(int [] aa,int [] bb,int i1,int j1,int i2,int j2){
		
		int [] newArray = new int[aa.length];
		int d = 0;
		boolean [] save = new boolean[501];
		for(int c = i1;c<=j1;c++){
			newArray[d++] = bb[c];
			save[bb[c]] = true;
		}
		
		//for(int value: newArray)System.out.println(value);
		
		//System.out.println();
		
		for(int c = i2;c<=j2;c++){
			if(save[aa[c]] == false){
				newArray[d++] = aa[c];
				save[aa[c]] = true;
			}
			else{
				int i = i1;
				for(i = i1;i<=j1;i++){
					if(save[aa[i]] == false){
						newArray[d++] = aa[i];
						save[aa[i]] = true;
						break;
					}
				}
			}
		}
		
		//customize(newArray);
		//for(int value: newArray)System.out.println(value);
		//System.out.println();
		
		return newArray;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void mutation(int [] minA,int [] minB){
		
		int rid1 = random(0,minA.length-1);
		int rid2 = random(0,minA.length-1);
		while(rid1 == rid2){
			rid2 = random(0,minA.length-1);
		}
		
		int z = minA[rid1];
		minA[rid1] = minA[rid2];
		minA[rid2] = z;
		
		
		rid1 = random(0,minB.length-1);
		rid2 = random(0,minB.length-1);
		while(rid1 == rid2){
			rid2 = random(0,minB.length-1);
		}
		
		z = minB[rid1];
		minB[rid1] = minB[rid2];
		minB[rid2] = z;
		
		fitnessValue[0] = fitness(minA);
		fitnessValue[1] = fitness(minB);


	}
	
	

	
	public static int random(int l,int h){
		return l+(int)(Math.random()*(h+1-l));
	}
	

	
	public static void sixtofour(){
		PriorityQueue<Save> q = new PriorityQueue<Save>();
		q.add(new Save(0,a,fitnessValue[0]));
		q.add(new Save(1,b,fitnessValue[1]));
		q.add(new Save(2,c,fitnessValue[2]));
		q.add(new Save(3,d,fitnessValue[3]));
		q.add(new Save(4,e,fitness(e)));
		q.add(new Save(5,f,fitness(f)));
		
		for(int i = 0;i<4;i++){
			Save s = q.poll();
			if(i == 0){
				a = s.ar;
				fitnessValue[i] = s.fitness;
			}
			else if(i == 1){
				b = s.ar;
				fitnessValue[i] = s.fitness;
			}
			else if(i == 2){
				c = s.ar;
				fitnessValue[i] = s.fitness;
			}
			else if(i == 3){
				d = s.ar;
				fitnessValue[i] = s.fitness;
			}
		}
	}
	
	

	
	
	
	
	
	public static void genetics(){
		
		boolean ok = true;
		int [] minA = new int[size];
		int [] minB = new int[size];
		while(true){
			
			//System.out.println("asd");
			//crossover(); //a,b,c,d er 4 ta array theke minimum 2 ta theke corssover korbo..
			
			if(ok){
				
				minA = a;
				minB = b;
				
			}
			
		
			int i = 0;
			int j = minA.length-1;
			int r1 = random(i,j);
			int r2 = random(i,j);
			while(r1 == r2){
				r2 = random(i,j);
			}
			
			e = new int[size];
			f = new int[size];
			
			Merging(e,f,minA,minB,Math.min(r1,r2),Math.max(r1,r2));
			
			crossover++;
			
			
			/*System.out.println();
			for(int value : e) System.out.println(value);
			System.out.println();
			System.out.println();
			for(int value : f) System.out.println(value);*/
			
			

			int fa = fitness(e);
			int fb = fitness(f);
			
			//System.out.println(fa+" "+fb);
			
			if(fa == 0){
				System.out.println("DONE");
				for(int value : e) System.out.println(value);
				break;
			}
			else if(fb == 0){
				System.out.println("Done");
				for(int value : f) System.out.println(value);
				break;
			}
			else if(fa<minx || fa<miny || fb<minx || fb<miny){
				waitformutation = 0;
				int [] y = {fa,fb,minx,miny};
				Arrays.sort(y);
				minx = y[0];
				miny = y[1];
				ok = true;
			}
			else{
				waitformutation++;
				ok = false;
			}
			
			if(waitformutation>1){
				mutation++;
				waitformutation = 0;
				mutation(minA,minB); // tader fitness o change hobea...
				int [] y = {fitness(a),fitness(b),fitness(c),fitness(d)};
				Arrays.sort(y);
				minx = y[0];
				miny = y[1];
				if(minx == 0 || miny == 0){
					if(fitness(minA) == 0){
						System.out.println("DONE");
						for(int value : minA) System.out.println(value);
						break;
					}
					else{
						System.out.println("DONE");
						for(int value : minB) System.out.println(value);
						break;
					}
				}
				
				ok = true;
			}

			if(ok)sixtofour();
		}
	}
	
	
	
	public static int fitness(int [] a){
		int result = 0;
		/*boolean [] see = new boolean[501];
		for(int c = 0;c<a.length;c++){
			if(see[a[c]] == false){
				see[a[c]] = true;
			}
			else{
				result++;
			}
		}
		*/
		//diagonal cheque
		for(int c = 0;c<a.length;c++){
			for(int d = c+1;d<a.length;d++){
				if(Math.abs(c-d) == Math.abs(a[c]-a[d])){
					result++;
				}
			}
		}
		
		
		return result;
		
	}
	
	
	public static void main(String [] args){
		read();

		int r1 = random(0,a.length-1);
		int r2 = random(0,a.length-1);
		while(r1 == r2){
			r2 = random(0,a.length-1);
		}
		
		//r1 = 3;
		//r2 = 5;
		
		
		c = new int[size];
		d = new int[size];
		
		Merge(Math.min(r1,r2),Math.max(r1,r2));
		
		
		/*for(int value : c) System.out.println(value);
		System.out.println();
		System.out.println();
		for(int value : d) System.out.println(value);*/
			
		
		
		makefour();
		genetics();
		
		System.out.println("No: of crossover "+(crossover));
		System.out.println("No: of mutation "+(mutation));
		System.out.println("No: of iteration "+(crossover+mutation));
		
	}
	
	
	static void makefour(){
		PriorityQueue<Save> q = new PriorityQueue<Save>();
		q.add(new Save(0,a,fitness(a)));
		q.add(new Save(1,b,fitness(b)));
		q.add(new Save(2,c,fitness(c)));
		q.add(new Save(3,d,fitness(d)));
		
		fitnessValue = new int[4];
		
		for(int i = 0;i<4;i++){
			Save s = q.poll();
			if(i == 0){
				a = s.ar;
				minx = fitnessValue[i] = s.fitness;
			}
			else if(i == 1){
				b = s.ar;
				miny = fitnessValue[i] = s.fitness;
			}
			else if(i == 2){
				c = s.ar;
				fitnessValue[i] = s.fitness;
			}
			else if(i == 3){
				d = s.ar;
				fitnessValue[i] = s.fitness;
			}
		}
	}
	
	

	
	static void read(){
		size = 12;
		crossover = 0;
		mutation = 0;
		a = new int[size];
		b = new int[size];
		waitformutation = 0;
		
		
		
		a[0] = 9;
		a[1] = 7;
		a[2] = 1;
		a[3] = 2;
		a[4] = 0;
		a[5] = 11;
		a[6] = 8;
		a[7] = 3;
		a[8] = 5;
		a[9] = 10;
		a[10] = 6;
		a[11] = 4;

		b[0] = 4;
		b[1] = 6;
		b[2] = 11;
		b[3] = 7;
		b[4] = 1;
		b[5] = 10;
		b[6] = 5;
		b[7] = 3;
		b[8] = 2;
		b[9] = 9;
		b[10] = 8;
		b[11] = 0;
		
		
	}
	
	
	static class Save implements Comparable{
		int index;
		int [] ar;
		int fitness;
		public Save(int index,int [] ar,int fitness){
			this.index = index;
			this.ar = ar;
			this.fitness = fitness;
		}
		@Override
		public int compareTo(Object o) {
			// TODO Auto-generated method stub
			return this.fitness - ((Save)o).fitness;
		}
	}
	
	
	
	
}