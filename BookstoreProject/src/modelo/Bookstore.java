/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author mati
 */
public class Bookstore extends ArrayList<Book> {

    public Bookstore() {
    }

    public int getModCount() {
        return modCount;
    }

    public void setModCount(int modCount) {
        this.modCount = modCount;
    }

    public void imprimirBS() {
        System.out.println("Información bookstore");
        for (int i = 0; i < this.size(); i++) {
            System.out.println(this.get(i).toString());
        }

    }

    @Override
    public String toString() {
        return "Este bookstore tiene " + this.size() + " libros";
    }

}
