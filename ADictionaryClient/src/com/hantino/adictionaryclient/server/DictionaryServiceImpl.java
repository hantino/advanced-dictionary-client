package com.hantino.adictionaryclient.server;

import java.util.ArrayList;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.hantino.adictionaryclient.client.Dictionary;
import com.hantino.adictionaryclient.client.DictionaryService;
import com.hantino.adictionaryclient.client.HostPort;

public class DictionaryServiceImpl extends RemoteServiceServlet implements DictionaryService {

	public ArrayList<Dictionary> getDictionaries(HostPort hostport) {
		// TODO Auto-generated method stub
		return null;
	}

}
