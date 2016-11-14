package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * Data object encapsulating the transition parameters for the fail transition
 **/

/**
 * Data object encapsulating the transition parameters for the fail transition
 */
@ApiModel(description = "Data object encapsulating the transition parameters for the fail transition")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-11-07T08:05:00.767Z")
public class FailBody   {
  private Object fail = null;

  public FailBody fail(Object fail) {
    this.fail = fail;
    return this;
  }

   /**
   * Get fail
   * @return fail
  **/
  @ApiModelProperty(required = true, value = "")
  public Object getFail() {
    return fail;
  }

  public void setFail(Object fail) {
    this.fail = fail;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FailBody failBody = (FailBody) o;
    return Objects.equals(this.fail, failBody.fail);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fail);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FailBody {\n");
    
    sb.append("    fail: ").append(toIndentedString(fail)).append("\n");
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

