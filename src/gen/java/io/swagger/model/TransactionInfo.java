package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * Data structure representing the fields and current FSM state
 **/

/**
 * Data structure representing the fields and current FSM state
 */
@ApiModel(description = "Data structure representing the fields and current FSM state")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-11-07T08:05:00.767Z")
public class TransactionInfo   {
  private String state = null;

  private Integer id = null;

  private String amount = null;

  private String from = null;

  private String to = null;

  public TransactionInfo state(String state) {
    this.state = state;
    return this;
  }

   /**
   * Get state
   * @return state
  **/
  @ApiModelProperty(value = "")
  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public TransactionInfo id(Integer id) {
    this.id = id;
    return this;
  }

   /**
   * Unique identifier for the instance of the specification
   * @return id
  **/
  @ApiModelProperty(value = "Unique identifier for the instance of the specification")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public TransactionInfo amount(String amount) {
    this.amount = amount;
    return this;
  }

   /**
   * Get amount
   * @return amount
  **/
  @ApiModelProperty(value = "")
  public String getAmount() {
    return amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }

  public TransactionInfo from(String from) {
    this.from = from;
    return this;
  }

   /**
   * Get from
   * @return from
  **/
  @ApiModelProperty(value = "")
  public String getFrom() {
    return from;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  public TransactionInfo to(String to) {
    this.to = to;
    return this;
  }

   /**
   * Get to
   * @return to
  **/
  @ApiModelProperty(value = "")
  public String getTo() {
    return to;
  }

  public void setTo(String to) {
    this.to = to;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TransactionInfo transactionInfo = (TransactionInfo) o;
    return Objects.equals(this.state, transactionInfo.state) &&
        Objects.equals(this.id, transactionInfo.id) &&
        Objects.equals(this.amount, transactionInfo.amount) &&
        Objects.equals(this.from, transactionInfo.from) &&
        Objects.equals(this.to, transactionInfo.to);
  }

  @Override
  public int hashCode() {
    return Objects.hash(state, id, amount, from, to);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TransactionInfo {\n");
    
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    from: ").append(toIndentedString(from)).append("\n");
    sb.append("    to: ").append(toIndentedString(to)).append("\n");
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

