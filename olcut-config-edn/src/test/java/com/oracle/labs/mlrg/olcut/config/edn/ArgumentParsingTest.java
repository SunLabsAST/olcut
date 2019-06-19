package com.oracle.labs.mlrg.olcut.config.edn;

import com.oracle.labs.mlrg.olcut.config.ConfigurationManager;
import com.oracle.labs.mlrg.olcut.config.Option;
import com.oracle.labs.mlrg.olcut.config.Options;
import com.oracle.labs.mlrg.olcut.config.StringListConfigurable;

import java.io.IOException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ArgumentParsingTest {

    @Test
    public void testConfigLoading() throws IOException {
        String[] args = new String[]{"-c","stringListConfig.edn","--other-arguments","that-get-in-the-way", "--config-file-formats", "com.oracle.labs.mlrg.olcut.config.edn.EdnConfigFactory"};
        loadFromArgs("-c",args);
        args = new String[]{"--config-file-formats", "com.oracle.labs.mlrg.olcut.config.edn.EdnConfigFactory", "--config-file","stringListConfig.edn","--other-arguments","that-get-in-the-way"};
        loadFromArgs("--config-file",args);
        args = new String[]{"-o","--config-file","stringListConfig.edn,componentListConfig.edn", "--config-file-formats", "com.oracle.labs.mlrg.olcut.config.edn.EdnConfigFactory","-s"};
        loadFromArgs("--config-file with multiple files",args);
        args = new String[]{"-o","--config-file","componentListConfig.edn","-s", "--config-file-formats", "com.oracle.labs.mlrg.olcut.config.edn.EdnConfigFactory","-c","stringListConfig.edn"};
        loadFromArgs("overriding --config-file with -c",args);
    }

    public void loadFromArgs(String name, String[] args) throws IOException {
        ParsingOptions o = new ParsingOptions();
        ConfigurationManager cm = new ConfigurationManager(args,o);
        StringListConfigurable slc = (StringListConfigurable) cm.lookup("listTest");
        assertEquals("a", slc.strings.get(0), "Loading from " + name + " failed.");
        assertEquals("b", slc.strings.get(1), "Loading from " + name + " failed.");
        assertEquals("c", slc.strings.get(2), "Loading from " + name + " failed.");
    }

    public static class ParsingOptions implements Options {
        @Option(charName = 'o', longName="other", usage="test hard")
        public boolean other;

        @Option(charName = 's', longName="surrounding", usage="test hard 2: test harder")
        public boolean surrounding;

        @Option(longName="other-arguments", usage="test hard with a vengeance")
        public String otherArguments;
    }
}

