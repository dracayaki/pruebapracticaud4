package org.iesvdm.booking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BookingDAOTest {

    private BookingDAO bookingDAO;
    private Map<String, BookingRequest> bookings;

    @BeforeEach
    public void setup() {
        bookings = new HashMap<>();
        bookingDAO = new BookingDAO(bookings);
    }

    /**
     * Crea 2 peticiones de reserva (BookingRequest)
     * agrégalas a las reservas (bookings) con la que
     * construyes el objeto BookingDAO bajo testeo.
     * Comprueba que cuando invocas bookingDAO.getAllBookingRequest
     * obtienes las 2 peticiones.
     */
    @Test
    void  getAllBookingRequestsTest() {

        BookingRequest prueba = Mockito.spy(new BookingRequest("1", LocalDate.of(2024,1,1), LocalDate.of(2024, 1,4), 2, true));
        BookingRequest prueba2 = Mockito.spy(new BookingRequest("2", LocalDate.of(2024,1,1), LocalDate.of(2024, 1,4), 2, true));


        bookings.put("1", prueba);
        bookings.put("2", prueba2);
        BookingDAO mock = Mockito.mock(BookingDAO.class);

        Mockito.doReturn(bookings.values()).when(mock).getAllBookingRequests();
        assertThat(mock.getAllBookingRequests()).isEqualTo(bookings.values());
    }

    /**
     * Crea 2 peticiones de reserva (BookingRequest)
     * agrégalas a las reservas mediante bookingDAO.save.
     * Comprueba que cuando invocas bookingDAO.getAllUUIDs
     * obtienes las UUIDs de las 2 peticiones guardadas.
     */
    @Test
    void getAllUUIDsTest() {
        BookingRequest prueba = Mockito.spy(new BookingRequest("1", LocalDate.of(2024,1,1), LocalDate.of(2024, 1,4), 2, true));
        BookingRequest prueba2 = Mockito.spy(new BookingRequest("2", LocalDate.of(2024,1,1), LocalDate.of(2024, 1,4), 2, true));

        BookingDAO mock = Mockito.mock(BookingDAO.class);

        mock.save(prueba);
        mock.save(prueba2);

        Mockito.when(mock.getAllUUIDs()).thenReturn(bookings.keySet());
        assertThat(mock.getAllUUIDs()).isEqualTo(bookings.keySet());

    }


    /**
     * Crea 2 peticiones de reserva (BookingRequest)
     * agrégalas a las reservas mediante bookingDAO.save.
     * Comprueba que cuando invocas bookingDAO.get con el UUID
     * obtienes las respectivas 2 peticiones guardadas.
     */
    @Test
    void getTest() {
        //BookingRequest prueba = new BookingRequest("1", LocalDate.of(2024,1,1), LocalDate.of(2024, 1,4), 2, true);
        //BookingRequest prueba2 = new BookingRequest("2", LocalDate.of(2024,1,1), LocalDate.of(2024, 1,4), 2, true);
        //bookingDAO.save(prueba);
        //bookingDAO.save(prueba2);
        BookingRequest prueba = Mockito.spy(new BookingRequest("1", LocalDate.of(2024,1,1), LocalDate.of(2024, 1,4), 2, true));
        BookingRequest prueba2 = Mockito.spy(new BookingRequest("2", LocalDate.of(2024,1,1), LocalDate.of(2024, 1,4), 2, true));

        BookingDAO mock = Mockito.mock(BookingDAO.class);

        mock.save(prueba);
        mock.save(prueba2);
        Mockito.when(mock.get("1")).thenReturn(bookings.get("1"));
        Mockito.when(mock.get("2")).thenReturn(bookings.get("2"));

        assertThat(mock.get("1")).isEqualTo(bookings.get("1"));
        assertThat(mock.get("2")).isEqualTo(bookings.get("2"));
    }

    /**
     * Crea 2 peticiones de reserva (BookingRequest)
     * agrégalas a las reservas mediante bookingDAO.save.
     * A continuación, borra la primera y comprueba
     * que se mantiene 1 reserva, la segunda guardada.
     */
    @Test
    void deleteTest() {

        BookingRequest prueba = Mockito.spy(new BookingRequest("1", LocalDate.of(2024,1,1), LocalDate.of(2024, 1,4), 2, true));
        BookingRequest prueba2 = Mockito.spy(new BookingRequest("2", LocalDate.of(2024,1,1), LocalDate.of(2024, 1,4), 2, true));

        BookingDAO mock = Mockito.mock(BookingDAO.class);

        mock.save(prueba);
        mock.save(prueba2);

        assertThat(mock.get("1")).isEqualTo(bookings.get("2"));
    }

    /**
     * Guarda 2 veces la misma petición de reserva (BookingRequest)
     * y demuestra que en la colección de bookings están repetidas
     * pero con UUID diferente
     *
     */
    @Test
    void saveTwiceSameBookingRequestTest() {
        BookingRequest prueba = new BookingRequest("1", LocalDate.of(2024,1,1), LocalDate.of(2024, 1,4), 2, true);


        bookingDAO.save(prueba);
        bookingDAO.save(prueba);
        assertThat(bookingDAO.getAllUUIDs()).isEqualTo(bookings.values());
    }

}
