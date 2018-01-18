FROM projectriff/java-function-invoker:0.0.2
ARG FUNCTION_JAR=/functions/spring-fn-demo-0.0.1.jar
ARG FUNCTION_CLASS=com.codepub.demo.riff.function.SpringFn
ADD target/spring-fn-demo-0.0.1.jar $FUNCTION_JAR
ENV FUNCTION_URI file://${FUNCTION_JAR}?handler=${FUNCTION_CLASS}
