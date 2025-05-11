package bg.tu_varna.sit.task_manager.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.time.LocalTime;

/***
 * Добавено в лабораторно упражнение 9
 */
@Getter
@Setter
@Entity
@Table(name = "reports")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "content", nullable = false)
    private String content;
    @Column(name = "workedTime", nullable = false)
    private LocalTime workedTime;
    @CreationTimestamp
    @Column(name = "dateCreated", length = 50, nullable = false)
    private LocalDateTime dateCreated;
    @UpdateTimestamp
    @Column(name = "dateUpdated", length = 50, nullable = false)
    private LocalDateTime dateUpdated;
    @ManyToOne
    @JoinColumn(name = "task_id", nullable = false)
    private Task task;
}
