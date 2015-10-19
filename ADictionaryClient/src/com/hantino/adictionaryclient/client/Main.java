package com.hantino.adictionaryclient.client;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
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
	@UiField PaperIconItemElement listDictionaries;
	@UiField PaperIconItemElement menuSettings;
	@UiField PaperIconItemElement menuAbout;

	private static HostPort hp;
	private DictionaryServiceAsync dictionarySvc = GWT.create(DictionaryService.class);
	
	// Our data base is just an array of Dictionaries in memory
    private List<Dictionary> dictionaries = new ArrayList<>();

	public Main() {
		initWidget(ourUiBinder.createAndBindUi(this));

		connectButton.addEventListener("click", new EventListener() {
			@Override
			public void handleEvent(Event event) {
				connectHostDialog.open();
			}
		});

		confirmConnectButton.addEventListener("click", new EventListener() {
			@Override
			public void handleEvent(Event event) {
				if (!hostInput.getValue().isEmpty() && !portInput.getValue().isEmpty()) {
					hp = new HostPort(hostInput.getValue(), portInput.getValue());
					//addHostPort(hostInput.getValue(), portInput.getValue());
					// clear text fields
					hostInput.setValue("");
					portInput.setValue("");
					refreshDictionaryList();
				}				
			}
		});
		
		listDictionaries.addEventListener("click", new EventListener() {
			@Override
			public void handleEvent(Event event) {
				if (dictionaries.size() > 0) {
					for (Dictionary d: dictionaries) {
						content.appendChild(d.getElement());
					}				
				}
			}
		});
		
		menuAbout.addEventListener("click", new EventListener() {
			@Override
			public void handleEvent(Event event) {
				while (content.hasChildNodes()) {
                    content.removeChild(content.getFirstChild());
                }
			}
		});
	}

	private void refreshDictionaryList(){
		// Initiliaze the service proxy.
		if(dictionarySvc == null){
			dictionarySvc = GWT.create(DictionaryService.class);
		}

		// Set up the callback object
		AsyncCallback<ArrayList<String>> callback = new AsyncCallback<ArrayList<String>>(){

			@Override
			public void onFailure(Throwable caught) {
			}

			@Override
			public void onSuccess(ArrayList<String> result) {
				addDictionaryList(result);
			}
		};
		dictionarySvc.getDictionaries(hp, callback);
	}
	
	private void addDictionaryList(ArrayList<String> result) {
        //content.appendChild(result.size());
		for (String s: result){
			Dictionary d = new Dictionary();
			d.setDictionaryTitle(s);
            content.appendChild(d.getElement());
            dictionaries.add(d);
        }
    }
}
