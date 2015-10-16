package com.hantino.adictionaryclient.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.vaadin.polymer.elemental.Event;
import com.vaadin.polymer.elemental.EventListener;
import com.vaadin.polymer.elemental.HTMLElement;
import com.vaadin.polymer.paper.element.*;

public class Main extends Composite {
  interface MainUiBinder extends UiBinder<HTMLPanel, Main> {
  }

  private static MainUiBinder ourUiBinder = GWT.create(MainUiBinder.class);
  
  @UiField PaperDrawerPanelElement drawerPanel;
  @UiField HTMLElement content;

  @UiField PaperFabElement connectButton;
  @UiField PaperDialogElement connectHostDialog;
  @UiField PaperInputElement hostInput;
  @UiField PaperTextareaElement portInput;
  @UiField PaperButtonElement confirmConnectButton;

  public Main() {
    initWidget(ourUiBinder.createAndBindUi(this));
    
    connectButton.addEventListener("click", new EventListener() {
        @Override
        public void handleEvent(Event event) {
            connectHostDialog.open();
        }
      });
  }
}
