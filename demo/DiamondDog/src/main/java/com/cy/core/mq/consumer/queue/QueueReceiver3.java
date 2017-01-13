
package com.cy.core.mq.consumer.queue;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.stereotype.Component;

/**
 * 
 * @author liang
 * @description  队列消息监听器
 * 
 */
@Component
public class QueueReceiver3 {

	public void sendMessage(String msg) {
			System.out.println("QueueReceiver3接收到消息:"+msg);
	}

}
