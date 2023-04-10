package br.com.delivery.handlers.exceptionHandlers;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@NoArgsConstructor
@AllArgsConstructor
public class errorModel {

        private String campo;
        private Long codigo;
        private String titulo;
        private Long status;
        private Long timestamp;
        private String mensagemDesenvolvedor;


        public errorModel(String titulo, Long codigo, Long status, Long timestamp, String mensagemDesenvolvedor) {
            this.codigo = codigo;
            this.titulo = titulo;
            this.status = status;
            this.timestamp = timestamp;
            this.mensagemDesenvolvedor = mensagemDesenvolvedor;
        }

        public errorModel(String titulo, Long codigo, Long status, Long timestamp, String mensagemDesenvolvedor, String campo) {
            this.codigo = codigo;
            this.titulo = titulo;
            this.status = status;
            this.timestamp = timestamp;
            this.mensagemDesenvolvedor = mensagemDesenvolvedor;
            this.campo =  campo;
        }


        public String getCampo() {
            return campo;
        }

        public void setCampo(String campo) {
            this.campo = campo;
        }

        public Long getCodigo() {
            return codigo;
        }

        public void setCodigo(Long codigo) {
            this.codigo = codigo;
        }

        public String getTitulo() {
            return titulo;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        public Long getStatus() {
            return status;
        }

        public void setStatus(Long status) {
            this.status = status;
        }

        public Long getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(Long timestamp) {
            this.timestamp = timestamp;
        }

        public String getMensagemDesenvolvedor() {
            return mensagemDesenvolvedor;
        }

        public void setMensagemDesenvolvedor(String mensagemDesenvolvedor) {
            this.mensagemDesenvolvedor = mensagemDesenvolvedor;
        }
}
