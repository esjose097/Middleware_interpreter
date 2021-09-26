/**
 * Esta clase representa el contexto del cambio de formato.
 * Del patrón interpreter.
 */
package Interpreter;

/**
 *
 * @author Casal
 */
public class Context {
    //Mensaje a traducir.
    private String conversionQues = "";
    //Respuesta(No supe como interpretarla)
    private String conversionResponse = "";
    //A que se va a convertir
    private FormatEnums conversionTo;
    //De que se va a convertir
    private FormatEnums conversionFrom;
    
    /**
     * Método constructor de la clase Ccontext.
     * @param conversionQues
     * @param conversionFrom
     * @param conversionTo 
     */
    public Context(String conversionQues, FormatEnums conversionFrom, FormatEnums conversionTo){
        this.conversionQues = conversionQues;
        this.conversionFrom = conversionFrom;
        this.conversionTo = conversionTo;
    }

    public String getConversionQues() {
        return conversionQues;
    }

    public String getConversionResponse() {
        return conversionResponse;
    }

    public FormatEnums getConversionTo() {
        return conversionTo;
    }

    public FormatEnums getConversionFrom() {
        return conversionFrom;
    }
        
}
