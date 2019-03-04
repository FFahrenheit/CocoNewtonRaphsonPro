package coconewtonraphsonpro;

/**
 *Esta clase maneja los términos como una clase
 * almacenando su exponente y coeficiente.
 * Así como la implementación de sus valores de derivada
 * @author ivxn
 */
public class Member 
{
    public double coeficient;
    public double exponent; 
    /***
     * Este constructor llama a la inicialización del miemnbro
     * @param _coef el coefiente de la expresión
     * @param _exp el exponente o grado de la expresión
     */
    Member(double _coef, double _exp)
    {
        setMember(_coef, _exp);
    }
    /***
     * setMember asigna valores al miembro
     * @param _coef el coefiente de la expresión
     * @param _exp el exponente o grado de la expresión
     */
    public void setMember(double _coef, double _exp)
    {
        coeficient = _coef;
        exponent = _exp;
    }
    
    /**
     * Devuelve la evaluación del miembro dado un X
     * @param _x el número con que se evaluará f(x)
     * @return f(x) del miembro evaluado
     */
    public double evaluate(double _x)
    {
        return coeficient*Math.pow(_x, exponent);
    }
    
    /**
     * Devuelve la evaluación de la derivada del 
     * miembro dado un valor X
     * @param _x el número con que se evaluará f'(x)
     * @return f'(x) del miembro evaluado
     */
     
    public double evaluatePrime(double _x)
    {
        return coeficient*exponent*Math.pow(_x, (exponent-1));
    }
}
