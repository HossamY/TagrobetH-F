package com.test.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.RootPanel;

public class EntryPoint implements com.google.gwt.core.client.EntryPoint {

	@Override
	public void onModuleLoad() {
		// TODO Auto-generated method stub
		GreetingServiceAsync rpcService = GWT.create(GreetingService.class);
		HandlerManager eventBus = new HandlerManager(null);
		AppController appViewer = new AppController(rpcService, eventBus);
		appViewer.go(RootPanel.get());

	}

}
