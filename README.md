# 🛒 E-Commerce Backend en Java

## 📖 Descripción
Este proyecto implementa un backend completo para un sistema de e-commerce utilizando **Java** con **Maven** y aplicando principios avanzados de **Programación Orientada a Objetos** y **Patrones de Diseño**.

## 🧰 Tecnologías
- Java 25+
- Maven
- POO (Herencia, Polimorfismo, Encapsulamiento)
- Patrones de diseño: Singleton, Factory, Observer, Abstract Class, Interface

## 📦 Características
- 👤 Gestión de usuarios (cliente y administrador)
- 📦 Gestión de productos (digital y físico)
- 🧱 Patrones implementados:
    - **Singleton**: Configuración del sistema (`ConfiguracionSistema`)
    - **Factory**: Creación de productos y usuarios (`FabricaEntidades`)
    - **Observer**: Sistema de notificaciones (`GestorPedidos`)
- 🛍️ Carrito de compras y proceso de pago con interfaces
- 📊 Gestión de inventario con clases abstractas

## 📸 Capturas

![Menú principal](docs/menu.png)
![Notificaciones](docs/observer.png)

## 🚀 Ejecución
```bash
mvn compile
mvn exec:java -Dexec.mainClass="org.ecommerce.Main"