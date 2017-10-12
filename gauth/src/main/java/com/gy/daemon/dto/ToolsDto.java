package com.gy.daemon.dto;

/**
 * Created by yang_gao on 2017/10/12.
 */
public class ToolsDto {


    public static class BCryptDto {
        String oriText;
        String cipher;
        String oriCipher;
        String text;

        public String getOriText() {
            return oriText;
        }

        public void setOriText(String oriText) {
            this.oriText = oriText;
        }

        public String getCipher() {
            return cipher;
        }

        public void setCipher(String cipher) {
            this.cipher = cipher;
        }

        public String getOriCipher() {
            return oriCipher;
        }

        public void setOriCipher(String oriCipher) {
            this.oriCipher = oriCipher;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            sb.append("\"oriText\":\"")
                    .append(oriText).append('\"');
            sb.append(",\"cipher\":\"")
                    .append(cipher).append('\"');
            sb.append(",\"oriCipher\":\"")
                    .append(oriCipher).append('\"');
            sb.append(",\"text\":\"")
                    .append(text).append('\"');
            sb.append('}');
            return sb.toString();
        }
    }
}

