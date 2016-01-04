/**
 * Copyright 2016 Smoke Turner, LLC.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.smoketurner.notification.application.managed;

import static org.assertj.core.api.Assertions.failBecauseExceptionWasNotThrown;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import org.junit.Test;
import com.basho.riak.client.core.RiakCluster;

public class RiakClusterManagerTest {

    private final RiakCluster cluster = mock(RiakCluster.class);
    private final RiakClusterManager manager = new RiakClusterManager(cluster);

    @Test
    public void testNullManager() throws Exception {
        try {
            new RiakClusterManager(null);
            failBecauseExceptionWasNotThrown(NullPointerException.class);
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testStart() throws Exception {
        manager.start();
        verify(cluster).start();
    }

    @Test
    public void testStop() throws Exception {
        manager.stop();
        verify(cluster).shutdown();
    }
}
