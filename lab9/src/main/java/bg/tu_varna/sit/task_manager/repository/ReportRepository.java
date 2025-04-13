package bg.tu_varna.sit.task_manager.repository;

import bg.tu_varna.sit.task_manager.model.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;

/***
 * Добавено в лабораторно упражнение 9
 */
public interface ReportRepository extends JpaRepository<Report, Long> {
}