package com.dguerrar.domain.base;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

import org.springframework.stereotype.Component;

import com.dguerrar.domain.Notification;
import com.dguerrar.domain.Order;

@Component
public class DataContainer extends BaseObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5897615187908867505L;

	private Map<Long,List<Order>> repository; //stores orders
	private Queue<Notification> notificationQueue;
	private Map<Long,List<Long>> repositoryOrderNumbers; //stores relation between orders and stores.

	private DataContainer() {
		super();
		repository= new HashMap<>();
		notificationQueue= new PriorityBlockingQueue<>();
		repositoryOrderNumbers= new HashMap<>();
	}

	public Map<Long, List<Order>> getRepository() {
		return repository;
	}

	public void setRepository(Map<Long, List<Order>> repository) {
		this.repository = repository;
	}

	public Queue<Notification> getNotificationQueue() {
		return notificationQueue;
	}

	public void setNotificationQueue(Queue<Notification> notificationQueue) {
		this.notificationQueue = notificationQueue;
	}

	public Map<Long, List<Long>> getRepositoryOrderNumbers() {
		return repositoryOrderNumbers;
	}

	public void setRepositoryOrderNumbers(Map<Long, List<Long>> repositoryOrderNumbers) {
		this.repositoryOrderNumbers = repositoryOrderNumbers;
	}




}
