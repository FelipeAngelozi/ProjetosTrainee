package br.com.sgsistemas.trainee.sgERPDB.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table( name= "UF")
public class UF {

   @Id
   private String sigla;
   private String descricao;

   public String getSigla() {
      return sigla;
   }

   public void setSigla(String sigla) {
      this.sigla = sigla;
   }

   public String getDescricao() {
      return descricao;
   }

   public void setDescricao(String descricao) {
      this.descricao = descricao;
   }

   @Override
   public String toString() {
      return "UF{" +
              "sigla='" + sigla + '\'' +
              ", descricao='" + descricao + '\'' +
              '}';
   }
}
