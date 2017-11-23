package com.spring.jms;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ActiveMQController {
	// 队列名activeMQ_queue
	@Resource(name = "demoQueueDestination")
	private Destination demoQueueDestination;

	// 队列消息生产者
	@Resource(name = "producerService")
	private ProducerService producer;

	// 队列消息消费者
	@Resource(name = "consumerService")
	private ConsumerService consumer;

	/**
	 * 发送消息  point-to-point
	 * @param message
	 */
	@RequestMapping(value = "/onsend", method = RequestMethod.GET)
	@ResponseBody
	public String producer(@RequestParam("message") String message) {
		System.out.println("------------send to jms");
		producer.sendMessage(demoQueueDestination, message);
		
		return "success";
	}

	/**
	 * 接收消息 point-to-point
	 * @return
	 * @throws JMSException
	 */
	@RequestMapping(value = "/receive", method = RequestMethod.GET)
	public ModelAndView queue_receive() throws JMSException {
		ModelAndView mv = new ModelAndView();
		try {
			TextMessage tm = consumer.receive(demoQueueDestination);
			
			if(tm!=null){
				mv.addObject("textMessage", tm.getText());
			}else{
				mv.addObject("textMessage", "未读取到消息");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		mv.setViewName("receive");
		return mv;
		
	}
	
}
