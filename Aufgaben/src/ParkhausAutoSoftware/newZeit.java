package ParkhausAutoSoftware;

import java.time.LocalTime;

public class newZeit {
	private LocalTime time = null;

	public newZeit(LocalTime time)
	{
		this.time = time;
	}
	
	public newZeit(int hours, int min) {
		time = LocalTime.of(0, 0);
		add(hours, min);
	}

	public int stunden() {
		return this.time.getHour();
	}

	public int minuten() {
		return this.time.getMinute();
	}

	public void add(newZeit other) {
		LocalTime newTimeMin = time.plusMinutes(other.minuten());
		LocalTime newTimeHoures = newTimeMin.plusHours(other.stunden());
		time = newTimeHoures;
	}
	
	public static newZeit aktuelleZeit()
	{
		newZeit z = new newZeit(LocalTime.now());
		return z;
	}
	

	public void add(int hours, int min) {
		LocalTime newTimeMin = time.plusMinutes(min);
		LocalTime newTimeHoures = newTimeMin.plusHours(hours);
		time = newTimeHoures;
	}

	@Override
	public String toString() {
		return String.format("%02d:%02d", stunden(), minuten());
	}

	@Override
	public boolean equals(Object other) {
		if (other.getClass() != newZeit.class)
			return false;
		return this.time.equals(((newZeit) other).time);
	}
}
