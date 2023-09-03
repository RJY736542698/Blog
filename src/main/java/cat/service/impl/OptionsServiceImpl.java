package cat.service.impl;
import javax.annotation.Resource;
//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import cat.entity.Options;
import cat.mapper.OptionsMapper;
import cat.service.OptionsService;

/**
 * 站点信息
 */
@Service
public class OptionsServiceImpl implements OptionsService {

    @Resource
    private OptionsMapper optionsMapper;

    @Override
   // @Cacheable(value = "default", key = "'options'")
    public Options getOptions() {
        return optionsMapper.getOptions();
    }

    @Override
   // @CacheEvict(value = "default", key = "'options'")
    public void updateOptions(Options options) {
        optionsMapper.updateOptions(options);
    }
}
