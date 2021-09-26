/**
 * Cliente del patrón interprete.
 */
package Interpreter;

/**
 *
 * @author Casal
 */
public class InterpreterClient {
    
    public InterpreterClient(){}
    /**
     * Método encargado de identificar el tipo de contexto
     * para hacer la conversión mediante las clases expression
     * @param conversionFrom
     * @return 
     */
    public static FormatExpression determinaContexto(FormatEnums conversionFrom){        
        switch (conversionFrom)
        {
            case DON:
                return new DONExpression();
            case CON:
                return new CONExpression();
            default:
                return null;
        }
    }
    
    /**
     * Método encargado de interpretar y convertir el archivo/formato.
     * @param context
     * @return 
     */
    public static String interpretar(Context context){
        FormatExpression expression = determinaContexto(context.getConversionFrom());
        
        switch(context.getConversionTo())
        {
            case CON:
                return expression.CON(context.getConversionQues());
            case DON:
                return expression.DON(context.getConversionQues());
            default:
                return null;
        }
    }
    
}
