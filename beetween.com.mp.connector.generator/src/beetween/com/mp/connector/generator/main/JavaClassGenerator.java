package beetween.com.mp.connector.generator.main;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Injector;

import beetween.com.mp.connector.generator.ConnectorGeneratorStandaloneSetup;
import beetween.com.mp.connector.generator.connectorGenerator.*;

public class JavaClassGenerator {

    public static void main(String[] args) throws IOException {
        Injector injector = new ConnectorGeneratorStandaloneSetup().createInjectorAndDoEMFRegistration();
        XtextResourceSet resourceSet = injector.getInstance(XtextResourceSet.class);

   //     resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);

        Resource resource = resourceSet.getResource(URI.createURI("input.dsl"), true);

        Connector connector = (Connector) ((Domainmodel) resource.getContents().get(0)).getConnector();

        JavaFieldVisitor javaVisitor = new JavaFieldVisitor();
        javaVisitor.visit(connector);

        System.out.println(javaVisitor.getResult());
    }
}
