/*
 * Copyright 2011-2014 Brian Matthews
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

package com.btmatthews.maven.plugins.inmemdb.db.mongodb;

import com.mongodb.DBObject;

/**
 * @author <a href="mailto:brian@btmatthews.com">Brian Matthews</a>
 * @since 2.0.0
 */
public class MongoUpdateMessage extends AbstractMongoMessage {

    private final String fullCollectionName;
    private final int flags;
    private final DBObject selector;
    private final DBObject update;

    public MongoUpdateMessage(
            final int requestID,
            final int responseTo,
            final String fullCollectionName,
            final int flags,
            final DBObject selector,
            final DBObject update) {
        super(requestID, responseTo, OpCode.OP_UPDATE);
        this.fullCollectionName = fullCollectionName;
        this.flags = flags;
        this.selector = selector;
        this.update = update;
    }

    public String getFullCollectionName() {
        return fullCollectionName;
    }

    public String getDatabaseName() {
        final int pos = fullCollectionName.indexOf('.');
        return fullCollectionName.substring(0, pos);
    }

    public String getCollectionName() {
        final int pos = fullCollectionName.indexOf('.');
        return fullCollectionName.substring(pos + 1);
    }

    public int getFlags() {
        return flags;
    }

    public boolean isUpsert() {
        return (flags & 0x1) == 0x1;
    }

    public boolean isMultiUpdate() {
        return (flags & 0x2) == 0x2;
    }

    public DBObject getSelector() {
        return selector;
    }

    public DBObject getUpdate() {
        return update;
    }
}