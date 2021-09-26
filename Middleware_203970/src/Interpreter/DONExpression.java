/**
 * Expresión para el formato DON
 */
package Interpreter;

/**
 *
 * @author Casal
 */
public class DONExpression extends FormatExpression{

    @Override
    public String DON(String formato) {
        return formato;
    }

    @Override
    public String CON(String formato) {
        return formato.replace("/", ",");
    }
    
}
