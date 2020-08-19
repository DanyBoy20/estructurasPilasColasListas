
package presentacion;

// importacion de utilerias
import java.util.LinkedList;
import java.util.Stack;

/**
 *
 * @author Dany
 */
public class Aplicacion {
    
    // ARREGLO DE TIPO STRING QUE GUARDA LAS OPCIONES DEL MENU PRINCIPAL - SELECCION DE ESTRUCTURA
    String numeroMenu[] = {"(1) PILAS - MAQUINA DESPACHADORA DE REFRESCO.",
                           "(2) COLAS - SERVICIO DE ATENCIÓN AL CLIENTE",
                           "(3) LISTAS - ABRIR Y CERRAR SERVICIOS EN UN SISTEMA OPERATIVO",
                           "(4) SALIR DEL PROGRAMA."}; 
    
    // ARREGLO DE TIPO STRING QUE GUARDA LAS OPCIONES DE LOS METODOS DE LAS ESTRUCTURAS
    String numeroMenuEstructuras[] = {"         (1) INSERTAR ELEMENTO.",
                                      "         (2) ELIMINAR ELEMENTO.",
                                      "         (3) MOSTRAR ELEMENTOS.",
                                      "         (4) VERIFICAR SI LA ESTRUCTURA ESTA VACIA.",
                                      "         (5) SALIR"}; 
    
    // CAPACIDAD DE LA PILA (REFRESCOS), LA COLA (TICKETS DE SERVICIO PARA ATENCION A PERSONAS), LISTAS (CANTIDAD SERVICIOS DISPONIBLES)
    public static final int CAPACIDAD_REFRESCO = 5;
    public static final int CANTIDAD_TICKETS = 5;
    public static final int CANTIDAD_SERVICIOS = 5; 
    
    
     // FUNCION PARA MOSTRAR EL MENU PRINCIPAL - SELECCION DE ESTRUCTURAS
    public int MenuPrincipal(){
    System.out.println("----------------MENU PRINCIPAL----------------"); // titulo
        for (String numeroMenu1 : numeroMenu){ // ciclo (o bucle) for para mostrar el menu
            System.out.println(numeroMenu1); // muestro una opcion por cada ciclo (por cada vuelta)
        }
    System.out.println("----------------------------------------------"); // separador, es solo para presentacion y puede quitarse
    // el siguiente metodo viene de la clase capturar, como lo dice en los comentarios dentro de dicha clase
    // aqui solo mando llamar el metodo, este me muestra el mensaje pasado por parametro
    // y me devuelve el valor que el usuario haya seleccionado
    return Integer.parseInt( Capturar.guarda(" --- SELECCIONE UNA OPCION DEL MENU ---\n")); 
    }
    
    // MENU ESTRUCTURAS - ES EL MENU QUE MUESTRA LAS OPCIONES DE LAS ESTRUCTURAS
    // INSERTAR ELEMENTO, ELIMINAR ELEMENTO, MOSTRAR ELEMENTO Y VALIDAR SI LA ESTRUCTURA ESTA VACIA
    public int MenuEstructuras(){
    System.out.println("----------------¿QUE DESEA HACER----------------"); // titulo
        for (String numeroMenuEstructura : numeroMenuEstructuras){ // ciclo (o bucle) for para mostrar el menu
            System.out.println(numeroMenuEstructura); // muestro una opcion por cada ciclo (por cada vuelta)
        }
    System.out.println("----------------------------------------------"); // separador, es solo para presentacion
    // el siguiente metodo viene de la clase capturar, como lo dice en los comentarios dentro de dicha clase
    // aqui solo mando llamar el metodo, este me muestra el mensaje pasado por parametro
    // y me devuelve el valor que el usuario haya seleccionado
    return Integer.parseInt( Capturar.guarda("\n        --- SELECCIONE UN METODO ---"));
    }
    
