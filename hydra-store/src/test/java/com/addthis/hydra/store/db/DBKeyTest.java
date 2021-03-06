/*
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
package com.addthis.hydra.store.db;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DBKeyTest {

    @Test
    public void keySerialization() {
        keySerialization(0, "");
        keySerialization(0, "foobar");
        keySerialization(1, "");
        keySerialization(1, "foobar");
        keySerialization(Integer.MAX_VALUE - 1l, "");
        keySerialization(Integer.MAX_VALUE - 1l, "foobar");
        keySerialization(Integer.MAX_VALUE, "");
        keySerialization(Integer.MAX_VALUE, "foobar");
        keySerialization(Integer.MAX_VALUE + 1l, "");
        keySerialization(Integer.MAX_VALUE + 1l, "foobar");
    }

    private void keySerialization(long id, String key) {
        DBKey input = new DBKey(id, key);
        byte[] serialization = input.toBytes();
        int bytes = key.length();
        if (id <= Integer.MAX_VALUE) {
            bytes += 4;
        } else {
            bytes += 8;
        }
        assertEquals(bytes, serialization.length);
        DBKey output = DBKey.fromBytes(serialization);
        assertEquals(input, output);
    }
}
