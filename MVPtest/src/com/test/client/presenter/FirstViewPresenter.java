package com.test.client.presenter;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasDirectionalText;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.test.client.GreetingServiceAsync;
import com.test.client.event.ButtonClickedEvent;
import com.test.client.view.FirstView;



public class FirstViewPresenter implements Presenter {

	public interface Display {
		HasClickHandlers getButton();
		HasDirectionalText getLabel();
		Widget asWidget();
	}

	private final HandlerManager eventBus;
	private final GreetingServiceAsync rpcService;
	private final FirstView view;

	public FirstViewPresenter(HandlerManager eventBus, GreetingServiceAsync rpcService, FirstView view) {
		this.eventBus = eventBus;
		this.rpcService = rpcService;
		this.view = view;
		this.view.setPresenter(this);
	}

	public void onButtonClicked() {
		eventBus.fireEvent(new ButtonClickedEvent());
	}

	@Override
	public void go(HasWidgets container) {
		// TODO Auto-generated method stub
		container.clear();
		container.add(view.asWidget());

	}

}
