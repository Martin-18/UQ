package co.edu.uniquindio.poo.proyectofinal.Model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class AdministradorTest {

    private Administrador administrador;
    private Bibliotecario bibliotecario1, bibliotecario2;

    @BeforeEach
    void setUp() {
        administrador = new Administrador("Carlos Rodríguez", 001);
        bibliotecario1 = new Bibliotecario("Ana García", 101);
        bibliotecario2 = new Bibliotecario("Luis Martín", 102);
    }

    @Test
    void testRegistrarEmpleado() {

        administrador.registrarEmpleado(bibliotecario1);
        assertEquals(1, administrador.getEmpleados().size());
        assertEquals("Ana García", administrador.getEmpleados().get(0).getNombre());

        administrador.registrarEmpleado(bibliotecario2);
        assertEquals(2, administrador.getEmpleados().size());
        assertEquals("Luis Martín", administrador.getEmpleados().get(1).getNombre());
    }

    @Test
    void testEliminarEmpleado() {
        administrador.registrarEmpleado(bibliotecario1);
        administrador.registrarEmpleado(bibliotecario2);
        assertEquals(2, administrador.getEmpleados().size());

        administrador.eliminarEmpleado(bibliotecario1);
        assertEquals(1, administrador.getEmpleados().size());
        assertEquals("Luis Martín", administrador.getEmpleados().get(0).getNombre());

        administrador.eliminarEmpleado(bibliotecario2);
        assertEquals(0, administrador.getEmpleados().size());

    }

    @Test
    void testAgregarCredencial() {
        assertTrue(administrador.agregarCredencial("admin", "password123"));
        assertEquals(1, administrador.getCredenciales().size());
        assertEquals("admin:password123", administrador.getCredenciales().get(0));

        assertTrue(administrador.agregarCredencial("user1", "pass456"));
        assertTrue(administrador.agregarCredencial("user2", "mypass789"));
        assertEquals(3, administrador.getCredenciales().size());

        assertFalse(administrador.agregarCredencial(null, "password"));
        assertFalse(administrador.agregarCredencial("user", null));
        assertFalse(administrador.agregarCredencial("", "password"));
        assertFalse(administrador.agregarCredencial("user", ""));
        assertFalse(administrador.agregarCredencial("   ", "password"));
        assertFalse(administrador.agregarCredencial("user", "   "));

    }

    @Test
    void testValidarCredenciales() {
        administrador.agregarCredencial("admin", "admin123");
        administrador.agregarCredencial("bibliotecario", "biblio456");
        administrador.agregarCredencial("usuario", "user789");

        assertTrue(administrador.validarCredenciales("admin", "admin123"));
        assertTrue(administrador.validarCredenciales("bibliotecario", "biblio456"));
        assertTrue(administrador.validarCredenciales("usuario", "user789"));

        assertFalse(administrador.validarCredenciales("admin", "wrongpass"));
        assertFalse(administrador.validarCredenciales("wronguser", "admin123"));
        assertFalse(administrador.validarCredenciales("admin", ""));
        assertFalse(administrador.validarCredenciales("", "admin123"));

    }

    @Test
    void testGenerarReporteUsoSistema() {
        Biblioteca biblioteca = new Biblioteca("UQ",12);

        administrador.registrarEmpleado(bibliotecario1);
        administrador.registrarEmpleado(bibliotecario2);
        administrador.agregarCredencial("admin", "pass1");
        administrador.agregarCredencial("user", "pass2");

        String reporte = administrador.generarReporteUsoSistema(biblioteca);

        assertNotNull(reporte);
        assertTrue(reporte.contains("=== REPORTE DE USO DEL SISTEMA ==="));
        assertTrue(reporte.contains("Empleados registrados: 2"));
        assertTrue(reporte.contains("Credenciales activas: 2"));
        assertTrue(reporte.contains("Porcentaje de uso de libros:"));
        assertTrue(reporte.contains("Fecha del reporte:"));

    }
}