package bg.tu_varna.sit.task_manager.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import java.util.Set;

/**
 * Добавено в лабораторно упражнение 11
 */
@Getter
@Entity
@Table(name = "users")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;
}
