package org.ecommerce.Model;

public class Administrator extends User {
    private String role;
    private String department;

    public Administrator() {
        super();
        this.role = "viewer";
        this.department = "general";
    }

    public Administrator(String name, String email, String password, String role, String department) {
        super(name, email, password);
        this.role = role != null ? role : "viewer";
        this.department = department != null ? department : "general";
    }

    public Administrator(String username, String password) {
        super(username, password);
        this.role = "viewer";
        this.department = "general";
    }

    // Getters & Setters
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public boolean hasPermission(String action) {
        if (role == null) return false;

        return switch (role.toLowerCase()) {
            case "superadmin" -> true; // acceso total
            case "manager" -> action.equalsIgnoreCase("manage_products") ||
                    action.equalsIgnoreCase("view_reports");
            case "viewer" -> action.equalsIgnoreCase("view_products");
            default -> false;
        };
    }

    public void showPermissions() {
        System.out.println(" Permisos disponibles para " + getName() + " (" + role + "):");
        if ("superadmin".equalsIgnoreCase(role)) {
            System.out.println("- Todos los permisos");
        } else if ("manager".equalsIgnoreCase(role)) {
            System.out.println("- Gestionar productos");
            System.out.println("- Ver reportes");
        } else {
            System.out.println("- Ver productos");
        }
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", role='" + role + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
