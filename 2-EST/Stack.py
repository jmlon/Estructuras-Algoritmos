#!/usr/bin/env python3
# -*- coding: utf-8 -*-

#-----------------------------------------------------------------------
# Stack.py
# An implementation of the Stack supported on a python list
#
# Author: Jorge Londoño
#-----------------------------------------------------------------------


class Stack:
    """Implementacion de un Stack por medio de una lista
    """
    
    # Constructor
    def __init__(self):
        """Constructor: Inicializa la variable de instancia como la lista vacia
        """
        self._datos = []

    
    def push(self, item):
        """Agrega un item en el tope del Stack
        """
        self._datos.append(item)


    def pop(self):
        """Obtiene el ultimo item agregado al Stack
        """
        return self._datos.pop()
        

    def size(self):
        """Devuelve el numero de elementos en el Stack
        """
        return len(self._datos)


    def isEmpty(self):
        """Comprueba si el Stack esta vacio
        """
        return self.size()==0


    def __iter__(self):
        """Devuelve un iterador en orden inverso para la lista
        """
        self._pos = self.size()
        return self


    def __next__(self):
        """Devuelve el siguiente item del iterador
        """
        if self._pos>0:
            self._pos = self._pos-1
            return self._datos[self._pos]
        else:
            raise StopIteration()


# Aplicacion cliente
if __name__ == '__main__':

    pila = Stack()
    print("isEmpty = {0}".format(pila.isEmpty()))
    pila.push(1)
    pila.push(3)
    pila.push(5)
    print("size = {0}".format(pila.size()))
    print("isEmpty = {0}".format(pila.isEmpty()))
    
    
    # Iterar sobre los items del Stack
    for x in pila:
        print(x)
    


