/*
 * Copyright © 2018 Smoke Turner, LLC (contact@smoketurner.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.smoketurner.notification.application.exceptions;

import io.dropwizard.jersey.errors.ErrorMessage;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NotificationExceptionMapper implements ExceptionMapper<NotificationException> {

  private static final Logger LOGGER = LoggerFactory.getLogger(NotificationExceptionMapper.class);

  @Override
  public Response toResponse(final NotificationException exception) {
    LOGGER.debug("Error response ({}): {}", exception.getCode(), exception.getMessage());

    return Response.status(exception.getCode())
        .entity(new ErrorMessage(exception.getCode(), exception.getMessage()))
        .type(MediaType.APPLICATION_JSON)
        .build();
  }
}
