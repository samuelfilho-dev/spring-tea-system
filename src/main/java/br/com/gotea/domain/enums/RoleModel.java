package br.com.gotea.domain.enums;

public enum RoleModel {
    USER("user"),
    ADMIN("admin");

    private final String role;

    private RoleModel(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
