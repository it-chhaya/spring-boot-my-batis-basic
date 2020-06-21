package com.kshrd.articlerest_version2.rest.response;

public class  Messages {

    public enum Error {

        NO_RECORD_FOUND("Record with provided ID is not found");

        private String message;

        Error(String message) {
            this.message = message;
        }

        public String value() {
            return message;
        }
    }

    public enum Success {

        RECORD_FOUND("Record has been found successfully");

        private String message;

        Success(String message) {
            this.message = message;
        }

        public String value() {
            return message;
        }

    }

}
