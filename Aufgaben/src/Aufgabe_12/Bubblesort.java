package Aufgabe_12;

import java.util.Comparator;
import java.util.List;

public class Bubblesort extends TicketSort{
	
	public static void sort(List<Ticket> tickets, Comparator<Ticket> c)
	{
		sortBubble(tickets, c);
	}
	
	private static <T extends E, E> void sortBubble(List<T> f, Comparator<E> c) {
		int p = f.size() - 1;
		while (p > 0) {
			int r = p;
			p = 0;
			for (int i = 0; i < r; ++i) {
				if (c.compare(f.get(i), f.get(i + 1)) > 0) {
					swap(f, i, i + 1);
					p = i;
				}
			}
		}
	}
	
	private static <T> void swap(List<T> f, int e1, int e2)
	{
		T t1 = f.get(e1);
		T t2 = f.get(e2);
		f.set(e1,t2);
		f.set(e2,t1);
	}

}
