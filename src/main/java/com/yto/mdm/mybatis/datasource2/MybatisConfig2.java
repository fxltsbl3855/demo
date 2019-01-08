package com.yto.mdm.mybatis.datasource2;

import com.github.pagehelper.PageHelper;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Mybatis & Mapper & PageHelper 配置
 */
@Configuration("configDataSource2")
public class MybatisConfig2 {

	public static final String MODEL_PACKAGE = "com.yto.mdm.mybatis.datasource2.entity";//Model所在包
	public static final String MAPPER_PACKAGE = "com.yto.mdm.mybatis.datasource2.mapper";//Mapper所在包
	public static final String MAPPER_INTERFACE_REFERENCE = "tk.mybatis.mapper.common.Mapper";//Mapper插件基础接口的完全限定名

    @Bean(name = "dataSource2")
    @ConfigurationProperties(prefix = "spring.datasource.datasource2")
    public DataSource dataSource2() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "dataSource2SqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean(@Qualifier("dataSource2") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(dataSource);
        factory.setTypeAliasesPackage(MODEL_PACKAGE);

        //配置分页插件，详情查阅PageHelper官方文档
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("pageSizeZero", "true");//分页尺寸为0时查询所有纪录不再执行分页
        properties.setProperty("reasonable", "true");//页码<=0 查询第一页，页码>=总页数查询最后一页
        properties.setProperty("supportMethodsArguments", "true");//支持通过 Mapper 接口参数来传递分页参数
        pageHelper.setProperties(properties);

        //添加插件
        factory.setPlugins(new Interceptor[]{pageHelper});

        //添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        factory.setMapperLocations(resolver.getResources("classpath:mapper/datasource2/**/*.xml"));
        return factory.getObject();
    }

    @Bean(name = "dataSource2MapperScannerConfigurer")
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBeanName("dataSource2MapperScannerConfigurer");
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("dataSource2SqlSessionFactory");
        mapperScannerConfigurer.setBasePackage(MAPPER_PACKAGE);

        //配置通用Mapper，详情请查阅官方文档
        Properties properties = new Properties();
        properties.setProperty("mappers", MAPPER_INTERFACE_REFERENCE);
        properties.setProperty("notEmpty", "false");//insert、update是否判断字符串类型!='' 即 test="str != null"表达式内是否追加 and str != ''
        properties.setProperty("IDENTITY", "MYSQL");
        mapperScannerConfigurer.setProperties(properties);

        return mapperScannerConfigurer;
    }

    @Bean(name = "dataSource2SqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("dataSource2SqlSessionFactory")SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
    
}

