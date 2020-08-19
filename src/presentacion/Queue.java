
package presentacion;

/**
 *
 * @author Dany
 */

// CLASE PRINCIPAL
class Queue{
    // ATRIBUTOS
    private final String cola[];  // arreglo para los elementos
    private int frente;		  // apuntador al frente - apunta al elemento de en frente de la cola (si hay alguno)
    private int posterior;	  // apunta al ultimo elemento de la cola
    private final int CAPACIDAD;  // capacidad maxima de la cola
    private int cantidad;	  // tamaño actual de la cola
	
    // CONSTRUCTOR PARA INICIALIZAR LOS ELEMENTOS
    Queue(int tamanio){
        // inicializo todos los elementos
        cola = new String[tamanio]; 
        CAPACIDAD = tamanio; 
        frente = 0;
        posterior = -1;
        cantidad = 0;
    }

    // METODO PARA ELIMINAR ELEMENTOS DEL FRENTE (DE LA COLA)
    public void poll(){
        if (isEmpty()){ // si la cola esta vacia
            System.out.println("NO HAY PERSONAS PARA ATENDER."); // mando mensaje            
        }else{ // sino esta vacia
          System.out.println(cola[frente] + ", PASE PARA SER ATENDIDO."); // mando mensaje indicando quien sera atendido (salir)
        frente = (frente + 1) % CAPACIDAD; // elimino quien este al frente
        cantidad--; // reduzco la cantidad de elementos existentes
        }
        
    }

    // METODO PARA AÑADIR ELEMENTOS A LA COLA
    public void offer(String item){ // paso por parametro el elemento a insertar
        if (isFull()){ // si la cola esta llena
            System.out.println("SE HAN REPARTIDO TODOS LOS BOLETOS DE ATENCIÓN."); // mando mensaje
        }    
        posterior = (posterior + 1) % CAPACIDAD; // ingreso el elemento a la cola ( por el inicio)
        cola[posterior] = item; // añado el elemento a la cola 
        cantidad++; // aumento 1 a la cantidad de elementos
    }

    // METODO PARA DEVOLVER EL PRIMER ELEMENTO, ES DECIR, EL DE LA CIMA Y EL QUE SALE PRIMERO
    public String peek(){
        if (isEmpty()){ // si la cola esta vacia
            System.out.println("NO HAY PERSONAS EN ESPERA"); // mensaje
            return cola[frente]; 
        } // si no
        System.out.println("\nLA SIGUIENTE PERSONA EN ATENDER SERA: " + cola[frente]); // mensaje mostrando siguiente persona en atender/salir
        return cola[frente];
    }

    // METODO QUE REGRESA EL TAMAÑO DE LA COLA
    public int size(){
        return cantidad; // regreso el tamaño de la cola
    }

    // METODO PARA VERIFICAR SI LA COLA ETA VACIA
    public Boolean isEmpty(){
        return (size() == 0); // verdadero si esta vacia ( tamaño sea igual a 0)
    }

    // METODO PARA SABER SI LA COLA ESTA LLENA
    public Boolean isFull(){
        return (size() == CAPACIDAD); // verdadero si tamaño es igual a capacidad, es decor si ya se lleno
    }		
}
