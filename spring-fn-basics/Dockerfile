FROM projectriff/java-function-invoker:0.0.2
ARG FUNCTION_JAR=/functions/spring-fn-basics-0.0.1.jar
ARG FUNCTION_CLASS=com.codepub.demo.riff.DemoFunction
ADD target/spring-fn-basics-0.0.1.jar $FUNCTION_JAR
ENV FUNCTION_URI file://${FUNCTION_JAR}?handler=${FUNCTION_CLASS}
