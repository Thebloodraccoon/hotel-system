package ua.thecoon.hotel.config;


// TODO
//@Configuration
//@EnableSwagger2
//public class SwaggerConfig extends WebMvcConfigurationSupport {
////
////    @Bean
////    public Docket api() {
////        return new Docket(DocumentationType.SWAGGER_2)
////                .select()
////                .apis(RequestHandlerSelectors.basePackage("ua.thecoon.hotel.controller"))
////                .paths(PathSelectors.any())
////                .build()
////                .apiInfo(metaData());
////    }
////
////    private ApiInfo metaData() {
////        return new ApiInfoBuilder()
////                .title("Spring Boot REST API")
////                .description("\"Spring Boot REST API for Hotel System\"")
////                .version("1.0.0")
////                .contact(new Contact("The blood coon", "https://github.com/Thebloodraccoon", "vsafirko@gmail.com"))
////                .build();
////    }
//
//    @Override
//    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("swagger-ui.html")
//                .addResourceLocations("classpath:/META-INF/resources/");
//
//        registry.addResourceHandler("/webjars/**")
//                .addResourceLocations("classpath:/META-INF/resources/webjars/");
//    }
//}