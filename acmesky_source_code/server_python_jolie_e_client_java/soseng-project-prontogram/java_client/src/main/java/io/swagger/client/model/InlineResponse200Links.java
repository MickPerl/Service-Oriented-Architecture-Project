/*
 * prontogramAPI
 * È l'API Restful offerta dall'applicazione di messaggistica *Prontogram* che vi racchiude la capability di inoltrare i messaggi circa le offerte inviate da ACMESky ai clienti interessati.
 *
 * OpenAPI spec version: 1.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package io.swagger.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
/**
 * Link a livello dei blocchi di messaggi
 */
@Schema(description = "Link a livello dei blocchi di messaggi")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-10-06T11:54:26.074+02:00[Europe/Rome]")
public class InlineResponse200Links {
  @SerializedName("self")
  private String self = null;

  @SerializedName("next")
  private String next = null;

  @SerializedName("prev")
  private String prev = null;

  public InlineResponse200Links self(String self) {
    this.self = self;
    return this;
  }

   /**
   * Link al blocco corrente
   * @return self
  **/
  @Schema(description = "Link al blocco corrente")
  public String getSelf() {
    return self;
  }

  public void setSelf(String self) {
    this.self = self;
  }

  public InlineResponse200Links next(String next) {
    this.next = next;
    return this;
  }

   /**
   * Link al blocco successivo in senso temporale
   * @return next
  **/
  @Schema(description = "Link al blocco successivo in senso temporale")
  public String getNext() {
    return next;
  }

  public void setNext(String next) {
    this.next = next;
  }

  public InlineResponse200Links prev(String prev) {
    this.prev = prev;
    return this;
  }

   /**
   * Link al blocco precedente in senso temporale
   * @return prev
  **/
  @Schema(description = "Link al blocco precedente in senso temporale")
  public String getPrev() {
    return prev;
  }

  public void setPrev(String prev) {
    this.prev = prev;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineResponse200Links inlineResponse200Links = (InlineResponse200Links) o;
    return Objects.equals(this.self, inlineResponse200Links.self) &&
        Objects.equals(this.next, inlineResponse200Links.next) &&
        Objects.equals(this.prev, inlineResponse200Links.prev);
  }

  @Override
  public int hashCode() {
    return Objects.hash(self, next, prev);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse200Links {\n");
    
    sb.append("    self: ").append(toIndentedString(self)).append("\n");
    sb.append("    next: ").append(toIndentedString(next)).append("\n");
    sb.append("    prev: ").append(toIndentedString(prev)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
