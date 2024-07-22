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
public class NodoDoble { 
    //Atributos
    int dato;
    NodoDoble enlaceIzq;
    NodoDoble enlaceDer;

    public NodoDoble(int dato, NodoDoble enlaceIzq, NodoDoble enlaceDer) {
        this.dato = dato;
        this.enlaceIzq = enlaceIzq;
        this.enlaceDer = enlaceDer;
    }

    public NodoDoble() {
      this.enlaceIzq = null;
      this.enlaceDer = null;   
    }
    
    public NodoDoble(int dato) {
        this.dato = dato;
        this.enlaceIzq = null;
        this.enlaceDer = null;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public void setEnlaceDer(NodoDoble enlaceDer) {
        this.enlaceDer = enlaceDer;
    }

    public void setEnlaceIzq(NodoDoble enlaceIzq) {
        this.enlaceIzq = enlaceIzq;
    }

    public int getDato() {
        return dato;
    }

    public NodoDoble getEnlaceDer() {
        return enlaceDer;
    }

    public NodoDoble getEnlaceIzq() {
        return enlaceIzq;
    }
/*
    @Override
    public String toString() {
         return  "<-"+dato+"->";
    }*/
    @Override
    public String toString(){
      String s="[|dato=";
      s=s+getDato();
      return s+"|]";
    }
    public static void main(String[] args) {
        NodoDoble p = new NodoDoble();
        p.setDato(5);
        System.out.println(p.toString());

        NodoDoble q = new NodoDoble(10);
        System.out.println(q.toString());

        NodoDoble r = new NodoDoble(15, p, q);
        System.out.println(r.toString());

        // Enlazando nodos
        p.setEnlaceDer(q);
        q.setEnlaceIzq(p);
        q.setEnlaceDer(r);
        r.setEnlaceIzq(q);

        System.out.println(p.toString() + "->" + p.getEnlaceDer());
        System.out.println(q.toString() + "->" + q.getEnlaceDer() + "<-" + q.getEnlaceIzq());
        System.out.println(r.toString() + "<-" + r.getEnlaceIzq());
    }
}