    // METODO PARA LA ESTRUCTURA PILA
    public void estructuraPilas(){
        Stack pila = new Stack(); // instancia de pila
        int cima  = -1; // inicializo la cima (siempre que no tiene nada o se crea por primera vez, su valor es -1
        boolean opcion = true; // esta opcion es para salir del ciclo do (en su condicion), es decir, salir del sistema
        do{            
            int metodoElegido = MenuEstructuras(); // guardo el valor devuelto por el menu principal (la opcion elegida por usuario)
                switch (metodoElegido) { // verifico que hay en la variable que guarda la opcion del usuario
                    case 1: // SI ELIGIO INSERTAR (INSERTAR REFRESCO EN DESPACHADORA)
                        if(CAPACIDAD_REFRESCO == cima + 1){ // si la capacidad del refresco llego a su limite (cima+1)
                            System.out.println("LA DESPACHADORA ESTA LLENA"); // mensaje
                        break; // break - salir de estas opciones
                        }else{ // sino
                            for(int i = cima; i < CAPACIDAD_REFRESCO; i++){ // ciclo para recorrer e ir insertando refrescos
                                                                            // mientras haya capacidad
                                if(CAPACIDAD_REFRESCO == cima + 1){ // si ya se llego a la capacidad de la pila
                                    System.out.println("YA ESTA LLENA LA DESPACHADORA"); // mensaje
                                    break; // salgo
                                }else{ // sino
                                    String nombreRef = Capturar.guarda("ESCRIBE EL NOMBRE DEL REFRESCO A INSERTAR"); // pido el dato
                                                                                                                     // a insertar
                                    pila.push(nombreRef); // inserto el dato
                                    cima++; // incremento cima (para ir llenando la pila)
                                    String continuar = Capturar.guarda("\n¿INSERTAR OTRO REFRESCO? (SI) - (NO)"); // captrar otro?
                                        if (continuar.equals("no") || continuar.equals("NO")){ // si la respuesta es no
                                        break; // salgo
                                        }
                                }
                            }
                        }
                    break; // salir de opcion
                    case 2: // DAR UN REFRESCO A CLIENTE - ELIMINAR DE DESPACHADORA
                        if(pila.isEmpty()){ // si la pila esta vacia
                            System.out.println("NO HAY REFRESCOS PARA DESPACHAR"); // mensaje
                        break; // salgo
                        }else{ // sino
                            for(int i = cima; i < CAPACIDAD_REFRESCO; i--){ // ciclo para recorrer pila e ir dando refrescos
                                if(pila.isEmpty()){ // si la pila ya esta vacia
                                    System.out.println("YA NO HAY MAS REFRESCOS EN LA DESPACHADORA"); // ya se despacho todo 
                                    break; // salgo
                                }else{ // sino
                                    System.out.println("    - REFRESCO DADO " + pila.pop()); // saco el refresco 
                                    cima--; // decremento el despachador 
                                    String continuar = Capturar.guarda("\n¿DESEA OTRO REFRESCO? (SI) - (NO)"); // sacar otro refresco
                                        if (continuar.equals("no") || continuar.equals("NO")){ // si respuesta es no
                                        break; // salgo
                                        }
                                }
                            }
                        }
                    break;
                    case 3: // MOSTRAR LOS REFRESCOS DE LA DESPACHADORA
                        if(pila.isEmpty()){ // si la pila esta vacia
                            System.out.println("NO HAY REFRESCOS EN LA DESPACHADORA"); // mensaje
                            break; // salgo
                        }else{ // sino
                            System.out.println("ELEMENTOS EN DESPACHADORA"); // mensaje
                            int chescos = 1; // valor solo organizativo (iniciar en 1 hasta la cantidad que hay de refresco
                            Object[] elementosPila = pila.toArray(); // la pila la convierto en array y la guardo en otro array
                                for (Object elementos : elementosPila) { // ciclo for para mostrar elementos
                                    System.out.println(chescos + " " + elementos); // imprimo los elementos
                                    chescos++; // incremento mi contador (valor solo organizativo
                                }
                        }
                    break; // salgo
                    case 4: // VERIFICAR SI LA DESPACHADORA ESTA VACIA
                        if(pila.isEmpty()){ // si esta vacia
                            System.out.println("NO HAY REFRESCOS EN LA DESPACHADORA"); // mensaje
                            break; // salgo
                        }else{ // sino
                            System.out.println("HAY " + pila.size() + " REFRESCOS EN LA DESPACHADORA"); // cantidad existente
                        }                        
                    break; // salgo
                    case 5: // SALIR DEL SISTEMA DESPACHADOR DE REFRESCOS (SALIR DE ESTRUCTURA PILA)
                        opcion = false; // cambio el valor para salir del ciclo do .. while
                    break; // salir de opcion
                    default: // SI NO ELIGIO UNA OPCION DE LAS MOSTRADAS
                        System.out.println("DEBE ELEGIR UNA OPCION VALIDA"); // el usuario selecciono otro valor
                    break; // salgo
                }
            
        }while(opcion); // condicion a cumplirse para seguir o no en el bucle
    }
    
