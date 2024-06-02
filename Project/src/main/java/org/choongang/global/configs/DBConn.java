package org.choongang.global.configs;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class DBConn {
    private static SqlSessionFactory factory;

    static {
        try {
            String mode = System.getenv("mode");
            mode = mode == null || !mode.equals("prod") ? "dev":"prod";
            Reader reader = Resources.getResourceAsReader("org/choongang/global/configs/mybatis-config.xml");
            factory = new SqlSessionFactoryBuilder().build(reader, mode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSession(boolean autoCommit) {
        return factory.openSession(autoCommit);
    }

    public static SqlSession getSession() {
        return getSession(true);
    }
}
