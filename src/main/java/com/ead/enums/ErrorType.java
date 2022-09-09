package com.ead.enums;

public enum ErrorType {

    METHOD_ARG_NOT_VALID_ERROR("Argumento ou valor(es) inválido(s)."),
    COURSE_NOT_FOUND("Curso não encontrado."),
    MODULE_NOT_FOUND("Modulo do curso não encontrado."),
    LESSON_NOT_FOUND("Lição do modulo não encontrado."),
    COURSE_NAME_EXISTS_BY_NAME_ERROR("Nome do curso já cadastrado."),
    SUBSCRIPTION_COURSE_AND_USER_EXISTS_ERROR("Inscrição de usuário nesse curso ja existe.");

    private String error;

    ErrorType(String error) {
        this.error = error;
    }

    public String getMessage() {
        return this.error;
    }
}
