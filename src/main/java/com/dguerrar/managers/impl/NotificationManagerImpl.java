package com.dguerrar.managers.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dguerrar.domain.Notification;
import com.dguerrar.domain.base.DataContainer;
import com.dguerrar.generic.GenericModule;
import com.dguerrar.managers.NotificationManager;


@Service
public class NotificationManagerImpl extends GenericModule implements NotificationManager {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4053972769972111172L;

	
	@Autowired
	private DataContainer container;
	@Override
	protected Class<?> getLogClass() {
		// TODO Auto-generated method stub
		return NotificationManagerImpl.class;
	}

	@Override
	public boolean sendNotification(Notification not) {
		container.getNotificationQueue().add(not);
		return true;
	}

}
