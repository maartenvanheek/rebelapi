package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.OpenAccountBodyOpenAccount;



/**
 * Data object encapsulating the transition parameters for the openAccount transition
 **/

/**
 * Data object encapsulating the transition parameters for the openAccount transition
 */
@ApiModel(description = "Data object encapsulating the transition parameters for the openAccount transition")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-11-07T08:05:00.767Z")
public class OpenAccountBody   {
  private OpenAccountBodyOpenAccount openAccount = null;

  public OpenAccountBody openAccount(OpenAccountBodyOpenAccount openAccount) {
    this.openAccount = openAccount;
    return this;
  }

   /**
   * Get openAccount
   * @return openAccount
  **/
  @ApiModelProperty(value = "")
  public OpenAccountBodyOpenAccount getOpenAccount() {
    return openAccount;
  }

  public void setOpenAccount(OpenAccountBodyOpenAccount openAccount) {
    this.openAccount = openAccount;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OpenAccountBody openAccountBody = (OpenAccountBody) o;
    return Objects.equals(this.openAccount, openAccountBody.openAccount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(openAccount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OpenAccountBody {\n");
    
    sb.append("    openAccount: ").append(toIndentedString(openAccount)).append("\n");
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

