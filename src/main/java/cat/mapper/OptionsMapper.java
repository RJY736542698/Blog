package cat.mapper;
import org.apache.ibatis.annotations.Mapper;
import cat.entity.Options;

/**
 * 站点信息
 */
@Mapper
public interface OptionsMapper {
    /**
     * 获得记录
     * @return 系统信息
     */
    Options getOptions();
    
    /**
     * 更新
     * @param options 系统信息
     * @return 影响行数
     */
    int updateOptions(Options options);
    
    /**
     * 根据ID查询
     *
     * @param optionId 系统设置ID
     * @return 系统设置
     */
    Options getOptionsById(Integer optionId);
}