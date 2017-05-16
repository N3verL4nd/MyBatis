import com.xiya.entity.Person;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by N3verL4nd on 2017/5/8.
 */
public class PersonDaoTest {
    @Test
    public void testGetPerson() throws IOException {
        // 1. 加载MyBatis的配置文件：mybatis-config.xml（它也加载关联的映射文件，也就是mappers结点下的映射文件）
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("mybatis-config.xml");
        // 2. SqlSessionFactoryBuilder实例将通过输入流调用build方法来构建 SqlSession 工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);

        // 3. 通过工厂获取 SqlSession 实例，SqlSession 完全包含了面向数据库执行 SQL 命令所需的所有方法。
        SqlSession session = sqlSessionFactory.openSession();

        // 4. 准备基本信息
        // 4.1) statement: 用来定位映射文件（PersonMapper.xml）中的语句（通过namespace id + select id)
        String statement = "com.xiya.dao.PersonMapper.getPersonById";
        // 4.2) parameter: 传进去的参数，也就是需要获取students表中主键值为1的记录
        int parameter = 1;
        // 5. SqlSession 实例来直接执行已映射的 SQL 语句，selectOne表示获取的是一条记录
        Person person = session.selectOne(statement, parameter);
        System.out.println(person);




        // 6. 关闭输入流和SqlSession实例
        in.close();
        session.close();

    }
}
