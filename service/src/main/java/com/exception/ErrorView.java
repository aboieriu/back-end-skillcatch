package com.exception;

import org.codehaus.jackson.annotate.JsonCreator;

import java.util.Objects;

/**
 * Created by aboieriu on 6/29/16.
 */
public class ErrorView {

    /**
     * Represents the specific error code for this error case.
     * Usually business specific details error code.
     * Can and it's recommended to be used as i18n error message key.
     */
    private final String code;
    /**
     * Nice human readable error message for debug purposes.
     * Saves time for not looking in error-codes dictionary every time.
     */
    private final String message;

    @JsonCreator
    public ErrorView(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ErrorView(String code) {
        this.code = code;
        this.message = null;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ErrorView errorView = (ErrorView) o;
        return Objects.equals(code, errorView.code) &&
                Objects.equals(message, errorView.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, message);
    }


}
