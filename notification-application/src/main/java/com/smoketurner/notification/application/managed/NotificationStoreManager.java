/*
 * Copyright © 2019 Smoke Turner, LLC (github@smoketurner.com)
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
package com.smoketurner.notification.application.managed;

import com.smoketurner.notification.application.store.NotificationStore;
import io.dropwizard.lifecycle.Managed;
import java.util.Objects;

public class NotificationStoreManager implements Managed {

  private final NotificationStore store;

  /**
   * Constructor
   *
   * @param store Notification store to manage
   */
  public NotificationStoreManager(final NotificationStore store) {
    this.store = Objects.requireNonNull(store, "store == null");
  }

  @Override
  public void start() throws Exception {
    store.initialize();
  }

  @Override
  public void stop() throws Exception {
    // nothing to stop
  }
}
