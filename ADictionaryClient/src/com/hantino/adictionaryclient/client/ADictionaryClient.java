package com.hantino.adictionaryclient.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.vaadin.polymer.paper.widget.PaperButton;


public class ADictionaryClient implements EntryPoint {
  public void onModuleLoad() {
    // Use Widget API to Create a <paper-button>
    PaperButton button = new PaperButton("Just a starter!");
    button.setRaised(true);
    RootPanel.get().add(button);
  }
}