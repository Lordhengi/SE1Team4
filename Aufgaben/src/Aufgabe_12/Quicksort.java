package Aufgabe_12;

import java.util.Comparator;
import java.util.List;


public class Quicksort extends TicketSort{

	public Quicksort(List<Ticket> tickets, Comparator<Ticket> c)
	{
		PivotPicker<Ticket> p = new PivotPickerMedian<Ticket>(c);
		sortQuick(tickets, c, p);
	}
	
	public static <T> void sortQuick(List<T> f, Comparator<? super T> c, PivotPicker<T> p) {
		sortQuick(f, c, p, 0, f.size() - 1);
	}

	private static <T> void sortQuick(List<T> f, Comparator<? super T> c, PivotPicker<T> p, int l, int r) {
		if (l >= r) {
			return;
		}
		int piv = p.pivot(f, l, r);
		swap(f,piv, r);
		int il = l;
		int ir = r - 1;

		do {
			while (il <= ir && c.compare(f.get(il), f.get(r)) < 0) {
				++il;
			}
			while (il < ir && c.compare(f.get(ir), f.get(r)) >= 0) {
				--ir;
			}
			if (il < ir) {
				swap(f, il++, ir);
			}
		} while (il <= --ir);
		piv = il;
		swap(f, piv, r);
		sortQuick(f, c, p, l, piv - 1);
		sortQuick(f, c, p, piv + 1, r);
	}
	
	private static <T> void swap(List<T> f, int e1, int e2)
	{
		T t1 = f.get(e1);
		T t2 = f.get(e2);
		f.set(e1,t2);
		f.set(e2,t1);
	}
}
