package bg.tu_varna.sit.task_manager.component;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.stereotype.Component;
import java.lang.reflect.Type;
import org.modelmapper.TypeToken;
import java.util.List;

/**
 * Добавено в лабораторно упражнение 9
 */
@Component
public class CustomMapper extends ModelMapper {
    public CustomMapper() {
        this.getConfiguration()
                .setSkipNullEnabled(true)
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
    }
}