    // METODO PARA COLAS
    public void estructuraColas(){
        Queue cola = new Queue(CANTIDAD_TICKETS); // instancia de cola (Queue)
        boolean opcion = true; // opcion de tipo boleno (verdadero-falso) para salir o seguir en este menu
        do{            
            int metodoElegido = MenuEstructuras(); // guardo el valor que regresa el menu
                switch (metodoElegido) { // lo valido con un switch
                    case 1: // opcion insertar
                        if(cola.isFull()){ // si la cola esta llena
                            System.out.println("SE HAN REPARTIDO TODOS LOS BOLETOS DE ATENCIÓN."); // mensaje
                            break; // salgo
                        } // sino
                        String nombreAtender = Capturar.guarda("DEBE REGISTRARSE, ESCRIBA SU NOMBRE"); // guardo dato en variable
                        cola.offer(nombreAtender); // inserto el dato en la cola
                    break;
                    case 2: // opcion eliminar
                        cola.poll(); // mando llamar al metodo eliminar y elimino dato
                    break;
                    case 3: // opcion mostrar
                        cola.peek(); // mando llamar al metodo mostrar dato (el primero , el que saldra primero)
                    break;
                    case 4: // opcion verificar
                        if(cola.isEmpty()){ // si la cola esta vacia
                            System.out.println("NO HAY PERSONAS PARA ATENDER"); // mensaje
                            break; // salgo
                        }else if(cola.isFull()){ // si la cola esta llena
                            System.out.println("TODOS LOS TICKETS DEL DIA HAN SIDO REPARTIDOS"); // mensaje
                            break; // salgo
                        }else{ // sino
                            System.out.println("HAY " + cola.size() + " PERSONA EN ESPERA"); // muestro cuantas personas hay en la cola
                        } 
                    break; // salgo
                    case 5: // opcion salir
                        opcion = false; // salgo de este menu - variable a falso para que ya no se cumpla la condicion del while
                    break;
                    default: // por defecto - el usuario no eligio alguna opcion de las mostradas
                        System.out.println("DEBE ELEGIR UNA OPCION VALIDA"); // mensaje
                    break; // salgo
                }
            
        }while(opcion); // condicion a cumplirse para seguir en este menu
    }
    
