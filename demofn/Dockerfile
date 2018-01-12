FROM projectriff/java-function-invoker:0.0.2
ARG FUNCTION_JAR=/functions/demofn-0.0.1.jar
ARG FUNCTION_CLASS=com.codepub.demo.DemoFunction
ADD target/demofn-0.0.1.jar $FUNCTION_JAR
ENV FUNCTION_URI file://${FUNCTION_JAR}?handler=${FUNCTION_CLASS}
