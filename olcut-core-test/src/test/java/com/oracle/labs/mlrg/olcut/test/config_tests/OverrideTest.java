/*
 * Copyright (c) 2004-2020, Oracle and/or its affiliates.
 *
 * Licensed under the 2-clause BSD license.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */

package com.oracle.labs.mlrg.olcut.test.config_tests;

import java.io.IOException;

import com.oracle.labs.mlrg.olcut.config.ConfigurationManager;
import com.oracle.labs.mlrg.olcut.config.io.ConfigLoaderException;
import com.oracle.labs.mlrg.olcut.test.config.StringConfigurable;
import com.oracle.labs.mlrg.olcut.test.config.StringleConfigurable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.oracle.labs.mlrg.olcut.config.ConfigurationManager.createModuleResourceString;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 */
public class OverrideTest {

    @Test
    public void overrideWithSameType() throws IOException {
        ConfigurationManager cm = new ConfigurationManager(createModuleResourceString(this.getClass(), "overrideConfig.xml"));
        StringConfigurable sc = (StringConfigurable) cm.lookup("a");
        Assertions.assertEquals("a", sc.one);
        Assertions.assertEquals("b", sc.two);
        Assertions.assertEquals("c", sc.three);
        sc = (StringConfigurable) cm.lookup("b");
        Assertions.assertEquals("a", sc.one);
        Assertions.assertEquals("b", sc.two);
        Assertions.assertEquals("d", sc.three);
    }

    @Test
    public void doubleOverride() throws IOException {
        ConfigurationManager cm = new ConfigurationManager(createModuleResourceString(this.getClass(), "overrideConfig.xml"));
        StringConfigurable sc = (StringConfigurable) cm.lookup("a");
        Assertions.assertEquals("a", sc.one);
        Assertions.assertEquals("b", sc.two);
        Assertions.assertEquals("c", sc.three);
        sc = (StringConfigurable) cm.lookup("b");
        Assertions.assertEquals("a", sc.one);
        Assertions.assertEquals("b", sc.two);
        Assertions.assertEquals("d", sc.three);
        sc = (StringConfigurable) cm.lookup("bsub");
        Assertions.assertEquals("a", sc.one);
        Assertions.assertEquals("b", sc.two);
        Assertions.assertEquals("e", sc.three);
    }
    
    @Test
    public void overrideWithSubType() throws IOException {
        ConfigurationManager cm = new ConfigurationManager(createModuleResourceString(this.getClass(), "overrideConfig.xml"));
        StringConfigurable sc = (StringConfigurable) cm.lookup("a");
        Assertions.assertEquals("a", sc.one);
        Assertions.assertEquals("b", sc.two);
        Assertions.assertEquals("c", sc.three);
        StringleConfigurable sc2 = (StringleConfigurable) cm.lookup("c1");
        Assertions.assertEquals("a", sc2.one);
        Assertions.assertEquals("b", sc2.two);
        Assertions.assertEquals("c", sc2.three);
        Assertions.assertEquals("e", sc2.four);
        sc2 = (StringleConfigurable) cm.lookup("c2");
        Assertions.assertEquals("a", sc2.one);
        Assertions.assertEquals("b", sc2.two);
        Assertions.assertEquals("d", sc2.three);
        Assertions.assertEquals("e", sc2.four);
    }

    @Test
    public void overrideIncorrectName() {
        Assertions.assertThrows(ConfigLoaderException.class,
                () -> {
                    ConfigurationManager cm = new ConfigurationManager(createModuleResourceString(this.getClass(),
                            "overrideIncorrect.xml"));
                });
    }
}
