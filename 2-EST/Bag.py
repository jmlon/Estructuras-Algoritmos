#!/usr/bin/env python3
# -*- coding: utf-8 -*-

#-----------------------------------------------------------------------
# Bag.py
# An implementation of the Bag supported on a python list
#
# Author: Jorge Londoño
#-----------------------------------------------------------------------



class Bag:
    """Implementacion de un Bag por medio de una lista
    """
    
    # Constructor
    def __init__(self):
        """Constructor: Inicializa la variable de instancia como la lista vacia
        """
        self._datos = []

    
    def add(self, item):
        """Agrega un item a la bolsa
        """
        self._datos.append(item)


    def size(self):
        """Devuelve el numero de elementos en el Bag
        """
        return len(self._datos)


    def isEmpty(self):
        """Comprueba si el Bag se encuentra vacio
        """
        return self.size()==0

        
    # Iterador basado en el iterador de la lista 
    def __iter__(self):
        """Devuelve un iterador del Bag reutilizando el iterador del list
        """
        return iter(self._datos)



# Aplicacion cliente ejemplo
if __name__ == '__main__':

    # Crear una bolsa y agregar algunos items    
    bolsa = Bag();
    print("isEmpty = {0}".format(bolsa.isEmpty()))
    bolsa.add('Hola')
    bolsa.add('Mundo')
    print("size = {0}".format(bolsa.size()))
    print("isEmpty = {0}".format(bolsa.isEmpty()))

    # Iterar sobre los items de la bolsa
    for x in bolsa:
        print(x)

