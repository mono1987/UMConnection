package local.um.initial;

import com.pcbsys.nirvana.client.nChannel;
import com.pcbsys.nirvana.client.nChannelAttributes;
import com.pcbsys.nirvana.client.nConsumeEvent;
import com.pcbsys.nirvana.client.nEventListener;
import com.pcbsys.nirvana.client.nSession;
import com.pcbsys.nirvana.client.nSessionAttributes;
import com.pcbsys.nirvana.client.nSessionFactory;

public class MySub implements nEventListener {
	
	public MySub() throws Exception{
		nSession mySession = null;
		String RNAME="nsp://137.117.196.229:9000";
		nSessionAttributes nsa=new nSessionAttributes(RNAME);
		
		mySession=nSessionFactory.create(nsa);
		mySession.init();
		
		nChannelAttributes cattrib=new nChannelAttributes();
		cattrib.setName("StoreOrderReference");
		nChannel myChannel=mySession.findChannel(cattrib);
		System.out.println("cc");
		myChannel.addSubscriber(this,0);
		
	}
	
	

	public static void main(String[] args) {
		
		try {
			new MySub();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void go(nConsumeEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Consumed event "+arg0.getEventID());
		byte[] byteArr=arg0.getEventData();
		System.out.println(new String(byteArr));
	}

}
