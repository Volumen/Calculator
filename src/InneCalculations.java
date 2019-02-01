public class InneCalculations {
    public enum BiOperations
    {
        normal, add, minus, multiply, divide, XpowerofY
    }
    public enum MonoOperations
    {
        square, squareRoot, oneDevidedBy, cos, sin, tan, log, rate
    }
    private double number1, number2;
    private BiOperations mode = BiOperations.normal;
    private double calculateBiImpl()
    {
        if(mode == BiOperations.normal)
        {
            return  number2;
        }
        else if(mode == BiOperations.add)
        {
            return number1+number2;
        }
        else if(mode == BiOperations.minus)
        {
            return number1-number2;
        }
        else if(mode == BiOperations.multiply)
        {
            return number1*number2;
        }
        else if(mode == BiOperations.divide)
        {
            return number1/number2;
        }
        else if(mode == BiOperations.XpowerofY)
        {
            return Math.pow(number1,number2);
        }
        throw new Error();
    }
    public double calculateBi (BiOperations newMode, double number)
    {
        if(mode==BiOperations.normal)
        {
            number2= 0.0;
            number1=number;
            mode = newMode;
            return  Double.NaN;
        }
        else
        {
            number2 = number;
            number1 = calculateBiImpl();
            mode = newMode;
            return  number1;

        }
    }
    public double calculateEqual(double number)
    {
        return calculateBi(BiOperations.normal, number);
    }
    public double reset()
    {
        number2 = 0.0;
        number1 = 0.0;
        mode = BiOperations.normal;
        return Double.NaN;
    }
    public double calculateMono (MonoOperations newMode, double number)
    {
        if(newMode == MonoOperations.square)
        {
            return  number * number;
        }
        else if(newMode == MonoOperations.squareRoot)
        {
            return  Math.sqrt(number);
        }
        else if(newMode == MonoOperations.oneDevidedBy)
        {
            return  1/number;
        }
        else if(newMode == MonoOperations.cos)
        {
            return  Math.cos(number);
        }
        else if(newMode == MonoOperations.sin)
        {
            return  Math.sin(number);
        }
        else if(newMode == MonoOperations.tan)
        {
            return  Math.tan(number);
        }
        else if(newMode == MonoOperations.log)
        {
            return  Math.log10(number);
        }
        else if(newMode == MonoOperations.rate)
        {
            return  number/100;
        }

        throw new Error();
    }
}
