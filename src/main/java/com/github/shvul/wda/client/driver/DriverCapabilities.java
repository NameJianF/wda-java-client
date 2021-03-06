/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
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

package com.github.shvul.wda.client.driver;

import com.github.shvul.wda.client.exception.CapabilityIsNotFoundException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DriverCapabilities {

    public enum Key {
        PLATFORM("platform"),
        WDA_PATH("wdaPath"),
        DEVICE_NAME("deviceName"),
        DEVICE_ID("deviceId"),
        OS_VERSION("osVersion"),
        DEVICE_IP("deviceIp"),
        BUNDLE_ID("bundleId"),
        APP_PATH("app"),
        LANGUAGE("language"),
        LOCALE("locale");

        private String key;

        Key(String key) {
            this.key = key;
        }

        String getKey() {
            return key;
        }
    }

    private Map<String, String> capabilities = new HashMap<>();

    public void setCapability(Key capabilityKey, String value) {
        this.addToCapabilities(capabilityKey.getKey(), value);
    }

    public void setCapability(String name, String value) {
        this.addToCapabilities(name, value);
    }

    public void setCapabilities(String name, Boolean value) {
        this.addToCapabilities(name, value);
    }

    public void setPlatform(String value) {
        this.setCapability(Key.PLATFORM, value);
    }

    public void setWdaPath(String value) {
        this.setCapability(Key.WDA_PATH, value);
    }

    public void setDeviceIp(String value) {
        this.setCapability(Key.DEVICE_IP, value);
    }


    public void setDeviceName(String value) {
        this.setCapability(Key.DEVICE_NAME, value);
    }

    public void setDeviceId(String value) {
        this.setCapability(Key.DEVICE_ID, value);
    }

    public void setOsVersion(String value) {
        this.setCapability(Key.OS_VERSION, value);
    }

    public void setAppPath(String value) {
        this.setCapability(Key.APP_PATH, value);
    }

    public void setBundleId(String value) {
        this.setCapability(Key.BUNDLE_ID, value);
    }

    public void setLanguage(String value) {
        this.setCapability(Key.LANGUAGE, value);
    }

    public void setLocale(String value) {
        this.setCapability(Key.LOCALE, value);
    }

    public String getCapability(String name) {
        return capabilities.get(name);
    }

    public String getCapability(Key capabilityKey) {
        return capabilities.get(capabilityKey.getKey());
    }

    private void addToCapabilities(String name, Object value) {
        if (Arrays.stream(Key.values()).map(Key::getKey).anyMatch(k -> k.equals(name))) {
            capabilities.put(name, (String)value);
        } else {
            throw new CapabilityIsNotFoundException(name);
        }
    }
}
