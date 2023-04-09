package beetween.com.mp.connector.generator.implementations;

import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import beetween.com.mp.connector.generator.connectorGenerator.Connector

class JavaGenerator extends AbstractGenerator {
	
	
	 
	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
        for (connector : resource.allContents.toIterable.filter(Connector)) {
           
        }
        fsa.generateFile('greetings.txt', 'People to greet: ' + 
			resource.allContents.toIterable.filter(Connector).map[it]
				.join(', '));
    }
	
	
	
	/*/

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
