package 代码库.JavaEE.反射.对象拷贝.BeanCopier;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.junit.Assert;
import org.junit.Test;

import net.sf.cglib.beans.BeanCopier;
import net.sf.cglib.core.Converter;

public class CoverterDemo {
	@Test  
	public void converterTest() {  
	    AccountEntity po = new AccountEntity();  
	    po.setId(1);  
	    po.setCreateTime(Timestamp.valueOf("2014-04-12 16:16:15"));  
	    po.setBalance(BigDecimal.valueOf(4000L));  
	    BeanCopier copier = BeanCopier.create(AccountEntity.class, AccountDto.class, true);  
	    AccountConverter converter = new AccountConverter();  
	    AccountDto dto = new AccountDto();  
	    copier.copy(po, dto, converter);  
	    Assert.assertEquals("2014-04-12 16:16:15", dto.getCreateTime());  
	    Assert.assertEquals("4000", dto.getBalance());  
	}  
}
class AccountEntity {  
    private int id;  
    private Timestamp createTime;  
    private BigDecimal balance;  
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
}
class AccountDto {  
    private int id;  
    private String name;  
    private String createTime;  
    private String balance;  
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
    
}  
class AccountConverter implements Converter {  
	  
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
  
    @SuppressWarnings("rawtypes")  
    @Override  
    public Object convert(Object value, Class target, Object context) {  
    	System.err.println("源数据："+value +" : 目标类型：" + target + " : 目标Set方法：" + context);
        if (value instanceof Integer) {  
            return (Integer) value;  
        } else if (value instanceof Timestamp) {  
            Timestamp date = (Timestamp) value;  
            return sdf.format(date);  
        } else if (value instanceof BigDecimal) {  
            BigDecimal bd = (BigDecimal) value;  
            return bd.toPlainString();  
        }  
        return null;  
    }  
} 