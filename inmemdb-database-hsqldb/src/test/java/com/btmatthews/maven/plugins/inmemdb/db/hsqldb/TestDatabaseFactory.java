/*
 * Copyright 2011-2016 Brian Matthews
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

package com.btmatthews.maven.plugins.inmemdb.db.hsqldb;

import com.btmatthews.utils.monitor.Logger;
import com.btmatthews.utils.monitor.ServerFactory;
import com.btmatthews.utils.monitor.ServerFactoryLocator;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Unit test the server factory configuration.
 *
 * @author <a href="mailto:brian@btmatthews.com">Brian Matthews</a>
 * @version 1.0.0
 */
public final class TestDatabaseFactory {

    /**
     * Mock for the logger.
     */
    @Mock
    private Logger logger;

    /**
     * Used to locate the {@link ServerFactory} for the database server.
     */
    private ServerFactoryLocator locator;

    /**
     * Create the server locator factory test fixture.
     */
    @Before
    public void setUp() {
        initMocks(this);
        locator = ServerFactoryLocator.getInstance(logger);
    }

    /**
     * Verify that the server factory locator returns a {@link HSQLDBDatabaseFactory} when
     * &quot;hsqldb&quot; is passed as the database type.
     */
    @Test
    public void testHSQLDBType() {
        final ServerFactory factory = locator.getFactory("hsqldb");
        assertNotNull(factory);
        assertTrue(factory instanceof HSQLDBDatabaseFactory);
    }
}