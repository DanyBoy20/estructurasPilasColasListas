
package presentacion;

/**
 *
 * @author Dany
 */
import java.util.Scanner;
// PARA NO ESTAR GENERANDO UNA Y OTRA VEZ EL METODO PARA CAPTURAR LO QUE EL USUARIO INGRESE POR TECLADO, CREO UNA CLASE
// CON SU METODO QUE ME REALIZE ESA OPERACION. YA EN LA APLICACION MANDO LLAMAR AL METODO CADA VEZ QUE LO NECESITE.
public class Capturar {    
    static Scanner captura = new Scanner(System.in); // CREO UNA INSTANCIA DE SCANNER   
    public static String guarda(String mensaje){ // CREO EL METODO GUARDA
        System.out.print(mensaje + " : "); // MANDO EL MENSAJE QUE SE PASA POR PARAMETRO EN EL METODO CUANDO SE INVOQUE
           return captura.nextLine(); // GUARDO EL VALOR CAPTURADO Y LO REGRESO CUANDO EL METODO SEA INVOCADO
    }
}
