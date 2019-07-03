package com.oracle.labs.mlrg.olcut.config.edn;

import com.oracle.labs.mlrg.olcut.config.BasicConfigurable;
import com.oracle.labs.mlrg.olcut.config.ConfigurationData;
import com.oracle.labs.mlrg.olcut.config.ConfigurationManager;
import com.oracle.labs.mlrg.olcut.config.StringConfigurable;
import com.oracle.labs.mlrg.olcut.config.property.Property;
import com.oracle.labs.mlrg.olcut.config.PropertyException;
import com.oracle.labs.mlrg.olcut.config.property.SimpleProperty;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class RemoveTest {

    @BeforeAll
    public static void setUpClass() throws IOException {
        ConfigurationManager.addFileFormatFactory(new EdnConfigFactory());
    }

    @Test
    public void testInstantiatedRemove() throws IOException {
        ConfigurationManager cm = new ConfigurationManager("basicConfig.edn");
        BasicConfigurable bc = (BasicConfigurable) cm.lookup("a");
        boolean removed = cm.removeConfigurable("a");
        assertTrue(removed);
        try {
            BasicConfigurable nbc = (BasicConfigurable) cm.lookup("a");
            fail("Found a removed component");
        } catch (PropertyException e) { }
    }

    @Test
    public void testUninstantiatedRemove() throws IOException {
        ConfigurationManager cm = new ConfigurationManager("basicConfig.edn");
        boolean removed = cm.removeConfigurable("a");
        assertTrue(removed);
        try{
            BasicConfigurable nbc = (BasicConfigurable) cm.lookup("a");
            fail("Found a removed component");
        } catch (PropertyException e) { }
    }

    @Test
    public void removeProgramaticallyAddedUninstantiated() throws IOException {
        ConfigurationManager cm = new ConfigurationManager();
        Map<String, Property> m = new HashMap<>();
        m.put("s", new SimpleProperty("foo"));
        m.put("i", new SimpleProperty(Integer.toString(7)));
        m.put("d", new SimpleProperty(Double.toString(2.71)));
        cm.addConfiguration(new ConfigurationData("a",BasicConfigurable.class.getName(),m));
        boolean removed = cm.removeConfigurable("a");
        assertTrue(removed);
        try{
            BasicConfigurable bc = (BasicConfigurable) cm.lookup("a");
            fail("Found a removed component");
        } catch (PropertyException e) { }
    }

    @Test
    public void removeProgramaticallyAddedInstantiated() throws IOException {
        ConfigurationManager cm = new ConfigurationManager();
        Map<String, Property> m = new HashMap<>();
        m.put("s", new SimpleProperty("foo"));
        m.put("i", new SimpleProperty(Integer.toString(7)));
        m.put("d", new SimpleProperty(Double.toString(2.71)));
        cm.addConfiguration(new ConfigurationData("a",BasicConfigurable.class.getName(),m));
        BasicConfigurable bc = (BasicConfigurable) cm.lookup("a");
        boolean removed = cm.removeConfigurable("a");
        assertTrue(removed);
    }
}
