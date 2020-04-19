package com.mindtree.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.kafka.model.Employee;

@RestController
@RequestMapping("/kafka")
public class DemoController {
	
	@Autowired
	KafkaTemplate<String, Employee> kafkaTemplate;
    
	private static final String TOPIC ="KAFKA_MINDTREE";
	
	@GetMapping("/publish")
	public String post(@RequestParam("name") String name, @RequestParam("unit") String unit, @RequestParam("salary") Double salary) {
	   kafkaTemplate.send(TOPIC, new Employee(name, unit, salary));
		return "Published successfully";
	}
}
