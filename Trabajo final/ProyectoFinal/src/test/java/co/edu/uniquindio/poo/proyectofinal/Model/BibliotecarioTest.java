package co.edu.uniquindio.poo.proyectofinal.Model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BibliotecarioTest {

    private Bibliotecario bibliotecario;
    private Libro libro1, libro2, libro3;
    private Usuario usuario1, usuario2;

    @BeforeEach
    void setUp() {
        bibliotecario = new Bibliotecario("Ana García", 101);

        libro1 = new Libro("El Quijote", "Cervantes", "Novela", 1605, false);
        libro2 = new Libro("Cien Años de Soledad", "García Márquez", "Realismo Mágico", 1967, false);
        libro3 = new Libro("1984", "George Orwell", "Distopía", 1949, false);

        usuario1 = new Usuario("Juan Pérez", 123, new ArrayList<>(), 3, 15);
        usuario2 = new Usuario("María López", 456, new ArrayList<>(), 2, 10);
    }

    @Test
    void testAgregarLibro() {
        bibliotecario.agregarLibro(libro1);

        List<Libro> libros = bibliotecario.getLibros();
        assertEquals(1, libros.size());
        assertEquals("El Quijote", libros.get(0).getTitulo());

        bibliotecario.agregarLibro(libro2);
        bibliotecario.agregarLibro(libro3);
        assertEquals(3, libros.size());
    }

    @Test
    void testAgregarUsuario() {
        bibliotecario.agregarUsuario(usuario1);

        List<Usuario> usuarios = bibliotecario.getUsuarios();
        assertEquals(1, usuarios.size());
        assertEquals("Juan Pérez", usuarios.get(0).getNombre());

        bibliotecario.agregarUsuario(usuario2);
        assertEquals(2, usuarios.size());
    }

    @Test
    void testBuscarUsuarioPorId() {
        bibliotecario.agregarUsuario(usuario1);
        bibliotecario.agregarUsuario(usuario2);

        Usuario encontrado = bibliotecario.buscarUsuarioPorId(123);
        assertEquals("Juan Pérez", encontrado.getNombre());

        Usuario encontrado2 = bibliotecario.buscarUsuarioPorId(456);
        assertEquals("María López", encontrado2.getNombre());

    }

    @Test
    void testBuscarLibroPorTitulo() {
        bibliotecario.agregarLibro(libro1);
        bibliotecario.agregarLibro(libro2);

        Libro encontrado = bibliotecario.buscarLibroPorTitulo("El Quijote");
        assertEquals("Cervantes", encontrado.getAutor());

        Libro encontrado2 = bibliotecario.buscarLibroPorTitulo("Cien Años de Soledad");
        assertEquals("García Márquez", encontrado2.getAutor());

    }

    @Test
    void testRealizarPrestamo() {
        bibliotecario.agregarLibro(libro1);
        bibliotecario.agregarUsuario(usuario1);

        assertTrue(bibliotecario.realizarPrestamo(123, "El Quijote"));
        assertTrue(libro1.isPrestado());
        assertEquals(1, usuario1.contarLibrosPrestados());

        assertFalse(bibliotecario.realizarPrestamo(456, "El Quijote"));
    }

    @Test
    void testDevolverLibro() {
        bibliotecario.agregarLibro(libro1);
        bibliotecario.agregarUsuario(usuario1);
        bibliotecario.realizarPrestamo(123, "El Quijote");

        assertTrue(libro1.isPrestado());
        assertEquals(1, usuario1.contarLibrosPrestados());

        assertTrue(bibliotecario.devolverLibro(123, "El Quijote"));
        assertFalse(libro1.isPrestado());
        assertEquals(0, usuario1.contarLibrosPrestados());
    }

    @Test
    void testLibroDisponible() {
        bibliotecario.agregarLibro(libro1);
        bibliotecario.agregarLibro(libro2);

        assertTrue(bibliotecario.libroDisponible("El Quijote"));
    }

    @Test
    void testReporteLibrosPrestados() {
        String[] reporte = bibliotecario.reporteLibrosPrestados();
        assertEquals(0, reporte.length);

        bibliotecario.agregarLibro(libro1);
        bibliotecario.agregarLibro(libro2);
        bibliotecario.agregarLibro(libro3);
        bibliotecario.agregarUsuario(usuario1);
        bibliotecario.agregarUsuario(usuario2);

        bibliotecario.realizarPrestamo(123, "El Quijote");
        bibliotecario.realizarPrestamo(456, "1984");
    }

    @Test
    void testReporteUsuariosConPrestamos() {
        assertEquals(0, bibliotecario.reporteUsuariosConPrestamos());

        bibliotecario.agregarUsuario(usuario1);
        bibliotecario.agregarUsuario(usuario2);
        bibliotecario.agregarLibro(libro1);
        bibliotecario.agregarLibro(libro2);

        bibliotecario.realizarPrestamo(123, "El Quijote");
        assertEquals(1, bibliotecario.reporteUsuariosConPrestamos());

        bibliotecario.realizarPrestamo(456, "Cien Años de Soledad");
        assertEquals(2, bibliotecario.reporteUsuariosConPrestamos());
    }

    @Test
    void testObtenerPrestamosUsuario() {
        String[] prestamosInexistente = bibliotecario.obtenerPrestamosUsuario(999);
        assertEquals(0, prestamosInexistente.length);

        bibliotecario.agregarUsuario(usuario1);
        String[] prestamosSinLibros = bibliotecario.obtenerPrestamosUsuario(123);
        assertEquals(0, prestamosSinLibros.length);

        bibliotecario.agregarLibro(libro1);
        bibliotecario.agregarLibro(libro2);
        bibliotecario.realizarPrestamo(123, "El Quijote");
        bibliotecario.realizarPrestamo(123, "Cien Años de Soledad");

    }
}