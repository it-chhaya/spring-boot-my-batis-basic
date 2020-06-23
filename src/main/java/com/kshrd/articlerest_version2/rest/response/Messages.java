package com.kshrd.articlerest_version2.rest.response;

public class Messages {

    public enum Success {

        INSERT_SUCCESS("Record has been inserted successfully");

        private String message;

        Success(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    public enum Error {

        INSERT_FAILURE("Record cannot insert");

        private String message;

        Error(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

    }
}
