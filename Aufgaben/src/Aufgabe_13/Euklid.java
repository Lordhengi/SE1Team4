package Aufgabe_13;

public class Euklid {
	public int ggT(int a, int b) {
		if(a == 0)
			return b;
		else
			while(b != 0)
			{
				if(a > b)
					a = a-b;
				else
					b = b-a;
			}
		return a;
	}
	
}
