package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * Data object encapsulating the transition parameters for the close transition
 **/

/**
 * Data object encapsulating the transition parameters for the close transition
 */
@ApiModel(description = "Data object encapsulating the transition parameters for the close transition")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-11-07T08:05:00.767Z")
public class CloseBody   {
  private Object close = null;

  public CloseBody close(Object close) {
    this.close = close;
    return this;
  }

   /**
   * Get close
   * @return close
  **/
  @ApiModelProperty(required = true, value = "")
  public Object getClose() {
    return close;
  }

  public void setClose(Object close) {
    this.close = close;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CloseBody closeBody = (CloseBody) o;
    return Objects.equals(this.close, closeBody.close);
  }

  @Override
  public int hashCode() {
    return Objects.hash(close);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CloseBody {\n");
    
    sb.append("    close: ").append(toIndentedString(close)).append("\n");
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

