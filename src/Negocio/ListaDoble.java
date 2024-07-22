/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author fernando EL 23
 */
public class ListaDoble {
    // Atributos

    NodoDoble inicio;
    NodoDoble fin;
    int cantidad;

    // Constructor
    public ListaDoble() {
        this.inicio = null;
        this.fin = null;
        this.cantidad = 0;
    }
    // Método para verificar si la lista está vacía

    public boolean vacia() {
        return cantidad == 0;
    }

    // Método para insertar un nodo en la lista de manera ordenada
    public void insertar(int elemento) {
        NodoDoble nuevo = new NodoDoble(elemento);
        if (vacia()) {
            inicio = fin = nuevo;
        } else {
            NodoDoble aux = inicio;
            while (aux != null && aux.getDato() < elemento) {
                aux = aux.getEnlaceDer();
            }
            if (aux == inicio) {
                if (aux.getDato() != elemento) {
                    nuevo.setEnlaceDer(inicio);
                    inicio.setEnlaceIzq(nuevo);
                    inicio = nuevo;
                }
            } else if (aux != null) {
                if (aux.getDato() != elemento) {
                    nuevo.setEnlaceDer(aux);
                    nuevo.setEnlaceIzq(aux.getEnlaceIzq());
                    aux.getEnlaceIzq().setEnlaceDer(nuevo);
                    aux.setEnlaceIzq(nuevo);
                }
            } else {
                fin.setEnlaceDer(nuevo);
                nuevo.setEnlaceIzq(fin);
                fin = nuevo;
            }
        }
        cantidad++;
    }

    // Método para eliminar un nodo de la lista
    public void eliminar(int elemento) {
        if (!vacia()) {
            NodoDoble aux = inicio;
            while (aux != null && aux.getDato() != elemento) {
                aux = aux.getEnlaceDer();
            }
            if (aux != null) {
                if (aux == inicio) {
                    inicio = aux.getEnlaceDer();
                    if (inicio != null) {
                        inicio.setEnlaceIzq(null);
                    } else {
                        fin = null;
                    }
                } else if (aux == fin) {
                    fin = aux.getEnlaceIzq();
                    if (fin != null) {
                        fin.setEnlaceDer(null);
                    } else {
                        inicio = null;
                    }
                } else {
                    aux.getEnlaceIzq().setEnlaceDer(aux.getEnlaceDer());
                    aux.getEnlaceDer().setEnlaceIzq(aux.getEnlaceIzq());
                }
                cantidad--;
            }
        }
    }

    // Método para verificar si un elemento existe en la lista
    public boolean existe(int elemento) {
        NodoDoble aux = inicio;
        while (aux != null && aux.getDato() != elemento) {
            aux = aux.getEnlaceDer();
        }
        return aux != null;
    }

    public void Insertarinicio(int elemento) {// inserta un nodo en el inicio
        NodoDoble nuevo = new NodoDoble(elemento);
        if (vacia()) {
            inicio = fin = nuevo;
        } else {
            nuevo.setEnlaceDer(inicio);
            inicio.setEnlaceIzq(nuevo);
            inicio = nuevo;
        }
        cantidad++;
    }

    public void Insertarfin(int elemento) {//inserta un nodo en el fin
        NodoDoble nuevo = new NodoDoble(elemento);
        if (vacia()) {
            inicio = fin = nuevo;
        } else {
            fin.setEnlaceDer(nuevo);
            nuevo.setEnlaceIzq(fin);
            fin = nuevo;
        }
        cantidad++;
    }

    public void Insertarporfin(int ele) {
    } // inserta un nodo por el final

    // Método para invertir la lista en pares
    public void invertira2() {
        if (vacia() || inicio.getEnlaceDer() == null) {
            return;
        }
        NodoDoble ant = null;
        NodoDoble aux = inicio;
        NodoDoble pos = inicio.getEnlaceDer();//aux.getEnlaceDer();
        //Recorrer

        while (pos != null) {
            aux.setEnlaceDer(pos.getEnlaceDer());
            pos.setEnlaceDer(aux);
            if (aux.getEnlaceDer() != null) {
                aux.getEnlaceDer().setEnlaceIzq(aux);
            }
            pos.setEnlaceIzq(aux.getEnlaceIzq());
            aux.setEnlaceIzq(pos);
            if (pos.getEnlaceIzq() != null) {
                ant.setEnlaceDer(pos);
            } else {
                inicio = pos;
            }
            ant = aux;
            aux = aux.getEnlaceDer();
            if (aux != null) {
                pos = aux.getEnlaceDer();
            } else {
                pos = null;
            }
        }

    }

    // Método para invertir la lista en pares
    public void invertir2() {
        if (!vacia() || inicio.getEnlaceDer() != null) {
            NodoDoble ant = null;
            NodoDoble aux = inicio;
            NodoDoble pos = aux.getEnlaceDer();
            NodoDoble sig = null;
            //Recorrer

            while (pos != null) {
                sig = pos.getEnlaceDer();
                aux.setEnlaceDer(sig);
                pos.setEnlaceDer(aux);
                if (aux.getEnlaceDer() != null) {
                    aux.getEnlaceDer().setEnlaceIzq(aux);
                }
                pos.setEnlaceIzq(aux.getEnlaceIzq());
                aux.setEnlaceIzq(pos);
                if (pos.getEnlaceIzq() != null) {
                    pos.getEnlaceIzq().setEnlaceDer(pos);
                } else {
                    inicio = pos;
                }
                ant = aux;
                aux = aux.getEnlaceDer();
                if (aux != null) {
                    pos = aux.getEnlaceDer();
                } else {
                    pos = null;
                }
            }
        }
    }

    @Override
    public String toString() {
        String S = "Inicio";
        NodoDoble Aux = inicio;
        while (Aux != null) {
            S = S + ">[" + Aux.dato + "]<=";
            Aux = Aux.getEnlaceDer();
        }
        S = S + "Fin";
        return S;
    }

    // Método principal para pruebas
    public static void main(String[] args) {
        ListaDoble L = new ListaDoble();
        L.insertar(1);
        L.insertar(2);
        L.insertar(3);
        L.insertar(4);
        L.insertar(5);
        System.out.println(L.toString());
        L.invertir2();
        System.out.println(L.toString());
        /* L.eliminar(2);
        System.out.println(L.toString());

        L.eliminar(5);
        System.out.println(L.toString());*/
    }

}
