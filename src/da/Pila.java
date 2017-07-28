package da;

/**
 *
 * @author Johan Herrera
 * @param <T>
 */
public class Pila<T extends Comparable<T>> {

    private Nodo<T> cabeza;
    private Nodo<T> ultimo;
    private int size;

    public Pila() {
        this.cabeza = null;
        this.ultimo = null;
        this.size = 0;
    }

    public Nodo<T> getCabeza() {
        return cabeza;
    }

    public void setCabeza(Nodo<T> cabeza) {
        this.cabeza = cabeza;
    }

    public Nodo<T> getUltimo() {
        return ultimo;
    }

    public void setUltimo(Nodo<T> ultimo) {
        this.ultimo = ultimo;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return cabeza == null;
    }

    /**
     * <h1>Push</h1>
     * <p>
     * Agrega una persona a la pila. </p>
     *
     * @param nombre
     * @param apellido
     * @param apellido2
     * @param cedula
     * @param edad
     */
    public void push(String nombre, String apellido, String apellido2, String cedula, double edad) {
        if (!validarCedulaPasaporte(cedula)) {
            if (pasaporteCedula(cedula)) {
                cedula = cedula.toUpperCase();
            }
            Persona persona = new Persona(nombre, apellido, apellido2, cedula, edad);
            Nodo nuevo = new Nodo(persona);
            if (isEmpty()) {
                cabeza = nuevo;
                ultimo = nuevo;
            } else {
                ultimo.setSiguiente(nuevo);
                nuevo.setAnterior(ultimo);
                ultimo = nuevo;
            }
            nuevo.setPersona(persona);
            size++;
        }
    }

    /**
     * <h1>Pop</h1>
     * <p>
     * Remueve el ultimo nodo de la pila.</p>
     *
     * @return Nodo: con el ultimo nodo eliminado.
     */
    public Nodo pop() {
        if (!isEmpty()) {
            Nodo<T> aux = ultimo;
            ultimo = ultimo.getAnterior();
            size--;
            return aux;
        } else {
            return null;
        }
    }

    /**
     * <h1>Peek</h1>
     * <p>
     * Devuelve el ultimo nodo de la pila pero no lo remueve.</p>
     *
     * @return Nodo: Ultimo nodo de la pila.
     */
    public Nodo peek() {
        if (!isEmpty()) {
            return ultimo;
        } else {
            return null;
        }
    }

    /**
     * <h1>Validar Cedula Pasaporte</h1>
     * <p>
     * Comprueba si la Cedula o el Pasaporte introducido cumple con los
     * requerimientos necesarios.</p>
     *
     * @param documento
     * @return boolean: Con el resultado de la operacion.
     */
    public boolean validarCedulaPasaporte(String documento) {
        boolean bandera = false;
        Nodo aux = cabeza;
        int cont = 0;
        if ((documento.length() != 11 && documento.length() != 7) || (documento.length() == 7 && pasaporteFormato(documento)) || (documento.length() == 11 && cedulaFormato(documento))) {
            bandera = true;
            System.err.println("La Cedula debe incluir 11 digitos incluyendo los guiones,"
                    + " ademas de que no puede iniciar con 0 y el Pasaporte debe incluir una Letra y seis digitos.");
        }
        while (cont < size()) {
            if (aux.getPersona().getCedula().equals(documento)) {
                bandera = true;
                System.err.println("El pasaporte o Cedula introducido ya existe.");
                break;
            }
            cont++;
            aux = aux.getSiguiente();
        }
        return bandera;
    }

    /**
     * <h1>Pasaporte Formato</h1>
     * <p>
     * Verifica que el pasaporte cumpla con los requerimientos. Iniciar con una
     * letra y tener 6 numeros.</p>
     *
     * @param Pasaporte
     * @return boolean: con el resultado de la operacion.
     */
    public boolean pasaporteFormato(String Pasaporte) {
        boolean bandera = false;
        for (int i = 1; i < 7; i++) {
            if (Character.isLetter(Pasaporte.charAt(i))) {
                bandera = true;
            }
        }
        if (!Character.isLetter(Pasaporte.charAt(0))) {
            bandera = true;
        }
        return bandera;
    }

    /**
     * <h1>Cedula Formato</h1>
     * <p>
     * Verifica que la cedula cumpla con los requerimientos. Iniciar con un
     * numero que no puede ser 0. Seguido debe llevar un guion. Despues cuatro
     * numeros otro guion y otros cuatro numeros.</p>
     *
     * @param Cedula
     * @return boolean: con el resultado de la operacion.
     */
    public boolean cedulaFormato(String Cedula) {
        boolean bandera = false;
        for (int i = 2; i < 5; i++) {
            if (!Character.isDigit(Cedula.charAt(i))) {
                bandera = true;
            }
        }
        for (int i = 7; i < 11; i++) {
            if (!Character.isDigit(Cedula.charAt(i))) {
                bandera = true;
            }
        }
        if (!Character.isDigit(Cedula.charAt(0)) || Cedula.charAt(1) != '-' || Cedula.charAt(6) != '-' || Cedula.charAt(0) == '0') {
            bandera = true;
        }
        return bandera;
    }

    /**
     * <h1>Pasaporte Cedula</h1>
     * <p>
     * Comprueba si el documento introducido es un pasaporte o una cedula.</p>
     *
     * @param Documento
     * @return boolean: con el resultado.
     */
    public boolean pasaporteCedula(String Documento) {
        boolean bandera = false;
        if (abcMayus(Documento.charAt(0)) || abcMinus(Documento.charAt(0))) {
            bandera = true;
        }
        return bandera;
    }

    /**
     * <h1>AbcMayus</h1>
     * <p>
     * Verifica si el caracter introducido es una letra del abecedario en
     * Mayuscula. De ser asi significa que el numero entrante es un
     * Pasaporte.</p>
     *
     * @param letra
     * @return boolean: el resultado de la operacion.
     */
    public boolean abcMayus(char letra) {
        char a = (char) 65;
        boolean bandera = false;
        for (int i = 0; i < 26; i++) {
            if (a == letra) {
                bandera = true;
                break;
            } else {
                a = (char) (a + 1);
            }
        }
        return bandera;
    }

    /**
     * <h1>AbcMinus</h1>
     * <p>
     * Verifica si el caracter introducido es una letra del abecedario en
     * Minuscula. De ser asi significa que el numero entrante es un
     * Pasaporte.</p>
     *
     * @param letra
     * @return boolean: el resultado de la operacion.
     */
    public boolean abcMinus(char letra) {
        char a = (char) 97;
        boolean bandera = false;
        for (int i = 0; i < 26; i++) {
            if (a == letra) {
                bandera = true;
                break;
            } else {
                a = (char) (a + 1);
            }
        }
        return bandera;
    }

    @Override
    public String toString() {
        if (!isEmpty()) {
            StringBuilder builder = new StringBuilder();
            Nodo aux = cabeza;
            int cont = 0;
            while (cont < size) {
                builder.append(" - ").append(aux.getDato());
                builder.append("\n");
                aux = aux.getSiguiente();
                cont++;
            }
            return builder.toString();
        }
        return null;
    }
}
