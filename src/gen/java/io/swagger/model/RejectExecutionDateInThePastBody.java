package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * Data object encapsulating the transition parameters for the rejectExecutionDateInThePast transition
 **/

/**
 * Data object encapsulating the transition parameters for the rejectExecutionDateInThePast transition
 */
@ApiModel(description = "Data object encapsulating the transition parameters for the rejectExecutionDateInThePast transition")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-11-14T12:30:06.878Z")
public class RejectExecutionDateInThePastBody   {
  private Object rejectExecutionDateInThePast = null;

  public RejectExecutionDateInThePastBody rejectExecutionDateInThePast(Object rejectExecutionDateInThePast) {
    this.rejectExecutionDateInThePast = rejectExecutionDateInThePast;
    return this;
  }

   /**
   * Get rejectExecutionDateInThePast
   * @return rejectExecutionDateInThePast
  **/
  @ApiModelProperty(required = true, value = "")
  public Object getRejectExecutionDateInThePast() {
    return rejectExecutionDateInThePast;
  }

  public void setRejectExecutionDateInThePast(Object rejectExecutionDateInThePast) {
    this.rejectExecutionDateInThePast = rejectExecutionDateInThePast;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RejectExecutionDateInThePastBody rejectExecutionDateInThePastBody = (RejectExecutionDateInThePastBody) o;
    return Objects.equals(this.rejectExecutionDateInThePast, rejectExecutionDateInThePastBody.rejectExecutionDateInThePast);
  }

  @Override
  public int hashCode() {
    return Objects.hash(rejectExecutionDateInThePast);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RejectExecutionDateInThePastBody {\n");
    
    sb.append("    rejectExecutionDateInThePast: ").append(toIndentedString(rejectExecutionDateInThePast)).append("\n");
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