    // METODO  PARA LISTAS
    public void estructuraListas(){
        LinkedList<String> lista = new LinkedList<>(); // instancia de linkedlist (se llamara lista)
        boolean opcion = true; // opcion de tipo boleno (verdadero-falso) para salir o seguir en este menu
        do{            
            int metodoElegido = MenuEstructuras(); // guardo el valor que regresa el menu
                switch (metodoElegido) {
                    case 1: // opcion insertar
                        if(lista.size() == CANTIDAD_SERVICIOS){ // si la lista de servicios ya llego a su capacidad
                            System.out.println("NO PUEDE ABRIR MAS SERVICIOS."); // no inserto nada y mando mensaje
                            break;
                        }else if(lista.isEmpty()){ // si va a ser el primer servicio en abrir 
                            String iniciarServicio = Capturar.guarda("ESCRIBA EL PROGRAMA Y/O SERVICIO QUE DESEA ABRIR"); // pedir datos
                            lista.add(iniciarServicio); // lo que se guarda en variable, lo insetto en la lista
                            break;
                        }else{ // si la lista no esta vacia
                            // pido que den ubicacion de donde desean guardar el dato: al inicio o al final
                            String ubicacion = Capturar.guarda("INDIQUE LA UBICACION DEL PROGRAMA/SERVICIO A ABRIR (1)AL INICIO / (2)AL FINAL");
                            int selecUbica = Integer.parseInt(ubicacion); // valido la opcion elegida por el usuario
                            switch (selecUbica) { // seleccion al inicio
                                case 1:
                                    // pido datos a insertar
                                    String insertarInicio = Capturar.guarda("ESCRIBA EL PROGRAMA Y/O SERVICIO QUE DESEA ABRIR");
                                    lista.addFirst(insertarInicio); // inserto dato 
                                break; // salgo
                                case 2: // seleccion al final
                                    // pido dato a insertar en lista
                                    String insertarFinal = Capturar.guarda("ESCRIBA EL PROGRAMA Y/O SERVICIO QUE DESEA ABRIR");
                                    lista.addLast(insertarFinal); // inserto dato en lista 
                                break; // salgo
                                default:
                                    // si no eligio una opcion de las motradas, mando mensaje e inserto al inicio
                                    String insertarIni = Capturar.guarda("OPCION NO VALIDA, SE INSERTARA AL INICIO - ESCRIBA EL PROGRAMA Y/O SERVICIO QUE DESEA ABRIR");
                                    lista.addFirst(insertarIni); // inserto dato
                                break; // salgo
                            }
                        }                      
                    break;
                    case 2: // opcion eliminar
                        if(lista.isEmpty()){ // si esta vacia
                            System.out.println("NO HAY SERVICIOS PARA CERRAR."); // no hay nada que eliminar
                            break; // salgo
                        }else if (lista.size() == 1){ // si solo hay un elemento
                            // mensaje indicando que se cerrara ese elemento
                            System.out.println("EL UNICO SERVICIO ACTIVO ES " + lista.getFirst() + ", Y SE PROCEDERA A CERRARLO");
                            lista.removeFirst(); // lo cierro (elimino)
                        }else{  // sino
                            System.out.println("SERVICIOS ACTIVOS"); // muestro los servicios (la lista con los datos)
                            Object[] elementosLista = lista.toArray(); // la lista la convierto en array y la guardo en otro arreglo
                                for (Object elementos : elementosLista) { // ciclo para recorrer los elementos del arreglo nuevo
                                    System.out.print(elementos + " | "); // muestro los datos del arreglo
                                }
                            System.out.println("\n"); // salto de linea
                            // pido elegir que servicio (dato de la lista) debo eliminar)
                            String eliminarUbica = Capturar.guarda("(1)CERRAR SERVICIO INICIAL | (2)CERRAR SERVICIO FINAL | (3)ELEGIR SERVICIO A ELIMINAR");
                            int eliminUbica = Integer.parseInt(eliminarUbica); // guardo en variable lo que el usuario eligio
                            switch (eliminUbica) { // valido el dato guardado
                                case 1: // eligio cerrar (eliminar) el dato inicial
                                    lista.removeFirst(); // elimino el dato inicial
                                    System.out.println("SERVICIO " + lista.getFirst() + " CERRADO SATISFACTIRIAMENTE"); // muestro mensaje
                                break; // salgo
                                case 2: // eligio cerrar (eliminar) el dato final
                                    lista.removeLast();// elimino el dato final
                                    System.out.println("SERVICIO " + lista.getLast() + " CERRADO SATISFACTIRIAMENTE");// muestro mensaje
                                break;// salgo
                                case 3: // eligio cerrar (eliminar) un servicio en especifico
                                    String cerrarSeleccion = Capturar.guarda("ESCRIBA EL PROGRAMA Y/O SERVICIO QUE DESEA CERRAR"); // pido servicio a eliminar
                                    lista.remove(cerrarSeleccion); // lo elimino, pasando el dato por parametro
                                    System.out.println("SERVICIO " + cerrarSeleccion + " CERRADO SATISFACTIRIAMENTE"); // mensaje indicando el servicio cerrado
                                break;// salgo
                                default: // si el usuario no eligio una opcion de las mostradas
                                    System.out.println("OPCION NO VALIDA, LOS SERVICIOS NO SUFRIRAN CAMBIOS"); // no elimino nada y mando mensaje
                                break; // salgo
                            }
                                
                                
                        }
                        
                    break;
                    case 3: // opcion mostrar
                        if(lista.isEmpty()){ // si la lista esta vacia
                            System.out.println("NO HAY SERVICIOS ACTIVOS / PROGRAMAS ABIERTOS."); // mensaje , no hay nada que mostrar
                            break; // salgo
                        } // sino
                        System.out.println("SERVICIOS ACTIVOS"); // mensaje - muestro los servicios
                        Object[] elementosLista1 = lista.toArray(); // la lista la convierto en array y la guardo en otro arreglo
                                for (Object elementos : elementosLista1) { // ciclo para recorrer los elementos del arreglo nuevo
                                    System.out.print(elementos + " | "); // muestro los datos del arreglo
                                }
                        System.out.println("\n"); // un salto de linea
                    break;// salgo
                    case 4: // opcion verificar
                        if(lista.isEmpty()){ // si la lista esta vacia
                            System.out.println("NO HAY SERVICIOS ACTIVOS (LISTA VACIA)"); // mensaje, no hay nada que verificar
                            break;// salgo
                        } // sino
                        System.out.println("LA LISTA TIENE SERVICIOS ACTIVOS (NO ESTA VACIA)"); // mensaje y muestro la lista
                        Object[] elementosLista2 = lista.toArray(); // la lista la convierto en array y la guardo en otro arreglo
                                for (Object elementos : elementosLista2) { // ciclo para recorrer los elementos del arreglo nuevo
                                    System.out.print(elementos + " | "); // muestro los datos del arreglo
                                }
                        System.out.println("\n");// un salto de linea
                    break;// salgo
                    case 5: // opcion salir
                        opcion = false;
                    break;// salgo
                    default: // opcion por defecto - el usuario no eligio alguna de las anteriores
                        System.out.println("DEBE ELEGIR UNA OPCION VALIDA");
                    break;// salgo
                }
            
        }while(opcion); // condicion para seguir o no en este ciclo (en este menu)
    }
    
