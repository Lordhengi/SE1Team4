package ParkhausAutoSoftware;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class NewZeit {
	private LocalTime time = null;

	public NewZeit(LocalTime time)
	{
		this.time = time;
	}
	
	public NewZeit(int hours, int min) {
		time = LocalTime.of(0, 0);
		add(hours, min);
	}

	public int stunden() {
		return this.time.getHour();
	}

	public int minuten() {
		return this.time.getMinute();
	}

	public void add(NewZeit other) {
		LocalTime newTimeMin = time.plusMinutes(other.minuten());
		LocalTime newTimeHoures = newTimeMin.plusHours(other.stunden());
		time = newTimeHoures;
	}
	
	public static NewZeit aktuelleZeit()
	{
		NewZeit z = new NewZeit(LocalTime.now());
		return z;
	}
	
	public static int differenzinMinuten(NewZeit z1, NewZeit z2)
	{
		long f = ChronoUnit.MINUTES.between(z1.time,z2.time);
		int i = java.lang.Math.toIntExact(ChronoUnit.MINUTES.between(z1.time,z2.time));
		return java.lang.Math.toIntExact(ChronoUnit.MINUTES.between(z1.time,z2.time));
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
		if (other.getClass() != NewZeit.class)
			return false;
		return this.time.equals(((NewZeit) other).time);
	}
}
