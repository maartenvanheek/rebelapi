package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.WithdrawBodyWithdraw;



/**
 * Data object encapsulating the transition parameters for the withdraw transition
 **/

/**
 * Data object encapsulating the transition parameters for the withdraw transition
 */
@ApiModel(description = "Data object encapsulating the transition parameters for the withdraw transition")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-11-07T08:05:00.767Z")
public class WithdrawBody   {
  private WithdrawBodyWithdraw withdraw = null;

  public WithdrawBody withdraw(WithdrawBodyWithdraw withdraw) {
    this.withdraw = withdraw;
    return this;
  }

   /**
   * Get withdraw
   * @return withdraw
  **/
  @ApiModelProperty(value = "")
  public WithdrawBodyWithdraw getWithdraw() {
    return withdraw;
  }

  public void setWithdraw(WithdrawBodyWithdraw withdraw) {
    this.withdraw = withdraw;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WithdrawBody withdrawBody = (WithdrawBody) o;
    return Objects.equals(this.withdraw, withdrawBody.withdraw);
  }

  @Override
  public int hashCode() {
    return Objects.hash(withdraw);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WithdrawBody {\n");
    
    sb.append("    withdraw: ").append(toIndentedString(withdraw)).append("\n");
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