    // METODO PRINCIPAL - ESTE MANDA A LLAMAR EL MENU PRINCIPAL Y EJECUTA LOS METODOS ACORDE AL SISTEMA (ESTRUCTURA) ELEGIDO
    public void iniciar(){
        
        int opcionElegida; // variable para guardar la opcion elegida
        
        do{ // ciclo do - el codigo por lo menos se ejecuta una vez, mientras se cumpla la condicion al final de este bucle
            opcionElegida = MenuPrincipal(); // a la variable le asigno el valor obtenido del metodo MenuPrincipal
            switch(opcionElegida){ // verifico que opcion eligio el usuario
                case 1: // si eligio pilas
                    estructuraPilas();
                    break; // salir de esta opcion y del switch
                case 2: // si eligio colas
                    estructuraColas();
                    break; // salir de esta opcion y del switch
                case 3: // si eligio listas
                    estructuraListas();
                    break;  // salir de esta opcion y del switch 
                case 4: // SALIR DEL SISTEMA GENERAL (CERRAR APLICACION)
                    System.out.println(" -- GRACIAS POR USAR EL PROGRAMA --"); // mensaje
                    break; // salir de esta opcion y del switch
                default: // SI NO SE SELECCIONO UNA OPCION VALIDA
                    System.out.println("¡ERROR! ... DEBE ELEGIR UNA OPCION VALIDA"); // mensaje
                    break;  // salir de esta opcion y del switch              
            }
        }while(opcionElegida != 4);        
    }
}
