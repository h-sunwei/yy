package com.yy.sola.support;

import org.springframework.core.convert.converter.Converter;

/**
 * 转换器
 */
public interface CustomerConverter<S, T> extends Converter<S, T> {
}
