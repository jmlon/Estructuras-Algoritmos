#!/usr/bin/env python3
# -*- coding: utf-8 -*-


class Contador:
    '''Implementacion del ADT Contador como una clase en Python
    '''

    def __init__(self, id):
        self._id = id
        self._conteo = 0

    def incrementar(self):
        self._conteo += 1

    def getConteo(self):
        return self._conteo

    def getId(self):
        return self._id


# Prueba unitaria del ADT Contador
if __name__ == '__main__':
    a = Contador('prueba')
    a.incrementar()
    a.incrementar()
    assert a.getConteo() == 2
    assert a.getId() == 'prueba'
