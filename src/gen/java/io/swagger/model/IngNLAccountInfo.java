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
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-11-14T12:30:06.878Z")
public class IngNLAccountInfo   {
  private String state = null;

  private String accountNumber = null;

  private String balance = null;

  public IngNLAccountInfo state(String state) {
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

  public IngNLAccountInfo accountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
    return this;
  }

   /**
   * Unique identifier for the instance of the specification
   * @return accountNumber
  **/
  @ApiModelProperty(value = "Unique identifier for the instance of the specification")
  public String getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  public IngNLAccountInfo balance(String balance) {
    this.balance = balance;
    return this;
  }

   /**
   * Get balance
   * @return balance
  **/
  @ApiModelProperty(value = "")
  public String getBalance() {
    return balance;
  }

  public void setBalance(String balance) {
    this.balance = balance;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IngNLAccountInfo ingNLAccountInfo = (IngNLAccountInfo) o;
    return Objects.equals(this.state, ingNLAccountInfo.state) &&
        Objects.equals(this.accountNumber, ingNLAccountInfo.accountNumber) &&
        Objects.equals(this.balance, ingNLAccountInfo.balance);
  }

  @Override
  public int hashCode() {
    return Objects.hash(state, accountNumber, balance);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IngNLAccountInfo {\n");
    
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    accountNumber: ").append(toIndentedString(accountNumber)).append("\n");
    sb.append("    balance: ").append(toIndentedString(balance)).append("\n");
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

