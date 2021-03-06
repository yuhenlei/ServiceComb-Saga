/*
 * Copyright 2017 Huawei Technologies Co., Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.servicecomb.saga.transports;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.servicecomb.saga.transports.httpclient.HttpClientTransport;

@Configuration
public class HttpClientTransportConfig {

  private final int requestTimeout;

  public HttpClientTransportConfig(@Value("${saga.request.timeout:30000}") int requestTimeout) {
    this.requestTimeout = requestTimeout;
  }

  @Bean
  @ConditionalOnMissingBean(RestTransport.class)
  RestTransport transport() {
    return new HttpClientTransport(requestTimeout);
  }
}
