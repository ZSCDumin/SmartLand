package com.guotu.gt.exceptions;

import com.guotu.gt.dto.Result;
import com.guotu.gt.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.*;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * @Author:huxudong 这个用来捕捉异常, 捕捉统一返回类里面的异常
 */
@ControllerAdvice
public class HandleExceptions {

    private final static Logger logger = LoggerFactory.getLogger(HandleExceptions.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result<Object> handle(Exception e) {
        /**
         * 自定义异常
         */
        if (e instanceof JcExceptions) {
            JcExceptions jcException = (JcExceptions) e;
            return ResultUtil.error(jcException);
        }
        /**
         * 空指针异常
         */
        else if (e instanceof NullPointerException) {
            logger.error("【空指针异常】错误发生在{},\n原因为{}", e.getStackTrace(),e.getMessage());
            ByteArrayOutputStream stack = new ByteArrayOutputStream();
            e.printStackTrace(new PrintStream(stack));
            String stackTrace = stack.toString();
            return ResultUtil.error(String.format("空指针异常,错误发生在{%s},原因{%s}", stackTrace,e.getMessage()));
        }
        /**
         * 参数类型不匹配异常
         */
        else if (e instanceof MethodArgumentTypeMismatchException) {
            logger.error("【参数类型不匹配异常】 {}", e.getMessage());
            return ResultUtil.error(new JcExceptions(EnumExceptions.ARGU_MISMATCH_EXCEPTION));

        } else if (e instanceof IllegalArgumentException) {
            logger.error("【非法参数异常】 {}", e.getMessage());
            return ResultUtil.error(e.getMessage());
        }
        /**
         * 访问数据库的异常,Mybatis都在这个异常处理类下
         */
        else if (e instanceof DataAccessException) {
            logger.error("【访问数据库异常】 {}", e.getMessage());

            if (e instanceof DataAccessResourceFailureException) {
                logger.error("[无法访问数据库资源异常]");
                return ResultUtil.error(new JcExceptions(EnumExceptions.FAILED_CONNECTED_DATABASE));
            } else if (e instanceof DataIntegrityViolationException) {
                logger.error("[违反数据库约束异常]");
                if (e.getMessage().contains("cannot be null")) {
                    return ResultUtil.error(new JcExceptions(EnumExceptions.NOT_NULL_COLUMN_CANT_BE_NULL));
                } else if (e.getMessage().contains("foreign key constraint"))
                    return ResultUtil.error(new JcExceptions(EnumExceptions.FAILED_FOREIGN_KEY_CONSTRAINT));
                else
                    return ResultUtil.error(new JcExceptions(EnumExceptions.VIOLATION_CONSTRAINED_OPERATION));
            } else if (e instanceof InvalidDataAccessResourceUsageException) {
                logger.error("[错误使用数据访问资源，例如用错误的SQL语法访问关系型数据库]");
                return ResultUtil.error("[使用了错误的SQL语句]\n" + e.getMessage().substring(e.getMessage().indexOf("exist in file")));
            } else if (e instanceof TypeMismatchDataAccessException) {
                logger.error("[java类型和数据库字段类型不匹配]");
                return ResultUtil.error(new JcExceptions(EnumExceptions.TYPE_MISMATCH_ERROR));
            } else EnumExceptions.UNKOWN_ERROR.setMessage(e.getMessage());
            logger.error("[未知异常]");
            return ResultUtil.error(new JcExceptions(EnumExceptions.UNKOWN_ERROR));
        }

        /**
         * 根据消息字段捕捉的异常
         */
        else {
            logger.error("【系统异常】 {}", e.getMessage());
            //方法不匹配
            if (e.getMessage().contains("Request method")) {
                return ResultUtil.error(new JcExceptions(EnumExceptions.REQUEST_METHOD));
            } else {
                // 开发阶段不显示未知异常
                logger.error("[未知异常]");
                EnumExceptions.UNKOWN_ERROR.setMessage(e.getMessage());
                return ResultUtil.error(new JcExceptions(EnumExceptions.UNKOWN_ERROR));
            }
        }
    }

}
