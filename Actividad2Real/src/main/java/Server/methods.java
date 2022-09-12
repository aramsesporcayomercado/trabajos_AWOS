package Server;

public class methods {

    public String operation(double num1, double num2, double num3, double num4) {
        double sum = (num1 + num2 + num3 + num4);
        double product = (num1 * num2 * num3 * num4);
        double prom = (num1 + num2 + num3 + num4 / 4);

        return "Tu suma es de: " + sum + "Tu producto es de" + product
                + "Tu promedio es de: " + prom;
    }

    public String sum2(double num1, double num2) {
        if (num1 > num2) {
            double x = num1;
            num1 = num2;
            num2 = x;
        }
        double sumtotal = 0;
        for (double i = num1; i < num2; i++) {

            sumtotal = sumtotal + i;
        }
        sumtotal = sumtotal - num1;
        return "Suma Total: " + sumtotal;
    }

    public String arreglo(int cifra, int num1, int num2, int num3, int num4, int num5) {

        double array[] = new double[cifra];
        array[0] = num1;
        array[1] = num2;
        array[2] = num3;
        array[3] = num4;
        array[4] = num5;

        double aux = 0;
        for (double i = 0; i < 5; i++) {

            for (double x = 0; x < cifra - 1; x++) {

                if (array[(int) x] > array[(int) (x + 1)]) {
                    aux = array[(int) x];
                    array[(int) x] = array[(int) (x + 1)];
                    array[(int) (x + 1)] = aux;
                }
            }
        }
        return "EL orden es del menor al mayor " + array[0] + ", " + array[1] + ", " + array[2] + ", " + array[3] + ", " + array[4];

    }
}

