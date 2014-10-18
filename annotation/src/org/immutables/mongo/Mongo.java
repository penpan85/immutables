package org.immutables.mongo;

import com.google.common.annotations.Beta;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Beta
@Retention(RetentionPolicy.SOURCE)
public @interface Mongo {
  /**
   * Abstract immutable classes annotated with this annotation will have repository generated to
   * store
   * and retrieve documents from MongoDB collection named by class name or explicitly named as
   * specified by {@link #value()}.
   * <p>
   * {@link Repository} requires marshaler for the annotated class, so one will be generated
   * regardless of the presence of @{@link org.immutables.json.Json.Marshaled} annotation. However,
   * care should be taken for all attributes to be recursively marshalable by being either built-in
   * types or marshalable documents (annotated with @{@link org.immutables.json.Json.Marshaled}) or
   * ensuring some marshaling {@link org.immutables.json.Json.Import} routines exists to marshal
   * types.
   * <p>
   * <em>Note: Currently, this annotation works only for top level classes.</em>
   */
  @Documented
  @Target(ElementType.TYPE)
  @Retention(RetentionPolicy.SOURCE)
  public @interface Repository {
    /**
     * Specify document collection name. If not specified, then collection name will be given
     * automatically by document class name, i.e. {@code "myDocument"} for {@code MyDocument} class.
     */
    String value() default "";
  }
}
