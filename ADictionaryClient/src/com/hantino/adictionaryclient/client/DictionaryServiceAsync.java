package com.hantino.adictionaryclient.client;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface DictionaryServiceAsync {
	void getDictionaries(HostPort hostport, AsyncCallback<ArrayList<String>> callback);
}
