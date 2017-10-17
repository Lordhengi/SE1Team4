package Aufgabe_02;

public class Zeit {
	  float time;

	  public Zeit(float time) {
	    this.time = time;
	  }

	  public int stunden(){
	    return (int) this.time;
	  }

	  public int minuten(){
	    return (int) ((this.time - stunden()) * 100);
	  }

	  void add(Zeit other){
	    this.time += other.time;
	  }

	  @Override
	  public String toString(){
	    return String.format("%02d:%02d", stunden(), minuten());
	  }

	  @Override
	  public boolean equals(Object other){
	    if (other.getClass() != Zeit.class) return false;
	    return this.time == ((Zeit)other).time;
	  }

	}
