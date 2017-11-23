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
	// ������activeMQ_queue
	@Resource(name = "demoQueueDestination")
	private Destination demoQueueDestination;

	// ������Ϣ������
	@Resource(name = "producerService")
	private ProducerService producer;

	// ������Ϣ������
	@Resource(name = "consumerService")
	private ConsumerService consumer;

	/**
	 * ������Ϣ  point-to-point
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
	 * ������Ϣ point-to-point
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
				mv.addObject("textMessage", "δ��ȡ����Ϣ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		mv.setViewName("receive");
		return mv;
		
	}
	
}
