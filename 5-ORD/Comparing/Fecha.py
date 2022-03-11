# Sobrecarga de los metodos de "Rich Comparison"
# Documentacion: https://docs.python.org/3/reference/datamodel.html#basic-customization


class Fecha:

    def __init__(self, año, mes, dia):
        self._año = año
        self._mes = mes
        self._dia = dia

    def __str__(self):
        return str(self._año)+"/"+str(self._mes)+"/"+str(self._dia)

    def __lt__(self, f):
        # print(f"Comparando {str(self)} con {str(f)}")
        if self._año != f._año:
            return self._año < f._año
        if self._mes != f._mes:
            return self._mes < f._mes
        return self._dia < f._dia


# Pruebas unitarias
if __name__=="__main__":
    f1 = Fecha(2020, 3, 17)
    f2 = Fecha(2020, 3, 16)
    f3 = Fecha(2020, 4, 17)
    f4 = Fecha(2020, 3, 17)
    f5 = Fecha(2021, 4, 17)

    assert not(f1<f2), "f1 no debe ser menor que f2"
    assert f2<f1, "f2 debe ser menor que f1"
    assert f1<f3, "f1 debe ser menor que f3"
    assert not(f1<f4), "f1 no debe ser menor que f4"
    assert f3<f5, "f3 debe ser menor que f5"
