package com.hantino.adictionaryclient.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.vaadin.polymer.Polymer;
import com.vaadin.polymer.elemental.Function;
import com.vaadin.polymer.iron.element.IronIconElement;
import com.vaadin.polymer.paper.element.PaperButtonElement;
import com.vaadin.polymer.paper.element.PaperDialogElement;
import com.vaadin.polymer.paper.element.PaperDrawerPanelElement;
import com.vaadin.polymer.paper.element.PaperFabElement;
import com.vaadin.polymer.paper.element.PaperHeaderPanelElement;
import com.vaadin.polymer.paper.element.PaperIconItemElement;
import com.vaadin.polymer.paper.element.PaperInputElement;
import com.vaadin.polymer.paper.element.PaperRippleElement;
import com.vaadin.polymer.paper.element.PaperToolbarElement;

import java.util.Arrays;


public class ADictionaryClient implements EntryPoint {
	
  public void onModuleLoad() {
    // Loading icon sets before running application
	Polymer.importHref(Arrays.asList(
			"iron-icons/iron-icons.html",
			PaperIconItemElement.SRC,
			IronIconElement.SRC,
			PaperRippleElement.SRC,
			PaperDrawerPanelElement.SRC,
			PaperHeaderPanelElement.SRC,
			PaperToolbarElement.SRC,
			PaperFabElement.SRC,
			PaperDialogElement.SRC,
			PaperInputElement.SRC,
			PaperButtonElement.SRC), new Function(){
		public Object call(Object arg){
			startApplication();
			return null;
		}
		
	}); 
  }
  
  private void startApplication(){
	  RootPanel.get().add(new Main());
  }
  
}