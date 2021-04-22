/*
 * Copyright 2018-present HiveMQ GmbH
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
package com.hivemq.swarm.extensions;

import com.codahale.metrics.Counter;
import com.hivemq.swarm.extension.sdk.ExtensionContext;
import com.hivemq.swarm.extension.sdk.ExtensionMain;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * This is the main class of the extension,
 * which is instantiated during the HiveMQ Swarm start up process
 *
 * @author Florian Limpöck
 * @since 4.6.0
 */
public class HelloWorldMain implements ExtensionMain {

    private static final Logger log = LoggerFactory.getLogger(HelloWorldMain.class);

    @Override
    public void extensionMain(final @NotNull ExtensionContext extensionContext) {

        final Counter counter = extensionContext.getMetricRegistry().counter("payloads.generated");
        final @NotNull AtomicInteger next = new AtomicInteger(0);

        extensionContext.getExtensionRegistry().addPayloadGenerator("my-generator", payloadGeneratorInput -> {
            counter.inc();
            final String payload = payloadGeneratorInput.getTopic() + next.incrementAndGet();
            log.info("payload-generated: " + payload);
            return ByteBuffer.wrap((payload).getBytes(StandardCharsets.UTF_8));
        });
    }
}
