package local.um.initial;

import com.pcbsys.nirvana.client.nChannel;
import com.pcbsys.nirvana.client.nChannelAttributes;
import com.pcbsys.nirvana.client.nChannelNotFoundException;
import com.pcbsys.nirvana.client.nConsumeEvent;
import com.pcbsys.nirvana.client.nEventProperties;
import com.pcbsys.nirvana.client.nIllegalArgumentException;
import com.pcbsys.nirvana.client.nIllegalChannelMode;
import com.pcbsys.nirvana.client.nMaxBufferSizeExceededException;
import com.pcbsys.nirvana.client.nRealmUnreachableException;
import com.pcbsys.nirvana.client.nRequestTimedOutException;
import com.pcbsys.nirvana.client.nSecurityException;
import com.pcbsys.nirvana.client.nSession;
import com.pcbsys.nirvana.client.nSessionAlreadyInitialisedException;
import com.pcbsys.nirvana.client.nSessionAttributes;
import com.pcbsys.nirvana.client.nSessionFactory;
import com.pcbsys.nirvana.client.nSessionNotConnectedException;
import com.pcbsys.nirvana.client.nSessionPausedException;
import com.pcbsys.nirvana.client.nUnexpectedResponseException;
import com.pcbsys.nirvana.client.nUnknownRemoteRealmException;

public class UMConnection {

	public static void main(String[] args) {
		nSession mySession = null;
		try {
			String RNAME="nsp://127.0.0.1:9000";
			nSessionAttributes nsa=new nSessionAttributes(RNAME);
			
			mySession=nSessionFactory.create(nsa);
			mySession.init();
			
			nChannelAttributes cattrib=new nChannelAttributes();
			cattrib.setName("Topic1");
			nChannel myChannel=mySession.findChannel(cattrib);
			
			nEventProperties props = new nEventProperties();
			props.put("bondname", "bond1");
			props.put("price", 100.00);
			nConsumeEvent evt = new nConsumeEvent( "atag", "hello juno".getBytes() );
			myChannel.publish(evt);
					
		} catch (nIllegalArgumentException e) {
			e.printStackTrace();
		} catch (nRealmUnreachableException e) {
			e.printStackTrace();
		} catch (nSecurityException e) {
			e.printStackTrace();
		} catch (nSessionNotConnectedException e) {
			e.printStackTrace();
		} catch (nSessionAlreadyInitialisedException e) {
			e.printStackTrace();
		} catch (nChannelNotFoundException e) {
			e.printStackTrace();
		} catch (nSessionPausedException e) {
			e.printStackTrace();
		} catch (nUnknownRemoteRealmException e) {
			e.printStackTrace();
		} catch (nUnexpectedResponseException e) {
			e.printStackTrace();
		} catch (nRequestTimedOutException e) {
			e.printStackTrace();
		} catch (nIllegalChannelMode e) {
			e.printStackTrace();
		} catch (nMaxBufferSizeExceededException e) {
			e.printStackTrace();
		}finally {
			if(mySession!=null)
			mySession.close();
		}
	}

}
