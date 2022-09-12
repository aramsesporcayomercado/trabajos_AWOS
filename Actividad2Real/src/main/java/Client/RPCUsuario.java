package Client;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
public class RPCUsuario {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws MalformedURLException, XmlRpcException {
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL("http://localhost:1200"));
        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config);
        Object[] numbers = {5.0, 5D,4,10};
        System.out.println("Ingresa numero 1 porfavor");
        double num1 = sc.nextDouble();
        System.out.println("Ingresa numero 2 porfavor");
        double num2 = sc.nextDouble();
        System.out.println("Ingresa numero 3 porfavor");
        double num3 = sc.nextDouble();
        System.out.println("Ingresa numero 4 porfavor");
        double num4 = sc.nextDouble();
        Double response = (Double)
                client.execute("methods.operation", numbers);
        System.out.println(response);

        System.out.println("ACTIVIDAD 3");

        System.out.println("Introducir numero 1 porfavor");
         num1 =sc.nextDouble();
        System.out.println("Introducir numero 2 porfavor");
         num2 =sc.nextDouble();

        Object[] number ={num1, num2};
        String responses = (String) client.execute("Methods.sum2", number);
        System.out.println(responses);

        System.out.println("ACTIVIDAD 4");

        double cifra=4;
        System.out.println("Introducir el Numero 1 porfavor");
         num1 = sc.nextInt();
        System.out.println("Introducir el Numero 2 porfavor");
         num2 = sc.nextInt();
        System.out.println("Introducir el Numero 3 porfavor");
         num3 = sc.nextInt();
        System.out.println("Introducir el Numero 4 porfavor");
         num4 = sc.nextInt();
        System.out.println("Introducir el Numero 5 porfavor");
         double num5 = sc.nextInt();

        number = new Object[]{cifra, num1, num2, num3, num4, num5};
        String response2 = (String) client.execute("Methods.arreglo", number);
        System.out.println(response2);


    }
}
