package city_book;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cbh.dao.UserDao;
import com.cbh.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class UserTest {
	@Autowired
	UserDao userDao;
	
	@Test
	public void testQueryUserSingle() {
		User user = userDao.getUserById(1);
		
		System.out.println(user);
	}
	
	@Test
	public void testQueryUserList() {
		System.out.println(UUID.randomUUID().toString().replace("-", ""));
		
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("offset", 0);
		param.put("limit", 10);
		List<List<?>> list = userDao.getUserList(param);
		System.out.println(list.get(0));
	}
}
