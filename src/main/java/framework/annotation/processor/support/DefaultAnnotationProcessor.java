package framework.annotation.processor.support;

/**
 * @author : xiaoheshang
 * @version : 2.0 版本引入
 * @time : 2019/6/19 - 2:41 PM
 * @Param :
 * @function :
 */
public interface DefaultAnnotationProcessor {

    /**
     * @author : xiaoheshang
     *
     * @time : 2019/6/19 - 2:42 PM
     * @Param :
     * @function : 不同注解处理器通过不同方式解析获取对象
     */
    Object resolveObject() throws Exception;

}
