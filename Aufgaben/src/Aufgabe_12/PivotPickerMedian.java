package Aufgabe_12;


/*
 * @author hdoerr2s
 */
import java.util.Comparator;
import java.util.List;

public class PivotPickerMedian<T> implements PivotPicker<T>{
	
	private Comparator<? super T> c;
	
	public PivotPickerMedian(Comparator<? super T> c) {
		this.c = c;
	}

	@Override
	public int pivot(List<T> f, int l, int r) {
		if(r - l <= 1) {
            return r;
        }
        final int m = (l + r + 1) / 2;
        int m2 = m, l2 = l, r2 = r;
        if(c.compare(f.get(l2), f.get(r2)) > 0)
        {
        	int t = l2;
        	l2 = r2;
        	r2 = t;
        }
        if(c.compare(f.get(l2), f.get(m2)) > 0)
        {
        	int t = l2;
        	l2 = m2;
        	m2 = t;
        }
        if(c.compare(f.get(m2), f.get(r2)) > 0)
        {
        	int t = m2;
        	m2 = r2;
        	r2 = t;
        }
        return m2;
	}

}
