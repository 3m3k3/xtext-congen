package beetween.com.mp.connector.generator.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.print.attribute.HashAttributeSet;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.xtext.generator.model.GeneratedJavaFileAccess;

import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.TypeLiteral;

import beetween.com.mp.connector.generator.ConnectorGeneratorStandaloneSetup;
import beetween.com.mp.connector.generator.connectorGenerator.Connector;
import beetween.com.mp.connector.generator.connectorGenerator.ConnectorType;
import beetween.com.mp.connector.generator.connectorGenerator.Domainmodel;
import beetween.com.mp.connector.generator.connectorGenerator.FieldDef;
import beetween.com.mp.connector.generator.connectorGenerator.FieldMaper;
import beetween.com.mp.connector.generator.connectorGenerator.FieldType;
public class ParserModelGenerator {
	
	private static final String PACKAGE_ROOT_PATH = "package com.beetween.multiposting.connectors.";
	
	static String packageClass = PACKAGE_ROOT_PATH;
	static String connectorName;
	static String extendsClass;
	static String connectorType;
	
	static Connector connector;
	
	private final static StringBuilder sb = new StringBuilder();
	
	static HashMap<String, String> map = new HashMap<String, String>();
	static HashMap<String, String> fields = new HashMap<String, String>();
	static HashMap<String, String> imports = new HashMap<String, String>();
	static HashMap<String, String> files = new HashMap<String, String>();
    
	public static void main(String[] args) throws Exception {
    	String  dsl = init();
    	
        Domainmodel model = doGetModel(dsl);
        connector = model.getConnector();
        initDatas();
        String connectorJava = generateJavaClass();

    }
    private static String generateJavaClass() {
    	sb.append("public class ").append(connector.getInfos().getConnectorName()).append(" {\n");

    			
    	System.out.println("	public class " + map.get("className")+ ( map.get("extendsClass") != null ? " extends " + map.get("extendsClass") :"") +" {");
    	System.out.println(generateJavaMapping(connector));

    	System.out.println("	}");
    	
    	
		return null;
	}
    
	private static void initDatas() {
		connectorName = connector.getInfos().getConnectorName();
		connectorType = connector.getInfos().getType().getLiteral();
		
		if ( ConnectorType.API.getLiteral().equals(connectorType)) {
			extendsClass = "StandardApiConnector";
			files.put(connectorName + "ApiConnector.java", PACKAGE_ROOT_PATH);
		} else {
			extendsClass = "StandardFeedConnector";
			files.put(connectorName + "FeedConnector.java", PACKAGE_ROOT_PATH);
			files.put(connectorName + "FeedFormatter.java", PACKAGE_ROOT_PATH);
		}
		
    	
		
	}

	
	private static String generateJavaMapping(Connector connector) {
		String map = "";
		
		return map;
	}
	
	private static String init() throws IOException {
		return ReadFile.readFromFile("src/ressources/fileTest.txt");
	}
	public static Domainmodel doGetModel(String content) throws Exception {
        Injector injector = new ConnectorGeneratorStandaloneSetup().createInjectorAndDoEMFRegistration();
        ParseHelper<Domainmodel> parserHelper = injector.getInstance(Key.get(new TypeLiteral<ParseHelper<Domainmodel>>() {}));
        return parserHelper.parse(content);
    }
	
	
	  

}
