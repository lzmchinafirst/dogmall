package org.singledog.dogmall.core.async;

import org.springframework.context.ApplicationEvent;

/**
 * Async execute error event
 *
 * @author Zheming Liu
 * @since 1.0.0-RELEASE
 */
public class AsyncErrorEvent extends ApplicationEvent {

    public AsyncErrorEvent(AsyncErrorEventDescribe source) {
        super(source);
    }

    public AsyncErrorEventDescribe getAsyncDescribe() {
        return (AsyncErrorEventDescribe) getSource();
    }
}
