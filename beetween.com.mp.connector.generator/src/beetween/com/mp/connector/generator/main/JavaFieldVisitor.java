package beetween.com.mp.connector.generator.main;

import beetween.com.mp.connector.generator.connectorGenerator.Connector;
import beetween.com.mp.connector.generator.connectorGenerator.FieldDef;
import beetween.com.mp.connector.generator.connectorGenerator.FieldMaper;

public class JavaFieldVisitor extends ConnectorGeneratorVisitor {

    private final StringBuilder sb = new StringBuilder();
    private int indentationLevel = 0;

    @Override
    public Void visitConnector(Connector connector) {
        sb.append("public class ").append(connector.getInfos().getConnectorName()).append(" {\n");
        indentationLevel++;

        for (FieldMaper fieldMaper : connector.getMapping()) {
         //   fieldMaper.accept(this);
        }

        indentationLevel--;
        sb.append("}\n");

        return null;
    }

    @Override
    public Void visitFieldMaper(FieldMaper fieldMaper) {
       

        return null;
    }

    private String getIndentation() {
        return " ".repeat(indentationLevel * 4);
    }

    public String getResult() {
        return sb.toString();
    }

	public void visit(Connector connector) {
		// TODO Auto-generated method stub
		
	}
}
