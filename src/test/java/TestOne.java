import com.example.entity.DataNotice;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;


public class TestOne {

    SessionFactory factory;
    Session session;

    @Before
    public void init(){
        Configuration cfg=new Configuration();
        //加载主配置文件
        cfg.configure("hibernate.cofig.xml");
        //创建工厂对象
        factory = cfg.buildSessionFactory();
        //创建Session对象
        session = factory.openSession();
    }

    @After
    public void destory(){
        //Session 使用以后务必关闭
        session.close();
        factory.close();
    }

    @Test
    public void testCre(){
        //查询一张上所有的信息
        Criteria c = session.createCriteria(DataNotice.class);
        c.setMaxResults(10);
        List<DataNotice> list =  c.list();
        for(DataNotice d : list){
            System.out.println(d.getZoneCode());
        }

    }

    @Test
    public void testPage(){
        //条件查询对象
        Criteria c = session.createCriteria(DataNotice.class);
        c.add(Restrictions.eq("id",5));
        List<DataNotice> lsis = c.list();
        for(DataNotice d : lsis){
            System.out.println(d.getZoneCode());
        }
    }
}
