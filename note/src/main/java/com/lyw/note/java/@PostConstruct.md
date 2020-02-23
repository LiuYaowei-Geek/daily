#@PostConstruct注解
1. PostConstruct 注释用于在依赖关系注入完成之后需要执行的方法上，以执行任何初始化。此方法必须在将类放入服务之前调用。支持依赖关系注入的所有类都必须支持此注释。即使类没有请求注入任何资源，用 PostConstruct 注释的方法也必须被调用。只有一个方法可以用此注释进行注释。应用 PostConstruct 注释的方法必须遵守以下所有标准：该方法不得有任何参数，除非是在 EJB 拦截器 (interceptor) 的情况下，根据 EJB 规范的定义，在这种情况下它将带有一个 InvocationContext 对象 ；该方法的返回类型必须为 void；该方法不得抛出已检查异常；应用 PostConstruct 的方法可以是 public、protected、package private 或 private；除了应用程序客户端之外，该方法不能是 static；该方法可以是 final；如果该方法抛出未检查异常，那么不得将类放入服务中，除非是能够处理异常并可从中恢复的 EJB。  
2. The PostConstruct annotation is used on a method that needs to be executed
after dependency injection is done to perform any initialization. This
method MUST be invoked before the class is put into service. This
annotation MUST be supported on all classes that support dependency
injection. The method annotated with PostConstruct MUST be invoked even
if the class does not request any resources to be injected. Only one
method can be annotated with this annotation. The method on which the
PostConstruct annotation is applied MUST fulfill all of the following
criteria:
<p>
<ul>
<li>The method MUST NOT have any parameters except in the case of
interceptors in which case it takes an InvocationContext object as
defined by the Interceptors specification.</li>
<li>The method defined on an interceptor class MUST HAVE one of the
following signatures:
<p>
void &#060;METHOD&#062;(InvocationContext)
<p>
Object &#060;METHOD&#062;(InvocationContext) throws Exception
<p>
<i>Note: A PostConstruct interceptor method must not throw application
exceptions, but it may be declared to throw checked exceptions including
the java.lang.Exception if the same interceptor method interposes on
business or timeout methods in addition to lifecycle events. If a
PostConstruct interceptor method returns a value, it is ignored by
the container.</i>
</li>
<li>The method defined on a non-interceptor class MUST HAVE the
following signature:
<p>
void &#060;METHOD&#062;()
</li>
<li>The method on which PostConstruct is applied MAY be public, protected,
package private or private.</li>
<li>The method MUST NOT be static except for the application client.</li>
<li>The method MAY be final.</li>
<li>If the method throws an unchecked exception the class MUST NOT be put into
service except in the case of EJBs where the EJB can handle exceptions and
even recover from them.</li></ul>
<li>@since Common Annotations 1.0
<li>@see javax.annotation.PreDestroy
<li>@see javax.annotation.Resource  

3.code
```java
@Documented
@Retention (RUNTIME)
@Target(METHOD)
public @interface PostConstruct {
}
```