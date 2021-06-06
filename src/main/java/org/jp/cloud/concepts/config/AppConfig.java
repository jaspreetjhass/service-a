package org.jp.cloud.concepts.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "service-b")
public class AppConfig {

	private String baseUrl;
	private String requestUrl;

}
