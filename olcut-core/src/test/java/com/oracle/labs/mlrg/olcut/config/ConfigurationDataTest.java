package com.oracle.labs.mlrg.olcut.config;

import com.oracle.labs.mlrg.olcut.provenance.ProvenanceUtil;
import com.oracle.labs.mlrg.olcut.provenance.ProvenanceUtilTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConfigurationDataTest {


    @BeforeAll
    public static void setup() {
        Logger logger = Logger.getLogger(PropertySheet.class.getName());
        logger.setLevel(Level.FINER);
    }


    /*
    @Test
    public void structuralEqualsAllConfig() {
        final String aName = "all-config";
        ConfigurationManager cm = new ConfigurationManager("allConfig.xml");
        AllFieldsConfigurable ac = (AllFieldsConfigurable) cm.lookup(aName);
        List<ConfigurationData> a = cm.getComponentNames().stream()
                .map(cm::getConfigurationData)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());

        cm.close();
        cm = new ConfigurationManager();
        final String bName = cm.importConfigurable(ac);

        List<ConfigurationData> b = cm.getComponentNames().stream()
                .map(cm::getConfigurationData)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());

        ConfigurationData aRoot = a.stream().filter(cd -> cd.getName().equals(aName)).findFirst().get();
        ConfigurationData bRoot = b.stream().filter(cd -> cd.getName().equals(bName)).findFirst().get();

        System.out.println("ac.urlField: " + ac.urlField);
        System.out.println("a.urlField: " + aRoot.get("urlField"));
        System.out.println("b.urlField: " + bRoot.get("urlField"));

        assertTrue(ConfigurationData.structuralEquals(a, b, aName, bName));

        ac.stringField = "Something different from before";

        cm.close();
        cm = new ConfigurationManager();

        String b2Name = cm.importConfigurable(ac);

        b = cm.getComponentNames().stream()
                .map(cm::getConfigurationData)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());

        assertFalse(ConfigurationData.structuralEquals(a, b, aName, bName));
    }
     */

    @Test
    public void structuralEqualsProvenanceRoundtrip() {
        ConfigurationManager cm = new ConfigurationManager("allConfig.xml");
        AllFieldsConfigurable ac = (AllFieldsConfigurable) cm.lookup("all-config");

        cm.close();
        cm = new ConfigurationManager();

        String aName = cm.importConfigurable(ac);
        List<ConfigurationData> a = cm.getComponentNames().stream()
                .map(cm::getConfigurationData)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());

        List<ConfigurationData> b = ProvenanceUtil.extractConfiguration(ac.getProvenance());

        String bName = b.get(0).getName();

        assertTrue(ConfigurationData.structuralEquals(a, b, aName, bName));
    }

}
