
import java.util.List;

/**
 * @author 
 * @date 
 * @since COMS 5.0
 */
public interface UrmPlanDetailMapper
{
	/**
	 * @param 
	 * @return
	 * @since COMS 5.0
	 */
	${modelBean.className} query${modelBean.className}ById(Long id);
	/**
	 * @param 
	 * @return 
	 * @since COMS 5.0
	 */
	List<${modelBean.className}> query${modelBean.className}List(Query${modelBean.className}BO query);
	/**
	 * 
	 * @param 
	 * @return 
	 * @since COMS 5.0
	 */
	int insert${modelBean.className}(${modelBean.className}DO do);
	/**
	 * @param 
	 * @return
	 * @since COMS 5.0
	 */
	int update${modelBean.className}(${modelBean.className}DO do);
	/**
	 * @param 
	 * @return
	 * @since COMS 5.0
	 */
	int delete${modelBean.className}(${modelBean.className}DO do);
}
