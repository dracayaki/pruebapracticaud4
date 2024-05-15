package org.iesvdm.reservamesa;

//import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ReservaMesaTest {






    /*@Test
    void checkGetMesa(){
        ReservaMesa mock = Mockito.mock(ReservaMesa.class);

        assertThat(mock.getMesas()).
    }
*/
    @Test
    void checkSetMesa(){
        ReservaMesa prueba = new ReservaMesa();
        int[] array = {1, 2, 3};

        prueba.setMesas(array);
        prueba.imprimir();
        assertThat(prueba.getMesas()).isEqualTo(array);

    }


    @Test
    void checkTamanioMesa(){
        ReservaMesa prueba = new ReservaMesa();
        int[] array = {1, 2, 3};
        prueba.setTamanioMesa(5);

        assertThat(prueba.getTamanioMesa()).isEqualTo(5);
    }

   /* @Test
    void checkRellenarMesas(){
        ReservaMesa prueba = new ReservaMesa();

        int[] array = {1, 2, 3};
        prueba.setMesas(array);
        prueba.setTamanioMesa(5);

       prueba.rellenarMesas();
       prueba.imprimir();
       */


    @Test
    void chekcBuscarMesa(){
        ReservaMesa prueba = new ReservaMesa();

        int[] array = {0, 2, 3, 4};
        prueba.setMesas(array);
        prueba.setTamanioMesa(7);
        prueba.imprimir();
        assertThat(prueba.buscarPrimeraMesaVacia()).isEqualTo(0);
    }


    @Test
    void checkMesaCompartir(){
        ReservaMesa prueba = new ReservaMesa();

        int[] array = {7, 4, 1, 7};
        prueba.setMesas(array);
        prueba.setTamanioMesa(7);
        prueba.imprimir();

        assertThat(prueba.buscarMesaParaCompartir(2)).isEqualTo(1);
    }

    @Test
    void checkBuscarMesaCercana(){
        ReservaMesa prueba = new ReservaMesa();
        prueba.setTamanioMesa(3);
        int[] array = {1, 1, 3, 3};
        prueba.setMesas(array);

        prueba.imprimir();
        assertThat(prueba.buscarMesaCompartirMasCercaDe(2, 1)).isEqualTo(1);

    }

    @Test
    void checkMesaAlejada(){
        ReservaMesa prueba = new ReservaMesa();
        prueba.setTamanioMesa(3);
        int[] array = {1, 1, 3, 3};
        prueba.setMesas(array);

        prueba.imprimir();
        assertThat(prueba.buscarMesaCompartirMasAlejadaDe(2, 1)).isEqualTo(0);

    }

    @Test
    void checkMesaConsecutivaFail(){
        ReservaMesa prueba = new ReservaMesa();
        prueba.setTamanioMesa(3);
        int[] array = {3, 3, 3, 1};
        prueba.setMesas(array);

        prueba.imprimir();
        assertThat(prueba.buscarCompartirNMesasConsecutivas(3,2)).isEqualTo(-1);
    }

    @Test
    void checkComenTotal(){
        ReservaMesa prueba = new ReservaMesa();
        prueba.setTamanioMesa(3);
        int[] array = {3, 3, 3, 1};
        prueba.setMesas(array);
        prueba.imprimir();
        assertThat(prueba.comensalesTotales()).isEqualTo(10);

    }



}
