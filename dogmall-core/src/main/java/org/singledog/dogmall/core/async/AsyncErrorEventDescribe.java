package org.singledog.dogmall.core.async;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Method;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AsyncErrorEventDescribe {
    private Throwable ex;
    private Method method;
    private Object[] params;
}
