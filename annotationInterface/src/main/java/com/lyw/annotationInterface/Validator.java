package com.lyw.annotationInterface;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author liuyaowei488
 * @date created in 2019-12-13 15:17
 */
public class Validator {
    public static String validate(Object object) {
        AtomicReference<String> msg = new AtomicReference<>();
        if (null == object) {
            msg.set("object is null");
            return msg.get();
        }

//        for (Field field : object.getClass().getDeclaredFields()) {
//
//        }

        Arrays.stream(object.getClass().getDeclaredFields()).forEach(field -> {
            Arrays.stream(field.getDeclaredAnnotations()).forEach(annotation -> {
                try {
                    msg.set(process(annotation, object, field));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        });
        return msg.get();
    }

    private static String process(Annotation annotation, Object object, Field field) throws Exception {
        String msg = null;
        if (StringNotEmpty.class.equals(annotation.annotationType())) {
            field.setAccessible(true);
            Object value = field.get(object);
            if (!String.class.equals(field.getType()))
                return msg;

            String fieldValue = (String) value;
            StringNotEmpty anno = (StringNotEmpty) annotation;
            msg = anno.msg();

            if (null == fieldValue || fieldValue.trim().length() == 0)
                return msg;
        }
        return msg;
    }
}
