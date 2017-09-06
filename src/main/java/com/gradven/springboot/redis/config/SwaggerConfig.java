package com.gradven.springboot.redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger接口自动生成工具的配置
 *
 * @author liuhangjun
 * @date 2017-01-22
 */

@Configuration
@EnableSwagger2
@ComponentScan(value = "com.gradven.springboot.redis.controller")
public class SwaggerConfig extends WebMvcConfigurerAdapter {

	@Bean
	public Docket api() {

		/*Parameter debugUserIdParam = new ParameterBuilder().name("sessionId").required(false).parameterType("query") //参数类型支持header, cookie, body, query etc
				.allowMultiple(false).defaultValue("1").modelRef(new ModelRef("string")).description("用于调试需要登录的接口")
				.build();*/

		Parameter clientAgentParam = new ParameterBuilder().name("X-Client-Agent").required(false).parameterType("header")
				.allowMultiple(false).defaultValue("Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.115 Mobile Safari/537.36")
				.modelRef(new ModelRef("string")).description("用户UA信息")
				.build();

		return new Docket(DocumentationType.SWAGGER_2)
                .select()
				//.globalOperationParameters(Lists.newArrayList(debugUserIdParam, clientAgentParam)).select()
				.apis(RequestHandlerSelectors.basePackage("com.gradven.springboot.redis.controller")).build()
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				// 页面标题
				.title("使用 Swagger2 构建RESTful API")
				// 创建人
				//.contact(new Contact("test", null, "test@test.com"))
				// 版本号
				.version("1.0")
				// 描述
				.description("接口展示").build();
	}


	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");

		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}

}
