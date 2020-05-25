package com.walter.space.common.utils;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author walter
 * @date 2020/5/25 11:43 下午
 */
public class BeanCopyUtil extends BeanUtils {

    /**
     * 对象数据的拷贝
     *
     * @param source 数据源
     * @param target 目标类::new(eg:UserVo::new)
     * @return 目标数据
     */
    public static <S, T> T copyObjProperties(S source, Supplier<T> target) {
        return copyObjProperties(source, target, null);
    }

    /**
     * 对象数据拷贝(带回调函数，可自定义回调规则)
     *
     * @param source   数据源
     * @param target   目标类::new(eg:UserVo::new)
     * @param callBack 回调函数
     * @return 目标数据
     */
    public static <S, T> T copyObjProperties(S source, Supplier<T> target, BeanCopyUtilCallBack<S, T> callBack) {
        if (source == null) {
            return null;
        }
        T t = target.get();
        BeanUtils.copyProperties(source, t);
        if (callBack != null) {
            callBack.callBack(source, t);
        }
        return t;
    }

    /**
     * 集合数据的拷贝
     *
     * @param sources 数据源
     * @param target  目标类::new(eg:UserVo::new)
     * @return 目标集合数据
     */
    public static <S, T> List<T> copyListProperties(List<S> sources, Supplier<T> target) {
        return copyListProperties(sources, target, null);
    }

    /**
     * 集合数据的拷贝
     *
     * @param sources 数据源
     * @param target  目标类::new(eg:UserVo::new)
     * @return 目标集合数据
     */

    public static <S, T> List<T> copyListProperties(List<S> sources, Supplier<T> target, BeanCopyUtilCallBack<S, T> callBack) {
        List<T> list = new ArrayList<>(sources.size());
        for (S source : sources) {
            T t = target.get();
            copyProperties(source, t);
            list.add(t);
            if (callBack != null) {
                callBack.callBack(source, t);
            }
        }
        return list;
    }

    /**
     * 自定义回调函数接口
     */
    public interface BeanCopyUtilCallBack<S, T> {
        /**
         * 定义默认回调方法
         *
         * @param s 源对象
         * @param t 目标对象
         */
        void callBack(S s, T t);
    }

}
