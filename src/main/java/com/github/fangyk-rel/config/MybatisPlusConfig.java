package com.fangyk.config;

import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.fangyk.datasource.DynamicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import javax.annotation.Resource;

/**
 * Mybatis Plus 配置
 *
 * @author fangyk
 * @date 2023年07月28日 11:36
 */
public class MybatisPlusConfig {
    @Resource
    private DynamicDataSource dynamicDataSource;

    @Primary
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        MybatisSqlSessionFactoryBean sqlSessionFactory = new MybatisSqlSessionFactoryBean();

        //配置数据源
        sqlSessionFactory.setDataSource(dynamicDataSource);

        MybatisConfiguration configuration = new MybatisConfiguration();

        sqlSessionFactory.setConfiguration(configuration);

        return sqlSessionFactory.getObject();
    }
}