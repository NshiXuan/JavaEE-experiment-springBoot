package com.sx.common.cfg;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.RequestParameterBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ParameterType;
import springfox.documentation.service.RequestParameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Configuration
public class SwaggerCfg implements InitializingBean {
  @Autowired
  private Environment environment;
  private boolean enable;

  @Bean
  public Docket docket() {
    return basicDocket()
            .apiInfo(apiInfo("接口文档", "一个测试的接口文档"))
            .select()
            .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
            .build();
  }

  private Docket basicDocket() {
    RequestParameter token = new RequestParameterBuilder()
            .name("token")
            .description("用户登录令牌")
            .in(ParameterType.HEADER)
            .build();

    return new Docket(DocumentationType.SWAGGER_2)
            .globalRequestParameters(List.of(token))
            .ignoredParameterTypes(
                    HttpSession.class,
                    HttpServletRequest.class,
                    HttpServletResponse.class)
            .enable(enable);
  }

  private ApiInfo apiInfo(String title, String desc) {
    return new ApiInfoBuilder()
            .title(title)
            .description(desc)
            .version("1.0.0")
            .build();
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    enable = environment.acceptsProfiles(Profiles.of("dev", "test"));
  }
}
