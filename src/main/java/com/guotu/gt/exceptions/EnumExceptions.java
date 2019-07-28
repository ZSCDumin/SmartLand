package com.guotu.gt.exceptions;

/**
 * 所有异常类型
 * <p>
 * huxudong
 */
public enum EnumExceptions {
    UNKOWN_ERROR(-1, "未知错误"),
    SQL_ERROR(-1, "开发人员很可能使用了错误的SQL语句"),
    TYPE_MISMATCH_ERROR(-1, "错误的数据类型插入数据库"),
    NULL_POINTER_ERROR(-1, "空指针异常,运行时操作了Null数据"),
    //以上都是错误,错误code为-1
    SUCCESS(0, "操作成功"),
    REQUEST_METHOD(1, "请求方法不匹配"),
    ARGU_MISMATCH_EXCEPTION(2, "参数类型不匹配错误, 请检查"),
    FAILED_CONNECTED_DATABASE(3, "数据库资源访问失败"),
    VIOLATION_CONSTRAINED_OPERATION(4, "禁止操作,违反数据库约束"),//外键,非空,唯一键等
    NOT_NULL_COLUMN_CANT_BE_NULL(4, "存在非空字段设置为空现象"),
    ADD_FAILED_FOREIGN_KEY_NOT_EXIST(4, "新增失败,外键不存在"),
    FAILED_FOREIGN_KEY_CONSTRAINT(4, "操作失败,存在外键约束"),
    //以上是全局捕捉异常,请勿修改

    ADD_FAILED_NAME_DUPLICATED(5, "新增失败,名称重复"),
    DELETE_FAILED_NOT_EXISTS(6, "删除失败,不存在"),
    UPDATE_FAILED_NOT_EXISTS(7, "更新失败,不存在"),
    FIND_FAILED_NOT_EXISTS(8, "查找失败,不存在"),
    ADD_FAILED_USER_NOT_EXIST(9, "新增失败,用户不存在"),
    ADD_FAILED_BATCH_NUMBER_NOT_EXIST(10, "新增失败,批号不存在"),
    ADD_FAILED_BATCH_NUMBER_DUPLICATE(11, "新增或更新失败,批号重复"),
    ADD_FAILED_NAME_NULL(12, "新增失败,名称为空"),
    ADD_FAILED_OPERATORS_NULL(13, "新增失败,操作人列表不能为空"),
    ADD_FAILED_OPERATORS_NOT_EXIST(14, "新增失败,不存在操作人"),
    ADD_FAILED_DATA_NOT_EXIST(15, "新增失败,数据为空"),
    ADD_FAILED_BASE_TABLE_NULL(16, "新增失败,找不到基础数据,(工序,生产线,受检物料)"),
    ADD_FAILED_SAMPLER_NOT_EXIST(17, "新增失败,取样人不存在"),
    ADD_FAILED_TESTER_NOT_EXIST(18, "新增失败,测试人不存在"),
    ADD_FAILED_FREQUENCY_NULL(19, "新增失败,检测频率为空"),
    UPDATE_FAILED_CONTENT_NULL(20, "更新内容存在空值"),
    ADD_FAILED_BATCH_NUMBER_CONFLICT(21, "新增失败,批号为空或重复"),
    ADD_FAILED_STATUS_NULL(22, "新增失败,提交状态为空"),
    ADD_FAILED_DELIVERING_DATA_NULL(23, "新增失败,样品送检记录为空"),
    ADD_FAILED_DELIVERING_DATE_NULL(24, "新增失败,送检日期空"),
    ADD_FAILED_REPO_DUPLICATE(25, "新增失败,存在名称、类型、厂商一致的物料"),
    APPLY_FAILED_OUT_OF_RANGE(26, "出库申请失败,数量或者重量超出库存范围"),
    DELETE_FAILED_SUM_NOT_MATCH(27, "删除失败,删除的数据数量与数据库存在的数量不匹配"),
    ADD_FAILED_NEGATIVE_FORBIDDEN(28, "新增失败,必须输入正整数"),
    ADD_FAILED_APPLY_TYPE_NOT_EXIST(29, "申请失败,申请类型不存在");

    /**
     * 编码
     */
    private Integer code;
    /**
     * 信息
     */
    private String message;

    /**
     * 构造函数
     *
     * @param code
     * @param message
     */
    EnumExceptions(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
