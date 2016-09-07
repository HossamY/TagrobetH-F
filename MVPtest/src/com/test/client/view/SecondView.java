package com.test.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasDirectionalText;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;
import com.test.client.presenter.SecondViewPresenter;

public class SecondView extends Composite implements com.test.client.presenter.SecondViewPresenter.Display{

	private static SecondViewUiBinder uiBinder = GWT.create(SecondViewUiBinder.class);

	interface SecondViewUiBinder extends UiBinder<Widget, SecondView> {
	}

	public SecondView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField
	Button button;
	private SecondViewPresenter presenter;

	public SecondView(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
		button.setText(firstName);
	}
	
	

	public void setPresenter(SecondViewPresenter presenter) {
		this.presenter = presenter;
	}



	@UiHandler("button")
	void onClick(ClickEvent e) {
		Window.alert("Hello!");
	}

	public void setText(String text) {
		button.setText(text);
	}

	public String getText() {
		return button.getText();
	}

	@Override
	public HasClickHandlers getButton() {
		// TODO Auto-generated method stub
		return button;
	}

}
