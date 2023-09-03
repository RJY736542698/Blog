package cat.service;
import cat.entity.Options;

/**
 * 站点信息
 */
public interface OptionsService {
    /**
     * 获得基本信息
     * @return 系统设置
     */
    Options getOptions();

    /**
     * 更新基本信息
     * @param options 系统设置
     */
    void updateOptions(Options options);
}
