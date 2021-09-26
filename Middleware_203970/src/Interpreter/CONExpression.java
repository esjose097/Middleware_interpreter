/**
 * Expresiones para el tipo de formato CON.
 */
package Interpreter;

/**
 *
 * @author Casal
 */
public class CONExpression extends FormatExpression{

    @Override
    public String DON(String formato) {
        return formato.replace(",", "/");
    }

    @Override
    public String CON(String formato) {
        return formato;
    }
    
}
