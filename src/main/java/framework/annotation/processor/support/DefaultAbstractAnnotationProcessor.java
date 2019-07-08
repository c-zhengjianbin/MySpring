package framework.annotation.processor.support;

/**
 * @author : zhengjianbin
 * @version : 2.0 版本
 * @time : 2019/6/19 - 2:46 PM
 * @Param :
 * @function : 默认注解处理器公共类
 */
public abstract class DefaultAbstractAnnotationProcessor implements DefaultAnnotationProcessor {
    @Override
    public Object resolveObject() throws Exception  {
        throw new Exception("DefaultAbstractAnnotationProcessor not support resolveObject，require subclass support");
    }
}
