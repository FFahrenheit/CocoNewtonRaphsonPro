package coconewtonraphsonpro;

/**
 * Esta clase maneja un conjunto de miembros
 * como parte de una ecuación, ofrece el método
 * de solución mediante Newton Raphson, determinada
 * una sigma (error).
 * @author ivxn
 */
public class Equation 
{
    private int membersCount;
    private Member[] members;
    private double sigma;
    public double solution;
    public int iterations;
    /***
     * Incializa la dimensión del arreglo de miembros de la ecuación.
     * @param _count guarda el número de miembros en la ecuación
     */
    Equation(int _count)
    {
        membersCount = _count;
        members = new Member[membersCount];
    }
    /**
     * Inicializa el miembro n de la ecuación
     * @param _coef coeficiente del miembro n
     * @param _exp exponente del miembro n 
     * @param _index identifica al miemnbro n
     */
    public void setMember(double _coef, double _exp, int _index)
    {
        members[_index] = new Member(_coef, _exp);
    }
    /**
     * Función que inicia el método dado un sigma y un x0
     * @param _begin Representa el x0 para comenzar con el método
     * @param _sigma Representa el error, comunmente es <0.001
     * @return la solución, una vez pbtenida.
     */
    public double newtonRaphson(double _begin, double _sigma)
    {
        iterations=0;
        sigma = _sigma;
        solve(_begin);
        return solution;
    }
    /**
     * Realiza una iteración del método Newton Raphson
     * dado un Xn.
     * Si la respuesta está dentro de sigma, asigna el valor,
     * sino, calcula la siguiente iteración y la manda a llamar.
     * @param x_value 
     */
    private void solve(double x_value)
    {
        double y = evaluateF(x_value);
        if(Math.abs(y) <= sigma)
        {
            solution = x_value; 
        }
        else
        {
            iterations++;
            double yprime = evaluateFPrime(x_value);
            double nextIteration = x_value - (y/yprime);
            solve(nextIteration);
        }
    }
    /**
     * Evalúa f(x) de la ecuación dado un Xn
     * @param _x el valor que depende la f(x)
     * @return y, es decir f(x) evaluado
     */
    private double evaluateF(double _x)
    {
        double acum = 0.0;
        for(int i=0; i<membersCount; i++)
        {
            acum += members[i].evaluate(_x);
        }
        return acum;
    }
    /**
     * Evalúa f'(x) de la ecuación dado un Xn
     * @param _x el valor del que depende f(x)
     * @return  el valor de y, dependiente de x
     */
    private double evaluateFPrime(double _x)
    {
        double acum = 0.0;
        for(int i=0; i<membersCount; i++)
        {
            acum += members[i].evaluatePrime(_x);
        }
        return acum;
    }
}