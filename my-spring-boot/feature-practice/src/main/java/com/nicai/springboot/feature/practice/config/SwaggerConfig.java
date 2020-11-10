package com.nicai.springboot.feature.practice.config;


import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * @author guozhe
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket userApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(basePackage("com.nicai.springboot.feature.practice.controller"))
                .paths(PathSelectors.regex("/api.*"))
                .build();
    }

    public static Predicate<RequestHandler> basePackage(final String basePackage) {
        return input -> declaringClass(input).transform(handlerPackage(basePackage)).or(true);
    }

    private static Function<Class<?>, Boolean> handlerPackage(final String basePackage) {
        return input -> {
            for (String strPackage : basePackage.split(",")) {
                boolean isMatch = input.getPackage().getName().startsWith(strPackage);
                if (isMatch) {
                    return true;
                }
            }
            return false;
        };
    }

    /**
     *     * @param input RequestHandler
     *     * @return Optional
     *    
     */
    private static Optional<? extends Class<?>> declaringClass(RequestHandler input) {
        return Optional.fromNullable(input.declaringClass());
    }


    private static ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("资产服务接口文档")
                .description("注意!!!：URL以【/api/core/v2/】开头：有统一的返回格式，异常已经被封装。以【/api/core/v1/】开头：线上正在使用的URL,无统一的异常封装。")
                .termsOfServiceUrl("http://wiki.puhuitech.cn/pages/viewpage.action?pageId=11502024")
                .contact(new Contact("任买科技-资产服务", "http://wiki.renmaitech.com/pages/viewpage.action?pageId=3804090", "core.list@renmaitech.com"))
                .license("renmaitech license")
                .licenseUrl("http://wiki.renmaitech.com/")
                .version("1.0")
                .build();
    }

}