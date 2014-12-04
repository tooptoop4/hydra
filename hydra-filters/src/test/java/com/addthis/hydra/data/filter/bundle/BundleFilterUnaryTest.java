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
package com.addthis.hydra.data.filter.bundle;

import java.io.IOException;

import com.addthis.bundle.core.Bundle;
import com.addthis.bundle.core.list.ListBundle;
import com.addthis.codec.config.Configs;
import com.addthis.hydra.data.filter.bundle.unary.BundleFilterUnary;

import org.junit.Assert;
import org.junit.Test;

public class BundleFilterUnaryTest {

    @Test public void trueAlias() throws IOException {
        Bundle bundle = new ListBundle();
        BundleFilterUnary filter = (BundleFilterUnary) Configs.decodeObject(
                BundleFilter.class, "true {}");
        Assert.assertTrue(filter.filter(bundle));
    }

    @Test public void isNotAlias() throws IOException {
        Bundle bundle = new ListBundle();
        BundleFilterUnary filter = (BundleFilterUnary) Configs.decodeObject(
                BundleFilter.class, "is not.false {}");
        Assert.assertTrue(filter.filter(bundle));
    }
}