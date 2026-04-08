package bg.tu_varna.sit.task_manager.exception;

/***
 * Добавено в лабораторно упражнение 9
 */
public class RelatedEntityException extends Exception {
    public RelatedEntityException(long id, Class<?> clazz) {
        super(String.format("Conflict: %d with ID = %s is still linked to other records and cannot be deleted", id, clazz.getName()));
    }
}
