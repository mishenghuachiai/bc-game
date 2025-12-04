package com.user.api.common.convert;

import org.springframework.beans.BeanUtils;

import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class ConvertUtils {
    public static <S, T> Function<S, T> of(Supplier<T> supplier) {
        return source -> {
            T target = supplier.get();
            if (source != null) {
                BeanUtils.copyProperties(source, target); // 自动拷贝同名字段
            }
            return target;
        };
    }

    // 局部覆盖某个字段
    public static <S, T> Function<S, T> andThen(Function<S, T> before, BiConsumer<S, T> customizer) {
        return before.andThen(t -> {
            customizer.accept(null, t); // 注意：这里 source 已不可用，只能改 target
            return t;
        });
    }

    // 更强的版本：保留 source
    public static <S, T> Function<S, T> withCustom(BiConsumer<S, T> customizer) {
        return source -> {
            T target = (T) new Object(); // 占位，实际配合 of 使用
            customizer.accept(source, target);
            return target;
        };
    }
}
