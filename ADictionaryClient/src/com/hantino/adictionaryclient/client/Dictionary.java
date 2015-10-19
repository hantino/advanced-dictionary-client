package com.hantino.adictionaryclient.client;

import java.io.Serializable;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.vaadin.polymer.elemental.Event;
import com.vaadin.polymer.elemental.EventListener;
import com.vaadin.polymer.paper.element.PaperButtonElement;

@SuppressWarnings("serial")
public class Dictionary implements Serializable {

	private DivElement element;

	private static DictionaryUiBinder uiBinder = GWT
			.create(DictionaryUiBinder.class);

	@UiField Element dictionaryTitle;
	@UiField PaperButtonElement defineWordButton;

	private String dictionaryDbTitle;

	interface DictionaryUiBinder extends UiBinder<DivElement, Dictionary> {
	}

	public Dictionary() {
		element = uiBinder.createAndBindUi(this);
		
		defineWordButton.addEventListener("click", new EventListener() {
            @Override
            public void handleEvent(Event event) {
                // TODO
            }
        });
	}

	public String getDictionaryTitle() {
		return dictionaryTitle.getInnerText();
	}

	public void setDictionaryTitle(String s) {
		dictionaryTitle.setInnerText(s);
	}

	public void setDictionaryDbTitle(String s){
		this.dictionaryDbTitle = s;
	}
	
	public String getDictionaryDbTitle(){
		return this.dictionaryDbTitle;
	}
	public DivElement getElement() {
		return element;
	}

}
