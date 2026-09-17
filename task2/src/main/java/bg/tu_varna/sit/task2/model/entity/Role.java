package bg.tu_varna.sit.task2.model.entity;

/***
 * Добавено в лабораторно упражнение 11
 */
public enum Role {
    USER,
    ADMIN;

    public String asAuthority() {
        return "ROLE_" + this.name();
    }
}
