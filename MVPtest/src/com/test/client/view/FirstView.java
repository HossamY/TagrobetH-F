package com.test.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasDirectionalText;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.test.client.presenter.FirstViewPresenter;

public class FirstView extends Composite implements com.test.client.presenter.FirstViewPresenter.Display {

	private static FirstViewUiBinder uiBinder = GWT.create(FirstViewUiBinder.class);

	interface FirstViewUiBinder extends UiBinder<Widget, FirstView> {
	}

	@UiField
	Button button;
	@UiField
	Label label;
	private FirstViewPresenter presenter;

	public FirstView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public void setPresenter(FirstViewPresenter presenter) {
		this.presenter = presenter;
	}

	@UiHandler("button")
	void onClick(ClickEvent e) {
		presenter.onButtonClicked();
	}

	@Override
	public HasClickHandlers getButton() {
		// TODO Auto-generated method stub
		return button;
	}

	@Override
	public HasDirectionalText getLabel() {
		// TODO Auto-generated method stub
		return label;
	}

	public Widget asWidget(){
		return this;
	}
}
