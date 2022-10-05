import utez.ServiceService;
import utez.Service;

import java.util.Random;
import java.util.Scanner;


public class SoapClient {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ServiceService service = new ServiceService();
        Service port = (Service) service.getServicePort();
        int arp;
        do {
            System.out.println("1 para numeros alatorios");
            System.out.println("2 para Eliminar vocales");
            System.out.println("3 para sacar rfc");
            System.out.println("4 salir");

            arp = input.nextInt();
            switch (arp) {
                case 1:


                    int a = (int) ((Math.random() * 5)+1);
                    int r;
                    int p;

                    System.out.println("Tienes que  adivinar un numero a la azar de 1 a 5 porfavor");

                    System.out.print("adivina el numero porfavor");
                    r = input.nextInt();

                    for (p=0; p<=4; p++) {


                        if (a == r) {
                            System.out.println( port.responseMessage("correcto acertaste") );
                            break;
                        } else if (p == 4) {
                            System.out.println("perdon: perdiste, El número era el siguiente: " + a);
                            break;
                        } else if (a > r)
                            System.out.println("El número secreto es Mayor que " + r);
                        else if (a < r)
                            System.out.println("El número secreto es Menor que " + r);


                        if (p <= 1) {
                            System.out.print("Intentalo otra vez " );
                            r = input.nextInt();
                        } else if (p == 2) {
                            int y = (int) (a / 10);
                            System.out.println("Te voy a dar una pista, la primera cifra es " + y);
                            System.out.print("porfavor inténtalo de nuevo: ");
                            r = input.nextInt();
                        } else if (p >= 3) {
                            System.out.print("Este es tu ultimo intento piensalo bien y responde correctamente");
                            r = input.nextInt();
                        }
                    }

                    break;

                case 2:
                    String str = "Eliminar las vocales";

                    System.out.println("palabra ingresada: " + str);
                    str = str.replaceAll("[AaEeIiOoUu]", "");

                    System.out.println(port.responseMessage(str));
                    break;
                case 3:

                    System.out.println("Ingresa tu nombre porfavor");
                    String nombre = input.next();

                    System.out.println("Ingresa tu appeliido paterno  porfavor ");
                    String apaterno = input.next();
                    System.out.println("Ingresa tu apellido materno maternos  porfavor  ");
                    String amaterno= input.next();
                    System.out.println("escribe tu fecha nacimiento de la siguiente forma porfavor dd/mm/aaaa  ");
                    String fecha= input.next();
                    String rfc = nombre+appelido+apellido+fecha;
                    nombre = nombre.substring(0,1);
                    apaterno = appelido.substring(0,2);
                    amaterno = apellido.substring(0,1);
                    String anio=fecha.trim().substring(8, 10);
                    String mes=fecha.substring(3,5);
                    String dia=fecha.substring(1, 2);
                    String alpha ="asffdsfsdfsd";
                    String r;
                    Random rd = new Random();
                    r = alpha.charAt(rd.nextInt(alpha.length()-1))+"";
                    r+=rd.nextInt(9)+""+rd.nextInt(9);
                    rfc = appelido+apellido+nombre+anio+mes+dia+r;

                    System.out.println(port.responseMessage(rfc));
                    break;


//        System.out.println("ingresa tu apellido fecha de nacimiento   ");


              //      String response = port.responseMessage();

                //    System.out.println(response);
            }
        }while(arp != 4);

    }
}
