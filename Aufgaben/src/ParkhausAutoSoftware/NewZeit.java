package ParkhausAutoSoftware;


import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class NewZeit {
	private LocalDateTime time = null;

	public NewZeit(LocalDateTime time)
	{
		this.time = time;
	}
	
	public NewZeit(int hours, int min) {
		time = LocalDateTime.of(2018,1,1,0,0);
		add(hours, min);
	}

	public int stunden() {
		return this.time.getHour();
	}

	public int minuten() {
		return this.time.getMinute();
	}

	public void add(NewZeit other) {
		LocalDateTime newTimeMin = time.plusMinutes(other.minuten());
		LocalDateTime newTimeHoures = newTimeMin.plusHours(other.stunden());
		time = newTimeHoures;
	}
	
	public static NewZeit aktuelleZeit() {
		NewZeit z = new NewZeit(LocalDateTime.now());
		return z;
	}
	
	public static int differenzinMinuten(NewZeit z1, NewZeit z2) {
		return java.lang.Math.toIntExact(ChronoUnit.MINUTES.between(z1.time,z2.time));
	}
	
	public static int differenzinSekunden(NewZeit z1, NewZeit z2) {
		return java.lang.Math.toIntExact(ChronoUnit.SECONDS.between(z1.time,z2.time));
	}
	
	public static int differenzinTagen(NewZeit z1, NewZeit z2) {
		return java.lang.Math.toIntExact(ChronoUnit.DAYS.between(z1.time,z2.time));
	}

	public void add(int hours, int min) {
		LocalDateTime newTimeMin = time.plusMinutes(min);
		LocalDateTime newTimeHoures = newTimeMin.plusHours(hours);
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
