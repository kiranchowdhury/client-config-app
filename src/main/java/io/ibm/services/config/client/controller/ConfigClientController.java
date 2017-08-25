package io.ibm.services.config.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.ibm.services.config.client.ConfigClientAppConfigurator;

@RestController
@RefreshScope
public class ConfigClientController {
	@Autowired
	private ConfigClientAppConfigurator configurator;
	
	@Value("${some.other.property}")
	private String someOtherProperty;
	
	@RequestMapping
	public String getConfiguration() {
		return configurator.getProperty() + " || "+ someOtherProperty;
	}
}
