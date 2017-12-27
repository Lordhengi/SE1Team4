package ParkhausAutoSoftware;

import com.thoughtworks.xstream.XStream;

public class Test {
	
	Parkhaus p;
	public void save() {
		XStream xstream = new XStream();
		
		for(int i = 0; i < p.getTicketautomaten().size(); i++) {
			String test = xstream.toXML(p.getTicketautomaten().get(i));
		}
	}
	

}
