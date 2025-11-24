
package model;

import java.util.ArrayList;

/**
 *
 * @author PAUL
 * @param <T>
 */
public interface Comportamiento<T>{
    void agregar(T elemento);
    ArrayList<T> obtenerTodo();
}