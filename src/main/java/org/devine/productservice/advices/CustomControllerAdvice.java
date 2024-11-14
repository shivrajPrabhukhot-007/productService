package org.devine.productservice.advices;

import org.apache.coyote.Response;
import org.devine.productservice.dtos.ErrorDTO;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class CustomControllerAdvice {

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorDTO> handleNPException(){
        ErrorDTO edto = new ErrorDTO();
        edto.setMessage("Null Pointer Exception");
        ResponseEntity<ErrorDTO> responseEntity = new ResponseEntity<>(edto, HttpStatusCode.valueOf(501));
        return responseEntity;
    }
}
