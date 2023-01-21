package io.github.arrudalabs;

/*
 *    Copyright 2023-2023 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 *
 */

import org.apache.maven.plugin.logging.Log;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;


@ExtendWith({MockitoExtension.class})
class GreetingMojoTest {


    @Test
    public void testHello(@Mock Log logger) {
        // Given
        GreetingMojo greetingMojo = new GreetingMojo();
        greetingMojo.setLog(logger);

        // When
        greetingMojo.execute();

        // Then
        verify(logger,atLeastOnce()).info(anyString());
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(greetingMojo.getLog()).info(captor.capture());
        String actual = captor.getValue();
        assertEquals("Hello, world!", actual);
    }
}