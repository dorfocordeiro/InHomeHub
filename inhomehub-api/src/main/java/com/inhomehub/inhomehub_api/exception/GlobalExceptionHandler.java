//package com.inhomehub.inhomehub_api.exception;
//
//import com.inhomehub.inhomehub_api.dto.response.ErrorResponseDTO;
//import com.inhomehub.inhomehub_api.exception.UserException;
//import org.springframework.dao.DataIntegrityViolationException;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//@RestControllerAdvice
//public class GlobalExceptionHandler {
//
//    @ExceptionHandler(UserException.class)
//    public ResponseEntity<ErrorResponseDTO> handleUserException(UserException ex) {
//        return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                .body(new ErrorResponseDTO(ex.getMessage()));
//    }
//
//    @ExceptionHandler(IllegalArgumentException.class)
//    public ResponseEntity<ErrorResponseDTO> handleIllegalArgument(IllegalArgumentException ex) {
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//                .body(new ErrorResponseDTO(ex.getMessage()));
//    }
//
//    @ExceptionHandler(ExemploException.class)
//    public ResponseEntity<ErrorResponseDTO> handleExemploException(ExemploException ex) {
//        ErrorResponseDTO response = new ErrorResponseDTO(ex.getMessage());
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
//    }
//
//    @ExceptionHandler(DataIntegrityViolationException.class)
//    public ResponseEntity<ErrorResponseDTO> handleDataIntegrityViolation(DataIntegrityViolationException ex) {
//        return ResponseEntity.status(HttpStatus.CONFLICT)
//                .body(new ErrorResponseDTO("Violação de integridade referencial ou restrição de banco de dados."));
//    }
//}