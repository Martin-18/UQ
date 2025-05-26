package co.edu.uniquindio.poo.proyectofinal.Model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    private Usuario usuario;
    private List<Libro> librosPrestados;

    @BeforeEach
    void setUp() {
        librosPrestados = new ArrayList<>();
        usuario = new Usuario("Juan Pérez", 123, librosPrestados, 3, 15);
    }

    @Test
    void testValidarNombre() {

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> usuario.validarNombre("")
        );
    }

    @Test
    void testPuedePrestarMas() {
        assertTrue(usuario.puedePrestarMas());

        Libro libro1 = new Libro("Libro 1", "Autor 1", "Género 1", 2020, false);
        Libro libro2 = new Libro("Libro 2", "Autor 2", "Género 2", 2021, false);
        Libro libro3 = new Libro("Libro 3", "Autor 3", "Género 3", 2022, false);

        usuario.agregarLibroPrestado(libro1);
        assertTrue(usuario.puedePrestarMas());

        usuario.agregarLibroPrestado(libro2);
        assertTrue(usuario.puedePrestarMas());

        usuario.agregarLibroPrestado(libro3);
        assertFalse(usuario.puedePrestarMas());

    }

    @Test
    void testAgregarLibroPrestado() {
        Libro libro = new Libro("Nuevo Libro", "Autor", "Género", 2023, false);

        usuario.agregarLibroPrestado(libro);
        assertEquals(1, usuario.contarLibrosPrestados());
        assertTrue(libro.isPrestado());

        Libro libro2 = new Libro("Libro 2", "Autor 2", "Género 2", 2021, false);
        Libro libro3 = new Libro("Libro 3", "Autor 3", "Género 3", 2022, false);
        Libro libro4 = new Libro("Libro 4", "Autor 4", "Género 4", 2020, false);

        usuario.agregarLibroPrestado(libro2);
        usuario.agregarLibroPrestado(libro3);
        assertEquals(3, usuario.contarLibrosPrestados());

        usuario.agregarLibroPrestado(libro4);
        assertEquals(3, usuario.contarLibrosPrestados());
        assertFalse(libro4.isPrestado());
    }

    @Test
    void testDevolverLibro() {
        Libro libro = new Libro("Libro a Devolver", "Autor", "Género", 2023, false);
        usuario.agregarLibroPrestado(libro);

        assertEquals(1, usuario.contarLibrosPrestados());
        assertTrue(libro.isPrestado());

        assertTrue(usuario.devolverLibro(libro));
        assertEquals(0, usuario.contarLibrosPrestados());
        assertFalse(libro.isPrestado());
    }

    @Test
    void testContarLibrosPrestados() {
        assertEquals(0, usuario.contarLibrosPrestados());

        Libro libro1 = new Libro("Libro 1", "Autor 1", "Género 1", 2020, false);
        Libro libro2 = new Libro("Libro 2", "Autor 2", "Género 2", 2021, false);

        usuario.agregarLibroPrestado(libro1);
        assertEquals(1, usuario.contarLibrosPrestados());

        usuario.agregarLibroPrestado(libro2);
        assertEquals(2, usuario.contarLibrosPrestados());

        usuario.devolverLibro(libro1);
        assertEquals(1, usuario.contarLibrosPrestados());
    }

}