import com.entity.*;
import com.mapper.BlogMapper;
import com.mapper.JobMapper;
import com.mapper.UserMapper;
import lombok.extern.log4j.Log4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;


@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:applicationContext-dao.xml"})
public class TestUSer {

    @Autowired
    private SqlSessionFactory factory;

    @Test
    public void testid() {
        Resume resume = new Resume();
        Resume resume1 = new Resume();
        System.out.println(resume.getResumeId());
        System.out.println(resume1.getResumeId());
    }

    @Test
    public void testUserJob() {
        SqlSession sqlSession = factory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserJob(1);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void testUJM() {
        SqlSession sqlSession = factory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        UJM ujm =new UJM();
        ujm.setUserId(2);
        ujm.setJobId(3);
        int result = userMapper.insertUJM(ujm);
        System.out.println(result);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testgetByCatrgory(){
        SqlSession sqlSession = factory.openSession();
        JobMapper jobMapper = sqlSession.getMapper(JobMapper.class);
        List<Job> jobs = jobMapper.getByCategory("java");
        System.out.println(jobs);
    }
    @Test
    public void testgetByBlogCatrgory(){
        SqlSession sqlSession = factory.openSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        List<Blog> blogs = blogMapper.getByBlogCategory("热门帖子");
        System.out.println(blogs);
    }
    @Test
    public void testgetByLike(){
        SqlSession sqlSession = factory.openSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        List<Blog> blogs = blogMapper.getByLike("%唐%");
        System.out.println(blogs);
    }

}
