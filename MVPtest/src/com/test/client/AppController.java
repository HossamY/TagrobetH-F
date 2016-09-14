package com.test.client;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasWidgets;
import com.test.client.event.ButtonClickedEvent;
import com.test.client.event.ButtonClickedEventHandler;
import com.test.client.presenter.FirstViewPresenter;
import com.test.client.presenter.Presenter;
import com.test.client.presenter.SecondViewPresenter;
import com.test.client.view.FirstView;
import com.test.client.view.SecondView;

public class AppController implements Presenter, ValueChangeHandler<String> {
	
	private final HandlerManager eventBus;
	private final GreetingServiceAsync rpcService;
	private HasWidgets container;

	public AppController(GreetingServiceAsync rpcService, HandlerManager eventBus) {
		this.eventBus = eventBus;
		this.rpcService = rpcService;
		bind();
	}

	private void bind() {
		System.out.println("IN BIND METHOD !!!!!!!!!!!!!");
		History.addValueChangeHandler(this);
		eventBus.addHandler(ButtonClickedEvent.TYPE, new ButtonClickedEventHandler() {
			@Override
			public void onButtonClicked(ButtonClickedEvent buttonClickedEvent) {
				doButtonClickedThing();
			}
		});
	}

	private void doButtonClickedThing() {
		History.newItem("button");
	}

	public void go(final HasWidgets container) {
		this.container = container;

		if ("".equals(History.getToken())) {
			History.newItem("initialState");
			Presenter presenter = new FirstViewPresenter(eventBus, rpcService, new FirstView());
			presenter.go(container);
			
		} else {
			History.fireCurrentHistoryState();
		}
	}

	public void onValueChange(ValueChangeEvent<String> event) {
		String token = event.getValue();
		if (token != null) {
			if (token.equals("button")) {
				Presenter presenter = new SecondViewPresenter(eventBus, rpcService, new SecondView());
				presenter.go(container);
			}

		}
	}

}
