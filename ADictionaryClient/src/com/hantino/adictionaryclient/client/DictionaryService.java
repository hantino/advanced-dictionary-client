package com.hantino.adictionaryclient.client;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("dictionaries")
public interface DictionaryService extends RemoteService {
	
	ArrayList<String> getDictionaries(HostPort hostport);
}
