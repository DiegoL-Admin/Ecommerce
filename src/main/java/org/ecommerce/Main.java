package org.ecommerce;

import org.ecommerce.Model.*;
import org.ecommerce.Service.*;
import org.ecommerce.Payment.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Servicios
        UserService userService = new UserService();
        ProductService productService = new ProductService();
        CartService cartService = new CartService();

        // Inventarios
        InventoryManager inventarioFisico = new PhysicalInventory();
        InventoryManager inventarioDigital = new DigitalInventory();

        boolean running = true;
        User usuarioLogeado = null;

        // Menú principal
        while (running) {
            System.out.println("\n========= 🛒 E-COMMERCE SYSTEM =========");
            System.out.println("1️⃣ - Registrar nuevo usuario");
            System.out.println("2️⃣ - Iniciar sesión");
            System.out.println("3️⃣ - Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    registrarUsuario(sc, userService);
                    break;
                case 2:
                    usuarioLogeado = iniciarSesion(sc, userService);
                    if (usuarioLogeado != null) {
                        if (usuarioLogeado instanceof Administrator) {
                            menuAdministrador(sc, productService, inventarioFisico, inventarioDigital);
                        } else if (usuarioLogeado instanceof Client) {
                            menuCliente(sc, productService, cartService, (Client) usuarioLogeado);
                        }
                    } else {
                        System.out.println("❌ Usuario o contraseña incorrectos.");
                    }
                    break;
                case 3:
                    running = false;
                    System.out.println("👋 ¡Gracias por usar la tienda!");
                    break;
                default:
                    System.out.println("⚠️ Opción no válida.");
            }
        }

        sc.close();
    }

    // 🧑‍💻 Registro de usuario
    private static void registrarUsuario(Scanner sc, UserService userService) {
        System.out.print("Ingrese nombre de usuario: ");
        String username = sc.nextLine();
        System.out.print("Ingrese contraseña: ");
        String password = sc.nextLine();

        System.out.println("Seleccione tipo de usuario:");
        System.out.println("1️⃣ - Cliente");
        System.out.println("2️⃣ - Administrador");
        int tipo = sc.nextInt();
        sc.nextLine();

        if (tipo == 1) {
            userService.registerClient(username, "", password, "", "", false);
            System.out.println("✅ Cliente registrado con éxito.");
        } else if (tipo == 2) {
            userService.registerAdmin(username, "", password, "manager", "general");
            System.out.println("✅ Administrador registrado con éxito.");
        } else {
            System.out.println("⚠️ Tipo no válido.");
        }
    }

    // 🔐 Login
    private static User iniciarSesion(Scanner sc, UserService userService) {
        System.out.print("Ingrese email o nombre de usuario: ");
        String email = sc.nextLine();
        System.out.print("Ingrese contraseña: ");
        String password = sc.nextLine();
        return userService.login(email, password);
    }

    // 🧰 Menú Administrador
    private static void menuAdministrador(Scanner sc, ProductService productService,
                                          InventoryManager inventarioFisico, InventoryManager inventarioDigital) {
        boolean back = false;
        while (!back) {
            System.out.println("\n========= 🔧 PANEL ADMINISTRADOR =========");
            System.out.println("1️⃣ - Agregar producto físico");
            System.out.println("2️⃣ - Agregar producto digital");
            System.out.println("3️⃣ - Eliminar producto");
            System.out.println("4️⃣ - Ver inventario");
            System.out.println("5️⃣ - Cerrar sesión");
            System.out.print("Seleccione una opción: ");
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> agregarProductoFisico(sc, productService, inventarioFisico);
                case 2 -> agregarProductoDigital(sc, productService, inventarioDigital);
                case 3 -> eliminarProducto(sc, productService);
                case 4 -> productService.showProducts();
                case 5 -> back = true;
                default -> System.out.println("⚠️ Opción no válida.");
            }
        }
    }

    // 🛍️ Menú Cliente
    private static void menuCliente(Scanner sc, ProductService productService,
                                    CartService cartService, Client cliente) {
        boolean back = false;
        while (!back) {
            System.out.println("\n========= 🛍️ MENÚ CLIENTE =========");
            System.out.println("1️⃣ - Ver productos");
            System.out.println("2️⃣ - Comprar producto");
            System.out.println("3️⃣ - Ver carrito");
            System.out.println("4️⃣ - Cerrar sesión");
            System.out.print("Seleccione una opción: ");
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> productService.showProducts();
                case 2 -> comprarProducto(sc, productService, cartService, cliente);
                case 3 -> {
                    if (cliente.getCarts().isEmpty()) {
                        System.out.println("⚠️ No hay carrito activo.");
                    } else {
                        cartService.showCart(cliente.getCarts().get(0));
                    }
                }
                case 4 -> back = true;
                default -> System.out.println("⚠️ Opción no válida.");
            }
        }
    }

    // ➕ Agregar producto físico
    private static void agregarProductoFisico(Scanner sc, ProductService productService, InventoryManager inventario) {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Descripción: ");
        String descripcion = sc.nextLine();
        System.out.print("Precio: ");
        double precio = sc.nextDouble();
        System.out.print("Stock: ");
        int stock = sc.nextInt();
        System.out.print("Peso (kg): ");
        double peso = sc.nextDouble();
        System.out.print("Ancho (cm): ");
        double ancho = sc.nextDouble();
        System.out.print("Alto (cm): ");
        double alto = sc.nextDouble();
        System.out.print("Profundidad (cm): ");
        double profundidad = sc.nextDouble();
        sc.nextLine();

        PhysicalProduct p = productService.addPhysicalProduct(nombre, descripcion, precio, stock, peso, ancho, alto, profundidad);
        inventario.addProduct(p);
    }

    // ➕ Agregar producto digital
    private static void agregarProductoDigital(Scanner sc, ProductService productService, InventoryManager inventario) {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Descripción: ");
        String descripcion = sc.nextLine();
        System.out.print("Precio: ");
        double precio = sc.nextDouble();
        System.out.print("Stock: ");
        int stock = sc.nextInt();
        System.out.print("Tamaño del archivo (MB): ");
        double size = sc.nextDouble();
        sc.nextLine();

        DigitalProduct p = productService.addDigitalProduct(nombre, descripcion, precio, stock, size);
        inventario.addProduct(p);
    }

    // ❌ Eliminar producto
    private static void eliminarProducto(Scanner sc, ProductService productService) {
        System.out.print("Ingrese ID del producto a eliminar: ");
        int id = sc.nextInt();
        sc.nextLine();
        boolean eliminado = productService.remove(id);
        System.out.println(eliminado ? "✅ Producto eliminado correctamente." : "❌ Producto no encontrado.");
    }

    // 💳 Comprar producto
    private static void comprarProducto(Scanner sc, ProductService productService,
                                        CartService cartService, Client cliente) {
        productService.showProducts();
        System.out.print("Ingrese ID del producto a comprar: ");
        int id = sc.nextInt();
        sc.nextLine();

        Product p = productService.findById(id);
        if (p == null) {
            System.out.println("❌ Producto no encontrado.");
            return;
        }

        System.out.print("Cantidad: ");
        int cantidad = sc.nextInt();
        sc.nextLine();

        // Crear o usar carrito
        Cart cart = cliente.getCarts().isEmpty() ? cartService.createCart(cliente) : cliente.getCarts().get(0);
        if (cliente.getCarts().isEmpty()) cliente.getCarts().add(cart);

        try {
            cartService.addProductToCart(cart, p, cantidad);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        // Método de pago
        System.out.println("Seleccione método de pago:");
        System.out.println("1️⃣ - Tarjeta");
        System.out.println("2️⃣ - PayPal");
        int metodo = sc.nextInt();
        sc.nextLine();

        PaymentProcessor pago = (metodo == 1) ? new CardPayment() : new PayPalPayment();
        pago.paymentInit(p.getPrice() * cantidad);
        if (pago.paymentVerify()) pago.paymentConfirm();

        cartService.showCart(cart);
    }
}

