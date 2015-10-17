package com.hantino.adictionaryclient.client;

import java.io.Serializable;

@SuppressWarnings("serial")
public class HostPort implements Serializable {
	
	private String host;
	private String port;
	
	public HostPort(){}
	
	public HostPort(String host, String port){
		this.host = host;
		this.port = port;
	}
	
	public String getHost() {
	    return this.host;
	  }
	  
	  public String getPort() {
	    return this.port;
	  }
	  
	  public void setHost(String host) {
		   this.host = host;
		  }
		  
		  public void setPort(String port) {
		    this.port = port;
		    
		  }
}
