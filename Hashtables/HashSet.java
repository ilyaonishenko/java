import java.lang.Math;
public class HashSet{
	int[] head;
	int[] next;
	int[] keys;
	int headNum;
	int cnt = 1;
	public void HashSet(int headNum,int maxSize){
		this.headNum = headNum;
		head = new int[headNum];
		next = new int[maxSize+1];
		keys = new int[maxSize+1];
	}
	boolean add (int x){
		if (this.contains(x))
			return false;
		int h = index(hash(x));
		next[cnt] = head[h];
		keys[cnt] = h;
		head[h]=cnt++;
		return true;
	}
	boolean contains(int x){
		int h = index(hash(x));
		for(int i=head[h];i!=0;i=next[i])
			if(keys[i]==x)
				return true;
		return false;
	}
	int hash(int x){
		return (x>>15)^x;
	}
	int index(int x){
		return Math.abs(hash)%headNum;
	}
}
