package com.cz.api.exception;

import com.cz.model.code.CodeModel;
import com.cz.model.message.MessageModel;
import com.cz.model.result.ResultModel;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
* 全局异常处理
* */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /*
    * 上传文件大小超出限制处理
    * */
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResultModel uploadException(MaxUploadSizeExceededException e, HttpServletResponse resp)
            throws IOException {
        var result = new ResultModel<String>();
        result.setCode(CodeModel.FILESIZEEXCEEDEDLIMIT);
        result.setMsg(MessageModel.FILESIZEEXCEEDEDLIMIT);
        result.setData("");
        return result;
    }

}
