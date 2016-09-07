package com.test.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class ButtonClickedEvent extends GwtEvent<ButtonClickedEventHandler> {

	public static Type<ButtonClickedEventHandler> TYPE = new Type<ButtonClickedEventHandler>();

	@Override
	public Type<ButtonClickedEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(ButtonClickedEventHandler handler) {
		handler.onButtonClicked(this);
	}
}