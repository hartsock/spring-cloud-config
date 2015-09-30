/*
 * Copyright 2013-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.cloud.config.server.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.config.server.ConfigServerProperties;
import org.springframework.cloud.config.server.GenericResourceRepository;
import org.springframework.cloud.config.server.ResourceLocationService;
import org.springframework.cloud.config.server.ResourceRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Dave Syer
 *
 */
@Configuration
@ConditionalOnMissingBean(ResourceRepository.class)
@EnableConfigurationProperties(ConfigServerProperties.class)
public class ResourceRepositoryConfiguration {

	@Bean
	public ResourceRepository resourceRepository(ResourceLocationService service) {
		return new GenericResourceRepository(service);
	}
}