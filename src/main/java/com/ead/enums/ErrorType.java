package com.ead.enums;

public enum ErrorType {

    METHOD_ARG_NOT_VALID_ERROR("Argumento ou valor(es) inválido(s)."),
    UNEXPECTED_ERROR("Um erro inesperado ocorreu, por favor, verifique os logs."),
    SERVICE_UNAVAILABLE("O serviço da api de auth user está indisponível no momento, tente novamente mais tarde."),
    COURSE_NOT_FOUND("Curso não encontrado."),
    MODULE_NOT_FOUND("Modulo do curso não encontrado."),
    LESSON_NOT_FOUND("Lição do modulo não encontrado."),
    COURSE_NAME_EXISTS_BY_NAME_ERROR("Nome do curso já cadastrado."),
    USER_NOT_FOUND("Usuário não encontrado."),
    USER_BLOCKED("Usuário esta bloqueado."),
    USER_INSTRUCTOROR_ADMIN_NOT_FOUND("Instrutor OU Admin não encontrado."),
    SUBSCRIPTION_COURSE_AND_USER_EXISTS_ERROR("Inscrição do usuário ja existe nesse curso."),
    USER_MUST_BE_INSTRUCTOR_OR_ADMIN_ERROR(" Usuário precisa ser do tipo INSTRUTOR ou ADMIN.");

    private String error;

    ErrorType(String error) {
        this.error = error;
    }

    public String getMessage() {
        return this.error;
    }
}
