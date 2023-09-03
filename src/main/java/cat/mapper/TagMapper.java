package cat.mapper;
import java.util.List;
import cat.entity.Tag;

/**
 * Tag标签
 */
public interface TagMapper {
    /**
     * 获得标签列表
     */
    List<Tag> listTag() ;

    /**
     * 添加标签
     */
	void addTag(Tag tag);
}