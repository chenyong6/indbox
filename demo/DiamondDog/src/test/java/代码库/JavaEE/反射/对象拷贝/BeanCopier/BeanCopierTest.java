package 代码库.JavaEE.反射.对象拷贝.BeanCopier;

import static org.hamcrest.CoreMatchers.*;

import net.sf.cglib.beans.BeanCopier;
import 代码库.JavaEE.反射.对象拷贝.domain.ConverterDiffType;
import 代码库.JavaEE.反射.对象拷贝.domain.LackOfSetter;
import 代码库.JavaEE.反射.对象拷贝.domain.OrderDto;
import 代码库.JavaEE.反射.对象拷贝.domain.OrderEntity;
import 代码库.JavaEE.反射.对象拷贝.domain.PropWithDiffType;

import org.junit.Assert;
import org.junit.Test;
/**
 * http://czj4451.iteye.com/blog/2044101
 *  测试结论：
 *  1. BeanCopier只拷贝名称和类型都相同的属性。 
 *	2. 当目标类的setter数目比getter少时，创建BeanCopier会失败而导致拷贝不成功。
 * @author chenyong6
 *
 */
public class BeanCopierTest {
	/**
	 * 1. 属性名称、类型都相同:
	 */
	@Test
	public void normalCopyTest() {
		OrderEntity entity = new OrderEntity();
		entity.setId(1);
		entity.setName("orderName");
		final BeanCopier copier = BeanCopier.create(OrderEntity.class,
				OrderDto.class, false);
		OrderDto dto = new OrderDto();
		copier.copy(entity, dto, null);
		Assert.assertThat(dto.getId(), is(1));
		Assert.assertThat(dto.getName(), is("orderName"));
	}

	/**
	 * 2. 属性名称相同、类型不同： 1.名称相同而类型不同的属性不会被拷贝。 注意：即使源类型是原始类型(int,
	 * short和char等)，目标类型是其包装类型(Integer, Short和Character等)，或反之：都不会被拷贝。
	 */
	@Test
	public void sameNameDifferentTypeCopyTest() {
		OrderEntity entity = new OrderEntity();
		entity.setId(1);
		entity.setName("orderName");
		final BeanCopier copier = BeanCopier.create(OrderEntity.class,
				PropWithDiffType.class, false);
		PropWithDiffType dto = new PropWithDiffType();
		copier.copy(entity, dto, null);
		Assert.assertEquals(null, dto.getId());
		Assert.assertEquals("orderName", dto.getName());
	}

	/**
	 * 3. 源类和目标类有相同的属性(两者的getter都存在),但目标类的setter不存在
	 * 
	 */
	@Test
	public void targetLackOfSetterCopyTest() {
		OrderEntity entity = new OrderEntity();
		entity.setId(2);
		entity.setName("test");
		final BeanCopier copier = BeanCopier.create(OrderEntity.class,
				LackOfSetter.class, false);
		// ↑ 抛NullPointerException
		LackOfSetter lackBean = new LackOfSetter();
		copier.copy(entity, lackBean, null);
		System.err.println(entity);
		System.err.println(lackBean);
	}

	/**
	 * 4. 源类或目标类的setter比getter少
	 */
	@Test
	public void sourceLackOfSetterCopyTest() {
		LackOfSetter source = new LackOfSetter(1, "throne");
		final BeanCopier copier = BeanCopier.create(LackOfSetter.class,
				OrderDto.class, false);
		OrderDto dto = new OrderDto();
		copier.copy(source, dto, null);
		Assert.assertEquals(1, dto.getId());
		Assert.assertEquals("throne", dto.getName());
	}
	@Test
	public void ConverterDiffTypeTest(){
		OrderEntity oEntity = new OrderEntity();
		oEntity.setId(1);
		oEntity.setName("cy");
		PropWithDiffType diffEntity = new PropWithDiffType();
		final BeanCopier copier = BeanCopier.create(OrderEntity.class,PropWithDiffType.class,false);
		copier.copy(oEntity, diffEntity,new ConverterDiffType());
		Assert.assertThat(oEntity.getId(), is(diffEntity.getId()));
		Assert.assertThat(oEntity.getName(), is(diffEntity.getName()));
	}
}
