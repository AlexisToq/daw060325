import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GestorTiendaTest {
    private GestorTienda gestor;

    @BeforeEach
    void setUp() {
        gestor = new GestorTienda();
    }

    // Pruebas para calcularDescuento
    @Test
    void testCalcularDescuento_10Productos() {
        double descuento = gestor.calcularDescuento(100, 10);
        assertEquals(10, descuento, "Debe aplicar un 10% de descuento para 10 o más productos");
    }

    @Test
    void testCalcularDescuento_5Productos() {
        double descuento = gestor.calcularDescuento(100, 5);
        assertEquals(5, descuento, "Debe aplicar un 5% de descuento para 5 a 9 productos");
    }

    @Test
    void testCalcularDescuento_MenosDe5Productos() {
        double descuento = gestor.calcularDescuento(100, 4);
        assertEquals(0, descuento, "No debe aplicar descuento para menos de 5 productos");
    }

    // Pruebas para categorizarProducto
    @Test
    void testCategorizarProducto_Economico() {
        assertEquals("Económico", gestor.categorizarProducto(9.99), "Debe ser Económico si el precio es menor a 10");
    }

    @Test
    void testCategorizarProducto_Estandar() {
        assertEquals("Estándar", gestor.categorizarProducto(20), "Debe ser Estándar si el precio está entre 10 y 49.99");
    }

    @Test
    void testCategorizarProducto_Premium() {
        assertEquals("Premium", gestor.categorizarProducto(50), "Debe ser Premium si el precio es 50 o más");
    }

    // Pruebas para buscarProducto
    @Test
    void testBuscarProducto_Encontrado() {
        String[] inventario = {"Manzana", "Banana", "Cereza"};
        assertEquals("Banana", gestor.buscarProducto(inventario, "banana"), "Debe encontrar el producto ignorando mayúsculas");
    }

    @Test
    void testBuscarProducto_NoEncontrado() {
        String[] inventario = {"Manzana", "Banana", "Cereza"};
        assertNull(gestor.buscarProducto(inventario, "Mango"), "Debe devolver null si el producto no está en el inventario");
    }

    @Test
    void testBuscarProducto_InventarioVacio() {
        String[] inventario = {};
        assertNull(gestor.buscarProducto(inventario, "Manzana"), "Debe devolver null si el inventario está vacío");
    }
}

