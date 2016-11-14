package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.StartBodyStart;



/**
 * Data object encapsulating the transition parameters for the start transition
 **/

/**
 * Data object encapsulating the transition parameters for the start transition
 */
@ApiModel(description = "Data object encapsulating the transition parameters for the start transition")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-11-07T08:05:00.767Z")
public class StartBody   {
  private StartBodyStart start = null;

  public StartBody start(StartBodyStart start) {
    this.start = start;
    return this;
  }

   /**
   * Get start
   * @return start
  **/
  @ApiModelProperty(value = "")
  public StartBodyStart getStart() {
    return start;
  }

  public void setStart(StartBodyStart start) {
    this.start = start;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StartBody startBody = (StartBody) o;
    return Objects.equals(this.start, startBody.start);
  }

  @Override
  public int hashCode() {
    return Objects.hash(start);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StartBody {\n");
    
    sb.append("    start: ").append(toIndentedString(start)).append("\n");
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

