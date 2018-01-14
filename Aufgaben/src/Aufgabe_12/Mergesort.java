package Aufgabe_12;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class Mergesort extends TicketSort{
	public static void sort(List<Ticket> tickets, Comparator<Ticket> c)
	{
		sortMerge(tickets, c);
	}
	
	
	private static <T extends E, E> void sortMerge(List<T> f, Comparator<E> c) {
	    sortMerge(f,c, 0, f.size());
	}

	private static <T extends E, E> void sortMerge(List<T> f, Comparator<E> c, int l, int r) {
		if (r - l <= 1) {
			return;
		}
		int m = (l + r) / 2;

		sortMerge(f, c, l, m);
		sortMerge(f, c, m, r);

		List<T> tmp = new ArrayList<T>(r - l);
		int i = 0;
		int jl = l;
		int jr = m;

		while (jl < m && jr < r) {
			if (c.compare(f.get(jl), f.get(jr)) <= 0) {
				tmp.set(i++, f.get(jl++));
			} else {
				tmp.set(i++, f.get(jr++));
			}
		}

		while (jl < m) {
			tmp.set(i++, f.get(jl++));
		}
		while (jr < r) {
			tmp.set(i++, f.get(jr++));
		}

		for (int k = 0; k < tmp.size(); ++k) {
			f.set(l+k, tmp.get(k));
		}
	}

}


