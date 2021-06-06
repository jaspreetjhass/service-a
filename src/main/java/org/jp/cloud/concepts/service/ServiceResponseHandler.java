package org.jp.cloud.concepts.service;

import java.net.URI;

import org.jp.cloud.concepts.config.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ServiceResponseHandler {

	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private AppConfig appConfig;

	@HystrixCommand(fallbackMethod = "defaultResponse")
	public String fetchResponseFromB() {
		log.info("calling serviceB +++++++++++++++++");
		final ResponseEntity<String> responseEntity = restTemplate.getForEntity(URI.create(appConfig.getRequestUrl()),
				String.class);
		log.info("response received from serviceB +++++++++++++++++");
		return responseEntity.getBody();
	}

	public static String defaultResponse() {
		log.info("preparing default response %%%%%%%%%%%%%%%%%%%%%%%%%");
		return "Hello from B";
	}
}
