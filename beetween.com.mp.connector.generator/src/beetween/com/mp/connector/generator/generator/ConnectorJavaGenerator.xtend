package beetween.com.mp.connector.generator.generator

import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext

class ConnectorJavaGenerator extends AbstractGenerator {
	
	override doGenerate(Resource input, IFileSystemAccess2 fsa, IGeneratorContext context) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	/*/
	List connectors = new ArrayList();

	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		
		connectors.ad
		for (e: resource.allContents.toIterable.filter(Connector)) {
		 	e.medatetadas.addAll(connectors);
		}

	
	 fsa.generateFile('greetings.txt', 'People to greet: ' + 
			resource.allContents.toIterable.filter(Connector).map[it]
				.join(', '));
	 
	}
	*/
}
