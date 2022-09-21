package RPCClient;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Client {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws MalformedURLException, XmlRpcException {
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL("http://localhost:1700"));
        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config);

        String opcion = "", num1 = "", num2 = "";

        do {
            System.out.print("1. suma");

            System.out.print("2. Resta");
            System.out.print("3. Multiplicacion");
            System.out.print("4. Division");
            System.out.print("5 Exponente");
            System.out.print("6. raiz");
            System.out.print("7. Salir");
            opcion = sc.next();
            if (isNumber(opcion)) {
                switch (Integer.parseInt(opcion)) {
                    case 1:
                        do {
                            System.out.print("el primer valor");
                            num1 = sc.next();
                            if (!isNumber(num1)) {
                                System.out.print("error ingrese el correcto");
                                break;
                            }
                        }
                        while (!isNumber(num2));
                        //llamada al servicio web
                        Object[] info ={ num1, num2};
                        String response = (String) client.execute("Methods.sum", info);
                        response = (String) client.execute("Methods.sum", info);
                        response = (String) client.execute("Methods.sum", info);
                        System.out.println(response);
                        break;
                    case 2:
                        do {
                            System.out.print("el primer dato");
                            System.out.print("el segundo dato");
                            num1 = sc.next();
                            num2 = sc.next();
                            if (!isNumber(num1)){
                                System.out.print("error ingrese el correcto");
                                break;
                            }
                        }
                        while (!isNumber(num2));
                        //llamada al servicio web
                        Object[] inf ={ num1, num2};
                        response = (String) client.execute("Methods.resta", inf);
                        System.out.println(response);
                        break;
                    case 3:
                        do{
                            System.out.print("el primer dato");
                            System.out.print("el segundo dato");
                            num1 = sc.next();
                            num2 = sc.next();
                            if(!isNumber(num1)){
                                System.out.print("error ingrese el correcto porfavor");
                                break;
                            }
                        }
                        while (!isNumber(num2));
                        Object[] i ={ num1, num2};
                        response = (String) client.execute("Methods.multiplicacion", i);
                        System.out.println(response);
                        break;
                    case 4:
                        do {
                            System.out.print("el primer dato");
                            System.out.print("el segundo dato");
                            num1 = sc.next();
                            num2 = sc.next();
                            if (!isNumber(num1)) {
                                System.out.print("error ingrese el correcto porfavor");
                                break;
                            }
                        }
                        while (!isNumber(num2));
                        Object[] a ={ num1, num2};
                        response = (String) client.execute("Methods.division", a);
                        System.out.println(response);
                        break;
                    case 5:
                        do {
                            System.out.print("el primer dato");
                            num1 = sc.next();
                            if (!isNumber(num1)) {
                                System.out.print("error ingrese el correcto porfavor");
                                break;
                            }
                        }
                        while (!isNumber(num2));
                        Object[] t ={ num1, num2};
                        response = (String) client.execute("Methods.division", t);
                        System.out.println(response);
                        break;
                    case 6:
                        do {
                            System.out.print("el primer dato");
                            num1 = sc.next();
                            if (!isNumber(num1)){
                                System.out.print("error ingrese el correcto porfavor");
                                break;
                            }
                        }
                        while (!isNumber(num2));
                        Object[] u ={ num1, num2};
                        response = (String) client.execute("Methods.exponente", u);
                        System.out.println(response);
                        break;
                    case 7:
                        do {
                            System.out.print("el primer dato");
                            num1 = sc.next();
                            if (!isNumber(num1)){
                                System.out.print("error ingrese el correcto porfavor");
                                break;
                            }
                        }
                        while (!isNumber(num2));
                        Object[] y ={ num1, num2};
                        response = (String) client.execute("Methods.raiz", y);
                        System.out.println(response);
                        break;
                    default:
                        System.out.print("ingresa la opcion correcta porfavor");
                }
            } else {
                System.out.print("ingresa opcion valido");

            }
        } while (!opcion.equals("7"));
    }


    public static boolean isNumber(String Number) {
        try {
            int num = Integer.parseInt(Number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}

