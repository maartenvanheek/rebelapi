package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * Data object encapsulating the transition parameters for the unblock transition
 **/

/**
 * Data object encapsulating the transition parameters for the unblock transition
 */
@ApiModel(description = "Data object encapsulating the transition parameters for the unblock transition")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-11-07T08:05:00.767Z")
public class UnblockBody   {
  private Object unblock = null;

  public UnblockBody unblock(Object unblock) {
    this.unblock = unblock;
    return this;
  }

   /**
   * Get unblock
   * @return unblock
  **/
  @ApiModelProperty(required = true, value = "")
  public Object getUnblock() {
    return unblock;
  }

  public void setUnblock(Object unblock) {
    this.unblock = unblock;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UnblockBody unblockBody = (UnblockBody) o;
    return Objects.equals(this.unblock, unblockBody.unblock);
  }

  @Override
  public int hashCode() {
    return Objects.hash(unblock);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UnblockBody {\n");
    
    sb.append("    unblock: ").append(toIndentedString(unblock)).append("\n");
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

