#!/usr/bin/env python3
# -*- coding: utf-8 -*-


#-----------------------------------------------------------------------
# Queue.py
# An implementation of the Queue supported on a python list
#
# Author: Jorge Londoño
#-----------------------------------------------------------------------


class Queue:
    """Implementacion de un Queue por medio de una lista
    """
    
    # Constructor
    def __init__(self):
        """Constructor: Inicializa la variable de instancia como la lista vacia
        """
        self._datos = []

    
    def enqueue(self, item):
        """Agrega un item al final del Queue
        """
        self._datos.append(item)


    def dequeue(self):
        """Obtiene el item al principio del Queue
        """
        item = self._datos[0]
        self._datos = self._datos[1:]
        return item
        

    def size(self):
        """Devuelve el numero de elementos en el Queue
        """
        return len(self._datos)


    def isEmpty(self):
        """Comprueba si la Cola esta vacia
        """
        return self.size()==0


    def __iter__(self):
        """Devuelve un iterador en orden FIFO para el Queue.
        Reutiliza el iterador de la lista
        """
        return iter(self._datos)



# Aplicacion cliente
if __name__ == '__main__':

    cola = Queue()
    print("isEmpty = {0}".format(cola.isEmpty()))
    cola.enqueue(1)
    cola.enqueue(3)
    cola.enqueue(5)
    print("size = {0}".format(cola.size()))
    print("isEmpty = {0}".format(cola.isEmpty()))
    print("dequeue = {0} ,  size = {1}".format(cola.dequeue(), cola.size()))
    
    
    # Iterar sobre los items del Queue
    for x in cola:
        print(x)
    


