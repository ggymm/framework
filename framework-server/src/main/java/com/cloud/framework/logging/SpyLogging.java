package com.cloud.framework.logging;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.p6spy.engine.spy.appender.MessageFormattingStrategy;
import lombok.extern.slf4j.Slf4j;

/**
 * @author gongym
 * @version 创建时间: 2021-11-09 15:48
 */
@Slf4j
public class SpyLogging extends com.p6spy.engine.spy.appender.StdoutLogger  implements MessageFormattingStrategy {

    @Override
    public void logText(String text) {
      log.info(text);
    }

    @Override
    public String formatMessage(int connectionId, String now, long elapsed, String category,
                                String prepared, String sql, String url) {
        return StringUtils.isNotBlank(sql) ? "\n\n\t Consume Time：" + elapsed + " ms " + now +
                "\n\t Execute SQL：" + sql.replaceAll("[\\s]+", " ") + "\n" : "";
    }
}