/*
 * Copyright 2017 ImpactDevelopment
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

package clientapi.plugin;

import clientapi.core.Core;
import clientapi.util.interfaces.Helper;

/**
 * An extension to ClientAPI
 *
 * @author Brady
 * @since 9/1/2017 1:42 PM
 */
public abstract class Plugin extends Core<PluginInfo> implements Helper {

    public Plugin(PluginInfo info) {
        super(info);
    }
}
