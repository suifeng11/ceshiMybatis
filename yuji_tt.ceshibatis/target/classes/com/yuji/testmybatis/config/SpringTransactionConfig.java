package com.yuji.testmybatis.config;

import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.interceptor.*;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class SpringTransactionConfig {
 

    @Resource(name="proDataSource")
    private DataSource dataSource;
	
	@Bean("transactionManager")
	public DataSourceTransactionManager txManager() {
		return new DataSourceTransactionManager(dataSource);
	}
 
    /*事务拦截器*/
    @Bean("txAdvice")
    public 	TransactionInterceptor txAdvice(DataSourceTransactionManager txManager){
    	 
    	NameMatchTransactionAttributeSource source = new NameMatchTransactionAttributeSource();
          /*创建只读事务*/
         RuleBasedTransactionAttribute readOnlyTx = new RuleBasedTransactionAttribute();
         readOnlyTx.setReadOnly(true);
         readOnlyTx.setPropagationBehavior(TransactionDefinition.PROPAGATION_NOT_SUPPORTED );

        /*创建可修改事务*/
         RuleBasedTransactionAttribute requiredTx = new RuleBasedTransactionAttribute(TransactionDefinition.PROPAGATION_REQUIRED,
             Collections.singletonList(new RollbackRuleAttribute(Exception.class)));
         requiredTx.setTimeout(10000);


         Map<String, TransactionAttribute> txMap = new HashMap<>();
         txMap.put("add*", requiredTx);
         txMap.put("save*", requiredTx);
         txMap.put("insert*", requiredTx);
         txMap.put("update*", requiredTx);
         txMap.put("del*", requiredTx);
         txMap.put("find*", requiredTx);
         

         txMap.put("get*", readOnlyTx);
        // txMap.put("find*", readOnlyTx);
         txMap.put("query*", readOnlyTx);
         source.setNameMap( txMap );

         return new TransactionInterceptor(txManager ,source) ;
    }
 
    /**切面拦截规则 参数会自动从容器中注入*/
    @Bean
    public DefaultPointcutAdvisor defaultPointcutAdvisor(TransactionInterceptor txAdvice){
    	DefaultPointcutAdvisor pointcutAdvisor = new DefaultPointcutAdvisor();
        pointcutAdvisor.setAdvice(txAdvice);
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("execution(* com.yuji.testmybatis.service..*.*(..))");
        pointcutAdvisor.setPointcut(pointcut);
        return pointcutAdvisor;
    }
 
 
}
 
