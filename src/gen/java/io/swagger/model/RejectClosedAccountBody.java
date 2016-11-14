package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * Data object encapsulating the transition parameters for the rejectClosedAccount transition
 **/

/**
 * Data object encapsulating the transition parameters for the rejectClosedAccount transition
 */
@ApiModel(description = "Data object encapsulating the transition parameters for the rejectClosedAccount transition")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-11-14T12:30:06.878Z")
public class RejectClosedAccountBody   {
  private Object rejectClosedAccount = null;

  public RejectClosedAccountBody rejectClosedAccount(Object rejectClosedAccount) {
    this.rejectClosedAccount = rejectClosedAccount;
    return this;
  }

   /**
   * Get rejectClosedAccount
   * @return rejectClosedAccount
  **/
  @ApiModelProperty(required = true, value = "")
  public Object getRejectClosedAccount() {
    return rejectClosedAccount;
  }

  public void setRejectClosedAccount(Object rejectClosedAccount) {
    this.rejectClosedAccount = rejectClosedAccount;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RejectClosedAccountBody rejectClosedAccountBody = (RejectClosedAccountBody) o;
    return Objects.equals(this.rejectClosedAccount, rejectClosedAccountBody.rejectClosedAccount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(rejectClosedAccount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RejectClosedAccountBody {\n");
    
    sb.append("    rejectClosedAccount: ").append(toIndentedString(rejectClosedAccount)).append("\n");
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

