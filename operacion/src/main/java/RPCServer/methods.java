package RPCServer;

public class methods {

    public String sum(double num1, double num2){
        double suma= num1+num2;
        return "tu suma es de:"+suma;
    }
    public String resta(double num1,double num2){
        double resta =num1 - num2;
        return "tu resta es de:"+resta;
    }
    public String multiplicacion(double num1,double num2){
        double Multiplicacion = num1*num2;
        return "tu multiplicacion es de:"+Multiplicacion;
    }
    public String division(double num1, double num2) {
        double division = num1 / num2;
        return "tu division es de:" + division;
    }
    public String exponente(double num2){
        double exponete = Math.pow(num2, 4);
        return "tu exponente es de:"+ exponete;
    }
    public String Raiz(double num1)  {
        double raiz = Math.sqrt(num1);
        return "tu raiz es de:" + raiz;
    }
}


