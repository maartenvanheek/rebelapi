package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.WithdrawBodyWithdraw;



/**
 * Data object encapsulating the transition parameters for the deposit transition
 **/

/**
 * Data object encapsulating the transition parameters for the deposit transition
 */
@ApiModel(description = "Data object encapsulating the transition parameters for the deposit transition")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-11-14T12:30:06.878Z")
public class DepositBody   {
  private WithdrawBodyWithdraw deposit = null;

  public DepositBody deposit(WithdrawBodyWithdraw deposit) {
    this.deposit = deposit;
    return this;
  }

   /**
   * Get deposit
   * @return deposit
  **/
  @ApiModelProperty(value = "")
  public WithdrawBodyWithdraw getDeposit() {
    return deposit;
  }

  public void setDeposit(WithdrawBodyWithdraw deposit) {
    this.deposit = deposit;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DepositBody depositBody = (DepositBody) o;
    return Objects.equals(this.deposit, depositBody.deposit);
  }

  @Override
  public int hashCode() {
    return Objects.hash(deposit);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DepositBody {\n");
    
    sb.append("    deposit: ").append(toIndentedString(deposit)).append("\n");
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

