package com.elegant.poc.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class ClientApplication {

	@Autowired
	private EurekaClient client;

	@Autowired
	RestTemplateBuilder restTemplateBuilder;

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}

	@RequestMapping("/")
	public String callService() {

		RestTemplate restTemplate = restTemplateBuilder.build();
		InstanceInfo instanceInfo = client.getNextServerFromEureka("service", false);
		String baseUrl = instanceInfo.getHomePageUrl();

		ResponseEntity<String> response = restTemplate.exchange(baseUrl, HttpMethod.GET, null, String.class);

		return response.getBody();
	}
}
