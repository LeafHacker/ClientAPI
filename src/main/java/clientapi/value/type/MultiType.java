/*
 * Copyright 2018 ImpactDevelopment
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

package clientapi.value.type;

import clientapi.util.ClientAPIUtils;
import clientapi.util.interfaces.Cycleable;
import clientapi.value.Value;
import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.Field;

/**
 * A value that can have a specific set of values
 *
 * @author Brady
 * @since 2/24/2017 12:00 PM
 */
public final class MultiType extends Value<String> implements Cycleable<String> {

    /**
     * Different values
     */
    private final String[] values;

    public MultiType(String name, String parent, String id, String description, Object object, Field field, String[] values) {
        super(name, parent, id, description, object, field);
        this.values = values;
        this.setValue(values[0]);
    }

    @Override
    public final void setValue(String value) {
        super.setValue(ClientAPIUtils.objectFrom(value, values));
    }

    @Override
    public final String current() {
        return this.getValue();
    }

    @Override
    public final String next() {
        String value = peekNext();
        this.setValue(value);
        return value;
    }

    @Override
    public final String last() {
        String value = peekLast();
        this.setValue(value);
        return value;
    }

    @Override
    public final String peekNext() {
        int index = ArrayUtils.indexOf(values, getValue());
        if (++index >= values.length)
            index = 0;
        return values[index];
    }

    @Override
    public final String peekLast() {
        int index = ArrayUtils.indexOf(values, getValue());
        if (--index < 0)
            index = values.length - 1;
        return values[index];
    }

    @Override
    public final String[] getElements() {
        return this.values;
    }
}
