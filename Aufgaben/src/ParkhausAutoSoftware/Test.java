package ParkhausAutoSoftware;

public class Test {
	
	Parkhaus p;
	
	
	public void save() {
		XStream xstream = new XStream();
		
		for(int i = 0; i < p.getticketautomaten().size(); i++) {
			String test = xstream.toXML(p.getticketautomaten().get(i));
		}
	}
}
